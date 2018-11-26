package com.examples;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class netbeanstest {
	
	WebDriver driver;
	
	@Test
	public  void op() throws InterruptedException, FileNotFoundException 
	{

		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe");  
		   
		driver = new ChromeDriver();
	
		driver.get("http://google.com");
		
		driver.manage().window().maximize();
		

}
}