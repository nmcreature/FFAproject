package org.ffa.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.ffa.webelements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.ffa.framework.BrowserFactory.getDriver;

public class LibraryPage extends BasePage {

    private String book = "//android.webkit.WebView[1]/android.widget.ListView[2]//android.view.View[contains(@content-desc, \"%s\")]";


    @FindBy(xpath = "//div[@class='manage-publications-mode']//li")
    private List<WebElement> listOfMenuItems;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[2]/android.view.View[2]")
    private Button libraryButton;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[1]//android.view.View[contains(@content-desc, \"My Books\")]")
    private Button myBooksButton;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[3]/android.view.View[2]")
    private Button studyButton;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[1]")
    private Link firstBook;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[1]/android.widget.Image[1]")
    private Link firstBookImage;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[1]")
    private Element userMenu;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[7]")
    private Button categoriesMenu;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[3]/android.view.View[2]/android.view.View[1]")
    private Link autobiographies;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[6]/android.widget.EditText[1]")
    private TextInput filter;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[15]")
    private Label message;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[16]")
    private Label todo;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[1]")
    private TextInput searchLibrary;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[5]/android.widget.EditText[1]")
    private TextInput searchByKeyword;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[10]")
    private Label myProfile;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[10]")
    private Label about;

    String info = "//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[12]/android.view.View[contains(@content-desc, \"%s\")]/../android.view.View[contains(@content-desc, \"Image for details\")]";

    String infoOnMyBooks = "//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[7]/android.view.View[contains(@content-desc, \"%s\")]/../android.view.View[contains(@content-desc, \"Image for details\")]";

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[contains(@content-desc, \"Book Info\")]")
    private Label bookInfo;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[16]/android.view.View[contains(@content-desc, \"Read\")]")
    private Button read;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[16]/android.view.View[contains(@content-desc, \"New Study Course\")]")
    private Button newStudyCourse;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[16]/android.view.View[contains(@content-desc, \"Remove\")]")
    private Button remove;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[contains(@content-desc, \"New Study Course\")]")
    private Button newStudyCourseHeader;

    @Step("Click My Books")
    public void tapMyBooks() {
        ((AndroidDriver) getDriver()).tap(1, 70, 170, 100);

//        myBooksButton.click();
    }

    @Step("Click Library")
    public void tapLibrary() {
        libraryButton.click();
    }

    @Step("Click Study")
    public void tapStudy() {
        studyButton.click();
    }

    @Step("Click Categories Menu")
    public void clickCategoriesMenu() {
        By menuPath = MobileBy.xpath("//android.webkit.WebView[1]/android.view.View[5]");
        WebElement element = find(menuPath);
        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 10, element.getLocation().getY() + 10, 100);
    }

    @Step("Select category - Autobiographies")
    public void selectAutobiographies() {
        By menuItem = MobileBy.xpath("//android.webkit.WebView[1]/android.widget.ListView[3]/android.view.View[2]/android.view.View[1]");
        WebElement element = find(menuItem);
        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 10, element.getLocation().getY() + 10, 100);
    }

    @Step("Select category - All categories")
    public void selectAllCategories() {
        By menuItem = MobileBy.xpath("//android.webkit.WebView[1]/android.widget.ListView[3]/android.view.View[1]");
        WebElement element = find(menuItem);
        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 10, element.getLocation().getY() + 10, 100);
    }

    @Step("Filter")
    public void filterBy(String text) {
        filter.click();
        filter.sendKeys(text);
    }

    @Step
    public BookPage selectBook(String bookName) {
        String bookXpath = String.format(book, bookName);
        WebElement element = find(By.xpath(bookXpath));
//        System.out.println("x: " + element.getLocation().getX() + " y: " + element.getLocation().getY());
        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 20, element.getLocation().getY() + 20, 100);
        return new BookPage();
    }

    @Step
    public BookPage tapFirstBook() {
        firstBook.click();
        return new BookPage();
    }

    public void tapInfo(String bookName) {
        String infoXpath = String.format(info, bookName);
        WebElement element = find(By.xpath(infoXpath));
        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 10, element.getLocation().getY() + 10, 100);
    }

    public void tapInfoOnMyBooks(String bookName) {
        String infoXpath = String.format(infoOnMyBooks, bookName);
        WebElement element = find(By.xpath(infoXpath));
        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 10, element.getLocation().getY() + 10, 100);
    }

    public void tapNewStudyCourse() {
        newStudyCourse.click();
    }

    public void tapRead() {
        read.click();
    }

    public void tapRemove() {
        remove.click();
    }

    @Step
    public boolean verifyFirstBookIsDisplayed() {
        return firstBook.isDisplayed();
    }

    @Step
    public boolean verifyFirstBookImageIsDisplayed() {
        return firstBookImage.isDisplayed();
    }

    @Step
    public boolean verifyMessageIsDisplayed() {
        return message.isDisplayed();
    }

    @Step
    public boolean verifyToDoIsDisplayed() {
        return todo.isDisplayed();
    }

    @Step
    public boolean verifySearchLibraryIsDisplayed() {
        return searchLibrary.isDisplayed();
    }

    @Step
    public boolean verifySearchByKeywordIsDisplayed() {
        return searchByKeyword.isDisplayed();
    }

    @Step
    public boolean verifyMyProfileIsDisplayed() {
        return myProfile.isDisplayed();
    }

    @Step
    public boolean verifyAboutIsDisplayed() {
        return about.isDisplayed();
    }

    @Step
    public boolean verifyBookInfoIsDisplayed() {
        return bookInfo.isDisplayed();
    }

    public boolean verifyNewStudyCourceIsDisplayed() {
        return newStudyCourseHeader.isDisplayed();
    }
}
