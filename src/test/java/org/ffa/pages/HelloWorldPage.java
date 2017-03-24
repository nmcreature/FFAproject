package org.ffa.pages;

import io.appium.java_client.AppiumDriver;
import org.ffa.webelements.Button;
import org.openqa.selenium.support.FindBy;

import static org.ffa.framework.BrowserFactory.getDriver;

/**
 * Created by sokd on 3/22/17.
 */
public class HelloWorldPage {

    @FindBy(className = "button--large")
    private Button startDemo;

    public void clickStartDemo() {
        startDemo.click();
    }
}
