package org.ffa.pages;

import org.ffa.framework.Wait;
import org.ffa.webelements.Element;
import org.ffa.webelements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.ffa.framework.Wait.untilNotVisible;
import static org.ffa.framework.Wait.untilVisible;
import static org.ffa.framework.WaitingConditions.elementToBeClickable;

public abstract class ReaderBasePage extends BasePage {

    private String book = "//a[contains(text(), \"%s\")]";
    private String bookInfo = "//a[contains(text(), '%s')]/ancestor::div[@ng-switch=\"\"]/following-sibling::div";

    @FindBy(xpath = "//div[@class='manage-publications-mode']//li")
    private List<WebElement> listOfMenuItems;

    @FindBy(xpath = "//button[text()='Far from the Madding Crowd']")
    private Link firstBook;

    @FindBy(xpath = "//div[@class='sw-appMenu list-containing-menu col']")
    private Element mainMenu;

    @FindBy(xpath = "//span[@sw-localize='PublicationDetails.remove.label']")
    private Element remove;

    @Step("Click My Books")
    public MyBooksPage clickMyBooks() {
        untilNotVisible(inputBlocker);
        listOfMenuItems.get(0).click();
        getLogger().info("My Books was clicked");
        return new MyBooksPage();
    }

    @Step("Click Library")
    public LibraryPage clickLibrary() {
        untilNotVisible(overlay);
        listOfMenuItems.get(1).click();
        getLogger().info("Library was clicked");
        return new LibraryPage();
    }

    @Step("Click Study")
    public StudyPage clickStudy() {
        untilNotVisible(overlay);
        listOfMenuItems.get(2).click();
        getLogger().info("Study was clicked");
        return new StudyPage();
    }

    @Step("Click Main Menu")
    public LibraryPage clickMainMenu() {
        untilVisible(mainMenu);
        untilNotVisible(overlay);
        mainMenu.click();
        return new LibraryPage();
    }

    @Step("Select a book")
    public BookPage selectBook(String bookName) {
        String bookXpath = String.format(book, bookName);
        untilNotVisible(overlay);
        find(By.xpath(bookXpath)).click();
        getLogger().info("Book is selected");
        return new BookPage();
    }

    @Step("Click Book Info icon")
    public void clickBookInfo(String bookNameStart) {
        String bookInfoXpath = String.format(bookInfo, bookNameStart);
        untilNotVisible(inputBlocker);
        find(By.xpath(bookInfoXpath)).click();
        getLogger().info("Book info was clicked");
    }

    @Step("Click Remove")
    public void clickRemove() {
        remove.click();
    }

    @Step("Wait until book is visible")
    public void waitUntilBookIsVisible(String bookName) {
        String bookXpath = String.format(book, bookName);
        Wait.untilVisible(find(By.xpath(bookXpath)));
        elementToBeClickable(find(By.xpath(bookXpath)));
    }

    @Step("Check book is opened")
    public boolean checkBook(String bookName) {
        String bookXpath = String.format(book, bookName);
        return checkPresenceIgnoringStaleException(By.xpath(bookXpath));
    }

    @Step("Check library page is opened")
    public boolean checkMainMenuIcon() {
        untilVisible(mainMenu);
        return mainMenu.exists();
    }
}
