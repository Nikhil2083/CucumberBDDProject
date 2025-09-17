package Utilities;

import java.io.File;

public class FileUtils {

    public static boolean isFileDownloaded(String downloadDir, String fileName, int timeoutInSeconds) {
        //File dir = new File(downloadDir);
        File dir = new File(downloadDir + File.separator + fileName);
        int waited = 0;

        while (waited < timeoutInSeconds) {
            // Refresh the list of files in directory
            File[] files = dir.listFiles();

            if (files != null) {
                for (File f : files) {
                    if (f.getName().equals(fileName) && !f.getName().endsWith(".crdownload")) {
                        return true;
                    }
                }
            }

            try {
                Thread.sleep(1000); // Check every 1 second
                waited++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false; // timeout reached and file not found
    }
}