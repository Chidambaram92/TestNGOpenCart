package com.drivermethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static WebDriver driver;
	public static Properties prop;
	public BaseClass()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/"
					+ "Config.properties");
			prop.load(ip);	
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void driverInitialization() throws MalformedURLException
	{
		String propBrowser=prop.getProperty("browserName");

		if(propBrowser.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 

		}
		else if(propBrowser.equalsIgnoreCase("FireFox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("applicationUrl"));
		
}
	public static void OutPutFileMethod() {
		try {
			OutputStream outputFile= new FileOutputStream(System.getProperty("user.dir")+"");
			prop.setProperty("Result", "pass");
			prop.store(outputFile, "Tested");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
