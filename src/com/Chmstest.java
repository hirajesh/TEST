package com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Chmstest

{

	WebDriver driver;
	int screen = 0;

	@Test
	public void Login() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://122.165.236.133/CHMRES/SignIn.aspx#!");

		Thread.sleep(1000);
		ss();
		driver.findElement(By.xpath("//*[@id='txtlip']")).sendKeys("122.165.236.133");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='txtlname']")).sendKeys("administrator");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='txtlpwd']")).sendKeys("cctvware");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='btnlogin']")).click();
		Thread.sleep(9000);

		ss();

		// CLICK SITES
		// =================
		try {
			driver.findElement(By.xpath("//*[@id='drag-upcoming']/li[1]/div")).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='drag-upcoming']/li[1]/div/div[2]/h4")).click();
		}
		Thread.sleep(2000);

		// POP-UP CLICK SITES
		// ========================

		driver.findElement(By.xpath("//*[@id='btnsitedetails']")).click();
		Thread.sleep(2000);

		ss();

		// CLOSE
		// =========

		driver.findElement(By.xpath("//*[@id='itemsclose']")).click();
		Thread.sleep(2000);

		ss();

		// SITE
		// ==========
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[2]/ul/li[1]/a")).click();
		Thread.sleep(2000);

		ss();

		// EVENT TYPE
		// ================

		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[2]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		ss();

		/*// EVENT
		// ==========

		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[2]/ul/li[3]/a")).click();
		Thread.sleep(2000);

		ss();*/

	/*	// LOG
		// ==========

		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[2]/ul/li[3]/a")).click();
		Thread.sleep(2000);

		ss();*/

		// CURRENT SERVICE REQUEST
		// ==============================

		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[3]/a")).click();
		Thread.sleep(2000);

		ss();

		// OFFLINE SITE ITEMS
		// ===========================
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[4]/a")).click();
		Thread.sleep(2000);

		ss();

		// CONFIGURATION SETTINGS
		// ==========================
		driver.findElement(By.xpath("//*[@id='navigation']/ul/li[5]/a")).click();
		Thread.sleep(2000);

		ss();

		driver.close();
	}

	public void ss() throws IOException {

		screen++;
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\CHMS\\SCREEN RESOLUTION\\1600x900\\" + screen + ".png"));

		//1024x768,1152x864,1280x768,1280x800,1280x900,1280x1024,1360x768,1366x768,1440x900,1600x900  
		
	}

}
