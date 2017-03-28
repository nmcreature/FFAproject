package org.ffa.framework;

import org.openqa.selenium.JavascriptExecutor;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

public class Tabs {

    @Step("Open Second tab")
    public static void openSecondTab(String pageUrl){
        JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver();
        js.executeScript("window.open(arguments[0])", pageUrl);
    }

    public static ArrayList<String> getWindowHandles() {
        return new ArrayList(BrowserFactory.getDriver().getWindowHandles());
    }

    @Step("Switch to the mail tab")
    public static void switchToSecondTab(String tab) {
        BrowserFactory.getDriver().switchTo().window(tab);
    }

    @Step("Switch to main tab")
    public static void switchToFirstTab(String tab) {
        BrowserFactory.getDriver().switchTo().window(tab);
    }
}
