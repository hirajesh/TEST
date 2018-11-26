package com;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
import org.testng.annotations.Test;



public class Healthposttostore {
	
	
	WebDriver driver;
	String Healtpost_Requestnumber,CMORNO,productname;
	boolean sscallow=false;
	
	@Test
	public void Healthpost() throws InterruptedException, IOException 
	{
		HealthpostLogin();
		Thread.sleep(2000);
		HealthpostRequest();
		Thread.sleep(2000);
		SIGNOUT();
		Thread.sleep(2000);
		CMO();
		Thread.sleep(2000);
		SIGNOUT();
		Thread.sleep(2000);
		DMS_LOGIN();
		Thread.sleep(2000);
		IssueHealthpoststoremedicine();
		Thread.sleep(2000);
		SIGNOUT();
		Thread.sleep(2000);
		/*Ack();
		SIGNOUT();*/
		driver.close();
	}
	
	
	
	public void HealthpostLogin() throws InterruptedException, IOException 
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\add jar files\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("http:\\192.168.137.1/Multihospital_new/");
		driver.get("http://192.168.137.1/Multihospital_New/HDSplashscreen.aspx");
		driver.manage().window().maximize();
		
		/*Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li[1]/a")).click();
		Thread.sleep(2000);*/
		
		driver.findElement(By.xpath("//*[@id='form1']/div[6]/div[2]/div/div[4]/label/a")).click();
		if(sscallow)
		{ssc();}
		driver.findElement(By.id("txtusername")).sendKeys("ganesh");
		if(sscallow)
		{ssc();}
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		if(sscallow)
		{ssc();}
		Thread.sleep(4000);
		//driver.findElement(By.id("btnSubmit")).click();
	
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();
		
	}
	
	public void HealthpostRequest() throws InterruptedException, IOException 
	{
		Thread.sleep(5000);
		try 
		{
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/a")).click();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/a")).click();
		}
		
		try 
		{
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/ul/li[1]/a")).click();
		}
		catch (Exception e) 
		{
		
			e.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/ul/li[1]/a")).click();
		}
		
		
		Thread.sleep(2000);
		if(sscallow)
		{ssc();}
		/*Select rtype = new Select(driver.findElement(By.id("drpreqtype")));
		rtype.selectByIndex(1);*/
	
		Select catedriverry = new Select(driver.findElement(By.id("optcategory")));
		catedriverry.selectByIndex(2);
		if(sscallow)
		{ssc();}
		Thread.sleep(2000);
		Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(49);
		if(sscallow)
		{ssc();}

		driver.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
		if(sscallow)
	     {ssc();}
		driver.findElement(By.id("btnadd")).click();
		if(sscallow) {ssc();}
		
		Thread.sleep(500);
		catedriverry.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(2);
		driver.findElement(By.id("txttreat")).sendKeys("50"); 
		Thread.sleep(500);
	    driver.findElement(By.id("btnadd")).click();
		Thread.sleep(1000);
	    if(sscallow) 
	    	{ssc();}
		

		Thread.sleep(500);
		catedriverry.selectByIndex(1);
		Thread.sleep(500);
		choosemedicine.selectByIndex(4);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
     	driver.findElement(By.id("btnadd")).click();
		
		
