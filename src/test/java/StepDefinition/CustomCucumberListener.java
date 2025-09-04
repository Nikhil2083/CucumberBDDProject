package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Utilities.TestRecord;
import java.util.ArrayList;
import java.util.List;

public class CustomCucumberListener {

    public static List<TestRecord> testRecords = new ArrayList<>();

    @After
    public void afterScenario(Scenario scenario) {
        String status = scenario.isFailed() ? "FAIL" : "PASS";
        String logs = "Execution logs here"; // fetch from Log4j2 if needed
        String screenshotPath = null;

        if (scenario.isFailed()) {
            screenshotPath = "target/screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png";
            byte[] screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            // Optionally save to file system
        }

        testRecords.add(new TestRecord(
            scenario.getName(),
            status,
            "Chrome",
            "116.0",
            0, // duration
            "startTime",
            "endTime",
            logs,
            screenshotPath
        ));
    }
}
