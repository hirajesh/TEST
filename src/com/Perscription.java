package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Perscription 
{
	
	WebDriver driver;
	String[] PATIENT_NAME={"ravi","Ganeshkumar","ajay","kamal","ramesh","anu","divya","nithya","ruba"};
	
	@Test
	public void pentry() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\add jar files\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Pharmacy")).click();
		driver.findElement(By.id("txtusername")).sendKeys("raja");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(3000);
		WebElement Submit=driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(Submit).click().perform();
		Thread.sleep(3000);
	
	 driver.findElement(By.id("today")).click();
	//driver.findElement(By.id("prev")).click();
	Thread.sleep(2000);
	for(int i=0;i<=PATIENT_NAME.length;i++)
	{
		driver.findElement(By.xpath("//*[@id='example1_filter']/label/input")).sendKeys(PATIENT_NAME[i]);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='example1']/tbody/tr[1]/td[6]/a")).click();//*[@id="example1"]/tbody/tr/td[6]/a
		Thread.sleep(2000);
		Select Doc=new Select(driver.findElement(By.id("doctor")));
		Doc.selectByIndex(1);
		Thread.sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(3000);
		if(driver.findElement(By.id("chk")).isDisplayed())
		{
	    driver.findElement(By.id("chk")).click();
		}
		else
		{
			System.out.println("This is Next Visit For Patient");
		}
	Thread.sleep(3000);
	int Seconds=0;
	while(true)
	{
	try 
	{
		driver.findElement(By.id("btnSubmit")).click();
		break;
	}
	catch (Exception e)
	{
		
		e.printStackTrace();
		if(Seconds==25)
		{
			break;
		}
		Seconds++;
		continue;
		
	}
	
	}
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
	driver.navigate().refresh();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='connector']/div[3]/a")).click();
	}
	}

}
