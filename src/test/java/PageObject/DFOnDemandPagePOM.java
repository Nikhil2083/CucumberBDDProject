package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DFOnDemandPagePOM {
	WebDriver ldriver;
	WebDriverWait wait;
    
	//Constructor
	public DFOnDemandPagePOM(WebDriver rDriver) {
		ldriver = rDriver;
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(50));
		PageFactory.initElements(rDriver, this);
		
	}
	
	@FindBy (xpath = "//li[contains(@id,'DeepFreezeonDemand')]")
	WebElement DeepFreezeOnDemandPage;
	
	@FindBy (xpath = "//input[contains(@id,'SearchDeepFreeze')]")
	WebElement SearchboxofDFODpage;
	
////////////////////////////////////////split///////////////////////////////////////////////

	
	
}
