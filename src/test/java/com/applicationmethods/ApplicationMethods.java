package com.applicationmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.drivermethods.BaseClass;

public class ApplicationMethods extends BaseClass {

	public ApplicationMethods() {
		PageFactory.initElements(driver, this);
	}
	/*
	 * public static void waitMethod(WebDriver driver, By by) { try { WebDriverWait
	 * wbWait= new WebDriverWait(driver, 30);
	 * wbWait.until(ExpectedConditions.presenceOfElement);
	 * wbWait.until(ExpectedConditions.visibilityOfElementLocated(by)); }
	 * catch(NoSuchElementException e) { System.out.println(e.getMessage()); } }
	 */

	public void expWait(WebElement element,int timeInSecs){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(NoSuchElementException exc) {
			System.out.println(exc.getMessage());
		}
	}
	public static void clickMethod(WebElement element) {
		try {
			element.click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void jscriptClickMethod(WebElement elementClick) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", elementClick);
			js.executeScript("arguments[0].click();", elementClick);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void jscriptEnterValues(WebElement enterText, String text) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", enterText);
			js.executeScript("arguments[0].click();", enterText);
			js.executeScript("arguments[0].setAttribute('value', '" + text +"')", enterText);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void enterValues(WebElement elementEnter, String text) {
		try {

			elementEnter.sendKeys(text);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
