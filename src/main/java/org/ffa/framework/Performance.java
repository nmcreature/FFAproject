package org.ffa.framework;

import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Performance {

    public static void pageLoadi() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver();
        final Long Prerequest;
        final Long Request;
        final Long Response;
        final Long DOMLoading;
        final Long DOMComplete;
        final Long Load;
        final Long Processing;

        Prerequest = (Long) js.executeScript("return (window.performance.timing.requestStart-window.performance.timing.navigationStart);");

        Request = (Long) js.executeScript("return (window.performance.timing.responseStart - window.performance.timing.requestStart) ;");
        System.out.println("Request " + Request);

        Response = (Long) js.executeScript("return (window.performance.timing.responseEnd - window.performance.timing.responseStart) ;");
        System.out.println("Response " + Response);

        DOMLoading = (Long) js.executeScript("return (window.performance.timing.domInteractive -window.performance.timing.responseEnd) ;");
        System.out.println("DOMLoading " + DOMLoading);

        DOMComplete = (Long) js.executeScript("return (window.performance.timing.domComplete - window.performance.timing.domInteractive) ;");
        System.out.println("DOMComplete " + DOMComplete);

        Load = (Long) js.executeScript("return (window.performance.timing.loadEventEnd - window.performance.timing.domComplete) ;");
        System.out.println("Load " + Load);

        System.out.println("Total " + (Prerequest + Request + Response + DOMLoading + DOMComplete + Load));
    }

    public static void pageLoad(String args) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver();
        final Long loadEventEnd;
        final Long responseStart;
        final Long responseEnd;
        final Long requestStart;
        final Long navigationStart;
        final Long indexOfLastResources;
        final Long Request;
        final Long Response;
        final Long fulLoad;
        final Long fullNav;

        //http://w3c.github.io/navigation-timing/
        //This attribute must return the time when the load event of the current document is completed
        loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");

        //This attribute must return the time immediately after the user agent receives the first byte of the response from the server
        responseStart = (Long) js.executeScript("return window.performance.timing.responseStart;");

        //This attribute must return the time immediately after the user agent receives the last byte of the current document or immediately before the transport connection is closed, whichever comes first
        responseEnd = (Long) js.executeScript("return window.performance.timing.responseEnd;");

        //This attribute must return the time immediately before the user agent starts requesting the current document from the server
        requestStart = (Long) js.executeScript("return window.performance.timing.requestStart;");

        navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");

        indexOfLastResources = (Long) js.executeScript("return window.performance.getEntriesByType('resource').length");

        Request = responseStart - requestStart;
        Response = responseEnd - responseStart;
        fulLoad = loadEventEnd - requestStart;
        fullNav = loadEventEnd - navigationStart;

     /*   System.out.println("Load Event End " + loadEventEnd);
        System.out.println("Page Load Time is " + fulLoad + " mseconds.");
        System.out.println("TimeFirstByte " + responseTime + " serverTime " + serverTime);
        System.out.println("Requests " + indexOfLastResources);*/

        /*String TextRequest =  "Request  : " + Request + "| ";
        String TextResponse = "Response : " + Response + "| ";
        String TextfulLoad =  "Full Load: " + fulLoad + "| ";*/

        String TextRequest =  Request + "| ";
        String TextResponse = Response + "| ";
        String TextfulLoad =  fulLoad + "| ";
        String TextfulNav =  fullNav + "| ";

        String TotalRequests = "Total Requests:" + indexOfLastResources + " ";
        String page = "Page: " + args + "| ";

        String baseUrl = BrowserFactory.getDriver().getCurrentUrl();
        //System.out.println("URL is " + baseUrl);
        //System.out.println("URL is " + baseUrl.toString());

        //File file = new File("C:/Users/olsa/IdeaProjects/ProjectTestCom/Report.txt");
        File file = new File("D:/Report.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file, true);
        // FileWriter fr = null;
        try {
            // fr = new FileWriter(file);
            fw.write("\r\n");
            fw.write(baseUrl);
            fw.write("\r\n");
            fw.write(page);
            fw.write(TextRequest);
            fw.write(TextResponse);
            fw.write(TextfulLoad);
            fw.write(TextfulNav);
            //fw.write(TotalRequests);
            //fw.write("\r\n");
            fw.write("\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File f = new File("D:/diagram.txt");
        f.createNewFile();
        FileWriter ff = new FileWriter(f, true);
        try {
            //ff.write(page);
            ff.write(TextfulLoad);
            ff.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ff.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
