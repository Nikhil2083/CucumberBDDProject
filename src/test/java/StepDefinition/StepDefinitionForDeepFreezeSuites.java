package StepDefinition;

import java.io.File;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	ArrayList<String> tabs;
	private static boolean isLoggedIn = false;
	PageObjectForDeepFreezeSuite df = new PageObjectForDeepFreezeSuite(driver);

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
            driver.get(readConfig.getURL());
            DeepFreezeSuitePg = new PageObjectForDeepFreezeSuite(driver);
            DeepFreezeSuitePg.enterEmailID(readConfig.getUsername());
            DeepFreezeSuitePg.clickonNextBtn();
            DeepFreezeSuitePg.enterPass(readConfig.getPassword());
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
            Thread.sleep(20000);
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

    
    
    
    
    
 ///////////////////User Management Page/////////////////////////////////////////////////
    
    @Then("open email destination: {string}")
    public void open_email_destination(String url) throws InterruptedException {
        String originalWindow = driver.getWindowHandle();

        ((JavascriptExecutor) driver).executeScript("window.open();");
        tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to GuerrillaMail tab (2nd tab)
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
        log.info("Opened email site: " + url);
        Thread.sleep(5000); // Ideally use explicit wait
    }
 
    @Then("click forget me button on gurrilla page")
    public void click_forget_me_button_on_gurrilla_page() throws InterruptedException {
       DeepFreezeSuitePg.clickonforgetmebtn();
       Thread.sleep(1000); 
    }
    @Then("Enter name: {string}")
    public void enter_name(String Nikhil) throws InterruptedException {
        DeepFreezeSuitePg.clickondomaintxtbox();
    }
      @Then("click on set button")
    public void click_on_set_button() throws InterruptedException {
        DeepFreezeSuitePg.clickonsetbuttong();
    }
    
    
    @Then("uncheck Scramble Address option")
    public void uncheck_scramble_address_option() {
        DeepFreezeSuitePg.uncheckscambleaddress();
    }
    @Then("click on the invitation email from deepfreeze")
    public void click_on_the_invitation_email_from_deepfreeze() throws InterruptedException {
        DeepFreezeSuitePg.clickoninvitemail();
        Thread.sleep(2000); 
    }
    @Then("Click on invite link for password change")
    public void click_on_invite_link_for_password_change()throws InterruptedException {
        
    	DeepFreezeSuitePg.clickoninvitelink();

        // After clicking, new tab opens → switch to it (3rd tab)
        Thread.sleep(3000); // wait for new tab
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2)); // Set Password window
        log.info("Switched to Set Password tab");
        Thread.sleep(2000); 
    }
    @Then("On Set Password page enter New Password {string}")
    public void on_set_password_page_enter_new_password(String string) {
        DeepFreezeSuitePg.enternewpassword();
    }
    @Then("Enter Confirm New Password {string}")
    public void enter_confirm_new_password(String string) {
       DeepFreezeSuitePg.enterconfirmpassword();
    }
    @Then("Click on OK")
    public void click_on_ok() throws InterruptedException {
    	DeepFreezeSuitePg.enterokbtn();
    	Thread.sleep(1000); 
    	
                        
        log.info("Switched back to original Deep Freeze tab");
        Thread.sleep(1000); 
    }
    @Then("Click on SignIN")
    public void click_on_sign_in() {
    	 DeepFreezeSuitePg.clickonLoginBtn();
         log.info("Clicked on SignIN.");
    }
    @Then("On My Profile page click on save button")
    public void on_my_profile_page_click_on_save_button() throws InterruptedException {
       DeepFreezeSuitePg.onmyprofilepageclickonsavebtn();
       Thread.sleep(4000); 
       DeepFreezeSuitePg.onmainpageclickonadgotitbtn();
    }
    @Then("Verified following user are logged in {string}")
    public void verified_following_user_are_logged_in(String string) {
        DeepFreezeSuitePg.verifyLoggedInUser();
        // Close Guerrilla tab (2nd tab)
        driver.switchTo().window(tabs.get(1));
        driver.close();
        
    }
    
    
    
    
    
    @Then("click on current user")
    public void click_on_current_user() throws InterruptedException{
        DeepFreezeSuitePg.clickoncurrentuser();
    }
    @Then("Click on USER MANAGEMENT")
    public void click_on_user_management() {
        DeepFreezeSuitePg.clickonusermanagementbtn();
    }
    @Then("on USER MANAGEMENT page click on Add User dropdown and select Add New User")
    public void on_user_management_page_click_on_add_user_dropdown_and_select_add_new_user() throws InterruptedException {
        DeepFreezeSuitePg.clickonadduserdropdown();
        Thread.sleep(2000);
        DeepFreezeSuitePg.clickonaddnewuser();
        Thread.sleep(2000);
    }
    @Then("On Add User popup window enter First Name:{string}")
    public void on_add_user_popup_window_enter_first_name(String string) {
    	DeepFreezeSuitePg.enterfirstname();
    }
    @Then("Enter Last Name:{string}")
    public void enter_last_name(String string) {
        DeepFreezeSuitePg.enterlastname();
    }
      
     
    @Then("Enter Email: {string}")
    public void enter_email(String string) throws InterruptedException {
    	  DeepFreezeSuitePg.enteremail();
          Thread.sleep(2000);
    }
    @Then("Click OK")
    public void click_ok() throws InterruptedException {
    	 DeepFreezeSuitePg.okbtn();
    	 Thread.sleep(5000);
    }
    
    @Then("New user added successfully")
    public void new_user_added_successfully() throws InterruptedException {
        DeepFreezeSuitePg.verifyUserAddedInTable("nikhil@sharklasers.com");
        Thread.sleep(2000);
    }
    
   /////////////////////////////// Tags Management Page//////////////////////////////
    
    @Then("Click Tags Management tab")
    public void click_tags_management_tab() {
        DeepFreezeSuitePg.clicktagmanagementtab();
    }
    @Then("On Tag Management page click on Add Tickets")
    public void on_tag_management_page_click_on_add_tickets() {
        DeepFreezeSuitePg.ontagmanagementpageclickonaddtickets();
    }
    
    @Then("Enter Ticket Tag under Add Ticket Tag text failed and save- {string}")
    public void enter_ticket_tag_under_add_ticket_tag_text_failed_and_save(String Test1) throws InterruptedException {
       DeepFreezeSuitePg.entertickettagunderaddtickettagtextfailedandsave();
       
    }
    
    @Then("check ticket tag is added successfully.")
    public void check_ticket_tag_is_added_successfully() throws InterruptedException {
        DeepFreezeSuitePg.checkTicketTagIsAddedSuccessfully();
    }
    
    @Then("click on delete X tab")
    public void click_on_delete_x_tab() throws InterruptedException {
    	Actions actions = new Actions(driver);

        WebElement tagElement = driver.findElement(By.xpath("//span[@class='abstractText']"));
        actions.moveToElement(tagElement).perform();
    	    	  Thread.sleep(2000);
          // 2. Locate the delete icon which becomes visible after hover
          WebElement deleteIcon = driver.findElement(By.xpath("//img[@title='Delete' and contains(@id,'deleteImage')]"));

          // 3. Click using JavaScript (since Actions.click() fails if hidden earlier)
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("arguments[0].click();", deleteIcon);

          System.out.println("✅ Clicked delete icon successfully.");
          Thread.sleep(3000);
      }
    	  
    	  
    	  
 
    @Then("Are you sure you wish to delete the tag, click on Delete")
    public void are_you_sure_you_wish_to_delete_the_tag_click_on_delete() {
       DeepFreezeSuitePg.deletetagfromtickettag();
    }
    @Then("Check Entered Ticket Tag is deleted properly")
    public void check_entered_ticket_tag_is_deleted_properly() throws InterruptedException {
    	DeepFreezeSuitePg.verifyTicketTagDeleted();
    }
    
    
    
    @Then("Click on Add Tags")
    public void click_on_add_tags() {
       DeepFreezeSuitePg.addtagnormal();
    }
    
    @Then("Enter Tag name under Add Tag text failed and save- {string}")
    public void enter_tag_name_under_add_tag_text_failed_and_save(String Test1) throws InterruptedException {
       DeepFreezeSuitePg.entertagnametextbox();
    }
    @Then("check Tag is added successfully.")
    public void check_tag_is_added_successfully() throws InterruptedException {
        DeepFreezeSuitePg.verifyTagIsAddedSuccessfully();
    }
    
    
    
    @Then("click on delete X tab on Normal Tag")
    public void click_on_delete_x_tab_on_normal_tag() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement tagElement = driver.findElement(By.xpath("//span[@class='abstractText']"));
        actions.moveToElement(tagElement).perform();
        Thread.sleep(1000); // allow UI to update

        // 2. Locate the delete icon which becomes visible after hover
        WebElement deleteIcon = driver.findElement(By.xpath("//img[@title='Delete' and contains(@id,'deleteImage')]"));

        // 3. Click using JavaScript (since Actions.click() fails if hidden earlier)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteIcon);

        System.out.println("✅ Clicked delete icon successfully.");
    }
    
    @Then("Are you sure you wish to delete the tag normal, click on Delete")
    public void are_you_sure_you_wish_to_delete_the_tag_normal_click_on_delete() {
       DeepFreezeSuitePg.deletetagfromtickettag();
    }
    @Then("Check Entered Normal Tag is deleted properly")
    public void check_entered_normal_tag_is_deleted_properly() throws InterruptedException {
        DeepFreezeSuitePg.verifyNormalTagDeleted();
    }
    
    
    
    
    @Then("Click on Add Location Tags")
    public void click_on_add_location_tags() {
        DeepFreezeSuitePg.addtaglocationtag();
    }
    
    @Then("Enter Location Tag name under Add Location Tag text failed and save- {string}")
    public void enter_location_tag_name_under_add_location_tag_text_failed_and_save(String string) throws InterruptedException {
    		DeepFreezeSuitePg.enterlocationtagname();
    }
    
    @Then("check Location Tag is added successfully.")
    public void check_location_tag_is_added_successfully() throws InterruptedException {
        DeepFreezeSuitePg.verifyTagIsAddedSuccessfullyinlocationtag();
    }
    
    @Then("click on delete X tab on Location Tag")
    public void click_on_delete_x_tab_on_location_tag() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement tagElement = driver.findElement(By.xpath("//span[@class='abstractText']"));
        actions.moveToElement(tagElement).perform();
        Thread.sleep(1000); // allow UI to update

        // 2. Locate the delete icon which becomes visible after hover
        WebElement deleteIcon = driver.findElement(By.xpath("//img[@title='Delete' and contains(@id,'deleteImage')]"));

        // 3. Click using JavaScript (since Actions.click() fails if hidden earlier)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteIcon);

        System.out.println("✅ Clicked delete icon successfully.");
    }
    @Then("Are you sure you wish to delete the tag Location, click on Delete")
    public void are_you_sure_you_wish_to_delete_the_tag_location_click_on_delete() {
        DeepFreezeSuitePg.clickondeletelocationtagbutton();
    }
    @Then("Check Entered Location Tag is deleted properly")
    public void check_entered_location_tag_is_deleted_properly() throws InterruptedException {
        DeepFreezeSuitePg.verifyLocationTagDeleted();
    }

    
  //////////////////////////////launch browser////////////////////////////////////  
    
    
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
        driver.navigate().refresh();
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

		boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 3600);
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

		boolean isDownloaded = Utilities.FileUtils.isFileDownloaded(downloadDir, expectedFileName, 3600);
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






