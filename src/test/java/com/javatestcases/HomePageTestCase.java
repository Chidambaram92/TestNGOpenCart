package com.javatestcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basicutils.CSVUtils;
import com.drivermethods.BaseClass;
import com.javatestmethod.HomePageStep;

public class HomePageTestCase extends BaseClass {
	HomePageStep homePage;

	@BeforeTest
	public void callMethod(){ 
		try {
			driverInitialization();
			homePage= new HomePageStep();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public HomePageTestCase() {
		super();
	}

	@Test(priority=1)
	public void checkHomePage() {
		homePage.newHome("Phone");
	}
	/*
	 * @Test(priority=1) public void launchHomePage() { try { if
	 * (CSVUtils.fetchCSV("stestcaseOne")) { //OutPutFileMethod(); }
	 * 
	 * } catch (IOException e) { e.printStackTrace(); } System.out.println("Done");
	 * }
	 */

	/*
	 * @AfterTest public void validateLogo() { OutPutFileMethod(); }
	 */

}
