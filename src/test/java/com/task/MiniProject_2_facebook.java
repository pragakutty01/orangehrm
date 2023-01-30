package com.task;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MiniProject_2_facebook {
WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.window().maximize();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manage.deleteAllCookies();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(3000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\praga\\eclipse-workspace\\Selenium\\ScreenShot.fab_failed.png");
		FileHandler.copy(source,target);
		
		driver.navigate().back();
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(title +"   " + currentUrl);
		
		if (title.contains("facebook") && currentUrl.contains("facebook")) {
			System.out.println("Matched");
			
		}else {
			System.out.println("Unmatched");
		}
		//create new account
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("praga");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("deesh");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("78977987797");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("123456@praga");
		
		//dropdown
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select d = new Select(day);
		d.selectByValue("1");
		
		WebElement month = driver.findElement(By.xpath("//select[@id='Month']"));
		Select  m= new Select(month);
		m.selectByValue("2");
		
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select  y= new Select(month);
		y.selectByValue("3");
		
		
		
		
		
		
		
		

	}

}
