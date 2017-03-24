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
public class StudyBlockTest extends BaseTest {

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin("sokd@isddesign.com");
        loginPage.enterPassword("xv443ix7tr"); //go7y7kz37q zk2kt5r0ne
        loginPage.clickLogIn();
    }

    @Test()
    public void studyBlock() throws IOException {
        String bookName;
        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        StudyPage studyPage = new StudyPage();
        BookPage bookPage = new BookPage();
        MainMenuPage mainMenuPage = new MainMenuPage();

        bookName = "Little Women";

        sleep(20000);

        studyPage.swipeFromBottomToTop(2);
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

        libraryPage.tapStudy();


        sleep(20000);

//        studyPage.swipeFromBottomToTop(2);
        sleep(10000);
        studyPage.tapBeginStudy();
        startTimer("Tap Begin study ");
        bookPage.verifyBookImageIsDisplayed();
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapOverview();
        startTimer("Overview");
        studyPage.verifyCourseDetailsIsDisplayed();
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibrary();
        studyPage.verifyCoursePageIsDisplayed();

//        studyPage.swipeFromBottomToTop(2);

        studyPage.tapCourseDetails();
        startTimer("Course details");
        studyPage.verifyCourseDetailsIsDisplayed();
        stopTimer();

        studyPage.tapStudyCourseDropDown();
        studyPage.selectActivity();
        startTimer("Activity");
        studyPage.verifyActivityPageIsDisplayed();
        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibrary();
//        studyPage.verifyCoursePageIsDisplayed();
//
//        studyPage.swipeFromBottomToTop(2);
//
//        studyPage.tapResumeStudy();
//        studyPage.verifyBookPageIsDisplayed();
    }
}