/*		Thread.sleep(500);
		
		Select catedriverry1 = new Select(driver.findElement(By.id("optcategory")));
		catedriverry1.selectByIndex(1);
		Thread.sleep(500);
		Select choosemedicine1 = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine1.selectByIndex(2);
		
		driver.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
     	driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		catedriverry.selectByIndex(12);
		Thread.sleep(500);
		choosemedicine.selectByIndex(2);
		
		driver.findElement(By.id("txttreat")).sendKeys("200"); 
		Thread.sleep(500);
     	driver.findElement(By.id("btnadd")).click();
		*/
	/*	Thread.sleep(500);
		catedriverry.selectByIndex(3);
		Thread.sleep(500);
		choosemedicine.selectByIndex(2);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
	    driver.findElement(By.id("btnadd")).click();
		
		Thread.sleep(500);
		catedriverry.selectByIndex(3);
		Thread.sleep(500);
		choosemedicine.selectByIndex(16);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
	    driver.findElement(By.id("btnadd")).click();
		
		Thread.sleep(500);
		catedriverry.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(7);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("250"); 
		Thread.sleep(500);
	    driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(500);
		catedriverry.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(8);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
	    driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(500);
		catedriverry.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(9);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
	    driver.findElement(By.id("btnadd")).click();*/
		Thread.sleep(5000);
		
		 Healtpost_Requestnumber = driver.findElement(By.id("txtno")).getAttribute("value").trim();
		 CMORNO = Healtpost_Requestnumber.toString().split("\\/")[2].trim();
		 
		  try
		     {
		    		
		    while(true)
		    {
		    scroll();
		    try 
		    {
		    WebElement save= driver.findElement(By.id("btnsave"));
		     Actions action = new Actions(driver);
			action.moveToElement(save).click().perform();
		     break;
		    } 
		    catch (Exception e) 
		     {			
		      e.printStackTrace();
		      continue;
		      }
		    		
		      }
					
		   
					Thread.sleep(4000);
					 if(sscallow)
						 {ssc();}
					String Alerttextcms=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText().trim();
					Thread.sleep(2000);
					 String alertmsgis="Already Exist this Request No !";
						if(Alerttextcms.contains(alertmsgis))
						{
							driver.navigate().refresh();
							Thread.sleep(2000);
							
						}
						else
						{
					try {
						driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
					} catch (Exception e) 
					{
						Thread.sleep(2000);
						driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
						e.printStackTrace();
					}
					Thread.sleep(2000);
				
				 System.out.println("* Alert Text"+Alerttextcms);
		         System.out.println("* HEALTHPOST REQUEST SEND SUCCESSFULLY ");
				 System.out.println("* HEALTHPOST REQUEST NUMBER IS " +Healtpost_Requestnumber);
		 
						}
		     }
		  catch (Exception e) 
		     {			
			  while(true)
			    {
			    scroll();
			    try 
			    {
			    	  WebElement save= driver.findElement(By.id("btnsave"));
					     Actions action = new Actions(driver);
						action.moveToElement(save).click().perform();
			     break;
			    } 
			    catch (Exception e1) 
			     {			
			      e1.printStackTrace();
			      continue;
			     }
			    		
			     }
			 
			Thread.sleep(4000);
			 if(sscallow) 
		     {ssc();}
			String Alerttextcms=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
			Thread.sleep(2000);
			
			 String alertmsgis="Already Exist this Request No !";
			if(Alerttextcms.contains(alertmsgis))
			{
				driver.navigate().refresh();
				Thread.sleep(2000);
				
			}
			else
			{
		try {
			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
		} catch (Exception e1) 
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			e1.printStackTrace();
		}
		Thread.sleep(2000);
	
	 System.out.println("* Alert Text"+Alerttextcms);
     System.out.println("* HEALTHPOST REQUEST SEND SUCCESSFULLY ");
	 System.out.println("* HEALTHPOST REQUEST NUMBER IS " +Healtpost_Requestnumber);

			}
		    }
	}
	
	
	public void DMS_LOGIN() throws InterruptedException, IOException 
	{
		
		try {
			 
			driver.findElement(By.linkText("Divisional Store")).click();
			if(sscallow) 
				{ssc();}
			driver.findElement(By.id("txtusername")).sendKeys("navas");
			if(sscallow) 
				{ssc();}
			driver.findElement(By.id("txtpassword")).sendKeys("navas123");
			if(sscallow)
				{ssc();}

			Thread.sleep(3000);
			
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
		
			System.out.println("* LOGIN TO DMS");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} 
		catch (Exception e1) 
		{
			
			e1.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(3000);
			 
			WebElement div=driver.findElement(By.linkText("Divisional Store"));
			Clickaction(div);
			if(sscallow) 
				{ssc();}
			driver.findElement(By.id("txtusername")).sendKeys("navas");
			if(sscallow)
				{ssc();}
			driver.findElement(By.id("txtpassword")).sendKeys("navas123");
			if(sscallow) 
				{ssc();}
           Thread.sleep(3000);
			
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("* LOGIN TO CMS");
		}
		
}
	public void IssueHealthpoststoremedicine() throws InterruptedException, IOException 
	{
		Thread.sleep(5000);
		scroll();
	try 
	{
		driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[11]/a")).click();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		Thread.sleep(4000);
		WebElement exp=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[11]/a"));
	    Clickaction(exp);	
	}	
	
	try 
	{
		driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[11]/ul/li[1]/a")).click();
	} catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		Thread.sleep(4000);
		WebElement exp1=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[11]/ul/li[1]/a"));
		exp1.click();
	}
	
	   driver.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMORNO);
	   Thread.sleep(2000);
	   if(sscallow) 
		   {ssc();}
	   driver.findElement(By.id(CMORNO)).click();
	   if(sscallow) 
		   {ssc();}
	   
	   Thread.sleep(2000);
	   Select product=new Select(driver.findElement(By.id("fldproduct")));
	   List opt=product.getOptions();
	   Thread.sleep(2000);
	 
	   for(int r=1;r<opt.size();r++)
	   {
		   Thread.sleep(2000);
		   product.selectByIndex(r);
		   if(sscallow) 
			   {ssc();}
		    productname = product.getOptions().get(r).getText().toString();  
		   Boolean pharmacyispresent=driver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/button")).size() > 0;
		
		   if(pharmacyispresent)
			{
				System.out.println(productname  +"* Medicine stock qty is not avilable or expired");
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				continue;
			}
		   
		   
		   
		   WebElement batch =(driver.findElement(By.id("fldbatch")));
			Select batchnumber = new Select(batch);
			List batchnumber_list = batchnumber.getOptions();
	
			for(int q=1;q<batchnumber_list.size();q++)
			{
				batchnumber.selectByIndex(q);
				
				Thread.sleep(2000);
				
				 String Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
				 String Required_qty = driver.findElement(By.id("txttotal")).getAttribute("value");
				 
				
				 
				 if (Integer.parseInt(Stock_qty) >= Integer.parseInt(Required_qty))
					{
					 if(sscallow)
						 {ssc();}
						driver.findElement(By.id("txtqty")).sendKeys(String.valueOf(Required_qty));
						Thread.sleep(2000);
						if(sscallow)
							{ssc();}
						driver.findElement(By.id("btnadd")).click();
						Thread.sleep(2000);
						 if(sscallow)
							 {ssc();}
						break;
						
					}
				 else
				 {
					 System.out.println(productname +"=== Stockqty is less than required qty");
					 System.out.println(productname +"=== Stock qty available is : " +Stock_qty+ " Required Qty Is:"+Required_qty);
				
				 }
				
			}
	   }
	  
	   while(true)
	   {
	   try 
	   {
		scroll();
		Thread.sleep(4000);
		  WebElement ClickSunbmit=driver.findElement(By.id("btnSubmit"));
		  Clickaction(ClickSunbmit);
		  break;
	     } 
	   catch (Exception e) 
	   {
		// TODO Auto-generated catch block
		e.printStackTrace();
		continue;
		/* scroll();
		   driver.findElement(By.id("btnSubmit")).click();*/
	}
	   }
	   Thread.sleep(4000);
	   if(sscallow)
		   {ssc();}
	   driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
	   
	}
	
	
	public void CMO() throws InterruptedException, IOException {

		System.out.println("* LOGIN TO CMO ");
	   Thread.sleep(3000);
	   
	   driver.get("http:\\192.168.137.1/Multihospital_new/");
	/*	try 
		{
			driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		} 
		catch (Exception e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		}
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li/a")).click();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li/a")).click();
		}*/
		Thread.sleep(4000);
		
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
			if(sscallow)
				{ssc();}
			Thread.sleep(2000);
			driver.findElement(By.id("txtusername")).sendKeys("jana");
			if(sscallow) 
			{ssc();}
			driver.findElement(By.id("txtpassword")).sendKeys("jana123");
			if(sscallow)
				{ssc();}
			Thread.sleep(4000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			  driver.get("http:\\192.168.137.1/Multihospital_new/");
			//driver.navigate().refresh();
			Thread.sleep(3000);
			driver.findElement(By.linkText("CMO")).click();
			if(sscallow)
				{ssc();}
			driver.findElement(By.id("txtusername")).sendKeys("jana");
			if(sscallow) 
				{ssc();}
			driver.findElement(By.id("txtpassword")).sendKeys("jana123");
			if(sscallow)
				{ssc();}
			Thread.sleep(4000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
		

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a/span")).click();
	 	}
			
		try {
				
			
				Thread.sleep(2000);
			//	driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
				Thread.sleep(2000);
				CMORNO=Healtpost_Requestnumber.toString().split("\\/")[2].trim();
			    Thread.sleep(4000);
			    if(sscallow) 
			    	{ssc();}
			    System.out.println(" ");
	             System.out.println("* SEARCH THE HEALTHPOST REQUEST");
               Select Idept=new Select(driver.findElement(By.id("optdept")));
               Thread.sleep(4000);
               Idept.selectByIndex(5);
               Thread.sleep(2000);
               Select Status=new Select(driver.findElement(By.id("optsta")));
               Thread.sleep(500);
               Status.selectByIndex(1);
               Thread.sleep(500);
               driver.findElement(By.id("btnsearch")).click();
               Thread.sleep(3000);
               
               if(sscallow) 
            	   {ssc();}
				for(int Seconds=0;;Seconds++)
				{
				boolean flag=false;  
               
        	  while(true)
	            {
				JavascriptExecutor cmo = (JavascriptExecutor) driver;
				cmo.executeScript("window.scrollBy(0,200)", "");
				try 
				{
			
				driver.findElement(By.id(CMORNO)).click();
				flag=true;
				
				break;
					
				} 
				catch (Exception e) 
				{
				 e.printStackTrace();
				if(Seconds<=60)
				{
				break;
				}
				continue;
				
				}
	            }
        	  if(flag)
		       {
				break;
		       }
			   }
       
				Thread.sleep(2000);
				if(sscallow)
					{ssc();}
				Select Approval = new Select(driver.findElement(By.id("optstatus")));
				Thread.sleep(2000);
				Approval.selectByIndex(1);
				Thread.sleep(2000);
				if(sscallow) 
					{ssc();}
				driver.findElement(By.id("btnupdate")).click();
				
				Thread.sleep(2000);
				if(sscallow) 
					{ssc();}
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println(" ");
                System.out.println("* CMO UPDATED THE HEALTHPOST REQUEST SUCCESSFULLY");
                if(sscallow) 
                	{ssc();}
	
                
	             }
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				driver.navigate().refresh();
				driver.findElement(By.xpath("//*[text()='Department Wise Request']")).click();
				Thread.sleep(200);
				CMORNO=Healtpost_Requestnumber.toString().split("\\/")[2].trim();
				Thread.sleep(200);
				System.out.println(CMORNO);
				Thread.sleep(4000);
				if(sscallow)
					{ssc();}
				 System.out.println(" ");
	             System.out.println("* SEARCH THE HEALTHPOST REQUEST");
	              Select Idept=new Select(driver.findElement(By.id("optdept")));
				    Thread.sleep(400);
	               Idept.selectByIndex(5);
	               Thread.sleep(200);
	               Select Status=new Select(driver.findElement(By.id("optsta")));
	                Thread.sleep(500);
	                Status.selectByIndex(1);
	                Thread.sleep(500);
	               driver.findElement(By.id("btnsearch")).click();
	                Thread.sleep(2000);
	            	for(int Seconds=0;;Seconds++)
					{
					boolean flag=false;  
	               
	        	  while(true)
		            {
					JavascriptExecutor cmo = (JavascriptExecutor) driver;
					cmo.executeScript("window.scrollBy(0,200)", "");
					try 
					{
					driver.findElement(By.id(CMORNO)).click();
					if(sscallow)
						{ssc();}
					flag=true;
				    break;
						
					} 
					catch (Exception e) 
					{
					
					if(Seconds<=120)
					{
					break;
					}
					continue;
					
					}
		            }
	        	  if(flag)
			       {
					break;
			       }
				   }
				Thread.sleep(2000);
				Select Approval = new Select(driver.findElement(By.id("optstatus")));
				Thread.sleep(200);
				Approval.selectByIndex(1);
				if(sscallow) 
					{ssc();}
				Thread.sleep(200);
				driver.findElement(By.id("btnupdate")).click();
				
				Thread.sleep(200);
				if(sscallow)
					{ssc();}
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println(" ");
				System.out.println("* CMO UPDATED THE HEALTHPOST REQUEST SUCCESSFULLY");
			}
			
			//signout();
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

	public void scroll()
	{
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,200)", "");
	}
	
	
	public void Clickaction(WebElement Element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(Element).click().build().perform();
	}
	public void ssc() throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\Healthpoststore\\" +System.currentTimeMillis()  +".png"));
		
	}		
	public void faliedscreen(ITestResult HealthpostTestResult) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\Jenkins output\\Healthpoststore\\"+HealthpostTestResult.getName()+"-" +Arrays.toString(HealthpostTestResult.getParameters()) +".png"));
	}
	public void Ack() throws InterruptedException
	{
		try 
		{
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a")).click();
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a")).click();
		}
		try 
		{
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[1]/a")).click();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[1]/a")).click();
		}
		
	      	driver.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMORNO);
	      	Thread.sleep(500);
	      	driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[1]")).click();
	      	driver.findElement(By.id("txtackremarks")).sendKeys("Medicine Received Rno Is: "+Healtpost_Requestnumber);
	      	Thread.sleep(500);
	      	driver.findElement(By.id("btnadd")).click();
	      	Thread.sleep(3000);
	      	driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
	}
}

