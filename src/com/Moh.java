package com;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Moh {

	WebDriver driver;
	String CMORNO,PO_Rno,ponumber,date1;
	int med;

	@Test
	public void mohpo() throws InterruptedException, IOException
	{
		
		
		DateFormat date=new SimpleDateFormat("dd/MM/yy");
		Date da=new Date();
		date1=date.format(da);
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\add jar files\\chromedriver.exe"); 
		   driver = new ChromeDriver();
		 driver.get("http://192.168.137.1/Multihospital_New/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		
		
		CMS_LOGIN();
		CMS_REQUESTTO_MOH();
		SIGNOUT();
		System.out.println("* CMS SIGNOUT SUCCESSFULLY ");
		Thread.sleep(2000);
		MOH_PO();
		Thread.sleep(2000);
		SIGNOUT();
		System.out.println("* ADMIN/MOH SIGNOUT SUCCESSFULLY ");
		Thread.sleep(2000);
		CMS_LOGIN();
		Thread.sleep(2000);
		GRN();
		Thread.sleep(2000);
		SIGNOUT();
		System.out.println("* CMS SIGNOUT SUCCESSFULLY ");
		driver.close();
		
	/*	try {
			CMS_LOGIN();
			Thread.sleep(2000);
			try {
				CMS_REQUESTTO_MOH();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//CMS_REQUESTTO_MOH();
			}
			Thread.sleep(2000);
			SIGNOUT();
			System.out.println("* CMS SIGNOUT SUCCESSFULLY ");
			Thread.sleep(2000);
			try {
				MOH_PO();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				MOH_PO();
			}
			Thread.sleep(2000);
			SIGNOUT();
			System.out.println("* ADMIN/MOH SIGNOUT SUCCESSFULLY ");
			Thread.sleep(2000);
			CMS_LOGIN();
			Thread.sleep(2000);
			try {
				GRN();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				GRN();
			}
			Thread.sleep(2000);
			SIGNOUT();
			System.out.println("* CMS SIGNOUT SUCCESSFULLY ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();*/
	}
	public void CMS_REQUESTTO_MOH() throws InterruptedException
	{
		Thread.sleep(2000);
		try 
		{
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
			
		} 
		catch (Exception e2) 
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
			
		}
		Thread.sleep(3000);
		
		
	
		Select rtype = new Select(driver.findElement(By.id("drpreqtype")));
		rtype.selectByIndex(1);
	
		
		
		/*for(int u=1;u<=12;u++)
		{
		*/
		
		Select category = new Select(driver.findElement(By.id("optcategory")));
		category.selectByIndex(1);

		Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		int Medicinesize=choosemedicine.getOptions().size();
		System.out.println(Medicinesize);
		
		for(int o=1;o<Medicinesize;o++)
		{

		Thread.sleep(2000);
		category.selectByIndex(1);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(o);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("3000");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
	//	System.out.println(+o +" " +choosemedicine.getOptions().get(o).getText().toString());
		}
		
	//	}
    	
		 PO_Rno = driver.findElement(By.id("txtno")).getAttribute("value").trim();
		 CMORNO = PO_Rno.toString().split("\\/")[2].trim();
     try
     {
    		
    	while(true)
    	{
    		JavascriptExecutor scroll = (JavascriptExecutor) driver;
			scroll.executeScript("window.scrollBy(0,200)", "");
    		try {
    			driver.findElement(By.id("btnsave")).click();
    			break;
    		} catch (Exception e) {
    			
    			//e.printStackTrace();
    			continue;
    		}
    		
    	}
			
			
			Thread.sleep(4000);
			String Alerttextcms=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			Thread.sleep(2000);
		
		 System.out.println("* Alert Text"+Alerttextcms);
         System.out.println("* PO REQUEST SEND SUCCESSFULLY ");
		 System.out.println("* PO REQUEST NUMBER IS " +PO_Rno);
     }
     catch (Exception e) 
     {			
    	 while(true)
     	{
     		JavascriptExecutor scroll = (JavascriptExecutor) driver;
 			scroll.executeScript("window.scrollBy(0,200)", "");
     		try {
     			driver.findElement(By.id("btnsave")).click();
     			break;
     		} catch (Exception e1) {
     			
     			//e.printStackTrace();
     			continue;
     		}
     		
     	}
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			Thread.sleep(2000);
			System.out.println("* PO REQUEST SEND SUCCESSFULLY ");
			System.out.println("* PO REQUEST NUMBER IS " +PO_Rno);
     }
	
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();


	}
	public void CMS_LOGIN() throws InterruptedException, IOException 
	{
		
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
	public void ss() throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\MOh\\"+date1+"" +System.currentTimeMillis()  +".png"));
		
	}		
	
	public void MOH_PO() throws InterruptedException
	{
	
		try{
			
			Thread.sleep(5000);
		driver.findElement(By.linkText("Admin Master")).click();
		driver.findElement(By.id("txtusername")).sendKeys("admin");
		driver.findElement(By.id("txtpassword")).sendKeys("admin123");
		Thread.sleep(4000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		Thread.sleep(5000);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Admin Master")).click();
		driver.findElement(By.id("txtusername")).sendKeys("admin");
		driver.findElement(By.id("txtpassword")).sendKeys("admin123");
		Thread.sleep(4000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		Thread.sleep(5000);
	}
	try {
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//*[text()='Hospital Registration']")).click();
		//	ss();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/section/ul/li[3]/a")).click();
		}
		scroll();
		Thread.sleep(2000);
		try {
			WebElement cms=driver.findElement(By.xpath("//*[text()='CMS']"));
			Clickaction(cms);
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			WebElement cms1=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/section/ul/li[8]/a"));
			Clickaction(cms1);
			
		}
		
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[12]/ul/li[1]/a")).click();
				
			} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				WebElement Requestapproval=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[12]/ul/li[1]/a"));
				Clickaction(Requestapproval);
			//	ss();
			}
			Thread.sleep(2000);
	} 
	catch (Exception e2) {
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Hospital Registration']")).click();
		Thread.sleep(2000);
		scroll();
		driver.findElement(By.xpath("//*[text()='CMS']")).click();
			Thread.sleep(2000);
			try {
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[12]/ul/li[1]/a")).click();
				ss();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[12]/ul/li[1]/a")).click();
				
			}
			Thread.sleep(2000);
	}
		
		
		try {
			WebElement rno=driver.findElement(By.id(CMORNO));
			Clickaction(rno);
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
			WebElement rno=driver.findElement(By.id(CMORNO));
			Clickaction(rno);
		}
		
		Thread.sleep(2000);
		Select Approval = new Select(driver.findElement(By.id("optstatus")));
		Thread.sleep(2000);
		Approval.selectByIndex(1);
		Thread.sleep(2000);
		
		driver.findElement(By.id("btnupdate")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
		Thread.sleep(3000);
		System.out.println("* MOH UPDATE THE CMS REQUEST");
		Thread.sleep(3000);
	
		try {
			scroll();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='CMS']")).click();
			Thread.sleep(2000);
			WebElement po=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[12]/ul/li[2]/a"));
			Actions porder=new Actions(driver);
			porder.moveToElement(po).click().build().perform();
			Thread.sleep(4000);
			System.out.println("* GENERATE P O");
			String pode=driver.getCurrentUrl().toString();
			System.out.println(pode);
		
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
            scroll();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[10]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[12]/ul/li[2]/a")).click();
			Thread.sleep(2000);
			System.out.println("* GENERATE P O");
			String pode=driver.getCurrentUrl().toString();
			System.out.println(pode);
		}
		
	//	driver.get("http://192.168.137.1/Multihospital_New/PORaise.aspx");
		Thread.sleep(3000);
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			while(true)
			{
			try {
				driver.findElement(By.xpath("//*[@id='flddealer']")).click();
				Thread.sleep(5000);
			    Select pdealer = new Select(driver.findElement(By.xpath("//*[@id='flddealer']")));
				pdealer.selectByIndex(11);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				continue;
			}
			}
			
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(5000);	
			Select pdealer = new Select(driver.findElement(By.xpath("//*[@id='flddealer']")));
			pdealer.selectByIndex(5);
		}
		Thread.sleep(2000);
		Select PRnumber = new Select(driver.findElement(By.id("fldreqnum")));
		PRnumber.selectByVisibleText(PO_Rno);
		Thread.sleep(2000);
		driver.findElement(By.id("seldes")).click();
		Thread.sleep(2000);
		
		try {
			
			while(true)
			{
				Thread.sleep(3000);
			JavascriptExecutor sub=((JavascriptExecutor)driver);
			sub.executeScript("window.scrollBy(0,100)","");
			try {
				Thread.sleep(3000);
				/*WebElement Rise=driver.findElement(By.id("btnreturn"));//submit
						Rise.click();*/
				driver.findElement(By.xpath("//*[@id='btnreturn']")).click(); 
				break;
				
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
			}
		
			
			ponumber = driver.findElement(By.id("lblpono")).getAttribute("value");
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button[2]")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button[2]")).click();
				Thread.sleep(2000);
			}
			try {
				
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				e.printStackTrace();
				 Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			}
			System.out.println("PURCHASE ORDER NUMBER IS " +ponumber);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(2000);
			boolean Flag1=false;
			for(int Seconds2=0;;Seconds2++)
			{
			while(true)
			{
			JavascriptExecutor sub=((JavascriptExecutor)driver);
			sub.executeScript("window.scrollBy(0,200)","");
			try {
				try 
				{
					driver.findElement(By.id("btnreturn")).click();
				} 
				catch (Exception e1) 
				{
					WebElement Risepo=driver.findElement(By.id("btnreturn"));
					Clickaction(Risepo);
				}
				Flag1=true;
				break;
				
			} 
			catch (Exception e2) 
			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
				continue;
			}
			}
			if(Flag1)
			{
				break;
			}
			}
			Thread.sleep(3000);
			ponumber = driver.findElement(By.id("lblpono")).getAttribute("value");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button[2]")).click();
			Thread.sleep(2000);
			try {
				String AlertText=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText();
				System.out.println("Alert Text " +AlertText);
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			}
			System.out.println("PURCHASE ORDER NUMBER IS " +ponumber);
		}
		
	
	}
	public void GRN() throws InterruptedException, IOException
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
	driver.findElement(By.id("txtnetamt")).sendKeys("15000");
	driver.findElement(By.id("txttaxamt")).sendKeys("250");
	Thread.sleep(2000);
	driver.findElement(By.id("txtgrnno")).sendKeys(GenerateInvoiceNo(1));
	Thread.sleep(2000);
	driver.findElement(By.id("txtchallanno")).sendKeys(GenerateInvoiceNo(2));

	JavascriptExecutor grn=((JavascriptExecutor)driver);
	grn.executeScript("window.scrollBy(0,400)", "");	
	
	WebElement medicine=driver.findElement(By.id("fldproduct"));
	Select Product = new Select(medicine);
	List product_list=Product.getOptions();
	
	for(med=1;med<product_list.size();med++)
	{
		Thread.sleep(2000);
		Product.selectByIndex(med);
		
		String select_list=Product.getOptions().get(med).getText();
		System.out.println(med +". " +select_list);
		String Rqty=driver.findElement(By.id("txtreqqty")).getAttribute("value");
		Thread.sleep(4000);
		
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
		tabfun1.sendKeys(Keys.TAB);*/
		
		try {
			driver.findElement(By.id("txtdeal")).sendKeys("4");
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				Thread.sleep(2000);
			}
			Product.selectByIndex(2);
			Thread.sleep(2000);
			Product.selectByIndex(med);
			Thread.sleep(2000);
			driver.findElement(By.id("txtqty")).sendKeys(Rqty);
			Thread.sleep(2000);
			driver.findElement(By.id("txtdeal")).sendKeys("4");
		}
		
		
		driver.findElement(By.id("txtmrp")).sendKeys("6");
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
			boolean Flag=false;
			for(int Seconds=0;;Seconds++)
			{
			while(true)
			{
			JavascriptExecutor sub=((JavascriptExecutor)driver);
			sub.executeScript("window.scrollBy(0,400)","");
			try {
				
				WebElement submit=driver.findElement(By.id("btnSubmit"));
				Clickaction(submit);
				Flag=true;
				break;
				
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
			}
			if(Flag)
			{
				break;
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JavascriptExecutor sub=((JavascriptExecutor)driver);
			sub.executeScript("window.scrollBy(0,400)","");
			driver.findElement(By.id("btnSubmit")).click();//submit
			Thread.sleep(4000);
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

	}
	
	
	return str;
	}
	


@AfterMethod
public void screen(ITestResult testresult1) throws IOException 
{
if(testresult1.getStatus()==ITestResult.FAILURE)
{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("E:\\Jenkins output\\MOH_TEST\\"+date1+"" + testresult1.getName()+ "-" + Arrays.toString(testresult1.getParameters())+ ".png"));
	
}}
public void Clickaction(WebElement Element)
{
	Actions action=new Actions(driver);
	action.moveToElement(Element).click().build().perform();
}


public void scroll()
{
	JavascriptExecutor sub=((JavascriptExecutor)driver);
	sub.executeScript("window.scrollBy(0,200)","");
}
	

}
