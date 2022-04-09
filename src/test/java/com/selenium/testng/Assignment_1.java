package com.selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_1 {
	WebDriver w;

	@BeforeTest
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority = 0,description = "Test case to verify Calculator functionlity for Addition")
	public void addFunctionality()throws Exception {

		w.get("https://juliemr.github.io/protractor-demo/");

		w.findElement(By.cssSelector("input[ng-model='first']")).clear();
		w.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("5");

		WebElement operator_dropdown=w.findElement(By.xpath("/html/body/div/div/form/select"));
				Select sc = new Select(operator_dropdown);
				sc.selectByVisibleText("+");

				w.findElement(By.cssSelector("input[ng-model='second']")).clear();
				w.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("5");
				
				w.findElement(By.id("gobutton")).click();
		Thread.sleep(2000);

		String outputValue=w.findElement(By.xpath("/html/body/div/div/form/h2")).getText();

		Assert.assertEquals(outputValue, "10");

	}
	
	@Test(priority = 1,description = "Test case to verify Calculator functionlity for Subtraction")
	public void subFunctionality()throws Exception {

		

		w.findElement(By.cssSelector("input[ng-model='first']")).clear();
		w.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("5");

		WebElement operator_dropdown=w.findElement(By.xpath("/html/body/div/div/form/select"));
				Select sc = new Select(operator_dropdown);
				sc.selectByVisibleText("-");

				w.findElement(By.cssSelector("input[ng-model='second']")).clear();
				w.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("2");
				
				w.findElement(By.id("gobutton")).click();
		Thread.sleep(2000);

		String outputValue=w.findElement(By.xpath("/html/body/div/div/form/h2")).getText();

		Assert.assertEquals(outputValue, "3");

	}
	
	
	@Test(priority = 2,description = "Test case to verify Calculator functionlity for Multiplication")
	public void mulFunctionality()throws Exception {

		

		w.findElement(By.cssSelector("input[ng-model='first']")).clear();
		w.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("3");

		WebElement operator_dropdown=w.findElement(By.xpath("/html/body/div/div/form/select"));
				Select sc = new Select(operator_dropdown);
				sc.selectByVisibleText("*");

				w.findElement(By.cssSelector("input[ng-model='second']")).clear();
				w.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("3");
				
				w.findElement(By.id("gobutton")).click();
		Thread.sleep(2000);

		String outputValue=w.findElement(By.xpath("/html/body/div/div/form/h2")).getText();

		Assert.assertEquals(outputValue, "9");

	}
	
	
	@Test(priority = 3,description = "Test case to verify Calculator functionlity for Division")
	public void divFunctionality()throws Exception {

		

		w.findElement(By.cssSelector("input[ng-model='first']")).clear();
		w.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("4");

		WebElement operator_dropdown=w.findElement(By.xpath("/html/body/div/div/form/select"));
				Select sc = new Select(operator_dropdown);
				sc.selectByVisibleText("/");

				w.findElement(By.cssSelector("input[ng-model='second']")).clear();
				w.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("2");
				
				w.findElement(By.id("gobutton")).click();
		Thread.sleep(2000);

		String outputValue=w.findElement(By.xpath("/html/body/div/div/form/h2")).getText();

		Assert.assertEquals(outputValue, "2");

	}

	@AfterTest
	public void afterTest() {

		w.close();
	}
}
