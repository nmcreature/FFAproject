package org.ffa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.ffa.framework.BrowserFactory.getDriver;

public class Utilities {

    public static void jsSelect(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].checked = true;", element);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement find(By locator) {
        return BrowserFactory.getDriver().findElement(locator);
    }
}
