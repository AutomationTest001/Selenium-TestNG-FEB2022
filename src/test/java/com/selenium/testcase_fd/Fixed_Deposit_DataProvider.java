package com.selenium.testcase_fd;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

/*
 *  Author : Automation Test
 *  Description :
 *  Date : 
 * 
 */


public class Fixed_Deposit_DataProvider {
	
	WebDriver w;
  

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "100000", "8" , "5" , "Simple Interest"},
      new Object[] { "300000", "8.5" , "3" , "Simple Interest"},
      new Object[] { "700000", "4" , "2" , "Simple Interest"},
      new Object[] { "900000", "4" , "2" , "Simple Interest"},
    };
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
  }
  
  
  @Test(dataProvider = "dp")
  public void f(String principle, String roi,String tenure,String frequency) throws Exception {
	  
	  w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		w.findElement(By.id("principal")).sendKeys(principle);
		
		w.findElement(By.name("interest")).sendKeys(roi);
		
		w.findElement(By.name("tenure")).sendKeys(tenure);
		
		
		Select drop_down_tenurePeriod=new Select(w.findElement(By.name("tenurePeriod")));
		drop_down_tenurePeriod.selectByVisibleText("year(s)");
		
		Select drop_down_frequency=new Select(w.findElement(By.name("frequency")));
		drop_down_frequency.selectByVisibleText(frequency);		
		
		
	
		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
		Thread.sleep(3000); 
		
		System.out.println("Principle : "+principle);

	
  }

  @AfterTest
  public void afterTest() {
	  w.close();
  }
  
  

}
