package PageObject;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


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

	@FindBy(css = "label[for='w-212']")
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
			Assert.fail("❌ Test failed because computer was not selected!"); 
		} 
	}

	public void clickonrestartbtnandgototaskstatuspage() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(RestartbtnonDFODpage)).click();
			Thread.sleep(2000);
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

	 public void verifyTaskExecutedOrFailed() {
	        boolean statusVerified = false;
	        long startTime = System.currentTimeMillis();
	        long maxWaitTime = 15 * 60 * 1000; // 15 minutes

	        try {
	            // Search computer on task status page
	            wait.until(ExpectedConditions.elementToBeClickable(SearchBoxofTaskStatusPage)).sendKeys("WINDOWS-10-22H2", Keys.ENTER);
	            System.out.println("✅ Searching Computer on Task Status Page");
	        } catch (Exception e) {
	            System.err.println("❌ Failed to search computer: " + e.getMessage());
	        }

	        while ((System.currentTimeMillis() - startTime) < maxWaitTime) {
	            try {
	                String actualStatus = ontaskstatuspagecheckassignedtaskstatus.getText().trim();
	                System.out.println("🔎 Current Status: " + actualStatus);

	                if (actualStatus.equalsIgnoreCase("Executed")) {
	                    System.out.println("✅ Task executed successfully!");
	                    statusVerified = true;
	                    break;

	                } else if (actualStatus.startsWith("Failed")) {
	                    // Extract reason inside brackets
	                    String reason = "";
	                    if (actualStatus.contains("(") && actualStatus.contains(")")) {
	                        reason = actualStatus.substring(
	                                actualStatus.indexOf("(") + 1,
	                                actualStatus.indexOf(")")
	                        );
	                    }
	                    System.out.println("❌ Task failed! Reason: " + reason);
	                    statusVerified = true;
	                    break;

	                } else {
	                    System.out.println("⏳ Still waiting... refreshing in 5 sec");
	                    Thread.sleep(5000);
	                   ldriver.navigate().refresh();
	                   WebElement searchboxofTaskStatusPage = wait.until(ExpectedConditions.elementToBeClickable(SearchBoxofTaskStatusPage));
	                   searchboxofTaskStatusPage.clear();
	                   searchboxofTaskStatusPage.click();
	                   searchboxofTaskStatusPage.sendKeys("WINDOWS-10-22H2", Keys.ENTER);
	                }

	            } catch (Exception e) {
	                System.out.println("⚠️ Error while checking status: " + e.getMessage());
	            }
	        }

	        if (!statusVerified) {
	            System.out.println("⏳ Timeout: Task did not complete within 15 minutes!");
	        } 
	    }
	

//
// public void switchtorelatedsite() {
//	try {
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(switchsitedropdown)).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(clickonmigrationsite)).click();
//		Thread.sleep(3000);
//		System.out.println("✅ Switched to related site successfully!");
//	}catch(Exception e) {
//		System.err.println("❌ Failed to switch related site");
//		
//	}
//}
	

@FindBy (xpath = "//div[@class='dfodthawed-ico']")
WebElement DFThawedIcon; 




























}
