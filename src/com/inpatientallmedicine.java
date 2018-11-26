package com;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class inpatientallmedicine {

	
	WebDriver driver;
	int i, j, k, p, q, receveditem, a;
	String  Ritem, xp, CMORNO, Stock_qty, Required_qty,PRNO,Pharmacy_Rno,date1,PO_Rno;
    static int h; 	

	@Test
	public void openbrowser() throws InterruptedException, IOException 
	{
		
		DateFormat date=new SimpleDateFormat("dd/MM/yy");
		Date da=new Date();
		date1=date.format(da);
			
	
		
				
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\add jar files\\chromedriver.exe"); 
	    driver = new ChromeDriver();
	  
	  
	
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Pharmacy")).click();
		driver.findElement(By.id("txtusername")).sendKeys("raja");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		
		Thread.sleep(4000);
		
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PharmacyREQUEST();
		Thread.sleep(2000);
		
		driver.close();
		
		
}
	
	
	public void PharmacyREQUEST() throws InterruptedException
	{

		   Thread.sleep(3000);
		   try {
			   WebElement inventory=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a/span"));
			   clickactions(inventory);
		       }
		   catch (Exception e2) 
		   {
			 e2.printStackTrace();
			 Thread.sleep(3000);
			 WebElement inventory=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a/span"));
			 clickactions(inventory);
		}
	    	Thread.sleep(5000);
	    	driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Medicine Request")).click();
			Thread.sleep(2000);
		
	/*	WebElement	category = driver.findElement(By.id("optcategory"));
	
		Select Mcategory = new Select(category);
	    List<WebElement> siz=Mcategory.getOptions();*/
		
		
		Thread.sleep(3000);
	    //WebElement medicine=driver.findElement(By.id("optmedicine"));
	
		
		
		for(h=6;h<12;h++)
		{
			Thread.sleep(3000);
			
			WebElement	category = driver.findElement(By.id("optcategory"));
			
			Select Mcategory = new Select(category);
			Thread.sleep(3000);
		    Mcategory.selectByIndex(h);
			Thread.sleep(3000);
			
			  WebElement medicine=driver.findElement(By.id("optmedicine"));
			  Thread.sleep(2000);
			Select choosemedicine = new Select(medicine);
			List medicinesize=choosemedicine.getOptions();
		
			Thread.sleep(2000);
			System.out.println("Size :"+medicinesize.size());
			
		try {
			for(int g=1;g<medicinesize.size();g++)
			{
				Mcategory.selectByIndex(h);
				Thread.sleep(2000);
			choosemedicine.selectByIndex(g);
			Thread.sleep(2000);
			driver.findElement(By.id("txttreat")).sendKeys(g+"0"); 
			Thread.sleep(3000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			continue;
		}
		
		
		
    	

		Pharmacy_Rno = driver.findElement(By.id("txtno")).getAttribute("value").trim();
    	

		
			
			while(true)
			{
			JavascriptExecutor scroll = (JavascriptExecutor) driver;
			scroll.executeScript("window.scrollBy(0,100)", "");
			
			try {
				driver.findElement(By.id("btnsave")).click();
				break;
			} catch (Exception e) {
				//e.printStackTrace();
				continue;
			}
			}
			
		
			Thread.sleep(3000);
			 
			String Pharmacyreqalert=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText().trim();
			System.out.println("* PHARMACY REQUEST ALERT :"+Pharmacyreqalert);
			
		
		
			try 
			{
				driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			}
			System.out.println(" ");
			System.out.println("* PHARMACY REQUEST SEND SUCCESSFULLY ");
			System.out.println("* PHARMACY REQUEST NUMBER :"+Pharmacy_Rno);
			
			Thread.sleep(5000);
			
			
		}
		}
	
	@AfterMethod
	public void Exceutenext(ITestResult testresult1) throws IOException, InterruptedException 
	{
	if(testresult1.getStatus()==ITestResult.FAILURE)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\All Medicine\\"+date1+"" + testresult1.getName()+ "-" + Arrays.toString(testresult1.getParameters())+ ".png"));	
	}
	
	}
	
	public void clickactions(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	}

