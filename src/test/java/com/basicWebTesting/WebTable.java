package com.basicWebTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manage.deleteAllCookies();
		
		driver.get("https://letcode.in/table");
		// header
		WebElement table = driver.findElement(By.id("simpletable"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
        for (WebElement headers : heading) {
        	String text = headers.getText();
        	System.out.println(text);
}
	//table.findElements(By.tagName( ))
	driver.quit();
	
	}
	
	
	

}
