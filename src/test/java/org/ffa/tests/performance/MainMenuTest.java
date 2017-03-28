package org.ffa.tests.performance;

import org.ffa.pages.LoginPage;
import org.ffa.pages.LibraryPage;
import org.ffa.pages.MainMenuPage;
import org.ffa.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.ffa.framework.Timer.startTimer;
import static org.ffa.framework.Timer.stopTimer;
import static org.testng.Assert.assertTrue;

@Listeners
public class MainMenuTest extends BaseTest {

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Test()
    public void mainMenuNavigation() throws IOException {

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        sleep(5000);
        libraryPage.tapMenuByCoordinates();
        MainMenuPage mainMenuPage = new MainMenuPage();
        sleep(3000);
        mainMenuPage.tapMessages();
        startTimer("Open Messages: ");
        assertTrue(libraryPage.verifyMessageIsDisplayed());
        stopTimer();

        sleep(2000);
        libraryPage.tapMenuByCoordinates();
        sleep(2000);
        libraryPage.tapMenuByCoordinates();
        sleep(2000);

        mainMenuPage.tapToDo();
        startTimer("Open To Do: ");
        assertTrue(libraryPage.verifyToDoIsDisplayed());
        stopTimer();

        sleep(2000);
        libraryPage.tapMenuByCoordinates();
        sleep(2000);
        libraryPage.tapMenuByCoordinates();
        sleep(2000);

        mainMenuPage.tapLibrary();
        startTimer("Open Library: ");
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        sleep(2000);
        libraryPage.tapMenuByCoordinates();
        sleep(2000);

        mainMenuPage.tapAdvancedSearch();
        startTimer("Open Advanced Search: ");
        assertTrue(libraryPage.verifySearchLibraryIsDisplayed());
        stopTimer();

        sleep(2000);
        libraryPage.tapMenuByCoordinates();
        sleep(2000);

        mainMenuPage.tapDictionary();
        startTimer("Open Dictionary: ");
        assertTrue(libraryPage.verifySearchByKeywordIsDisplayed());
        stopTimer();

        sleep(2000);
        libraryPage.tapMenuByCoordinates();
        sleep(2000);
//        libraryPage.tapMenuByCoordinates();


        mainMenuPage.tapProfile();
        startTimer("Open Profile: ");
        assertTrue(libraryPage.verifyMyProfileIsDisplayed());
        stopTimer();
        sleep(4000);
        mainMenuPage.closeProfile();


        sleep(1500);
        libraryPage.tapMenuByCoordinates();
        sleep(1000);

        mainMenuPage.tapAbout();
        startTimer("Open About: ");
        assertTrue(libraryPage.verifyAboutIsDisplayed());
        stopTimer();

        sleep(1500);
        libraryPage.tapMenuByCoordinates();
        sleep(1000);
        libraryPage.tapMenuByCoordinates();
        sleep(1000);

        mainMenuPage.tapLogOut();
        startTimer("Logout: ");
        LoginPage loginPage = new LoginPage();
        assertTrue(loginPage.verifyLoginFieldIsDisplayed());
        stopTimer();
    }
}
