package org.ffa;

import org.ffa.framework.BrowserFactory;
import org.ffa.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {


    public void testApp() throws InterruptedException {
        BrowserFactory browserFactory = new BrowserFactory();
        browserFactory.startBrowser();

        WebDriver driver = browserFactory.getDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://reader.firm-foundation.org/portal/");

        LoginPage loginPage = new LoginPage();
        loginPage.clickSignIn();

        Assert.assertTrue( true );
    }
}
