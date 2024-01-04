package Utils;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.FileNotFoundException;

public class ExtentReportsNG {

    public static com.aventstack.extentreports.ExtentReports extent;
    public static com.aventstack.extentreports.ExtentReports extentReports() throws FileNotFoundException {

        File path = new File(System.getProperty("user.dir")+"\\reports\\results.html");
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Appium Results");
        reporter.config().setDocumentTitle("Extent Results");
        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Prasanth");
        return extent;

    }

}
