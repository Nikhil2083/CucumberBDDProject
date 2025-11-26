package DemoPractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadAgentAndInstall {

	public static void main(String[] args) throws InterruptedException {

		String vmName = "Windows1124H264Bit";
		String exeName = "FaronicsDeployAgent_Nik-RP.exe";
		String distPath = "C:/Users/Administrator/Downloads/FaronicsDeployAgent_Nik-RP.exe";
		String username = "Administrator";
		String password = "aloha";
		String vboxManagePath = "C:\\Program Files\\Oracle\\VirtualBox\\VBoxManage.exe";
		String policy = "Nik-RP";
		String downloadPath = "C:/Users/Administrator/Downloads";
		String fileName = "FaronicsDeployAgent_Nik-RP.exe";
		String machinename = "WINDOWS1124H264";

		System.setProperty("webdriver.chrome.driver", "K:\\chromedriver.exe");

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("safebrowsing.enabled", true);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebDriverWait longwait = new WebDriverWait(driver, Duration.ofMinutes(5));
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
				WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Password']")));
				pwd.sendKeys("Aloha@123", Keys.ENTER);
				System.out.println("Entered Password.");
			} catch (Exception e) {
				System.out.println("Failed to enter Password. " + e.getMessage());
			}

			try {
				WebElement clickondownloaddropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='optiondropdownMenu']")));
				clickondownloaddropdown.click();
				System.out.println("Clicked on Download Agent");
				Thread.sleep(1000);
				WebElement policyDropdown = driver.findElement(By.xpath("//div[@id='ddlDownloadAgentPolicy']//div[@class='dx-texteditor-container']"));
				policyDropdown.click();
				System.out.println("Clicked on Policy Drop-down");

				Actions actions = new Actions(driver);
				WebElement policyOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ddlDownloadAgentPolicyContainer']//div[text()='" + policy + "']")));
				actions.moveToElement(policyOption).click().build().perform();
				System.out.println(policy + " This Policy is Selected");

				wait.until(ExpectedConditions.elementToBeClickable(By.id("btnDownloadNow"))).click();
				System.out.println("Clicked on Download For Windows button");

				boolean isDownloaded = waitForFileDownload(downloadPath, fileName, 2000);
				if (isDownloaded) {
					System.out.println("File download complete: " + fileName);
					try {
						System.out.println("Powering on VirtualBox VM: " + vmName);
						runCommand(new String[] { vboxManagePath, "startvm", vmName });
						System.out.println("VM started successfully: " + vmName);
						
						System.out.println("Waiting for " + vmName + " to boot (90 seconds)...");
						Thread.sleep(Duration.ofSeconds(90).toMillis());

						String targetPath = "C:/Users/" + username + "/Desktop/" + exeName;
						System.out.println("Copying " + exeName + " to " + vmName + ": " + targetPath);

						runCommand(new String[] { vboxManagePath, "guestcontrol", vmName, "copyto", distPath, targetPath, "--username", username, "--password", password });
						System.out.println("Successfully copied to " + vmName + ": " + targetPath);

						Thread.sleep(5000);
						System.out.println("Running " + exeName + " on " + vmName);

//						String[] command = { vboxManagePath, "guestcontrol", vmName, "run", "--exe",
//											"C:\\\\Windows\\\\System32\\\\cmd.exe",
//											// "C:\\\\Windows\\\\System32\\\\WindowsPowerShell\\\\v1.0\\\\powershell.exe",
//											"--username", username, "--password", password, "--", "-Command","Start-Process '" + targetPath + "' -Wait" };
//						
						String[] command = {
				                   vboxManagePath, "guestcontrol", vmName, "run",
				                    "--exe", targetPath,
				                    "--username", username,
				                    "--password", password,
				                    "--",  "/S"  };
						
						
						String output = runCommand(command);
						
						if (!output.isEmpty()) {
							System.out.println(" " + vmName + " output: \n" + output);
						}
						
						System.out.println("VM automation completed successfully.");

					} catch (Exception e) {
						System.out.println("VM automation failed: " + e.getMessage());
					}

				} else {
					System.out.println("File download failed or timeout.");
					driver.close();
				}

			} catch (Exception e) {
				System.err.println("Not Able to click on Download Agent Drop-Down " + e.getMessage());
			}

			try {
				driver.navigate().refresh();

				longwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='" + machinename + "'])[1]//ancestor::tr//td[1]")));
				System.out.println("Machine is reported successfully: " + machinename);

			} catch (Exception e) {
				System.err.println(machinename + " This Machine is not reported successfully");
			}

		} catch (Exception e) {
			System.out.println("Test Failed due to exception: " + e.getMessage());
		}finally {
			System.out.println("Browser Close after 10sec...");
			Thread.sleep(10000);
			driver.quit();
			System.out.println("Browser Closed successfully...");
		}
	}

	public static boolean waitForFileDownload(String dirPath, String fileName, int timeoutSeconds) {
		File finalFile = new File(dirPath, fileName);
		File tempFile = new File(dirPath, fileName + ".crdownload");

		long endTime = System.currentTimeMillis() + (timeoutSeconds * 1000);

		while (System.currentTimeMillis() < endTime) {
			if (finalFile.exists() && !tempFile.exists()) {
				return true;
			}

			if (tempFile.exists()) {
				System.out.println("Download in progress...");
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return false; 
	}

	
	
	private static String runCommand(String[] command) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.redirectErrorStream(true);
		Process process = pb.start();

		StringBuilder output = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line).append(System.lineSeparator());
			}
		}
		int exitCode = process.waitFor();
		if (exitCode != 0) {
			throw new IOException("Command failed with exit code: " + exitCode + "\nOutput:\n" + output);
		}
		return output.toString().trim();
	}
}
