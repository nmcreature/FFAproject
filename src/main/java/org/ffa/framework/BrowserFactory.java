package org.ffa.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void startBrowser() {

        String app = "/Users/sokd/Desktop/FFA/FFA-reader-stage.apk"; // FFA-reader-stage
        String ANDROID_APP_PACKAGE = "com.isd.ffamaster";
        String ANDROID_DEVICE_SOCKET = ANDROID_APP_PACKAGE + "_devtools_remote";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("androidDeviceSocket", ANDROID_DEVICE_SOCKET);

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_6P_API_23");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
        capabilities.setCapability(MobileCapabilityType.UDID, "0139488fe3715743");
//        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, app);

        capabilities.setCapability("androidDeviceSocket", ANDROID_DEVICE_SOCKET);

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

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
