package PageObject;

import java.sql.Driver;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilitiesPagePOM {

	WebDriver ldriver;
	WebDriverWait wait;
    
	//Constructor
	public UtilitiesPagePOM(WebDriver rDriver) {
		ldriver = rDriver;
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(50));
		PageFactory.initElements(rDriver, this);
		
	}
	
	 
	
	
	 
}
