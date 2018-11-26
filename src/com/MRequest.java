package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MRequest {

	WebDriver driver;
	
	public void OK() throws InterruptedException 
	{
     Login();
     Mrequestpharmacy();
		
	}

	@Test
	public void Login() throws InterruptedException 
	{

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.137.1/multihospital_new/");
		driver.findElement(By.id("txtusername")).sendKeys("raja");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(4000);
		WebElement click=driver.findElement(By.id("btnSubmit"));
		clic(click);
		Thread.sleep(5000);
	}
	
	public void Mrequestpharmacy() throws InterruptedException 
	{

	driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/ul/li[1]/a")).click();
	Thread.sleep(2000);
	}
	
	public void Riserequest() throws InterruptedException 
	{

	WebElement	category = driver.findElement(By.id("optcategory"));
	Select Mcategory = new Select(category);
	
	
	 WebElement medicine=driver.findElement(By.id("optmedicine"));
	 Thread.sleep(2000);
	 Select choosemedicine = new Select(medicine);
	 
	 driver.findElement(By.id("txttreat")).sendKeys("20");
	 Thread.sleep(2000);
	
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(2000);
	
	Thread.sleep(500);
	Mcategory.selectByIndex(1);
	Thread.sleep(500);
	choosemedicine.selectByIndex(4);
	Thread.sleep(500);
	driver.findElement(By.id("txttreat")).sendKeys("150"); 
	Thread.sleep(500);
 	driver.findElement(By.id("btnadd")).click();
	
	}

	public void clic(WebElement element ) 
	{
	Actions action = new Actions(driver);
	action.moveToElement(element).click().perform();
	}
}
