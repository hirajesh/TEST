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

public class Inpatientmedicinerequest {

	WebDriver driver;
	int i, j, k, p, q, receveditem, a;
	String  Ritem, xp, CMORNO, Stock_qty, Required_qty,PRNO,Inpatient_Rno,date1;
	int Seconds=0;

	@Test
	public void openbrowser() throws InterruptedException, IOException {
		
		DateFormat date=new SimpleDateFormat("dd/MM/yy");
		Date da=new Date();
		date1=date.format(da);
			
	
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe");  
	   driver = new ChromeDriver();
	  
	  
		//driver = new FirefoxDriver();
		driver.get("http://182.18.161.229/Multihospital_new");
		//driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.linkText("In Patient")).click();
		driver.findElement(By.id("txtusername")).sendKeys("brintha");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		
		Thread.sleep(4000);
		
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println(" ");
		System.out.println("INPATIENT REQUEST");
		System.out.println("================= ");
		System.out.println(" ");
		
		try {
			Thread.sleep(2000);
			Inpatient_storerequest();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Inpatient_storerequest();
		}
		try {
			CMO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			CMO();
		}
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		try {
			DMS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			signout();
			e.printStackTrace();
			Thread.sleep(2000);
			DMS();
		}
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		/*Inpatient_ack();
		Thread.sleep(2000);*/
		driver.close();
	
	}

	public void Inpatient_storerequest() throws InterruptedException, IOException 
	
