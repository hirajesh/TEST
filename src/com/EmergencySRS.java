package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EmergencySRS 
{


	WebDriver driver;
	String Emergency_Requestnumber,CMORNO,Product_name, Stock_qty, Required_qty,PRNO,date1,stock_list;;
	int a;
	int Seconds=0;
	List <Medicinelist>RequestedMlist=new ArrayList<>();
	String rqtyvalue;
	int NewStock,s=0;
	String rqtyinemergency,Stockqtyinemergency;
    @Test
	public void Emergencyall() throws InterruptedException, IOException
	{

    	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		   
    	driver=new ChromeDriver();
		driver.manage().window().maximize();
	    EmergencyLogin();
	    Thread.sleep(2000);
		EmergencyRequest();
		Thread.sleep(3000);
		signout();
		Thread.sleep(3000);
		CMO();
		Thread.sleep(3000);
		signout();
		Thread.sleep(3000);
		DMS(RequestedMlist);
		Thread.sleep(3000);
	    signout();
	    Thread.sleep(3000);
	    EmergencyLogin();
	    Thread.sleep(2000);
	    Checkstock(RequestedMlist);
	    
		driver.close();
	}

    public void EmergencyLogin() throws InterruptedException 
    {

    	driver.get("http://192.168.137.1/Multihospital_New/EmergencyLogin.aspx");
		driver.findElement(By.id("txtusername")).sendKeys("nivetha");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(5000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		Thread.sleep(5000);
	}

    
    
    public void EmergencyRequest() throws InterruptedException 
    {
     try {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		Thread.sleep(2000);
	}
     catch (InterruptedException e) 
     {
     	e.printStackTrace();
     	Thread.sleep(3000);
     	driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
	}
     
     try {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[2]/a")).click();
		Thread.sleep(2000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Thread.sleep(3000);
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[2]/a")).click();
	}
     
     
     
     
  /*   Select category = new Select(driver.findElement(By.id("optcategory")));
		category.selectByIndex(3);
		
		Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(1);
     int medicine=choosemedicine.getOptions().size();*/
     
  /*   for(int i=1;i<medicine-1;i++)
     {
		
     category.selectByIndex(3);
     Thread.sleep(2000);
     choosemedicine.selectByIndex(i);
     Thread.sleep(2000);
     driver.findElement(By.id("txttreat")).sendKeys("10");
     Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
     }*/
     
 	Select category = new Select(driver.findElement(By.id("optcategory")));
	category.selectByIndex(1);
	Thread.sleep(2000);
	
	Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
	choosemedicine.selectByIndex(2);
	
	Medicinelist rmedicine=new Medicinelist();
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(2).getText().trim());

	driver.findElement(By.id("txttreat")).sendKeys("5");
	Thread.sleep(2000);
	//rqtyvalue=driver.findElement(By.id("txttreat")).getText().trim();
	rmedicine.setRqty("5");
	
	driver.findElement(By.id("btnadd")).click();
	RequestedMlist.add(rmedicine);
	
	
	Thread.sleep(500);
	category.selectByIndex(1);
	Thread.sleep(500);
	choosemedicine.selectByIndex(4);
	Thread.sleep(500);

	rmedicine=new Medicinelist();
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(4).getText().trim());
	driver.findElement(By.id("txttreat")).sendKeys("2");
	
	Thread.sleep(2000);
	//rqtyvalue=driver.findElement(By.id("txttreat")).getText();
	
	Thread.sleep(500);
	rmedicine.setRqty("2");
	
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(500);
	RequestedMlist.add(rmedicine);

	category.selectByIndex(1);
	Thread.sleep(500);
	choosemedicine.selectByIndex(3);
	
	rmedicine=new Medicinelist();
	Thread.sleep(500);
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(3).getText().trim());
	driver.findElement(By.id("txttreat")).sendKeys("4");
	Thread.sleep(500);
	
	//rqtyvalue=driver.findElement(By.id("txttreat")).getText();
	Thread.sleep(500);
	rmedicine.setRqty("4");
	
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(500);
	RequestedMlist.add(rmedicine);

	rmedicine=new Medicinelist();
	category.selectByIndex(3);
	Thread.sleep(500);
	choosemedicine.selectByIndex(7);
	Thread.sleep(500);
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(7).getText().trim());
	driver.findElement(By.id("txttreat")).sendKeys("5");
	Thread.sleep(2000);
	
	//rqtyvalue=driver.findElement(By.id("txttreat")).getText();
	rmedicine.setRqty("5");
	
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(2000);
	RequestedMlist.add(rmedicine);
	
	rmedicine=new Medicinelist();
	category.selectByIndex(3);
	Thread.sleep(500);
	choosemedicine.selectByIndex(8);
	
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(8).getText().trim());
	driver.findElement(By.id("txttreat")).sendKeys("3");
	Thread.sleep(2000);
	rqtyvalue=driver.findElement(By.id("txttreat")).getText();
	Thread.sleep(500);
	rmedicine.setRqty(rqtyvalue);
	rmedicine.setRqty("3");
	
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(2000);
	RequestedMlist.add(rmedicine);
	
	
	rmedicine=new Medicinelist();
	Thread.sleep(500);
	category.selectByIndex(3);
	Thread.sleep(500);
	choosemedicine.selectByIndex(2);
	Thread.sleep(500);
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(2).getText().trim());
	driver.findElement(By.id("txttreat")).sendKeys("5");
	Thread.sleep(2000);
	
