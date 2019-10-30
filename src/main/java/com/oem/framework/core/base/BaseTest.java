package com.oem.framework.core.base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.oem.framework.core.DriverManager;
import com.oem.framework.core.Globals;
import com.oem.framework.core.TestExecutionContext;
import com.oem.framework.core.utils.TestUtil;

import com.oem.framework.pages.HeaderPage;
import com.oem.framework.reports.ExtentManager;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;


public abstract class BaseTest implements Base {



    protected Logger logger=getLogger();
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws IOException {
        new TestExecutionContext("");

    }

    @BeforeClass(alwaysRun = true)
    public void baseClass() throws IOException {
        HeaderPage headerPage=new HeaderPage();
        if(headerPage.isLoggedIn())
            headerPage.logout();

    }


    @BeforeMethod(alwaysRun = true)
    public void baseInit(Method method, ITestContext ctx) throws IOException {
        System.out.println("Executing BaseTest before method");
        System.out.println("**************** Starting test : " + getClass().getSimpleName() +" - "+method.getName()
                + " ****************");


        if(Globals.getCurrentThreadContext()==null)
            new TestExecutionContext(method.getName());
        else
            Globals.getCurrentThreadContext().setTestName(method.getName());

        getReportUtil().info("**************** Starting test : " + getClass().getSimpleName() +" - "+method.getName()
                + " ****************");
        getReportUtil().info("***** Description "+method.getAnnotation(Test.class).description() +" ***********");


    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method method, ITestContext ctx, ITestResult result){

        String testName = method.getName();
        System.out.println(String.format("**********************************************************************************"));
        System.out.println(String.format("%s::%s - afterMethod", getClass().getSimpleName(), testName));
        System.out.println(String.format(">> Finished - %s  -   %s", getClass().getSimpleName()
                , testName));


        updateTestStatusInReport(result);

        System.out.println(String.format("Finished Test (%s) execution :: Is execution successful? : %s", testName,
                result.isSuccess()));

        System.out.println(String.format("Completed afterMethod processing for test: %s", testName));
        System.out.println(String.format("**********************************************************************************"));

        getReportUtil().debug(String.format(">> Finished - %s::%s", getClass().getSimpleName()
                , testName));
        ExtentManager.getInstance().flush();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        long threadId=Thread.currentThread().getId();
        cleanUpThread(threadId);
    }

    private void cleanUpThread(long threadId){

        Globals.getTestExecutionContext(threadId).getDriver().quit();
        Globals.remove(threadId);

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        DriverManager.shutDownService();

    }
    public ExtentTest getReportUtil(){
        long threadId=Thread.currentThread().getId();
        return Globals.getTestExecutionContext(threadId).getExtentTest();
    }

    private void updateTestStatusInReport(ITestResult result) {
        try {
            TestExecutionContext context = Globals.getCurrentThreadContext();
            String screenshot = TestUtil.takeScreenshot(result.getName() + "-" + getCurrentTime(), context.getDriver());

            if (result.getStatus() == ITestResult.FAILURE) {
                getReportUtil().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
                getReportUtil().fail(result.getThrowable());
                addScreenshotToReport(result, screenshot);
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                getReportUtil().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
            } else {
                getReportUtil().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
                if(result.getThrowable()!=null)
                    getReportUtil().skip(result.getThrowable());
            }

            ExtentManager.getInstance().flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private String getCurrentTime(){

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").format(new Date());
        return timeStamp;
    }
    private void addScreenshotToReport(ITestResult result,String screenshot){


//        MediaEntityModelProvider mediaModel = null;
        try {
            String base64Data=getBase64String(screenshot);

           // getReportUtil().fail("Test Level screenshot").addScreenCaptureFromPath(screenshot,"lets see this");
           // mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build();
           // getReportUtil().fail("Log Level screenshot", mediaModel);
          //  getReportUtil().addScreenCaptureFromBase64String(base64Data,"Failure details in screenshot");

            getReportUtil().fail("Failed screenshot",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Data).build());

        } catch (Exception e) {
            e.printStackTrace();
            getReportUtil().error("Failed to attach screenshot. There was an error. "+e.getStackTrace());
        }

        ExtentManager.getInstance().flush();
    }

    private String getBase64String(String screenshotLocation) throws Exception {
        InputStream is = new FileInputStream(screenshotLocation);
        byte[] imageBytes = IOUtils.toByteArray(is);
        Thread.sleep(1000);
        String base64 = Base64.getEncoder().encodeToString(imageBytes);
        return base64;
    }
}
