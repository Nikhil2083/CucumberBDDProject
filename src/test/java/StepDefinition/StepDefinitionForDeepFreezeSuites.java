package StepDefinition;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import PageObject.PageObjectForDeepFreezeSuite;
import Utilities.FileUtils;
import Utilities.ReadConfig;
import Utilities.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


//child class of base class
public class StepDefinitionForDeepFreezeSuites extends BaseClass {
	private static boolean isLoggedIn = false;
	

	////////////////////////before/////////////////////////////////////////
	
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
        log.info("✅ Browser launched once before all scenarios.");
    }

    @Before(order = 1)
    public void loginIfNotDone() {
        if (!isLoggedIn) {
            driver.get("https://www1.faronicsbeta.com/");
            DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
            DeepFreezeSuitePg.enterEmailID("nikhilguravnkil@gmail.com");
            DeepFreezeSuitePg.clickonNextBtn();
            DeepFreezeSuitePg.enterPass("Aloha@123");
            DeepFreezeSuitePg.clickonLoginBtn();

            isLoggedIn = true;
            log.info("🔐 Login performed once before all scenarios.");
        }
    }

    @Before(order = 2)
    public void initPageObjects() {
        if (DeepFreezeSuitePg == null) {
            DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
            log.info("📄 PageObject initialized.");
        }
    }
    
    
    
   /////////////////////after/////////////////////////////////// 
    
    
    @AfterStep
    public void addScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After
    public void captureScreenshot(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            Thread.sleep(1000);
            ScreenshotUtil.capture(driver, scenario.getName());
        }
    }

    @AfterAll
    public static void tearDownAfterAll() {
        if (driver != null) {
            driver.quit();
            log.info("🛑 Browser closed after all scenarios.");
        }
    }
    


