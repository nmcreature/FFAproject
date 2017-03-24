package org.ffa.tests;

import org.ffa.framework.BrowserFactory;
import org.ffa.framework.Utilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Utilities{

//    @beforeTest(alwaysRun = true)
    public void beforeTest() {
        BrowserFactory.startBrowser();
    }

//    @AfterTest(alwaysRun = true)
    public void afterTest() {
        BrowserFactory.cleanUpDrivers();
    }
}
