package org.ffa.tests.performance;

import org.ffa.pages.BookPage;
import org.ffa.pages.LoginPage;
import org.ffa.pages.LibraryPage;
import org.ffa.pages.MainMenuPage;
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
public class OpenFromMyBooks extends BaseTest {

    @BeforeClass
    public void setUp() throws InterruptedException {
//        BrowserActions.open("https://reader.firm-foundation.org/portal/");
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin("nalb@isddesign.com");
        loginPage.enterPassword("123456"); //go7y7kz37q zk2kt5r0ne
        loginPage.clickLogIn();
        startTimer("Login");
    }

    @Test()
    public void openBookFromMyBooks() throws IOException {
        String bookName;

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        libraryPage.tapMyBooks();
        libraryPage.tapLibrary();
        sleep(5000);
        libraryPage.tapMyBooks();
        sleep(2000);

//        bookName = "Aesop's Fables";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
        BookPage bookPage = new BookPage();
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
        MainMenuPage mainMenuPage = new MainMenuPage();
//        mainMenuPage.tapLibrary();
//        libraryPage.tapMyBooks();
//        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(1);

        bookName = "Andersen's Fairy Tales";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        sleep(2000);
//        bookPage.tapMenu();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        bookName = "More Jataka Tales";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        bookName = "Just So Stories";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());


//        libraryPage.swipeFromBottomToTop(1);
        bookName = "Peter Pan";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        libraryPage.swipeFromBottomToTop(1); // 3
        bookName = "Tarzan of the Apes";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

//        libraryPage.swipeFromBottomToTop(2);
        bookName = "Narrative of the Life of Frederick Douglass";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        libraryPage.swipeFromBottomToTop(1); //3
        bookName = "King Solomon's Mines";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        libraryPage.swipeFromBottomToTop(1); // 3
        bookName = "David Crockett: His Life and Adventures";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

//        libraryPage.swipeFromBottomToTop(2);
        bookName = "The Kreutzer Sonata";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

//        libraryPage.swipeFromBottomToTop(2);
        bookName = "The Turn of the Screw";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        libraryPage.swipeFromBottomToTop(1); // 4
        bookName = "A Connecticut Yankee in King Arthur's Court";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        mainMenuPage.tapLibraryFromBook();
        libraryPage.tapMyBooks();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

        libraryPage.swipeFromBottomToTop(1); // 3
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
