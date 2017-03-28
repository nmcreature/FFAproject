package org.ffa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.ffa.webelements.Button;
import org.ffa.webelements.Element;
import org.ffa.webelements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.ffa.framework.BrowserFactory.getDriver;
import static org.ffa.framework.Wait.untilVisible;

public class BookPage extends BasePage {

    @FindBy(xpath = "//div[@class='book-head-text']//h1")
    private Element bookTitle;

    @FindBy(xpath = "//*[@id='para_1']/span[2]")
    private Element bookContent;

    @FindBy(xpath = "//a[@sw-tooltip='ApplicationMenuItem.Library.hint']")
    private Link library;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.Image[1]")
    private Element bookImage;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[1]//android.view.View[contains(@content-desc, \"Info\")]")
    private Button info;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[1]//android.view.View[contains(@content-desc, \"Notes\")]")
    private Button notes;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[contains(@content-desc, \"All Notes\")]")
    private Button allNotes;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[11]/android.widget.ListView[1]/android.view.View[4]/android.widget.Button[1]")
    private Button readingBar;

    String contentPath  = "//android.webkit.WebView[1]/android.view.View[12]/android.widget.ListView[1]//android.view.View[contains(@content-desc, \"%s\")]";

    String selectedContentPath = "//android.webkit.WebView[1]/android.view.View[7]/android.view.View[contains(@content-desc, \"%s\")]";

    @Step("Get book title")
    public String getBookTitle() {
        untilVisible(bookTitle);
        return bookTitle.getText();
    }

    @Step("Get book content")
    public String getContent() {
        return bookContent.getText();
    }

    @Step("Verify book image is displayed")
    public boolean verifyBookImageIsDisplayed() {
        return bookImage.isDisplayed();
    }

    @Step("Verify Info is displayed")
    public boolean verifyInfoIsDisplayed() {
        return info.isDisplayed();
    }

    @Step("Verify Notes is displayed")
    public boolean verifyNotesIsDisplayed() {
        return notes.isDisplayed();
    }

    @Step("Verify All Notes is displayed")
    public boolean verifyAllNotesIsDisplayed() {
        return allNotes.isDisplayed();
    }

    public boolean verifySelectedContentIsDisplayed(String contentName) {
        String contentXpath = String.format(selectedContentPath, contentName);
        WebElement element = find(By.xpath(contentXpath));
        return element.isDisplayed();
    }

    public LibraryPage clickLibrary() {
        library.click();
        return new LibraryPage();
    }

    public void tapNotes() {
        notes.click();
    }

    public void tapInfo() {
        info.click();
    }

    public void selectContent(String content) {
        String contentXpath = String.format(contentPath, content);
        WebElement element = find(By.xpath(contentXpath));
        element.click();

//        System.out.println("x: " + element.getLocation().getX() + " y: " + element.getLocation().getY());
//        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 20, element.getLocation().getY() + 20, 100);
    }

    public boolean verifyReadingSettingsIsDisplayed() {
        return readingBar.isDisplayed();
    }
}
