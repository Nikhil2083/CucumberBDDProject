package Utilities;

import java.io.File;

public class FileUtils {
    public static boolean isFileDownloaded(String downloadDir, String fileName, int timeoutInSeconds) {
    	
    	File dir = new File(downloadDir); 
        File file = new File(downloadDir + File.separator + fileName);
        int waited = 0;
        while (waited < timeoutInSeconds) {
            if (file.exists() && !file.getName().endsWith(".crdownload")) {
                return true;
            }
            try {
                Thread.sleep(1000);
                waited++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
