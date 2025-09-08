package StepDefinition;

import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import PageObject.PageObjectForDeepFreezeSuite;
import Utilities.ReadConfig;

public class BaseClass {
	ArrayList<String> tabs;
	
    public static WebDriver driver;
    public PageObjectForDeepFreezeSuite DeepFreezeSuitePg;
    //public StepDefinitionForDeepFreezeSuites HooksConcept;
    
    public static ReadConfig readConfig = new ReadConfig();

    // Logger initialized statically
    public static Logger log = LogManager.getLogger(BaseClass.class);

    /**
     * ChromeOptions for automatic download & bypassing protection
     */
    public static ChromeOptions getChromeOptions() {

        String downloadPath = readConfig.getDownloadPath();

        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("safebrowsing.disable_download_protection", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Headless mode check
        if (readConfig.getHeadless().equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
        }

        // Bypass security features
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");

        return options;
    }
}
