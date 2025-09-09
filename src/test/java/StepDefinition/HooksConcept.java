package StepDefinition;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utilities.ReadConfig;
import Utilities.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import Utilities.CustomReportListener;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.PageObjectForDeepFreezeSuite;
import PageObject.UtilitiesPagePOM;
import Utilities.CustomReportListener;
import Utilities.CustomTestResult;
import Utilities.ReadConfig;
import Utilities.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;


public class HooksConcept extends BaseClass{
	ArrayList<String> tabs;
    private static boolean isLoggedIn = false;
    PageObjectForDeepFreezeSuite df = new PageObjectForDeepFreezeSuite(driver);
    private static List<CustomTestResult> allResults = new ArrayList<>();
    private static int passed = 0, failed = 0, skipped = 0;

    
 // ---------------- BEFORE HOOKS ---------------- //
@BeforeAll
    public static void setUp() {
        readConfig = new ReadConfig();
        String browser = readConfig.getBrowser();
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "msedge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser in config: " + browser);
        }
        driver.manage().window().maximize();
        log = LogManager.getLogger("StepDefinitionForDeepFreezeSuites");
        log = LogManager.getLogger("StepDefinitionForDeepFreezeSuites");
        
        log.info("✅ Browser launched once before all scenarios.");
    }
    
@Before(order = 1)
public void loginIfNotDone() {
    if (!isLoggedIn) {
        driver.get(readConfig.getURL());

        DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
        UtilitiesPagePg = new UtilitiesPagePOM(driver);

        DeepFreezeSuitePg.enterEmailID(readConfig.getUsername());
        DeepFreezeSuitePg.clickonNextBtn();
        DeepFreezeSuitePg.enterPass(readConfig.getPassword());
        DeepFreezeSuitePg.clickonLoginBtn();

        isLoggedIn = true;
        log.info("🔐 Login completed");
    }
}

    @Before(order = 2)
    public void initPageObjects() {
        if (DeepFreezeSuitePg == null) DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
        if (UtilitiesPagePg == null) UtilitiesPagePg = new UtilitiesPagePOM(driver);
        log.info("📄 All PageObjects initialized");
    }

    // ---------------- AFTER HOOKS ---------------- //
    @AfterStep
    public void addScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            log.info("📸 Screenshot attached for failed step: " + scenario.getName());
            System.err.println("Screenshot attached for failed step");
        }
    }

    @After
    public void captureScenarioResult(Scenario scenario) throws InterruptedException {
        // Screenshot if failed
//        if (scenario.isFailed()) {
//            Thread.sleep(1000);
//            ScreenshotUtil.capture(driver, scenario.getName());
//            Thread.sleep(2000);
//            log.info("📸 Captured screenshot for failed scenario: " + scenario.getName());
//        }
        // Collect results
        String status;
        if (scenario.isFailed()) {
            status = "FAIL";
            failed++;
            log.info("❌ Scenario failed: " + scenario.getName());
        } else if (scenario.getStatus().toString().equalsIgnoreCase("SKIPPED")) {
            status = "SKIP";
            skipped++;
            log.info("⏭️ Scenario skipped: " + scenario.getName());
        } else {
            status = "PASS";
            passed++;
            log.info("✅ Scenario passed: " + scenario.getName());
        }
        allResults.add(new CustomTestResult(scenario.getName(), List.of(status)));
    }

    @AfterAll
    public static void tearDownAfterAll() {
        if (driver != null) {
            driver.quit();
            log.info("🛑 Browser closed after all scenarios.");
        }
        try {
            CustomReportListener.generateReport(
                "Faronics Deep Freeze",   // $SUITE_NAME
                "Regression Test",     // $TEST_NAME
                passed, failed, skipped,
                allResults
            );
            log.info("📊 Custom HTML report generated in target/custom-reports/");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("❌ Error generating custom report: " + e.getMessage());
        }
    }
}