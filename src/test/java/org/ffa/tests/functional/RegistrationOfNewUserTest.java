package org.ffa.tests.functional;

import org.ffa.framework.BrowserActions;
import org.ffa.framework.SoftAssertExtended;
import org.ffa.pages.ConfirmationPage;
import org.ffa.pages.LoginPage;
import org.ffa.pages.RegisterPage;
import org.ffa.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Listeners(org.ffa.framework.AllureOnFailListener.class)
public class RegistrationOfNewUserTest extends BaseTest {

    RegisterPage registerPage;
    LoginPage loginPage;
    ConfirmationPage confirmationPage;
    SoftAssertExtended softAssert;

    @BeforeClass
    public void setUp() throws InterruptedException {
        BrowserActions.open("https://reader-stage.firm-foundation.org/portal/#/");
        loginPage = new LoginPage();
        loginPage.clickWebVersion();
        registerPage = loginPage.clickCreateNewAccount();
    }

    @Features("New User Registration")
    @Stories("Verification of validation messages on Register page")
    @Test()
    public void verificationOnRegisterPage() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Button Back verification test started");
        registerPage.clickBackButton();
        softAssert.assertTrue(loginPage.checkLogIn());
        loginPage.clickCreateNewAccount();
        getLogger().info("Validation verification on Register page test started");
        getLogger().info("Case 3.1 started");
        registerPage.clickCreateAccount();
        registerPage = new RegisterPage();
        softAssert.assertEquals(registerPage.getFirstNameValidation(), "Value required, Please, enter valid name");
        softAssert.assertEquals(registerPage.getLastNameValidation(), "Value required, Please, enter valid name");
        softAssert.assertEquals(registerPage.getEmailValidation(), "Value required, E-mail address has been already used or invalid");
        softAssert.assertEquals(registerPage.getPasswordValidation(), "Value required, Please, enter valid password");
        softAssert.assertEquals(registerPage.getConfirmPasswordValidation(), "Value required");

        getLogger().info("Case 3.2 started");
        registerPage.enterFirstName("123123");
        softAssert.assertEquals(registerPage.getFirstNameValidation(), "Please, enter valid name");

        getLogger().info("Case 3.3 started");
        registerPage.enterLastName("ываы34");
        softAssert.assertEquals(registerPage.getLastNameValidation(), "Please, enter valid name");
        registerPage.clearFirstAndLastNameFields();
        softAssert.assertEquals(registerPage.getFirstNameValidation(), "Please, enter valid name, Value required");
        softAssert.assertEquals(registerPage.getLastNameValidation(), "Please, enter valid name, Value required");

        getLogger().info("Case 3.4 started");
        registerPage.enterFirstName("werwrwerrrrrrrrrrrrrghghjd");
        registerPage.enterLastName("werwrwerrrrrrrrrrrrrghghjd");
        softAssert.assertEquals(registerPage.getFirstNameValidation(), "Please, enter valid name");
        softAssert.assertEquals(registerPage.getLastNameValidation(), "Please, enter valid name");

        getLogger().info("Case 3.5 started");
        registerPage.enterFirstName("Oliver");
        registerPage.enterLastName("Richardson");
        registerPage.enterEmail("1234563454");
        softAssert.assertEquals(registerPage.getEmailValidation(), "Value required, E-mail address has been already used or invalid");
        registerPage.enterEmail("efff.fg");
        softAssert.assertEquals(registerPage.getEmailValidation(), "Value required, E-mail address has been already used or invalid");
        registerPage.enterEmail("ваываыва\"ппп");
        softAssert.assertEquals(registerPage.getEmailValidation(), "Value required, E-mail address has been already used or invalid");

        getLogger().info("Case 3.6 started");
        registerPage.enterEmail("olsa@isddesign.com");
        registerPage.enterPassword("123456");
        registerPage.enterPasswordConfirmation("123456");
        registerPage.clickCreateAccount();
        softAssert.assertEquals(registerPage.getEmailValidation(), "E-mail address has been already used or invalid");

        getLogger().info("Case 3.7 started");
        registerPage.enterEmail("nalb@gmail.com");
        registerPage.enterPassword("123456");
        registerPage.clearPasswordConfirmation();
        softAssert.assertEquals(registerPage.getConfirmPasswordValidation(), "Value required, Please, enter valid confirmation");

        getLogger().info("Case 3.8 started");
        registerPage.enterPasswordConfirmation("654321");
        softAssert.assertEquals(registerPage.getConfirmPasswordValidation(), "Please, enter valid confirmation");
        softAssert.assertAll();
    }

    @Features("New User Registration")
    @Stories("Successful registration")
    @Test(dependsOnMethods = "verificationOnRegisterPage", alwaysRun = true)
    public void successfulRegistrationTest() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Successful registration test started");
        registerPage.enterEmail("olirich@yopmail.com");
        registerPage.enterPassword("123456");
        registerPage.enterPasswordConfirmation("123456");
        registerPage.clickCreateAccount();
        registerPage.clickCreateAccount();
        confirmationPage = new ConfirmationPage();
        softAssert.assertTrue(confirmationPage.checkTitle());
        softAssert.assertAll();
    }

    @Features("New User Registration")
    @Stories("Verification of validation messages on Confirm registration page")
    @Test(dependsOnMethods = "successfulRegistrationTest", alwaysRun = true)
    public void verificationOnConfirmRegistrationPage() {
        softAssert = new SoftAssertExtended();
        getLogger().info("Verification on Confirm registration page test started");
        confirmationPage = new ConfirmationPage();
        confirmationPage.clickProceedButton();
        confirmationPage = new ConfirmationPage();
        sleep(500);
        softAssert.assertEquals(confirmationPage.getCodeValidation(), "Task confirmation code hasn't been found.");
        confirmationPage.enterCode("letters");
        softAssert.assertEquals(confirmationPage.getCodeValidation(), "Task confirmation code hasn't been found.");
        confirmationPage.enterCode("1234563454");
        softAssert.assertEquals(confirmationPage.getCodeValidation(), "Task confirmation code hasn't been found.");
        confirmationPage.enterCode("879rrr!@$*(0)##");
        softAssert.assertEquals(confirmationPage.getCodeValidation(), "Task confirmation code hasn't been found.");
        confirmationPage.clickBackButton();
        softAssert.assertTrue(loginPage.checkLogIn());
        softAssert.assertAll();
    }
}
