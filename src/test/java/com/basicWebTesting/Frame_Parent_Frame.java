package com.basicWebTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_Parent_Frame {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		manage.deleteAllCookies();
		
		driver.get("https://letcode.in/frame");
		WebElement frame1 = driver.findElement(By.id("firstFr"));
		driver.switchTo().frame(frame1);
		WebElement entername = driver.findElement(By.xpath("//input[@placeholder='Enter name']"));
		entername.sendKeys("Praga");
		driver.findElement(By.name("lname")).sendKeys("abc");
		
		// another frame
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.name("email")).sendKeys("pragadeesh");
		
		// going back to parent frame
		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).clear();
		
		// default content--> it will come to main page
		// if it comes out of the frame only it can navigate or do any work
		
		driver.switchTo().defaultContent();
		driver.navigate().to("https://www.amazon.in/");
	}

}
