package org.ffa.tests.performance;

import org.ffa.pages.BookPage;
import org.ffa.pages.LoginPage;
import org.ffa.pages.LibraryPage;
import org.ffa.tests.BaseTest;
import org.testng.annotations.*;

import java.io.IOException;

import static org.ffa.framework.Timer.startTimer;
import static org.ffa.framework.Timer.stopTimer;
import static org.testng.Assert.assertTrue;

@Listeners
public class GoToBookStagingTest extends BaseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin("nalb@isddesign.com");
        loginPage.enterPassword("zk2kt5r0ne"); //go7y7kz37q
        loginPage.clickLogIn();
        startTimer("Login: ");
    }

    @Test(dataProvider = "provideBooks")
    public void openBookFromLibrary(String bookName) throws IOException {

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        stopTimer();

        libraryPage.swipeToBook(bookName);
        libraryPage.selectBook(bookName);
        startTimer("Open book: " + bookName);
        BookPage bookPage = new BookPage();
        assertTrue(bookPage.verifyBookImageIsDisplayed());
        stopTimer();
    }

    @DataProvider(name = "provideBooks")
    public Object[][] provideData() {

        return new Object[][] {
                { "Aesop's Fables" },
                { "Andersen's Fairy Tales" },
                { "More Jataka Tales" },
                { "Just So Stories" },
                { "Peter Pan" },
                { "Tarzan of the Apes" },
                { "Narrative of the Life of Frederick Douglass" },
                { "Candide" },
                { "King Solomon's Mines" },
                { "David Crockett: His Life and Adventures" },
                { "The Kreutzer Sonata" },
                { "The Turn of the Screw" },
                { "A Connecticut Yankee in King Arthur's Court" }
        };
    }
    @AfterMethod
    public void tearDown() {
        super.afterTest();
    }
}
