package com.basicWebTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {
	
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	// browser launch
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.window().maximize();
		manage.timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Pragadeeswaran");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("kutty");
		
		driver.navigate().to("https://www.amazon.in/");
		String amazon = driver.getTitle();
		System.out.println(amazon);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		
		// xpath
		// //tagname[text()="Full text"]
		
		driver.findElement(By.xpath("//a[text()=\"Mobiles\"]")).click();
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.instagram.com/");
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().forward();
		Thread.sleep(2000);
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		
		
		
		driver.close();
		
		
		
		
		
		
	
		
		
		

	}

}
