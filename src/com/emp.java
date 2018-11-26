package com;



	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.ITestResult;
	import org.testng.annotations.Test;

	public class emp {

		WebDriver driver;
		String Hospitalname="MALARHOSPITAL"; 
		String Address="Trichy";
		long EmployeeId=1;
		int Department=12,pw=123;
		String EmailID,Eid,Username,Email,Hname,Password,CPassword;
		public static String Ename=null;
		String[] Employeename={"RAGU","BALA","KUMAR","RAJA","SHAFI","NAVAS","VISHNU","JANA","RANA","RANI","SANDEEP","VENI","RAJU","NITHYA","ANU"};
		String[] Gender={"Male","Male","Male","Male","Male","Male","Male","Male","Male","Female","Male","Female","Male","Male","Male"};
		String[] Role={"Receptionist","Billing","Transactions","Laboratorist","Pharmacy In Charge","Pharmacist","Inpatient In Charge","CMO","Emergency","Charge Nurse","Laundry Incharge","Staff Nurse","Housekeeping","Staff Nurse","Staff Nurse"};
		String[] Mobile={"9658742130","9658742131","9658742132","9658742133","9658742134","9658742135","9658742136","9658742140","9658742141","9658742142","9658742143","9658742137","9658742144","9658742138","9658742139",};
		
		
		
		
	@Test
		public void OPEN() throws IOException, InterruptedException 
		{

		
		    System.setProperty("webdriver.chrome.driver","D:\\Selenium\\add jar files\\chromedriver.exe"); 
			driver = new ChromeDriver();
			driver.get("http:\\192.168.137.1/Multihospital_new");
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Admin Master")).click();
			driver.findElement(By.id("txtusername")).sendKeys("rinnukumar");
			driver.findElement(By.id("txtpassword")).sendKeys("123");
	        Thread.sleep(4000);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
		
			Thread.sleep(5000);
			driver.findElement(By.linkText("Employee")).click();
			Thread.sleep(3000);
			
			try 
			{
				employeeinsert();
				
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	driver.close();
		}

		public void employeeinsert() throws InterruptedException, IOException 
		{
		
		
			
			for(int O=0;O<=Employeename.length-1;O++)
			{
			
			
			Hname=Hospitalname.substring(0,3).trim();
			Eid=Hname.concat(String.valueOf(EmployeeId));
			System.out.println("EMPLOYEE ID " +Eid);
			
			Email="@gmail.com";
			EmailID=Employeename[O].toLowerCase()+Email.trim();
			System.out.println("EMPLOYEE EMAIL "+EmailID);
			
			Username=Hname.toLowerCase()+Employeename[O].toLowerCase().toString().trim();
			Thread.sleep(2000);
			Ename=Username.trim();
			
			Password=Employeename[O].toLowerCase()+String.valueOf(pw).toLowerCase().trim();
			CPassword=Password;
			
			
			System.out.println(EmployeeId);
			System.out.println(Employeename[O]);
			System.out.println(Gender[O]);
			System.out.println(Department);
			System.out.println(Role[O]);
			System.out.println(Address);
			System.out.println(Mobile[O]);
			System.out.println(EmailID);
			System.out.println(Username);
			System.out.println(Password);
			System.out.println(CPassword);
			EmployeeId++;
			
			try 
			{
				WebElement element=driver.findElement(By.id("btnadd"));
				clickactions(element);
				Thread.sleep(3000);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				WebElement element=driver.findElement(By.id("btnadd"));
				clickactions(element);
				Thread.sleep(3000);
				
			}
			
			try 
			{
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("txtempid")));
				driver.findElement(By.id("txtempid")).sendKeys(Eid);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				Thread.sleep(2000);
				while(true)
				{
				try {
					driver.findElement(By.xpath("//*[@id='txtempid']")).sendKeys(Eid);
					break;
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
					continue;
				}
				}
			}
			
			driver.findElement(By.id("txtfirstname")).sendKeys(Employeename[O]);
			Select gen = new Select(driver.findElement(By.id("gen")));
			gen.selectByVisibleText(Gender[O]);

			/*Select hospital = new Select(driver.findElement(By.id("opthos")));
			hospital.selectByVisibleText(Department);*/

			Select department = new Select(driver.findElement(By.id("optdepat")));
			department.selectByIndex(Department);

			Select role = new Select(driver.findElement(By.id("optrole")));
			role.selectByVisibleText(Role[O]);

			
			
			driver.findElement(By.id("txtdoj")).click();
			Thread.sleep(2000);
			
			Select Year=new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")));
			Year.selectByIndex(10);
			Thread.sleep(500);
			
			driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-prev.ui-corner-all")).click();
			driver.findElement(By.linkText("27")).click();
			// driver.findElement(By.id("imgphoto")).sendKeys("image path");

			driver.findElement(By.id("txtadd1")).sendKeys(Address);
			driver.findElement(By.id("txtphone1")).sendKeys(Mobile[O]);
			driver.findElement(By.id("txtemail")).sendKeys(EmailID);
			
			
			if((Role[O].toString().equals("Receptionist"))||(Role[O].toString().equals("Billing"))||(Role[O].toString().equals("Transactions"))||(Role[O].toString().equals("Laboratorist"))||(Role[O].toString().equals("Pharmacy In Charge"))||(Role[O].toString().equals("Pharmacist"))||(Role[O].toString().equals("Inpatient In Charge"))||(Role[O].toString().equals("CMO"))||(Role[O].toString().equals("Emergency")))			 
			 {
				    driver.findElement(By.id("txtuser")).sendKeys(Username);
					driver.findElement(By.id("txtpwd")).sendKeys(String.valueOf(Password));
					driver.findElement(By.id("txtconfirmpwd")).sendKeys(String.valueOf(CPassword));
					Thread.sleep(2000);
					WebElement save=driver.findElement(By.id("btnsave"));
					
					clickactions(save);
					Thread.sleep(4000);
					try 
					{
						
						driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
					}
					catch (Exception e)
					{
						Thread.sleep(500);
						e.printStackTrace();
						driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
					}
					Thread.sleep(2000);	
		
			}
			 else
			 {
					Thread.sleep(2000);
					
					WebElement save=driver.findElement(By.id("btnsave"));
					
					clickactions(save);
					Thread.sleep(4000);
					try
					{
						
						driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
					}
					catch (Exception e)
					{
						Thread.sleep(500);
						e.printStackTrace();
						driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
					}
					Thread.sleep(2000);
			 }
			 
			 
		}	
	}
		public void clickactions(WebElement element)
		{
			Actions action=new Actions(driver);
			action.moveToElement(element).click().perform();
		}	
		
	public void screen(ITestResult result) throws IOException
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("E:\\KDMC\\Employee Insert\\" +System.currentTimeMillis()+ ".png"));

	}
		
	}
	}