//	rqtyvalue=driver.findElement(By.id("txttreat")).getText();
	rmedicine.setRqty("5");
	
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(2000);
	RequestedMlist.add(rmedicine);
	
	rmedicine=new Medicinelist();
	Thread.sleep(300);
	category.selectByIndex(5);
	Thread.sleep(500);
	choosemedicine.selectByIndex(2);
	Thread.sleep(500);
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(2).getText().trim());
	driver.findElement(By.id("txttreat")).sendKeys("3");
	Thread.sleep(2000);
	
	rmedicine.setRqty("1");
	
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(2000);
	RequestedMlist.add(rmedicine);
	
	rmedicine=new Medicinelist();
	
	Thread.sleep(300);
	category.selectByIndex(7);
	Thread.sleep(1000);
	choosemedicine.selectByIndex(10);
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(10).getText().trim());
	driver.findElement(By.id("txttreat")).sendKeys("1");
	Thread.sleep(2000);
	
	rmedicine.setRqty("1");
	
	RequestedMlist.add(rmedicine);
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(2000);
	//RequestedMlist.add(rmedicine);
	
	rmedicine=new Medicinelist();
	Thread.sleep(200);
	category.selectByIndex(3);
    Thread.sleep(500);
	choosemedicine.selectByIndex(6);
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(6).getText().trim());
	driver.findElement(By.id("txttreat")).sendKeys("5");
	Thread.sleep(2000);
	
	rmedicine.setRqty("5");
	
	RequestedMlist.add(rmedicine);
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(2000);
	RequestedMlist.add(rmedicine);
	
	rmedicine=new Medicinelist();
	
     
	Thread.sleep(500);
	category.selectByIndex(3);
	Thread.sleep(500);
	choosemedicine.selectByIndex(9);
	rmedicine.setRMedicinename(choosemedicine.getOptions().get(9).getText().trim());
	driver.findElement(By.id("txttreat")).sendKeys("5");
	Thread.sleep(2000);
	
	rmedicine.setRqty("5");
	
	RequestedMlist.add(rmedicine);
	driver.findElement(By.id("btnadd")).click();
	Thread.sleep(2000);
	//RequestedMlist.add(rmedicine);
    	
	Emergency_Requestnumber = driver.findElement(By.id("txtno")).getAttribute("value").trim();
	
	Thread.sleep(2000);
