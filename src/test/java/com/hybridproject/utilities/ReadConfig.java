package com.hybridproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties properties;
public ReadConfig() {
	File src=new File("./configuration/config.properties");
	try {
		FileInputStream fileInputStream=new FileInputStream(src);
		properties=new Properties();
		properties.load(fileInputStream);
	}catch (Exception e) {
		System.out.println("Exception is:"+e.getMessage());
		// TODO: handle exception
	}
	
}
public String getappliationurl() {
	String url=properties.getProperty("base_url");
	return url;
	
	
}
public String getusername() {
	String url=properties.getProperty("username");
	return url;
	
	
}
public String getpassword() {
	String url=properties.getProperty("password");
	return url;
	
	
}
public String getchromepath() {
	String url=properties.getProperty("chromepath");
	return url;
	
	
}

}
