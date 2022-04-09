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

public class WebObject_DropDown {

	WebDriver w;

	@BeforeTest
	public void preCondition() {
	//	System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Test Case to handle drop-down list (Skills)")
	public void handleDropDownList_Skills() {

		w.get("http://demo.automationtesting.in/Register.html");

		String languageToSearch = "Java";
		boolean flag = false;

		WebElement Skills = w.findElement(By.id("Skills"));
		Select sel = new Select(Skills);

		List<WebElement> dataDropDown = sel.getOptions();
		int numberOfValue = dataDropDown.size();

		System.out.println("\nValue from Skills drop down : \n");

		// Using For Loop

		for (int i = 0; i < numberOfValue; i++) {

			System.out.println(dataDropDown.get(i).getText());
		}

		
		//Searching 'Java' inside drop down
		for (int i = 0; i < numberOfValue; i++) {

			String dropDownValue = dataDropDown.get(i).getText();

			if (dropDownValue.equals(languageToSearch)) {

				flag = true;
				break;
			}
		}

		if (flag == true) {
			System.out.println("Java Found");
			sel.selectByVisibleText(languageToSearch);
		} else {
			System.out.println("Java not found !!!!");
		}

	}

	@Test(priority = 1, description = "Test Case to handle list-Box (Country)")
	public void handleListBoxCountry() throws Exception {

		w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")).click();

		Thread.sleep(2000);

		w.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("I");

		Thread.sleep(2000);

		w.findElement(By.xpath("//li[text()='India']")).click();

	}

	@AfterTest
	public void afterTest() {
	}

}
