package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Code_For_IFrame_3 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test
	public void Code_For_IFrame_Test() throws Exception{
		
		w.get("http://demo.automationtesting.in/Frames.html");
		
		w.switchTo().frame("singleframe");
		
		w.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Selenium");
	}

	@AfterTest
	public void afterTest() {
	//	w.quit();
	}

}
