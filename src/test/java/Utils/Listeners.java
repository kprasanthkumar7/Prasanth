package Utils;

import Pageobjects.AbstractPage.AbstractClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Listeners implements ITestListener{

    ExtentTest test;
    ExtentReports extent;

    {
        try {
            extent = ExtentReportsNG.extentReports();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        AppiumDriver driver;
        try {
            driver = (AppiumDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        try {
            test.addScreenCaptureFromPath(takeScreenShot(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String takeScreenShot(String testCase, AppiumDriver driver) throws IOException {
        File source =driver.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\Reports\\"+testCase+".png";
        FileUtils.copyFile(source, new File(path));
        return path;


    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
