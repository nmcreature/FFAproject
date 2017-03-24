package org.ffa.framework;

import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

import static org.ffa.framework.BrowserFactory.getDriver;

public class BrowserActions {

    private static ArrayList<String> tabs;

    public static void open(String url) {
        try{
            getDriver().get(url);

        }catch(UnhandledAlertException e){
            try{
                getDriver().switchTo().alert().accept();
            }
            catch(NoAlertPresentException a){

            }
            getDriver().get(url);
        }
    }

    public static String getNewWindowURL(){
        Wait.forNumberOfTabsToBe(2);
        String originHandle = getDriver().getWindowHandle();
        String targetHandle = getNextWindowHandle(originHandle);
        getDriver().switchTo().window(targetHandle);
        Wait.forURL();
        String url = getDriver().getCurrentUrl();
        getDriver().close();
        getDriver().switchTo().window(originHandle);
        return url;
    }

    public static String getNextWindowHandle(String originHandle) {
        Set handles = getDriver().getWindowHandles();
        handles.remove(originHandle);
        return (String) handles.iterator().next();
    }

    public static void refreshPage(){
        getDriver().navigate().refresh();
    }

    public static void clearCookies() {
        try{
            getDriver().manage().deleteAllCookies();
        }catch (UnhandledAlertException e){
            try{
                getDriver().switchTo().alert().accept();
            }
            catch(NoAlertPresentException a){

            }
            getDriver().manage().deleteAllCookies();
        }
//        getDriver().navigate().refresh();
    }

    public static int getWindowsCount(){
        return getDriver().getWindowHandles().size();
    }

    public static void switchToFrame(String frame){
        getDriver().switchTo().frame(frame);
    }

    public static void switchToDefaultContent(){
        getDriver().switchTo().defaultContent();
    }

    public static void closeTab(){
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));
    }

    public static void openNewTab(){
        ((JavascriptExecutor) getDriver()).executeScript("window.open('your url','_blank');");
        Wait.forNumberOfTabsToBe(2);
        tabs = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }

    public static void navigateBack() {
        String curURL = getDriver().getCurrentUrl();
        getDriver().navigate().back();
        new WebDriverWait(getDriver(), 3).until((Predicate<WebDriver>) driver -> getDriver().getCurrentUrl() != curURL);
    }

    public static void acceptAlert() {
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.alertIsPresent()).accept();
    }
}
