package com.task;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MiniProject_3_blazedemo {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Options manage = driver.manage();
		// manage.window().maximize();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://blazedemo.com/");

//		List<WebElement> Departure = driver.findElements(By.xpath("//select[@name='fromPort']"));
//		for (WebElement depart : Departure) {
//			a="Mexico City";

		WebElement depart = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select s = new Select(depart);
		String a = "Mexico City";

		List<WebElement> depList = s.getOptions();
		for (int i = 0; i < depList.size(); i++) {
			String text = depList.get(i).getText();
			if (text.equalsIgnoreCase(a)) { // contains
				s.selectByVisibleText(a);
				System.out.println("depart contains Mexico");
			}
		}

		WebElement arrives = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select s2 = new Select(arrives);
		String b = "London";
		List<WebElement> arri = s2.getOptions();
		for (int i = 0; i < arri.size(); i++) {
			String text2 = arri.get(i).getText();

			if (text2.contains(b)) {
				s2.selectByVisibleText(b);
				System.out.println("arrival contains London");
			} else {
				System.out.println("doesnt contains ");
			}
		}
		// find flight
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		WebElement check = driver.findElement(By.xpath("//h3[text()='Flights from Mexico City to London: ']"));
		String checkbothpage = check.getText();
		System.out.println(checkbothpage);

		if (checkbothpage.contains(a)) {
			System.out.println("both pages contains--> Mexico and London");
		} else
			System.out.println("both pages unmached");
		
		
		List<WebElement> total_no_of_flights = driver.findElements(By.xpath("//table//tr//td[2]"));
		int size = total_no_of_flights.size();
		System.out.println(size);
		
	
		
		WebElement selectflight = driver.findElement(By.xpath("(//input[@type='submit'])[4]"));
		selectflight.click();
		
		// css--> #ID
		driver.findElement(By.cssSelector("#inputName")).sendKeys("Pragadeeswaran");
		driver.findElement(By.cssSelector("#address")).sendKeys("abc. def, 6022050");
		
		//css--> Name-->[attname='att value']
		driver.findElement(By.cssSelector("[name='city']")).sendKeys("Chennai");
		driver.findElement(By.cssSelector("[name='state']")).sendKeys("TamilNadu");
		
		driver.findElement(By.cssSelector("#zipCode")).sendKeys("123456");
		WebElement cardtype = driver.findElement(By.cssSelector("#cardType"));
		Select card = new Select(cardtype);
		card.selectByValue("visa");
		
		driver.findElement(By.cssSelector("[name=\"creditCardNumber\"]")).sendKeys("9789 1400 6297 7814");
		
		// using action
		
		Actions d = new Actions(driver);
		WebElement dc = driver.findElement(By.cssSelector("#creditCardMonth"));
		d.doubleClick(dc);
		dc.sendKeys("12");
		
		WebElement cl = driver.findElement(By.cssSelector("#creditCardYear"));
		cl.clear();
		cl.sendKeys("2025");
		
		driver.findElement(By.cssSelector("[id=\"nameOnCard\"]")).sendKeys("Pragadeesh");
		
		driver.findElement(By.cssSelector("#rememberMe")).click();
		
		driver.findElement(By.cssSelector("class=\"btn btn-primary\"")).click();
		
		Thread.sleep(3000);
		
		// taking screen shot
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

	
	
	

}
