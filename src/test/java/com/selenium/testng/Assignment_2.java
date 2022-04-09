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
import org.testng.asserts.SoftAssert;

public class Assignment_2 {

	WebDriver w;
	SoftAssert st;

	@BeforeTest
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Test case to verify 'blazedemo.com' home page")
	public void homePage() throws Exception {

		w.get("https://blazedemo.com/");

		String pageTitle = w.getTitle();

		Assert.assertEquals(pageTitle, "BlazeDemo");

		WebElement departure_city_dropdown = w.findElement(By.name("fromPort"));
		Select departure_city = new Select(departure_city_dropdown);
		departure_city.selectByVisibleText("Boston");

		WebElement destination_city_dropdown = w.findElement(By.name("toPort"));
		Select destination_city = new Select(destination_city_dropdown);
		destination_city.selectByVisibleText("London");

		w.findElement(By.cssSelector("input[type='submit']")).click();

		Thread.sleep(2000);
	}

	@Test(priority = 1, description = "Test case to verify 'blazedemo.com' reserve page")
	public void reservePage() throws Exception {

		String pageLabel = w.findElement(By.xpath("/html/body/div[2]/h3")).getText();

		Assert.assertEquals(pageLabel, "Flights from Boston to London:");

		w.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]/input")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2, description = "Test case to verify 'blazedemo.com' purchase page")
	public void purchasePage() throws Exception {

		st = new SoftAssert();

		String pageTitle = w.getTitle();
		String pageLabel = w.findElement(By.xpath("/html/body/div[2]/h2")).getText();

		st.assertEquals(pageTitle, "BlazeDemo Purchase");
		st.assertEquals(pageLabel, "Your flight from TLV to SFO has been reserved.");

		String airline = w.findElement(By.xpath("/html/body/div[2]/p[1]")).getText();
		String Flight_Number = w.findElement(By.xpath("/html/body/div[2]/p[2]")).getText();

		st.assertTrue(airline.contains("United"), "Airline is not United");
		st.assertTrue(Flight_Number.contains("UA954"), "FlightNumber doesn't contains UA954");

		String price = w.findElement(By.xpath("/html/body/div[2]/p[3]")).getText(); // Price: 400
		
		String Arbitrary_Fees_and_Taxes = w.findElement(By.xpath("/html/body/div[2]/p[4]")).getText();
		String total_Price = w.findElement(By.xpath("/html/body/div[2]/p[5]/em")).getText();

		// Price Code
		
		 // Price: 400
		
		//[0]=Price:
		//	[1]=400
		
		

		String priceValue[] = price.split(" ");
		int priceInNumber = Integer.parseInt(priceValue[1]);

		System.out.println(priceInNumber);

		// Arbitrary_Fees_and_Taxes code

		String Arbitrary_Fees_and_Taxes_Value[] = Arbitrary_Fees_and_Taxes.split(" ");
		float Arbitrary_Fees_and_Taxes_InNumber = Float.parseFloat(Arbitrary_Fees_and_Taxes_Value[4]);

		System.out.println(Arbitrary_Fees_and_Taxes_InNumber);

		// Added value of Price + Arbitrary_Fees_and_Taxes

		float sum_of_cost = priceInNumber + Arbitrary_Fees_and_Taxes_InNumber; //914.55

		System.out.println(sum_of_cost);

		String SumCost_InString = String.valueOf(sum_of_cost);

		st.assertEquals(total_Price, SumCost_InString);

		// **************************** Done validation
		// **************************************

		w.findElement(By.id("inputName")).sendKeys("Jones Pence");

		w.findElement(By.id("address")).sendKeys("Observatory Circle, U.S");

		w.findElement(By.id("city")).sendKeys("Phoenix");

		w.findElement(By.id("state")).sendKeys("Arizona (AZ)");

		w.findElement(By.id("zipCode")).sendKeys("85001");

		w.findElement(By.id("creditCardNumber")).sendKeys("12345678");

		w.findElement(By.id("creditCardMonth")).sendKeys("12");

		w.findElement(By.id("creditCardYear")).sendKeys("2018");

		w.findElement(By.id("nameOnCard")).sendKeys("Jones Pence");

		w.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();

		st.assertAll();

	}

	@Test(priority = 3, description = "Test case to verify 'blazedemo.com' confirmation page")
	public void confirmationPage() throws Exception {

		Thread.sleep(2000);
		
		String pageTitle=w.getTitle();
		
		Assert.assertEquals(pageTitle, "BlazeDemo Confirmation");
	}

	@AfterTest
	public void afterTest() {

		w.close();
	}
}
