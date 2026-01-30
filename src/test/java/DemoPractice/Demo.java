package DemoPractice;


	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Demo {

		public static void main(String[]arg) throws InterruptedException {
			 WebDriverManager.chromedriver().setup();
			 
			 WebDriver driver = new ChromeDriver();
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			 driver.get("https://www1.faronicsbeta.com/");
			 
			 driver.manage().window().maximize();
				
				WebElement emailid = driver.findElement(By.xpath("//input[@id='txtUserName']"));
				
				wait.until(ExpectedConditions.elementToBeClickable(emailid)).click();
				emailid.sendKeys("nikhilguravnkil@gmail.com");
				emailid.sendKeys(Keys.ENTER);   
				
				WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
				wait.until(ExpectedConditions.elementToBeClickable(password)).click();
				password.sendKeys("Aloha@123");
				password.sendKeys(Keys.ENTER);
				
				WebElement comp1 = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("COMPUTERS")));
				
				comp1.sendKeys(Keys.CONTROL,Keys.RETURN);
				
				String ftab = driver.getWindowHandle();
				Set<String> stab = driver.getWindowHandles();
				
				for(String Handel : stab) {
					if (!Handel.equals(ftab)) {
						driver.switchTo().window(Handel);
						break;
					}
				}
				WebElement comp2 = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("COMPUTERS")));
				comp2.click();
				Thread.sleep(2000);
				
				driver.close();
				
				driver.switchTo().window(ftab);
				comp1.click();
				Thread.sleep(2000);
				driver.quit();
		}
		
		
	}


