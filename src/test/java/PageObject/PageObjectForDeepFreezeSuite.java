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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class PageObjectForDeepFreezeSuite {

    WebDriver ldriver;

    public PageObjectForDeepFreezeSuite(WebDriver rDriver)
    {
      ldriver=rDriver;
      PageFactory.initElements(rDriver, this);
     }

    @FindBy(id="txtUserName")
    WebElement EmailId;
    
    @FindBy(id="btnlogin")
    WebElement NextButton;
    
    @FindBy(id="txtPassword")
    WebElement Password;
    
    @FindBy(id="btnlogin")
    WebElement LoginButton;
    
    @FindBy(id="logg_main")
    WebElement  clickonlogoutmenu;
    
    @FindBy(id="aSignOut")
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
    
    @FindBy(id="Install")
    WebElement clickDownload;
    
    @FindBy(id="Install")
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
    
    @FindBy(xpath = "//img[@id=\"imgmysitedownaarow\"]")
    WebElement SiteDropDown;
    
    @FindBy(xpath = "//div[@class='site_header']//li[3]")
    WebElement SelectSite;
    
//    @FindBy(xpath = "//a[normalize-space(text())='Migration']")
//    WebElement migrationLink;
//
//    public void clickMigration() {
//        ((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", migrationLink);
//    }
    
    @FindBy(xpath = "//td[@aria-label='Column Policy, Value Automation test']")
    WebElement ClickOnPolicy;
    
    @FindBy(xpath = "//li[@id='li_WINSELECT']//div[@class='sidebar-product-names']")
    WebElement SelectProductWINSELECT;
    
    @FindBy(xpath = "//select[@id='ddPolicySettingsWinSelect']")
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
   
   @FindBy(id="addTag_Ticket")
   WebElement clickaddtagonticket;
   
   @FindBy(id="txtTagName")
   WebElement entertickettagunderaddtickettagtextfailed;
   
   @FindBy(id="btnAddTagOk")
   WebElement btnAddTagOk;
   
   @FindBy(xpath = "//span[@class='abstractText']")
   WebElement tickettagisaddedsuccessfully;
   
   @FindBy(id ="btnDeleteTagOK")
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
   List <WebElement> LocationTagsList;
   
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
   
   @FindBy(xpath = "//li[@id='logg_main']//*[contains(text(),'Nikhil@sharklasers.com')]")
   WebElement loggedInUsername;
   
   @FindBy(xpath = "//input[@value='GOT IT']")
   WebElement onmainpageclickonAdGOTIT;
///////////////////////////////////////////////SPLIT/////////////////////////////////////////////////////////////////    
   
   
   
   
   
   
   /////////////////////////////User Management Page/////////////////////////////////////////////
   
   public void onmainpageclickonadgotitbtn() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	  	 wait.until(ExpectedConditions.elementToBeClickable(onmainpageclickonAdGOTIT)).click();
	      }
   
   public void verifyLoggedInUser() {
	    String expected = "Nikhil@sharklasers.com";
	    String actual = loggedInUsername.getText().trim();
	    Assert.assertEquals(actual, expected, "❌ User login verification failed!");
	    System.out.println("✅ Logged in as: " + actual);
	}
   
   public void onmyprofilepageclickonsavebtn() {
	   	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	  	 wait.until(ExpectedConditions.elementToBeClickable(onMyProfilePageclickonSave)).click();
   }
   public void enterokbtn() throws InterruptedException {
	   Thread.sleep(2000);
	   enterOKbtn.click();
	   Thread.sleep(2000); 
   }
   
   public void enterconfirmpassword() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	  	 wait.until(ExpectedConditions.elementToBeClickable(EnterConfirmPassword)).sendKeys("Aloha@123");
   }
   
   public void enternewpassword() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	  	 wait.until(ExpectedConditions.elementToBeClickable(EnterNewPassword)).sendKeys("Aloha@123");

   }
   public void clickoninvitemail() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	  	 wait.until(ExpectedConditions.elementToBeClickable(ClickonInviteMail)).click();
   }
   
   public void clickonsetbuttong() throws InterruptedException {
	   ClickOnSetButton.click();
	  	 Thread.sleep(10000);
   }
   public void clickonforgetmebtn() {
	  clickonForgetmebtn.click();
   }
   public void clickondomaintxtbox() throws InterruptedException {
	   Thread.sleep(1000);
	   clickonDomaintxtbox.click();
	   
	   clickonDomaintxtbox.sendKeys("Nikhil");
   }
   
   public void uncheckscambleaddress() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	  	 wait.until(ExpectedConditions.elementToBeClickable(uncheckScrambleAddress)).click();
   }
   
   public void clickoninvitelink() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
  	 wait.until(ExpectedConditions.elementToBeClickable(clickOninvitelink)).click();
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
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	  	 wait.until(ExpectedConditions.elementToBeClickable(clickonOKbtn)).click();
   }
   public void enteremail() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	  	 wait.until(ExpectedConditions.elementToBeClickable(EnterEmail)).sendKeys("nikhil@sharklasers.com");
   }
   public void enterlastname() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	  	 wait.until(ExpectedConditions.elementToBeClickable(enterLastName)).sendKeys("Automation");
   }
   
   public void enterfirstname() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
  	 wait.until(ExpectedConditions.elementToBeClickable(enterFirstName)).sendKeys("Nikhil");
   }
   
   public void clickonaddnewuser() {
	   clickonAddNewUser.click();
   }
   public void clickonadduserdropdown() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
  	 wait.until(ExpectedConditions.elementToBeClickable(clickOnAddUserDropDown)).click();
   }
   
   public void clickonusermanagementbtn() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	  	 wait.until(ExpectedConditions.elementToBeClickable(clickonUserManagement)).click();
   }
   
   public void clickoncurrentuser() {
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(clickonuserbtn));
	    clickonuserbtn.click();
	}
   
   ///////////////////////////tag management page///////////////////////////////////////////////////
   
  
   public void verifyLocationTagDeleted() throws InterruptedException {
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
	}
   
   public void clickondeletelocationtagbutton() {
	   Deletetickettag.click();
   }
   
   public void verifyTagIsAddedSuccessfullyinlocationtag() throws InterruptedException {
	    Thread.sleep(2000); // Wait for tag to appear

	    try {
	        if (addedlocationTag.isDisplayed()) {
	            System.out.println("✅ Ticket tag added successfully: " + addedlocationTag.getText());
	        } else {
	            System.out.println("❌ Ticket tag element is not displayed.");
	            Assert.fail("Ticket tag was not displayed after adding.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("❌ Ticket tag element not found in DOM.");
	        Assert.fail("Ticket tag not added or not present in DOM.");
	    }
	}
    
   public void enterlocationtagname() throws InterruptedException {
		  WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		 	 wait.until(ExpectedConditions.elementToBeClickable(entertagname)).sendKeys("Test1");  
		 	 Thread.sleep(2000);
		 	clickonOK.click();
		 	Thread.sleep(2000);
   }
   
   public void addtaglocationtag() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
  	 wait.until(ExpectedConditions.elementToBeClickable(addTagLocationTag)).click();
   }
   
   public void verifyNormalTagDeleted() throws InterruptedException {
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
	}
   
   public void verifyTagIsAddedSuccessfully() throws InterruptedException {
	    Thread.sleep(2000); // Wait for tag to appear

	    try {
	        if (addedTag.isDisplayed()) {
	            System.out.println("✅ Ticket tag added successfully: " + addedTag.getText());
	        } else {
	            System.out.println("❌ Ticket tag element is not displayed.");
	            Assert.fail("Ticket tag was not displayed after adding.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("❌ Ticket tag element not found in DOM.");
	        Assert.fail("Ticket tag not added or not present in DOM.");
	    }
	}
   
   public void entertagnametextbox() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
 	 wait.until(ExpectedConditions.elementToBeClickable(entertagname)).sendKeys("Test1");  
 	 Thread.sleep(2000);
 	clickonOK.click();
  }
  
   public void addtagnormal() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
  	 wait.until(ExpectedConditions.elementToBeClickable(addTagNormal)).click();
	   }
   
   public void verifyTicketTagDeleted() throws InterruptedException {
	   Thread.sleep(2000); 
	   if (ticketTags.isEmpty()) {
	        System.out.println("✅ Ticket tag deleted successfully. No tags found under Ticket section.");
	    } else {
	        System.out.println("❌ Ticket tag deletion failed. Found " + ticketTags.size() + " tag(s).");
	        for (WebElement tag : ticketTags) {
	            System.out.println("Tag still present: " + tag.getText());
	        }
	        Assert.fail("Tag still exists under Ticket section after deletion.");
	    }
	   Thread.sleep(2000); 
	}
   
   public void deletetagfromtickettag() {
	   Deletetickettag.click();
   }
      
   public void checkTicketTagIsAddedSuccessfully() throws InterruptedException {
	    Thread.sleep(2000); // Wait for tag to appear

	    try {
	        if (tickettagisaddedsuccessfully.isDisplayed()) {
	            System.out.println("✅ Ticket tag added successfully: " + tickettagisaddedsuccessfully.getText());
	        } else {
	            System.out.println("❌ Ticket tag element is not displayed.");
	            Assert.fail("Ticket tag was not displayed after adding.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("❌ Ticket tag element not found in DOM.");
	        Assert.fail("Ticket tag not added or not present in DOM.");
	    }
	}
  
   public void entertickettagunderaddtickettagtextfailedandsave() throws InterruptedException {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
	  	 wait.until(ExpectedConditions.elementToBeClickable(entertickettagunderaddtickettagtextfailed)).sendKeys("Test1");
	  	 Thread.sleep(2000);
	     btnAddTagOk.click();
   }
   
   public void ontagmanagementpageclickonaddtickets() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
  	 wait.until(ExpectedConditions.elementToBeClickable(clickaddtagonticket)).click();
  }
   
   public void clicktagmanagementtab() {
	   WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
	  	 wait.until(ExpectedConditions.elementToBeClickable(ClickTagManagentTab)).click();
	      }
   
   
   
   
   ////////////////////////////////////////////////////////////////////////////////////////
   
   public void disabledproductfromdropdown () {
	   DisabledProduct.click();
   }
   
   
   public void ClickOnDisablePolicyDropdown()
   {
   	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
  	 wait.until(ExpectedConditions.elementToBeClickable(ClickOnEnablePolicyDropDown)).click();
   
	}
   public boolean waitForWinSelectUninstalledAndHover(int maxWaitInSeconds) {
	    Actions actions = new Actions(ldriver);
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

	    long endTime = System.currentTimeMillis() + (maxWaitInSeconds * 1000);

	    while (System.currentTimeMillis() < endTime) {
	        try {
	            if (WinSelectStatusNotInstalled.isDisplayed()) {
	                actions.moveToElement(WinSelectStatusNotInstalled).perform();
	                Thread.sleep(30000); // 30 sec hover
	                return true;
	            }
	        } catch (Exception ignored) {}

	        try {
	            Thread.sleep(15000); // wait before retry
	            ldriver.navigate().refresh();
	            wait.until(ExpectedConditions.elementToBeClickable(ComputersPage)).click();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

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
	                Thread.sleep(30000); // 🕒 Hover for 30 sec
	                return true;
	            }
	        } catch (Exception ignored) { }

	        try {
	            if (WinSelectStatusEnabledOutdated.isDisplayed()) {
	                actions.moveToElement(WinSelectStatusEnabledOutdated).perform();
	                Thread.sleep(30000); // 🕒 Hover for 30 sec
	                return true;
	            }
	        } catch (Exception ignored) { }

	        try {
	            Thread.sleep(15000); // wait 15 sec before next try
	            ldriver.navigate().refresh();
	            wait.until(ExpectedConditions.elementToBeClickable(ComputersPage)).click(); // reopen Computers tab
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return false; // Timeout
	}
    
    
    
    public void clickok() {
    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
   	 wait.until(ExpectedConditions.elementToBeClickable(clickOK)).click();
   	 
    }
    
    public void checkradiobtn()
    {
    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
   	 wait.until(ExpectedConditions.elementToBeClickable(checkRadioBtn)).click();
    }
    
    public void Savebtn() {
    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
   	 wait.until(ExpectedConditions.elementToBeClickable(SaveBtn)).click();
    	
    	    }
    
    public void ClickOnWINSELECTToEnableFromDropDown() {
    	
    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
   	 wait.until(ExpectedConditions.elementToBeClickable(EnableWINSELECT)).click();
    	    }
    
    
    public void ClickOnEnablePolicyDropdown()
    {
    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
   	 wait.until(ExpectedConditions.elementToBeClickable(ClickOnEnablePolicyDropDown)).click();
    
	}
    
    public void ClickONWINSELECT()
    {
    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
   	 wait.until(ExpectedConditions.elementToBeClickable(SelectProductWINSELECT)).click();
    	
    }
    
    public void ClickOnPolicyName()
    {
    	 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(ClickOnPolicy)).click();
    	
    	
    }
    
    public void SelectRelatedSite() {
       SelectSite.click();
    }
    
    public void clickOnSiteDropDown() 
    { 
    	
    	ldriver.navigate().refresh();
    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
   	 wait.until(ExpectedConditions.elementToBeClickable(SiteDropDown)).click();
    	
    }
   
    
    public void searchComputerByName(String computerName) throws InterruptedException {
    	SearchBoxOnComputersPage.click();
    	SearchBoxOnComputersPage.clear();
        SearchBoxOnComputersPage.sendKeys(computerName);
        // Optional: press Enter if search doesn't auto trigger
         SearchBoxOnComputersPage.sendKeys(Keys.ENTER);
         Thread.sleep(4000);
    }
    
    public void clickonComputersPage()
	{
    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
   	 wait.until(ExpectedConditions.elementToBeClickable(ComputersPage)).click();
    	
	}
    
    public void enterEmailID(String emailAddress)
    {
    	EmailId.sendKeys(emailAddress);
    }
    public void clickonNextBtn()
    {
    	NextButton.click();
    }
    public void enterPass (String pwd)
    {
    	Password.sendKeys(pwd);
    }
    public void clickonLoginBtn ()
    {
    	LoginButton.click();
    }
    public void clickonlogoutmenubtn()
    {
    	clickonlogoutmenu.click();
    }
    public void clicklogoutbtn()
    {
    	clickonlogout.click();
    }
    
    public void clickOnPolicyTabbtn()
    {
    	clickOnPolicyTab.click();
    }
    public void clickonAddPolictbtn()
    {
    	AddPolicyDropDown.click();
    }
    public void selectPolicyTypeDeepFreezeWindow()
    {
    	SelectPolicyTypeDFWindow.click();
    }
    public void PolicyName(String Test)
    {
    	EnterPolicyName.sendKeys(Test);
    }
    public void SelectDeepFreezeProduct() throws InterruptedException
    {
    	SelectDFProduct.click(); 
    	Thread.sleep(2000);
    }
    public void ClickTOEnable()
    {
    	EnableDFProduct.click();
    }
    
    public void selectDeepFreezeSetting(String value) throws InterruptedException {
    	Thread.sleep(4000);
       	dropdown.click();
    	
    }
    public void SavePolicybtn() throws InterruptedException
    {
    	ClickOnSaveBtn.click();
    	Thread.sleep(7000);
    }
    public void DownloadAgentbtn()
    {
    	ClickONDownloadAhentbtn.click();
    }
    
    public void selectnNewlyCreatedPolicy() throws InterruptedException
    {
    	SelectPolicyNameDropDown.click();
   	 Thread.sleep(2000);
   	   SelectPolicy.click();
    
    }

		
	public void SelectDownloadType()
    {
    	SelectDownloadTypeFromList.click();
    }
    public void Downloadbtn() throws InterruptedException 
    {
       clickDownload.click();
      // Thread.sleep(10000);
    }

	public void SelectMSIDownloadType()
	{
	SelectMSIDownloadTypeFromList.click();
	}
	public void SelectDeploymentUtilityType()
	{
		SelectDeploymentUtilityTypeFromList.click();
	}
	public void SelectFullInstallerType()
	{
				
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(3600));
	   	 wait.until(ExpectedConditions.elementToBeClickable(SelectFullInstallerTypeFromList)).click();
	}
	public void Downloadbtnn() throws InterruptedException
	{
		Downloadn.click();
		//Thread.sleep(900000);
	}
	
	public void SelectDownloaderTypeWindowsServer()
	{
		SelectDownloaderTypeeWindowsServer.click();
	}
	public void SelectDownloaderTypeMac()
	{
		SelectDownloaderTypeeMac.click();
	}
	
	
}

