package com.basicWebTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDown {

	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		//manage.window().maximize();
		manage.timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		manage.timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		manage.deleteAllCookies();
		
		driver.get("https://demoqa.com/select-menu");
		
		// single dropdown-- select by value
		
		WebElement single = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		Select s = new Select(single);
		s.selectByValue("5");
		Thread.sleep(3000);
		
		// get the list dropdown present --> it will return all the options in dropdown
		
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		
		}
		
		
		// mulitple dropdown
		
		System.out.println("==multiple==");
		
		WebElement multiple = driver.findElement(By.xpath("//select[@name='cars']"));
		Select s1 = new Select(multiple);
		s1.selectByIndex(0);
		s1.selectByVisibleText("Audi");
		
		// get all selected options--> it will return all the selected options in dropdown
		// it wont accept in single dropdown
		
		List<WebElement> all = s1.getAllSelectedOptions();
		
		// u can use for each or for loop
		
//	    for (WebElement a : all) {
//	    	System.out.println(a.getText());
		
		for (int i = 0; i < all.size(); i++) {
			System.out.println(all.get(i).getText());
		}
		
		// get first Select Option--> it will return the first selected options in dropdown
		// it will accept single drop down also
		System.out.println("==first selected options===");
		
		WebElement firstSelectedOption = s1.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
		
		
		System.out.println("==multiple");
		
		boolean multiple2 = s1.isMultiple();
		System.out.println(multiple2);
		
		
		
		
		
			
		}
		
	}


