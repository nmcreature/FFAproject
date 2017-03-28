package org.ffa.tests;

import io.appium.java_client.AppiumDriver;
import org.ffa.pages.HelloWorldPage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.ffa.framework.BrowserFactory.getDriver;

/**
 * Created by sokd on 3/22/17.
 */
public class HelloWorld extends BaseTest {

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.beforeTest();
    }

    @Test
    public void helloWorldTest() throws InterruptedException, IOException {
        sleep(15000);

        Set<String> contexts = ((AppiumDriver)getDriver()).getContextHandles();
        for (String context : contexts) {
            System.out.println(context);
        }

        for (String context : contexts) {
            if(context.contains("CHROMIUM")) {
                System.out.println(context);
                ((AppiumDriver) getDriver()).context(context);
                System.out.println("context is set");
                break;
            }
        }
        sleep(10000);
        System.out.println("________________________");
        getDriver().findElement(By.xpath("//input[@ng-model=\"loginInfo.userName\"]")).sendKeys("someUser");
//        getDriver().findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]")).click();
    }
}
