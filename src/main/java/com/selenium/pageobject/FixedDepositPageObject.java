package com.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedDepositPageObject extends TestBase {
	
	
	@FindBy(id = "principal")
	public WebElement principleTextBox;

	@FindBy(name = "interest")
	public WebElement interestTextBox;

	@FindBy(id = "tenure")
	public WebElement tenureTextBox;

	@FindBy(css = "select#tenurePeriod")
	public WebElement tenurePeriodDropDown;

	@FindBy(css = "select[name='frequency']")
	public WebElement frequencyDropDown;
	
	@FindBy(xpath = "//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement calculateBtn;
	
	@FindBy(xpath="//*[@id=\"resp_matval\"]/strong")
	public WebElement outputValue;
	
	
	public void callPageFactoryElements_FD() {
		
		PageFactory.initElements(w, this);
		
		
	}
	

}
