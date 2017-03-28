package org.ffa.framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.ffa.framework.BrowserFactory.getDriver;
import static org.ffa.framework.Utilities.getLogger;

public class Screenshoter {

    public static synchronized void takeScreenshot(String name) {
        String path = "./target/screenshots/" + name + ".png";
        try {
            Screenshot scr = shoot();
            byte[] rawBytes = writeToFS(path, scr);
            attachToAllure(name, rawBytes);
            getScreenshotURL(path);
        } catch (Exception e) {
            try{
                getDriver().switchTo().alert().accept();
            }
            catch(NoAlertPresentException noAlert) {
                getLogger().error("Exception while taking screenshot " + e.getMessage() + ".");
            }
        } finally {
            ((JavascriptExecutor)getDriver()).executeScript("document.body.style.zoom=1.0; window.scrollTo(0,0)");
        }
    }

    public static void takeScreenshot() {
        takeScreenshot(Long.toString(System.currentTimeMillis()));
    }

    private static byte[] writeToFS(String path, Screenshot scr) throws IOException {
        File outputFile = new File(Thread.currentThread().getId() + ".png");
        ImageIO.write(scr.getImage(), "PNG", outputFile);
        File screenshot = new File(path);
        FileUtils.copyFile(outputFile, screenshot);
        outputFile.deleteOnExit();
        return Files.readAllBytes(Paths.get(screenshot.getPath()));
    }

    private static Screenshot shoot() {
        Screenshot scr;
            scr = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(10)).takeScreenshot(getDriver());
//        this is for all other browsers
//      scr = new AShot().shootingStrategy(ShootingStrategies.simple()).takeScreenshot(getDriver());
        getLogger().info("Screenshot was taken");
        return scr;
    }

    private static void getScreenshotURL(String path) {
        String jenkinsURL = System.getProperty("jenkins.buildUrl");
        if(jenkinsURL == null || jenkinsURL.trim().isEmpty())
            getLogger().info((System.getProperty("user.dir") + "/"+path).replace("/", "\\").replace("\\.", ""));
        else
            getLogger().info(jenkinsURL + "artifact/Framework/" + path + "");
    }

    @Attachment(value = "{0}", type = "image/png")
    private static byte[] attachToAllure(String name, byte[] bytes) {
        return bytes;
    }

}
