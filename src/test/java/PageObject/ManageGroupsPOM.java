package PageObject;

import static org.testng.Assert.fail;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ManageGroupsPOM {
	WebDriver ldriver;
	WebDriverWait wait;
	WebDriverWait Longwait;

	// Constructor 
	public ManageGroupsPOM(WebDriver rDriver) {
		ldriver = rDriver;
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(50));
		Longwait = new WebDriverWait(ldriver, Duration.ofMinutes(15));
		PageFactory.initElements(rDriver, this);
	}
	
	
	
	
	
	
	@FindBy(id="Groups")
	WebElement groupspage;
	
	@FindBy(xpath = "//div[@role='document']//div[@id='AddGroupPopup']")
	WebElement verifyaddgroupdialogappeared;
	
	@FindBy(xpath = "//span[@class='imgTextHome']")
	WebElement AddGroupBTN;
	
	@FindBy(xpath = "//button[contains(@id,'btnAddGroup')]")
	WebElement ADDbtn;
	
	@FindBy(xpath = "//span[contains(@id,'Name-error')]")
	WebElement requiredfillederror;
	
////////////////////////////////////////split///////////////////////////////////////////////
	
	public void errorappears() {
		try {
			WebElement ErrorMSG = wait.until(ExpectedConditions.visibilityOf(requiredfillederror));
			 String Actualtext = ErrorMSG.getText().trim();
			 String Expectedtext = "Required.";
			 
			 Assert.assertEquals(Actualtext, Expectedtext, "Error text mismatch!");
			 System.out.println("Error Appeared and failed to ADD Group: " + Actualtext );
			
		} catch (Exception e) {
			Assert.fail("Failed to show error message when ADD group with empty name.");
			System.err.println("error message not appeared on Add Groups dialog" + e);
		}
		
	}  

	public void ClickonADDBtn() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ADDbtn)).click();
			System.out.println("clicked on ADD button");
			
		} catch (Exception e) {
			System.err.println("not able to click on ADD button" + e);
		}
	}
	
	public void AddGroupsDialogAppeared() {
		try {
		WebElement addgroupsdialoglaunched =	wait.until(ExpectedConditions.visibilityOf(verifyaddgroupdialogappeared));
		Assert.assertTrue(addgroupsdialoglaunched.isDisplayed(),"Add Groups Dialog is NOT displayed");
		
		//Assert.assertEquals(false, null);
		System.out.println("Add Groups Dialog Appeared or Launched");
		} catch (Exception e) {
			Assert.fail("Task Failed, Add Groups Dialog not appeared or Launched" + e.getMessage());
		}
		
	}
	
	public void  clickonaddgroupsbutton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddGroupBTN)).click();
			System.out.println("Clicked on Add groups button");
		} catch (Exception e) {
			System.err.println("Not able to click Add Groups Button." + e);
		}
	}
	
	public void addgroupsbutton() {
		try {
			Longwait.until(ExpectedConditions.presenceOfElementLocated(By.id("addGroupButton")));
			System.out.println("Add Groups Button is displayed on groups page.");
		} catch (Exception e) {
			System.err.println("Add Groups Button not displayed on Groups Page." + e);
		}
	}       
	
	public void clickonGroupsPage() {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(groupspage)).click();
		System.out.println("Clicked on Groups Page");
			
		} catch (Exception e) {
			System.err.println("Not able to click on Groups page" + e);
		}
	}
			
			
	
	

}
