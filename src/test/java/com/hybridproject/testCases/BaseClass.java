package com.hybridproject.testCases;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hybridproject.utilities.ReadConfig;

public class BaseClass {
	 ReadConfig config=new ReadConfig();
	 public String base_url=config.getappliationurl();
	 public String username=config.getusername();
	 public String password=config.getpassword();
	 public WebDriver driver;
	 
	 public static Logger logger;

	
	
	@BeforeClass  
	
	 @Test
	 @Parameters("browser")
	  void setup(String br) {
		        if(br.equals("chrome")) {
		    	System.setProperty("webdriver.chrome.driver",config.getchromepath());
				driver=new ChromeDriver();	
		        }
				
		 
				 logger = LogManager.getLogger(BaseClass.class);
         	  

				
		  
    
	 	
	}
	@AfterClass
	void logout() {
		driver.close();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
