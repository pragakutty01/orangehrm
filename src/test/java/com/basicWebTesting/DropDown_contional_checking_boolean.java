package com.basicWebTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_contional_checking_boolean {

	WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		// manage.window().maximize();
		manage.timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		manage.timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		manage.deleteAllCookies();

		driver.get("https://demoqa.com/select-menu");

		System.out.println("==multiple==");

		WebElement multiple = driver.findElement(By.xpath("//select[@name='cars']"));
		Select s1 = new Select(multiple);
		
		boolean multi = s1.isMultiple();
		if (multi==true) {
			
			s1.selectByIndex(0);
			s1.selectByVisibleText("Audi");
			
		}else {
			s1.selectByVisibleText("Saab");
		}
		
		WebElement single = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		Select s = new Select(single);
		
		boolean multi2 = s.isMultiple();
		if (multi2==true) {
			s.selectByValue("1");
			s.selectByValue("3");
			s.selectByValue("5");
			
		}else {
			s.selectByIndex(9);
		}
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
		driver.quit();
	}
	
	
}

	