//@After(order = 2)
//public void end2()
//{
//	driver.quit();
//	System.out.println("End Method Executed...");
//}
//
//@BeforeStep
//public void beforeStepMethosDemo()
//{
//	System.out.println("this is before step...");
//}
//
//
//@AfterStep
//public void afterStepMethodDemo()
//{
//	System.out.println("this is after step...");
//}

    
    
    
    
 ////////////////////////step definition code from till///////////////////////////////////
	
    @Given("Launch Chrome Browser")
	public void launch_chrome_browser() {

		DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
		log.info("user launch chrome browser");
	}


    @When("Opens URL {string}")
    public void opens_url(String url) {
        driver.get(url);
        log.info("Opened URL: " + url);
    }

    @When("Enters Email as {string}")
    public void enters_email_as(String emailAddress) {
        DeepFreezeSuitePg.enterEmailID(emailAddress);
        log.info("Entered email address.");
    }

    @When("Click on NextButton")
    public void click_on_next_button() {
        DeepFreezeSuitePg.clickonNextBtn();
        log.info("Clicked on next.");
    }

    @When("Enter Password as {string}")
    public void enter_password_as(String pwd) {
        DeepFreezeSuitePg.enterPass(pwd);
        log.info("Entered password.");
    }

    @When("Click on Login")
    public void click_on_login() {
        DeepFreezeSuitePg.clickonLoginBtn();
        log.info("Clicked on login.");
    }

    @Then("Page Title Should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            log.info("Page title matched.");
            Assert.assertTrue(true);
        } else {
            log.warn("Page title did not match. Actual: " + actualTitle);
            Assert.fail("Title mismatch");
        }
    }
    
    

    @Then("click on logoutmenu")
    public void click_on_logoutmenu() {
        DeepFreezeSuitePg.clickonlogoutmenubtn();
    }

    @Then("click on Logout")
    public void click_on_logout() throws InterruptedException {
        DeepFreezeSuitePg.clicklogoutbtn();
        Thread.sleep(2000);
    }

    @Then("Close browser")
    public void close_browser() {
        log.info("Close browser step executed but browser will close only after all scenarios.");
    }
	 
	
	
	//////////////// download policy///////////////////

	@Then("click on Policy tab")
	public void click_on_policy_tab() {

		DeepFreezeSuitePg.clickOnPolicyTabbtn();
	}

	@Then("click on Add Policy button")
	public void click_on_add_policy_button() {
		DeepFreezeSuitePg.clickonAddPolictbtn();
	}

	@Then("Select policy type Deep Freeze Windows")
	public void select_policy_type_deep_freeze_windows() {
		DeepFreezeSuitePg.selectPolicyTypeDeepFreezeWindow();
	}

	@Then("Enter Policy Name as {string}")
	public void enter_policy_name_as(String Test) {
		DeepFreezeSuitePg.PolicyName(Test);
	}

	@Then("Select DEEP FREEZE Product")
	public void select_deep_freeze_product() throws InterruptedException {
		DeepFreezeSuitePg.SelectDeepFreezeProduct();
	}

	@Then("Click for Enable DeepFreeze Product")
	public void click_for_enable_deep_freeze_product() {
		DeepFreezeSuitePg.ClickTOEnable();
	}

	@Then("Select Deep Freeze setting as {string}")
	public void select_deep_freeze_setting_as(String settingValue) throws InterruptedException {
		DeepFreezeSuitePg.selectDeepFreezeSetting(settingValue);
	}

	@Then("Save the policy")
	public void save_the_policy() throws InterruptedException {
		DeepFreezeSuitePg.SavePolicybtn();
	}

	@Then("Click on Download Agent")
	public void click_on_download_agent() {
		DeepFreezeSuitePg.DownloadAgentbtn();
	}

	@Then("Select newly created policy from Policy: dropdown")
	public void select_newly_created_policy_from_policy_dropdown() throws InterruptedException {
		DeepFreezeSuitePg.selectnNewlyCreatedPolicy();
	}

	@Then("Select download type {string}")
	public void select_download_type(String string) {
		DeepFreezeSuitePg.SelectDownloadType();
	}

	@Then("Click on Download button")
	public void click_on_download_button() throws InterruptedException {
		DeepFreezeSuitePg.Downloadbtn();
	}

	@Then("Windows installer downloaded successfully")
	public void verify_agent_download() {  String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
    String expectedFile = "FWAWebInstaller_Test.exe";

    boolean isDownloaded = FileUtils.isFileDownloaded(downloadDir, expectedFile, 30);
    Assert.assertTrue("❌ Download failed!", isDownloaded);
}

	//////////////// Download MSI installer to deploy via Active
	//////////////// Directory.///////////////
	///

	@Then("Select MSI download type {string}")
	public void select_msi_download_type(String string) {
		DeepFreezeSuitePg.SelectMSIDownloadType();
	}

	@Then("MSI installer downloaded successfully")
	public void msi_installer_downloaded_successfully() {
		String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
		String expectedFileName = "WebAgent_Test.msi";

		boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 30);
		Assert.assertTrue("❌ Agent download failed!", isDownloaded);
	}

	///////////// Download the Deployment Utility to detect and install on any
	///////////// computer.///////////////////////

	@Then("Select Deployment Utility type {string}")
	public void select_deployment_utility_type(String string) {
		DeepFreezeSuitePg.SelectDeploymentUtilityType();
	}

	@Then("Deployment Utility downloaded successfully")
	public void deployment_utility_downloaded_successfully() {
		String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
		String expectedFileName = "DeploymentUtility_Test.exe";

		boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 30);
		Assert.assertTrue("❌ Agent download failed!", isDownloaded);
	}

	@Then("Select Full Installer type {string}")
	public void select_full_installer_type(String string) {
		DeepFreezeSuitePg.SelectFullInstallerType();
	}

	@Then("Full Installer downloaded successfully")
	public void full_installer_downloaded_successfully() throws InterruptedException {

		String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
		String expectedFileName = "FullFWAWebInstaller_Test.exe";

		boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 30);
		Assert.assertTrue("❌ Agent download failed!", isDownloaded);
	}

	@Then("Click on Download button for download Full Installer")
	public void click_on_download_button_for_download_full_installer() throws InterruptedException {
		DeepFreezeSuitePg.Downloadbtnn();
	}

	
	@Then("Select downloader type- Windows Server")
	public void select_downloader_type_windows_server() 
	{
	    DeepFreezeSuitePg.SelectDownloaderTypeWindowsServer();
	}
	
	
	
	
	@Then("Windows Server Installer downloaded successfully")
	public void windows_server_installer_downloaded_successfully() throws InterruptedException {

			String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
			String expectedFileName = "FWAWebInstaller_Faronics Default Server.exe";

			boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 30);
			Assert.assertTrue("❌ Agent download failed!", isDownloaded);
		}
	
	
	@Then("Select downloader type- Mac")
	public void select_downloader_type_mac() {
	    DeepFreezeSuitePg.SelectDownloaderTypeMac();
	}
