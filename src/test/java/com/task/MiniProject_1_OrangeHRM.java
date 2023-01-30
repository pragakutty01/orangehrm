package com.task;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MiniProject_1_OrangeHRM {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\praga\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		String lowerCase = title.toLowerCase();

		System.out.println(title);
		System.out.println(lowerCase);
		System.out.println(currentUrl);
		

		Thread.sleep(3000);

		if (currentUrl.contains(lowerCase)) {

			WebElement usernametext = driver.findElement(By.xpath("//p[text()='Username : Admin']"));
			WebElement passText = driver.findElement(By.xpath("//p[text()='Password : admin123']"));
			
			String untext = usernametext.getText();
			String pwtext = passText.getText();
			System.out.println(untext + " " + pwtext);
			
			
			String[] part1 = untext.split(":");
			String[] part2 = pwtext.split(":");
			
			String admintrim = part1[0].toString().trim();
			String pwtrim = part2[0].toString().trim();
			
			System.out.println(admintrim);
			System.out.println(pwtrim);
			
			WebElement usernameTbox = driver.findElement(By.xpath("//input[@name='username']"));
			String unTbox = usernameTbox.getAttribute("placeholder");
			System.out.println(unTbox);
			

			WebElement passwordTbox = driver.findElement(By.xpath("//input[@name='password']"));
			String pwTbox = passwordTbox.getAttribute("placeholder");
			System.out.println(pwTbox);
			
			
			if (admintrim.contains(unTbox) && pwtrim.contains(pwTbox)) {
				System.err.println("matched");
				
				usernameTbox.sendKeys("Admin");
				passwordTbox.sendKeys("admin123");
				
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(2000);
				System.out.println("==login_done==");
				driver.close();
				
				
			}else {
				System.out.println("unmatched");
			}
					
		}
		
		
		
		
		
	}
}
