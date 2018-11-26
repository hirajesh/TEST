package com;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.Test;


public class DMSTOCMS1 {

	
	WebDriver driver;
	
//	WebDriver driver = new FirefoxDriver();

	
	String CMORNO, CMS_Requestnumber;
	List<issuedmedicinelist> issuedmedicine = new ArrayList<>();
	int a;
	String stok_qty_in_cms,Requestedqty;
	int Seconds=0;
	String CMOUSERNAME="guru";
	String CMOPASSWORD="123";
	
	String STOREUSERNAME="ragu";
	String STOREPASSWORD="123";

	@Test
	public void Run() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
	    driver = new ChromeDriver();
		
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
		
		System.out.println(" ");
		System.out.println("DMS REQUEST TO CMS");
		System.out.println("===================");
		System.out.println(" ");
		
		DMS();
		try {
			
			RequesttoCMS();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequesttoCMS();
		}
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		CMO();
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		CMS();
		Thread.sleep(2000);
		
		Dispatchfromcms();
		
		Thread.sleep(2000);
		/*dis();
		Thread.sleep(2000);*/
		DMS();
		Thread.sleep(2000);
	
			Addto_Stock();
	
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		driver.close();
	}

	public void DMS() throws InterruptedException
	{

		
		
		Thread.sleep(5000);
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

	public void RequesttoCMS() throws InterruptedException {

		try {
			WebElement open = driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/a"));
            clickact(open);
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebElement open = driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/a"));
			clickact(open);
		}
		Thread.sleep(2000);
		try {
			WebElement click = driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/ul/li[1]/a"));
			clickact(click);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebElement click = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/ul/li[1]/a"));
			clickact(click);
		}

		Select rtype = new Select(driver.findElement(By.id("drpreqtype")));
		rtype.selectByIndex(1);

		Select category = new Select(driver.findElement(By.id("optcategory")));
		category.selectByIndex(6);
		
		Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(1);
        int medicine=choosemedicine.getOptions().size();
        
        for(int i=1;i<medicine-1;i++)
        {
		
        category.selectByIndex(6);
        Thread.sleep(1000);
        choosemedicine.selectByIndex(i);
        Thread.sleep(1000);
        driver.findElement(By.id("txttreat")).sendKeys("1000");
        Thread.sleep(1000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(1000);
        }
		
		
	/*	Thread.sleep(2000);
		Select rtype = new Select(driver.findElement(By.id("drpreqtype")));
		rtype.selectByIndex(1);

		Select category = new Select(driver.findElement(By.id("optcategory")));
		category.selectByIndex(1);

		Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(2);

		driver.findElement(By.id("txttreat")).sendKeys("500");
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		category.selectByIndex(10);
		Thread.sleep(500);
		choosemedicine.selectByIndex(9);
		driver.findElement(By.id("txttreat")).sendKeys("300");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(500);
		category.selectByIndex(10);
		choosemedicine.selectByIndex(11);
		driver.findElement(By.id("txttreat")).sendKeys("200");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		
		Thread.sleep(500);
		
		Select category1 = new Select(driver.findElement(By.id("optcategory")));
		category1.selectByIndex(10);
		
		Select choosemedicine1 = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine1.selectByIndex(7);
		
		driver.findElement(By.id("txttreat")).sendKeys("250");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		category.selectByIndex(11);
		Thread.sleep(500);
		choosemedicine.selectByIndex(1);
		
		driver.findElement(By.id("txttreat")).sendKeys("300");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(200);
		category.selectByIndex(3);
		Thread.sleep(200);
		choosemedicine.selectByIndex(2);
		Thread.sleep(200);
		driver.findElement(By.id("txttreat")).sendKeys("200");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(200);
		category.selectByIndex(3);
		Thread.sleep(200);
		choosemedicine.selectByIndex(16);
		Thread.sleep(200);
		driver.findElement(By.id("txttreat")).sendKeys("400");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
	
		category.selectByIndex(5);
		Thread.sleep(200);
		choosemedicine.selectByIndex(7);
		Thread.sleep(200);
		driver.findElement(By.id("txttreat")).sendKeys("500");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
	
		
		
		category.selectByIndex(5);
		Thread.sleep(200);
		choosemedicine.selectByIndex(8);
		driver.findElement(By.id("txttreat")).sendKeys("300");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(200);
		category.selectByIndex(5);
		Thread.sleep(200);
		choosemedicine.selectByIndex(9);
		Thread.sleep(200);
		driver.findElement(By.id("txttreat")).sendKeys("500");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		
		
		
		
		//LAB ITEMS
		//==========
		
		Select Lcategory = new Select(driver.findElement(By.id("optcategory")));
		Lcategory.selectByIndex(4);
		Select Lchoosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		Lchoosemedicine.selectByIndex(5);
		driver.findElement(By.id("txttreat")).sendKeys("200");
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);

		Thread.sleep(300);
		Lcategory.selectByIndex(5);
		Thread.sleep(100);
		Lchoosemedicine.selectByIndex(2);
		Thread.sleep(200);
		driver.findElement(By.id("txttreat")).sendKeys("300");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(300);
		Lcategory.selectByIndex(5);
		Thread.sleep(1000);
		Lchoosemedicine.selectByIndex(11);
		driver.findElement(By.id("txttreat")).sendKeys("300");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(200);
		Lcategory.selectByIndex(6);
		Thread.sleep(100);
		Lchoosemedicine.selectByIndex(2);
		driver.findElement(By.id("txttreat")).sendKeys("400");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
	//	Thread.sleep(3000);
		
		
		 
		//PHARMACY ITEMS
		//================
		
		Select Pcategory = new Select(driver.findElement(By.id("optcategory")));
		Pcategory.selectByIndex(2);
		Select Pchoosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		Pchoosemedicine.selectByIndex(12);
		driver.findElement(By.id("txttreat")).sendKeys("200");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		Pcategory.selectByIndex(2);
		//Thread.sleep(2000);
		Pchoosemedicine.selectByIndex(15);
		driver.findElement(By.id("txttreat")).sendKeys("400");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(200);
		Pcategory.selectByIndex(3);
	    Thread.sleep(500);
		Pchoosemedicine.selectByIndex(3);
		driver.findElement(By.id("txttreat")).sendKeys("250");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(200);
		Pcategory.selectByIndex(3);
	//	Thread.sleep(2000);
		Pchoosemedicine.selectByIndex(4);
		driver.findElement(By.id("txttreat")).sendKeys("350");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);*/
	

		CMS_Requestnumber = driver.findElement(By.id("txtno")).getAttribute("value").trim();
		
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
		Thread.sleep(3000);
		String alertmsg = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText().trim();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
		
		System.out.println("Alertmsg " + alertmsg);
		System.out.println("* " +CMS_Requestnumber);
		
		String alertmsgis="Already Exist this Request No !";
		if(alertmsg.equals(alertmsgis))
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
			RequesttoCMS();
		}

	}

	public void CMO() throws InterruptedException, IOException {

		System.out.println("* LOGIN TO CMO ");
		// CMO APPROVAL
		// ==================
		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("CMO")).click();
			driver.findElement(By.id("txtusername")).sendKeys(CMOUSERNAME);
			driver.findElement(By.id("txtpassword")).sendKeys(CMOPASSWORD);
			Thread.sleep(3500);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[1]/a")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.findElement(By.linkText("CMO")).click();
			driver.findElement(By.id("txtusername")).sendKeys(CMOUSERNAME);
			driver.findElement(By.id("txtpassword")).sendKeys(CMOPASSWORD);
			Thread.sleep(3500);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[1]/a")).click();
		}
		
		
		try {
			
			Thread.sleep(4000);
			CMORNO = CMS_Requestnumber.toString().split("\\/")[2].trim();
			System.out.println(" ");
			System.out.println("* SEARCH THE DMS REQUEST");

			
		      while(true)
	            {
				JavascriptExecutor cmo = (JavascriptExecutor) driver;
				cmo.executeScript("window.scrollBy(0,100)", "");
				try {
					driver.findElement(By.id(CMORNO)).click();
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
					Run();
					
				}

			Thread.sleep(2000);
			Select Approval = new Select(driver.findElement(By.id("optstatus")));
			Thread.sleep(500);
			Approval.selectByIndex(1);
			Thread.sleep(500);
			driver.findElement(By.id("btnupdate")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
			System.out.println(" ");
			System.out.println("* CMO UPDATED THE DMS REQUEST SUCCESSFULLY");


		} 
	catch (Exception e1) 
	{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Thread.sleep(4000);
			CMORNO = CMS_Requestnumber.toString().split("\\/")[2].trim();
			System.out.println(" ");
			System.out.println("* SEARCH THE DMS REQUEST");

			WebElement save = driver.findElement(By.id(CMORNO));
			Actions action = new Actions(driver);
			action.moveToElement(save).click().perform();
			// driver.findElement(By.id(CMORNO)).click();
			Thread.sleep(2000);
			Select Approval = new Select(driver.findElement(By.id("optstatus")));
			Thread.sleep(2000);
			Approval.selectByIndex(1);
			Thread.sleep(2000);
			driver.findElement(By.id("btnupdate")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
			System.out.println(" ");
			System.out.println("* CMO UPDATED THE DMS REQUEST SUCCESSFULLY");
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
					Run();
					
				}

			Thread.sleep(2000);
			Select Approval1 = new Select(driver.findElement(By.id("optstatus")));
			Thread.sleep(2000);
			Approval1.selectByIndex(1);
			Thread.sleep(2000);
			driver.findElement(By.id("btnupdate")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
			System.out.println(" ");
			System.out.println("* CMO UPDATED THE DMS REQUEST SUCCESSFULLY");
		}
}// signout();
	

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

	public void CMS() throws InterruptedException {
		
		
		driver.findElement(By.linkText("CMS")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("txtusername")).sendKeys("bala");
		Thread.sleep(2000);
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(3500);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}

	public void Dispatchfromcms() throws InterruptedException 
	{

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/a")).click(); // Divisional store
																						
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/ul/li[2]/a")).click(); // Dispatch Items
			Thread.sleep(2000);
																							
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/a")).click(); // Divisional store
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/ul/li[2]/a")).click(); // Dispatch Items
			Thread.sleep(2000);
		}
		
		driver.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMS_Requestnumber);
		Thread.sleep(2000);
		driver.findElement(By.xpath("id('grndetails')/tbody/tr/td[8]")).click();
		Thread.sleep(2000);
		
driver.findElement(By.xpath("//*[@id='txtsal0']")).click();
Thread.sleep(2000);
			JavascriptExecutor scroll3 = (JavascriptExecutor) driver;
			scroll3.executeScript("window.scrollBy(0,2000)", "");
			Thread.sleep(2000);
			JavascriptExecutor scroll2 = (JavascriptExecutor) driver;
			scroll2.executeScript("window.scrollBy(2000,0)", "");

		
	

	/*	for (int y = 30; y >= 9; y--) 
		{
			
			while (true)
			{

				try
				{
					driver.findElement(By.xpath("/html/body/div[" + y + "]/div/div/div[2]/button")).click();
					continue;
				} 
				catch (Exception e) 
				{
				
					//e.printStackTrace();
					break;
				}

			}
		}*/

		int col = driver.findElements(By.xpath("/html/body/div[2]/div/div/aside[2]/form/div[5]/section[2]/div/div[3]/div/div/div[2]/div/div/table/tbody/tr/td[1]")).size();
		//System.out.println(col);

		a = 0;
		row: 
			for (int r = 1; r <= col; r++) 
			{
			try {
				stok_qty_in_cms = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
				Requestedqty = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[4]")).getText();
				System.out.println("* Requested Qty :" + Requestedqty);
				System.out.println("* Stock Qty in CMS:" + stok_qty_in_cms);
				System.out.println("=========================================");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				while(true)
				{
				Thread.sleep(2000);
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
	 			scroll.executeScript("window.scrollBy(0,200)", "");
	 			Thread.sleep(2000);
				 try {
					stok_qty_in_cms = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
					 Requestedqty = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[4]")).getText();
					 break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					continue;
				}
				}
				System.out.println("* Requested Qty :" + Requestedqty);
				System.out.println("* Stock Qty in CMS:" + stok_qty_in_cms);
				System.out.println("=========================================");
			}

			Thread.sleep(900);
			
			if (Integer.parseInt(stok_qty_in_cms) < Integer.parseInt(Requestedqty)) 
			{
				a++;
				System.out.println("* Stock Qty in less Than requested qty");
				continue row;

			}

			Select batch = new Select(driver.findElement(By.id("fldvendor" + a)));

			int bat = batch.getOptions().size();

			//System.out.println(bat);

			for (int y = 1; y <= bat - 1; y++) 
			{
				batch.selectByIndex(y);
				Thread.sleep(2000);
				String Batchqty = driver.findElement(By.id("txtbthqty" + a)).getAttribute("value");

			//	Thread.sleep(500);
				System.out.println("* Stockqty for this batch number:" + Batchqty);

				if (Integer.parseInt(Batchqty) >= Integer.parseInt(Requestedqty))
				{
					//driver.findElement(By.id("txtsal" + a)).clear();
				//	Thread.sleep(500);
				//	base.IDsend("txtsal" + a, Requestedqty);
					String issued = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[4]")).getText();
					String medicine = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[2]")).getText();

					issuedmedicinelist retrive = new issuedmedicinelist();
					retrive.setMedicineName(medicine);
					retrive.setIssuedQty(issued);
					issuedmedicine.add(retrive);
					break;

				}
				System.out.println("Stock Qty in less Than requested qty for this batch number");
               
			}
     Thread.sleep(2000);
			a++;
		}
		
	
		while (true) 
		{
			JavascriptExecutor cmo = (JavascriptExecutor) driver;
			cmo.executeScript("window.scrollBy(0,200)", "");
			try {
			driver.findElement(By.id("btndispatch")).click();
			Thread.sleep(2000);
				break;
			} catch (Exception e) {

				e.printStackTrace();
				continue;
				
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
		
		try {
			Dispatchfromcms();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			signout();
			Thread.sleep(3000);
			dis();
		}

	}
	
	

	public void dis() throws InterruptedException {
		System.out.println(" ");
		System.out.println("ISSUED MEDICINE LIST");
		System.out.println("=======================");
		for (int j = 0; j < issuedmedicine.size(); j++) 
		{
			String issued_Medname = issuedmedicine.get(j).getMedicineName().toString();
			String Issued_Qty = issuedmedicine.get(j).getIssuedQty().toString();
			System.out.println(issued_Medname + "     " + Issued_Qty);
		}

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
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
	}
	
	public void ssc(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\DMS TO CMS FLOW\\" +System.currentTimeMillis()  +".png"));
		}
	}		
	  private boolean isElementPresent(By by) {
	        try {
	          driver.findElement(by);
	          return true;
	        } catch (NoSuchElementException e) {
	          return false;
	        }
	      }
	public void clickact(WebElement element) 
	{

		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	public void Scroll()
	{
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,300)","");
	}
	
}

class issuedmedicinelist 
{
	String MedicineName, IssuedQty;

	public String getMedicineName() {
		return MedicineName;
	}

	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}

	public String getIssuedQty() {
		return IssuedQty;
	}

	public void setIssuedQty(String issuedQty) {
		IssuedQty = issuedQty;
	}
}

