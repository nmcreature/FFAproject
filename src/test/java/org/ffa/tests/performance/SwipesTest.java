package org.ffa.tests.performance;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.ffa.pages.BookPage;
import org.ffa.pages.LibraryPage;
import org.ffa.pages.LoginPage;
import org.ffa.tests.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.ffa.framework.BrowserFactory.getDriver;
import static org.ffa.framework.Timer.startTimer;
import static org.ffa.framework.Timer.stopTimer;
import static org.testng.Assert.assertTrue;

/**
 * Created by sokd on 3/17/17.
 */
public class SwipesTest extends BaseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        super.beforeTest();
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Test
    public void swipeTest() {
        String bookName;

        LibraryPage libraryPage = new LibraryPage();
        assertTrue(libraryPage.verifyFirstBookIsDisplayed());
        BookPage bookPage = new BookPage();

        bookName = "original"; // optimized
        libraryPage.swipeFromBottomToTop(5);
        startTimer("open book: " + bookName);
        libraryPage.selectBook(bookName);
        assertTrue(bookPage.verifyBookImageIsDisplayed());
//        sleep(30000);
        stopTimer();

        int steps = 0;

        getDriver().manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        startTimer("Swipe to the end of the book");
        while(true) {
            Dimension size = getDriver().manage().window().getSize();
            int starty = (int) (size.height * 0.80);
            int endy = (int) (size.height * 0.20);
            int startx = size.width / 2;
            sleep(200);
            ((AppiumDriver)getDriver()).swipe(startx, starty, startx, endy, 500);
//            sleep(200);

            steps ++;

            try {
                find(MobileBy.xpath("//android.webkit.WebView[1]/android.view.View[7]//android.view.View[contains(@content-desc, \"11.107\")]"));
                break;
            } catch (NoSuchElementException e) {
//                e.printStackTrace();
            }
        }
        stopTimer();
        System.out.println("Total swipes:" + steps);
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        ((JavascriptExecutor) getDriver()).executeScript(
//                "$('.sw-progress-toolbar-reading-position-marker').click()");
    }

}
