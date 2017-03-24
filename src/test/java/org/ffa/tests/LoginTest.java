package org.ffa.tests;

import io.appium.java_client.AppiumDriver;
import org.ffa.framework.BrowserActions;
import org.ffa.framework.BrowserFactory;
import org.ffa.framework.Performance;
import org.ffa.pages.LibraryPage;
import org.ffa.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.ffa.framework.BrowserFactory.getDriver;
import static org.ffa.framework.Wait.untilPageIsLoaded;


@Listeners
public class LoginTest extends BaseTest{

    @BeforeClass
    public void setUp() throws InterruptedException {
//        BrowserActions.open("https://reader.firm-foundation.org/portal/");
        super.beforeTest();
    }

    @Test
    public void loginTest() throws InterruptedException, IOException {
        sleep(10000);
        Set<String> contexts = ((AppiumDriver)getDriver()).getContextHandles();
        for (String context : contexts) {
            System.out.println(context);
        }
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        LibraryPage libraryPage = new LibraryPage();
        libraryPage.verifyFirstBookIsDisplayed();

        contexts = ((AppiumDriver)getDriver()).getContextHandles();
        for (String context : contexts) {
            System.out.println(context);
        }
    }
}
