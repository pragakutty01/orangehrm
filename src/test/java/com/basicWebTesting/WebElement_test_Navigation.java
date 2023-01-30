package com.basicWebTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElement_test_Navigation {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// launch the browser

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.window().maximize();

		// launch the website
		// NAVIGATE TO AND GET --> BOTH ARE SAME
		driver.get("https://www.facebook.com/");

		// get title
		String title = driver.getTitle();
		System.out.println(title);

		// current url
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		// to get the code of the page you are
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);

		// navigate to 
		driver.navigate().to("https://www.amazon.com/");
		
		String currentUrl2 = driver.getCurrentUrl();
		System.out.println(currentUrl2);
		
		
		String title2 = driver.getTitle();
		System.out.println(title2);

		// wait
		Thread.sleep(2000);

		// navigate back
		driver.navigate().back();

		// navigate forward
		driver.navigate().forward();
		Thread.sleep(2000);

		// navigate refresh
		driver.navigate().refresh();
		Thread.sleep(2000);

		// close--> it will close the current tab
		// quit--> it will close the browser itself

		driver.close();

	}

}
