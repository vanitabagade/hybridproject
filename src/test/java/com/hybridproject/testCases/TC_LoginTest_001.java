package com.hybridproject.testCases;



import java.io.IOException;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.hybridproject.pageObjects.LoginPage;




public class TC_LoginTest_001 extends BaseClass {
	

@Test
 void login_Test() throws InterruptedException, IOException {
    driver.get(base_url);
	
	 LoginPage loginPage=new LoginPage(driver); 
	 logger.info("username and password is provided");
	// loginPage.setusername(username);
	// loginPage.setpassword(password); 
	 loginPage.click(); 
	 logger.info("login button is clicked");
	 Thread.sleep(3000);
	 if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
		 
	 Assert.assertTrue(true);
	 loginPage.logout();
	 logger.info("test is passed ");
	 
	 }else {
		 Assert.assertTrue(false);
		 captureScreen(driver, "login_Test");
		 
		 logger.info("test is failed ");
	 }
	
}


}
