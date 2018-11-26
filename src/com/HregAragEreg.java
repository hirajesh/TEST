package com;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HregAragEreg {

	WebDriver driver;
	String date1, dat;
	String Hospitalname = "BSRS HOSPITAL"; // Giva a name without space because empty space not allowed
	String Healthpostname = "BSRS HEALTHPOST";
	String Dispensaryname = "BSRS DISPENSARY";
	public static String Hospitaladminusername, Healthpostadminusername, Dispensaryadminusername;

	String Hospital_adminname = "BHUVANESH", HOS_ADMIN_MNUMBER = "8781277776";
	String Healthpost_adminname = "VIVEK", HEL_ADMIN_MNUMBER = "8787777789";
	String Dispensary_adminname = "VIKAS", DIS_ADMIN_MNUMBER = "8787777770";
   
	
	// ALERT MSG
	// =============
	String Hospital_Alert_msg, Hospital_Admin_Alert_msg, Healthpost_Reg_Alert_msg, Dispensary_Reg_Alert_msg;
	String block, ward, ward_category, floor, bed, room, icu, room_list, dat1;

	// DELETE FUNCTION
	// ==================
	Statement St;
	String Hospital = "delete from Mstr_MultipleHospital where Hospital_Name='BSR HOSPITAL'";
	String Healthpost = "delete from Mstr_MultipleHospital where Hospital_Name='BSR HEALTHPOST'";
	String Dispensary = "delete from Mstr_MultipleHospital where Hospital_Name='BSR DISPENSARY'";
	String Hospitaladmin = "delete from mstr_Employee where Name='MUTHUKUMAR'";
	String Healthpostadmin = "delete from mstr_Employee where Name='VINOTHKUMAR'";
	String Dispensaryadmin = "delete from mstr_Employee where Name='ASHOKUMAR'";
	String Delhealthpostname = "delete from Mstr_HealthpostReg where HealthpostName='BSR HEALTHPOST'";
	String Deldispensaryname = "delete from Mstr_DispensaryReg where Dispensaryname='BSR DISPENSARY'";

	@Test
	public void HOSHELDIS_REG() throws InterruptedException, IOException, SQLException {

		// driver = new FirefoxDriver(); //chrome is not run this script because
		// of selenium 3.7.1 jar use 2.48

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\add jar files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Admin Master")).click();
		driver.findElement(By.id("txtusername")).sendKeys("admin");
		driver.findElement(By.id("txtpassword")).sendKeys("admin123");
		Thread.sleep(4000);

		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		Date date = new Date();
		date1 = dateFormat.format(date);
		dat = date1.substring(0, 2);

		if (dat.startsWith(String.valueOf(0))) {
			dat1 = dat.substring(1).trim();
			System.out.println(dat1);
		} else {
			dat1 = date1.substring(0, 2).trim();
			System.out.println(dat1);
		}

		try {

			Hospital();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			driver.navigate().refresh();
			Hospital();
		}
		try {

			Healthpost();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			driver.navigate().refresh();
			Healthpost();
		}

		try {
			Dispensary();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Dispensary();
		}

		try {
			Hospital_Admin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Hospital_Admin();
		}
		try {
			Healthpost_Admin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Healthpost_Admin();
		}
		try {
			Dispensary_Admin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Dispensary_Admin();
		}

		try {
			Healthpost_Reg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Healthpost_Reg();
		}
		try {
			Dispensary_Reg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Dispensary_Reg();
			Thread.sleep(5000);
		}

		try {
			Hospital_Block_Room_Ward_Bed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
		
		
		Thread.sleep(5000);
		
		Employee Employeeinsertdata = new Employee();
		Employeeinsertdata.OPEN();
		Thread.sleep(5000);
		
		DMSTOCMS StoreRequest=new DMSTOCMS();
		StoreRequest.Run();
		Thread.sleep(5000);
		
		LabRequest Lab = new LabRequest();
		Lab.nn();
		Thread.sleep(5000);
		
		Pharmacyrequest pharmacyrequest = new Pharmacyrequest();
		pharmacyrequest.Pharmacy();
		Thread.sleep(5000);
		
		Inpatientrequest inpatientrequest = new Inpatientrequest();
		inpatientrequest.Inpatient();
		
		
	

		System.out.println("* Hospital,Healthpost,Dispensary,And All Admin are inserted sucessfully");
		System.out.println("* Hospital_Block_Room_Ward_Bed are inserted sucessfully");

	}

	public void Hospital() throws InterruptedException, IOException {

		try {
			System.out.println("HOSPITAL REGISTRATION");
			System.out.println("=====================");

			try {
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[text()='Hospital Registration']")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(3000);
				WebElement hreg = driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[7]/a"));
				Actions action = new Actions(driver);
				action.moveToElement(hreg).click().perform();
				Thread.sleep(2000);
			}

			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("opttype")));
			select.selectByIndex(1);

			driver.findElement(By.id("txthname")).sendKeys(Hospitalname);
			Thread.sleep(1000);
			System.out.println(Hospitalname);

			Thread.sleep(3000);
			driver.findElement(By.id("txtphn")).sendKeys("04322220444");
			driver.findElement(By.id("txtmbl")).sendKeys("9898588787");
			driver.findElement(By.id("cname")).sendKeys("MAHI");
			driver.findElement(By.id("fax")).sendKeys("4568796");
			driver.findElement(By.id("sno")).sendKeys("789878");
			driver.findElement(By.id("txtctry")).clear();
			driver.findElement(By.id("txtctry")).sendKeys("INDIA");
			driver.findElement(By.id("txtstate")).clear();
			driver.findElement(By.id("txtstate")).sendKeys("TAMILNADU");
			driver.findElement(By.id("txtcity")).clear();
			driver.findElement(By.id("txtcity")).sendKeys("TRICHY");
			driver.findElement(By.id("txtpin")).sendKeys("6565555");
			// driver.findElement(By.id("filUpload")).sendKeys(data0);
			driver.findElement(By.id("add")).sendKeys("KMS STREET,TRICHY");

			String Hname = Hospitalname.substring(0, 3).toLowerCase();
			String mail = "@gmail.com";
			String HOS = Hname.concat(mail);
			driver.findElement(By.id("txtemail")).sendKeys(HOS);

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(3000);

			Hospital_Alert_msg = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
			System.out.println("* Hospital Alert Msg :" + Hospital_Alert_msg + " *");
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			System.out.println("* HOSPITAL WAS GENERATES SUCCESSFULLY");

			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			Hospital_Alert_msg = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText()
					.toString();
			System.out.println("* Hospital Alert Msg :" + Hospital_Alert_msg + " *");
		}

	}

	public void Healthpost() throws InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			System.out.println(" HEALTHPOST");
			System.out.println("==============");
			Thread.sleep(3000);
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Hospital Registration']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("opttype")));
			select.selectByIndex(2);
			Thread.sleep(1000);
			driver.findElement(By.id("txthname")).sendKeys(Healthpostname);
			Thread.sleep(1000);

			String Hpostname = Healthpostname.substring(0,4).toLowerCase().trim();
			String mail ="@gmail.com";
			String HP = Hpostname.concat(mail).trim();
			Thread.sleep(1000);

			driver.findElement(By.id("txtemail")).sendKeys(HP);
			driver.findElement(By.id("txtphn")).sendKeys("043222204012");
			driver.findElement(By.id("txtmbl")).sendKeys("9898588755");
			driver.findElement(By.id("cname")).sendKeys("AJAY");
			driver.findElement(By.id("fax")).sendKeys("8568696");
			driver.findElement(By.id("sno")).sendKeys("6523000");
			driver.findElement(By.id("txtctry")).clear();
			driver.findElement(By.id("txtctry")).sendKeys("INDIA");
			driver.findElement(By.id("txtstate")).clear();
			driver.findElement(By.id("txtstate")).sendKeys("TAMILNADU");
			driver.findElement(By.id("txtcity")).clear();
			driver.findElement(By.id("txtcity")).sendKeys("TRICHY");
			driver.findElement(By.id("txtpin")).sendKeys("6562545");
			// driver.findElement(By.id("filUpload")).sendKeys(data0);
			driver.findElement(By.id("add")).sendKeys("SS STREET,TRICHY");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(3000);
			Hospital_Alert_msg =  driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
			System.out.println("* Healthpost Alert Msg :" + Hospital_Alert_msg + " *");
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			
			Thread.sleep(3000);

			System.out.println("* HEALTHPOST WAS GENERATED SUCCESSFULLY");
			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Hospital_Alert_msg = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText()
					.toString();
			System.out.println("* Healthpost Alert Msg :" + Hospital_Alert_msg + " *");
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();

		}

	}

	public void Dispensary() throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			System.out.println("DISPENSARY REGISTRATION");
			System.out.println("========================");
			driver.findElement(By.xpath("//*[text()='Hospital Registration']")).click();
			Thread.sleep(2000);

			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("opttype")));
			select.selectByIndex(3);
			Thread.sleep(1000);
			driver.findElement(By.id("txthname")).sendKeys(Dispensaryname);
			Thread.sleep(1000);

			String Disname = Dispensaryname.substring(0, 4).toLowerCase().trim();
			String mail ="@gmail.com";
			String DM = Disname.concat(mail).trim();
			Thread.sleep(1000);

			driver.findElement(By.id("txtemail")).sendKeys(DM);
			driver.findElement(By.id("txtphn")).sendKeys("04322220443");
			driver.findElement(By.id("txtmbl")).sendKeys("9898588784");
			driver.findElement(By.id("cname")).sendKeys("VISHNU");
			driver.findElement(By.id("fax")).sendKeys("6578712");
			driver.findElement(By.id("sno")).sendKeys("784512");
			driver.findElement(By.id("txtctry")).clear();
			driver.findElement(By.id("txtctry")).sendKeys("INDIA");
			driver.findElement(By.id("txtstate")).clear();
			driver.findElement(By.id("txtstate")).sendKeys("TAMILNADU");
			driver.findElement(By.id("txtcity")).clear();
			driver.findElement(By.id("txtcity")).sendKeys("TRICHY");
			driver.findElement(By.id("txtpin")).sendKeys("6562553");
			// driver.findElement(By.id("filUpload")).sendKeys(data0);
			driver.findElement(By.id("add")).sendKeys("KK STREET,TRICHY");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(3000);
			Hospital_Alert_msg = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText()
					.toString();
			System.out.println("* Dispensary Alert Msg :" + Hospital_Alert_msg + " *");

			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			System.out.println("* DISPENSARY WAS GENERATED SUCCESSFULLY");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			Hospital_Alert_msg = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText()
					.toString();
			System.out.println("* Dispensary Alert Msg :" + Hospital_Alert_msg + " *");
		}

	}

	public void Hospital_Admin() throws InterruptedException, IOException {

		try {
			Thread.sleep(2000);
			System.out.println("HOSPITAL ADMIN REGISTRATION");
			System.out.println("============================");
			driver.findElement(By.xpath("//*[text()='Admin Registration']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(3000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Admin Registration']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(3000);
		}

		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			int k = 1;
			String A = "EMP";
			String E = Hospitalname.substring(0, 3);
			String Employeeid = E.concat(A + String.valueOf(k));

			driver.findElement(By.id("txtempid")).sendKeys(Employeeid);
			driver.findElement(By.id("txtfirstname")).sendKeys(Hospital_adminname);
			Select gen = new Select(driver.findElement(By.id("gen")));
			gen.selectByIndex(1);
			Select hospital = new Select(driver.findElement(By.id("opthos")));
			Thread.sleep(2000);
			hospital.selectByVisibleText(Hospitalname);

			Select department = new Select(driver.findElement(By.id("optdepat")));
			department.selectByIndex(12);

			Select role = new Select(driver.findElement(By.id("optrole")));
			role.selectByIndex(1);

			try {

				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y = new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				// driver.findElement(By.cssSelector("#ui-datepicker-div > div >
				// a.ui-datepicker-prev.ui-corner-all")).click();
				driver.findElement(By.linkText("15")).click();

			} catch (Exception e) {

				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y = new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				// driver.findElement(By.cssSelector("#ui-datepicker-div > div >
				// a.ui-datepicker-prev.ui-corner-all")).click();
				driver.findElement(By.linkText("15")).click();
			}
			// driver.findElement(By.id("imgphoto")).sendKeys("image path");

			driver.findElement(By.id("txtadd1")).sendKeys("KK NAGR TRICHY");
			driver.findElement(By.id("txtphone1")).sendKeys(HOS_ADMIN_MNUMBER);

			Hospitaladminusername = Hospital_adminname.trim().toLowerCase();
			String str = "@gmail.com";
			String Adminemail = Hospitaladminusername.concat(str);
			driver.findElement(By.id("txtemail")).sendKeys(Adminemail);
			driver.findElement(By.id("txtuser")).sendKeys(Hospitaladminusername);

			driver.findElement(By.id("txtpwd")).sendKeys("123");
			driver.findElement(By.id("txtconfirmpwd")).sendKeys("123");
			Thread.sleep(2000);
			JavascriptExecutor jse2 = (JavascriptExecutor) driver;
			jse2.executeScript("window.scrollBy(0,800)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(4000);

			try {

				try {
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div"))
							.getText().toString();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					Thread.sleep(3000);
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div"))
							.getText().toString();
				}
				System.out.println("* Hosptial Admin Alert Msg :" + Hospital_Admin_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println("* HOSPITAL ADMIN ARE REGISTERED SUCCESSFULLY");

			} catch (Exception e) {

				e.printStackTrace();
				Thread.sleep(2000);
				try {
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div"))
							.getText().toString();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					Thread.sleep(3000);
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("* Hosptial Admin Alert Msg :" + Hospital_Admin_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				
				System.out.println("* HOSPITAL ADMIN ARE REGISTERED SUCCESSFULLY");

			}
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			Thread.sleep(3000);
			Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText()
					.toString();
			System.out.println("* Hosptial Admin Alert Msg :" + Hospital_Admin_Alert_msg + " *");
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			System.out.println("* HOSPITAL ADMIN ARE REGISTERED SUCCESSFULLY");

			// driver.navigate().refresh();
			/*
			 * WebElement save=driver.findElement(By.id("btnsave")); Actions
			 * action=new Actions(driver);
			 * action.moveToElement(save).click().perform();
			 */
		}
	}

	public void Healthpost_Admin() throws InterruptedException, IOException {
		// driver.findElement(By.xpath("//*[text()='Admin
		// Registration']")).click();
		System.out.println("HEALTHPOST ADMIN REGISTRATION");
		System.out.println("==============================");

		try {
			Thread.sleep(3000);
			WebElement add = driver.findElement(By.id("btnadd"));
			Actions action = new Actions(driver);
			action.moveToElement(add).click().perform();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			Thread.sleep(3000);
			WebElement add = driver.findElement(By.id("btnadd"));
			Actions action = new Actions(driver);
			action.moveToElement(add).click().perform();

		}

		// driver.findElement(By.id("btnadd")).click();
		Thread.sleep(3000);
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			int k = 1;
			String HA = "H";
			String EHA = Hospitalname.substring(0, 3);
			String Employeeid = EHA.concat(HA + String.valueOf(k));

			driver.findElement(By.id("txtempid")).sendKeys(Employeeid);
			driver.findElement(By.id("txtfirstname")).sendKeys(Healthpost_adminname);

			Select gen = new Select(driver.findElement(By.id("gen")));
			gen.selectByIndex(1);

			Select hospital = new Select(driver.findElement(By.id("opthos")));
			Thread.sleep(2000);
			hospital.selectByVisibleText(Healthpostname);

			Select department = new Select(driver.findElement(By.id("optdepat")));
			department.selectByIndex(12);

			Select role = new Select(driver.findElement(By.id("optrole")));
			role.selectByIndex(1);

			try {

				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y = new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				driver.findElement(By.linkText("15")).click();
			} catch (Exception e) {

				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y = new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				driver.findElement(By.linkText("15")).click();
			}
			// driver.findElement(By.id("imgphoto")).sendKeys("image path");

			driver.findElement(By.id("txtadd1")).sendKeys("DMS 2ND STREET TRICHY");
			driver.findElement(By.id("txtphone1")).sendKeys(HEL_ADMIN_MNUMBER);
			Healthpostadminusername = Healthpost_adminname.trim().toLowerCase();
			String str = "@gmail.com";
			String Adminemail = Healthpostadminusername.concat(str);

			driver.findElement(By.id("txtemail")).sendKeys(Adminemail);
			driver.findElement(By.id("txtuser")).sendKeys(Healthpostadminusername);

			driver.findElement(By.id("txtpwd")).sendKeys("123");
			driver.findElement(By.id("txtconfirmpwd")).sendKeys("123");
			Thread.sleep(2000);
			JavascriptExecutor jse3 = (JavascriptExecutor) driver;
			jse3.executeScript("window.scrollBy(0,800)", "");

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(4000);

			try {
				try {
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText().toString();
				} catch (Exception e) {
					Thread.sleep(2000);
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("Healthpost Alert msg : * " + Hospital_Admin_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println("* HEALTHPOST ADMIN ARE REGISTERED SUCCESSFULLY");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				try {
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div"))
							.getText().toString();
				} catch (Exception e1) {
					Thread.sleep(2000);
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("Healthpost Alert msg : * " + Hospital_Admin_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println("* HEALTHPOST ADMIN ARE REGISTERED SUCCESSFULLY");
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// driver.navigate().refresh();
			Thread.sleep(2000);
			/*
			 * WebElement save=driver.findElement(By.id("btnsave")); Actions
			 * action=new Actions(driver);
			 * action.moveToElement(save).click().perform(); Thread.sleep(2000);
			 */
			Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText()
					.toString();
			System.out.println("Healthpost Alert msg : * " + Hospital_Admin_Alert_msg + " *");
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
			System.out.println("* HEALTHPOST ADMIN ARE REGISTERED SUCCESSFULLY");
		}
	}

	public void Dispensary_Admin() throws InterruptedException, IOException {

		System.out.println("DISPENSARY  ADMIN REGISTRATION ");
		System.out.println("===============================");
		try {
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(3000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(3000);
		}
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			int k = 1;
			String HD = "D";
			String HDE = Hospitalname.substring(0, 3);
			String Employeeid = HDE.concat(HD + String.valueOf(k));

			driver.findElement(By.id("txtempid")).sendKeys(Employeeid);
			driver.findElement(By.id("txtfirstname")).sendKeys(Dispensary_adminname);
			Select gen = new Select(driver.findElement(By.id("gen")));
			gen.selectByIndex(1);// selectByVisibleText("Male");

			Select hospital = new Select(driver.findElement(By.id("opthos")));
			Thread.sleep(2000);
			hospital.selectByVisibleText(Dispensaryname);

			Select department = new Select(driver.findElement(By.id("optdepat")));
			department.selectByIndex(12);

			Select role = new Select(driver.findElement(By.id("optrole")));
			role.selectByIndex(1);
			Thread.sleep(2000);

			try {
				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y = new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				driver.findElement(By.linkText("15")).click();
			} catch (Exception e) {

				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y = new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				driver.findElement(By.linkText("15")).click();
			}
			// driver.findElement(By.id("imgphoto")).sendKeys("image path");

			driver.findElement(By.id("txtadd1")).sendKeys("RAM STREET TRICHY");
			driver.findElement(By.id("txtphone1")).sendKeys(DIS_ADMIN_MNUMBER);

			Dispensaryadminusername = Dispensary_adminname.trim().toLowerCase();
			String str = "@gmail.com";
			String Adminemail = Dispensaryadminusername.concat(str);
			driver.findElement(By.id("txtemail")).sendKeys(Adminemail);
			driver.findElement(By.id("txtuser")).sendKeys(Dispensaryadminusername);

			driver.findElement(By.id("txtpwd")).sendKeys("123");
			driver.findElement(By.id("txtconfirmpwd")).sendKeys("123");
			Thread.sleep(2000);
			JavascriptExecutor jse4 = (JavascriptExecutor) driver;
			jse4.executeScript("window.scrollBy(0,500)", "");

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(4000);

			try {
				try {
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText().toString();
				} catch (Exception e) {
					Thread.sleep(2000);
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("Dispensary Alert msg : * " + Hospital_Admin_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println("* DISPENSARY ADMIN ARE REGISTERED SUCCESSFULLY");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText().toString();
				} catch (Exception e1) {
					Thread.sleep(2000);
					Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("Dispensary Alert msg : * " + Hospital_Admin_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println("* DISPENSARY ADMIN ARE REGISTERED SUCCESSFULLY");
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			/*
			 * Thread.sleep(2000); driver.navigate().refresh(); WebElement
			 * save=driver.findElement(By.id("btnsave")); Actions action=new
			 * Actions(driver); action.moveToElement(save).click().perform();
			 */
			Thread.sleep(2000);
			Hospital_Admin_Alert_msg = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div")).getText().toString();
			System.out.println("Dispensary Alert msg : * " + Hospital_Admin_Alert_msg + " *");
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
		}
	}

	public void Healthpost_Reg() throws IOException, InterruptedException {
		try {
			System.out.println("HEALTHPOST  REGISTRATION UNDER " + Hospitalname + "");
			System.out.println("================================================");
			driver.findElement(By.linkText("Healthpost Registration")).click();
			Thread.sleep(3000);
			Select Hselect = new Select(driver.findElement(By.id("opthealth")));
			Hselect.selectByVisibleText(Healthpostname);
			Select Hosselect = new Select(driver.findElement(By.id("opthos")));
			Hosselect.selectByVisibleText(Hospitalname);
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(4000);
			try {
				Healthpost_Reg_Alert_msg = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Healthpost Registration under hospital Alert msg : * " + Healthpost_Reg_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				System.out.println("* HEALTHPOST ARE REGISTERED SUCCESSFULLY UNDER " + Hospitalname + "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				Healthpost_Reg_Alert_msg = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Healthpost Registration under hospital Alert msg : * " + Healthpost_Reg_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				System.out.println("* HEALTHPOST ARE REGISTERED SUCCESSFULLY UNDER " + Hospitalname + "");
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Dispensary_Reg() throws IOException, InterruptedException {

		try {
			System.out.println("DISPENSARY  REGISTRATION UNDER " + Hospitalname + "");
			System.out.println("================================================");
			try {
				driver.findElement(By.linkText("Dispensary Registration")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[10]/a")).click();
				
			}
			
			
			Thread.sleep(3000);
			Select Hselect = new Select(driver.findElement(By.id("opthealth")));
			Hselect.selectByVisibleText(Dispensaryname);
			Select Hosselect = new Select(driver.findElement(By.id("opthos")));
			Hosselect.selectByVisibleText(Hospitalname);
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(4000);
			try {
				Dispensary_Reg_Alert_msg = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Dispensary Registration under hospital Alert msg : * " + Dispensary_Reg_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				System.out.println("* DISPENSARY ARE REGISTERED SUCCESSFULLY UNDER " + Hospitalname + "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				Dispensary_Reg_Alert_msg = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Dispensary Registration under hospital Alert msg : * " + Dispensary_Reg_Alert_msg + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				System.out.println("* DISPENSARY ARE REGISTERED SUCCESSFULLY UNDER " + Hospitalname + "");
			}
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[text()='Sign out']")).click();
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				driver.navigate().refresh();
				driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[text()='Sign out']")).click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Hospital_Block_Room_Ward_Bed() throws InterruptedException, IOException {

		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("Admin Master")).click();
			driver.findElement(By.id("txtusername")).sendKeys(Hospitaladminusername);
			driver.findElement(By.id("txtpassword")).sendKeys("123");
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			try {
				driver.findElement(By.xpath("\\*[text()='Employee']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				driver.findElement(By.xpath("\\*[text()='Employee']")).click();
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block

			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				driver.navigate().refresh();
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			}
		}

		// BLOCK
		// =============

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Block")).click();
		Thread.sleep(2000);
		WebElement Blo = driver.findElement(By.id("txtblock"));
		Blo.sendKeys("BLOCK1");
		Blo.getText();
		driver.findElement(By.id("btnsave")).click();
		Thread.sleep(3000);
		block = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
		System.out.println("Block Alert msg : * " + block + " *");
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();

		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement Blo1 = driver.findElement(By.id("txtblock"));
		Blo1.sendKeys("BLOCK2");
		Thread.sleep(2000);
		driver.findElement(By.id("btnsave")).click();
		Thread.sleep(3000);
		block = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
		System.out.println("Block Alert msg : * " + block + " *");
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();

		// FLOOR
		// =============

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospital']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Floor")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("optblock")));
			select.selectByVisibleText("BLOCK1");
			driver.findElement(By.id("txtfloor")).sendKeys("FIRSTFLOOR");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				floor = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Floor Alert msg : * " + floor + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				floor = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Floor Alert msg : * " + floor + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospital']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Floor")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("optblock")));
			select.selectByVisibleText("BLOCK1");
			driver.findElement(By.id("txtfloor")).sendKeys("FIRSTFLOOR");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				floor = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Floor Alert msg : * " + floor + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				floor = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Floor Alert msg : * " + floor + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// WARD CATEGORY
		// ====================
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ward Category")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtwardcat")).sendKeys("GENERAL");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				ward_category = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText()
						.toString();
				System.out.println("Ward category Alert msg : * " + ward_category + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				ward_category = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText()
						.toString();
				System.out.println("Ward category Alert msg : * " + ward_category + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ward Category")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtwardcat")).sendKeys("GENERAL");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				ward_category = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText()
						.toString();
				System.out.println("Ward category Alert msg : * " + ward_category + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				ward_category = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText()
						.toString();
				System.out.println("Ward category Alert msg : * " + ward_category + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// WARD LIST
		// =================

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ward List")).click();
			Thread.sleep(2000);
			Select wardlist = new Select(driver.findElement(By.id("optwardcate")));
			wardlist.selectByVisibleText("GENERAL");
			driver.findElement(By.id("txtwardname")).sendKeys("GEN1");
			driver.findElement(By.id("txtbed")).sendKeys("10");
			Select Department = new Select(driver.findElement(By.id("optdept")));
			Department.selectByVisibleText("GENERAL MEDICINE");
			Select Block = new Select(driver.findElement(By.id("optblock")));
			Block.selectByVisibleText("BLOCK1");
			Select Floor = new Select(driver.findElement(By.id("optFloor")));
			Floor.selectByVisibleText("FIRSTFLOOR");

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				ward = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward list Alert msg : * " + ward + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				ward = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward list Alert msg : * " + ward + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ward List")).click();
			Thread.sleep(2000);
			Select wardlist = new Select(driver.findElement(By.id("optwardcate")));
			wardlist.selectByVisibleText("GENERAL");
			driver.findElement(By.id("txtwardname")).sendKeys("GEN1");
			driver.findElement(By.id("txtbed")).sendKeys("10");
			Select Department = new Select(driver.findElement(By.id("optdept")));
			Department.selectByVisibleText("GENERAL MEDICINE");
			Select Block = new Select(driver.findElement(By.id("optblock")));
			Block.selectByVisibleText("BLOCK1");
			Select Floor = new Select(driver.findElement(By.id("optFloor")));
			Floor.selectByVisibleText("FIRSTFLOOR");

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				ward = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward list Alert msg : * " + ward + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				ward = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward list Alert msg : * " + ward + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// ROOM TYPE
		// =============

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Room Type")).click();
			Thread.sleep(2000);
			WebElement ROOM = driver.findElement(By.id("txtroomtype"));
			ROOM.sendKeys("SINGLE");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				room = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room Type Alert msg : * " + room + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				room = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room Type Alert msg : * " + room + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Room Type")).click();
			Thread.sleep(2000);
			WebElement ROOM = driver.findElement(By.id("txtroomtype"));
			ROOM.sendKeys("SINGLE");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				room = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room Type Alert msg : * " + room + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				room = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room Type Alert msg : * " + room + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// ROOM LIST
		// =================

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Room List")).click();
			Thread.sleep(2000);
			Select wardcat = new Select(driver.findElement(By.id("optcat")));
			wardcat.selectByVisibleText("GENERAL");
			Thread.sleep(2000);
			Select wardcatnum = new Select(driver.findElement(By.id("optwardcate")));
			wardcatnum.selectByVisibleText("GEN1");
			Thread.sleep(2000);
			Select Rtype = new Select(driver.findElement(By.id("optroomtype")));
			Rtype.selectByVisibleText("SINGLE");
			Thread.sleep(2000);
			driver.findElement(By.id("txtroom")).sendKeys("1");
			driver.findElement(By.id("txtactrate")).sendKeys("150");
			Thread.sleep(2000);
			Select TAX = new Select(driver.findElement(By.id("tx")));
			TAX.selectByVisibleText("No Tax 0%");
			Thread.sleep(2000);
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				room_list = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room List Alert msg : * " + room_list + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				room_list = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room List Alert msg : * " + room_list + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Room List")).click();
			Thread.sleep(2000);
			Select wardcat = new Select(driver.findElement(By.id("optcat")));
			wardcat.selectByVisibleText("GENERAL");
			Thread.sleep(2000);
			Select wardcatnum = new Select(driver.findElement(By.id("optwardcate")));
			wardcatnum.selectByVisibleText("GEN1");
			Thread.sleep(2000);
			Select Rtype = new Select(driver.findElement(By.id("optroomtype")));
			Rtype.selectByVisibleText("SINGLE");
			Thread.sleep(2000);
			driver.findElement(By.id("txtroom")).sendKeys("1");
			driver.findElement(By.id("txtactrate")).sendKeys("150");
			Thread.sleep(2000);
			Select TAX = new Select(driver.findElement(By.id("tx")));
			TAX.selectByVisibleText("No Tax 0%");
			Thread.sleep(2000);
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);

			try {
				room_list = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room List Alert msg : * " + room_list + " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				room_list = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room List Alert msg : * " + room_list + " *");
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// BED LIST
		// =================

		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Bed List")).click();
		Thread.sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				Select Bedwc = new Select(driver.findElement(By.id("optcat")));
				Bedwc.selectByVisibleText("GENERAL");
				Thread.sleep(2000);
				Select wardnum = new Select(driver.findElement(By.id("optwardcate")));
				wardnum.selectByVisibleText("GEN1");
				Thread.sleep(2000);
				Select Bedrtype = new Select(driver.findElement(By.id("optrtype")));
				Bedrtype.selectByVisibleText("SINGLE");
				Select Bedrnum = new Select(driver.findElement(By.id("optroomno")));
				Bedrnum.selectByVisibleText("1");
				Thread.sleep(2000);
				driver.findElement(By.id("txtbed")).sendKeys(String.valueOf(i));
				Thread.sleep(2000);
				driver.findElement(By.id("btnsave")).click();
				Thread.sleep(2000);

				try {
					bed = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(+i + " Bed Alert msg : * " + bed + " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Thread.sleep(2000);
					bed = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(+i + " Bed Alert msg : * " + bed + " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				Select Bedwc = new Select(driver.findElement(By.id("optcat")));
				Bedwc.selectByVisibleText("GENERAL");
				Thread.sleep(2000);
				Select wardnum = new Select(driver.findElement(By.id("optwardcate")));
				wardnum.selectByVisibleText("GEN1");
				Thread.sleep(2000);
				Select Bedrtype = new Select(driver.findElement(By.id("optrtype")));
				Bedrtype.selectByVisibleText("SINGLE");
				Select Bedrnum = new Select(driver.findElement(By.id("optroomno")));
				Bedrnum.selectByVisibleText("1");
				Thread.sleep(2000);
				driver.findElement(By.id("txtbed")).sendKeys(String.valueOf(i));
				Thread.sleep(2000);
				driver.findElement(By.id("btnsave")).click();
				Thread.sleep(2000);

				try {
					bed = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(" Bed Alert msg : * " + bed + " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					Thread.sleep(2000);
					bed = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(" Bed Alert msg : * " + bed + " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
			}
		}

		// ICU
		// =======

		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("ICU")).click();
		Thread.sleep(2000);

		for (int j = 1; j <= 5; j++) {
			try {
				Select selblock = new Select(driver.findElement(By.id("optblock")));
				selblock.selectByIndex(2);
				Thread.sleep(2000);
				driver.findElement(By.id("txtroom")).sendKeys(String.valueOf(j));
				Thread.sleep(2000);
				driver.findElement(By.id("txtbed")).sendKeys(String.valueOf(j));
				Thread.sleep(2000);
				Thread.sleep(2000);
				driver.findElement(By.id("txtactrate")).sendKeys("250");
				Thread.sleep(2000);
				Select tax = new Select(driver.findElement(By.id("tx")));
				tax.selectByIndex(1);
				driver.findElement(By.id("btnsave")).click();
				Thread.sleep(2000);

				try {
					icu = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(+j + " ICU Alert msg : * " + icu + " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Thread.sleep(2000);
					icu = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(+j + " ICU Alert msg : * " + icu + " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
			} catch (Exception e)

			{
				// TODO Auto-generated catch block
				e.printStackTrace();

				Select selblock = new Select(driver.findElement(By.id("optblock")));
				selblock.selectByIndex(2);
				Thread.sleep(2000);
				driver.findElement(By.id("txtroom")).sendKeys(String.valueOf(j));
				Thread.sleep(2000);
				driver.findElement(By.id("txtbed")).sendKeys(String.valueOf(j));
				Thread.sleep(2000);
				Thread.sleep(2000);
				driver.findElement(By.id("txtactrate")).sendKeys("250");
				Thread.sleep(2000);
				Select tax = new Select(driver.findElement(By.id("tx")));
				tax.selectByIndex(1);
				driver.findElement(By.id("btnsave")).click();
				Thread.sleep(2000);

				try {
					icu = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println("+j+" + " ICU Alert msg : * " + icu + " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					Thread.sleep(2000);
					icu = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println("+j+" + " ICU Alert msg : * " + icu + " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
			}
		}

	}

	@AfterMethod
	public void screen(ITestResult testresult1) throws IOException {
		if (testresult1.getStatus() == ITestResult.FAILURE) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("E:\\Jenkins output\\KDMC\\" + date1 + "" + testresult1.getName() + "-"
					+ Arrays.toString(testresult1.getParameters()) + ".png"));

		}
	}
}


 class Employee {

	WebDriver driver;
	
	HregAragEreg hos = new HregAragEreg();
	String Hospitalname = hos.Hospitalname;

	String AdminUN=hos.Hospitaladminusername.toString().trim();
	String Address = "Trichy";
	long EmployeeId = 1;
	int Department = 12, pw = 123;
	String EmailID, Eid, Username, Email, Hname, Password, CPassword;
	public static String Ename = null;
	
	
	/*String[] Employeename = { "RAGU", "BALA", "KUMAR", "RAJA", "SHAFI", "NAVAS", "VISHNU", "JANA", "RANA", "RANI",
			"SANDEEP", "VENI", "RAJU", "NITHYA", "ANU" };
	String[] Gender = { "Male", "Male", "Male", "Male", "Male", "Male", "Male", "Male", "Male", "Female", "Male",
			"Female", "Male", "Male", "Male" };
	String[] Role = { "Receptionist", "Billing", "Transactions", "Laboratorist", "Pharmacy In Charge", "Pharmacist",
			"Inpatient In Charge", "CMO", "Emergency", "Charge Nurse", "Laundry Incharge", "Staff Nurse",
			"Housekeeping", "Staff Nurse", "Staff Nurse" };
	String[] Mobile = { "9658742130", "9658742131", "9658742132", "9658742133", "9658742134", "9658742135",
			"9658742136", "9658742140", "9658742141", "9658742142", "9658742143", "9658742137", "9658742144",
			"9658742138", "9658742139", };
	*/
	
	String[] Employeename = { "PRINYANKA", "SURYA", "RAJKUMAR", "MANU", "SHAFI", "NAVAS", "VISHNU", "JANA","RANA","ANU","RAJI" };
	String[] Gender = { "Female", "Male", "Male", "Male", "Male", "Male", "Male", "Male", "Male","Female","Female"};
	String[] Role = { "Receptionist", "Billing", "Laboratorist", "Pharmacy In Charge", "Pharmacist","Inpatient In Charge", "CMO", "Emergency","Transactions","Charge Nurse","Staff Nurse"};
	String[] Mobile = { "9658742130", "9658742131", "9658742132", "9658742133", "9658742134", "9658742135",
			"9658742136", "9658742140", "9658742141","9658742142","9658742143"};
	
	
	
	
	public static List<creadentialist> Creatientials = new ArrayList<>();

	@Test
	public void OPEN() throws IOException, InterruptedException {
		
		
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\add jar files\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println(AdminUN);
		driver.get("http:\\192.168.137.1/Multihospital_new");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Admin Master")).click();
		driver.findElement(By.id("txtusername")).sendKeys(AdminUN);
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(4000);
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();

		Thread.sleep(5000);
		try {
			driver.findElement(By.linkText("Employee")).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a")).click();
			
		}
		

		Thread.sleep(3000);

		try {
			employeeinsert();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		signout();
		Thread.sleep(2000);
		driver.close();
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


	public void employeeinsert() throws InterruptedException, IOException {

		for (int O = 0; O <= Employeename.length - 1; O++) {

			Hname = Hospitalname.substring(0, 3).trim();
			Eid = Hname.concat(String.valueOf(EmployeeId));
			System.out.println("EMPLOYEE ID " + Eid);

			Email = "@gmail.com";
			EmailID = Employeename[O].toLowerCase() + Email.trim();
			System.out.println("EMPLOYEE EMAIL " + EmailID);

			//Username = Hname.toLowerCase() + Employeename[O].toLowerCase().toString().trim();
			Thread.sleep(2000);
			Username =  Employeename[O].toLowerCase().toString().trim();
			Ename = Username.trim();

			Password = Employeename[O].toLowerCase() + String.valueOf(pw).toLowerCase().trim();
			CPassword = Password;

			/*System.out.println(EmployeeId);
			System.out.println(Employeename[O]);
			System.out.println(Gender[O]);
			System.out.println(Department);*/
			System.out.println(Role[O]);
			/*System.out.println(Address);
			System.out.println(Mobile[O]);
			System.out.println(EmailID);*/
			System.out.println(Username);
			System.out.println(Password);
		//	System.out.println(CPassword);
			EmployeeId++;

			creadentialist creadential = new creadentialist();
			creadential.setUname(Username);
			creadential.setPword(Password);
			Creatientials.add(creadential);

			try {
				WebElement element = driver.findElement(By.id("btnadd"));
				clickactions(element);
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				WebElement element = driver.findElement(By.id("btnadd"));
				clickactions(element);
				Thread.sleep(3000);

			}

			try {
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("txtempid")));
				driver.findElement(By.id("txtempid")).sendKeys(Eid);
			} catch (Exception e) {
				e.printStackTrace();
				Thread.sleep(2000);
				while (true) {
					try {
						driver.findElement(By.xpath("//*[@id='txtempid']")).sendKeys(Eid);
						break;
					} catch (Exception e1) {
						e1.printStackTrace();
						continue;
					}
				}
			}

			driver.findElement(By.id("txtfirstname")).sendKeys(Employeename[O]);
			Select gen = new Select(driver.findElement(By.id("gen")));
			gen.selectByVisibleText(Gender[O]);

			/*
			 * Select hospital = new
			 * Select(driver.findElement(By.id("opthos")));
			 * hospital.selectByVisibleText(Department);
			 */

			Select department = new Select(driver.findElement(By.id("optdepat")));
			department.selectByIndex(Department);

			Select role = new Select(driver.findElement(By.id("optrole")));
			role.selectByVisibleText(Role[O]);

			driver.findElement(By.id("txtdoj")).click();
			Thread.sleep(2000);

			Select Year = new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")));
			Year.selectByIndex(10);
			Thread.sleep(500);

			driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-prev.ui-corner-all")).click();
			driver.findElement(By.linkText("27")).click();
			// driver.findElement(By.id("imgphoto")).sendKeys("image path");

			driver.findElement(By.id("txtadd1")).sendKeys(Address);
			driver.findElement(By.id("txtphone1")).sendKeys(Mobile[O]);
			driver.findElement(By.id("txtemail")).sendKeys(EmailID);

			if ((Role[O].toString().equals("Receptionist")) || (Role[O].toString().equals("Billing"))
					|| (Role[O].toString().equals("Transactions")) || (Role[O].toString().equals("Laboratorist"))
					|| (Role[O].toString().equals("Pharmacy In Charge")) || (Role[O].toString().equals("Pharmacist"))
					|| (Role[O].toString().equals("Inpatient In Charge")) || (Role[O].toString().equals("CMO"))
					|| (Role[O].toString().equals("Emergency"))) {
				driver.findElement(By.id("txtuser")).sendKeys(Username);
				driver.findElement(By.id("txtpwd")).sendKeys(String.valueOf(Password));
				driver.findElement(By.id("txtconfirmpwd")).sendKeys(String.valueOf(CPassword));
				Thread.sleep(2000);
				WebElement save = driver.findElement(By.id("btnsave"));

				clickactions(save);
				Thread.sleep(4000);
				try {

					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				} catch (Exception e) {
					Thread.sleep(500);
					e.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);

			} else {
				Thread.sleep(2000);

				WebElement save = driver.findElement(By.id("btnsave"));

				clickactions(save);
				Thread.sleep(4000);
				try {

					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				} catch (Exception e) {
					Thread.sleep(500);
					e.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
			}

		}
	}

	public void clickactions(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void screen(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("E:\\KDMC\\Employee Insert\\" + System.currentTimeMillis() + ".png"));

		}

	}

	class creadentialist {
		String Uname, Pword;

		public String getUname() {
			return Uname;
		}

		public void setUname(String uname) {
			Uname = uname;
		}

		public String getPword() {
			return Pword;
		}

		public void setPword(String pword) {
			Pword = pword;
		}

	}
}

 class DMSTOCMS {

		
		WebDriver driver;	
		String CMORNO, CMS_Requestnumber;
		List<issuedmedicinelist> issuedmedicine = new ArrayList<>();
		int a;
		String stok_qty_in_cms,Requestedqty;
		 int Seconds=0;
		
		@Test
		public void Run() throws InterruptedException, IOException {
			
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\add jar files\\chromedriver.exe"); 
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
				driver.navigate().refresh();
				Thread.sleep(3000);
				RequesttoCMS();
				Thread.sleep(2000);
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
			try {
				Dispatchfromcms();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Dispatchfromcms();
			}
			Thread.sleep(2000);
			/*dis();
			Thread.sleep(2000);*/
			DMS();
			Thread.sleep(2000);
			try {
				Addto_Stock();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				driver.navigate().refresh();
				Thread.sleep(2000);
				Addto_Stock();
			}
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
			driver.findElement(By.id("txtusername")).sendKeys(Employee.Creatientials.get(5).Uname.toString().trim());
			driver.findElement(By.id("txtpassword")).sendKeys(Employee.Creatientials.get(5).Pword.toString().trim());
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			Thread.sleep(5000);

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

			Thread.sleep(2000);
			try {
				Select rtype = new Select(driver.findElement(By.id("drpreqtype")));
				rtype.selectByIndex(1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				Select rtype = new Select(driver.findElement(By.xpath("//*[@id='drpreqtype']")));
				rtype.selectByIndex(1);
			}

			Thread.sleep(2000);
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
			Thread.sleep(500);
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
			Thread.sleep(500);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(500);

			Thread.sleep(2000);
			category.selectByIndex(11);
			Thread.sleep(500);
			choosemedicine.selectByIndex(1);
			
			driver.findElement(By.id("txttreat")).sendKeys("300");
			Thread.sleep(500);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(500);
			
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
			Thread.sleep(200);
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
			Thread.sleep(500);
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
			Thread.sleep(500);
			Select Lchoosemedicine = new Select(driver.findElement(By.id("optmedicine")));
			Lchoosemedicine.selectByIndex(5);
			Thread.sleep(500);
			driver.findElement(By.id("txttreat")).sendKeys("200");
			Thread.sleep(500);
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
			Thread.sleep(500);
			driver.findElement(By.id("txttreat")).sendKeys("300");
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
			
			Thread.sleep(200);
			Lcategory.selectByIndex(6);
			Thread.sleep(100);
			Lchoosemedicine.selectByIndex(2);
			Thread.sleep(500);
			driver.findElement(By.id("txttreat")).sendKeys("400");
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
		//	Thread.sleep(3000);
			
			
			 
			//PHARMACY ITEMS
			//================
			
			Select Pcategory = new Select(driver.findElement(By.id("optcategory")));
			Pcategory.selectByIndex(2);
			Thread.sleep(500);
			Select Pchoosemedicine = new Select(driver.findElement(By.id("optmedicine")));
			Pchoosemedicine.selectByIndex(12);
			Thread.sleep(500);
			driver.findElement(By.id("txttreat")).sendKeys("200");
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);

			Thread.sleep(2000);
			Pcategory.selectByIndex(2);
			//Thread.sleep(2000);
			Thread.sleep(500);
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
			Thread.sleep(500);
			Pchoosemedicine.selectByIndex(4);
			driver.findElement(By.id("txttreat")).sendKeys("350");
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
		

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
			
			System.out.println("Alertmsg " +alertmsg);
			System.out.println("* " +CMS_Requestnumber);
			
			String alertmsgis="* Already Exist this Request No !";
			                   
			if(alertmsg.equals(alertmsgis.trim()))
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
				driver.findElement(By.id("txtusername")).sendKeys(Employee.Creatientials.get(7).Uname.toString().trim());
				driver.findElement(By.id("txtpassword")).sendKeys(Employee.Creatientials.get(7).Pword.toString().trim());
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
				driver.findElement(By.id("txtusername")).sendKeys(Employee.Creatientials.get(7).Uname.toString().trim());
				driver.findElement(By.id("txtpassword")).sendKeys(Employee.Creatientials.get(7).Pword.toString().trim());
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
			driver.findElement(By.id("txtusername")).sendKeys("cms");
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
			driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[7]")).click();
			Thread.sleep(2000);
		

			for (int y = 30; y >= 9; y--) 
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
			}

			int col = driver.findElements(By.xpath("/html/body/div[2]/div/div/aside[2]/form/div[5]/section[2]/div/div[3]/div/div/div[2]/div/div/table/tbody/tr/td[1]")).size();
			//System.out.println(col);

			a = 0;
			row: 
				for (int r = 1; r <= col; r++) 
				{
				try {
					stok_qty_in_cms = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[2]")).getText();
					Requestedqty = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
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
						stok_qty_in_cms = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[2]")).getText();
						 Requestedqty = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
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

				if (Integer.parseInt(stok_qty_in_cms) < Integer.parseInt(Requestedqty)) {
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
					Thread.sleep(1000);
					String Batchqty = driver.findElement(By.id("txtbthqty" + a)).getAttribute("value");

				//	Thread.sleep(500);
					System.out.println("* Stockqty for this batch number:" + Batchqty);

					if (Integer.parseInt(Batchqty) >= Integer.parseInt(Requestedqty))
					{
						//driver.findElement(By.id("txtsal" + a)).clear();
					//	Thread.sleep(500);
					//	base.IDsend("txtsal" + a, Requestedqty);
						String issued = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
						String medicine = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[1]")).getText();

						issuedmedicinelist retrive = new issuedmedicinelist();
						retrive.setMedicineName(medicine);
						retrive.setIssuedQty(issued);
						issuedmedicine.add(retrive);
						break;

					}
					System.out.println("Stock Qty in less Than requested qty for this batch number");
	               
				}
				a++;
			}
			while (true) {
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
			Thread.sleep(3000);
			int add=driver.findElements(By.xpath("//*[@id='itemdetails1']/tbody/tr/td[7]")).size();
			System.out.print(add);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='myModal1']/div/div/div[3]/div/button")).click();
			Thread.sleep(2000);
			
			try {
				for(int q=1;q<=add;q++)
				{
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[7]")).click();
					Thread.sleep(2000);
				    try {
				    	Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[1]/td[6]")).click();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[1]/td[6]")).click();
					}
					Thread.sleep(3000);
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='myModal1']/div/div/div[3]/div/button")).click();
					Thread.sleep(2000);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				driver.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMS_Requestnumber);
				Thread.sleep(500);
			    driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[7]")).click();
				Thread.sleep(3000);
				int add1=driver.findElements(By.xpath("//*[@id='itemdetails1']/tbody/tr/td[7]")).size();
				System.out.print(add);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='myModal1']/div/div/div[3]/div/button")).click();
				Thread.sleep(2000);
				for(int q=1;q<=add1;q++)
				{
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[7]")).click();
					Thread.sleep(2000);
				    try {
				    	Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[1]/td[6]")).click();
						
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[1]/td[6]")).click();
					}
					Thread.sleep(3000);
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='myModal1']/div/div/div[3]/div/button")).click();
					Thread.sleep(2000);
					
					
				}
			}
				
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

	class nwissuedmedicinelist
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
 
 
 
 
 
 
 
 
class LabRequest 
{
	WebDriver driver;
	HregAragEreg hos = new HregAragEreg();
	int i, j, k, p, q, receveditem, a, g, h, column, row;
	String Lab_Rno, Ritem, xp, CMORNO, Stock_qty, Required_qty, PRNO, date1, Product_name, stock_list;
	public static List<StockData> stockDatas = new ArrayList<>();
    int Seconds=0;
	

	@Test
	public void nn() throws InterruptedException, IOException {

		DateFormat format = new SimpleDateFormat("dd/mm//yy");
		Date d = new Date();
		date1 = format.format(d);

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\add jar files\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println(Employee.Creatientials.get(8).toString());

		// driver.get("http://182.18.161.229/Multihospital_new");
		driver.get("http://192.168.137.1/Multihospital_New/");
        System.out.println(Employee.Creatientials.get(3).Pword.toString().trim());
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Investigation")).click();
		driver.findElement(By.id("txtusername")).sendKeys(Employee.Creatientials.get(3).Uname.toString().trim());
		driver.findElement(By.id("txtpassword")).sendKeys(Employee.Creatientials.get(3).Pword.toString().trim());
		Thread.sleep(4000);

		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println(" ");
		System.out.println("LAB REQUEST");
		System.out.println("================= ");
		System.out.println(" ");

		Lab_storerequest();
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		CMO();
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		DMS();
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		// ack_lab();
		
		driver.close();

	}

	public void Lab_storerequest() throws InterruptedException, IOException {

		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/ul/li[1]/a")).click();
		Thread.sleep(3000);

		column = driver.findElements(By.xpath("//*[@id='tblstockdetails']/thead/tr/th")).size();
		row = driver.findElements(By.xpath("//*[@id='tblstockdetails']/tbody/tr/td[1]")).size();

		System.out.println("* OLD STOCK LIST");

		//
		for (g = 1; g < row; g++) {

			System.out.println("\n===================================================\n");
			for (h = 1; h < column; h++) {
				stock_list = driver
						.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[" + g + "]/td[" + h + "]"))
						.getText();
				System.out.println(stock_list);
			}

			StockData sotockdata = new StockData();
			sotockdata.setProduct_Name(
					driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[" + g + "]/td[1]")).getText());
			sotockdata.setRece_qty(
					driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[" + g + "]/td[2]")).getText());
			sotockdata.setStock_qty(
					driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[" + g + "]/td[3]")).getText());

			stockDatas.add(sotockdata);

		}
		/*
		 * for(int y=1;y<stockDatas.size();y++) { String
		 * gh=stockDatas.get(y).getProduct_Name();
		 * System.out.println("Product name :"+gh); }
		 */

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a/span")).click();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a/span")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.linkText("Medicine Request")).click();
		Thread.sleep(2000);

		Select category = new Select(driver.findElement(By.id("optcategory")));
		category.selectByIndex(1);
		Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(5);
		driver.findElement(By.id("txttreat")).sendKeys("5");
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(2);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("8");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(2);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(11);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("6");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(6);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("3");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(5);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(6);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("5");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(5);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(7);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("8");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(5);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(9);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("6");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(5);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(11);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("8");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);

		Lab_Rno = driver.findElement(By.id("txtno")).getAttribute("value").trim();

		try {

			while (true) {
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
				scroll.executeScript("window.scrollBy(0,100)", "");

				try {
					driver.findElement(By.id("btnsave")).click();
					break;
				} catch (Exception e) {
					// e.printStackTrace();
					continue;
				}

			}

			Thread.sleep(3000);

			String labrequestalert = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText()
					.trim();
			System.out.println("* LAB REQUEST ALERT " + labrequestalert);

			String alertmsgis = "Already Exist this Request No !";
			if (labrequestalert.contains(alertmsgis)) {
				driver.navigate().refresh();
				Thread.sleep(2000);
				Lab_storerequest();
			} else {
				ss();
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				System.out.println("* LAB REQUEST SEND SUCCESSFULLY ");
				System.out.println("* LAB REQUEST NUMBER IS :" + Lab_Rno);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			while (true) {
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
				scroll.executeScript("window.scrollBy(0,100)", "");

				try {
					driver.findElement(By.id("btnsave")).click();
					break;
				} catch (Exception e1) {
					// e.printStackTrace();
					continue;
				}

			}
			Thread.sleep(3000);

			String labrequestalert = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText();
			System.out.println("* LAB REQUEST ALERT " + labrequestalert);

			String alertmsgis = "Already Exist this Request No !";
			if (labrequestalert.contains(alertmsgis)) {
				driver.navigate().refresh();
				Thread.sleep(2000);
				Lab_storerequest();
			}

			else {
				try {
					driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				}
				System.out.println(" ");
				System.out.println("* LAB REQUEST SEND SUCCESSFULLY ");
				System.out.println("* LAB REQUEST NUMBER IS :" + Lab_Rno);
			}
		}

		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/ul/li[3]/a")).click();// pending
																												// request

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
	public void screen(ITestResult labrequestresult) throws IOException {
		if (labrequestresult.getStatus() == ITestResult.FAILURE) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("E:\\Jenkins output\\Lab\\" + date1 + "" + labrequestresult.getName() + "-"
					+ Arrays.toString(labrequestresult.getParameters()) + ".png"));
			// FileUtils.copyFile(src, new File("E:\\Jenkins output\\Lab\\" +
			// System.currentTimeMillis() + ".png"));
		}
	}

	public void CMO() throws InterruptedException, IOException {

		System.out.println("* LOGIN TO CMO ");
		// CMO APPROVAL
		// ==================
		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("CMO")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtusername")).sendKeys(Employee.Creatientials.get(7).Uname.toString().trim());
			driver.findElement(By.id("txtpassword")).sendKeys(Employee.Creatientials.get(7).Pword.toString().trim());
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			try {
				driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
			} catch (Exception e) {
				e.printStackTrace();
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
			}
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(3000);
			// driver.findElement(By.linkText("CMO")).click();
			driver.findElement(By.id("txtusername")).sendKeys(Employee.Creatientials.get(7).Uname.toString().trim());
			driver.findElement(By.id("txtpassword")).sendKeys(Employee.Creatientials.get(7).Pword.toString().trim());
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a/span")).click();
		}
		try {
			Thread.sleep(2000);
			// driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();

			CMORNO = Lab_Rno.toString().split("\\/")[2].trim();
			// CMORNO = Rno.substring(14, 16);
			System.out.println(" ");
			System.out.println("* SEARCH THE LAB REQUEST");
			Thread.sleep(4000);
			Select Ldept = new Select(driver.findElement(By.id("optdept")));
			Thread.sleep(4000);
			Ldept.selectByIndex(4);
			Thread.sleep(2000);
			Select Status = new Select(driver.findElement(By.id("optsta")));
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
  				nn();
  				
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
			System.out.println("* CMO UPDATED THE LAB REQUEST SUCCESSFULLY");

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			driver.findElement(By.xpath("//*[text()='Department Wise Request']")).click();
			Thread.sleep(2000);
			CMORNO = Lab_Rno.toString().split("\\/")[2].trim();
			Thread.sleep(2000);
			System.out.println(CMORNO);
			System.out.println(" ");
			System.out.println("* SEARCH THE LAB REQUEST");
			Thread.sleep(4000);
			Select Ldept = new Select(driver.findElement(By.id("optdept")));
			Thread.sleep(4000);
			Ldept.selectByIndex(4);
			Thread.sleep(2000);

			Select Status = new Select(driver.findElement(By.id("optsta")));
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
  				nn();
  				
  			}
      

			Select Approval = new Select(driver.findElement(By.id("optstatus")));
			Thread.sleep(2000);
			Approval.selectByIndex(1);
			Thread.sleep(2000);
			driver.findElement(By.id("btnupdate")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
			System.out.println(" ");
			System.out.println("* CMO UPDATED THE LAB REQUEST SUCCESSFULLY");
		}
		// signout();
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

	public void DMS() throws InterruptedException, IOException {

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
			driver.findElement(By.id("txtusername")).sendKeys(Employee.Creatientials.get(5).Uname.toString().trim());
			driver.findElement(By.id("txtpassword")).sendKeys(Employee.Creatientials.get(5).Pword.toString().trim());
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.findElement(By.id("txtusername")).sendKeys(Employee.Creatientials.get(5).Uname.toString().trim());
			driver.findElement(By.id("txtpassword")).sendKeys(Employee.Creatientials.get(5).Pword.toString().trim());
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		Thread.sleep(2000);
		try {

			WebElement LabRequest = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[8]/a")); // Lab
																										// Request
			clickactions(LabRequest);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Thread.sleep(2000);
			WebElement LabRequest = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[8]/a")); // Lab
																										// Request
			clickactions(LabRequest);
		}
		Thread.sleep(2000);
		try {
			WebElement Requested_ItemLab = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[8]/ul/li[1]/a")); // Requested
																												// Item
																												// Lab
			clickactions(Requested_ItemLab);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Thread.sleep(2000);
			WebElement Requested_ItemLab = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[8]/ul/li[1]/a")); // Requested
																												// Item
																												// Lab
			clickactions(Requested_ItemLab);
		}
		Thread.sleep(2000);
		driver.findElement(By.id(CMORNO)).click();
		Thread.sleep(3000);
		System.out.println(" ");
		System.out.println("* LAB REQUESTED ITEMS ARE ISSUE IN PROCESS");
		WebElement med = driver.findElement(By.id("fldproduct"));
		Select product = new Select(med);
		List product_list = product.getOptions();

		for (a = 1; a < product_list.size(); a++) {
			Thread.sleep(2000);
			product.selectByIndex(a);
			// String test_name=list.get(i).getText().toString();
			Product_name = product.getOptions().get(a).getText().toString();
			Thread.sleep(2000);
			Boolean isPresent = driver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/button")).size() > 0;
			if (isPresent) {
				System.out.println(Product_name + "* Medicine stock qty is not avilable or expired");
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				continue;
			}
			WebElement batch = (driver.findElement(By.id("fldbatch")));
			Select batchnumber = new Select(batch);
			List batchnumber_list = batchnumber.getOptions();
			// Thread.sleep(2000);

			for (int q = 1; q < batchnumber_list.size(); q++) {
				batchnumber.selectByIndex(q);

				Thread.sleep(2000);

				Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
				Required_qty = driver.findElement(By.id("txttotal")).getAttribute("value");

				System.out.println(Product_name + "=== Stockqty :" + Stock_qty + " Required Qty :" + Required_qty);

				if (Integer.parseInt(Stock_qty) >= Integer.parseInt(Required_qty)) {
					Thread.sleep(2000);
					driver.findElement(By.id("txtqty")).sendKeys(String.valueOf(Required_qty));
					driver.findElement(By.id("btnadd")).click();

					break;
				} else {
					System.out.println(Product_name + "=== Stockqty is less than required qty");
					System.out.println(Product_name + "=== Stock qty available is : " + Stock_qty + " Required Qty Is:"
							+ Required_qty);
				}
			}

			Thread.sleep(2000);
		}

		try {
			Thread.sleep(3000);
			JavascriptExecutor scrollsub = (JavascriptExecutor) driver;
			scrollsub.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(2000);
			PRNO = driver.findElement(By.id("lblpono")).getAttribute("value");
			System.out.println(PRNO);

			driver.findElement(By.id("btnSubmit")).click();
			Thread.sleep(3000);

			String Labissued = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
			System.out.println("Lab Issued Alert " + Labissued);

			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			System.out.println(" ");
			System.out.println("* LAB REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JavascriptExecutor scrollsub = (JavascriptExecutor) driver;
			scrollsub.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			Thread.sleep(3000);

			String Labissued = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
			System.out.println("Lab Issued Alert " + Labissued);

			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			System.out.println(" ");
			System.out.println("* LAB REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
		}

	}
	/*
	 * public void ack_lab() throws InterruptedException { Thread.sleep(4000);
	 * driver.findElement(By.linkText("Investigation")).click();
	 * driver.findElement(By.id("txtusername")).sendKeys("fwbalaji");
	 * driver.findElement(By.id("txtpassword")).sendKeys("123"); WebElement
	 * submit=driver.findElement(By.id("btnSubmit")); Actions action=new
	 * Actions(driver); action.moveToElement(submit).click().perform();
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * 
	 * 
	 * Thread.sleep(2000);
	 * 
	 * try { driver.findElement(By.xpath(
	 * "/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click(); }
	 * catch (Exception e) { e.printStackTrace(); Thread.sleep(3000);
	 * driver.findElement(By.xpath(
	 * "/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click(); }
	 * Thread.sleep(2000); driver.findElement(By.xpath(
	 * "/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/ul/li[1]/a")).click(
	 * ); Thread.sleep(3000);
	 * 
	 * System.out.println("* NEW STOCK LIST"); System.out.println(" "); for(
	 * g=1;g<row;g++) {
	 * 
	 * System.out.println(
	 * "\n==============================================================================\n"
	 * ); for( h=1;h<column;h++) { stock_list=driver.findElement(By.xpath(
	 * "//*[@id='tblstockdetails']/tbody/tr["+g+"]/td["+h+"]")).getText();
	 * System.out.println(stock_list); }
	 * 
	 * } System.out.println(" ");
	 * 
	 * }
	 */

	public void clickactions(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void ss() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("E:\\Jenkins output\\Labrequest\\" + date1 + "" + System.currentTimeMillis() + ".png"));

	}

	class StockData {
		public String product_Name, rece_qty, stock_qty;

		public String getProduct_Name() {
			return product_Name;
		}

		public void setProduct_Name(String product_Name) {
			this.product_Name = product_Name;
		}

		public String getRece_qty() {
			return rece_qty;
		}

		public void setRece_qty(String rece_qty) {
			this.rece_qty = rece_qty;
		}

		public String getStock_qty() {
			return stock_qty;
		}

		public void setStock_qty(String stock_qty) {
			this.stock_qty = stock_qty;
		}

	}

}

class Pharmacyrequest {
	
	WebDriver driver;
	HregAragEreg hos = new HregAragEreg();
	int i, j, k, p, q, receveditem, a;
	String Pharmacy_Rno, Ritem, xp, CMORNO, Stock_qty, Required_qty, PRNO, date1;
	Employee pharmacycredentials = new Employee();
	int Seconds=0;

	@Test
	public void Pharmacy() throws InterruptedException, IOException {

		DateFormat date = new SimpleDateFormat("dd/mm/yy");
		Date da = new Date();
		date1 = date.format(da);

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\add jar files\\chromedriver.exe");
		driver = new ChromeDriver();

		// driver = new FirefoxDriver();
		// driver.get("http://182.18.161.229/Multihospital_new");
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Pharmacy")).click();
		driver.findElement(By.id("txtusername")).sendKeys(pharmacycredentials.Creatientials.get(4).Uname.toString().trim());
		driver.findElement(By.id("txtpassword")).sendKeys(pharmacycredentials.Creatientials.get(4).Pword.toString().trim());
		Thread.sleep(5000);
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println(" ");
		System.out.println("PHARMACY REQUEST");
		System.out.println("================= ");
		System.out.println(" ");
		Pharmacy_storerequest();
		Thread.sleep(2000);
		CMO();
		signout();
		Thread.sleep(2000);
		DMS();
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		/*
		 * ack(); Thread.sleep(2000);
		 */
		driver.close();

	}

	public void Pharmacy_storerequest() throws InterruptedException, IOException {

		Thread.sleep(3000);
		try {
			WebElement inventory = driver
					.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a/span"));
			clickactions(inventory);
		} catch (Exception e2) {
			e2.printStackTrace();
			Thread.sleep(3000);
			WebElement inventory = driver
					.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a/span"));
			clickactions(inventory);
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Medicine Request")).click();
		Thread.sleep(2000);

		Select category = new Select(driver.findElement(By.id("optcategory")));
		category.selectByIndex(2);
		Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(12);
		driver.findElement(By.id("txttreat")).sendKeys("10");
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(2);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(15);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("5");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(2);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(56);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("7");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(2);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(64);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("9");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(2);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(18);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("8");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);

		Thread.sleep(5000);
		category.selectByIndex(3);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(3);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("5");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);

		Thread.sleep(5000);
		category.selectByIndex(3);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(4);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("6");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);

		Thread.sleep(5000);
		category.selectByIndex(10);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(9);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("8");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);

		Pharmacy_Rno = driver.findElement(By.id("txtno")).getAttribute("value").trim();

		try {

			while (true) {
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
				scroll.executeScript("window.scrollBy(0,100)", "");

				try {
					driver.findElement(By.id("btnsave")).click();
					break;
				} catch (Exception e) {
					// e.printStackTrace();
					continue;
				}
			}

			Thread.sleep(3000);

			String Pharmacyreqalert = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText()
					.trim();
			System.out.println("* PHARMACY REQUEST ALERT :" + Pharmacyreqalert);

			String alertmsgis = "Already Exist this Request No !";
			if (Pharmacyreqalert.contains(alertmsgis)) {
				driver.navigate().refresh();
				Thread.sleep(2000);
				Pharmacy_storerequest();
			} else {
				ss();
				try {
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				} catch (Exception e) {
					e.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				}
				System.out.println(" ");
				System.out.println("* PHARMACY REQUEST SEND SUCCESSFULLY ");
				System.out.println("* PHARMACY REQUEST NUMBER :" + Pharmacy_Rno);
			}
		} catch (Exception e) {

			Thread.sleep(3000);

			String Pharmacyreqalert = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText()
					.trim();
			System.out.println("* PHARMACY REQUEST ALERT :" + Pharmacyreqalert);

			String alertmsgis = "Already Exist this Request No !";
			if (Pharmacyreqalert.contains(alertmsgis)) {
				driver.navigate().refresh();
				Thread.sleep(2000);
				Pharmacy_storerequest();
			} else {
				ss();
				try {
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				} catch (Exception e1) {
					e1.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				}
				System.out.println(" ");
				System.out.println("* PHARMACY REQUEST SEND SUCCESSFULLY ");
				System.out.println("* PHARMACY REQUEST NUMBER :" + Pharmacy_Rno);
			}
		}

		driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/ul/li[2]/a")).click();// pending
																													// request
		Thread.sleep(3000);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='aSign']")).click();
		Thread.sleep(2000);

		try {
			Thread.sleep(2000);

			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			// driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			// driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(4000);
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
	public void screen(ITestResult PharmacyReestresult) throws IOException {

		if (PharmacyReestresult.getStatus() == ITestResult.FAILURE) {

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("E:\\Jenkins output\\Pharmacy\\" + date1 + ""
					+ PharmacyReestresult.getName() + Arrays.toString(PharmacyReestresult.getParameters()) + ".png"));
			// FileUtils.copyFile(src, new File("E:\\Jenkins output\\Pharmacy\\"
			// + System.currentTimeMillis() + ".png"));
		}
	}

	public void CMO() throws InterruptedException, IOException {

		System.out.println("* LOGIN TO CMO ");
		// CMO APPROVAL
		// ==================
		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("CMO")).click();
			driver.findElement(By.id("txtusername"))
					.sendKeys(pharmacycredentials.Creatientials.get(7).Uname.toString().trim());
			driver.findElement(By.id("txtpassword"))
					.sendKeys(pharmacycredentials.Creatientials.get(7).Pword.toString().trim());
			Thread.sleep(3500);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.findElement(By.linkText("CMO")).click();
			driver.findElement(By.id("txtusername"))
					.sendKeys(pharmacycredentials.Creatientials.get(7).Uname.toString().trim());
			driver.findElement(By.id("txtpassword"))
					.sendKeys(pharmacycredentials.Creatientials.get(7).Pword.toString().trim());
			Thread.sleep(3500);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a/span")).click();
		}
		try {

			// driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
			Thread.sleep(4000);
			CMORNO = Pharmacy_Rno.toString().split("\\/")[2].trim();
			// CMORNO = Rno.substring(14, 16);

			System.out.println(" ");
			System.out.println("* SEARCH THE PHARMACY REQUEST");
			Thread.sleep(4000);
			Select Pdept = new Select(driver.findElement(By.id("optdept")));
			Thread.sleep(4000);
			Pdept.selectByIndex(2);
			Thread.sleep(2000);
			Select Status = new Select(driver.findElement(By.id("optsta")));
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
  				Pharmacy();
  				
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
			System.out.println("* CMO UPDATED THE PHARMACY REQUEST SUCCESSFULLY");

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			driver.findElement(By.xpath("//*[text()='Department Wise Request']")).click();
			Thread.sleep(2000);
			CMORNO = Pharmacy_Rno.toString().split("\\/")[2].trim();
			Thread.sleep(2000);
			System.out.println(CMORNO);
			System.out.println(" ");
			System.out.println("* SEARCH THE PHARMACY REQUEST");

			Thread.sleep(4000);
			Select Pdept = new Select(driver.findElement(By.id("optdept")));
			Thread.sleep(4000);
			Pdept.selectByIndex(2);
			Thread.sleep(2000);
			Select Status = new Select(driver.findElement(By.id("optsta")));
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
  				Pharmacy();
  				
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
			System.out.println("* CMO UPDATED THE PHARMACY REQUEST SUCCESSFULLY");
		}
		// signout();
	}

	public void signout() throws InterruptedException {
		try {
			Thread.sleep(2000);

			// driver.findElement(By.xpath("/html/body/header/div/nav/div/ul/li[2]/a")).click();
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

	public void DMS() throws InterruptedException, IOException {

		System.out.println(" ");
		System.out.println("* LOGIN TO DIVISIONAL STORE");

		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("Divisional Store")).click();
			driver.findElement(By.id("txtusername"))
					.sendKeys(pharmacycredentials.Creatientials.get(5).Uname.toString().trim());
			driver.findElement(By.id("txtpassword"))
					.sendKeys(pharmacycredentials.Creatientials.get(5).Pword.toString().trim());
			Thread.sleep(3500);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.findElement(By.linkText(" Divisional Store ")).click();
			driver.findElement(By.id("txtusername")).sendKeys("fwanwar");
			driver.findElement(By.id("txtpassword")).sendKeys("123");
			Thread.sleep(3500);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		Thread.sleep(2000);
		try {
			WebElement PharmacyRequest = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[7]/a")); // Pharmacy
																										// Request
			clickactions(PharmacyRequest);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			Thread.sleep(2000);
			e1.printStackTrace();
			WebElement PharmacyRequest = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[7]/a")); // Pharmacy
																										// Request
			clickactions(PharmacyRequest);

		}
		Thread.sleep(2000);
		try {
			WebElement RequesteditemPharmacy = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[7]/ul/li[1]/a")); // Requested
																												// Item
																												// Pharmacy
			clickactions(RequesteditemPharmacy);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Thread.sleep(2000);
			WebElement RequesteditemPharmacy = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[7]/ul/li[1]/a")); // Requested
																												// Item
																												// Pharmacy
			clickactions(RequesteditemPharmacy);
		}
		Thread.sleep(2000);
		driver.findElement(By.id(CMORNO)).click();
		Thread.sleep(3000);
		System.out.println(" ");
		System.out.println("* PHARMACY REQUESTED ITEMS ARE ISSUE IN PROCESS");
		System.out.println(" ");

		WebElement med = driver.findElement(By.id("fldproduct"));
		Select product1 = new Select(med);
		List product_list = product1.getOptions();

		for (a = 1; a < product_list.size(); a++) {
			Thread.sleep(2000);
			product1.selectByIndex(a);
			Thread.sleep(2000);
			String Product_name = product1.getOptions().get(a).getText().toString();
			Thread.sleep(2000);
			Boolean pharmacyispresent = driver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/button"))
					.size() > 0;
			if (pharmacyispresent) {
				System.out.println(Product_name + "* Medicine stock qty is not avilable or expired");
				Thread.sleep(3000);

				// System.out.println(+a+" Medicine stock qty is not avilable or
				// expired");
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				continue;
			}

			WebElement batch = (driver.findElement(By.id("fldbatch")));
			Select batchnumber = new Select(batch);
			List batchnumber_list = batchnumber.getOptions();

			// Thread.sleep(2000);

			for (int q = 1; q < batchnumber_list.size(); q++) {
				batchnumber.selectByIndex(q);

				Thread.sleep(3000);

				Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
				Required_qty = driver.findElement(By.id("txttotal")).getAttribute("value");

				System.out.println(Product_name + "=== Stockqty :" + Stock_qty + " Required Qty :" + Required_qty);
				// System.out.println("Stockqty :" +Stock_qty+ " Required Qty
				// :"+Required_qty);

				if (Integer.parseInt(Stock_qty) >= Integer.parseInt(Required_qty)) {
					Thread.sleep(2000);
					driver.findElement(By.id("txtqty")).sendKeys(String.valueOf(Required_qty));
					driver.findElement(By.id("btnadd")).click();

					break;
				} else {
					/*
					 * System.out.println("Stockqty is less than required qty");
					 * System.out.println("Stock qty available is : "
					 * +Stock_qty+ " Required Qty Is:"+Required_qty);
					 */
					System.out.println(Product_name + "=== Stockqty is less than required qty");
					System.out.println(Product_name + "=== Stock qty available is : " + Stock_qty + " Required Qty Is:"
							+ Required_qty);
				}
			}

			Thread.sleep(4000);
		}

		try {
			Thread.sleep(3000);

			JavascriptExecutor scrollsub = (JavascriptExecutor) driver;
			scrollsub.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(2000);

			PRNO = driver.findElement(By.id("lblpono")).getAttribute("value");
			System.out.println(PRNO);
			driver.findElement(By.id("btnSubmit")).click();
			Thread.sleep(3000);

			String Pharmacyissuedalert = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
			System.out.println("* PHARMACY ISSUED ALERT :" + Pharmacyissuedalert);

			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			System.out.println(" ");
			System.out.println("* PHARMACY REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
			System.out.println(" ");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JavascriptExecutor scrollsub = (JavascriptExecutor) driver;
			scrollsub.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("btnSubmit")).click();
			Thread.sleep(3000);

			String Pharmacyissuedalert = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
			System.out.println("* PHARMACY ISSUED ALERT :" + Pharmacyissuedalert);

			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			System.out.println(" ");
			System.out.println("* PHARMACY REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
			System.out.println(" ");
		}

	}

	public void ack() throws InterruptedException {
		
		driver.findElement(By.linkText("Pharmacy")).click();
		driver.findElement(By.id("txtusername")).sendKeys(pharmacycredentials.Creatientials.get(4).Uname.toString().trim());
		driver.findElement(By.id("txtpassword")).sendKeys(pharmacycredentials.Creatientials.get(4).Pword.toString().trim());
		Thread.sleep(5000);
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a/span")).click();
			Thread.sleep(2000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();

		}
		driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		// String Issuedno=PRNO.toString().split("\\/")[2].trim();
		driver.findElement(By.id(Pharmacy_Rno)).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtackremarks")).sendKeys("* Medicine Received-PHARMACY");
		Thread.sleep(2000);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='aSign']")).click();
		Thread.sleep(2000);

		try {
			Thread.sleep(2000);

			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			// driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			// driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(4000);
		}

	}

	public void clickactions(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void ss() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("E:\\Jenkins output\\Pharmacy1\\" + date1 + "" + System.currentTimeMillis() + ".png"));

	}

}

class Inpatientrequest {

	WebDriver driver;

	int i, j, k, p, q, receveditem, a;
	String Ritem, xp, CMORNO, Stock_qty, Required_qty, PRNO, Inpatient_Rno, date1;
    int Seconds=0;
	
	Employee inpatientcredentials = new Employee();

	@Test
	public void Inpatient() throws InterruptedException, IOException {

		DateFormat date = new SimpleDateFormat("dd/MM/yy");
		Date da = new Date();
		date1 = date.format(da);

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\add jar files\\chromedriver.exe");
		driver = new ChromeDriver();

		// driver = new FirefoxDriver();
		// driver.get("http://182.18.161.229/Multihospital_new");
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.linkText("In Patient")).click();
		driver.findElement(By.id("txtusername")).sendKeys(inpatientcredentials.Creatientials.get(6).Uname.toString().trim());
		driver.findElement(By.id("txtpassword")).sendKeys(inpatientcredentials.Creatientials.get(6).Pword.toString().trim());

		Thread.sleep(4000);

		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
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
			e.printStackTrace();
			DMS();
		}
		Thread.sleep(2000);
		signout();
		Thread.sleep(2000);
		/*
		 * Inpatient_ack(); Thread.sleep(2000);
		 */
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
			WebElement ex = driver.findElement(By.xpath("//*[@id='loadfull']/aside[1]/section/ul/li[14]/a"));
			clickactions(ex);
		}
		Thread.sleep(2000);
		driver.findElement(By.linkText("Medicine Request")).click();
		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		rescroll.executeScript("window.scrollBy(0,200)", "");
		Select ward_category = new Select(driver.findElement(By.id("optwardcate")));
		Thread.sleep(500);
		ward_category.selectByIndex(1);
		Thread.sleep(2000);

		Select category = new Select(driver.findElement(By.id("optcategory")));
		category.selectByIndex(1);
		// String name=category.getOptions().get(1).toString();

		Thread.sleep(2000);
		Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(2);
		// String cname=choosemedicine.getOptions().get(1).toString();
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("5");
		Thread.sleep(2000);
		// String mqty=driver.findElement(By.id("txttreat")).getText();
		// System.out.println(name +cname +mqty);

		WebElement add = driver.findElement(By.xpath("//*[@id='btnadd']"));
		clickactions(add);

		Thread.sleep(5000);
		category.selectByIndex(1);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(11);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("8");
		Thread.sleep(2000);
		WebElement add1 = driver.findElement(By.id("btnadd"));
		clickactions(add1);
		// driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);
		category.selectByIndex(3);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("6");
		Thread.sleep(2000);
		// driver.findElement(By.id("btnadd")).click();
		clickactions(add);

		Thread.sleep(5000);
		category.selectByIndex(3);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(10);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("4");
		Thread.sleep(2000);
		// driver.findElement(By.id("btnadd")).click();
		clickactions(add);
		Thread.sleep(5000);

		Thread.sleep(5000);
		category.selectByIndex(1);
		Thread.sleep(2000);
		choosemedicine.selectByIndex(7);
		Thread.sleep(2000);
		driver.findElement(By.id("txttreat")).sendKeys("8");
		Thread.sleep(2000);
		// driver.findElement(By.id("btnadd")).click();
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

		Inpatient_Rno = driver.findElement(By.id("txtno")).getAttribute("value").trim();
		try {
			while (true) {
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
				scroll.executeScript("window.scrollBy(0,100)", "");

				try {
					driver.findElement(By.id("btnsave")).click();
					break;
				} catch (Exception e) {
					// e.printStackTrace();

					continue;
				}
			}

			Thread.sleep(3000);

			String Requestsendalert = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText()
					.trim();
			System.out.println("* Alert Text " + Requestsendalert);

			String alertmsgis = "Already Exist this Request No !";

			if (Requestsendalert.contains(alertmsgis)) {
				driver.navigate().refresh();
				Thread.sleep(2000);
				Inpatient_storerequest();
			} else {
				try {
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				} catch (Exception e) {
					e.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
				System.out.println("* INPATIENT REQUEST SEND SUCCESSFULLY ");
				System.out.println("* INPATIENT REQUEST NUMBER IS " + Inpatient_Rno);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			while (true) {
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
				scroll.executeScript("window.scrollBy(0,100)", "");

				try {
					driver.findElement(By.id("btnsave")).click();
					break;
				} catch (Exception e1) {
					// e.printStackTrace();
					continue;
				}

			}
			Thread.sleep(3000);

			String Requestsendalert = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText();
			System.out.println("* " + Requestsendalert);

			String alertmsgis = "Already Exist this Request No !";
			if (Requestsendalert.contains(alertmsgis)) {
				driver.navigate().refresh();
				Thread.sleep(2000);
				Inpatient_storerequest();
			}

			else {
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				Thread.sleep(2000);
				System.out.println("* INPATIENT REQUEST SEND SUCCESSFULLY ");
				System.out.println("* INPATIENT REQUEST NUMBER IS " + Inpatient_Rno);
			}

		}
		JavascriptExecutor pendingscroll = (JavascriptExecutor) driver;
		pendingscroll.executeScript("window.scrollBy(0,400)", "");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[14]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[14]/ul/li[3]/a")).click();// pending
																												// request
		Thread.sleep(3000);

		Thread.sleep(3000);

		try {
			Thread.sleep(2000);

			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			// driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println("* INPATIENT SIGNOUT SUCCESSFULLY");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			// driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
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
		if (Inpatientrequest.getStatus() == (ITestResult.FAILURE)) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("E:\\Jenkins output\\Inpatient\\" + date1 + "" + Inpatientrequest.getName()
					+ Arrays.toString(Inpatientrequest.getParameters()) + ".png"));
			// FileUtils.copyFile(src, new File("E:\\Jenkins
			// output\\Inpatient\\" + System.currentTimeMillis() + ".png"));
		}
	}

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
			driver.findElement(By.id("txtusername"))
					.sendKeys(inpatientcredentials.Creatientials.get(7).Uname.toString().trim());
			driver.findElement(By.id("txtpassword"))
					.sendKeys(inpatientcredentials.Creatientials.get(7).Pword.toString().trim());
			Thread.sleep(4000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(3000);
			// driver.findElement(By.linkText("CMO")).click();
			driver.findElement(By.id("txtusername"))
					.sendKeys(inpatientcredentials.Creatientials.get(7).Uname.toString().trim());
			driver.findElement(By.id("txtpassword"))
					.sendKeys(inpatientcredentials.Creatientials.get(7).Pword.toString().trim());
			Thread.sleep(4000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a/span")).click();
		}
		try {
			Thread.sleep(2000);
			// driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
			Thread.sleep(2000);
			CMORNO = Inpatient_Rno.toString().split("\\/")[2].trim();
			Thread.sleep(4000);

			System.out.println(" ");
			System.out.println("* SEARCH THE INPATIENT REQUEST");
			Select Idept = new Select(driver.findElement(By.id("optdept")));
			Thread.sleep(4000);
			Idept.selectByIndex(1);
			Thread.sleep(2000);
			Select Status = new Select(driver.findElement(By.id("optsta")));
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
  				Inpatient();
  				
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

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			driver.findElement(By.xpath("//*[text()='Department Wise Request']")).click();
			Thread.sleep(200);
			CMORNO = Inpatient_Rno.toString().split("\\/")[2].trim();
			Thread.sleep(200);
			System.out.println(CMORNO);
			Thread.sleep(4000);

			System.out.println(" ");
			System.out.println("* SEARCH THE INPATIENT REQUEST");

			Select Idept = new Select(driver.findElement(By.id("optdept")));
			Thread.sleep(400);
			Idept.selectByIndex(1);
			Thread.sleep(500);
			Select Status = new Select(driver.findElement(By.id("optsta")));
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
  				Inpatient();
  				
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

		// signout();
	}

	public void signout() throws InterruptedException {
		try {

			// driver.findElement(By.xpath("/html/body/header/div/nav/div/ul/li[2]/a")).click();
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
			driver.findElement(By.id("txtusername"))
					.sendKeys(inpatientcredentials.Creatientials.get(5).Uname.toString().trim());
			driver.findElement(By.id("txtpassword"))
					.sendKeys(inpatientcredentials.Creatientials.get(5).Pword.toString().trim());
			Thread.sleep(4000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.findElement(By.linkText("Divisional Store")).click();
			driver.findElement(By.id("txtusername"))
					.sendKeys(inpatientcredentials.Creatientials.get(5).Uname.toString().trim());
			driver.findElement(By.id("txtpassword"))
					.sendKeys(inpatientcredentials.Creatientials.get(5).Pword.toString().trim());
			Thread.sleep(4000);
			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		Thread.sleep(3000);
		try {

			WebElement Inpatientreq = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a"));// Inpatient
																										// Request
			clickactions(Inpatientreq);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			WebElement Inpatientreq = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a"));// Inpatient
																										// Request
			clickactions(Inpatientreq);
		}
		Thread.sleep(2000);
		try {
			WebElement Requesteditem = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[1]/a")); // Requested
																												// Item
																												// Inpatient
			clickactions(Requesteditem);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Thread.sleep(2000);
			WebElement Requesteditem = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[1]/a")); // Requested
																												// Item
																												// Inpatient
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

		for (a = 1; a < product_list.size(); a++) {

			product.selectByIndex(a);
			String Product_name = product.getOptions().get(a).getText().toString();
			Thread.sleep(2000);
			Boolean pharmacyispresent = driver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/button"))
					.size() > 0;
			if (pharmacyispresent) {
				System.out.println(Product_name + "* Medicine stock qty is not avilable or expired");
				Thread.sleep(300);
				driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				continue;
			}

			WebElement batch = (driver.findElement(By.id("fldbatch")));
			Select batchnumber = new Select(batch);
			List batchnumber_list = batchnumber.getOptions();

			// Thread.sleep(2000);

			for (int q = 1; q < batchnumber_list.size(); q++) {
				batchnumber.selectByIndex(q);

				Thread.sleep(3000);

				Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
				Required_qty = driver.findElement(By.id("txttotal")).getAttribute("value");

				System.out.println(Product_name + "=== Stockqty :" + Stock_qty + " Required Qty :" + Required_qty);
				// System.out.println("Stockqty :" +Stock_qty+ " Required Qty
				// :"+Required_qty);

				if (Integer.parseInt(Stock_qty) > Integer.parseInt(Required_qty)) {
					driver.findElement(By.id("txtqty")).sendKeys(String.valueOf(Required_qty));
					driver.findElement(By.id("btnadd")).click();
					break;
				} else {
					System.out.println(Product_name + "=== Stockqty is less than required qty");
					System.out.println(Product_name + "=== Stock qty available is : " + Stock_qty + " Required Qty Is:"
							+ Required_qty);
					// System.out.println("* Stockqty is less than required
					// qty");
					// System.out.println("* Stock qty available is : "
					// +Stock_qty+ " Required Qty Is:"+Required_qty);
				}

			}
		}

		try {

			Thread.sleep(2000);
			PRNO = driver.findElement(By.id("lblpono")).getAttribute("value");
			JavascriptExecutor scrollsub = (JavascriptExecutor) driver;
			scrollsub.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(2000);

			System.out.println(PRNO);
			driver.findElement(By.id("btnSubmit")).click();
			Thread.sleep(2000);

			String inpatientissued = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]")).getText();
			System.out.println("* INPATIENT ALERT TEXT :" + inpatientissued);

			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			System.out.println(" ");
			System.out.println("* INPATIENT REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PRNO = driver.findElement(By.id("lblpono")).getAttribute("value");
			JavascriptExecutor scrollsub = (JavascriptExecutor) driver;
			scrollsub.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);

			driver.findElement(By.id("btnSubmit")).click();
			Thread.sleep(3000);

			String inpatientissued = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]")).getText();
			System.out.println("* INPATIENT ALERT TEXT :" + inpatientissued);

			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			System.out.println(" ");
			System.out.println("* INPATIENT REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
		}

	}

	public void Inpatient_ack() throws InterruptedException {
		Thread.sleep(4000);
		try {
			driver.findElement(By.linkText("In Patient")).click();
			driver.findElement(By.id("txtusername")).sendKeys(inpatientcredentials.Creatientials.get(6).Uname.toString().trim());
			driver.findElement(By.id("txtpassword")).sendKeys(inpatientcredentials.Creatientials.get(6).Pword.toString().trim());

			Thread.sleep(4000);

			WebElement submit = driver.findElement(By.id("btnSubmit"));
			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			JavascriptExecutor rece = (JavascriptExecutor) driver;
			rece.executeScript("window.scrollBy(0,300)", "");
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
			// e1.printStackTrace();
			driver.navigate().refresh();
			JavascriptExecutor rece = (JavascriptExecutor) driver;
			rece.executeScript("window.scrollBy(0,300)", "");
			driver.findElement(By.xpath("//*[@id='loadfull']/aside[1]/section/ul/li[14]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[14]/ul/li[4]/a")).click();
			Thread.sleep(2000);
			// String Issuedno=PRNO.toString().split("\\/")[2].trim();
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
			// driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			// driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(4000);
		}

	}

	public void clickactions(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void ss() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("E:\\Jenkins output\\Inpatient\\" + date1 + "" + System.currentTimeMillis() + ".png"));

	}
}
