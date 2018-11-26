package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class DispatchMedicineFromCMS 
{
WebDriver driver;
String CMS_Requestnumber="123";
String stok_qty_in_cms,Requestedqty;
int a;



@Test
public void Run() throws InterruptedException, IOException {
	
	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
    driver = new ChromeDriver();
	
	driver.get("http://192.168.137.1/Multihospital_New/");
	driver.manage().window().maximize();
	
	System.out.println(" ");
	System.out.println("MEDICINE DISPATCH FROM CMS");
	System.out.println("===========================");
	System.out.println(" ");
	
	CMS();
	Dispatchfromcms();
	signout();
	DMS();
	Addto_Stock();
	signout();
	driver.close();
	
}

public void DMS() throws InterruptedException
{

	
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id='form1']/div[6]/div[2]/div/div[3]/label/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("txtusername")).sendKeys("ragu");
	Thread.sleep(2000);
	driver.findElement(By.id("txtpassword")).sendKeys("123");
	Thread.sleep(4000);	
	WebElement submit=driver.findElement(By.id("btnSubmit"));
	Actions action=new Actions(driver);
	action.moveToElement(submit).click().perform();

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(6000);

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

//		e.printStackTrace();
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
		driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[8]")).click();
		Thread.sleep(2000);
	

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
			
			if (Integer.parseInt(stok_qty_in_cms) < Integer.parseInt(Requestedqty)) 
			{
				a++;
				System.out.println("* Total Stock Qty in less Than requested qty");
				continue row;
				
			
			}

			Select batch = new Select(driver.findElement(By.id("fldvendor" + a)));

			int bat = batch.getOptions().size();

			//System.out.println(bat);

			for (int y = 1; y <= bat - 1; y++) 
			{
				batch.selectByIndex(y);
				Thread.sleep(1000);
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

					break;

				}
				System.out.println("Stock Qty in less Than requested qty for this batch number");
               
			}
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
		try {
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
		}
		
		
		
		Thread.sleep(2000);
		
		/*try {
			Dispatchfromcms();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			signout();
			Thread.sleep(3000);
		
		}
*/
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
		Thread.sleep(5000);	
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
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
	//	driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
		 
	
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




