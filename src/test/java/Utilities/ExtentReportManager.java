package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize ExtentReports 
    public static void initExtentReports(String reportPath) {
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

   
    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

   
    public static void logStep(Status status, String message) {
        if (test != null) {
            test.log(status, message);
        } else {
            System.out.println("ExtentTest not initialized!");
        }
    }

  
    public static void flush() {
        extent.flush();
    }
}
