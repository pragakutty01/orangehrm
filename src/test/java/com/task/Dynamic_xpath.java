package com.task;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_xpath {
	WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");
		WebElement dynamic = driver.findElement(By.xpath("//span[text()='Home decoration']/ancestor::div[3]/following-sibling::div[1]/child::div[1]/a"));
		dynamic.click();
	}

}
