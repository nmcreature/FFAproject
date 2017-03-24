package org.ffa.tests.performance;

import org.ffa.pages.BookPage;
import org.ffa.pages.MainMenuPage;
import org.ffa.pages.LoginPage;
import org.ffa.pages.LibraryPage;
import org.ffa.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.ffa.framework.Timer.startTimer;
import static org.ffa.framework.Timer.stopTimer;
import static org.testng.Assert.assertTrue;

@Listeners
public class GoToBookPageTests extends BaseTest {

    @BeforeClass
    public void setUp() throws InterruptedException {
//        BrowserActions.open("https://reader.firm-foundation.org/portal/");
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        startTimer("Login");
    }

    @Test()
    public void openBookFromLibrary() throws IOException {
        String bookName;

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        BookPage bookPage = new BookPage();

//        bookName = "Aesop's Fables";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
        MainMenuPage mainMenuPage = new MainMenuPage();
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        sleep(20000);
//        libraryPage.swipeFromBottomToTop(3); //4
        bookName = "Andersen's Fairy Tales";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

        bookName = "More Jataka Tales";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

//        libraryPage.swipeFromBottomToTop();
        bookName = "Just So Stories";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

//        sleep(30000);
//        libraryPage.swipeFromBottomToTop(3);
        bookName = "Peter Pan";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

        sleep(40000);
        libraryPage.swipeFromBottomToTop(2); // 7
        bookName = "Tarzan of the Apes";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

//        sleep(30000);
        libraryPage.swipeFromBottomToTop(1); //4
        bookName = "Narrative of the Life of Frederick Douglass";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

//        sleep(30000);
        libraryPage.swipeFromBottomToTop(1); //5
        bookName = "King Solomon's Mines";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

//        sleep(30000);
        libraryPage.swipeFromBottomToTop(1); //6
        bookName = "David Crockett: His Life and Adventures";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

//        sleep(30000);
//        libraryPage.swipeFromBottomToTop(4);
        bookName = "The Kreutzer Sonata";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

//        sleep(30000);
//        libraryPage.swipeFromBottomToTop(4);
        bookName = "The Turn of the Screw";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

        sleep(40000);
        libraryPage.swipeFromBottomToTop(2); //10
        bookName = "A Connecticut Yankee in King Arthur's Court";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

//        sleep(30000);
        libraryPage.swipeFromBottomToTop(1); //5
        bookName = "Candide";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

//        assertEquals(bookPage.getBookTitle(), bookName);
//        assertEquals(bookPage.getContent(), contentWord);
//        bookPage.tapLibrary();
//        sleep(2000);
    }

    @DataProvider(name = "provideBooks")
    public Object[][] provideData() {

        return new Object[][] {
                { "Aesop", "Aesop's Fables", "Fox" },
                { "Andersen", "Andersen's Fairy Tales", "Emperor's" },
                { "More Jataka", "More Jataka Tales", "Jataka" },
                { "Just So", "Just So Stories", "So" },
                { "Peter", "Peter Pan", "Pan" },
                { "Tarzan", "Tarzan of the Apes", "Of" },
                { "Narrative of the Life of Frederick", "Narrative of the Life of Frederick Douglass", "Of" },
                { "Candide", "Candide", "Modern" },
                { "King", "King Solomon's Mines", "Solomon's" },
                { "David Crockett:", "David Crockett: His Life and Adventures", "Pioneers" },
                { "The Kreutzer", "The Kreutzer Sonata", "Kreutzer" },
                { "The Turn", "The Turn of the Screw", "Turn" },
                { "A Connecticut Yankee", "A Connecticut Yankee in King Arthur's Court", "Connecticut" }
        };
    }

}
