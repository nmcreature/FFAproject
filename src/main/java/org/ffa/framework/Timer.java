package org.ffa.framework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sokd on 2/16/17.
 */
public class Timer {
    private static final DateFormat REPORT_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private static Long start;
    private static Long end;
    private static Long totalTime;
    private static String title;


    private static void resetTimer() {
        start = 0L;
        end = 0L;
        title = "";
    }

    public static void startTimer(String stageTitle) {
        start = System.currentTimeMillis();
        title = stageTitle;
    }

    public static void stopTimer() {
        end = System.currentTimeMillis();
        totalTime = end - start;
        System.out.println(totalTime);
        saveResults();
        resetTimer();
    }

    private static void saveResults() {
        File file = new File("/Users/sokd/Desktop/FFA/Report.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // FileWriter fr = null;
        try {
            Date date = new Date();
            // fr = new FileWriter(file);
            fw.write("\r\n");
            fw.write(REPORT_DATE_FORMAT.format(date) + " " + title + ", total time to load: " + totalTime);
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
    }

}
