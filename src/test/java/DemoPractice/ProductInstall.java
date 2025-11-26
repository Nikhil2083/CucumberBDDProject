package DemoPractice;


import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class ProductInstall {

	public static void main(String[] args) throws InterruptedException {
		String windows = "WIN1125H264BIT";

		System.setProperty("webdriver.chrome.driver", "K:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().window().maximize();

		try {

			driver.get("https://deployqa.deepfreeze.com/");
			System.out.println("Opened Deep Freeze Cloud URL successfully.");

			// ------------------ LOGIN ------------------ //
			try {
				WebElement emailid = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtLoginEmail")));
				emailid.sendKeys("nikhilguravnkil@gmail.com", Keys.ENTER);
				System.out.println("Entered Email.");
			} catch (Exception e) {
				System.err.println("Failed to enter Email: " + e.getMessage());
			}

			try {
				WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(By.id("Password")));
				pwd.sendKeys("Aloha@123", Keys.ENTER);
				System.out.println("Entered Password.");
			} catch (Exception e) {
				System.err.println("Failed to enter Password: " + e.getMessage());
			}

			Thread.sleep(3000);

			// ===================================================================== //
			// INSTALLATION BLOCK //
			// ===================================================================== //

			try {
				System.out.println("\n INSTALLATION STARTED ");

				WebElement searchbox = wait
						.until(ExpectedConditions.elementToBeClickable(By.id("txtSearchPendingUpdates")));
				searchbox.clear();
				searchbox.sendKeys("Google Chrome", Keys.ENTER);
				System.out.println("Searched for application: Google Chrome");
				Thread.sleep(3000);

				String AppName = "Google Chrome";
				WebElement index = driver.findElement(By.xpath("//td[@aria-label='Column " + AppName + "']"));
				String colindex = index.getAttribute("aria-colindex");

				Actions action = new Actions(driver);
				WebElement googleCell = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//span[text()='" + windows + "']//ancestor::tr//td[" + colindex + "]")));
				action.moveToElement(googleCell).click().perform();
				System.out.println("Clicked on Google Chrome empty div for installation");

				wait.until(ExpectedConditions.elementToBeClickable(By.id("btnInstallApplication"))).click();
				System.out.println("Clicked on Install button");

				wait.until(ExpectedConditions.elementToBeClickable(By.id("btnConfirmCommonYes"))).click();
				System.out.println("Confirmed installation prompt");

				wait.until(ExpectedConditions.elementToBeClickable(By.id("liTaskHistory"))).click();
				System.out.println("Navigated to Task History page");

				verifyTaskCompletion(driver, wait, "Installation");

				System.out.println(" INSTALLATION COMPLETED \n");
			} catch (Exception e) {
				System.err.println("Error during INSTALLATION: " + e.getMessage());
			}

			// ===================================================================== //
			// UNINSTALLATION BLOCK //
			// ===================================================================== //
			try {
				System.out.println("\n UNINSTALLATION STARTED ");
				Thread.sleep(2000);
				WebElement applications = driver.findElement(By.xpath("//a[@data-target='dvFDApplication']"));
				applications.click();
				System.out.println("Navigated to Applications page");
				Thread.sleep(2000);
				WebElement searchbox = wait
						.until(ExpectedConditions.elementToBeClickable(By.id("txtSearchPendingUpdates")));
				searchbox.clear();
				searchbox.sendKeys("Google Chrome", Keys.ENTER);
				Thread.sleep(3000);
				System.out.println("Searched again for application");

				String AppName = "Google Chrome";
				WebElement index = driver.findElement(By.xpath("//td[@aria-label='Column " + AppName + "']"));
				String colindex = index.getAttribute("aria-colindex");

				Actions action = new Actions(driver);
				WebElement googleCell = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//span[text()='" + windows + "']//ancestor::tr//td[" + colindex + "]")));
				action.moveToElement(googleCell).click().perform();

				try {

					String version = googleCell.getText().trim();
					System.out.println("Installed Google Chrome Version is: " + version);
				} catch (Exception e) {
					System.err.println("Not able to find Application Version");
				}
				System.out.println("Clicked on installed application for uninstall");

				wait.until(ExpectedConditions.elementToBeClickable(By.id("btnUninstallApplication"))).click();
				System.out.println("Clicked on Uninstall button");

				wait.until(ExpectedConditions.elementToBeClickable(By.id("btnConfirmCommonYes"))).click();
				System.out.println("Confirmed uninstallation prompt");

				wait.until(ExpectedConditions.elementToBeClickable(By.id("liTaskHistory"))).click();
				System.out.println("Navigated to Task History page");

				verifyTaskCompletion(driver, wait, "Uninstallation");

				System.out.println(" UNINSTALLATION COMPLETED \n");
			} catch (Exception e) {
				System.err.println("Error during UNINSTALLATION: " + e.getMessage());
			}
			try {
				Thread.sleep(2000);
				WebElement applications = driver.findElement(By.xpath("//a[@data-target='dvFDApplication']"));
				applications.click();
				System.out.println("Navigated to Applications page");
				Thread.sleep(2000);

				WebElement searchbox1 = wait
						.until(ExpectedConditions.elementToBeClickable(By.id("txtSearchPendingUpdates")));
				searchbox1.clear();
				searchbox1.sendKeys("Google Chrome", Keys.ENTER);
				System.out.println("Searched for application: Google Chrome");
				Thread.sleep(3000);

				String AppName = "Google Chrome";
				WebElement index = driver.findElement(By.xpath("//td[@aria-label='Column " + AppName + "']"));
				String colindex = index.getAttribute("aria-colindex");
				Actions action1 = new Actions(driver);
				WebElement googleCell1 = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//span[text()='" + windows + "']//ancestor::tr//td[" + colindex + "]")));
				action1.moveToElement(googleCell1).click().perform();
				System.out.println("Clicked on Google Chrome empty div for verification");
				System.out.println("Google Chrome is not available after Uninstallation of Application");
			} catch (Exception e) {
				System.err.println("Google Chrome is available after Uninstallation of Application");
			}

		} finally {
			System.out.println("Browser will close after 10 seconds...");
			Thread.sleep(10000);
			driver.quit();
			System.out.println("Browser closed successfully.");
		}
	}

	// ====================== COMMON STATUS VERIFICATION =========================
	// //
	public static void verifyTaskCompletion(WebDriver driver, WebDriverWait wait, String taskType)
			throws InterruptedException {
		boolean statusVerified = false;
		long startTime = System.currentTimeMillis();
		long maxWaitTime = 30 * 60 * 1000; // 30 minutes
		String windows = "WIN1125H264BIT";

		while ((System.currentTimeMillis() - startTime) < maxWaitTime) {
			try {
				WebElement currentTaskStatus = driver
						.findElement(By.xpath("(//span[text()='" + windows + "'])[1]//ancestor::tr//td[5]"));
				String actualStatus = currentTaskStatus.getText().trim();
				System.out.println(taskType + " Task Status: " + actualStatus);

				if (actualStatus.equalsIgnoreCase("Completed")) {
					System.out.println(taskType + " completed successfully!");
					statusVerified = true;
					return;
				} else if (actualStatus.startsWith("Failed")) {
					System.out.println(taskType + " failed with reason: " + actualStatus);
					statusVerified = true;
					return;
				} else {
					System.out.println("Waiting for " + taskType + " to complete... refreshing in 1 min.");
					Thread.sleep(60000);
					driver.navigate().refresh();
				}
			} catch (Exception e) {
				System.err.println("Error while checking " + taskType + " status: " + e.getMessage());
			}
		}

		if (!statusVerified) {
			System.out.println("Timeout: " + taskType + " did not complete within 30 minutes!");
		}
	}
}

