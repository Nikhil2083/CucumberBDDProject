package Utilities;

import java.io.File;

public class FileUtils {

    public static boolean isFileDownloaded(String downloadDir, String fileName, int timeoutInSeconds) {
        File dir = new File(downloadDir);   // फक्त directory
        int waited = 0;

        while (waited < timeoutInSeconds) {
            File[] files = dir.listFiles();  // directory मधली सगळी files मिळव

            if (files != null) {
                for (File f : files) {
                    // फाईल नाव match झालं आणि .crdownload extension नाही
                    if (f.getName().equals(fileName) && !f.getName().endsWith(".crdownload")) {
                        return true;
                    }
                }
            }

            try {
                Thread.sleep(1000); // प्रत्येक 1 सेकंदाने check कर
                waited++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false; // timeout संपला आणि file सापडली नाही
    }
}
