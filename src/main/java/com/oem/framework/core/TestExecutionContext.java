package com.oem.framework.core;

import com.oem.framework.core.base.Base;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.HashMap;

public class TestExecutionContext implements Base {
    private String testName;
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
        TestExecutionContext context=Globals.getCurrentThreadContext();
        if(context==null) {
            this.driver = DriverManager.getDriver();
            configForExecutionEnvironment = Globals.configForExecutionEnvironment;
            Globals.addContext(Thread.currentThread().getId(), this);
        }
        else{
            // This becomes null when you close driver after class
            if(context.getDriver()==null)
                context.driver=DriverManager.getDriver();
        }

    }

    public String getConfig(String key){
        return configForExecutionEnvironment.get(key);
    }



    public void setTestName(String testName){
        this.testName=testName;


    }
}
