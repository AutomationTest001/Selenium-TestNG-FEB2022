package com.selenium.testng;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadValueFrom_PropertiesFile {

	public static void main(String[] args) throws Exception{


		FileInputStream fin=new FileInputStream(".\\Config\\config.properties");
		
		Properties prop=new Properties();
		
		prop.load(fin);
		
		String url=prop.getProperty("fd_url");
		String browser=prop.getProperty("browser_info");
		
		System.out.println(url);
		System.out.println(browser);		
		
		fin.close();

	}

}
