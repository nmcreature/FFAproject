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
        loginPage.enterLogin("sokd@isddesign.com");
        loginPage.enterPassword("xv443ix7tr"); //go7y7kz37q zk2kt5r0ne
        loginPage.clickLogIn();
    }

    @Test()
    public void mainMenuNavigation() throws IOException {

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        sleep(10000);
        libraryPage.tapMenu();
        MainMenuPage mainMenuPage = new MainMenuPage();
        sleep(1000);
        mainMenuPage.tapMessages();
        startTimer("Open Messages: ");
        assertTrue(libraryPage.verifyMessageIsDisplayed());
        stopTimer();

        sleep(1500);
        libraryPage.tapMenu();
        libraryPage.tapMenu();
        sleep(1000);

        mainMenuPage.tapToDo();
        startTimer("Open To Do: ");
        assertTrue(libraryPage.verifyToDoIsDisplayed());
        stopTimer();

        sleep(1500);
        libraryPage.tapMenu();
        libraryPage.tapMenu();
        sleep(1000);

        mainMenuPage.tapLibrary();
        startTimer("Open Library: ");
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        sleep(1500);
        libraryPage.tapMenu();
        sleep(1000);

        mainMenuPage.tapAdvancedSearch();
        startTimer("Open Advanced Search: ");
        assertTrue(libraryPage.verifySearchLibraryIsDisplayed());
        stopTimer();

        sleep(1500);
        libraryPage.tapMenuByCoordinates();
        sleep(1000);

        mainMenuPage.tapDictionary();
        startTimer("Open Dictionary: ");
        assertTrue(libraryPage.verifySearchByKeywordIsDisplayed());
        stopTimer();

        sleep(1500);
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
