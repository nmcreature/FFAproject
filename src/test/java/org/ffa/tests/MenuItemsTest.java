package org.ffa.tests;

import org.ffa.framework.BrowserActions;
import org.ffa.pages.LoginPage;
import org.ffa.pages.LibraryPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class MenuItemsTest extends BaseTest {

    @BeforeClass
    public void setUp() throws InterruptedException {
        BrowserActions.open("https://reader.firm-foundation.org/portal/");

        LoginPage loginPage = new LoginPage();
        loginPage.loginThroughSignInButton();
        loginPage.clickWebVersion();
    }

    @Test
    public void menuItemsTest() {
        LibraryPage libraryPage = new LibraryPage();
        libraryPage.tapMyBooks();
        libraryPage.tapLibrary();

    }
}
