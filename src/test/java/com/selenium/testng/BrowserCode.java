package com.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserCode {
	
	WebDriver w;
	
	
  @Test(priority = 0,description = "Test Case to verify application on chrome browser")
  public void chrome() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
	  w=new ChromeDriver();
	  w.get("https://blazedemo.com/");	  
	  Thread.sleep(1000);  
	  
  }
  
  @Test(priority = 1,description = "Test Case to verify application on firefox browser")
  public void firefox() throws Exception {
	  
	  System.setProperty("webdriver.gecko.driver", ".\\Browser_Driver\\geckodriver.exe");	  
	  w=new FirefoxDriver();
	  w.get("https://blazedemo.com/");	  
	  Thread.sleep(1000);
	  
	  
  }
  
  @Test(priority = 2,description = "Test Case to verify application on edge browser")
  public void edge() throws Exception {
	  
	  System.setProperty("webdriver.edge.driver", ".\\Browser_Driver\\msedgedriver.exe");	  
	  w=new EdgeDriver();
	  w.get("https://blazedemo.com/");	  
	  Thread.sleep(1000);
	  
  }
  
}
