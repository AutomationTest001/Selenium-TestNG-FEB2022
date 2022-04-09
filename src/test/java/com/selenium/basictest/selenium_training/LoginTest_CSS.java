package com.selenium.basictest.selenium_training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_CSS {

	public static void main(String[] args) throws Exception{


		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		
		WebDriver w=new ChromeDriver();
		
		w.get("https://opensource-demo.orangehrmlive.com/");
		
		w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		
		w.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		
		Thread.sleep(3000);
		
		w.findElement(By.cssSelector("a#welcome")).click();
		
		
		Thread.sleep(3000);
		
		w.findElement(By.linkText("Logout")).click();
		
		w.close();
		
		System.out.println("Orange HRM Login test cases passed !!");

	}

}
