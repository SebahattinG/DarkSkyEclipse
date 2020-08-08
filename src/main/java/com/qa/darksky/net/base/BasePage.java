package com.qa.darksky.net.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	public static String highlightelement;
	public OptionsManager optionsManager;
	
	
	public WebDriver init_driver(String browserName){
		System.out.println("Browser name is " + browserName);
		highlightelement = prop.getProperty("highlight");
		optionsManager =new OptionsManager(prop);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(optionsManager.getChromeOptions());
		}
		
			
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(optionsManager.getFireFoxOptions());}
		
			
		else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver= new SafariDriver();	}
		else {
			System.out.println("Browser name " + browserName + "is not found. ");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//driver.get(prop.getProperty("url"));
		return driver;
		
	}
	
	// properties is created to reach config datas
	public Properties init_properties(){
	 prop= new Properties();
	 
	 String path = "/Users/sebahattingokaydin/eclipse-workspace/DarkSky_TESTNG/src/main/java/com/qa/darksky/net/config/config.properties";
	try {
		FileInputStream ip= new FileInputStream(path);
		prop.load(ip);
	} catch (FileNotFoundException e) {
		System.out.println("some issue happened with config properties");
	}
	catch (IOException e) {
		e.printStackTrace();
	}return prop;
	
	
	
	
	
	
	
	}

}

