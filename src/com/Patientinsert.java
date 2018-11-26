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

public class Patientinsert {

	public static int i=2;
	
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
	
	public void Patient_insert() throws InterruptedException, IOException
	{

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\add jar files\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		driver.get("http://182.18.161.229/TNHIMS/");
		//driver.get("http://182.18.161.229/Multihospital_New/");
	 
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Reception")).click();
	
		driver.findElement(By.id("txtusername")).sendKeys("amirtha");

		driver.findElement(By.id("txtpassword")).sendKeys("123");

		Thread.sleep(5000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		Thread.sleep(3000);
		
		  
		File src=new File("C:\\Users\\Quality Analyst\\Desktop\\pat2.xlsx");
		FileInputStream nw=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(nw);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		 
		System.out.println("The Count is "  +rowcount);
		
		
		
		
	
			
		for(;i<=rowcount;i++)
		{
	
		String data0=sheet.getRow(i).getCell(0).getStringCellValue();//Prefix
		String data1=sheet.getRow(i).getCell(1).getStringCellValue();//Patient Name
		String data2=sheet.getRow(i).getCell(2).getStringCellValue();//Gender
		String data3=sheet.getRow(i).getCell(3).getStringCellValue();//Mitral Status
		String data4=sheet.getRow(i).getCell(4).getStringCellValue();//Father Prefix
		String data5=sheet.getRow(i).getCell(5).getStringCellValue();//Father or Spouse Name
		String data6=sheet.getRow(i).getCell(6).getStringCellValue();//Blood Group
		int data7=(int) sheet.getRow(i).getCell(7).getNumericCellValue();//Age
		long  data8=  (long) sheet.getRow(i).getCell(8).getNumericCellValue();//Mobile Number
		String data9=sheet.getRow(i).getCell(9).getStringCellValue();//Country
		String data10=sheet.getRow(i).getCell(10).getStringCellValue();//State
		String data11=sheet.getRow(i).getCell(11).getStringCellValue();//City
	//	String data12=sheet.getRow(i).getCell(12).getStringCellValue();//FileUpload
		String data13=sheet.getRow(i).getCell(13).getStringCellValue();//Reason
		
		 Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='patient_registration']")).click();
		driver.findElement(By.cssSelector("body > div.row > div > div > aside.left-side.sidebar-offcanvas > section > ul > li:nth-child(3) > a")).click();
		 Thread.sleep(3000);
		 
		 driver.findElement(By.id("btnadd")).click();
			Thread.sleep(4000);

			Select sel=new Select(driver.findElement(By.id("fldpatprefix")));
		
          if(data0.toString().equals("Mr"))
  		{
        	  sel.selectByIndex(0);	
  		}else if(data0.toString().equals("Mrs.")){
  		  sel.selectByIndex(3);
  		}else if(data0.toString().equals("Miss")){
  		  sel.selectByIndex(5);
  		}
          Thread.sleep(4000);
			driver.findElement(By.id("txtName")).sendKeys(data1);	
			Thread.sleep(1000);
			driver.findElement(By.id("fldgender")).sendKeys(data2);
			Thread.sleep(1000);
			driver.findElement(By.id("fldmarital")).sendKeys(data3);
			Thread.sleep(2000);
		
			Select sel1=new Select(driver.findElement(By.id("fldFaprefix")));
			  if(data4.toString().equals("Mr"))
		  		{
		        	  sel1.selectByIndex(0);	
		  		}else if(data4.toString().equals("Mrs.")){
		  		  sel1.selectByIndex(1);
		  		}else if(data4.toString().equals("Miss")){
		  		  sel1.selectByIndex(2);
		  		}
		 
			if(data3.toString().equals("Married") && data2.toString().equals("Female") && data0.toString().equals("Miss")||data0.toString().equals("Mrs."))
			{
				driver.findElement(By.id("txtSPName")).sendKeys(data5);
			}
			else
			{
				driver.findElement(By.id("txtFName")).sendKeys(data5);	
			}
			
		    
			driver.findElement(By.id("fldBlood")).sendKeys(data6);
		    driver.findElement(By.id("txtAge")).sendKeys(String.valueOf(data7));
		    
		    WebElement co =(driver.findElement(By.id("txtCountry")));
		     co.clear();
		     co.sendKeys(data9);
			//Thread.sleep(2000);
			WebElement st =(driver.findElement(By.id("txtState")));
			 st.clear();
			 st.sendKeys(data10);
			//Thread.sleep(2000);	
			WebElement ci =(driver.findElement(By.id("txtCity")));
			 ci.clear();
			 ci.sendKeys(data11);
			//Thread.sleep(2000);
		
		    
		    driver.findElement(By.id("txtPhone")).sendKeys(String.valueOf(data8).toString().replaceAll("\\.", ""));
			Thread.sleep(2000);
		//	driver.findElement(By.name("filUpload")).sendKeys(data12.toString());
			Select fee=new Select(driver.findElement(By.id("fee")));
			fee.selectByIndex(2);
			Thread.sleep(2000);	
			driver.findElement(By.id("btnsubmit")).click();
			Thread.sleep(4000);	
			/*WebDriverWait wait = new WebDriverWait(driver, 15);
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.bootbox.modal.fade.bootbox-alert.in > div > div > div.modal-footer > button")));*/
			driver.findElement(By.cssSelector("body > div.bootbox.modal.fade.bootbox-alert.in > div > div > div.modal-footer > button")).click();
			Thread.sleep(3000);	
		System.out.println("The data from row " +i+ " is " +data0);
		System.out.println("The data from row " +i+ " is " +data1);
		System.out.println("The data from row " +i+ " is " +data2);
		System.out.println("The data from row " +i+ " is " +data3);
		System.out.println("The data from row " +i+ " is " +data4);
		System.out.println("The data from row " +i+ " is " +data5);
		System.out.println("The data from row " +i+ " is " +data6);
		System.out.println("The data from row " +i+ " is " +data7);
		System.out.println("The data from row " +i+ " is " +data8);
		System.out.println("The data from row " +i+ " is " +data10);
		System.out.println("The data from row " +i+ " is " +data11);
	//	System.out.println("The data from row " +i+ " is " +data12);
		System.out.println("The data from row " +i+ " is " +data13);
	
		/*Thread.sleep(2000);	
		driver.findElement(By.id("txtpname")).sendKeys(data1);
		Thread.sleep(2000);
	     driver.findElement(By.id("btnsrch")).click();
	 	Thread.sleep(1000);
	 	driver.findElement(By.cssSelector("#add1 > tbody > tr > td:nth-child(5) > input")).click();
	//     driver.findElement(By.xpath("//*[@id='add1']/tbody/tr/td[5]/input")).click();
		Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id='btnperclose']")).click();
	   //  driver.findElement(By.id("btnperclose")).click();
	     Thread.sleep(2000);*/
	     
	     
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
	    
	     
	     driver.findElement(By.xpath("//*[@id='add1']/tbody/tr/td[5]/input")).click();
	    
		
			
			Thread.sleep(2000);
	     
	     
	     Select dep=new Select(driver.findElement(By.id("dd_Department")));
	     dep.selectByIndex(5);
	     Thread.sleep(3000);
	     Select doc=new Select(driver.findElement(By.id("dd_Doc")));
	    // doc.selectByVisibleText("Dr.Kumaran,DOCID/2017/09/98");
	     doc.selectByIndex(1);
	     Thread.sleep(1000);
	     driver.findElement(By.id("radd")).sendKeys(data13);
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/div[2]/div[4]/a/img")).click();
		Thread.sleep(2000);
	     driver.findElement(By.id("btnsave")).click();
	     Thread.sleep(3000);
	     WebDriverWait wait1 = new WebDriverWait(driver, 10);
	     wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnperclose")));

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

