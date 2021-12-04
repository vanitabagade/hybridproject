package com.hybridproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridproject.pageObjects.LoginPage;
import com.hybridproject.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException
	{
		driver.get(base_url);
		
		driver.manage().window().maximize();
		
		logger.info("URL is opened.....");
		
		LoginPage lp=new LoginPage(driver);
		lp.setusername(user);
		logger.info("User provided"); //logger msg
		
		lp.setpassword(pwd);
		logger.info("Password provided");//logger msg
		
		lp.click();
		logger.info("Login in Clicked");//logger msg
		
		Thread.sleep(2000);
				
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.logout();
			Thread.sleep(5000);
			logger.info("Login Passed");//logger msg
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");//logger msg
		}
	}
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/hybridproject/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
		}
		
		return logindata;
	}
	
	
	
	
}
