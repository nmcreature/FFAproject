package org.ffa.tests.performance;

import org.ffa.pages.BookPage;
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
public class BookInfoTest extends BaseTest {

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Test()
    public void bookInfo() throws IOException {
        String bookName = "Candide";
        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        sleep(20000);
        libraryPage.swipeFromBottomToTop(1);
        libraryPage.tapInfo(bookName);
        startTimer("Open book info ");
        libraryPage.verifyBookInfoIsDisplayed();
        stopTimer();

        libraryPage.tapRead();
        startTimer("Tap Read");
        BookPage bookPage = new BookPage();
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        sleep(15000);
        libraryPage.swipeFromBottomToTop(1);
        libraryPage.tapInfo(bookName);
        libraryPage.tapNewStudyCourse();
        startTimer("Open New Study Course pop-up");
        assertTrue(libraryPage.verifyNewStudyCourceIsDisplayed());
        stopTimer();

//        libraryPage.tapMenu();
//        sleep(2000);
//        libraryPage.tapMyBooks();
//        sleep(2000);
//        libraryPage.swipeFromBottomToTop();
//        libraryPage.tapInfoOnMyBooks(bookName);
//        libraryPage.tapRemove();
//        startTimer("Remove from My Books");
//        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
//        stopTimer();
    }
}
