package com;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

public class GRN 
{

	WebDriver driver;
	String ponumber="PO001";
	String y,q;
	double x,f;
	
	@Test
	public void CMS_LOGIN() throws InterruptedException, IOException 
	{
		

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		 driver = new ChromeDriver();
		 driver.get("http://192.168.137.1/Multihospital_New/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		
		
		
		try {
			 
			driver.findElement(By.linkText("CMS")).click();
			driver.findElement(By.id("txtusername")).sendKeys("bala");
			driver.findElement(By.id("txtpassword")).sendKeys("123");
			Thread.sleep(4000);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
		
			System.out.println("* LOGIN TO CMS");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(3000);
			 
			driver.findElement(By.linkText("CMS")).click();
			driver.findElement(By.id("txtusername")).sendKeys("bala");
			driver.findElement(By.id("txtpassword")).sendKeys("123");
			Thread.sleep(4000);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("* LOGIN TO CMS");
		}
	
		try {
			GRNRECEIVE();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			Thread.sleep(2000);
			
			try {
				
				while(true)
				{
				JavascriptExecutor sub=((JavascriptExecutor)driver);
				sub.executeScript("window.scrollBy(0,100)","");
				try {
					
					WebElement submit=driver.findElement(By.id("btnSubmit"));
					Clickaction(submit);
					break;
					
				} 
				catch (Exception e2) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
				}
			
				
				try {
					Thread.sleep(4000);
					driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				}
			} catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				JavascriptExecutor sub=((JavascriptExecutor)driver);
				sub.executeScript("window.scrollBy(0,400)","");
				driver.findElement(By.id("btnSubmit")).click();//submit
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			}	
			
			Thread.sleep(4000);
			GRNRECEIVE();
			
		}
		
		driver.close();
		
}
	
	
	public void GRNRECEIVE() throws InterruptedException, IOException
	{ 
	// CMS
	//======
	try {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a")).click();
	} catch (Exception e1)
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
		WebElement expand=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a"));
		Clickaction(expand);
	}
	Thread.sleep(2000);
	try {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/ul/li[3]/a")).click();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		WebElement expandclick=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/ul/li[3]/a"));
		Clickaction(expandclick);
	}
	Thread.sleep(2000);
	Select chooseponumber = new Select(driver.findElement(By.id("fldpo")));
	chooseponumber.selectByVisibleText(ponumber);
	Select receivedealer = new Select(driver.findElement(By.id("flddealer")));
	receivedealer.selectByIndex(1);
	driver.findElement(By.id("txtnetamt")).sendKeys(GenerateInvoiceNo(4));
	driver.findElement(By.id("txttaxamt")).sendKeys(GenerateInvoiceNo(5));
	Thread.sleep(2000);
	driver.findElement(By.id("txtgrnno")).sendKeys(GenerateInvoiceNo(1));
	Thread.sleep(2000);
	driver.findElement(By.id("txtchallanno")).sendKeys(GenerateInvoiceNo(2));

	JavascriptExecutor grn=((JavascriptExecutor)driver);
	grn.executeScript("window.scrollBy(0,400)", "");	
	
	WebElement medicine=driver.findElement(By.id("fldproduct"));
	Select Product = new Select(medicine);
	List product_list=Product.getOptions();
	
	for(int med=1;med<product_list.size();med++)
	{
		Thread.sleep(2000);
		Product.selectByIndex(med);
		
		String select_list=Product.getOptions().get(med).getText();
		System.out.println(select_list);
		Thread.sleep(4000);
		String Rqty=driver.findElement(By.id("txtreqqty")).getAttribute("value");
		Thread.sleep(2000);
		
		/*boolean ispresent=driver.findElements(By.xpath("/html/body/div[8]/div/div/div[2]/button")).size() > 0;
		if(ispresent)
		{
			String alert=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
			System.out.println(alert);
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			continue;
		}
		*/
		driver.findElement(By.id("txtqty")).sendKeys(Rqty);
		driver.findElement(By.id("txtfxdprice")).sendKeys("2");
		Thread.sleep(2000);
		/*WebElement tabfun=driver.findElement(By.id("txtfxdprice"));
		tabfun.sendKeys(Keys.TAB);*/
		
		Thread.sleep(2000);
		Select tax=new Select(driver.findElement(By.id("fldtax")));
		tax.selectByIndex(1);
		Thread.sleep(2000);
	/*	WebElement tabfun1=driver.findElement(By.id("fldtax"));
	 *tabfun1.sendKeys(Keys.TAB);*/
		
		getRandomDoubleBetweenRangeMRP();
		q=String.valueOf(f).substring(0,3);
		 System.out.println(q);
			
		driver.findElement(By.id("txtmrp")).sendKeys(q);
		
		
		getRandomDoubleBetweenRange();
		y=String.valueOf(x).substring(0, 3);
		 System.out.println(y);
		
		try {
			driver.findElement(By.id("txtdeal")).sendKeys(y);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			}
			Product.selectByIndex(2);
			Thread.sleep(2000);
			Product.selectByIndex(med);
			Thread.sleep(2000);
			driver.findElement(By.id("txtqty")).sendKeys(Rqty);
			Thread.sleep(2000);

		
			
		}
	//	driver.findElement(By.id("txtdeal")).sendKeys(GenerateInvoiceNo(5));
		Thread.sleep(2000);
		driver.findElement(By.id("txtbatchno")).sendKeys(GenerateInvoiceNo(3));
		Thread.sleep(2000);
		driver.findElement(By.id("txtexpdate")).click();//date
		Thread.sleep(2000);
		Select Year=new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")));
		Year.selectByIndex(3);
		Thread.sleep(2000);
		Select Month=new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]")));
		Month.selectByIndex(5);
		Thread.sleep(2000);
		driver.findElement(By.linkText("11")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();;
		Thread.sleep(2000);
		
	}
		try {
		
			while(true)
			{
			JavascriptExecutor sub=((JavascriptExecutor)driver);
			sub.executeScript("window.scrollBy(0,100)","");
			try {
				
				WebElement submit=driver.findElement(By.id("btnSubmit"));
				Clickaction(submit);
				break;
				
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
			}
		
			
			try {
				Thread.sleep(4000);
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			JavascriptExecutor sub=((JavascriptExecutor)driver);
			sub.executeScript("window.scrollBy(0,400)","");
			driver.findElement(By.id("btnSubmit")).click();//submit
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
		}		
		
	
	System.out.println("GOODS RECEIVED SUCESSFULLY");
}
	
	

public String GenerateInvoiceNo(int id)
{
	String str="";
	
	
	switch(id)
	{
	case 1:

     Random Invoice = new Random();
     str= String.valueOf("INV"+Invoice.nextInt(1000000));
    
		
		break;
	case 2:

		Random challan = new Random();
		str= String.valueOf("CH"+challan.nextInt(9999));
    	break;
	case 3:

         Random batch = new Random();
         str= String.valueOf("BA"+batch.nextInt(9999));
			break;
			
	case 4:

        Random Amount = new Random();
        str= String.valueOf(Amount.nextInt(50000));
        System.out.println(str);
			break;
			
	case 5:

        Random TaxRate = new Random();
       str= String.valueOf(TaxRate.nextInt(1000));
        
        System.out.println(str);
        break;

	}
	
	
	return str;
	}

public double getRandomDoubleBetweenRange()
{
	double min=1;
	double max=5;		
    
	
	x = (Math.random()*((max-min)+1))+min;
	 System.out.println(x);
	 
	return x;
}

public double getRandomDoubleBetweenRangeMRP()
{
	double min=5;
	double max=9;		
	
	f = (Math.random()*((max-min)+1))+min;
	 System.out.println(f);
	 
	return f;
}

	
public void Clickaction(WebElement Element)
{
	Actions action=new Actions(driver);
	action.moveToElement(Element).click().build().perform();
}
	
	
	
}
