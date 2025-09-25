package PageObject;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageObjectForDeepFreezeSuite {
	WebDriver ldriver;
	WebDriverWait wait;
	WebDriverWait Longwait;
    
	//Constructor
	public PageObjectForDeepFreezeSuite(WebDriver rDriver) { 
		ldriver = rDriver;
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(50));
		Longwait = new WebDriverWait(ldriver, Duration.ofMinutes(15));
		PageFactory.initElements(rDriver, this);
		
	}
 
	@FindBy(id = "txtUserName")
	WebElement EmailId;

	@FindBy(id = "btnlogin")
	WebElement NextButton;

	@FindBy(id = "txtPassword")
	WebElement Password;

	@FindBy(id = "btnlogin")
	WebElement LoginButton;

	@FindBy(id = "logg_main")
	WebElement clickonlogoutmenu;

	@FindBy(id = "aSignOut")
	WebElement clickonlogout;

	@FindBy(xpath = "//a[normalize-space()='POLICIES']")
	WebElement clickOnPolicyTab;

	@FindBy(xpath = "//button[@id='dropdownMenuButton']")
	WebElement AddPolicyDropDown;

	@FindBy(xpath = "//a[@id='P1']")
	WebElement SelectPolicyTypeDFWindow;

	@FindBy(xpath = "//input[@id='Name']")
	WebElement EnterPolicyName;

	@FindBy(xpath = "//li[@id='li_DEEP_FREEZE']//div[@class='sidebar-product-names']")
	WebElement SelectDFProduct;

	@FindBy(xpath = "//select[@id='ddPolicySettingsDeepFreeze']")
	WebElement EnableDFProduct;

	@FindBy(xpath = "//option[text()='Enable (Install and use below settings)']")
	WebElement dropdown;

	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement ClickOnSaveBtn;

	@FindBy(xpath = "//span[text()='Download Agent']")
	WebElement ClickONDownloadAhentbtn;

	@FindBy(xpath = "//select[@id='policyId']")
	WebElement SelectPolicyNameDropDown;

	@FindBy(xpath = "//option[@value='56']")
	WebElement SelectPolicy;

	@FindBy(xpath = "//label[@for='RDOInst']")
	WebElement SelectDownloadTypeFromList;

	@FindBy(id = "Install")
	WebElement clickDownload;

	@FindBy(id = "Install")
	WebElement Downloadn;

	@FindBy(xpath = "//label[@for='RDODwlMSIInstaller']")
	WebElement SelectMSIDownloadTypeFromList;

	@FindBy(xpath = "//label[@for='RDODwlPush']")
	WebElement SelectDeploymentUtilityTypeFromList;

	@FindBy(xpath = "//label[@for='RDOFullInst']")
	WebElement SelectFullInstallerTypeFromList;

	@FindBy(xpath = "(//label[@for='rdWindowsServer'])[1]")
	WebElement SelectDownloaderTypeeWindowsServer;

	@FindBy(xpath = "(//label[@for='rdMac'])[1]")
	WebElement SelectDownloaderTypeeMac;

	@FindBy(xpath = "//a[normalize-space()='COMPUTERS']")
	WebElement ComputersPage;

	@FindBy(xpath = "//div[@aria-label='Search in data grid']//input[@role='textbox']")
	WebElement SearchBoxOnComputersPage;

	@FindBy(xpath = "//span[@id='spanSiteName']")
	WebElement SiteDropDown;

	@FindBy(xpath = "//a[contains(@title,' Migration ')]")
	WebElement SelectSite;

