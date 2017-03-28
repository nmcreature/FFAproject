package org.ffa.framework;

import com.csvreader.CsvWriter;
import org.apache.log4j.Logger;
import org.ffa.webelements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.ffa.framework.BrowserFactory.getDriver;

public class Utilities {

    public static Logger getLogger(){
        return Logger.getLogger("root");
    }

    public static void jsSelect(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].checked = true;", element);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement find(By locator) {
        return BrowserFactory.getDriver().findElement(locator);
    }

    public static List<WebElement> finds(By locator) {
        return BrowserFactory.getDriver().findElements(locator);
    }

    public void transfersToLibrary() {
        List<WebElement> listOfMenuItems = finds(By.xpath("//div[@class='manage-publications-mode']//li"));
        listOfMenuItems.get(0).click();
        sleep(2000);
        listOfMenuItems.get(2).click();
        sleep(2000);
        listOfMenuItems.get(1).click();
        sleep(2000);
    }

    public static File writeToTxt(String fileName, String text) {
        File report = null;
        try {
            String fullPath = "./target/" + fileName + ".txt";
            report = new File(fullPath);
            FileWriter fw = new FileWriter(new File(fullPath).getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
            fw.close();
            getLogger().info("Report was generated");
        } catch (Exception e) {
            getLogger().error("Error generating report");
            e.printStackTrace();
        }
        return report;
    }

    public static void writeToCSV(String fileName, String [] headers, ArrayList<String> values) throws IOException {
        String fullPath = "./target/" + fileName + ".csv";

        boolean alreadyExists = new File(fullPath).exists();

        try {
            CsvWriter csvOutput = new CsvWriter(new FileWriter(fullPath, true), ',');

            if (!alreadyExists)
            {
                for (String str : headers) {
                    csvOutput.write(str);
            }
                csvOutput.endRecord();
            }

            // write out a few records
            for (String str : values) {
                csvOutput.write(str);
            }
            csvOutput.endRecord();

            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static byte[] saveTxtAttach(String attachName, File file) {
        try {
            return toByteArray(file);
        } catch (Exception e) {
            getLogger().error("Failed to attach to report");
        }
        return new byte[0];
    }

    private static byte[] toByteArray(File file) throws IOException {
        return Files.readAllBytes(Paths.get(file.getPath()));
    }

    public boolean checkPresenceIgnoringStaleException(By by) {
        int counter = 0;
        boolean isPresent = false;
        while (counter < 10) {
            try {
                Element el = new Element(find(by));
                isPresent = el.exists();
                break;
            } catch (StaleElementReferenceException e) {
                getLogger().info("Stale Reference Exception was caught");
                counter++;
            }
        }
        return isPresent;
    }

    public void addElementsToArray(ArrayList<String> arrayList, long value) {
        arrayList.add(Long.toString(value));
    }

    public static String generateRandomString() {
        Random random = new Random();

        String st = "aflmop";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < st.length(); i++) {
            stringBuilder.append(st.charAt(random.nextInt(st.length())));
        }
        return stringBuilder.toString();
    }
}