while(true)
{
	JavascriptExecutor scroll = (JavascriptExecutor) driver;
	scroll.executeScript("window.scrollBy(0,200)", "");
	try {
		driver.findElement(By.id("btnsave")).click();
		Thread.sleep(2000);
		break;
	} catch (Exception e) {
		
		//e.printStackTrace();
		continue;
	}
	
}
 Thread.sleep(4000);
 try {
	driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
}
Thread.sleep(2000);

   driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[1]/a")).click();
Thread.sleep(2000);

for(int y=0;y<=RequestedMlist.size()-1;y++)
{
    try {
		driver.findElement(By.xpath("//*[@id='tblstockdetails_filter']/label/input")).sendKeys(RequestedMlist.get(y).RMedicinename.toString());
		Thread.sleep(2000);
		String Sqty=driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[1]/td[3]")).getText().toString().trim();
		Thread.sleep(2000);
		RequestedMlist.get(y).setStockqty(Sqty);
		driver.findElement(By.xpath("//*[@id='tblstockdetails_filter']/label/input")).clear();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		driver.findElement(By.xpath("//*[@id='tblstockdetails_filter']/label/input")).clear();
		continue;
		
	}
}   
    }

    
    
    
    
    
public void CMO() throws InterruptedException, IOException
{

	
	System.out.println("* LOGIN TO CMO ");
	// CMO APPROVAL
	// ==================
	try {
		Thread.sleep(3000);
		driver.findElement(By.linkText("CMO")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtusername")).sendKeys("guru");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(3000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		}  
		catch (Exception e)
{
			e.printStackTrace();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		}
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
		Thread.sleep(3000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a/span")).click();
	}
		try {
			Thread.sleep(2000);
	
			CMORNO=Emergency_Requestnumber.toString().split("\\/")[2].trim();
		//	CMORNO = Rno.substring(14, 16);
			 System.out.println(" ");
             System.out.println("* SEARCH THE EMERGENCY REQUEST");
            Thread.sleep(4000);
            Select Ldept=new Select(driver.findElement(By.id("optdept")));
            Thread.sleep(4000);
            Ldept.selectByIndex(7);
            Thread.sleep(2000);
            Select Status=new Select(driver.findElement(By.id("optsta")));
            Thread.sleep(500);
            Status.selectByIndex(1);
            Thread.sleep(500);
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
				Emergencyall();
				
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
            System.out.println("* CMO UPDATED THE EMERGENCY REQUEST SUCCESSFULLY");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			driver.findElement(By.xpath("//*[text()='Department Wise Request']")).click();
			Thread.sleep(2000);
			CMORNO=Emergency_Requestnumber.toString().split("\\/")[2].trim();
			Thread.sleep(2000);
			System.out.println(CMORNO);
		    System.out.println(" ");
            System.out.println("* SEARCH THE EMERGENCY REQUEST");
			Thread.sleep(4000);
                Select Ldept=new Select(driver.findElement(By.id("optdept")));
                Thread.sleep(4000);
                Ldept.selectByIndex(7);
                Thread.sleep(2000);
                
                Select Status=new Select(driver.findElement(By.id("optsta")));
                Thread.sleep(500);
                Status.selectByIndex(1);
                Thread.sleep(500);
                
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
    				Emergencyall();
    				
    			}
                
			Select Approval = new Select(driver.findElement(By.id("optstatus")));
			Thread.sleep(2000);
			Approval.selectByIndex(1);
			Thread.sleep(2000);
			driver.findElement(By.id("btnupdate")).click();
			 
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
			System.out.println(" ");
            System.out.println("* CMO UPDATED THE EMERGENCY REQUEST SUCCESSFULLY");
		}
		//signout();
	}


public void signout() throws InterruptedException {
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		Thread.sleep(3000);
		System.out.println(" ");
        System.out.println("* SIGN OUT SUCCESSFULLY");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		Thread.sleep(3000);
		System.out.println(" ");
        System.out.println("* SIGN OUT SUCCESSFULLY");
	}
	
}



