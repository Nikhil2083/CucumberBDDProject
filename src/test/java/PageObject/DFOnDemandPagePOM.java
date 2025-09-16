package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
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
}
