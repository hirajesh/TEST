package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Doctor {

	
	WebDriver driver;
	String Username,Demail;
	String Doctorname[]={"SRIHARI","PRIYA","VENGATRAMAN"};
	int DGender[]={1,2,1};
	String QUalification[]={"M.B","M.B","M.B"};
	String Specilization[]={"ge","An","ge"};
	String DMobilenumber[]={"9856050017","9856050015","9856050016"};
	String DYear[]={"1985","1987","1988"};
	int DMonth[]={3,5,6};
	String DDate[]={"12","15","18"};
	String MCI[]={"Mci242526","Mci282930","Mci282930"};
	String PAN[]={"Pan282930","Pan383930","Pan482839"};
	String TAX[]={"Sr313233","Sr513268","Sr823242"};
	String SAP[]={"sap282932","sap282933","sap282935"};
	String doc="doc";
	String Hosname="BSR HOSPITAL";
	int i;




	@Test
	public void Login() throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.get("http://182.18.161.229/Multihospital_New/");
		driver.get("http://122.165.236.133/Multihospital/");
		//driver.get("http://182.18.161.229/Multihospital_New/");
		driver.findElement(By.linkText("Admin Master")).click();
		driver.findElement(By.id("txtusername")).sendKeys("admin");
		driver.findElement(By.id("txtpassword")).sendKeys("admin123");
		Thread.sleep(4000);
		
		
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();

		Thread.sleep(5000);
		Doc();
		Thread.sleep(3000);
		signout();
		Thread.sleep(2000);
		driver.close();
		
	}

	public void Doc() throws InterruptedException
	{

		driver.findElement(By.xpath("//*[@id='loadfull']/aside[1]/section/section/ul/li[5]/a")).click();
		Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[8]/a")).click();
	Thread.sleep(2000);	
		


	for(i=2;i<=Doctorname.length-1;i++)
	{
		
		WebElement Add=driver.findElement(By.id("btnadd"));
		Actions action=new Actions(driver);
		action.moveToElement(Add).click().perform();
		Thread.sleep(3000);	
		
		
	driver.findElement(By.id("dname")).sendKeys(Doctorname[i]);
	Thread.sleep(500);

	Select Gender=new Select(driver.findElement(By.id("gen")));
	Thread.sleep(2000);
	Gender.selectByIndex(DGender[i]);

	driver.findElement(By.xpath("//*[@id='dob']")).click();
	Thread.sleep(2000);

	Select Year=new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")));
	Thread.sleep(2000);
	Year.selectByVisibleText(DYear[i]);
	Thread.sleep(2000);


	Thread.sleep(2000);
	Select Month=new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]")));
	Thread.sleep(2000);
	Month.selectByIndex(DMonth[i]);

	driver.findElement(By.linkText(DDate[i])).click();

	driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/section/div[2]/div[3]/span[2]/span[1]/span/ul/li/input")).sendKeys(QUalification[i]);
	Thread.sleep(1000);

	driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/section/div[2]/div[3]/span[2]/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
	Thread.sleep(1000);

	driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/section/div[3]/div[1]/span[2]/span[1]/span/ul/li/input")).sendKeys(Specilization[i]);
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/section/div[3]/div[1]/span[2]/span[1]/span/ul/li/input")).sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(500);
	driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/section/div[3]/div[1]/span[2]/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
	Thread.sleep(500);

	driver.findElement(By.id("txtmci")).sendKeys(MCI[i]);
	Thread.sleep(500);

	driver.findElement(By.id("txtpan")).sendKeys(PAN[i]);
	Thread.sleep(500);

	driver.findElement(By.id("txtax")).sendKeys(TAX[i]);
	Thread.sleep(500);

	driver.findElement(By.id("txtmbl")).sendKeys(DMobilenumber[i]);
	Thread.sleep(2000);

	Demail=Doctorname[i].toLowerCase().toString().trim();

	driver.findElement(By.id("txtemail")).sendKeys(Demail+"@gmail.com");
	Thread.sleep(500);

	//Username=doc+Doctorname[i].toLowerCase();
	driver.findElement(By.id("txtuser")).sendKeys(Doctorname[i].toLowerCase().trim().toString());
	Thread.sleep(500);
	driver.findElement(By.id("txtpwd")).sendKeys("123");
	Thread.sleep(500);
	driver.findElement(By.id("txtconfirmpwd")).sendKeys("123");
	Thread.sleep(500);

	WebElement hos=driver.findElement(By.id("opthos1"));
	Thread.sleep(2000);
	Select hospital=new Select(hos);
	hospital.selectByVisibleText(Hosname);


	driver.findElement(By.id("txtsapno")).sendKeys(SAP[i]);
	Thread.sleep(500);

	driver.findElement(By.id("txtctry")).clear();
	driver.findElement(By.id("txtctry")).sendKeys("India");
	Thread.sleep(500);
	driver.findElement(By.id("txtstate")).clear();
	driver.findElement(By.id("txtstate")).sendKeys("Tamilnadu");
	Thread.sleep(400);
	driver.findElement(By.id("txtcity")).clear();
	driver.findElement(By.id("txtcity")).sendKeys("Tichy");
	Thread.sleep(500);
	driver.findElement(By.id("txtpin")).sendKeys("6202231");
	Thread.sleep(500);

	if(DGender[i]==2)
	{
		driver.findElement(By.id("filUpload")).sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\DOCTOR\\DocFemale.jpg");
		Thread.sleep(500);
		driver.findElement(By.id("filUpload1")).sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\DOCTOR\\s0.png");
		Thread.sleep(500);
	}
	else
	{
	driver.findElement(By.id("filUpload")).sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\DOCTOR\\doc0.jpg");
	Thread.sleep(500);
	driver.findElement(By.id("filUpload1")).sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\DOCTOR\\s1.png");
	Thread.sleep(500);
	}
	WebElement submit=driver.findElement(By.id("btnsave"));
	Actions action1=new Actions(driver);
	action1.moveToElement(submit).click().perform();
	Thread.sleep(4000);

	try {
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
		}
	}

	Thread.sleep(4000);

	}
	}
		
	public void signout() throws InterruptedException {
		try {
			Thread.sleep(2000);
			
		//	driver.findElement(By.xpath("/html/body/header/div/nav/div/ul/li[2]/a")).click();
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
	}
