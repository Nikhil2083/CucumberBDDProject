package StepDefinition;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObject.PageObjectForDeepFreezeSuite;
import Utilities.ReadConfig;
import Utilities.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

//child class of base class
public class StepDefinitionForDeepFreezeSuites extends BaseClass {

	@Before
	public void setup() 
	{ 
	
		readConfig = new ReadConfig();
		
		
		// for logger log log4j2 log =
		LogManager.getLogger("StepDefinitionForDeepFreezeSuites");
		log = LogManager.getLogger("StepDefinitionForDeepFreezeSuites");
		
		
		String browser = readConfig.getBrowser();
		
		switch(browser.toLowerCase())
		{
		////for invoke chrome browser
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(getChromeOptions());
			break;
		
			
			//for invoke msedge browser
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		
			
			//for invoke firefoc browser
		case "firefox":
			WebDriverManager.firefoxdriver();
		    driver = new FirefoxDriver();
		    break;
		    
		default:
			driver = null;
			break;
		
		}
		
		
		
		driver.manage().window().maximize();
		System.out.println("Setup Method Executed...");
		
		log.info("Setup1 executed...");
	}
	
	@Given("Launch Chrome Browser")
	public void launch_chrome_browser() {

		DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
		log.info("user launch chrome browser");
	}

	@When("Opens URL {string}")
	public void opens_url(String url) {
		driver.get(url);
		log.info("entered URL");
	}

	@When("Enters Email as {string}")
	public void enters_email_as(String emailAddress) {
		DeepFreezeSuitePg.enterEmailID(emailAddress);
		log.info("Entered email address");
	}

	@When("Click on NextButton")
	public void click_on_next_button() {
		DeepFreezeSuitePg.clickonNextBtn();
		log.info("clicked on next");
	}

	@When("Enter Password as {string}")
	public void enter_password_as(String pwd) {
		DeepFreezeSuitePg.enterPass(pwd);
		log.info("entered password");
	}

	@When("Click on Login")
	public void click_on_login() {
		DeepFreezeSuitePg.clickonLoginBtn();
		log.info("login button hitted");
	}


	
	@Then("Page Title Should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			log.warn("Page title  matched");
			Assert.assertTrue(true);
		} else {
			log.info("page title not matched");
			Assert.assertTrue(false);
		}
	}

	@Then("click on logoutmenu")
	public void click_on_logoutmenu() {
		DeepFreezeSuitePg.clickonlogoutmenubtn();
		log.info("clicked on logoutmenu dropdown");
	}

	@Then("click on Logout")
	public void click_on_logout() throws InterruptedException {
		DeepFreezeSuitePg.clicklogoutbtn();
		Thread.sleep(2000);
		log.info("session logged out");
	}


	  @Then("Close browser")
	  public void close_browser() { 
		  if (driver != null) {
	  driver.quit(); 
	  log.info("browser quit done"); 
	  } 
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
	public void verify_agent_download() {

		String downloadDir = System.getProperty("user.dir") + File.separator + "Download";
		String expectedFileName = "FWAWebInstaller_Test.exe";

		boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 30);
		Assert.assertTrue("❌ Agent download failed!", isDownloaded);
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

		   // @After
	    public void tearDown(Scenario scenario) throws InterruptedException {
	        if (scenario.isFailed()) {
	        	Thread.sleep(4000);
	            System.out.println("❌ Scenario failed: " + scenario.getName());
	            ScreenshotUtil.capture(driver, scenario.getName());
	        }

	        if (driver != null) {
	            try {
	                driver.quit();
	            } catch (Exception e) {
	                System.out.println("🟡 Browser already closed: " + e.getMessage());
	            }
	        }
	    }
		    @AfterStep
		    	public void addScreenshot(Scenario scenario) {
		    	if(scenario.isFailed())
		    	{
		    		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		    		
		    		//attach image file report(data, media type, name of the attachment)
		    		scenario.attach(screenshot, "image/png", scenario.getName());
		    		
		    	}
		    }

			
	}

	
		

	

//	@After(order = 2)
//	public void end2()
//	{
//		driver.quit();
//		System.out.println("End Method Executed...");
//	}
//	
//	@BeforeStep
//	public void beforeStepMethosDemo()
//	{
//		System.out.println("this is before step...");
//	}
//	
//	
//	@AfterStep
//	public void afterStepMethodDemo()
//	{
//		System.out.println("this is after step...");
//	}


