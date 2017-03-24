package org.ffa.framework;

import org.ffa.webelements.Element;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.ffa.framework.BrowserFactory.getDriver;

public class Wait {

    public static void untilPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='applicationHost']/div[@data-active-view='true']"))); // this path exists even on login page, so this WAIT will not fail if you did not login
            wait.until(WaitingConditions.jqueryIsLoaded());
        }catch (TimeoutException e) {
            //
        }
    }

    public static void untilContextIsChanged(WebElement element) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean forAttributeIsLoaded(WebElement element, String attribute) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MICROSECONDS)
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));

    }

    public static boolean forAttributeContains(WebElement element, String attribute, String value) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MICROSECONDS)
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.attributeContains(element, attribute, value));

    }

    public static WebElement untilVisible(WebElement element) {
        try{
            org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(3000, TimeUnit.SECONDS)
                    .pollingEvery(100, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            return wait.until(
                    ExpectedConditions.visibilityOf(element));
        }catch(TimeoutException e){
            return null;
        }
    }

    public static boolean untilVisibleByXpath(String xpath) {
        try{
            org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        }catch(TimeoutException e){
            return false;
        }
    }

    public static WebElement untilNotVisible(WebElement element) {
        try{
            org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            return wait.until(
                    WaitingConditions.invisibilityOfAnElement(element));
        }catch(TimeoutException e){
            return null;
        }
    }

    public static void clickWhenPresent(WebElement element) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(WaitingConditions.elementToBeClickable(element));
        wait.until(WaitingConditions.clickWhenReady(element));
    }

    public static boolean untilNotVisible(String elementXPath) {
        boolean elementStatus;
        try{
            org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            elementStatus = wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXPath)));
        }catch(TimeoutException e){
            elementStatus = false;
        }
        return elementStatus;
    }

    static void forNumberOfTabsToBe(int numberOfTabs) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS);
        wait.until(WaitingConditions.numberOfTabsToBe(numberOfTabs));
    }

    public static void forURL() {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS);
        wait.until(WaitingConditions.urlAppears());
    }

    public static void untilJQueryIsLoaded() {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MICROSECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(WaitingConditions.jqueryIsLoaded());
    }

    public static void untilTextAppears(Element element) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(WaitingConditions.textAppears(element.getWrappedElement()));
    }

    public static void untilExpanded(WebElement element) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MICROSECONDS);
        wait.until(WaitingConditions.elementIsExpanded(element.findElement(By.xpath("./following-sibling::div[1]"))));
    }

    public static void forNewUrlOrTab(String oldUrl) {
        try {
            new WebDriverWait(getDriver(), 3).until(WaitingConditions.newTabOrUrlChange(oldUrl));
        } catch (TimeoutException e) {
            //
        }
    }
}
