package com.selenium.testcase_fd;

import org.testng.annotations.Test;

import com.selenium.pageobject.FixedDepositPageObject;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.AfterTest;

public class Data_Driven_FD {

	FixedDepositPageObject fd;
	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet st;
	XSSFRow row;
	XSSFCell principle, ROI, tenurePeriod, frequency;

	@BeforeTest
	public void beforeTest() throws Exception {

		fd = new FixedDepositPageObject();
		fd.openBrowser(fd.readDataPropertiesFile("browser_info"));
		fd.callPageFactoryElements_FD();

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

			fd.openApplication();

			fd.handleTextBox(fd.principleTextBox, df.formatCellValue(principle).toString());

			fd.handleTextBox(fd.interestTextBox, df.formatCellValue(ROI).toString());

			fd.handleTextBox(fd.tenureTextBox, df.formatCellValue(tenurePeriod).toString());

			fd.handleDropDownList(fd.tenurePeriodDropDown, "year(s)");

			fd.handleDropDownList(fd.frequencyDropDown, df.formatCellValue(frequency).toString());

			fd.handleClickEvent(fd.calculateBtn);

			fd.waitSec(2);

			System.out.println("Principle Value : " + principle);

			// Assert.assertEquals(fd.returnElementText(fd.outputValue), "118000.00");

		}
	}

	@AfterTest
	public void afterTest() throws Exception {
		fd.closeBrowser();
		fi.close();
	}

}
