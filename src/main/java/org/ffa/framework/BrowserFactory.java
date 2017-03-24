package org.ffa.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void startBrowser() {

        String app = "/Users/sokd/Desktop/FFA/app-debug.apk"; // FFA-reader-stage
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_6P_API_23");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
        capabilities.setCapability(MobileCapabilityType.UDID, "0139488fe3715743");
//        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, app);
        AppiumDriver newDriver = null;
        try {
            newDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        newDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.set(newDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void cleanUpDrivers() {
        if(driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
