package com.selenium.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	static WebDriver w;

	String application_url = "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html";

	public void openBrowser(String br) {

		if (br.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			w = new ChromeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else if (br.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else if (br.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			w = new EdgeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	}

	public void closeBrowser() {

		w.close();
	}

	public void openApplication() {
		w.get(application_url);
	}

	public void handleTextBox(WebElement we, String value) {

		we.clear();
		we.sendKeys(value);

	}

	public void handleDropDownList(WebElement we, String value) {

		Select sc = new Select(we);
		sc.selectByVisibleText(value);

	}

	public void handleClickEvent(WebElement we) {

		we.click();

	}

	public void waitSec(int sec) throws Exception {

		sec = sec * 1000;

		Thread.sleep(sec);
	}

	public void handleAlert() {

		try {
			w.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {

		}
	}

	public void handleFrame(String id) {
		w.switchTo().frame(id);
	}

	public void explicitWait(By we) {
		WebDriverWait wt = new WebDriverWait(w, 60);
		wt.until(ExpectedConditions.visibilityOfElementLocated(we));

	}

	public String returnPageTitle() {

		return w.getTitle();
	}

	public String returnElementText(WebElement we) {

		return we.getText();
	}

	public String readDataPropertiesFile(String key) throws Exception {

		FileInputStream fin = new FileInputStream(".\\Config\\config.properties");
		
		Properties prop = new Properties();
		prop.load(fin);
		
		String value = prop.getProperty(key);	
		
		fin.close();
		
		return value;

	}
	
	
	public static void captureScreenshot(String filePath) throws Exception {
		
		TakesScreenshot ts=(TakesScreenshot) w;	       
	       File f=ts.getScreenshotAs(OutputType.FILE);       
	       FileUtils.copyFile(f, new File(filePath));
		
	}

}
