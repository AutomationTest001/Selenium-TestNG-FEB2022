package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Basic_WebObject {

	WebDriver w;

	@BeforeTest
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Test Case to handle textbox")
	public void handleTextBox() {

		w.get("http://demo.automationtesting.in/Register.html");

		WebElement firstName = w.findElement(By.cssSelector("input[ng-model='FirstName']"));

		firstName.clear();
		firstName.sendKeys("Steve");

		w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Jones");

	}

	@Test(priority = 1, description = "Test Case to handle textbox Area")
	public void handleTextArea() {

		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("sample test address");
	}

	@Test(priority = 2, description = "Test Case to handle radio button")
	public void handleRadioButton() {
		
		w.findElement(By.cssSelector("input[value='FeMale']")).click();
	}

	@Test(priority = 3, description = "Test Case to handle checkbox")
	public void handleCheckbox() {

		w.findElement(By.cssSelector(" input[value='Cricket']")).click();
	}

	@Test(priority = 4, description = "Test Case to handle drop-down list")
	public void handleDropDownList() {
		
		WebElement Skills=w.findElement(By.id("Skills"));		
		Select sel=new Select(Skills);			
			
	     List<WebElement> dataDropDown = sel.getOptions();
	     int numberOfValue=dataDropDown.size();
	     
	     System.out.println("\n Value from Skills drop down : \n");
	     
	     //Using For Loop	     
	    /* for(int i=0;i<numberOfValue;i++) {
	    	 
	    	 System.out.println(dataDropDown.get(i).getText());
	     }
	     
	     // Using For Each Loop	     
	    /* for(WebElement data : dataDropDown ) {
	    	 
	    	 System.out.println(data.getText());
	     }*/
	     
	     //Using Iterator	     
	     Iterator<WebElement> it=dataDropDown.iterator();
	     
	     while(it.hasNext()) {
	    	 
	    	 System.out.println(it.next().getText());
	     }
	     
	}
	
	
	@Test(priority = 5, description = "Test Case to handle list-Box")
	public void handleListBox() throws Exception {
		
		w.findElement(By.id("msdd")).click();
		Thread.sleep(2000);
		
		List<WebElement> li=w.findElements(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li"));
		int li_size=li.size();
		
		for(int i=1;i<li_size;i++) {
			
			String listBox_Value=w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li["+i+"]/a")).getText();
			
			System.out.println(listBox_Value);
		}
		
		Thread.sleep(2000);
		
	/*	
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")).click();
		*/
		
	}

	@AfterTest
	public void afterTest() {
	}

}
