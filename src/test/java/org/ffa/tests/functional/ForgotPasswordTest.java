package org.ffa.tests.functional;

import org.ffa.framework.BrowserActions;
import org.ffa.framework.BrowserFactory;
import org.ffa.framework.SoftAssertExtended;
import org.ffa.pages.ForgotPasswordPage;
import org.ffa.pages.LibraryPage;
import org.ffa.pages.LoginPage;
import org.ffa.pages.MailPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.util.ArrayList;

import static org.ffa.framework.Tabs.*;
import static org.ffa.framework.Utilities.getLogger;
import static org.ffa.framework.Utilities.sleep;

@Listeners(org.ffa.framework.AllureOnFailListener.class)
public class ForgotPasswordTest {

    LoginPage loginPage;
    SoftAssertExtended softAssert;
    ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        BrowserFactory.startBrowser();
        BrowserActions.open("https://reader-stage.firm-foundation.org/portal/#/");
        loginPage = new LoginPage();
        loginPage.clickWebVersion();
        forgotPasswordPage = loginPage.clickForgotPassword();
    }

    @Features("Forgot Password")
    @Stories("Successful forgot password")
    @Test
    public void forgotPasswordTest() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Successful forgot password test started");
        forgotPasswordPage.clickBackButton();
        softAssert.assertTrue(loginPage.checkLogIn());
        forgotPasswordPage = loginPage.clickForgotPassword();
        forgotPasswordPage.enterEmail("nalb@isddesign.com");
        forgotPasswordPage.clickProceed();
        softAssert.assertTrue(forgotPasswordPage.checkCodeConfirmField());
        forgotPasswordPage.clickBackButton();
        softAssert.assertTrue(loginPage.checkLogIn());
        softAssert.assertAll();
    }

    @Features("Forgot Password")
    @Stories("Verification of validation messages on Forgot password page")
    @Test(dependsOnMethods = "forgotPasswordTest", alwaysRun = true)
    public void validationOnForgotPasswordPage() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Case 2.2 started");
        forgotPasswordPage.enterEmail("oliver@gmail.com");
        forgotPasswordPage.clickProceed();
        softAssert.assertEquals(forgotPasswordPage.getEmailValidation(), "Sorry, this email is not registered in the IRLS system. Maybe you should try another one?");

        getLogger().info("Case 2.1 started");
        forgotPasswordPage.clickProceed();
        softAssert.assertEquals(forgotPasswordPage.getEmailValidation(), "Invalid email.");

        getLogger().info("Case 2.3 started");
        forgotPasswordPage.enterEmail("1234563454");
        forgotPasswordPage.clickProceed();
        softAssert.assertEquals(forgotPasswordPage.getEmailValidation(), "Invalid email.");
        forgotPasswordPage.enterEmail("efff.fg");
        forgotPasswordPage.clickProceed();
        softAssert.assertEquals(forgotPasswordPage.getEmailValidation(), "Invalid email.");
        forgotPasswordPage.enterEmail("ваываыва\"ппп");
        forgotPasswordPage.clickProceed();
        softAssert.assertEquals(forgotPasswordPage.getEmailValidation(), "Invalid email.");
        softAssert.assertAll();
    }

    @Features("Forgot Password")
    @Stories("Verification of validation messages on Changing password page and Successful Changing password")
    @Test(dependsOnMethods = "validationOnForgotPasswordPage", alwaysRun = true)
    public void validationOnChangingPassPageAndSuccessfulPassChanging() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Validation on  Changing password page test started");
        forgotPasswordPage.enterEmail("ollyrich@yopmail.com");
        forgotPasswordPage.clickProceed();
        openSecondTab("http://www.yopmail.com/en/");
        ArrayList<String> tabs = getWindowHandles();
        getLogger().info("Switch to mail tab");
        switchToSecondTab(tabs.get(1));
        MailPage mailPage = new MailPage();
        mailPage.loginToMail("ollyrich@yopmail.com");
        mailPage.switchToFrame();
        String code = mailPage.getPasswordChangeCode();
        BrowserFactory.getDriver().close();
        getLogger().info("Switch to main tab");
        switchToFirstTab(tabs.get(0));
        getLogger().info("switching to parent handle");
        sleep(2000);
        forgotPasswordPage.enterCode(code);
        sleep(2000);
        forgotPasswordPage.clickConfirm();

        getLogger().info("Case 3.1 started");
        forgotPasswordPage.clickChangePassword();
        softAssert.assertEquals(forgotPasswordPage.getNewPasswordValidation(), "Please, enter new password");
        softAssert.assertEquals(forgotPasswordPage.getConfirmPasswordValidation(), "Please, confirm your new password");

        getLogger().info("Case 3.2 started");
        forgotPasswordPage.enterNewPassword("123456");
        softAssert.assertTrue(forgotPasswordPage.checkConfirmValidation("Please, enter valid confirmation, Please, confirm your new password", "Please, confirm your new password, Please, enter valid confirmation"));

        getLogger().info("Case 3.3 started");
        forgotPasswordPage.enterConfirmPass("12");
        softAssert.assertEquals(forgotPasswordPage.getConfirmPasswordValidation(), "Please, enter valid confirmation");

        getLogger().info("Successful Changing password test started");
        forgotPasswordPage.enterConfirmPass("123456");
        forgotPasswordPage.enterNewPassword("123456");
        forgotPasswordPage.clickChangePassword();
        LibraryPage libraryPage = new LibraryPage();
        softAssert.assertTrue(libraryPage.checkMainMenuIcon());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.cleanUpDrivers();
    }
}
