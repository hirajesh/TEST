package veriication;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
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

public class Pharmacy_Tablet_Qty_Verification {

	WebDriver driver;
	int i, j, k, p, q, receveditem, a;
	String Pharmacy_Rno, Ritem, xp, CMORNO, Stock_qty, Required_qty, PRNO, date1;
	int Seconds = 0;

	String PharmacyUserName = "brsshafi";
	String PharmacyPassword = "shafi123";

	String CMOUserName = "brsjana";
	String CMOPassword = "jana123";

	String StoreUserName = "brsnavas";
	String StorePassword = "navas123";

	String URL = "http://122.165.236.133/MultiHospital/Splashscreen.aspx";

	String medicines;

	List<Medicinecount> store = new ArrayList<>();

	InputStreamReader inputs;
	BufferedReader readdta;
	
	@Test
	public void openbrowser() throws InterruptedException, IOException {

		DateFormat date = new SimpleDateFormat("dd/mm/yy");
		Date da = new Date();
		date1 = date.format(da);
		
		
		// Run Time Password Code
		//========================
		
		/*inputs=new InputStreamReader(System.in);
		readdta=new BufferedReader(inputs);
		System.out.print("Enter your Password: ");
		String Pharmacypassword=readdta.readLine();*/
		

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();

		// driver = new FirefoxDriver();
		// driver.get("http://182.18.161.229/Multihospital_new");
		// driver.get("http://192.168.137.1/Multihospital_New/");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Pharmacy")).click();
		driver.findElement(By.id("txtusername")).sendKeys(PharmacyUserName);
		driver.findElement(By.id("txtpassword")).sendKeys(PharmacyPassword);
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
		
		 ack(); Thread.sleep(2000);
		 
		driver.close();

	}

