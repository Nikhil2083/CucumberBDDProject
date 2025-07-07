package PageObject;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
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
   
   @FindBy(xpath = "//span[contains(@class,'abstractText') and contains(text(),'Test1')]")
   WebElement tickettagisaddedsuccessfully;
   
   @FindBy(id ="btnDeleteTagOK")
   WebElement Deletetickettag;
   
   @FindBy(xpath = "//ul[@id='Ticket']/li")
   List<WebElement> ticketTags;
   
   
///////////////////////////////////////////////SPLIT/////////////////////////////////////////////////////////////////    
   
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
   
   
   public void checktickettagisaddedsuccessfully() throws InterruptedException {
	   Thread.sleep(2000);
	   tickettagisaddedsuccessfully.click();
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

