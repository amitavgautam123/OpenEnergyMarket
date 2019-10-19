package com.oem.framework.core;

import com.aventstack.extentreports.ExtentReports;
import com.oem.framework.core.base.Base;
import com.oem.framework.core.utils.ConfigUtils;
import com.oem.framework.reports.ExtentManager;

import java.io.IOException;
import java.util.HashMap;

public class Globals implements Base {
    private static HashMap<String, TestExecutionContext> allTestsExecutionContext;
    static HashMap<String, String> configForExecutionEnvironment;
    static ExtentReports extent;

    static  {
        System.out.println("Globals static block");
        allTestsExecutionContext = new HashMap<>();
        extent= ExtentManager.getInstance();
        try {
            configForExecutionEnvironment = loadConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exiting the program as not able to initialize");
            System.exit(1);
        }
        System.out.println("Global static block executed");
    }

    private static HashMap<String, String> loadConfiguration() throws IOException {
        HashMap<String, String> configForExecutionEnvironment = new HashMap<>();
        configForExecutionEnvironment= ConfigUtils.loadConfigs();

        return configForExecutionEnvironment;

    }

    static synchronized void addContext(long threadId, TestExecutionContext testExecutionContext) {
        allTestsExecutionContext.put(String.valueOf(threadId), testExecutionContext);
        System.out.println(String.format("Adding context for thread - %s", threadId));
    }

    public static synchronized TestExecutionContext getTestExecutionContext(long threadId) {
        return allTestsExecutionContext.get(String.valueOf(threadId));
    }

    public static synchronized void remove(long threadId) {
        System.out.println(String.format("Removing context for thread - %s", threadId));
        allTestsExecutionContext.remove(String.valueOf(threadId));
    }

    public static String getConfig(String key){
        return configForExecutionEnvironment.get(key);
    }

    public static TestExecutionContext getCurrentThreadContext(){
        long threadId=Thread.currentThread().getId();
        return getTestExecutionContext(threadId);
    }

}
