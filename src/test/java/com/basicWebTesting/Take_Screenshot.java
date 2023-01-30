package com.basicWebTesting;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Take_Screenshot {
	WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		Options manage = driver.manage();
		manage.window().maximize();
		manage.timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		// take screenshot--> it is predefined interface
		// narrowing type casting--> changing one datatype to another datatype in variable
		// high to low--> type casting
		//low to high--> widening
		// int a =90; float f =a; syso(f); console: 90 -- it is possible becoz ---> low to high---> wideing
		// but narrowing is not possible i.e high to low
		// float q= 90.9 ; int a = q;	syso(a); error will through
		// possbile through typecasting narrowing only
		// float q= 90.9 ; int a = q; int a =(int) q ;
		// FileHandler--> it is predefined class
		// FileUtils is not belone to selenium, need to download apache common io 2.11.0 version
		// EXCEPTION : IOException i.e input output exception
		
		// syntax.\:      DATATYPE REF =(DATATYPE) VARIABLE NAME
		
		TakesScreenshot s = (TakesScreenshot)driver;
		File f1 = s.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\praga\\eclipse-workspace\\Selenium\\ScreenShot\\fbUtils.png");
		//FileHandler.copy(f1, f);
		FileUtils.copyFile(f1, f);
		
		driver.findElement(By.id("email")).sendKeys("praga");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		File source= s.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\praga\\eclipse-workspace\\Selenium\\ScreenShot\\login.png");
		FileUtils.copyFile(source, dest);
		Thread.sleep(2000);
		
		driver.quit();
		
		
			
	}

}
