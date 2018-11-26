package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class KdmcTest {

	
	WebDriver driver;
	
	@Test
	public void runscript() throws InterruptedException {

		Login();
	
		
		
	}

	
	public void Login() throws InterruptedException {

		

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
	//	driver.get("http://192.168.137.1/multihospital_new");
		driver.get("http://182.18.161.229/Multihospital_New/");
		driver.manage().window().maximize();
	//	driver.get("http://192.168.137.1/multihospital_new/");

		driver.findElement(By.linkText("Reception")).click();
		driver.findElement(By.id("txtusername")).sendKeys("amirtha");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(5000);
		
	Thread.sleep(3000);
		
		
		driver.findElement(By.cssSelector("body > div.row > div > div > aside.left-side.sidebar-offcanvas > section > ul > li:nth-child(3) > a")).click();
		Thread.sleep(3000);
	driver.get("http://182.18.161.229/Multihospital_New/PatientMaping.aspx");
	
	
	
	
		for(int i=10;i<=30;i++)
			
		{
			
			JavascriptExecutor scroll = (JavascriptExecutor) driver;
			scroll.executeScript("window.scrollBy(0,400)", "");
			
		  driver.findElement(By.xpath("//*[@id='add1']/tbody/tr["+i+"]/td[6]/input")).click();
		    
			
			
		Thread.sleep(2000);
	     
		for(int j=1;j<=13;j++)
		{
			
	     Select dep=new Select(driver.findElement(By.id("dd_Department")));
	     dep.selectByIndex(j);
		
	     Thread.sleep(2000);
	     Select doc=new Select(driver.findElement(By.id("dd_Doc")));
	    // doc.selectByVisibleText("Dr.Kumaran,DOCID/2017/09/98");
	     doc.selectByIndex(1);
	     Thread.sleep(1000);
	//     driver.findElement(By.id("radd")).sendKeys(data6);
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/div[2]/div[4]/a/img")).click();
		Thread.sleep(1000);
		
		}
	     driver.findElement(By.id("btnsave")).click();
	     Thread.sleep(3000);
	     WebDriverWait wait1 = new WebDriverWait(driver, 10);
	     wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnperclose")));

	    try {
			driver.findElement(By.id("btnperclose")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(2000);
			 driver.findElement(By.id("btnperclose")).click();
		}
	     //Thread.sleep(1000);
	    Thread.sleep(3000);

		}
		Thread.sleep(3000);
		
		
	}



	
	
	}
	

	
