package org.ffa.tests.performance;

import org.ffa.pages.BookPage;
import org.ffa.pages.LoginPage;
import org.ffa.pages.LibraryPage;
import org.ffa.pages.MainMenuPage;
import org.ffa.tests.BaseTest;
import org.testng.annotations.*;

import java.io.IOException;

import static org.ffa.framework.Timer.startTimer;
import static org.ffa.framework.Timer.stopTimer;
import static org.testng.Assert.assertTrue;

@Listeners
public class ReopenBooks extends BaseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        startTimer("Login: ");
    }

    @Test(dataProvider = "provideBooks")
    public void openBookFromLibrary(String bookName) throws IOException {

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        libraryPage.swipeToBook(bookName);
//        libraryPage.filterBy(bookName);
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        BookPage bookPage = new BookPage();
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());

//        libraryPage.filterBy(bookName);
        sleep(2000);
        libraryPage.selectBook(bookName);
        startTimer("Reopen book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();
    }

    @DataProvider(name = "provideBooks")
    public Object[][] provideData() {

        return new Object[][] {
                { "original" },
//                { "Aesop's Fables" },
//                { "Andersen's Fairy Tales" },
//                { "More Jataka Tales" },
//                { "Just So Stories" },
//                { "Peter Pan" },
//                { "Tarzan of the Apes" },
//                { "Narrative of the Life of Frederick Douglass" },
//                { "Candide" },
//                { "King Solomon's Mines" },
//                { "David Crockett: His Life and Adventures" },
//                { "The Kreutzer Sonata" },
//                { "The Turn of the Screw" },
//                { "A Connecticut Yankee in King Arthur's Court" }
        };
    }

    @Test()
    public void reopenBookFromLibrary() throws IOException {
        String bookName;

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        BookPage bookPage = new BookPage();
        MainMenuPage mainMenuPage = new MainMenuPage();

        libraryPage.swipeFromBottomToTop(6);
        bookName = "The Dawn-Breakers"; // "Andersen's Fairy Tales"
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

        libraryPage.swipeFromBottomToTop(6);
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

        libraryPage.swipeFromBottomToTop(1);
        bookName = "Old Friends"; // "More Jataka Tales"
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

        libraryPage.swipeFromBottomToTop(1);
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

        libraryPage.swipeFromBottomToTop(4);
        bookName = "Mosses from an Old Manse"; // "Just So Stories"
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

        libraryPage.swipeFromBottomToTop(4);
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        bookName = "Peter Pan";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        sleep(40000);
//        libraryPage.swipeFromBottomToTop(2); // 7
//        bookName = "Tarzan of the Apes";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(2); // 7
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(1); //4
//        bookName = "Narrative of the Life of Frederick Douglass";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(1); //4
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(1); //5
//        bookName = "King Solomon's Mines";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(1); //5
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(1); //6
//        bookName = "David Crockett: His Life and Adventures";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(1); //6
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        bookName = "The Kreutzer Sonata";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        bookName = "The Turn of the Screw";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        sleep(40000);
//        libraryPage.swipeFromBottomToTop(2); //10
//        bookName = "A Connecticut Yankee in King Arthur's Court";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        sleep(40000);
//        libraryPage.swipeFromBottomToTop(2); //10
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(1); //5
//        bookName = "Candide";
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
//
//        libraryPage.swipeFromBottomToTop(1); //5
//        libraryPage.selectBook(bookName);
//        startTimer("Open book: " + bookName);
//        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        stopTimer();
//
//        bookPage.tapMenu();
//        sleep(1000);
//        mainMenuPage.tapLibraryFromBook();
//        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());
    }

    @Test()
    public void openBookFromLibrary1() throws IOException {
        String bookName;

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        BookPage bookPage = new BookPage();
        MainMenuPage mainMenuPage = new MainMenuPage();

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

        bookName = "Just So Stories";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

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

        bookName = "The Kreutzer Sonata";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

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

        libraryPage.swipeFromBottomToTop(1); //5
        bookName = "Candide";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

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

        bookName = "Just So Stories";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

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

        bookName = "The Kreutzer Sonata";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();

        bookPage.tapMenu();
        sleep(1000);
        mainMenuPage.tapLibraryFromBook();
        assertTrue(libraryPage.verifyFirstBookImageIsDisplayed());

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

        libraryPage.swipeFromBottomToTop(1); //5
        bookName = "Candide";
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();
    }

    @AfterMethod
    public void tearDown() {
        super.afterTest();
    }
}
