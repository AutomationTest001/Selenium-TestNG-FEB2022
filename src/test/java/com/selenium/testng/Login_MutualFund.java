package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Login_MutualFund {
	
	WebDriver w;

	@BeforeTest
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority = 0,description = "Test case to verify login functionlity with 'admin' user",groups="LoginModule")
	public void loginAdmin()throws Exception {

		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.name("passw")).sendKeys("admin");
		w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
		Thread.sleep(3000); 
		w.findElement(By.linkText("Sign Off")).click();
		
		Reporter.log("Admin test cases executed !!!",true);
		
	

	}
	
	@Test(priority = 1,description = "Test case to verify login functionlity with 'tuser' user",groups="LoginModule",dependsOnMethods = "loginAdmin",enabled=false)
	public void loginTestUser()throws Exception {

		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.name("passw")).sendKeys("tuser");
		w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
		Thread.sleep(3000); 
		w.findElement(By.linkText("Sign Off")).click();

	}
	
	@Test(priority = 2,description = "Test case to verify login functionlity with 'jsmith' user",dependsOnMethods = "loginAdmin",groups="LoginModule",enabled = false)
	public void loginJsmithUser()throws Exception {

		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("jsmith");
		w.findElement(By.name("passw")).sendKeys("Demo1234");
		w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
		Thread.sleep(3000); 
		w.findElement(By.linkText("Sign Off")).click();

	}
	
	@Test(priority = 3,description = "Test case to verify login functionlity with invalid user",groups="LoginModule",enabled = false)
	public void loginInvalidUser()throws Exception {

		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("test");
		w.findElement(By.name("passw")).sendKeys("test@123");
		w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
		Thread.sleep(3000); 
		

	}
	
		
	


	@AfterTest
	public void postCondition() {
		w.close();
	}

}
