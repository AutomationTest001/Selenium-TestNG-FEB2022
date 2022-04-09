package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_MouseHandle_7 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();	
	}

	@Test
	public void Code_For_MouseHandle_Test() throws Exception {
		
		Actions a=new Actions(w);

	/*
		w.get("https://www.ebay.com/");	
		
		WebElement Electronics=w.findElement(By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/a"));
		
		Electronics.click();
		
		Thread.sleep(2000);
		
		w.navigate().back();
		
		Thread.sleep(2000);	
		

		WebElement Electronics_New=w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		
		a.moveToElement(Electronics_New).build().perform();
		
		
		
		
		Thread.sleep(2000);
		
		w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a")).click();
		
		Thread.sleep(2000);
		
		//WebElement searchButton=w.findElement(By.id("gh-btn"));
		
		//a.doubleClick(searchButton).build().perform();
		

		//Right click

	   WebElement Apple_Cell_Phones_Smartphones=w.findElement(By.xpath("//*[@id=\"s0-16-12_2-0-1[0]-0-0\"]/ul/li[1]/a"));
   
	     a.moveToElement(Apple_Cell_Phones_Smartphones).contextClick().build().perform(); */
     
		
		w.get("http://crossbrowsertesting.github.io/drag-and-drop.html");
		
		Thread.sleep(2000);
		
		WebElement draggable=w.findElement(By.id("draggable"));
		WebElement droppable=w.findElement(By.id("droppable"));

		
		a.dragAndDrop(draggable, droppable).build().perform();
		
		
		
		
	}

	@AfterTest
	public void afterTest() {
	}
}
