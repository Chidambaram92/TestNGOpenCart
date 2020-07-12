package com.basicutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.drivermethods.BaseClass;
import com.javatestmethod.HomePageStep;


public class CSVUtils extends BaseClass 
{
	public int row,col;
	public static String cityName,searchName;
	static HomePageStep homeobj;

	public CSVUtils() {
		super();
	}
	public static boolean fetchCSV(String currenTestCase) throws IOException {

		File file = new File(prop.getProperty("csvFile"));
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			byte[] byteArray = new byte[(int)file.length()];
			fis.read(byteArray);
			String data = new String(byteArray);
			String[] stringArray = data.split("\r\n");
			int rowcnt = stringArray.length;
			System.out.println("Number of lines in the file are :"+rowcnt);

			String sCurrentLine;
			BufferedReader br = new BufferedReader(new FileReader(file));
			for(int row=1;row<=rowcnt;row++){
				sCurrentLine = br.readLine();
				String[] val = sCurrentLine.split(",");
				if(currenTestCase.equalsIgnoreCase(val[0])){
					System.out.println(currenTestCase +" is present in row : "+row);
					cityName = val[1];
					searchName = val[2];
					System.out.println("Username : "+ cityName);
					System.out.println("Password : "+ searchName);
					System.out.println(currenTestCase);
					//Home page validations
					homeobj = new HomePageStep();
					homeobj.validateHomePage(cityName,searchName);
					br.close();
					fis.close();
					
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return true;
		
	}

}
