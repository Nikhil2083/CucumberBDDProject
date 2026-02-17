package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    public static String capture(WebDriver driver, String scenarioName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDir = System.getProperty("user.dir") + File.separator + "ScreenShot";
        File directory = new File(screenshotDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        // Sanitize scenarioName to avoid invalid filename characters
        String safeScenarioName = scenarioName.replaceAll("[^a-zA-Z0-9\\-_]", "_");
        String fileName = safeScenarioName + "_" + timestamp + ".png";
        String absoluteFilePath = screenshotDir + File.separator + fileName;

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE); 
        File dest = new File(absoluteFilePath);
        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved: " + absoluteFilePath);
        } catch (IOException e) {
            e.printStackTrace(); 
        } 

        // Return relative path for ExtentReports (relative to project root)
        String relativePath = "ScreenShot" + File.separator + fileName;
        relativePath = relativePath.replace("\\", "/"); // Ensure forward slashes for HTML
        return relativePath;
    }
}
