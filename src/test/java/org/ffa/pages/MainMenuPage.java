package org.ffa.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.ffa.webelements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ffa.framework.BrowserFactory.getDriver;

/**
 * Created by sokd on 2/16/17.
 */
public class MainMenuPage extends BasePage {
    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.view.View[1]")
    private Button messages;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[contains(@content-desc, 'To Do')]")
    private Button toDo;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[contains(@content-desc, 'Library')]")
    private Button library;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[contains(@content-desc, 'Resume Reading')]")
    private Button resumeReading;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[contains(@content-desc, 'Advanced Search')]")
    private Button advancedSearch;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[contains(@content-desc, 'Dictionary')]")
    private Button dictionary;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[contains(@content-desc, 'Profile')]")
    private Button profile;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[contains(@content-desc, 'Log Out')]")
    private Button logOut;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[contains(@content-desc, 'About FFA Reader')]")
    private Button aboutFFAReader;

    public void tapMessages() {
        ((AndroidDriver) getDriver()).tap(1, 240, 70, 100);
    }

    public void tapToDo() {
        ((AndroidDriver) getDriver()).tap(1, 240, 170, 100);
    }

    public void tapLibrary() {
        ((AndroidDriver) getDriver()).tap(1, 240, 300, 100);
    }

    public void tapLibraryFromBook() {
        ((AndroidDriver) getDriver()).tap(1, 240, 480, 100);
    }

    public void tapResumeReading() {
        ((AndroidDriver) getDriver()).tap(1, 240, 420, 100);
    }

    public void tapAdvancedSearch() {
        ((AndroidDriver) getDriver()).tap(1, 240, 420, 100);
    }

    public void tapDictionary() {
        ((AndroidDriver) getDriver()).tap(1, 240, 530, 100);
    }

    public void tapProfile() {
        ((AndroidDriver) getDriver()).tap(1, 240, 780, 100);
    }

    public void closeProfile() {
//        getDriver().getPageSource();
//        WebElement element = find(MobileBy.xpath("//android.webkit.WebView[1]/android.widget.Button[contains(@content-desc, 'Cancel')]"));
//        int x = element.getLocation().getX();
//        int y = element.getLocation().getY();
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);

        ((AndroidDriver) getDriver()).tap(1, 46, 353, 100);
    }

    public void tapLogOut() {
        ((AndroidDriver) getDriver()).tap(1, 240, 920, 100);
    }

    public void tapAbout() {
        ((AndroidDriver) getDriver()).tap(1, 240, 1035, 100);
    }

    public void tapExtras() {
        ((AndroidDriver) getDriver()).tap(1, 240, 70, 100);
    }

    public void tapReadingSettings() {
        ((AndroidDriver) getDriver()).tap(1, 240, 390, 100);
    }

    public void tapOverview() {
        ((AndroidDriver) getDriver()).tap(1, 240, 70, 100);
    }
}
