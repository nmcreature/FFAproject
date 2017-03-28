package org.ffa.tests.functional;

import org.ffa.framework.BrowserActions;
import org.ffa.framework.BrowserFactory;
import org.ffa.framework.SoftAssertExtended;
import org.ffa.pages.ForgotPasswordPage;
import org.ffa.pages.LibraryPage;
import org.ffa.pages.LoginPage;
import org.ffa.pages.RegisterPage;
import org.ffa.pages.socialPages.FacebookPage;
import org.ffa.pages.socialPages.GooglePage;
import org.ffa.pages.socialPages.TwitterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.ffa.framework.Utilities.getLogger;

@Listeners(org.ffa.framework.AllureOnFailListener.class)
public class LoginTest {

    LoginPage loginPage;
    LibraryPage libraryPage;
    SoftAssertExtended softAssert;
    FacebookPage facebookPage;
    TwitterPage twitterPage;
    GooglePage googlePage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        BrowserFactory.startBrowser();
        loginPage = new LoginPage();
    }

    @Features("Login")
    @Stories("Successful login")
    @Test
    public void successfulLoginTest() {
        loginPage.enterLogin("sokd@isddesign.com");
        loginPage.enterPassword("123456");
        loginPage.clickLogIn();
    }

    @Features("Login")
    @Stories("Successful login via Facebook")
    @Test
    public void loginViaFacebookTest() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Login via Facebook test started");
        facebookPage = loginPage.clickFacebook();
        facebookPage.enterEmail("sofikalina@outlook.com");
        facebookPage.enterPassword("qazwsx123");
        libraryPage = facebookPage.clickLogin();
        softAssert.assertTrue(libraryPage.checkMainMenuIcon());
        softAssert.assertAll();
    }

    @Features("Login")
    @Stories("Successful login via Twitter")
    @Test
    public void loginViaTwitterTest() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Login via Twitter test started");
        twitterPage = loginPage.clickTwitter();
        twitterPage.enterEmail("@AnnaGrosu1");
        twitterPage.enterPassword("cOnvErsAtIOn");
        libraryPage = twitterPage.clickAllow();
        softAssert.assertTrue(libraryPage.checkMainMenuIcon());
        softAssert.assertAll();
    }

    @Features("Login")
    @Stories("Successful login via Google+")
    @Test
    public void loginViaGoogleTest() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Login via Google+ test started");
        googlePage = loginPage.clickGoogle();
        googlePage.enterEmail("anntemplate@gmail.com");
        googlePage.clickNext();
        googlePage.enterPassword("Jk14501450");
        libraryPage = googlePage.clickSignIn();
        softAssert.assertTrue(libraryPage.checkMainMenuIcon());
        softAssert.assertAll();
    }

    @Features("Login")
    @Stories("Verification of validation messages on Register page")
    @Test
    public void validationOnRegisterPage() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Validation messages on Register page tests started");
        getLogger().info("Case 5.1 started");
        loginPage.clickLogIn();
        softAssert.assertEquals(loginPage.getLoginValidation(), "Login or password is incorrect.");

        getLogger().info("Case 5.2 started");
        loginPage.enterLogin("1234563454");
        loginPage.enterPassword("123");
        loginPage.clickLogIn();
        softAssert.assertEquals(loginPage.getLoginValidation(), "Login or password is incorrect.");
        loginPage.enterLogin("efff.fg");
        loginPage.enterPassword("123");
        loginPage.clickLogIn();
        softAssert.assertEquals(loginPage.getLoginValidation(), "Login or password is incorrect.");
        loginPage.enterLogin("ваываыва\"ппп");
        loginPage.enterPassword("123");
        loginPage.clickLogIn();
        softAssert.assertEquals(loginPage.getLoginValidation(), "Login or password is incorrect.");

        getLogger().info("Case 5.3 started");
        loginPage.enterLogin("nalb@isddesign.com");
        loginPage.enterPassword("123");
        loginPage.clickLogIn();
        softAssert.assertEquals(loginPage.getLoginValidation(), "Login or password is incorrect.");
        softAssert.assertAll();
    }

    @Features("Login")
    @Stories("Login from dropdown via Facebook")
    @Test
    public void loginFromDropdownViaFacebook() {
        softAssert = new SoftAssertExtended();
        loginPage.clickSignIn();
        getLogger().info("Case 6.2 login via Facebook started");
        facebookPage = loginPage.clickFacebook();
        facebookPage.enterEmail("sofikalina@outlook.com");
        facebookPage.enterPassword("qazwsx123");
        libraryPage = facebookPage.clickLogin();
        softAssert.assertTrue(libraryPage.checkMainMenuIcon());
        softAssert.assertAll();
    }

    @Features("Login")
    @Stories("Login from dropdown via Twitter")
    @Test
    public void loginFromDropdownViaTwitter() {
        softAssert = new SoftAssertExtended();
        loginPage.clickSignIn();
        getLogger().info("Case 6.3 login via Twitter started");
        twitterPage = loginPage.clickTwitter();
        twitterPage.enterEmail("@AnnaGrosu1");
        twitterPage.enterPassword("cOnvErsAtIOn");
        libraryPage = twitterPage.clickAllow();
        softAssert.assertTrue(libraryPage.checkMainMenuIcon());
        softAssert.assertAll();
    }

    @Features("Login")
    @Stories("Login from dropdown via Google+")
    @Test
    public void loginFromDropdownViaGoogle() {
        softAssert = new SoftAssertExtended();
        loginPage.clickSignIn();
        getLogger().info("Case 6.4 login via Google+ started");
        googlePage = loginPage.clickGoogle();
        googlePage.enterEmail("anntemplate@gmail.com");
        googlePage.clickNext();
        googlePage.enterPassword("Jk14501450");
        libraryPage = googlePage.clickSignIn();
        softAssert.assertTrue(libraryPage.checkMainMenuIcon());
        softAssert.assertAll();
    }


    @Features("Login")
    @Stories("Navigation from dropdown")
    @Test
    public void navigationFromDropdown() {
        softAssert = new SoftAssertExtended();
        loginPage.clickSignIn();
        getLogger().info("Case 6.5 started");
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPassword();
        softAssert.assertTrue(forgotPasswordPage.checkProceedButton());
        loginPage = forgotPasswordPage.clickPortal();
        loginPage.clickSignIn();
        RegisterPage registerPage = loginPage.clickCreateNewAccount();
        softAssert.assertTrue(registerPage.checkCreateAccountButton());
        loginPage = registerPage.clickPortal();
        softAssert.assertTrue(loginPage.checkWebVersion());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.cleanUpDrivers();
    }
}
