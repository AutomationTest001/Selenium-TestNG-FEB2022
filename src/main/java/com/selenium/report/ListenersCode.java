package com.selenium.report;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.selenium.pageobject.TestBase;

public class ListenersCode implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Case Passed : " + result.getMethod().getMethodName());
		
		try {
			TestBase.captureScreenshot(".\\Screenshot\\Pass\\"+result.getMethod().getMethodName()+".png");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case Failed : " + result.getMethod().getMethodName());
		
		try {
			TestBase.captureScreenshot(".\\Screenshot\\Fail\\"+result.getMethod().getMethodName()+".png");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Case Skipped : " + result.getMethod().getMethodName());
		
		try {
			TestBase.captureScreenshot(".\\Screenshot\\Skip\\"+result.getMethod().getMethodName()+".png");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
