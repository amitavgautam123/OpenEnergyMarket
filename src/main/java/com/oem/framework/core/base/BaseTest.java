package com.oem.framework.core.base;

import com.oem.framework.core.DriverManager;
import com.oem.framework.core.Globals;
import com.oem.framework.core.TestExecutionContext;
import com.oem.framework.pages.HeaderPage;
import org.slf4j.Logger;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

@Listeners({com.oem.framework.listeners.CustomReporter.class,com.oem.framework.listeners.TestListener.class})
public abstract class BaseTest implements Base, ITest {

    String mTestCaseName;

    protected Logger logger = getLogger();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws IOException {
        new TestExecutionContext("");

    }

    @BeforeClass //(alwaysRun = true)
    public void baseClass() throws IOException {
        new TestExecutionContext("");
        HeaderPage headerPage = new HeaderPage();
        if (headerPage.isLoggedIn())
            headerPage.logout();

    }


    @BeforeMethod //(alwaysRun = true)
    public void baseInit(Method method, ITestContext ctx, Object[] params) throws IOException {

        updateTestNameForDataProvider(method, params);
        System.out.println("Executing BaseTest before method");
        System.out.println("**************** Starting test : " + getClass().getSimpleName() + " - " + mTestCaseName
                + " ****************");


        if (Globals.getCurrentThreadContext() == null)
            new TestExecutionContext(mTestCaseName);
        else
            Globals.getCurrentThreadContext().setTestName(method.getName());

    }


    @AfterMethod//(alwaysRun = true)
    public void afterMethod(Method method, ITestContext ctx, ITestResult result) {

        String testName = method.getName();
        System.out.println(String.format("**********************************************************************************"));
        System.out.println(String.format("%s::%s - afterMethod", getClass().getSimpleName(), testName));
        System.out.println(String.format(">> Finished - %s  -   %s", getClass().getSimpleName()
                , testName));


        System.out.println(String.format("Finished Test (%s) execution :: Is execution successful? : %s", testName,
                result.isSuccess()));

        System.out.println(String.format("Completed afterMethod processing for test: %s", testName));
        System.out.println(String.format("**********************************************************************************"));


    }

    @AfterClass//(alwaysRun = true)
    public void afterClass() {
        long threadId = Thread.currentThread().getId();
        cleanUpThread(threadId);
    }

    private void cleanUpThread(long threadId) {

        Globals.getTestExecutionContext(threadId).getDriver().quit();
        // Globals.remove(threadId);

    }

    @AfterSuite //(alwaysRun = true)
    public void afterSuite() {
        DriverManager.shutDownService();

    }


    public void updateTestNameForDataProvider(Method method, Object[] testData) {
        String testCase = "";
        if (testData != null && testData.length > 0) {
            String _dyna_name = null;
            //Check if test method has actually received required parameters
            for (Object testParameter : testData) {
                if (testParameter instanceof String) {
                    _dyna_name = (String) testParameter;
                    break;
                }
            }
            if (_dyna_name != null) {
                testCase = _dyna_name;
            }
        }
        this.mTestCaseName = String.format("%s(%s)", method.getName(), testCase);
    }

    @Override
    public String getTestName() {
        return this.mTestCaseName;
    }
}
