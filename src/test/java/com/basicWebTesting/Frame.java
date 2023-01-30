package com.basicWebTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {
WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		manage.deleteAllCookies();
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement id = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].scrollIntoView();",id);
		id.sendKeys("Scroll Up done--> hello");
		Thread.sleep(2000);
		
		// frame
		// IN FRAME --XPATH--->>WE CANT PASS INDEX
		// driver.findElement(By.xpath("(//iframe[@id='frm1'])[2]"))
		
		
		WebElement frame1 = driver.findElement(By.id("frm1"));
		driver.switchTo().frame(frame1);
		Thread.sleep(2000);

		WebElement frame1dropdown = driver.findElement(By.id("selectnav1"));
		Select s = new Select(frame1dropdown);
		s.selectByVisibleText("- Java");
		Thread.sleep(2000);
		
//		List<WebElement> options = s.getOptions();
//		for (int i = 0; i <options.size(); i++) {
//				System.out.println(options.get(i).getText());
//		}
//		
//		
		
		// DEFAULT CONTENT--> it will comes out of frame
		
		driver.switchTo().defaultContent();
		id.clear();
		Thread.sleep(5000);
		id.sendKeys("asdflkhhkjldhfhdsjfhdsjh");
		Thread.sleep(2000);
		driver.quit();
		
			
	}

}
