package com.selenium.testcase_fd;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {

	public static void main(String[] args) throws Exception{
		
		DataFormatter df=new DataFormatter();
		
		FileInputStream fi=new FileInputStream(".\\TestData\\FDCal.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		
		XSSFSheet st=wb.getSheetAt(0);
		
		XSSFRow row=st.getRow(1);
		
		XSSFCell cell=row.getCell(0);
		
		
		System.out.println(df.formatCellValue(cell));
		
		
		
		fi.close();

	}

}
