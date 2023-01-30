package com.basicWebTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("==browser_launch_successfully");

		Options manage = driver.manage();
		// manage.window().maximize();
		manage.timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		manage.timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		manage.deleteAllCookies();
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]")).click();
		Thread.sleep(2000);
		
		//SIMPLE ALERT--> it display some information or warning in screen
		// only ok button
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm')]")).click();
		
		// CONFIRM ALERT--> ok and cancel button
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the pro')]")).click();
		
		//get text
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		Thread.sleep(2000);
		
		//send keys 
		
		driver.switchTo().alert().sendKeys("praga");
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		
	}
}
