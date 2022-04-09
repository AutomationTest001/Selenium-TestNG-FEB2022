package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_CountElements_1 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test(priority = 0, description = "Test case to Count WebElements ")
	public void CountWebElement() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);

		// Count number of radio button on web page.

		
		List<WebElement> radioCount=w.findElements(By.name("radiooptions"));		
		System.out.println("Number of radio button on web page : "+radioCount.size());
		
		

		// Count number of checkbox on web page.
		
		List<WebElement> checkboxCount=w.findElements(By.cssSelector("input[type='checkbox']"));		
		System.out.println("Number of checkbox on web page : "+checkboxCount.size());
		
		
		
		// Count number of Dropdown on web page.
		
		List<WebElement> DropdownCount=w.findElements(By.tagName("select"));		
		System.out.println("Number of Dropdown on web page : "+DropdownCount.size());

		

		// Count number of links on web page.
		
		List<WebElement> linksCount=w.findElements(By.tagName("a"));		
		System.out.println("Number of links on web page : "+linksCount.size());

		

		Thread.sleep(2000);

	}

	@AfterTest
	public void afterTest() {

		w.close();
	}

}
