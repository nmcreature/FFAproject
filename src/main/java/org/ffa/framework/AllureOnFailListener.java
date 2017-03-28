package org.ffa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import static org.ffa.framework.BrowserFactory.getDriver;
import static org.ffa.framework.Utilities.getLogger;

public class AllureOnFailListener implements ISuiteListener, IResultListener {
    // Button refreshButton = (Button) getDriver().findElement(By.xpath(" .//div[@class='commonError' and  @style='']//div[@class='timeout-message-refresh-section']//div"));

    AllureListener allureListener = new AllureListener();

    @Override
    public void onStart(ISuite arg0) {
        allureListener.onStart(arg0);
        getLogger().info(arg0.getName() + " is running");
    }

    @Override
    public void onFinish(ISuite arg0) {
        allureListener.onFinish(arg0);
    }

    @Override
    public void onTestStart(ITestResult result) {
        allureListener.onTestStart(result);
        getLogger().info("=== ATTENTION: '" + result.getName() + "' TEST HAS STARTED ===");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getLogger().info("=== SUCCESS: '" + result.getName() + "' TEST HAS PASSED ===");
        allureListener.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (isScreenshotRequired(result)) {
            Screenshoter.takeScreenshot(result.getName());
        }

        getLogger().error("=== FAILURE: '" + result.getName() + "' TEST HAS FAILED ===", result.getThrowable());
        allureListener.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getLogger().info("=== WARNING: '" + result.getName() + "' TEST HAS SKIPPED ===");
        allureListener.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        allureListener.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onStart(ITestContext context) {
        allureListener.onStart(context);
        getLogger().info("=== " + context.getName() + " TEST SET HAS STARTED ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        getLogger().info("=== " + context.getName() + " TEST SET IS FINISHED ===");
        allureListener.onFinish(context);
    }

    @Override
    public void onConfigurationSuccess(ITestResult itr) {
        allureListener.onConfigurationSuccess(itr);
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
        if (isScreenshotRequired(itr)) {
            Screenshoter.takeScreenshot(itr.getName());
        }
        getLogger().error("=== FAILURE: '" + itr.getName() + "' TEST CONFIGURATION HAS FAILED ===", itr.getThrowable());
        allureListener.onConfigurationFailure(itr);
    }

    @Override
    public void onConfigurationSkip(ITestResult itr) {
        allureListener.onConfigurationSkip(itr);
    }


    private static boolean softAssertFail(ITestResult result) {
        String message = result.getThrowable().getMessage();
        if (message != null) {
            return message.contains("The following asserts failed:");
        } else
            return false;

    }

    public static boolean isScreenshotRequired(ITestResult result) {
        return (getDriver() != null) && (!softAssertFail(result));
    }

    private void systemErrorHandling(ITestResult result) {
        if (!(result.getThrowable() instanceof AssertionError)){
            boolean isUnexpectedLogout = false;
            boolean isSystemError = false;
            try{
                isUnexpectedLogout = getDriver().findElement(By.xpath(".//div[@class='login-content-wrapper']")).isDisplayed();
            }
            catch (NoSuchElementException e) {}
            try{
                isSystemError = getDriver().findElement(By.xpath(".//div[@class='commonError' and not(contains(@style,'display: none'))]//div[@class='timeout-message-refresh-section']//div")).isDisplayed();
            }
            catch (NoSuchElementException e) {}
            if(isSystemError || isUnexpectedLogout){
                AssertionError assertError = new AssertionError("SYSTEM ERROR FAILURE");
                result.setThrowable(assertError);
            }
        }
    }
}