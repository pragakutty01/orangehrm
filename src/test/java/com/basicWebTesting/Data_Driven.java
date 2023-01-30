package com.basicWebTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Data_Driven {

	public static void main(String[] args) throws FileNotFoundException {


		File excelfile = new File("C:\\Users\\praga\\eclipse-workspace\\Selenium\\ScreenShot\\data.xls");
		System.out.println(excelfile.exists());

		FileInputStream fis = new FileInputStream(excelfile);
		
	}

}