public void DMS(List <Medicinelist> issued) throws InterruptedException, IOException {

System.out.println(" ");
System.out.println("* LOGIN TO DIVISIONAL STORE");
	
	try {
		 Thread.sleep(3000);
		try {
			driver.findElement(By.linkText("Divisional Store")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 Thread.sleep(3000);
			driver.findElement(By.linkText("Divisional Store")).click();
		}
		driver.findElement(By.id("txtusername")).sendKeys("ragu");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		 Thread.sleep(3000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
	 
		Thread.sleep(4000);
	    scrollthewindow();	
	} 
	catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		driver.navigate().refresh();
		 Thread.sleep(3000);
		 driver.findElement(By.id("txtusername")).sendKeys("ragu");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		 Thread.sleep(3000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		Thread.sleep(4000);
		
		scrollthewindow();
		
	}
	
	Thread.sleep(2000);
	try {
		
		
		WebElement EMERGENCYRequest=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[10]/a"));
		clickactions(EMERGENCYRequest);
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		Thread.sleep(2000);
		WebElement EMERGENCYRequest=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[10]/a"));
		clickactions(EMERGENCYRequest);
	} 
	Thread.sleep(2000);
	try {
		WebElement Requested_ItemEMERGENCY=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[10]/ul/li[1]/a")); //Requested Item Emergency
	    clickactions(Requested_ItemEMERGENCY);
	} 
	catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		Thread.sleep(2000);
		WebElement Requested_ItemEMERGENCY=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[10]/ul/li[1]/a")); //Requested Item Emergency
	    clickactions(Requested_ItemEMERGENCY);
	}
	Thread.sleep(2000);
	driver.findElement(By.id(CMORNO)).click();
	Thread.sleep(3000);
	System.out.println(" ");
    System.out.println("* EMERGENCY REQUESTED ITEMS ARE ISSUE IN PROCESS");
	WebElement med = driver.findElement(By.id("fldproduct"));
	Select product = new Select(med);
	List product_list = product.getOptions();
	
	
	for (a = 1; a <product_list.size();a++) 
	{
		Thread.sleep(2000);
		product.selectByIndex(a);
	//	String test_name=list.get(i).getText().toString();
	    Product_name=product.getOptions().get(a).getText().toString();
		Thread.sleep(2000);		
		Boolean isPresent = driver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/button")).size() > 0;
		if(isPresent)
		{
			System.out.println(Product_name  +"* Medicine stock qty is not avilable or expired");
			Thread.sleep(3000);
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
				
				Thread.sleep(2000);
				
				 Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
				 Required_qty = driver.findElement(By.id("txttotal")).getAttribute("value");
				 
				 System.out.println(Product_name +"=== Stockqty :" +Stock_qty+ " Required Qty :"+Required_qty);
				 
					if (Integer.parseInt(Stock_qty) >= Integer.parseInt(Required_qty))
						{
							Thread.sleep(2000);
							driver.findElement(By.id("txtqty")).sendKeys(String.valueOf(Required_qty));
							//String issuedqtyinstore=driver.findElement(By.id("txtqty")).getText();
						
							driver.findElement(By.id("btnadd")).click();
							issued.get(a-1).setIssuedqty(Required_qty);
							
							 rqtyinemergency=issued.get(s).getRqty().trim();
							 Stockqtyinemergency=issued.get(s).getStockqty().trim();
							
							 System.out.println(Product_name +"=== Stockqty in emergency :" +Stockqtyinemergency+ " Required Qty in emergency :"+rqtyinemergency);
							
							
						    NewStock=Integer.parseInt(rqtyinemergency)+Integer.parseInt(Stockqtyinemergency);
							issued.get(a-1).setEmergencystock(String.valueOf(NewStock));
							 issued.get(a).setIssued_Or_Not("ISSUED");  
	
							break;
						}
					 else
					 {
						 System.out.println(Product_name +"=== Stockqty is less than required qty");
						 System.out.println(Product_name +"=== Stock qty available is : " +Stock_qty+ " Required Qty Is:"+Required_qty);
						
						
					 }
				
				
			}
		
	
		Thread.sleep(2000);
		s++;
	}
	
	try 
	{
		Thread.sleep(3000);
		JavascriptExecutor scrollsub=(JavascriptExecutor)driver;
		scrollsub.executeScript("window.scrollBy(0,500)","");
		Thread.sleep(2000);
		PRNO=driver.findElement(By.id("lblpono")).getAttribute("value");
		System.out.println(PRNO);
		 
		driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(3000);
                   
        String Labissued=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
        System.out.println("Lab Issued Alert " +Labissued);
        
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
		System.out.println(" ");
	    System.out.println("* EMERGENCY REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
		
	}
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		JavascriptExecutor scrollsub=(JavascriptExecutor)driver;
		scrollsub.executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		Thread.sleep(3000);
		
		String Labissued=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
        System.out.println("Lab Issued Alert " +Labissued);
		
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
        Thread.sleep(3000);  
        System.out.println(" ");
	    System.out.println("* EMERGENCY REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
	}

}

public void Checkstock(List<Medicinelist> newstocklist) throws InterruptedException
{
  
	
	System.out.println("  ");
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[1]/a")).click();
	  Thread.sleep(2000);
	for(int y=0;y<=RequestedMlist.size()-1;y++)
	{
	    driver.findElement(By.xpath("//*[@id='tblstockdetails_filter']/label/input")).sendKeys(RequestedMlist.get(y).RMedicinename.toString());
		Thread.sleep(2000);
		String Sqty;
		try {
			Sqty = driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[1]/td[3]")).getText().toString().trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Sqty="This Medicine Is Not Issued From Store";
		}
		Thread.sleep(2000);
		System.out.println("**********************************************************************");
		System.out.println("Calculate values         = "+newstocklist.get(y).getRMedicinename().trim() +" " +newstocklist.get(y).getEmergencystock().trim() +" " +newstocklist.get(y).getIssued_Or_Not().trim());
		System.out.println("New Emergency Stockqty   = "+newstocklist.get(y).getRMedicinename().trim() +" " +Sqty);
		
		
		//   assertEquals(newstocklist.get(y).getEmergencystock().trim(), Sqty);
		driver.findElement(By.xpath("//*[@id='tblstockdetails_filter']/label/input")).clear();
		
		
	}   
	
}





public void clickactions(WebElement element)
{
	Actions action=new Actions(driver);
	action.moveToElement(element).click().perform();
}

public void scrollthewindow() 
{

	JavascriptExecutor scroll = (JavascriptExecutor) driver;
	scroll.executeScript("window.scrollBy(0,200)", "");

}
    
    @AfterMethod
    public void screen(ITestResult Emergencyall) throws IOException 
    {
    if(Emergencyall.getStatus()==ITestResult.FAILURE)
    {
    	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(src, new File("E:\\Jenkins output\\Emergency\\" + Emergencyall.getName() + "-" + Arrays.toString(Emergencyall.getParameters()) +".png"));

    }}

    
}

class Medicinelist
{
	String RMedicinename,Rqty,Stockqty="0",issuedqty="This Medicine is Not Issued",Emergencystock="0",Issued_Or_Not="NOT ISSUED";

	public String getRMedicinename() {
		return RMedicinename;
	}

	public void setRMedicinename(String rMedicinename) {
		RMedicinename = rMedicinename;
	}

	public String getRqty() {
		return Rqty;
	}

	public void setRqty(String rqty) {
		Rqty = rqty;
	}

	public String getStockqty() {
		return Stockqty;
	}

	public void setStockqty(String stockqty) {
		Stockqty = stockqty;
	}

	public String getIssuedqty() {
		return issuedqty;
	}

	public void setIssuedqty(String issuedqty) {
		this.issuedqty = issuedqty;
	}

	public String getEmergencystock() {
		return Emergencystock;
	}

	public void setEmergencystock(String emergencystock) {
		Emergencystock = emergencystock;
	}

	public String getIssued_Or_Not() {
		return Issued_Or_Not;
	}

	public void setIssued_Or_Not(String issued_Or_Not) {
		Issued_Or_Not = issued_Or_Not;
	}

	


		
	}


