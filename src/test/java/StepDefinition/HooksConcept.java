package StepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import PageObject.DFOnDemandPagePOM;
import PageObject.PageObjectForDeepFreezeSuite;
import PageObject.UtilitiesPagePOM;
import Utilities.CustomReportListener;
import Utilities.CustomTestResult;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksConcept extends BaseClass {
    ArrayList<String> tabs;
    private static boolean isLoggedIn = false;
    private static List<CustomTestResult> allResults = new ArrayList<>();
    private static int passed = 0, failed = 0, skipped = 0;

    // ---------------- BEFORE HOOKS ---------------- //

    
    @BeforeAll
    public static void setUpOnce() {
        readConfig = new ReadConfig();
        log = LogManager.getLogger("StepDefinitionForDeepFreezeSuites");
        log = LogManager.getLogger("UtilitiesPageStepDefinition");
        log = LogManager.getLogger("DFOnDemandPageStepDefinition");
        log.info("⚙️ Global setup done once before all scenarios.");
    }


    @Before(order = 0)
    public void ensureBrowserAndLogin() {
        try {
            boolean browserNotRunning = (driver == null || ((RemoteWebDriver) driver).getSessionId() == null);

            if (browserNotRunning) {
               
                log.info("🌐 Browser not running. Launching new browser instance...");
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
                isLoggedIn = false; // fresh session => login required
            }

            if (!isLoggedIn) {
                
                log.info("🔐 Performing login...");
                driver.get(readConfig.getURL());

                DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
                UtilitiesPagePg = new UtilitiesPagePOM(driver);

                DeepFreezeSuitePg.enterEmailID(readConfig.getUsername());
                DeepFreezeSuitePg.clickonNextBtn();
                DeepFreezeSuitePg.enterPass(readConfig.getPassword());
                DeepFreezeSuitePg.clickonLoginBtn();

                isLoggedIn = true;
                log.info("✅ Login completed successfully.");
            } else {
                log.info("🔄 Already logged in. Continuing with existing session.");
            }

        } catch (Exception e) {
            log.error("❌ Error in ensureBrowserAndLogin: " + e.getMessage());
            throw new RuntimeException("Failed to ensure browser/login state", e);
        }
    }

    @Before(order = 1)
    public void initPageObjects() {
        if (DeepFreezeSuitePg == null) DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
        log.info("📄 DeepFreezeSuitePOM PageObjects initialized.");
        if (UtilitiesPagePg == null) UtilitiesPagePg = new UtilitiesPagePOM(driver);
        log.info("📄 UtilitiesPagePOM PageObjects initialized.");
        if (DFOnDemandPagePg == null) DFOnDemandPagePg = new DFOnDemandPagePOM(driver);
        log.info("📄 DFOnDemandPagePOM PageObjects initialized.");
    }

    // ---------------- AFTER HOOKS ---------------- //
    @AfterStep
    public void addScreenshotOnFailure(Scenario scenario) {
        try {
            if (scenario.isFailed() && driver != null) {
                // Check if browser session is still active
                if (((RemoteWebDriver) driver).getSessionId() != null && driver.getWindowHandles().size() > 0) {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", scenario.getName());
                    log.info("📸 Screenshot attached for failed step: " + scenario.getName());
                } else {
                    log.warn("⚠️ Cannot capture screenshot: Browser window already closed for " + scenario.getName());
                }
            }
        } catch (Exception e) {
            log.error("❌ Failed to capture screenshot for scenario: " + scenario.getName() + " | Reason: " + e.getMessage());
        }
    }


    @After
    public void captureScenarioResult(Scenario scenario) {
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
                "Faronics Deep Freeze",
                "Regression Test",
                passed, failed, skipped,
                allResults
            );
            log.info("📊 Custom HTML report generated in target/custom-reports/");
        } catch (IOException e) {
            log.error("❌ Error generating custom report: " + e.getMessage());
        }
    }
}
