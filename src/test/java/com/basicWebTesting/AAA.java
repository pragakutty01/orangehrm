package com.basicWebTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AAA {
	WebDriver driver;
	
	private static void OpenBrowser() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("==browser_launch_successfully");
		
		Options manage = driver.manage();
		//manage.window().maximize();
		manage.timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		manage.timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		manage.deleteAllCookies();
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		OpenBrowser();
		

	}

}
