package com.raj.framework.core;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TestExecutionContext implements Base {
    private final String testName;
    private final WebDriver driver;
    HashMap<String, String> configForExecutionEnvironment;

    public TestExecutionContext(String testName) {
        this.testName = testName;
        this.driver = DriverManager.getDriver();
        configForExecutionEnvironment=Globals.configForExecutionEnvironment;
        Globals.addContext(Thread.currentThread().getId(), this);

        getLogger().debug(String.format("%s - TestExecution context created", testName));
    }

    public String getTestName() {
        return testName;
    }


    public WebDriver getDriver() {
        return driver;
    }


    public String getConfig(String key){
        return configForExecutionEnvironment.get(key);
    }


}