@Then("Click on Computers Page")
public void click_on_computers_page() {
   DeepFreezeSuitePg.clickonComputersPage();
}
@Then("Goto Switch site option")
public void goto_switch_site_option() throws InterruptedException {
    DeepFreezeSuitePg.clickOnSiteDropDown();
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
    log.info("⏳ Waiting for WINSELECT to be installed and status to appear (Enabled / Outdated)...");
    boolean statusIsGreen = DeepFreezeSuitePg.waitForWinSelectInstalledAndHover(3600); // 1 hour wait
    Assert.assertTrue("❌ WINSELECT not installed or mouse hover failed.", statusIsGreen);
    log.info("✅ WINSELECT status verified and mouse hover held for 30 seconds.");
}

@Then("Mouse hover on the WINSELECT status indicator")
public void mouse_hover_on_the_winselect_status_indicator() {
    log.info("✅ Mouse hover already performed during status check.");
}


@Then("Click on product dropdown")
public void click_on_product_dropdown() {
    DeepFreezeSuitePg.ClickOnDisablePolicyDropdown();
    log.info("Click on product dropdown.");
}

@Then("Disable DeepFreeze Product- WINSELECT")
public void disable_deep_freeze_product_winselect() {
  DeepFreezeSuitePg.disabledproductfromdropdown();
  log.info("Disabled product from dropdown.");
}


@Then("check WINSELECT status indicator should be grey")
public void check_winselect_status_indicator_should_be_grey() {
    log.info("⏳ Waiting for WINSELECT to be uninstalled (status grey)...");
    boolean isUninstalled = DeepFreezeSuitePg.waitForWinSelectUninstalledAndHover(3600); // 1 hour
    Assert.assertTrue("❌ WINSELECT not uninstalled or hover failed.", isUninstalled);
    log.info("✅ WINSELECT status is grey and hover held for 30 seconds.");
}
/////////////////////////////////////////////////////////////////////////////////////////





}

