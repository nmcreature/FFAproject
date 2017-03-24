package org.ffa.tests.performance;

import org.ffa.pages.LoginPage;
import org.ffa.pages.LibraryPage;
import org.ffa.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.ffa.framework.Timer.startTimer;
import static org.ffa.framework.Timer.stopTimer;
import static org.testng.Assert.assertTrue;

@Listeners
public class NavigationTests extends BaseTest {

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin("sokd@isddesign.com");
        loginPage.enterPassword("xv443ix7tr"); //go7y7kz37q zk2kt5r0ne
        loginPage.clickLogIn();
        startTimer("Login");
    }

    @Test()
    public void navigation() throws IOException {

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        libraryPage.tapMyBooks();
        libraryPage.tapLibrary();
        startTimer("Navigate MyBooks -> Library");
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        libraryPage.tapMyBooks();
        startTimer("Navigate Library -> MyBooks");
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        libraryPage.tapStudy();
        startTimer("Navigate Library -> Study");
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        libraryPage.tapLibrary();
        sleep(2000);
        libraryPage.clickCategoriesMenu();
        libraryPage.selectAutobiographies();
        startTimer("Select category - Autobiographies");
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        libraryPage.clickCategoriesMenu();
        libraryPage.selectAllCategories();

        libraryPage.filterBy("tales");
        startTimer("Filter by - tales");
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();
    }
}
