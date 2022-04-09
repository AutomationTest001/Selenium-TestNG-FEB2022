package com.selenium.basictest.selenium_training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws Exception{
		
		
		
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
	
		WebDriver w=new ChromeDriver();
		
		w.get("http://altoromutual.com:8080/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.name("passw")).sendKeys("admin");
		
		w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
		
		Thread.sleep(3000); // millisec 1000 = 1 sec
		
		w.findElement(By.linkText("Sign Off")).click();
		
		w.close();
		

	}

}
