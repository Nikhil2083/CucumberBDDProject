package Utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	Properties properties;
	
	String path = "D:\\Automation\\DeepFreezeTC\\Config.properties";
	
	//constructor
	public ReadConfig() {
		
		try {
			properties = new Properties();
			
			
			//to open config.properties file in input mode and load the file
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value!= null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
		
			
	}

	public String getUsername() {
		String value = properties.getProperty("username");
		if(value!= null)
			return value;
		else
			throw new RuntimeException("user not specified in config file.");
	}
	
	public String getPassword() {
		String value = properties.getProperty("password");
		if(value!= null)
			return value;
		else
			throw new RuntimeException("user password not specified in config file.");
	}
	
	public String getURL() {
		String value = properties.getProperty("baseURL");
		if(value!= null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
	}
	
}
