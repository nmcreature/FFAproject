package org.ffa.tests.performance;

import org.ffa.pages.*;
import org.ffa.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.ffa.framework.Timer.startTimer;
import static org.ffa.framework.Timer.stopTimer;
import static org.testng.Assert.assertTrue;

@Listeners
public class NavigationOnBookPageTest extends BaseTest {

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin("sokd@isddesign.com");
        loginPage.enterPassword("xv443ix7tr"); //go7y7kz37q zk2kt5r0ne
        loginPage.clickLogIn();
    }

    @Test()
    public void navigationOnBookPage() throws IOException {
        String bookName = "Little Women";
        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        sleep(20000);
        libraryPage.swipeFromBottomToTop(2); // 11
        libraryPage.selectBook("Little Women");
        BookPage bookPage = new BookPage();

        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        MainMenuPage mainMenuPage = new MainMenuPage();
        sleep(2000);
        mainMenuPage.tapExtras();
        startTimer("Open Extras ");
        bookPage.verifyInfoIsDisplayed();
        stopTimer();

        bookPage.tapNotes();
        startTimer("Open Notes ");
        bookPage.verifyAllNotesIsDisplayed();
        stopTimer();

        bookPage.tapInfo();
        sleep(5000);
        bookPage.selectContent("Burdens");
        startTimer("Select content: " + "Burdens");
        bookPage.verifySelectedContentIsDisplayed("Burdens");
        stopTimer();
    }

    @Test()
    public void mainMenuReadingSettings() throws IOException {
        String bookName;
        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        sleep(20000);
        libraryPage.swipeFromBottomToTop(2);
        bookName = "Tarzan of the Apes";
        libraryPage.selectBook(bookName);
        BookPage bookPage = new BookPage();

        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.tapReadingSettings();
        startTimer("Open Reading settings ");
        bookPage.verifyReadingSettingsIsDisplayed();
        stopTimer();

        bookPage.tapMenu();
        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.verifyFirstBookIsDisplayed();

        sleep(3000);
        libraryPage.tapMenuByCoordinates();
        sleep(5000);

        mainMenuPage.tapResumeReading();
        startTimer("Resume reading ");
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();
    }
}
