package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize ExtentReports (एकदा कॉल करा, उदा. @BeforeSuite मध्ये)
    public static void initExtentReports(String reportPath) {
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    // Test सुरू करण्यासाठी
    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    // Log step मेथड
    public static void logStep(Status status, String message) {
        if (test != null) {
            test.log(status, message);
        } else {
            System.out.println("ExtentTest not initialized!");
        }
    }

    // Report flush करण्यासाठी (उदा. @AfterSuite मध्ये)
    public static void flush() {
        extent.flush();
    }
}
