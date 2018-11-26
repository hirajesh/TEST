package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PatientInsertChangeRequest {
	
public static int i=6;
	
	@Test
	public void pat() throws InterruptedException, IOException
	{
		try {
			Patient_insert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				Patient_insert();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Patient_insert();
			}
		}
	}
	
	public static void Patient_insert() throws InterruptedException, IOException
	{

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
	//	driver.get("http://192.168.137.1/multihospital_new");
	//	driver.get("http://182.18.161.229/Multihospital_New/");
		driver.get("http://122.165.236.133/MultiHospital/Splashscreen.aspx");
		
		
		
	 
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Reception")).click();
	
		driver.findElement(By.id("txtusername")).sendKeys("brsragu");

		driver.findElement(By.id("txtpassword")).sendKeys("ragu123");

		Thread.sleep(5000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		Thread.sleep(3000);
		
		  
		File src=new File("C:\\Users\\Quality Analyst\\Desktop\\pat.xlsx");
		FileInputStream nw=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(nw);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		 
		System.out.println("The Count is "  +rowcount);
		
		
		
		
	
			
		for(;i<=rowcount;i++)
		{
		String data1=sheet.getRow(i).getCell(0).getStringCellValue();//Patient Name
		String data2=sheet.getRow(i).getCell(1).getStringCellValue();//Gender
		int data3=(int) sheet.getRow(i).getCell(2).getNumericCellValue();//Age
		long  data4=  (long) sheet.getRow(i).getCell(3).getNumericCellValue();//Mobile Number
	//	String data5=sheet.getRow(i).getCell(4).getStringCellValue();//Address
		String data6=sheet.getRow(i).getCell(5).getStringCellValue();//Reason
//		String data7=sheet.getRow(i).getCell(5).getStringCellValue();//Image
		
		 Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='patient_registration']")).click();
		try {
			driver.findElement(By.cssSelector("body > div.row > div > div > aside.left-side.sidebar-offcanvas > section > ul > li:nth-child(3) > a")).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			 driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		}
		
		 
		
		Thread.sleep(2000);
	
		System.out.println("The data from row " +i+ " is " +data1);
		System.out.println("The data from row " +i+ " is " +data2);
		System.out.println("The data from row " +i+ " is " +data3);
		System.out.println("The data from row " +i+ " is " +data4);
	//	System.out.println("The data from row " +i+ " is " +data5);
		System.out.println("The data from row " +i+ " is " +data6);
//		System.out.println("The data from row " +i+ " is " +data7);
	 
		
		
		 driver.findElement(By.id("btnadd")).click();
			Thread.sleep(4000);

			
			driver.findElement(By.id("txtName")).sendKeys(data1);	
			Thread.sleep(1000);
			driver.findElement(By.id("fldgender")).sendKeys(data2);
			Thread.sleep(1000);
			driver.findElement(By.id("txtAge")).sendKeys(String.valueOf(data3));
			Thread.sleep(2000);
			WebElement sms=driver.findElement(By.id("optradiosms"));
			Select smsoption=new Select(sms);
			smsoption.selectByIndex(1);		
			driver.findElement(By.id("txtPhone")).sendKeys(String.valueOf(data4).toString().replaceAll("\\.", ""));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='txtCity']")).clear();
			driver.findElement(By.xpath("//*[@id='txtCity']")).sendKeys("Pune");
			Thread.sleep(2000);
			
	        driver.findElement(By.id("Address")).sendKeys("Pune");
			Thread.sleep(2000);
			Select Fee=new Select(driver.findElement(By.id("fee")));
			Fee.selectByIndex(2);	
			
	//		driver.findElement(By.id("filUpload")).sendKeys(data7);
			Thread.sleep(2000);
			
				driver.findElement(By.id("btnsubmit")).click();
				Thread.sleep(3000);	
				
				driver.findElement(By.cssSelector("body > div.bootbox.modal.fade.bootbox-alert.in > div > div > div.modal-footer > button")).click();
				Thread.sleep(3000);	
			
			System.out.println("The data from row " +i+ " is " +data1);
			System.out.println("The data from row " +i+ " is " +data2);
			System.out.println("The data from row " +i+ " is " +data3);
			System.out.println("The data from row " +i+ " is " +data4);
		//	System.out.println("The data from row " +i+ " is " +data5);
			System.out.println("The data from row " +i+ " is " +data6);
		
				
	
	     
	     
		//MAPPING
		
		/* driver.findElement(By.className("treeview")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.linkText("Doctor Mapping")).click();
		*/
		 driver.findElement(By.id("txtpname")).sendKeys(data1);
	     Thread.sleep(1000);
	     driver.findElement(By.id("btnsrch")).click();
	     Thread.sleep(1000);
	     //driver.findElement(By.id("btncncl")).click();
	    
	     
	     driver.findElement(By.xpath("//*[@id='add1']/tbody/tr/td[6]/input")).click();
	    
		
			
			Thread.sleep(2000);
	     
	     
	     Select dep=new Select(driver.findElement(By.id("dd_Department")));
	     dep.selectByIndex(5);
	     Thread.sleep(3000);
	     Select doc=new Select(driver.findElement(By.id("dd_Doc")));
	    // doc.selectByVisibleText("Dr.Kumaran,DOCID/2017/09/98");
	     doc.selectByIndex(1);
	     Thread.sleep(1000);
	     driver.findElement(By.id("radd")).sendKeys(data6);
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/div[2]/div[4]/a/img")).click();
		Thread.sleep(2000);
	     driver.findElement(By.id("btnsave")).click();
	     Thread.sleep(4000);
	//     WebDriverWait wait1 = new WebDriverWait(driver, 10);
	  //   wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnperclose")));

	    try {
			driver.findElement(By.id("btnperclose")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(2000);
			 driver.findElement(By.id("btnperclose")).click();
		}
	     //Thread.sleep(1000);
		}
		
		//String data1=sheet.getRow(0).getCell(1).getStringCellValue();
		//System.out.println("The Count is"+data1);
     
 driver.close();
	
}

}
