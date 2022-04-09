package com.selenium.basictest.selenium_training;

interface UserReq {

	public void loginPage();

	public void homePage();

	public void registerPage();
}

class Code implements UserReq {

	@Override
	public void loginPage() {

		System.out.println("Login Code");

	}

	@Override
	public void homePage() {

		System.out.println("homepage Code");

	}

	@Override
	public void registerPage() {

		System.out.println("registerPage Code");

	}

}

public class DemoCode {

	public static void main(String[] args) {

		//interfacename instance =new classimplement();
		
		UserReq u=new Code();
		u.loginPage();
		
		
		//classname instance = new classsname();
		//Code c = new Code();
		//c.loginPage();

	}

}
