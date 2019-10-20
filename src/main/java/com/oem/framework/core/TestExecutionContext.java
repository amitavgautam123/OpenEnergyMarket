package com.oem.framework.core;

import com.aventstack.extentreports.ExtentTest;
import com.oem.framework.core.base.Base;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.HashMap;

public class TestExecutionContext implements Base {
    private String testName;
    ExtentTest extentTest;
    private WebDriver driver;
    HashMap<String, String> configForExecutionEnvironment;

    public TestExecutionContext(String testName) throws IOException {
        setTestName(testName);
        getDriverAndAddToContext();
        getLogger().debug(String.format("%s - TestExecution context created", testName));
    }

    public String getTestName() {
        return testName;
    }


    public WebDriver getDriver() {
        return driver;
    }

    private void getDriverAndAddToContext() throws IOException {
        if(Globals.getTestExecutionContext(Thread.currentThread().getId())==null) {
            this.driver = DriverManager.getDriver();
            configForExecutionEnvironment = Globals.configForExecutionEnvironment;
            Globals.addContext(Thread.currentThread().getId(), this);
        }

    }

    public String getConfig(String key){
        return configForExecutionEnvironment.get(key);
    }


    public ExtentTest getExtentTest() {
        return extentTest;
    }
    public void setTestName(String testName){
        this.testName=testName;
        if(StringUtils.isNotEmpty(this.testName))
            extentTest = Globals.extent.createTest(this.testName);

    }
}
