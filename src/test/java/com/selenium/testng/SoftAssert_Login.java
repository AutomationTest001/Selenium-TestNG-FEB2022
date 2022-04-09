package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class SoftAssert_Login {
	
	WebDriver w;
	SoftAssert st;

	@BeforeTest
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority = 0,description = "Test case to verify login functionlity with 'admin' user",groups="LoginModule")
	public void loginAdmin()throws Exception {
		
		st=new SoftAssert();

		w.get("http://altoromutual.com:8080/login.jsp");
		
		WebElement signInButton=w.findElement(By.id("LoginLink"));
		st.assertTrue(signInButton.isDisplayed(), "Sign In Link not displayed");
		
		String pageTitle=w.getTitle();
		String pageURL=w.getCurrentUrl();
		
		st.assertEquals(pageTitle, "Altoro Login");
		st.assertTrue(pageURL.contains("login123.jsp"), "URL is different");		
		
		WebElement pageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String pageLabelText=pageLabel.getText();		
		st.assertTrue(pageLabelText.contains("Login"), "Page Label doesn't contains login");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.name("passw")).sendKeys("admin");
		w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
		
		
	st.assertAll();

	}
	
	@Test(priority = 1,description = "Test case to verify logout functionlity for admin user",groups="LoginModule",dependsOnMethods = "loginAdmin")
	public void logoutAdmin()throws Exception {
		
		st=new SoftAssert();
		
		Thread.sleep(3000); 		
		
		String pageURL = w.getCurrentUrl();
		st.assertTrue(pageURL.contains("main.jsp"), "URL is different");
		
		WebElement pageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		String pageLabelText = pageLabel.getText();
		st.assertTrue(pageLabelText.contains("Admin"), "Page Label doesn't contains Admin");


		w.findElement(By.linkText("Sign Off")).click();
		
		Reporter.log("Admin test cases executed !!!",true);
		
		st.assertAll();
		
	}
	
		
	
		@AfterTest
	public void postCondition() {
		w.close();
	}

}
