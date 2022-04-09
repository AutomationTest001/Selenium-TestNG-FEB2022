package com.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCode_WebDriverManager {
	
	WebDriver w;
	
	
  @Test(priority = 0,description = "Test Case to verify application on chrome browser")
  public void chrome() throws InterruptedException {
	  
	 WebDriverManager.chromedriver().setup();
	  w=new ChromeDriver();
	  w.get("https://blazedemo.com/");	  
	  Thread.sleep(1000);  
	  
  }
  
  @Test(priority = 1,description = "Test Case to verify application on firefox browser")
  public void firefox() throws Exception {
	  
	  WebDriverManager.firefoxdriver().setup();
	  w=new FirefoxDriver();
	  w.get("https://blazedemo.com/");	  
	  Thread.sleep(1000);
	  
	  
  }
  
  @Test(priority = 2,description = "Test Case to verify application on edge browser")
  public void edge() throws Exception {
	  
	  WebDriverManager.edgedriver().setup();
	  w=new EdgeDriver();
	  w.get("https://blazedemo.com/");	  
	  Thread.sleep(1000);
	  
  }
  
}
