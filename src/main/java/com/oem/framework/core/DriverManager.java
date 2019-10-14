package com.oem.framework.core;

import com.oem.framework.core.base.Base;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class DriverManager implements Base {
    static DesiredCapabilities capabilities = null;
    static String chromeDriverPath="";
    private static final String DEFAULT_CHROME_DRIVER_DIR_PATH = Paths.get("src",
            new String[] { "test", "resources", "chromedrivers" }).toString();

    static ChromeDriverService service;

    public static WebDriver getDriver() throws IOException {

        return getChromeDriver();

    }

    public static ChromeDriver getChromeDriver() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        if(StringUtils.isEmpty(chromeDriverPath)) {
            if (StringUtils.isEmpty(Globals.getConfig("chrome.driver.path")))
                chromeDriverPath = getDriverPath();
            else
                chromeDriverPath = Globals.getConfig("chrome.driver.path");
        }

        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(chromeDriverPath))
                .usingAnyFreePort()
                .build();
        //service.start();
        
        capabilities= DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        DesiredCapabilities.chrome();
        options.merge(capabilities);

        return new ChromeDriver(service,options);
    }


    public static String getDriverPath(){
        String osName = System.getProperty("os.name").toLowerCase();
        String osPath="win";
        if(osName.contains("win"))
            osPath="win";

        if(osName.contains("linux"))
            osPath="linux";


        if(osName.contains("mac"))
            osPath="mac";

        String chromePath=Paths.get(DEFAULT_CHROME_DRIVER_DIR_PATH, new String[] { "v75", osPath }).toString();
        if(osName.contains("win"))
            chromePath=Paths.get(chromePath,"chromedriver.exe").toString();
        else
            chromePath=Paths.get(chromePath,"chromedriver").toString();

        System.out.println("Chrome driver path "+chromePath);
        return chromePath;

    }



    public static void shutDownService(){
        service.stop();
    }
}