	{

            Thread.sleep(3000);
            JavascriptExecutor rescroll = (JavascriptExecutor) driver;
			rescroll.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(2000);
		    try {
				driver.findElement(By.xpath("//*[@id='loadfull']/aside[1]/section/ul/li[14]/a")).click();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				WebElement ex= driver.findElement(By.xpath("//*[@id='loadfull']/aside[1]/section/ul/li[14]/a"));
			    clickactions(ex);
			}
			Thread.sleep(2000);
			driver.findElement(By.linkText("Medicine Request")).click();
			Thread.sleep(4000);
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		    rescroll.executeScript("window.scrollBy(0,200)","");
			
		    
		    Select ward_category = new Select(driver.findElement(By.id("optwardcate")));
			ward_category.selectByIndex(3);
			Thread.sleep(2000);
		    
		    
		     Select category = new Select(driver.findElement(By.id("optcategory")));
				category.selectByIndex(1);
				
				Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
				choosemedicine.selectByIndex(1);
		     int medicine=choosemedicine.getOptions().size();
		     
		     for(int i=1;i<medicine-1;i++)
		     {
				
		     category.selectByIndex(1);
		     Thread.sleep(2000);
		     choosemedicine.selectByIndex(i);
		     Thread.sleep(2000);
		     driver.findElement(By.id("txttreat")).sendKeys("10");
		     Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				Thread.sleep(2000);
		     }
		    
		    
		    
		    
		    
		    
		    
		    
		    
	/*	    Select ward_category = new Select(driver.findElement(By.id("optwardcate")));
			ward_category.selectByIndex(1);
			Thread.sleep(2000);
			
			Select category = new Select(driver.findElement(By.id("optcategory")));
			category.selectByIndex(1);
		//	String name=category.getOptions().get(1).toString();
			
			Thread.sleep(2000);
			Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
			choosemedicine.selectByIndex(2);
		//	String cname=choosemedicine.getOptions().get(1).toString();
			Thread.sleep(2000);
			driver.findElement(By.id("txttreat")).sendKeys("5");
			Thread.sleep(2000);
	//		String mqty=driver.findElement(By.id("txttreat")).getText();
			//System.out.println(name +cname +mqty);
			
			WebElement add=driver.findElement(By.xpath("//*[@id='btnadd']"));
			clickactions(add);
	

			Thread.sleep(5000);
			category.selectByIndex(1);
			Thread.sleep(2000);
			choosemedicine.selectByIndex(11);
			Thread.sleep(2000);
			driver.findElement(By.id("txttreat")).sendKeys("8");
			Thread.sleep(2000);
			WebElement add1=driver.findElement(By.id("btnadd"));
			clickactions(add1);
			//	driver.findElement(By.id("btnadd")).click();
			
			Thread.sleep(5000);
			category.selectByIndex(3);
			Thread.sleep(2000);
			choosemedicine.selectByIndex(2);
			Thread.sleep(2000);
			driver.findElement(By.id("txttreat")).sendKeys("6");
			Thread.sleep(2000);
			//driver.findElement(By.id("btnadd")).click();
			clickactions(add);
			
			Thread.sleep(5000);
			category.selectByIndex(3);
			Thread.sleep(2000);
			choosemedicine.selectByIndex(10);
			Thread.sleep(2000);
			driver.findElement(By.id("txttreat")).sendKeys("4");
			Thread.sleep(2000);
			//driver.findElement(By.id("btnadd")).click();
			clickactions(add);
			Thread.sleep(5000);
			 

			Thread.sleep(5000);
			category.selectByIndex(1);
			Thread.sleep(2000);
			choosemedicine.selectByIndex(7);
			Thread.sleep(2000);
			driver.findElement(By.id("txttreat")).sendKeys("8");
			Thread.sleep(2000);
			//driver.findElement(By.id("btnadd")).click();
			clickactions(add);
			
			Thread.sleep(5000);
			category.selectByIndex(1);
			Thread.sleep(2000);
			choosemedicine.selectByIndex(9);
			Thread.sleep(2000);
			driver.findElement(By.id("txttreat")).sendKeys("6");
			Thread.sleep(2000);
		clickactions(add);
			
			Thread.sleep(5000);
			category.selectByIndex(1);
			Thread.sleep(2000);
			choosemedicine.selectByIndex(8);
			Thread.sleep(2000);
			driver.findElement(By.id("txttreat")).sendKeys("5");
			Thread.sleep(2000);
		    clickactions(add);
			*/
			Inpatient_Rno = driver.findElement(By.id("txtno")).getAttribute("value").trim();
	    	try
	    	{
				while(true)
				{
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
				scroll.executeScript("window.scrollBy(0,100)", "");
				
				try 
				{
					driver.findElement(By.id("btnsave")).click();
					break;
				}
				catch (Exception e) 
				{
					//e.printStackTrace();
				
					continue;
				}
				}
		       
				
				
				Thread.sleep(3000);
				
				String Requestsendalert= driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().trim();
				System.out.println("* Alert Text "+Requestsendalert);
				
				String alertmsgis="Already Exist this Request No !";
				
				if(Requestsendalert.contains(alertmsgis))
				{
					driver.navigate().refresh();
					Thread.sleep(2000);
					Inpatient_storerequest();
				}
				else
				{
				try
				{
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				} 
				catch (Exception e)
				{
					e.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
				 System.out.println("* INPATIENT REQUEST SEND SUCCESSFULLY ");
				 System.out.println("* INPATIENT REQUEST NUMBER IS " +Inpatient_Rno);
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				while(true)
				{
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
				scroll.executeScript("window.scrollBy(0,100)", "");
				
				try {
					driver.findElement(By.id("btnsave")).click();
					break;
				} catch (Exception e1) {
					//e.printStackTrace();
					continue;
				}
				
				}
				Thread.sleep(3000);
				
				String Requestsendalert= driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText();
				System.out.println("* "+Requestsendalert);
				
				String alertmsgis="Already Exist this Request No !";
				if(Requestsendalert.contains(alertmsgis))
				{
					driver.navigate().refresh();
					Thread.sleep(2000);
					Inpatient_storerequest();
				}
				
				else
				{
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				Thread.sleep(2000);
				 System.out.println("* INPATIENT REQUEST SEND SUCCESSFULLY ");
				 System.out.println("* INPATIENT REQUEST NUMBER IS " +Inpatient_Rno);
				}
				
			}
			JavascriptExecutor pendingscroll = (JavascriptExecutor) driver;
			pendingscroll.executeScript("window.scrollBy(0,400)", "");
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[14]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[14]/ul/li[3]/a")).click();// pending request
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		
		
		try {
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			//driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println("* INPATIENT SIGNOUT SUCCESSFULLY");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			//driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(4000);
			System.out.println("* INPATIENT SIGNOUT SUCCESSFULLY");
		}
	}
	
		
		

	// RETURN EXPIRED MEDICINE
	// =========================
	public void return_medicine() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[5]/a")).click();
		if (driver.findElement(By.id("btnreturn")).isDisplayed()) {
			driver.findElement(By.id("seldes")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnreturn")).click();
		} else {
			System.out.println("* There is no Expired Medicine");
		}
		
	}
	@AfterMethod
	public void screen(ITestResult Inpatientrequest) throws IOException {
		if(Inpatientrequest.getStatus()==(ITestResult.FAILURE))
		{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\Inpatient\\"+date1+"" + Inpatientrequest.getName() +Arrays.toString(Inpatientrequest.getParameters()) + ".png"));
	//	FileUtils.copyFile(src, new File("E:\\Jenkins output\\Inpatient\\" + System.currentTimeMillis() + ".png"));
		}}

	public void CMO() throws InterruptedException, IOException {

		System.out.println("* LOGIN TO CMO ");
		// CMO APPROVAL
		// ==================
		try {
			Thread.sleep(3000);
			try {
				driver.findElement(By.linkText("CMO")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				driver.findElement(By.linkText("CMO")).click();
			}
			driver.findElement(By.id("txtusername")).sendKeys("guru");
			driver.findElement(By.id("txtpassword")).sendKeys("123");
            Thread.sleep(4000);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(3000);
		//	driver.findElement(By.linkText("CMO")).click();
			driver.findElement(By.id("txtusername")).sendKeys("guru");
			driver.findElement(By.id("txtpassword")).sendKeys("123");
            Thread.sleep(4000);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a/span")).click();
		}
			try {
				Thread.sleep(2000);
			//	driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
				Thread.sleep(2000);
				CMORNO=Inpatient_Rno.toString().split("\\/")[2].trim();
			    Thread.sleep(4000);
			    
			    System.out.println(" ");
	             System.out.println("* SEARCH THE INPATIENT REQUEST");
               Select Idept=new Select(driver.findElement(By.id("optdept")));
               Thread.sleep(4000);
               Idept.selectByIndex(1);
               Thread.sleep(2000);
               Select Status=new Select(driver.findElement(By.id("optsta")));
               Thread.sleep(500);
               Status.selectByIndex(1);
               driver.findElement(By.id("btnsearch")).click();
               Thread.sleep(3000);
               
 				
               while(true)
	            {
				JavascriptExecutor cmo = (JavascriptExecutor) driver;
				cmo.executeScript("window.scrollBy(0,100)", "");
				try {
					driver.findElement(By.id(CMORNO)).click();
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
					if(Seconds==50)
					{
						System.out.println("* Request is not received to CMO due to Hospital Id Is Mismatching");
						break;
						
					}
					Seconds++;
					continue;
					
				}
	            }
               
               if(Seconds==50)
				{
					driver.close();
					Thread.sleep(3000);
					openbrowser();
					
				}
               
				Thread.sleep(2000);
				
				Select Approval = new Select(driver.findElement(By.id("optstatus")));
				Thread.sleep(2000);
				Approval.selectByIndex(1);
				Thread.sleep(2000);
				
				driver.findElement(By.id("btnupdate")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println(" ");
                System.out.println("* CMO UPDATED THE INPATIENT REQUEST SUCCESSFULLY");
				
	
	             }
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				driver.navigate().refresh();
				driver.findElement(By.xpath("//*[text()='Department Wise Request']")).click();
				Thread.sleep(200);
				CMORNO=Inpatient_Rno.toString().split("\\/")[2].trim();
				Thread.sleep(200);
				System.out.println(CMORNO);
				Thread.sleep(4000);
				
				 System.out.println(" ");
	             System.out.println("* SEARCH THE INPATIENT REQUEST");
	             
				  Select Idept=new Select(driver.findElement(By.id("optdept")));
	               Thread.sleep(400);
	               Idept.selectByIndex(1);
	               Thread.sleep(500);
	               Select Status=new Select(driver.findElement(By.id("optsta")));
	               Thread.sleep(500);
	               Status.selectByIndex(1);
	               driver.findElement(By.id("btnsearch")).click();
	                Thread.sleep(2000);
	                while(true)
		            {
					JavascriptExecutor cmo = (JavascriptExecutor) driver;
					cmo.executeScript("window.scrollBy(0,100)", "");
					try {
						driver.findElement(By.id(CMORNO)).click();
						break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
						if(Seconds==50)
						{
							System.out.println("* Request is not received to CMO due to Hospital Id Is Mismatching");
							break;
							
						}
						Seconds++;
						continue;
						
					}
		            }
	               
	               if(Seconds==50)
					{
						driver.close();
						Thread.sleep(3000);
						openbrowser();
						
					}
				Thread.sleep(2000);
				Select Approval = new Select(driver.findElement(By.id("optstatus")));
				Thread.sleep(200);
				Approval.selectByIndex(1);
				Thread.sleep(200);
				driver.findElement(By.id("btnupdate")).click();
				
				Thread.sleep(200);
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println(" ");
                System.out.println("* CMO UPDATED THE INPATIENT REQUEST SUCCESSFULLY");
			}
			
			//signout();
		}
	

	public void signout() throws InterruptedException {
		try {
			
		//	driver.findElement(By.xpath("/html/body/header/div/nav/div/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println("* SIGNOUT SUCCESSFULLY");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println("* SIGNOUT SUCCESSFULLY");
		}
	}

public void DMS() throws InterruptedException, IOException {
		
	 System.out.println("* LOGIN TO DIVISIONAL STORE");
		try {
			 Thread.sleep(3000);
			driver.findElement(By.linkText("Divisional Store")).click();
			driver.findElement(By.id("txtusername")).sendKeys("ragu");
			driver.findElement(By.id("txtpassword")).sendKeys("123");
            Thread.sleep(4000);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.findElement(By.linkText(" Divisional Store ")).click();
			driver.findElement(By.id("txtusername")).sendKeys("ragu");
			driver.findElement(By.id("txtpassword")).sendKeys("123");
			Thread.sleep(4000);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		Thread.sleep(3000);
		try {
			
			WebElement Inpatientreq=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a"));//Inpatient Request
			clickactions(Inpatientreq);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			WebElement Inpatientreq=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a"));//Inpatient Request
			clickactions(Inpatientreq);
		}
		Thread.sleep(2000);
		try {
			WebElement Requesteditem=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[1]/a")); //Requested Item Inpatient
		clickactions(Requesteditem);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Thread.sleep(2000);
			WebElement Requesteditem=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[1]/a")); //Requested Item Inpatient
			clickactions(Requesteditem);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMORNO);
		Thread.sleep(3000);
		driver.findElement(By.id(CMORNO)).click();
		Thread.sleep(3000);
		System.out.println(" ");
	    System.out.println("* INPATIENT REQUESTED ITEMS ARE ISSUE IN PROCESS");
		WebElement med = driver.findElement(By.id("fldproduct"));
		Select product = new Select(med);
		List product_list = product.getOptions();
		
		for (a = 1; a <product_list.size();a++) 
		{
		
			product.selectByIndex(a);
			String Product_name=product.getOptions().get(a).getText().toString();
			Thread.sleep(2000);		
			Boolean pharmacyispresent=driver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/button")).size() > 0;
			if(pharmacyispresent)
			{
				System.out.println(Product_name  +"* Medicine stock qty is not avilable or expired");
				Thread.sleep(300);
				driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				continue;
			}
					
			WebElement batch =(driver.findElement(By.id("fldbatch")));
			Select batchnumber = new Select(batch);
			List batchnumber_list = batchnumber.getOptions();
		
			//Thread.sleep(2000);
			
				for(int q=1;q<batchnumber_list.size();q++)
				{
					batchnumber.selectByIndex(q);
					
					Thread.sleep(3000);
					
					 Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
					 Required_qty = driver.findElement(By.id("txttotal")).getAttribute("value");
					 
					 System.out.println(Product_name +"=== Stockqty :" +Stock_qty+ " Required Qty :"+Required_qty);
					 //System.out.println("Stockqty :" +Stock_qty+ " Required Qty :"+Required_qty);
					 
					 if (Integer.parseInt(Stock_qty) > Integer.parseInt(Required_qty))
						{
							driver.findElement(By.id("txtqty")).sendKeys(String.valueOf(Required_qty));
							driver.findElement(By.id("btnadd")).click();
							break;
						}
					 else
					 {
						 System.out.println(Product_name +"=== Stockqty is less than required qty");
						 System.out.println(Product_name +"=== Stock qty available is : " +Stock_qty+ " Required Qty Is:"+Required_qty);
						// System.out.println("* Stockqty is less than required qty");
						 //System.out.println("* Stock qty available is : " +Stock_qty+ "  Required Qty Is:"+Required_qty);
					 }
					
				}
		}
		
		try {
			
			Thread.sleep(2000);
			 PRNO=driver.findElement(By.id("lblpono")).getAttribute("value");
			JavascriptExecutor scrollsub=(JavascriptExecutor)driver;
			scrollsub.executeScript("window.scrollBy(0,500)","");
			Thread.sleep(2000);
			
		    
			System.out.println(PRNO);
			driver.findElement(By.id("btnSubmit")).click();
            Thread.sleep(2000);
            
            String inpatientissued=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]")).getText();          
            System.out.println("* INPATIENT ALERT TEXT :"+inpatientissued);
            
            driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			System.out.println(" ");
		    System.out.println("* INPATIENT REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 PRNO=driver.findElement(By.id("lblpono")).getAttribute("value");
			JavascriptExecutor scrollsub=(JavascriptExecutor)driver;
			scrollsub.executeScript("window.scrollBy(0,300)","");
			Thread.sleep(2000);
			
			driver.findElement(By.id("btnSubmit")).click();
			Thread.sleep(3000);
			
			String inpatientissued=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]")).getText();          
            System.out.println("* INPATIENT ALERT TEXT :"+inpatientissued);	
			
	        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
	        Thread.sleep(3000);  
	        System.out.println(" ");
		    System.out.println("* INPATIENT REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
		}

	}
	
	public void Inpatient_ack() throws InterruptedException
	{
		Thread.sleep(4000);
		try {
			driver.findElement(By.linkText("In Patient")).click();
			driver.findElement(By.id("txtusername")).sendKeys("vishnu");
			driver.findElement(By.id("txtpassword")).sendKeys("vishnu123");
			driver.findElement(By.id("btnSubmit")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			JavascriptExecutor rece=(JavascriptExecutor)driver;
			rece.executeScript("window.scrollBy(0,300)","");
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("//*[@id='loadfull']/aside[1]/section/ul/li[14]/a")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='loadfull']/aside[1]/section/ul/li[14]/a")).click();
				
			}
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[14]/ul/li[4]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.id(Inpatient_Rno)).click();
			Thread.sleep(2000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			driver.navigate().refresh();
			JavascriptExecutor rece=(JavascriptExecutor)driver;
			rece.executeScript("window.scrollBy(0,300)","");
			driver.findElement(By.xpath("//*[@id='loadfull']/aside[1]/section/ul/li[14]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[14]/ul/li[4]/a")).click();
			Thread.sleep(2000);
			//String Issuedno=PRNO.toString().split("\\/")[2].trim();
			Thread.sleep(2000);
		    driver.findElement(By.id(Inpatient_Rno)).click();
			Thread.sleep(2000);
		}
	    
		driver.findElement(By.id("txtackremarks")).sendKeys("* Medicine Received-INPATIENT");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
		
		
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			//driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			//driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(4000);
		}
		
	}
	
	public void clickactions(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void ss() throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\Inpatient\\"+date1+"" +System.currentTimeMillis()  +".png"));
		
	}
}