@Then("Mac Installer downloaded successfully")
public void mac_installer_downloaded_successfully() throws InterruptedException {

	String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
	String expectedFileName = "Installer.zip";

	boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 30);
	Assert.assertTrue("❌ Agent download failed!", isDownloaded);
}




//////////////////////////////////////////Product install and  uninstall using policy////////////////////////////////////////




@Then("Goto Switch site option")
public void goto_switch_site_option() throws InterruptedException {
    DeepFreezeSuitePg.clickOnSiteDropDown();
}

@Then("Click on Computers Page")
public void click_on_computers_page() {
   DeepFreezeSuitePg.clickonComputersPage();
}

@Then("Select Related Site")
public void select_related_site() {
  DeepFreezeSuitePg.SelectRelatedSite();
}

@Then("Search Computer Name {string}")
public void search_computer_name(String computerName) throws InterruptedException {
    DeepFreezeSuitePg.searchComputerByName(computerName);
}


@Then("click on assigned policy name")
public void click_on_assigned_policy_name() {
   DeepFreezeSuitePg.ClickOnPolicyName();
}

@Then("Click on DeepFreeze Product- WINSELECT")
public void click_on_deep_freeze_product_winselect() {
    DeepFreezeSuitePg.ClickONWINSELECT();
}

@Then("Click on Enable product dropdown")
public void click_on_enable_product_dropdown() {
 DeepFreezeSuitePg.ClickOnWINSELECTToEnableFromDropDown();
}


@Then("Enable DeepFreeze Product- WINSELECT")
public void enable_deep_freeze_product_winselect() {
 DeepFreezeSuitePg.ClickOnEnablePolicyDropdown();
}

@Then("Click on Save button")
public void click_on_save_button() {
    DeepFreezeSuitePg.Savebtn();
}

@Then("On Policy Update Preference window select- Notify the user immediately when the computer checks-in and restart after {int} minutes.")
public void on_policy_update_preference_window_select_notify_the_user_immediately_when_the_computer_checks_in_and_restart_after_minutes(Integer int1) {
  DeepFreezeSuitePg.checkradiobtn();
}

@Then("On Policy Update Preference window click OK")
public void on_policy_update_preference_window_click_ok() {
DeepFreezeSuitePg.clickok();
}

@Then("check WINSELECT status indicator should be green")
public void check_winselect_status_indicator_should_be_green() {
	boolean status = DeepFreezeSuitePg.waitForWinSelectInstallationStatus(3600); // Wait up to 1hr mins
    Assert.assertTrue("❌ WINSelect product was not installed within expected time.", status);
    log.info("✅ WINSelect installation verified on computers page.");
}

@Then("Mouse hover on the WINSELECT status indicator")
public void mouse_hover_on_the_winselect_status_indicator() throws InterruptedException {
    WebElement elementToHover;

    if (DeepFreezeSuitePg.WinSelectStatusEnabled.isDisplayed()) {
        elementToHover = DeepFreezeSuitePg.WinSelectStatusEnabled;
    } else {
        elementToHover = DeepFreezeSuitePg.WinSelectStatusEnabledOutdated;
    }

    Actions actions = new Actions(driver);
    actions.moveToElement(elementToHover).perform();
    log.info("Hovered on WINSelect status indicator.");
    Thread.sleep(15000);
}





}

