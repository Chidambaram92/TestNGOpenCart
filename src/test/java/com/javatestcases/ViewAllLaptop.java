package com.javatestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.drivermethods.BaseClass;
import com.javatestmethod.HomePageStep;
import com.javatestmethod.ProfilePageStep;

public class ViewAllLaptop extends BaseClass
{
	HomePageStep homePage;
	HomePageTestCase homeTestObj;
	ProfilePageStep prfileStep;
	@BeforeTest
	public void callHomePage() {
		homeTestObj= new HomePageTestCase();
		homeTestObj.callMethod();
	}
	
	public ViewAllLaptop() {
		super();
	}
	
	@Test
	public void viewAvailableLaptop() {
		homePage.clickTile();
	}
}