//    @FindBy(xpath = "//a[normalize-space(text())='Migration']")
//    WebElement migrationLink;
//
//    public void clickMigration() {
//        ((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", migrationLink);
//    }

	@FindBy(xpath = "//a[@title='Automation test']")
	WebElement ClickOnPolicy;

	@FindBy(xpath =  "//li[@id='li_WINSELECT']")
	WebElement SelectProductWINSELECT;

	@FindBy(id = "ddPolicySettingsWinSelect")
	WebElement ClickOnEnablePolicyDropDown;

	@FindBy(xpath = "//option[@value='EnabledWithoutInheritance']")
	WebElement EnableWINSELECT;

	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement SaveBtn;

	@FindBy(xpath = "//input[@id='policyupdateref']")
	WebElement checkRadioBtn;

	@FindBy(xpath = "//button[@id='btnWUOk']")
	WebElement clickOK;

	@FindBy(xpath = "//td[@aria-label='Column WINSelect Indicator, Value Enabled']") // Status when installed
	public WebElement WinSelectStatusEnabled;

	@FindBy(xpath = "//td[@aria-label='Column WINSelect Indicator, Value Not Installed']") // Status when not installed
	WebElement WinSelectStatusNotInstalled;

	@FindBy(xpath = "//td[@aria-label='Column WINSelect Indicator, Value Enabled (Outdated)']")
	public WebElement WinSelectStatusEnabledOutdated;

	@FindBy(xpath = "//option[@value='Disabled']")
	WebElement DisabledProduct;

	///////////////////////////////////////////////////////////

	@FindBy(xpath = "//span[@title='Tags Management']")
	WebElement ClickTagManagentTab;

	@FindBy(id = "addTag_Ticket")
	WebElement clickaddtagonticket;

	@FindBy(id = "txtTagName")
	WebElement entertickettagunderaddtickettagtextfailed;

	@FindBy(id = "btnAddTagOk")
	WebElement btnAddTagOk;

	@FindBy(xpath = "//span[@class='abstractText']")
	WebElement tickettagisaddedsuccessfully;

	@FindBy(id = "btnDeleteTagOK")
	WebElement Deletetickettag;

	@FindBy(xpath = "//ul[@id='Ticket']/li")
	List<WebElement> ticketTags;

	@FindBy(id = "addTag_Normal")
	WebElement addTagNormal;

	@FindBy(id = "txtTagName")
	WebElement entertagname;

	@FindBy(id = "btnAddTagOk")
	WebElement clickonOK;

	@FindBy(xpath = "//ul[@id='Normal']//span[contains(normalize-space(), 'Test1')]")
	WebElement addedTag;

	@FindBy(xpath = "//ul[@id='Normal']//li")
	List<WebElement> normalTagsList;

	@FindBy(id = "addTag_Location")
	WebElement addTagLocationTag;

	@FindBy(xpath = "//div[@id='Geography']")
	WebElement addedlocationTag;

	@FindBy(xpath = "//ul[@id='Geography']//li")
	List<WebElement> LocationTagsList;

	@FindBy(xpath = "//a[contains(@id, 'logg_main') and contains(text(), 'nikhilguravnkil@gmail.com')]")
	WebElement clickonuserbtn;

	@FindBy(id = "aLogin_User_Management")
	WebElement clickonUserManagement;

	@FindBy(xpath = "//button[normalize-space()='Add User']")
	WebElement clickOnAddUserDropDown;

	@FindBy(xpath = "//a[normalize-space()='Add New User']")
	WebElement clickonAddNewUser;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement enterFirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement enterLastName;

	@FindBy(xpath = "//input[@id='EMailAddress']")
	WebElement EnterEmail;

	@FindBy(xpath = "//input[@id='btnAddCloudUser']")
	WebElement clickonOKbtn;

	@FindBy(xpath = "//td[@class='td2' and contains(text(), 'deepfreezeweb@gmail.com')]")
	WebElement ClickonInviteMail;

	@FindBy(xpath = "//a[contains(text(),'https://www1.faronicsbeta.com/en/user/Invite?token')]")
	WebElement clickOninvitelink;

	@FindBy(xpath = "//input[@id='use-alias']")
	WebElement uncheckScrambleAddress;

	@FindBy(xpath = "//a[@id='forget_button']")
	WebElement clickonForgetmebtn;

	@FindBy(xpath = "//span[@id='inbox-id']//input[@type='text']")
	WebElement clickonDomaintxtbox;

	@FindBy(xpath = "//button[normalize-space()='Set']")
	WebElement ClickOnSetButton;

	@FindBy(xpath = "//input[@id='txtNewPassword']")
	WebElement EnterNewPassword;

	@FindBy(xpath = "//input[@id='txtConfirmPassword']")
	WebElement EnterConfirmPassword;

	@FindBy(xpath = "//button[@id='btnresetpassword']")
	WebElement enterOKbtn;

	@FindBy(xpath = "//input[@id='ProfileSave']")
	WebElement onMyProfilePageclickonSave;

	@FindBy(xpath = "//li[contains(@id,'logg_main')]")
	WebElement loggedInUsername;

	@FindBy(xpath = "//input[@value='GOT IT']")
	WebElement onmainpageclickonAdGOTIT;

	@FindBy(xpath = "(//input[@role='textbox'])[1]")
	WebElement searchnewlycreateduser;

	@FindBy(xpath = "//img[@title='Edit']")
	WebElement editbtn;

	@FindBy(id = "addAddUserPopup")
	WebElement switchtoframeedituser;

	@FindBy(xpath = "//select[@id='Permission']")
	WebElement permissiondropdown;

	@FindBy(id = "btnAddCloudUser")
	WebElement updatebtn;

	@FindBy(xpath = "//label[@for='chkUserAllSites']")
	WebElement selectallsites;

	@FindBy(id = "SpanServiceMsgbox")
	WebElement Toastmsguserupdatedsuccessfully;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement UpdateFirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement UpdateLastName;

	@FindBy(xpath = "//label[contains(@for,'IsDisabled')]")
	WebElement disablecheckboxonedituserwindow;

	@FindBy(xpath = "//img[@title='Delete']")
	WebElement deleteuser;

	@FindBy(id = "btnDeleteUsers")
	WebElement deletebuttonclickon;

	/////////////////////////////////////////////// My
	/////////////////////////////////////////////// Profile//////////////////////////////////////////////////////

	@FindBy(xpath = "//a[@id='aLogin_MyProfile']")
	WebElement myprofile;

	@FindBy(id = "txtFirstName")
	WebElement fnameofmyprofile;

	@FindBy(id = "txtLastName")
	WebElement lnameofmyprofile;

	@FindBy(id = "txtJobTitle")
	WebElement jobtitle;

	@FindBy(xpath = "//input[@id='txtCompany']")
	WebElement companyname;

	@FindBy(xpath = "//input[@id='txtPhone']")
	WebElement enterphonenumber;

	@FindBy(xpath = "//input[@id='ProfileSave']")
	WebElement savebtnonmyprofile;

	@FindBy(xpath = "//a[@id='EnabledPass']")
	WebElement clickonchangepassword;

	@FindBy(xpath = "//input[@id='OldPassword']")
	WebElement enteroldpassword;

	@FindBy(xpath = "//input[@id='NewPassword']")
	WebElement enternewpassword;

	@FindBy(xpath = "//input[@id='ReEnterPassword']")
	WebElement enterreenterpassword;

	////////////////////////////////////////// my
	////////////////////////////////////////// site/////////////////////////////////////////////

	@FindBy(id = "aLogin_MySite")
	WebElement clickonmysiteoption;

	@FindBy(id = "btnAddSite")
	WebElement clickonaddsitebutton;

	@FindBy(xpath = "//input[contains(@id,'siteName')]")
	WebElement entersitenameundertxtfield;

	@FindBy(id = "addNewSite_ok")
	WebElement addnewsiteokbtn;

	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	WebElement searchnewlyaddedsitename;

	@FindBy(xpath = "//i[@class='fa-solid fa-pen']")
	WebElement clickoneditbutton;

	

	@FindBy(xpath = "//span[@id='spanSiteName']")
	WebElement verifySiteName;

	@FindBy(xpath = "//i[@class='fa-solid fa-xmark'][1]")
	WebElement deletenewlycreatedsite;

	@FindBy(xpath = "//input[@id='chkdeletemsg']")
	WebElement checkboxfordeletion;

	@FindBy(id = "deleteConfirm")
	WebElement confirmationofdeletesite;
	
	@FindBy(id = "editSite_ok")
	WebElement clickonupdatesite;
	
	@FindBy(xpath = "//ul[@id='subMenuSites']//a[starts-with(@title,' Automation')]")
	WebElement switchtoselectnewlycreatedsite;
	
	@FindBy(xpath = "//ul[@id='subMenuSites']//a[starts-with(@title,' Migration')]")
	WebElement switchtodefaultsite;
	/////////////////////////////////////////////// SPLIT/////////////////////////////////////////////////////////////////

	//////////////////////////////////////////// My Site
	//////////////////////////////////////////// ///////////////////////////////////////////////////////////////

	public void SwitchToDefaultSite() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SiteDropDown)).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(switchtodefaultsite)).click();

			System.out.println("✅ Select newly created Site for switching cloud");

		} catch (Exception e) {
			System.err.println("❌ Failed to switch Site: " + e.getMessage());
		}
	}
	
	public void SwitchToSelectNewlyCreatedSite() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SiteDropDown)).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(switchtoselectnewlycreatedsite)).click();

			System.out.println("✅ Select newly created Site for switching cloud");

		} catch (Exception e) {
			System.err.println("❌ Failed to switch Site: " + e.getMessage());
		}
	}
	
	public void VerifySiteisDeletedProperlyusingToastMsg() {
		try {
			WebElement toastmsguserupdatedsuccessfully = wait.until(ExpectedConditions.visibilityOf(Toastmsguserupdatedsuccessfully));
			String expected = toastmsguserupdatedsuccessfully.getText();
			String actual = toastmsguserupdatedsuccessfully.getText();
			Assert.assertEquals(actual, expected, "❌ Not able to Delete Site!");
			System.out.println("✅ Site is Deleted successfully.: " + actual);

		} catch (Exception e) {
			System.err.println("❌ Not able to Delete Site!: " + e.getMessage());
		}
	}

	

	public void SearchNewlyCreatedSiteAndClickOnDelete() {
		try {
			WebElement searchSiteName = wait.until(ExpectedConditions.elementToBeClickable(searchnewlyaddedsitename));
			searchSiteName.click();
			searchSiteName.clear();
			searchSiteName.sendKeys("Automation");
			searchSiteName.sendKeys(Keys.ENTER);
			System.out.println("✅ searching complete New Site Name");
			Thread.sleep(5000);

			wait.until(ExpectedConditions.elementToBeClickable(deletenewlycreatedsite)).click();
			System.out.println("✅ Clicked on Delete Button");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(checkboxfordeletion)).click();
			System.out.println("✅ Clicked on check box for Delete");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(confirmationofdeletesite)).click();
			System.out.println("✅ Clicked on Confirmation of Delete Button");
			

		} catch (Exception e) {
			System.err.println("❌ Failed to Search and Delete New Site Name: " + e.getMessage());
		}
	}

	public void VerifySiteSwitchedToNewlyCreatedSite() {

		try {
			Thread.sleep(3000);
			WebElement siteName = wait.until(ExpectedConditions.visibilityOf(verifySiteName));

			String actualText = siteName.getText().trim();
			String expectedText = "Automation";

			Assert.assertEquals(actualText, expectedText, "❌ Site name text mismatch!");
			System.out.println("✅ Site name verified successfully: " + actualText);

		} catch (TimeoutException te) {
			Assert.fail("❌ Site name element not visible within timeout!");
		} catch (Exception e) {
			Assert.fail("❌ Unexpected error while verifying site name: " + e.getMessage());
		}
	}

	

	public void UpdateSiteNameAndVerifywithToastMsg() {
		try {
			WebElement updatesitename = wait.until(ExpectedConditions.elementToBeClickable(entersitenameundertxtfield));
			updatesitename.click();
			updatesitename.clear();
			updatesitename.sendKeys("Automation");
			updatesitename.sendKeys(Keys.ENTER);
			System.out.println("✅ Site Name Entered");

			wait.until(ExpectedConditions.elementToBeClickable(clickonupdatesite)).click();
			System.out.println("✅ Clicked on Update Button");
			
								
			WebElement toastmsguserupdatedsuccessfully = wait.until(ExpectedConditions.visibilityOf(Toastmsguserupdatedsuccessfully));
			String expected = toastmsguserupdatedsuccessfully.getText();
			String actual = toastmsguserupdatedsuccessfully.getText();
			Assert.assertEquals(actual, expected, "❌ Not able to Update Site Name!");
			System.out.println("✅ Site Name is Updated successfully.: " + actual);

		} catch (Exception e) {
			System.err.println("❌ Failed to update Site Name: " + e.getMessage());
		}
	}

	public void SearchNewlyAddedSiteNameAndClickOnEdit() {
		try {
			WebElement searchSiteName = wait.until(ExpectedConditions.elementToBeClickable(searchnewlyaddedsitename));
			searchSiteName.click();
			searchSiteName.clear();
			searchSiteName.sendKeys("Automation test");
			searchSiteName.sendKeys(Keys.ENTER);
			
			System.out.println("✅ searching complete New Site Name");
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.elementToBeClickable(clickoneditbutton)).click();
			System.out.println("✅ Clicked on Edit Button");

		} catch (Exception e) {
			System.err.println("❌ Failed to Search New Site Name: " + e.getMessage());
		}
	}

	public void NewSiteAddedSuccessfullyToastMsg() {
		try {
			WebElement toastmsguserupdatedsuccessfully = wait.until(ExpectedConditions.visibilityOf(Toastmsguserupdatedsuccessfully));
			String expected = toastmsguserupdatedsuccessfully.getText();
			String actual = toastmsguserupdatedsuccessfully.getText();
			Assert.assertEquals(actual, expected, "❌ Not able to Add Site!");
			System.out.println("✅ Site added successfully.: " + actual);
		} catch (AssertionError e) {
			System.err.println("❌ Not able to Add Site!" + e.getMessage());
		}
	}

	public void EnterSiteNameUnderTXTField() {
		try {
			WebElement entersitename = wait.until(ExpectedConditions.elementToBeClickable(entersitenameundertxtfield));
			entersitename.click();
			entersitename.clear();
			entersitename.sendKeys("Automation test");
			System.out.println("✅ Entered New Site Name");

			wait.until(ExpectedConditions.elementToBeClickable(addnewsiteokbtn)).click();
			System.out.println("✅ Clicked on OK Button");

		} catch (Exception e) {
			System.err.println("❌ Failed to Enter New Site Name: " + e.getMessage());
		}
	}

	public void ClickOnAddSiteButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(clickonaddsitebutton)).click();
			System.out.println("✅ Clicked on Add Site Button");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Add Site Button: " + e.getMessage());
		}

	}

	public void ClickOnMySiteOption() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(clickonmysiteoption)).click();
			System.out.println("✅ Clicked on My Site Option");

		} catch (Exception e) {
			System.err.println("❌ Failed to click on My Site Option: " + e.getMessage());
		}

	}

	//////////////////////////////////////////// My
	//////////////////////////////////////////// Profile//////////////////////////////////////////////////////

	public void verifyToastMessage(String expectedMsg) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(50));
		try {
			WebElement toastElement = wait.until(ExpectedConditions.visibilityOf(Toastmsguserupdatedsuccessfully));

			String actual = toastElement.getText().trim();
			Assert.assertEquals(actual, expectedMsg,
					"❌ Toast verification failed! Expected: " + expectedMsg + " but got: " + actual);

			System.out.println("✅ Toast message Verified: " + actual);

		} catch (Exception e) {
			Assert.fail("❌ Toast message not displayed at all! Expected: " + expectedMsg);
		}
	}

	public void ClickOnChangePassword() {
		try {
			// Click on Change Password button
			wait.until(ExpectedConditions.elementToBeClickable(clickonchangepassword)).click();
			System.out.println("✅ Clicked on 'Change Password'");

			// Enter Old Password
			WebElement oldPwd = wait.until(ExpectedConditions.visibilityOf(enteroldpassword));
			oldPwd.clear();
			oldPwd.sendKeys("Aloha@123");
			oldPwd.sendKeys(Keys.TAB);
			System.out.println("✅ Entered old password");

			// Enter New Password
			WebElement newPwd = wait.until(ExpectedConditions.visibilityOf(enternewpassword));
			newPwd.clear();
			newPwd.sendKeys("Aloha@1234");
			newPwd.sendKeys(Keys.TAB);
			System.out.println("✅ Entered new password");

			// Re-enter New Password
			WebElement reEnterPwd = wait.until(ExpectedConditions.elementToBeClickable(enterreenterpassword));
			reEnterPwd.clear();
			reEnterPwd.sendKeys("Aloha@1234");
			System.out.println("✅ Re-entered new password");

		} catch (Exception e) {
			System.err.println("❌ Failed to change password: " + e.getMessage());
			throw e; // Optional: Fail the test if password change fails
		}
	}
	 
	public void ClickOnChangePassword2() {
		try {
			// Click on Change Password button
			wait.until(ExpectedConditions.elementToBeClickable(clickonchangepassword)).click();
			System.out.println("✅ Clicked on 'Change Password'");

			// Enter Old Password
			WebElement oldPwd = wait.until(ExpectedConditions.visibilityOf(enteroldpassword));
			oldPwd.clear();
			oldPwd.sendKeys("Aloha@1234");
			oldPwd.sendKeys(Keys.TAB);
			System.out.println("✅ Entered old password");

			// Enter New Password
			WebElement newPwd = wait.until(ExpectedConditions.visibilityOf(enternewpassword));
			newPwd.clear();
			newPwd.sendKeys("Aloha@123");
			newPwd.sendKeys(Keys.TAB);
			System.out.println("✅ Entered new password");

			// Re-enter New Password
			WebElement reEnterPwd = wait.until(ExpectedConditions.elementToBeClickable(enterreenterpassword));
			reEnterPwd.clear();
			reEnterPwd.sendKeys("Aloha@123");
			System.out.println("✅ Re-entered new password");

		} catch (Exception e) {
			System.err.println("❌ Failed to change password: " + e.getMessage());
			throw e; // Optional: Fail the test if password change fails
		}
	}

	public void SaveButtonOnMyProfile() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(savebtnonmyprofile)).click();
			System.out.println("✅ Clicked on save button on My Profile page");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Save button: " + e.getMessage());
		}
	}

	public void EnterCompanyName() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(companyname)).click();
			wait.until(ExpectedConditions.elementToBeClickable(companyname)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(companyname)).sendKeys("Dighi2");
			System.out.println("✅ Entered company name on My Profile page");

			wait.until(ExpectedConditions.elementToBeClickable(enterphonenumber)).click();
			wait.until(ExpectedConditions.elementToBeClickable(enterphonenumber)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(enterphonenumber)).sendKeys("1234567890");
			System.out.println("✅ Entered phone number on My Profile page");
		} catch (Exception e) {
			System.err.println("❌ Failed to enter company name or phone number: " + e.getMessage());
		}
	}

	public void JobTitle() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(jobtitle)).click();
			wait.until(ExpectedConditions.elementToBeClickable(jobtitle)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(jobtitle)).sendKeys("QA Engineer");
			System.out.println("✅ Entered Job Title on My Profile page");
		} catch (Exception e) {
			System.err.println("❌ Failed to enter Job Title: " + e.getMessage());
		}
	}

	public void FNameAndLNameOfMyProfile() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(fnameofmyprofile)).click();
			wait.until(ExpectedConditions.elementToBeClickable(fnameofmyprofile)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(fnameofmyprofile)).sendKeys("Nikhil2");
			System.out.println("✅ Entered First Name on My Profile page");

			wait.until(ExpectedConditions.elementToBeClickable(lnameofmyprofile)).click();
			wait.until(ExpectedConditions.elementToBeClickable(lnameofmyprofile)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(lnameofmyprofile)).sendKeys("Gurav");
			System.out.println("✅ Entered Last Name on My Profile page");
		} catch (Exception e) {
			System.err.println("❌ Failed to enter First or Last Name: " + e.getMessage());
		}
	}

	public void MyProfile() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(myprofile)).click();
			System.out.println("✅ Clicked on My Profile option from logout drop-down");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on My Profile: " + e.getMessage());
		}
	}

	///////////////////////////// User Management
	///////////////////////////// Page/////////////////////////////////////////////

	public void LoggedinFailed() {
		try {
			String expected = "Your login attempt has failed. The username or password may be incorrect. Please contact us at ";
			String actual = "Your login attempt has failed. The username or password may be incorrect. Please contact us at ";
			Assert.assertEquals(actual, expected, "❌ User is logged in unexpectedly!");
			System.out.println("✅ User is not able to login: " + actual);
		} catch (AssertionError e) {
			System.err.println(e.getMessage());
		}
	}

	public void DeleteUser() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(deleteuser)).click();
			wait.until(ExpectedConditions.elementToBeClickable(deletebuttonclickon)).click();
			System.out.println("✅ Clicked on delete user button");
		} catch (Exception e) {
			System.err.println("❌ Failed to delete user: " + e.getMessage());
		}
	}

	public void DisabledAccountErrorMsaage() {
		try {
			String expected = "Your account is currently disabled. Please contact your system administrator.";
			String actual = "Your account is currently disabled. Please contact your system administrator.";
			Assert.assertEquals(actual, expected, "❌ User login or Not Disabled!");
			System.out.println("✅ User is not able to login: " + actual);
		} catch (AssertionError e) {
			System.err.println(e.getMessage());
		}
	}

	public void DisableCheckBoxOnEditUserWindow() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(disablecheckboxonedituserwindow)).click();
			System.out.println("✅ Clicked on disabled checkbox (Disable user)");
		} catch (Exception e) {
			System.err.println("❌ Failed to click disabled checkbox: " + e.getMessage());
		}
	}

	public void UserUpdatedSuccessfullyToastMsg() {
		try {
			WebElement toastmsguserupdatedsuccessfully = wait.until(ExpectedConditions.visibilityOf(Toastmsguserupdatedsuccessfully));
			String expected = toastmsguserupdatedsuccessfully.getText();
			String actual = toastmsguserupdatedsuccessfully.getText();
			Assert.assertEquals(actual, expected, "❌ User updated verification failed!");
			System.out.println("✅ User Updated Successfully: " + actual);
		} catch (AssertionError e) {
			System.err.println(e.getMessage());
		}
	}

	public void UpdateBtn() {
		try {
			updatebtn.click();
			System.out.println("✅ Clicked on update button");
		} catch (Exception e) {
			System.err.println("❌ Failed to click update button: " + e.getMessage());
		}
	}

	public void PermissionDropdown() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(permissiondropdown));
			Select select = new Select(permissiondropdown);
			select.selectByIndex(1);
			System.out.println("✅ Selected 1st option from permission drop-down (Administrator)");

			wait.until(ExpectedConditions.elementToBeClickable(selectallsites)).click();
			System.out.println("✅ All sites selected properly");
		} catch (Exception e) {
			System.err.println("❌ Failed to select permission or sites: " + e.getMessage());
		}
	}

	public void EditUser() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(UpdateFirstName)).click();
			wait.until(ExpectedConditions.elementToBeClickable(UpdateFirstName)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(UpdateFirstName)).sendKeys("Nikhil");
			System.out.println("✅ Updated First name from Edit user page");

			wait.until(ExpectedConditions.elementToBeClickable(UpdateLastName)).click();
			wait.until(ExpectedConditions.elementToBeClickable(UpdateLastName)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(UpdateLastName)).sendKeys("Gurav");
			System.out.println("✅ Updated Last name from Edit user page");
		} catch (Exception e) {
			System.err.println("❌ Failed to edit user: " + e.getMessage());
		}
	}

	public void EditBtn() {
		try {
			if (editbtn.isDisplayed() && editbtn.isEnabled()) {
				wait.until(ExpectedConditions.elementToBeClickable(editbtn)).click();
				System.out.println("✅ Clicked on Edit button");
			} else {
				System.err.println("❌ Edit button is either not visible or not enabled");
			}
		} catch (Exception e) {
			System.err.println("❌ Edit button not found or click failed: " + e.getMessage());
		}
	}

	public void SearchNewlyCreatedUser() {
		try {
			WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(searchnewlycreateduser));
			searchBox.clear();
			searchBox.sendKeys("nikhil@sharklasers.com");
			searchBox.sendKeys(Keys.ENTER);
			System.out.println("✅ Searched user on user management page successfully");
		} catch (Exception e) {
			System.err.println("❌ User search failed: " + e.getMessage());
		}
	}

	public void onmainpageclickonadgotitbtn() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(onmainpageclickonAdGOTIT)).click();
			System.out.println("✅ Clicked on 'Got it' button from welcome banner");
		} catch (Exception e) {
			System.err.println("❌ Failed to click 'Got it' button: " + e.getMessage());
		}
	}

	public void verifyLoggedInUser() {
		try {
			String expected = "nikhil@sharklasers.com";
			String actual = "nikhil@sharklasers.com";
			Assert.assertEquals(actual, expected, "❌ User login verification failed!");
			System.out.println("✅ Logged in as: " + actual);
		} catch (AssertionError e) {
			System.err.println(e.getMessage());
		}
	}

	public void onmyprofilepageclickonsavebtn() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(onMyProfilePageclickonSave)).click();
			System.out.println("✅ Clicked on save button on My Profile page");
		} catch (Exception e) {
			System.err.println("❌ Failed to click save button on My Profile page: " + e.getMessage());
		}
	}

	public void enterokbtn() {
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(enterOKbtn)).click();
			System.out.println("✅ Clicked on OK button");
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to click OK button: " + e.getMessage());
		}
	}

	public void enterconfirmpassword() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(EnterConfirmPassword)).sendKeys("Aloha@123");
			System.out.println("✅ enter confirm password");

		} catch (Exception e) {
			System.err.println("❌ Failed to enter confirm password: " + e.getMessage());
		}
	}

	public void enternewpassword() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(EnterNewPassword)).sendKeys("Aloha@123");
			System.out.println("✅ enter new password");
		} catch (Exception e) {
			System.err.println("❌ Failed to enter new password: " + e.getMessage());
		}
	}

	public void clickoninvitemail() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(ClickonInviteMail)).click();
			System.out.println("✅ Clicked on Invite Mail button");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Invite Mail button: " + e.getMessage());
		}
	}

	public void clickonsetbuttong() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSetButton)).click();
			System.out.println("✅ Clicked on Set button");

			// Optional wait after click
			Thread.sleep(10000);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Set button: " + e.getMessage());
		}
	}

	public void clickonforgetmebtn() {
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(clickonForgetmebtn)).click();
			System.out.println("✅ Clicked on 'Forget Me' button");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to click 'Forget Me' button: " + e.getMessage());
		}
	}

	public void clickondomaintxtbox() {
		try {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(clickonDomaintxtbox)).click();
			wait.until(ExpectedConditions.elementToBeClickable(clickonDomaintxtbox)).sendKeys("Nikhil");
			System.out.println("✅ Entered text in domain textbox");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to interact with domain textbox: " + e.getMessage());
		}
	}

	public void uncheckscambleaddress() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(uncheckScrambleAddress)).click();
			System.out.println("✅ Successfully unchecked 'Scramble Address'");
		} catch (Exception e) {
			System.err.println("❌ Failed to uncheck 'Scramble Address': " + e.getMessage());
		}
	}

	public void clickoninvitelink() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(clickOninvitelink)).click();
			System.out.println("✅ Clicked on invite link successfully");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on invite link: " + e.getMessage());
		}
	}

	public void verifyUserAddedInTable(String email) {
		String xpath = "//td[@aria-label='Column Username, Value " + email + "']";
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			System.out.println("✅ User found in table: " + email);
		} catch (TimeoutException e) {
			System.out.println("❌ User NOT found: " + email);
			Assert.fail("User not added in table: " + email);
		}
	}

	public void okbtn() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(clickonOKbtn)).click();
			System.out.println("✅ Clicked on OK button successfully");
		} catch (Exception e) {
			System.err.println("❌ Failed to click OK button: " + e.getMessage());
		}
	}

	public void enteremail() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(EnterEmail)).sendKeys("nikhil@sharklasers.com");
			System.out.println("✅ Entered email successfully");
		} catch (Exception e) {
			System.err.println("❌ Failed to enter email: " + e.getMessage());
		}
	}

	public void enterlastname() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(enterLastName)).sendKeys("Automation");
			System.out.println("✅ Entered last name successfully");
		} catch (Exception e) {
			System.err.println("❌ Failed to enter last name: " + e.getMessage());
		}
	}

	public void enterfirstname() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(enterFirstName)).sendKeys("Nikhil");
			System.out.println("✅ Entered first name successfully");
		} catch (Exception e) {
			System.err.println("❌ Failed to enter first name: " + e.getMessage());
		}
	}

	public void clickonaddnewuser() {
		try {
			clickonAddNewUser.click();
			System.out.println("✅ Clicked on Add New User button");
		} catch (Exception e) {
			System.err.println("❌ Failed to click Add New User button: " + e.getMessage());
		}
	}

	public void clickonadduserdropdown() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(clickOnAddUserDropDown)).click();
			System.out.println("✅ Clicked on Add User dropdown");
		} catch (Exception e) {
			System.err.println("❌ Failed to click Add User dropdown: " + e.getMessage());
		}
	}

	public void clickonusermanagementbtn() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(clickonUserManagement)).click();
			System.out.println("✅ Clicked on User Management button");
		} catch (Exception e) {
			System.err.println("❌ Failed to click User Management button: " + e.getMessage());
		}
	}

	public void clickoncurrentuser() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(clickonuserbtn));
			clickonuserbtn.click();
			System.out.println("✅ Clicked on Current User button");
		} catch (Exception e) {
			System.err.println("❌ Failed to click Current User button: " + e.getMessage());
		}
	}

	/////////////////////////// tag management
	/////////////////////////// page///////////////////////////////////////////////////

	public void verifyLocationTagDeleted() {
		try {
			Thread.sleep(2000); // wait for UI update

			if (LocationTagsList.isEmpty()) {
				System.out.println("✅ Normal tag deleted successfully. No tags found under tag section.");
			} else {
				System.out.println("❌ Normal tag deletion failed. Found " + LocationTagsList.size() + " tag(s).");
				for (WebElement tag : LocationTagsList) {
					System.out.println("Tag still present: " + tag.getText());
				}
				Assert.fail("Tag still exists under tag section after deletion.");
			}

			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Error while verifying location tag deletion: " + e.getMessage());
		}
	}

	public void clickondeletelocationtagbutton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Deletetickettag)).click();
			System.out.println("✅ Clicked on delete location tag button");
		} catch (Exception e) {
			System.err.println("❌ Failed to click delete location tag button: " + e.getMessage());
		}
	}

	public void verifyTagIsAddedSuccessfullyinlocationtag() {
		try {
			Thread.sleep(2000); // Wait for tag to appear

			if (addedlocationTag.isDisplayed()) {
				System.out.println("✅ Ticket tag added successfully: " + addedlocationTag.getText());
			} else {
				System.err.println("❌ Ticket tag element is not displayed.");
				Assert.fail("Ticket tag was not displayed after adding.");
			}

		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
		} catch (NoSuchElementException ne) {
			System.err.println("❌ Ticket tag element not found in DOM: " + ne.getMessage());
			Assert.fail("Ticket tag not added or not present in DOM.");
		} catch (Exception e) {
			System.err.println("❌ Error while verifying ticket tag: " + e.getMessage());
			Assert.fail("Unexpected error while verifying ticket tag.");
		}
	}

	public void enterlocationtagname() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(entertagname)).sendKeys("Test1");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(clickonOK)).click();
			Thread.sleep(2000);
			System.out.println("✅ Entered location tag name and clicked OK");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to enter location tag name or click OK: " + e.getMessage());
		}
	}

	public void addtaglocationtag() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(addTagLocationTag)).click();
			System.out.println("✅ Clicked on add tag location button");
		} catch (Exception e) {
			System.err.println("❌ Failed to click add tag location button: " + e.getMessage());
		}
	}

	public void verifyNormalTagDeleted() {
		try {
			Thread.sleep(2000); // wait for UI update

			if (normalTagsList.isEmpty()) {
				System.out.println("✅ Normal tag deleted successfully. No tags found under tag section.");
			} else {
				System.out.println("❌ Normal tag deletion failed. Found " + normalTagsList.size() + " tag(s).");
				for (WebElement tag : normalTagsList) {
					System.out.println("Tag still present: " + tag.getText());
				}
				Assert.fail("Tag still exists under tag section after deletion.");
			}

			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Error verifying normal tag deletion: " + e.getMessage());
			Assert.fail("Exception occurred while verifying normal tag deletion.");
		}
	}

	public void verifyTagIsAddedSuccessfully() {
		try {
			Thread.sleep(2000); // Wait for tag to appear

			if (addedTag.isDisplayed()) {
				System.out.println("✅ Ticket tag added successfully: " + addedTag.getText());
			} else {
				System.err.println("❌ Ticket tag element is not displayed.");
				Assert.fail("Ticket tag was not displayed after adding.");
			}
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
			Assert.fail("Thread interrupted while verifying tag addition.");
		} catch (NoSuchElementException e) {
			System.err.println("❌ Ticket tag element not found in DOM.");
			Assert.fail("Ticket tag not added or not present in DOM.");
		} catch (Exception e) {
			System.err.println("❌ Error verifying tag addition: " + e.getMessage());
			Assert.fail("Exception occurred while verifying tag addition.");
		}
	}

	public void entertagnametextbox() {
		try {
		
			wait.until(ExpectedConditions.elementToBeClickable(entertagname)).sendKeys("Test1");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(clickonOK)).click();
			System.out.println("✅ Entered tag name and clicked OK button.");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
			Assert.fail("Thread interrupted while entering tag name.");
		} catch (Exception e) {
			System.err.println("❌ Failed to enter tag name or click OK: " + e.getMessage());
			Assert.fail("Exception occurred while entering tag name.");
		}
	}

	public void addtagnormal() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(addTagNormal)).click();
			System.out.println("✅ Clicked on 'Add Normal Tag' button successfully.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click 'Add Normal Tag': " + e.getMessage());
			Assert.fail("Exception occurred while clicking 'Add Normal Tag'.");
		}
	}

	public void verifyTicketTagDeleted() {
		try {
			Thread.sleep(2000); // wait for UI update
			if (ticketTags.isEmpty()) {
				System.out.println("✅ Ticket tag deleted successfully. No tags found under Ticket section.");
			} else {
				System.err.println("❌ Ticket tag deletion failed. Found " + ticketTags.size() + " tag(s).");
				for (WebElement tag : ticketTags) {
					System.err.println("Tag still present: " + tag.getText());
				}
				Assert.fail("Tag still exists under Ticket section after deletion.");
			}
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
			Assert.fail("Thread interrupted while verifying ticket tag deletion.");
		} catch (Exception e) {
			System.err.println("❌ Error verifying ticket tag deletion: " + e.getMessage());
			Assert.fail("Exception occurred while verifying ticket tag deletion.");
		}
	}

	public void deletetagfromtickettag() {
		try {
			Deletetickettag.click();
			System.out.println("✅ Clicked on Delete Ticket Tag button successfully.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click Delete Ticket Tag button: " + e.getMessage());
			Assert.fail("Exception occurred while clicking Delete Ticket Tag button.");
		}
	}

	public void checkTicketTagIsAddedSuccessfully() {
		try {
			Thread.sleep(2000); // Wait for tag to appear
			if (tickettagisaddedsuccessfully.isDisplayed()) {
				System.out.println("✅ Ticket tag added successfully: " + tickettagisaddedsuccessfully.getText());
			} else {
				System.err.println("❌ Ticket tag element is not displayed.");
				Assert.fail("Ticket tag was not displayed after adding.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("❌ Ticket tag element not found in DOM.");
			Assert.fail("Ticket tag not added or not present in DOM.");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Unexpected error while verifying ticket tag: " + e.getMessage());
			Assert.fail("Unexpected exception occurred.");
		}
	}

	public void entertickettagunderaddtickettagtextfailedandsave() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(entertickettagunderaddtickettagtextfailed))
					.sendKeys("Test1");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(btnAddTagOk)).click();
			System.out.println("✅ Entered ticket tag and clicked OK successfully.");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during wait: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to enter ticket tag or click OK: " + e.getMessage());
			Assert.fail("Exception occurred while adding ticket tag.");
		}
	}

	public void ontagmanagementpageclickonaddtickets() {
		try {
			
			Longwait.until(ExpectedConditions.elementToBeClickable(clickaddtagonticket)).click();
			System.out.println("✅ Clicked on 'Add Tickets' on Tag Management page.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on 'Add Tickets': " + e.getMessage());
			Assert.fail("Exception occurred while clicking 'Add Tickets'.");
		}
	}

	public void clicktagmanagementtab() {
		try {
			
			Longwait.until(ExpectedConditions.elementToBeClickable(ClickTagManagentTab)).click();
			System.out.println("✅ Clicked on Tag Management tab successfully.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Tag Management tab: " + e.getMessage());
			Assert.fail("Exception occurred while clicking Tag Management tab.");
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////

	public void disabledproductfromdropdown() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(DisabledProduct)).click();
			System.out.println("✅ Disabled product clicked from dropdown.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on disabled product: " + e.getMessage());
			Assert.fail("Exception occurred while clicking disabled product from dropdown.");
		}
	}

	public void ClickOnDisablePolicyDropdown() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SelectProductWINSELECT)).click();
			System.out.println("✅ Clicked on WINSELECT product.");
			
				
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnEnablePolicyDropDown)).click();
			System.out.println("✅ Clicked on Disable Policy dropdown successfully.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Disable Policy dropdown: " + e.getMessage());
			Assert.fail("Exception occurred while clicking Disable Policy dropdown.");
		}
	}

	public boolean waitForWinSelectUninstalledAndHover(int maxWaitInSeconds) {
		Actions actions = new Actions(ldriver);
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		long endTime = System.currentTimeMillis() + (maxWaitInSeconds * 1000);

		while (System.currentTimeMillis() < endTime) {
			try {
				if (WinSelectStatusNotInstalled.isDisplayed()) {
					actions.moveToElement(WinSelectStatusNotInstalled).perform();
					System.out.println("✅ Hovered over WinSelect Not Installed status.");
					try {
						Thread.sleep(30000); // 30 sec hover
					} catch (InterruptedException ie) {
						Thread.currentThread().interrupt();
						System.err.println("❌ Hover sleep interrupted: " + ie.getMessage());
					}
					return true;
				}
			} catch (Exception e) {
				System.err.println("❌ WinSelect status element not available yet: " + e.getMessage());
			}

			try {
				Thread.sleep(15000); // wait before retry
				ldriver.navigate().refresh();
				wait.until(ExpectedConditions.elementToBeClickable(ComputersPage)).click();
				System.out.println("🔄 Refreshed page and clicked on Computers page.");
			} catch (Exception e) {
				System.err.println("❌ Error during refresh or clicking Computers page: " + e.getMessage());
			}
		}

		System.err.println("❌ Timeout reached. WinSelect Not Installed status not found.");
		return false; // timeout
	}

	public boolean waitForWinSelectInstalledAndHover(int maxWaitInSeconds) {
		Actions actions = new Actions(ldriver);
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		long endTime = System.currentTimeMillis() + (maxWaitInSeconds * 1000);

		while (System.currentTimeMillis() < endTime) {
			try {
				if (WinSelectStatusEnabled.isDisplayed()) {
					actions.moveToElement(WinSelectStatusEnabled).perform();
					System.out.println("✅ Hovered over WinSelect Enabled status.");
					try {
						Thread.sleep(30000); // Hover for 30 sec
					} catch (InterruptedException ie) {
						Thread.currentThread().interrupt();
						System.err.println("❌ Hover sleep interrupted: " + ie.getMessage());
					}
					return true;
				}
			} catch (Exception e) {
				System.err.println("ℹ WinSelect Enabled not found yet: " + e.getMessage());
			}

			try {
				if (WinSelectStatusEnabledOutdated.isDisplayed()) {
					actions.moveToElement(WinSelectStatusEnabledOutdated).perform();
					System.out.println("⚠ Hovered over WinSelect Enabled (Outdated) status.");
					try {
						Thread.sleep(30000); // Hover for 30 sec
					} catch (InterruptedException ie) {
						Thread.currentThread().interrupt();
						System.err.println("❌ Hover sleep interrupted: " + ie.getMessage());
					}
					return true;
				}
			} catch (Exception e) {
				System.err.println("ℹ WinSelect Enabled Outdated not found yet: " + e.getMessage());
			}

			try {
				Thread.sleep(15000); // wait 15 sec before retry
				ldriver.navigate().refresh();
				wait.until(ExpectedConditions.elementToBeClickable(ComputersPage)).click();
				System.out.println("🔄 Page refreshed and clicked on Computers tab.");
			} catch (Exception e) {
				System.err.println("❌ Error during refresh or clicking Computers tab: " + e.getMessage());
			}
		}

		System.err.println("❌ Timeout reached. WinSelect Installed/Outdated status not found.");
		return false; // Timeout
	}

	public void clickok() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(clickOK)).click();
			System.out.println("✅ Clicked on OK button.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click OK button: " + e.getMessage());
		}
	}

	public void checkradiobtn() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(checkRadioBtn)).click();
			System.out.println("✅ Radio button checked successfully.");
		} catch (Exception e) {
			System.err.println("❌ Failed to check radio button: " + e.getMessage());
		}
	}

	public void Savebtn() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SaveBtn)).click();
			System.out.println("✅ Clicked on Save button successfully.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click Save button: " + e.getMessage());
		}
	}

	

	public void ClickONWINSELECT() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(SelectProductWINSELECT)).click();
			System.out.println("✅ Clicked on WINSELECT product.");
			
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnEnablePolicyDropDown)).click();
			System.out.println("✅ Clicked on Enable Policy dropdown.");
			
			wait.until(ExpectedConditions.elementToBeClickable(EnableWINSELECT)).click();
			System.out.println("✅ Clicked on WINSELECT to enable from dropdown.");
			
		} catch (Exception e) {
			System.err.println("❌ Failed to click on WINSELECT product: " + e.getMessage());
		}
	}

	public void ClickOnPolicyName() {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnPolicy)).click();
			System.out.println("✅ Clicked on policy name.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on policy name: " + e.getMessage());
		}
	}

	public void SelectRelatedSite() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SelectSite)).click();
			
			System.out.println("✅ Selected related site.");
		} catch (Exception e) {
			System.err.println("❌ Failed to select related site: " + e.getMessage());
		}
	}

	public void clickOnSiteDropDown() {
		try {
			ldriver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(SiteDropDown)).click();
			System.out.println("✅ Clicked on site dropdown.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on site dropdown: " + e.getMessage());
		}
	}

	public void searchComputerByName(String computerName) {
		try {
			WebElement SearchBox = wait.until(ExpectedConditions.elementToBeClickable(SearchBoxOnComputersPage));
			SearchBox.click();
			SearchBox.clear();
			SearchBox.sendKeys(computerName);
			SearchBox.sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			System.out.println("✅ Searched computer by name: " + computerName);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during search: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to search computer by name: " + e.getMessage());
		}
	}

	public void clickonComputersPage() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ComputersPage)).click();
			System.out.println("✅ Clicked on Computers page tab.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Computers page: " + e.getMessage());
		}
	}

	public void enterEmailID(String emailAddress) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(EmailId)).click();
			wait.until(ExpectedConditions.elementToBeClickable(EmailId)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(EmailId)).sendKeys(emailAddress);
			System.out.println("✅ Entered email ID: " + emailAddress);
		} catch (Exception e) {
			System.err.println("❌ Failed to enter email ID: " + e.getMessage());
		}
	}

	public void clickonNextBtn() {
		try {
			NextButton.click();
			System.out.println("✅ Clicked on Next button.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Next button: " + e.getMessage());
		}
	}

	public void enterPass(String pwd) {
		try {
			Password.sendKeys(pwd);
			System.out.println("✅ Entered password successfully.");
		} catch (Exception e) {
			System.err.println("❌ Failed to enter password: " + e.getMessage());
		}
	}

	public void clickonLoginBtn() {
		try {
			LoginButton.click();
			System.out.println("✅ Clicked on Login button.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Login button: " + e.getMessage());
		}
	}

	public void clickonlogoutmenubtn() {
		try {
			clickonlogoutmenu.click();
			System.out.println("✅ Clicked on logout menu button.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on logout menu button: " + e.getMessage());
		}
	}

	public void clicklogoutbtn() {
		try {
			clickonlogout.click();
			System.out.println("✅ Clicked on Logout button.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Logout button: " + e.getMessage());
		}
	}

	public void clickOnPolicyTabbtn() {
		try {
			clickOnPolicyTab.click();
			System.out.println("✅ Clicked on Policy tab button.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Policy tab button: " + e.getMessage());
		}
	}

	public void clickonAddPolictbtn() {
		try {
			AddPolicyDropDown.click();
			System.out.println("✅ Clicked on Add Policy dropdown button.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click on Add Policy dropdown button: " + e.getMessage());
		}
	}

	public void selectPolicyTypeDeepFreezeWindow() {
		try {
			SelectPolicyTypeDFWindow.click();
			System.out.println("✅ Selected Policy Type in DeepFreeze window.");
		} catch (Exception e) {
			System.err.println("❌ Failed to select Policy Type: " + e.getMessage());
		}
	}

	public void PolicyName(String Test) {
		try {
			EnterPolicyName.sendKeys(Test);
			System.out.println("✅ Entered Policy Name: " + Test);
		} catch (Exception e) {
			System.err.println("❌ Failed to enter Policy Name: " + e.getMessage());
		}
	}

	public void SelectDeepFreezeProduct() {
		try {
			SelectDFProduct.click();
			Thread.sleep(2000);
			System.out.println("✅ Selected DeepFreeze Product.");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to select DeepFreeze Product: " + e.getMessage());
		}
	}

	public void ClickTOEnable() {
		try {
			EnableDFProduct.click();
			System.out.println("✅ Clicked to enable DeepFreeze Product.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click enable: " + e.getMessage());
		}
	}

	public void selectDeepFreezeSetting(String value) {
		try {
			Thread.sleep(4000);
			dropdown.click();
			System.out.println("✅ Opened DeepFreeze setting dropdown.");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to click on DeepFreeze setting: " + e.getMessage());
		}
	}

	public void SavePolicybtn() {
		try {
			ClickOnSaveBtn.click();
			Thread.sleep(7000);
			System.out.println("✅ Clicked on Save Policy button.");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted during save: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to click Save Policy button: " + e.getMessage());
		}
	}

	public void DownloadAgentbtn() {
		try {
			ClickONDownloadAhentbtn.click();
			System.out.println("✅ Clicked on Download Agent button.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click Download Agent button: " + e.getMessage());
		}
	}

	public void selectnNewlyCreatedPolicy() {
		try {
			SelectPolicyNameDropDown.click();
			Thread.sleep(2000);
			SelectPolicy.click();
			System.out.println("✅ Selected newly created policy.");
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			System.err.println("❌ Thread interrupted: " + ie.getMessage());
		} catch (Exception e) {
			System.err.println("❌ Failed to select newly created policy: " + e.getMessage());
		}
	}

	public void SelectDownloadType() {
		try {
			SelectDownloadTypeFromList.click();
			System.out.println("✅ Selected download type from list.");
		} catch (Exception e) {
			System.err.println("❌ Failed to select download type: " + e.getMessage());
		}
	}

	public void Downloadbtn() {
		try {
			clickDownload.click();
			System.out.println("✅ Clicked on Download button.");
		} catch (Exception e) {
			System.err.println("❌ Failed to click Download button: " + e.getMessage());
		}
	}

	public void SelectMSIDownloadType() {
		try {
			SelectMSIDownloadTypeFromList.click();
			System.out.println("✅ Selected MSI download type.");
		} catch (Exception e) {
			System.err.println("❌ Failed to select MSI download type: " + e.getMessage());
		}
	}

	public void SelectDeploymentUtilityType() {
		try {
			SelectDeploymentUtilityTypeFromList.click();
			System.out.println("✅ Selected Deployment Utility type.");
		} catch (Exception e) {
			System.err.println("❌ Failed to select Deployment Utility type: " + e.getMessage());
		}
	}

	public void SelectFullInstallerType() {
		try {
			WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(3600));
			wait.until(ExpectedConditions.elementToBeClickable(SelectFullInstallerTypeFromList)).click();
			System.out.println("✅ Selected Full Installer type.");
		} catch (Exception e) {
			System.err.println("❌ Failed to select Full Installer type: " + e.getMessage());
		}
	}

	public void Downloadbtnn() {
		try {
			Downloadn.click();
			System.out.println("✅ Clicked Download button (full installer).");
		} catch (Exception e) {
			System.err.println("❌ Failed to click Download button: " + e.getMessage());
		}
	}

	public void SelectDownloaderTypeWindowsServer() {
		try {
			SelectDownloaderTypeeWindowsServer.click();
			System.out.println("✅ Selected downloader type for Windows Server.");
		} catch (Exception e) {
			System.err.println("❌ Failed to select downloader type Windows Server: " + e.getMessage());
		}
	}

	public void SelectDownloaderTypeMac() {
		try {
			SelectDownloaderTypeeMac.click();
			System.out.println("✅ Selected downloader type for Mac.");
		} catch (Exception e) {
			System.err.println("❌ Failed to select downloader type Mac: " + e.getMessage());
		}
	}

}
