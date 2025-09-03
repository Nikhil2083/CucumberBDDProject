package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    String path = "D:\\Automation\\DeepFreezeTC\\Config.properties";

    // constructor
    public ReadConfig() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getURL() {
        return properties.getProperty("baseURL");
    }

    public String getDownloadPath() {
        return System.getProperty("user.dir") + "\\" + properties.getProperty("downloadPath");
    }

    public String getReportPath() {
        return System.getProperty("user.dir") + "\\" + properties.getProperty("reportPath");
    }

    public String getEnvironment() {
        return properties.getProperty("environment");
    }

    public String getHeadless() {
        return properties.getProperty("headless");
    }

    public int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicitWait"));
    }

    public int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("pageLoadTimeout"));
    }
}
