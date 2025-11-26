package DemoPractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeployDemo {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "K:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.manage().window().maximize();

        try {
            driver.get("https://deployqa.deepfreeze.com/");
            System.out.println("Opened URL successfully.");

          
            try {
                WebElement emailid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='txtLoginEmail']")));
                emailid.sendKeys("nikhilguravnkil@gmail.com", Keys.ENTER);
                System.out.println("Entered Email.");
            } catch (Exception e) {
                System.out.println("Failed to enter Email. " + e.getMessage());
            }

            try {
                WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Password']")));
                password.sendKeys("Aloha@123", Keys.ENTER);
                System.out.println("Entered Password.");
            } catch (Exception e) {
                System.out.println("Failed to enter Password. " + e.getMessage());
            }

            
            try {
                WebElement searchbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#txtSearchPendingUpdates")));
                searchbox.sendKeys("WIN1125H264BIT", Keys.ENTER);
                System.out.println("Computer searched.");
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Failed to search computer. " + e.getMessage());
            }

          
            try {
                WebElement comp = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[3]/div/div/div/div/div[3]/div[2]/div/div/div[6]/div[2]/table/tbody/tr[1]/td[1]/div/div/span")));
                comp.click();
                System.out.println("Selected computer.");
            } catch (Exception e) {
                System.out.println("Failed to select computer. " + e.getMessage());
            }

            
            try {
                WebElement actionbtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("dvCompActionsDDBtn")));
                actionbtn.click();
                System.out.println("Action button clicked.");

                WebElement clickonremote = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Remote']")));
                clickonremote.click();
                System.out.println("Remote option clicked.");

                WebElement clickonremotepro = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Remote Pro')]")));
                clickonremotepro.click();
                System.out.println("Remote Pro clicked.");

              
              
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='connectingRCP textColorWhite']")));
                    System.out.println("Remote is in connecting state...");

                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='connectingRCP textColorWhite d-none']")));
                    System.out.println("Remote session connected successfully, Test Passed.");
                } catch (Exception e) {
                    System.out.println("Remote session validation failed. " + e.getMessage());
                }

            } catch (Exception e) {
                System.out.println("Failed during Remote flow. " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Test Failed due to exception: " + e.getMessage());
        } finally {
        	System.out.println("Browser Close after 10sec...");
			Thread.sleep(10000);
			driver.quit();
			System.out.println("Browser Closed successfully...");
        }
    }
}
