package DemoPractice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;


public class InstallAgentOnVMUsingCMD {

		public static void main(String[] args) {

			String vmName = "Windows1124H264Bit"; // VM Name
			String exeName = "FaronicsDeployAgent.exe"; // Executable file name
			String distPath = "C:/Users/Administrator/Downloads/FaronicsDeployAgent_Nik-RP.exe"; // Local path of exe "C:\Users\Administrator\Downloads\FaronicsDeployAgent_Nik-RP.exe"
			String username = "Administrator"; // VM Username
			String password = "aloha"; // VM Password
			String vboxManagePath = "C:\\Program Files\\Oracle\\VirtualBox\\VBoxManage.exe";

			try {
				// 1. Start VM
				System.out.println("Powering on VirtualBox VM: " + vmName);
				runCommand(new String[] { vboxManagePath, "startvm", vmName });
				System.out.println("VM started successfully: " + vmName);

				// 2. Wait for VM to boot
				System.out.println("Waiting for " + vmName + " to boot (90 seconds)...");
				Thread.sleep(Duration.ofSeconds(90).toMillis());

				// 3. Copy exe to Desktop inside VM
				String targetPath = "C:/Users/" + username + "/Desktop/" + exeName;
				System.out.println("Copying " + exeName + " to " + vmName + ": " + targetPath);

				runCommand(new String[] { vboxManagePath, "guestcontrol", vmName, "copyto", distPath, targetPath,"--username", username, "--password", password });
				System.out.println("Successfully copied to " + vmName + ": " + targetPath);

				// 4. Run exe using PowerShell inside VM
				Thread.sleep(5000);
				System.out.println("Running " + exeName + " on " + vmName);

//				String[] command = { vboxManagePath, "guestcontrol", vmName, "run",
				//			"--exe", "C:\\Windows\\System32\\cmd.exe",
				//			"--username", username, "--password", password,
				//			"--", "/c", targetPath };
				
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
		}

		// Helper method to run VBoxManage commands
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