	public void Pharmacy_storerequest() throws InterruptedException, IOException 
	{

		Medicinecount medicine=new Medicinecount();
		
            Thread.sleep(3000);
		   try {
			   WebElement inventory=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a/span"));
			   clickactions(inventory);
		       }
		   catch (Exception e2) 
		   {
			 e2.printStackTrace();
			 Thread.sleep(3000);
			 WebElement inventory=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a/span"));
			 clickactions(inventory);
		}
	    	Thread.sleep(5000);
	    	driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Medicine Request")).click();
			Thread.sleep(2000);
			
			medicine=new Medicinecount();
			
			Select category = new Select(driver.findElement(By.id("optcategory")));
			category.selectByIndex(2);
			Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
			choosemedicine.selectByIndex(12);
		
		    medicines=choosemedicine.getOptions().get(12).getText().toString().trim();
            medicine.setMedicine_Name(medicines);
			
			driver.findElement(By.id("txttreat")).sendKeys("10");
            medicine.setRequested_Qty("10");
            Thread.sleep(2000);
            driver.findElement(By.id("btnadd")).click();
            store.add(medicine);	
			
            
            medicine=new Medicinecount();
			Thread.sleep(5000);
			category.selectByIndex(2);
			Thread.sleep(2000);
			choosemedicine.selectByIndex(15);
			Thread.sleep(2000);
			

			medicines=choosemedicine.getOptions().get(15).getText().toString().trim();
            medicine.setMedicine_Name(medicines);
			
			driver.findElement(By.id("txttreat")).sendKeys("5");
			medicine.setRequested_Qty("5");
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			store.add(medicine);	
			
			medicine=new Medicinecount();
			Thread.sleep(5000);
			category.selectByIndex(2);
			Thread.sleep(2000);
			choosemedicine.selectByIndex(56);
			Thread.sleep(2000);
			
			  medicines=choosemedicine.getOptions().get(56).getText().toString().trim();
	            medicine.setMedicine_Name(medicines);
				
				driver.findElement(By.id("txttreat")).sendKeys("5");
				medicine.setRequested_Qty("5");
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				store.add(medicine);	
				
			medicine=new Medicinecount();	
			Thread.sleep(5000);
			category.selectByIndex(2);
			Thread.sleep(2000);
			choosemedicine.selectByIndex(64);
			
			  medicines=choosemedicine.getOptions().get(64).getText().toString().trim();
	         medicine.setMedicine_Name(medicines);
				
				driver.findElement(By.id("txttreat")).sendKeys("5");
				medicine.setRequested_Qty("5");
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				store.add(medicine);	
		/*	Thread.sleep(5000);
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
			Thread.sleep(5000);*/
			
		
				
			 
			Pharmacy_Rno = driver.findElement(By.id("txtno")).getAttribute("value").trim();
	    	

			try {
				
				while(true)
				{
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
				scroll.executeScript("window.scrollBy(0,100)", "");
				
				try {
					driver.findElement(By.id("btnsave")).click();
					break;
				} catch (Exception e) {
					//e.printStackTrace();
					continue;
				}
				}
				
			
				Thread.sleep(3000);
				 
				String Pharmacyreqalert=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText().trim();
				System.out.println("* PHARMACY REQUEST ALERT :"+Pharmacyreqalert);
				
				String alertmsgis="Already Exist this Request No !";
				if(Pharmacyreqalert.contains(alertmsgis))
				{
					driver.navigate().refresh();
					Thread.sleep(2000);
					Pharmacy_storerequest();
				}
				else
				{
				ss();
				try 
				{
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				}
				System.out.println(" ");
				System.out.println("* PHARMACY REQUEST SEND SUCCESSFULLY ");
				System.out.println("* PHARMACY REQUEST NUMBER :"+Pharmacy_Rno);
				}
			}
			catch (Exception e) 
			{

				Thread.sleep(3000);
				
				String Pharmacyreqalert=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText().trim();
				System.out.println("* PHARMACY REQUEST ALERT :"+Pharmacyreqalert);
				
				String alertmsgis="Already Exist this Request No !";
				if(Pharmacyreqalert.contains(alertmsgis))
				{
					driver.navigate().refresh();
					Thread.sleep(2000);
					Pharmacy_storerequest();
				}
				else
				{
				ss();
				try 
				{
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				}
				System.out.println(" ");
				System.out.println("* PHARMACY REQUEST SEND SUCCESSFULLY ");
				System.out.println("* PHARMACY REQUEST NUMBER :"+Pharmacy_Rno);
				}
			}
		
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[1]/a")).click();
			Thread.sleep(2000);
			
			System.out.println("Size= "+store.size());
			
			for (int i = 0; i <= store.size()-1; i++) 
			{
	
	        driver.findElement(By.xpath("//*[@id='tblstockdetails_filter']/label/input")).sendKeys(store.get(i).getMedicine_Name().toString());
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[1]/td[4]")).getText();
			Thread.sleep(2000);
			
			store.get(i).setStockAvailable(driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[1]/td[4]")).getText());
			
			
			 driver.findElement(By.xpath("//*[@id='tblstockdetails_filter']/label/input")).clear();
			 Thread.sleep(2000);
			}
			
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='aSign']")).click();
		Thread.sleep(2000);
		
		try {
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			//driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			//driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(4000);
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
			driver.findElement(By.id("txtusername")).sendKeys(CMOUserName);
			driver.findElement(By.id("txtpassword")).sendKeys(CMOPassword);
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
			driver.findElement(By.id("txtusername")).sendKeys(CMOUserName);
			driver.findElement(By.id("txtpassword")).sendKeys(CMOPassword);
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

			while (true) {
				JavascriptExecutor cmo = (JavascriptExecutor) driver;
				cmo.executeScript("window.scrollBy(0,100)", "");
				try {
					driver.findElement(By.id(CMORNO)).click();
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					if (Seconds == 50) {
						System.out.println("* Request is not received to CMO due to Hospital Id Is Mismatching");
						break;

					}
					Seconds++;
					continue;

				}
			}

			if (Seconds == 50) {
				driver.close();
				Thread.sleep(3000);
				openbrowser();

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

			while (true) {
				JavascriptExecutor cmo = (JavascriptExecutor) driver;
				cmo.executeScript("window.scrollBy(0,100)", "");
				try {
					driver.findElement(By.id(CMORNO)).click();
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					if (Seconds == 50) {
						System.out.println("* Request is not received to CMO due to Hospital Id Is Mismatching");
						break;

					}
					Seconds++;
					continue;

				}
			}

			if (Seconds == 50) {
				driver.close();
				Thread.sleep(3000);
				openbrowser();

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
			driver.findElement(By.id("txtusername")).sendKeys(StoreUserName);
			driver.findElement(By.id("txtpassword")).sendKeys(StorePassword);
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
			driver.findElement(By.id("txtusername")).sendKeys(StoreUserName);
			driver.findElement(By.id("txtpassword")).sendKeys(StorePassword);
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

			Thread.sleep(2000);

			for (int q = 1; q < batchnumber_list.size(); q++) {
				batchnumber.selectByIndex(q);

				while(true)
				{
				Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
				if(Stock_qty.isEmpty())
				{
					Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
					continue;
				}
				else
				{
					Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
					break;
				}
				}
				
				Required_qty = driver.findElement(By.id("txttotal")).getAttribute("value");

				System.out.println(Product_name + "=== Stockqty :" + Stock_qty + " Required Qty :" + Required_qty);
				// System.out.println("Stockqty :" +Stock_qty+ " Required Qty
				// :"+Required_qty);

				if (Integer.parseInt(Stock_qty) >= Integer.parseInt(Required_qty)) {
					Thread.sleep(2000);
					driver.findElement(By.id("txtqty")).sendKeys(String.valueOf(Required_qty));
					driver.findElement(By.id("btnadd")).click();
					/*Medicinecount addgivenqty=new Medicinecount();
					addgivenqty.setGivenQty(Required_qty);
					store.add(addgivenqty);*/
					store.get(a-1).setGivenQty(Required_qty);
					
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
					
					store.get(i-1).setGivenQty("0");
					/*Medicinecount addgivenqty=new Medicinecount();
					addgivenqty.setGivenQty("0");
					store.add(addgivenqty);
*/				}
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

			String Pharmacyissuedalert = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/font")).getText();
			System.out.println("* PHARMACY ISSUED ALERT :" + Pharmacyissuedalert);
			Thread.sleep(2000);
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
		driver.findElement(By.id("txtusername")).sendKeys("brsshafi");
		driver.findElement(By.id("txtpassword")).sendKeys("shafi123");
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		  try {
			   WebElement inventory=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a/span"));
			   clickactions(inventory);
		       }
		   catch (Exception e2) 
		   {
			 e2.printStackTrace();
			 Thread.sleep(3000);
			 WebElement inventory=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a/span"));
			 clickactions(inventory);
		}
			System.out.println("Size f the List " +store.size());
		
		for (int i = 0; i <=store.size()-1; i++) 
		{
             driver.findElement(By.xpath("//*[@id='tblstockdetails_filter']/label/input")).sendKeys(store.get(i).getMedicine_Name().toString());
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[1]/td[4]")).getText();
			Thread.sleep(2000);
			store.get(i).setCurrent_Stock_QTy(driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr[1]/td[4]")).getText());
		    driver.findElement(By.xpath("//*[@id='tblstockdetails_filter']/label/input")).clear();
		}
		
		
		
		try {
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/a")).click();
			Thread.sleep(2000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[2]/a")).click();

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
		
		System.out.println("Size of the List " +store.size());
		for (int i = 0; i <=store.size()-1; i++) {
			
			System.out.println("Medicine Name :" +" " +store.get(i).getMedicine_Name().toString());
		    System.out.println("Previous Stock Qty :" +" " +store.get(i).getStockAvailable().toString());
			System.out.println("Requested Qty :" +" " +store.get(i).getRequested_Qty().toString());
			System.out.println("Given Qty :" +" " +store.get(i).getGivenQty().toString());	
		    System.out.println("Current Stock Qty :" +" " +store.get(i).getCurrent_Stock_QTy().toString());
		    System.out.println("====**********====*************====*************");
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

	class Medicinecount {
		String Medicine_Name, Requested_Qty, Current_Stock_QTy, StockAvailable,GivenQty;

		public String getCurrent_Stock_QTy() {
			return Current_Stock_QTy;
		}

		public void setCurrent_Stock_QTy(String current_Stoc_QTy) {
			Current_Stock_QTy = current_Stoc_QTy;
		}

		public String getGivenQty() {
			return GivenQty;
		}

		public void setGivenQty(String givenQty) {
			GivenQty = givenQty;
		}

		public String getStockAvailable() {
			return StockAvailable;
		}

		public void setStockAvailable(String stockAvailable) {
			StockAvailable = stockAvailable;
		}

		public String getMedicine_Name() {
			return Medicine_Name;
		}

		public void setMedicine_Name(String medicine_Name) {
			Medicine_Name = medicine_Name;
		}

		public String getRequested_Qty() {
			return Requested_Qty;
		}

		public void setRequested_Qty(String requested_Qty) {
			Requested_Qty = requested_Qty;
		}


	}
}
