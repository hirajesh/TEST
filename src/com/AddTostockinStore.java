package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddTostockinStore {

	WebDriver driver;
	String CMS_Requestnumber="PRNO/02052018/10";
	
	String STOREUSERNAME="navas";
	String STOREPASSWORD="navas123";
	
	@Test
	public void ADDSTOCK() throws InterruptedException
	{
		DMS();
		Thread.sleep(2000);
		Addto_Stock();
		Thread.sleep(2000);
		SIGNOUT();
		Thread.sleep(3000);
		driver.close();
	}
	
	public void DMS() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
	    driver = new ChromeDriver();
		
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize(); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='form1']/div[6]/div[2]/div/div[3]/label/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtusername")).sendKeys(STOREUSERNAME);
		Thread.sleep(2000);
		driver.findElement(By.id("txtpassword")).sendKeys(STOREPASSWORD);
		Thread.sleep(4000);	
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(6000);

	}

	public void Addto_Stock() throws InterruptedException 
	{
		
		try {
			WebElement open = driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/a"));
			clickact(open);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebElement open = driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/a"));
			clickact(open);
		}
		Thread.sleep(2000);
		try {
			WebElement click = driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/ul/li[4]/a"));
			clickact(click);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebElement click = driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/ul/li[1]/a"));
			clickact(click);
		}
		driver.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMS_Requestnumber);
		Thread.sleep(500);
	    driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[7]")).click();
		Thread.sleep(2000);	
		driver.findElement(By.id("seldes")).click();
		Thread.sleep(2000);
		
		while(true)
		{
		try {
			driver.findElement(By.id("btchkroqadd")).click();
			break;
		} catch (Exception e) {
			
			JavascriptExecutor scroll = (JavascriptExecutor) driver;
			scroll.executeScript("window.scrollBy(0,200)", "");	
		}
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
	}

	public void SIGNOUT() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println(" ");
            System.out.println("* SIGN OUT SUCCESSFULLY");
		} catch (Exception e) {
		
		//	e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println(" ");
            System.out.println("* SIGN OUT SUCCESSFULLY");
		}
		
	}
public void clickact(WebElement element) 
{

	Actions action = new Actions(driver);
	action.moveToElement(element).click().perform();
}
}