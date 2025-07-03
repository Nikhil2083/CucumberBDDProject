package PageObject;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
    
    @FindBy(xpath = "//select[@id=\"policyId\"]")
    WebElement SelectPolicyName;
    
    @FindBy(xpath = "//option[@value='62']")
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
    
    @FindBy(xpath = "//a[normalize-space()='Migration']")
    WebElement SelectSite;
    
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
    
   // @FindBy(xpath = "(//div[@title='Enabled'])[302]") // Status when installed
	//public WebElement WinSelectStatusEnabled;

    @FindBy(xpath = "(//div[@title='Not Installed'])[302]") // Status when not installed
    WebElement WinSelectStatusNotInstalled;
    
 //   @FindBy(xpath = "(//div[@title='Enabled (Outdated)'])[1]")
//	public WebElement WinSelectStatusEnabledOutdated;
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   
        
    public boolean waitForWinSelectInstallationStatus(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(timeoutSeconds));
        try {
            return wait.until(driver -> {
                List<WebElement> enabledElements = driver.findElements(By.xpath("//div[@title='Enabled']"));
                List<WebElement> outdatedElements = driver.findElements(By.xpath("//div[@title='Enabled (Outdated)']"));

                return !enabledElements.isEmpty() || !outdatedElements.isEmpty();
            });
        } catch (Exception e) {
            return false;
        }
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
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
        By relatedSiteLocator = By.xpath("//a[@title=' Migration ']");

        WebElement relatedSiteElement = wait.until(ExpectedConditions.elementToBeClickable(relatedSiteLocator));
        relatedSiteElement.click();
    }
    
    public void clickOnSiteDropDown() 
    {
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
    	SelectPolicyName.click();
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
		SelectFullInstallerTypeFromList.click();
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

