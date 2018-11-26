package com.examples;

import java.awt.AWTException;

import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageLoad {
	
	
	WebDriver driver;
	
	@Test
	public void Run() throws InterruptedException, AWTException
	{
		
		
		
		for (int i = 0; i < 30; i++) 
		{
				
			
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
			   
	    	driver=new ChromeDriver();
	    	driver.manage().window().maximize();
	   
		driver.get("http://122.165.236.133/CHMTEST");
		
		driver.findElement(By.id("txtlname")).click();
		
		Thread.sleep(2000);
		
		long start = System.currentTimeMillis();
		
		driver.findElement(By.id("txtlname")).sendKeys("administrator");
		driver.findElement(By.id("txtlpwd")).sendKeys("cctvware");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='btnlogin']")).click();
		Thread.sleep(2000);
		long finish = System.currentTimeMillis();
		
		long totalTime = finish - start; 
		System.out.println("Total Time for page load : "+totalTime); 
		
		
				}
		
	}


}
