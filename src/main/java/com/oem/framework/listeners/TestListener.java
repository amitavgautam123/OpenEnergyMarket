package com.oem.framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.oem.framework.core.Globals;
import com.oem.framework.core.TestExecutionContext;
import com.oem.framework.core.utils.TestUtil;
import com.oem.framework.reports.ExtentManager;
import org.apache.commons.io.IOUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Base64;

public class TestListener implements ITestListener {
    ExtentReports extent;
    public TestListener() {
        this.extent =  ExtentManager.getInstance();
    }

    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentManager.getInstance().flush();

    }

    public void onTestStart(ITestResult result) {

        ExtentManager.createMethod(result, true);
        ExtentManager.getTest().log(Status.INFO, result.getName() + " Test has Started");
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        ExtentManager.getTest().log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        ExtentManager.getTest().log(Status.FAIL, "Test Failed");
        ExtentManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
        ExtentManager.getTest().fail(result.getThrowable());
        String screenshot = TestUtil.takeScreenshot(result.getName() + "-" + getCurrentTime(), Globals.getCurrentThreadContext().getDriver());
        addScreenshotToReport(result, screenshot);

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentManager.getTest().log(Status.SKIP,"*** Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentManager.getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
        if(result.getThrowable()!=null)
            ExtentManager.getTest().skip(result.getThrowable());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }






    private String getCurrentTime(){

        return TestUtil.getCurrentTime();
    }
    private void addScreenshotToReport(ITestResult result,String screenshot){


//        MediaEntityModelProvider mediaModel = null;
        try {
            String base64Data=getBase64String(screenshot);

            // getReportUtil().fail("Test Level screenshot").addScreenCaptureFromPath(screenshot,"lets see this");
            // mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build();
            // getReportUtil().fail("Log Level screenshot", mediaModel);
            //  getReportUtil().addScreenCaptureFromBase64String(base64Data,"Failure details in screenshot");

            ExtentManager.getTest().fail("Failed screenshot",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Data).build());

        } catch (Exception e) {
            e.printStackTrace();
            ExtentManager.getTest().error("Failed to attach screenshot. There was an error. "+e.getStackTrace());
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
            if(_dyna_name!=null){
                testCase = _dyna_name;
            }
        }
      //  this.mTestCaseName = String.format("%s(%s)", method.getName(), testCase);
    }

}