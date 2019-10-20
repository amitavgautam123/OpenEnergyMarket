package com.oem.framework.core.utils;

import com.oem.framework.core.base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestUtil implements Base {
    static Logger logger= LoggerFactory.getLogger(TestUtil.class);

    public static void createDirectoryIfNotExists(String path) {

        File theDir = new File(path);
        if (!theDir.exists()) {
            logger.info("Directory does not exist:: " + path);
            boolean result = false;

            try {
                theDir.mkdirs();
                result = true;
            } catch (SecurityException var4) {
            }

            if (result) {
                logger.info("Directory created");
            }
        }

    }

    public static void cleanDirectory(String directory) {
        if (directory != null && !directory.trim().isEmpty()) {
            File dir = new File(directory.trim());

            try {
                if (dir.exists()) {
                    if (dir.isDirectory()) {
                        FileUtils.cleanDirectory(dir);
                    } else {
                        FileUtils.forceDelete(dir);
                    }
                }
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }
    }
    public static String takeScreenshot(String fileName, WebDriver driver) {
        String filepath = System.getProperty("user.dir") + File.separator + "screenshots"+ File.separator;
        createDirectoryIfNotExists(filepath);
        File destination = new File(filepath + fileName + ".png");
        try {
            logger.debug("Screenshot file name: " + fileName);
            File source;
            if (driver.getClass().toString().contains("Remote")) {
                // Save a screenshot
                WebDriver augmentedDriver = new Augmenter().augment(driver);
                 source = (File)((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
                // augmentedDriver.close();
            } else {
                 source = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            }

            FileUtils.copyFile(source, destination);
            return  destination.getAbsolutePath();
        } catch (Exception e) {
            // Ignore errors while taking the screenshot
            e.printStackTrace();
            logger.info("Failed to capture screenshot! " + e.getMessage());
        }
        return destination.getAbsolutePath();
    }





    private void writeScreenshotToFile(byte screenshot[], String fileName) throws IOException {
        File outFile = new File(fileName);
        FileOutputStream fout = new FileOutputStream(outFile);
        fout.write(screenshot);
        fout.flush();
        fout.close();
    }
}
