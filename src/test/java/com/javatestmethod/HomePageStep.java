package com.javatestmethod;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.applicationmethods.ApplicationMethods;
import com.drivermethods.BaseClass;

public class HomePageStep extends BaseClass
{
	@FindBy(xpath="//input[@id='inp_RegionSearch_top']")
	public WebElement citySearchBox;
	@FindBy(xpath="//input[@id='input-search-box']")
	public WebElement searchBox;
	//Open Cart Site
	@FindBy(xpath="//img[@title='Your Store']")
	public WebElement openCartLogo;
	@FindBy(xpath="//div[@class='col-sm-5']//input[@name='search']")
	public WebElement openCartSearch;
	@FindBy(xpath="//span[@class='input-group-btn']//i[@class='fa fa-search']")
	public WebElement openCartSearchIcon;
	ApplicationMethods appObj;
	public HomePageStep() 
	{
		PageFactory.initElements(driver, this);	
	}

	public void validateHomePage(String sValue,String valueTwo) {
		WebElement elementCitySearch=citySearchBox;
		if(elementCitySearch.isDisplayed()) {
			Assert.assertTrue(true);
			appObj= new ApplicationMethods();
			appObj.expWait(elementCitySearch, 30);
			ApplicationMethods.enterValues(elementCitySearch, sValue);
		}
		else {
			WebElement elementcommonSearch=searchBox;
			ApplicationMethods.enterValues(elementcommonSearch,valueTwo);

		}
	}
	public void newHome(String valueOne) {
		WebElement elementLog=openCartLogo;
		WebElement searchTextBox=openCartSearch;
		WebElement searchImage=openCartSearchIcon;
		try {
			if(elementLog.isDisplayed()) {
				Assert.assertTrue(true);
				appObj= new ApplicationMethods();
				appObj.expWait(searchTextBox, 30);
				ApplicationMethods.enterValues(searchTextBox, valueOne);
				appObj.expWait(searchImage, 30);
				ApplicationMethods.clickMethod(searchImage);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
