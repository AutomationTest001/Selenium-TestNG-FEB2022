package com.selenium.testcase_fd;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Data_Driven_FixedDeposit {

	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet st;
	XSSFRow row;
	XSSFCell principle, ROI, tenurePeriod, frequency;
	
	WebDriver w;

	@BeforeTest
	public void beforeTest() throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();

		df = new DataFormatter();
		fi = new FileInputStream(".\\TestData\\FDCal.xlsx");
		wb = new XSSFWorkbook(fi);
		st = wb.getSheetAt(0);

	}

	@Test
	public void dataDriven_FD() throws Exception {

		int rowCount = st.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {

			// i = rows

			row = st.getRow(i);

			principle = row.getCell(0);
			ROI = row.getCell(1);
			tenurePeriod = row.getCell(2);
			frequency = row.getCell(3);
			
			
			w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
			
			w.findElement(By.id("principal")).sendKeys(df.formatCellValue(principle).toString());
			
			w.findElement(By.name("interest")).sendKeys(df.formatCellValue(ROI).toString());
			
			w.findElement(By.name("tenure")).sendKeys(df.formatCellValue(tenurePeriod).toString());
			
			
			Select drop_down_tenurePeriod=new Select(w.findElement(By.name("tenurePeriod")));
			drop_down_tenurePeriod.selectByVisibleText("year(s)");
			
			Select drop_down_frequency=new Select(w.findElement(By.name("frequency")));
			drop_down_frequency.selectByVisibleText(df.formatCellValue(frequency).toString());		
			
			
		
			w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
			Thread.sleep(3000); 

			System.out.println("Principle Value : " + principle);

			// Assert.assertEquals(fd.returnElementText(fd.outputValue), "118000.00");

		}
	}

	@AfterTest
	public void afterTest() throws Exception {
		
	}

}
