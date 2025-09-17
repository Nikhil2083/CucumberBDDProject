package PageObject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DFOnDemandPagePOM {
	WebDriver ldriver;
	WebDriverWait wait;
	WebDriverWait Longwait;

	// Constructor
	public DFOnDemandPagePOM(WebDriver rDriver) {
		ldriver = rDriver;
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(50));
		Longwait = new WebDriverWait(ldriver, Duration.ofMinutes(15));
		PageFactory.initElements(rDriver, this);

	}

	@FindBy(xpath = "//li[contains(@id,'DeepFreezeonDemand')]")
	WebElement DeepFreezeOnDemandPage;

	@FindBy(xpath = "//input[contains(@id,'SearchDeepFreeze')]")
	WebElement SearchboxofDFODpage;

	@FindBy(xpath = "//label[contains(@for,'w-212')]")
	WebElement SelectComputerCheckBox;

	@FindBy(xpath = "//span[contains(@title,'Restart')]")
	WebElement RestartbtnonDFODpage;

	@FindBy(xpath = "//span[contains(@title,'Task Status')]")
	WebElement clickedonTaskStatusPage;

	@FindBy(xpath = "")
	WebElement taskstatusExecuted;

	@FindBy(xpath = "(//span[@name='Status'])[1]")
	WebElement ontaskstatuspagecheckassignedtaskstatus;
	
	@FindBy (xpath = "//div[@aria-label='Search in data grid']//input[@role='textbox']")
	WebElement SearchBoxofTaskStatusPage;
	
	@FindBy (xpath = "//img[contains(@id,'imgmysitedownaarow')]")
	WebElement switchsitedropdown;
	
	@FindBy (xpath = "//a[contains(text(),'Migration')]")
	WebElement clickonmigrationsite;
////////////////////////////////////////split///////////////////////////////////////////////

	public void clickondeepfreezeondemandpage() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(DeepFreezeOnDemandPage)).click();

			System.out.println("✅ Clicked on DFOD Page");

		} catch (Exception e) {
			System.err.println("❌ Failed to Click on DFOD Page: " + e.getMessage());
		}
	}

	public void searchcomputerbytherenameandselectit() {
		try {
			WebElement searchbox = wait.until(ExpectedConditions.elementToBeClickable(SearchboxofDFODpage));
			searchbox.click();
			System.out.println("✅ Searching computer name");
			searchbox.clear();
			searchbox.sendKeys("WINDOWS-10-22H2");
			searchbox.sendKeys(Keys.ENTER);
			System.out.println("✅ Searched computer name");
		} catch (Exception e) {
			System.err.println("❌ Failed to search computer: " + e.getMessage());
		}

		// --- Try for Selecting Computer ---
		try {
			WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(SelectComputerCheckBox));
			checkbox.click();
			System.out.println("✅ Selected computer");
		} catch (Exception e) {
			System.err.println("❌ Failed to select computer: " + e.getMessage());
		}
	}

	public void clickonrestartbtnandgototaskstatuspage() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(RestartbtnonDFODpage)).click();
			System.out.println("✅ Clicked on Restart Button");
		} catch (Exception e) {
			System.err.println("❌ Failed to click restart button: " + e.getMessage());

		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(clickedonTaskStatusPage)).click();
			System.out.println("✅ Clicked on Task Status Page");
		} catch (Exception e) {
			System.err.println("❌ Failed to goto Task Status Page: ");
		}
	}

	public void verifiedTaskExecutedProperly() {
		
		try {
			WebElement searchboxoftaskstatuspage = wait.until(ExpectedConditions.elementToBeClickable(SearchBoxofTaskStatusPage));
			searchboxoftaskstatuspage.click();
			searchboxoftaskstatuspage.clear();
			System.out.println("✅ Searching Computer on Task Status Page");
			searchboxoftaskstatuspage.sendKeys("WINDOWS-10-22H2");
			searchboxoftaskstatuspage.sendKeys(Keys.ENTER);
		}catch(Exception e){
				System.err.println("❌ Failed to Search Computer");
			}
			
		try {
			
			WebElement statusElement = Longwait.until(ExpectedConditions.visibilityOf(ontaskstatuspagecheckassignedtaskstatus));

			String actualStatus = statusElement.getText().trim();
			System.out.println("🔎 Task Status found: " + actualStatus);

			if ("Executed".equalsIgnoreCase(actualStatus)) {
				System.out.println("✅ Task executed successfully!");
			} else if (actualStatus.toLowerCase().contains("failed")) {
				System.out.println("❌ Task failed!");
			} else {
				System.out.println("⚠️ Unexpected Task Status: " + actualStatus);
			}

		} catch (TimeoutException te) {
			System.err.println("⏳ Timed out waiting for task status element!");
		} catch (Exception e) {
			System.err.println("❌ Could not verify task status: " + e.getMessage());
		}
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(DeepFreezeOnDemandPage)).click();

			System.out.println("✅ Clicked back to on DFOD Page");

		} catch (Exception e) {
			System.err.println("❌ Failed to Click back to on DFOD Page: " + e.getMessage());
		}
	

	}
	
 public void switchtorelatedsite() {
	try {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(switchsitedropdown)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(clickonmigrationsite)).click();
		Thread.sleep(3000);
		System.out.println("✅ Switched to related site successfully!");
	}catch(Exception e) {
		System.err.println("❌ Failed to switch related site");
	}
}
	






























}
