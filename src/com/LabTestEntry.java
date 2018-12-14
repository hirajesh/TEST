package com;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LabTestEntry {

	WebDriver driver;
	String all,Trimname,lname;
	String[] PSname={"10798"};
	String Healthpost="http://192.168.137.1/Multihospital_New/HDSplashscreen.aspx?log=0";
	String Hospital_LOCAL="http://192.168.137.1/Multihospital_New/";
	
	@Test
	public  void op() throws InterruptedException, FileNotFoundException 
	{

		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe");  
		   
		driver = new ChromeDriver();
		
		// driver.get(Hospital_LOCAL);
	//	driver.get("http://182.18.161.229/Multihospital_New/");
		driver.get("http://122.165.236.133/MultiHospital/Splashscreen.aspx");
		
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Investigation")).click();
		driver.findElement(By.id("txtusername")).sendKeys("brsraja");
		driver.findElement(By.id("txtpassword")).sendKeys("raja123");
        Thread.sleep(4000);
		
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		Thread.sleep(4000);

		
		for(int y=0;y<PSname.length;y++)
		{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='example1_filter']/label/input")).sendKeys(PSname[y]);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='example1']/tbody/tr[1]/td[2]/a")).click();
				
	
		if (driver.findElement(By.id("fldivecgheader")).isDisplayed()) 
		{
			ECG();
		} 
		else
		{
			System.out.print("Page Contains No ECG Test \n");
		}

		if (driver.findElement(By.id("fldiveegheader")).isDisplayed()) 
		{
			EEG();
		} 
		else 
		{
			System.out.print("page contains no EEG Test \n");
		}
		if (driver.findElement(By.id("fldivxrayheder")).isDisplayed()) 
		{
			XRAY();
		}
		else
		{
			System.out.print("Page Contains No X RAY Test \n");
		}
		if (driver.findElement(By.id("fldivscanheader")).isDisplayed()) 
		{
			SCAN();
		}
		else 
		{
			System.out.print("Page Contains No SCAN Test \n");
		}
		if (driver.findElement(By.id("fldivangioheader")).isDisplayed()) 
		{
			ANGIO();
		}
		else 
		{
			System.out.print("Page Contains No ANGIOGRAM Test \n");
		}
		if (driver.findElement(By.id("fldivtesthead")).isDisplayed()) 
		{
			subtest();
			
			Select rtype5=new Select(driver.findElement(By.id("resulttype")));
			rtype5.selectByValue("1");
		} 
		else 
		{
			System.out.print("Page Contains No TESTS value \n");
		}
		
		
		
		WebElement save = driver.findElement(By.id("btnSaveangio"));
		Actions action1 = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 4000)");
		Thread.sleep(3000);
		action1.moveToElement(save).click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("body > div.bootbox.modal.fade.bootbox-alert.in > div > div > div.modal-footer > button")).click();
		Thread.sleep(4000);	
		}
		Thread.sleep(2000);	
	signout();
	Thread.sleep(2000);
		driver.close();

	}

	public void signout() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
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
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println(" ");
	        System.out.println("* SIGN OUT SUCCESSFULLY");
		}
		
	}
	
	public  void subtest() throws InterruptedException 
	{
		driver.findElement(By.id("fldivtesthead")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("testimgrem")).sendKeys("TEST REPORT");
		driver.findElement(By.id("testupload")).sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\TestReport.png");
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddtestimg")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.id("fldTest"));
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();
		System.out.println(list.size());
		for (int i = 1; i < list.size(); i++) {
			/*
			 * Select select1=new Select (driver.findElement(By.id("fldTest")));
			 * List<WebElement> list1=select1.getOptions(); for(int
			 * j=0;j<list1.size();j++) {
			 * System.out.println(list1.get(j).getText()); }
			 */
			
			System.out.println(list.get(i).getText());
			Thread.sleep(3000);
			String test_name=list.get(i).getText().toString();

			
				if (test_name.equals("STOOL/All stool test")) 
				{
					Load(4);
				} 
				else if (test_name.equals("HIV/All hiv test")) 
				{

					Load(1);
				} 
				else if (test_name.equals("EXAMINATION OF BLOOD/All examination of blood"))
				{

					Load(2);
				} 
				else if (test_name.equals("URINE/All urine test")) 
				{

					Load(3);
				} 
				else if (test_name.equals("ANC FP/All anc fp test"))
				{

					Load(5);
				} 
				
				else if (test_name.equals("EXAMINATION OF BLOOD/Complete blood count"))
				{

					Load(6);
				}
				
				else if (test_name.equals("EXAMINATION OF BLOOD/Differential count")) {

					Load(7);
				}

				else if (test_name.equals("EXAMINATION OF BLOOD/Widal test")) {

					Load(8);
				}
				
			else {
				
					
			//	System.out.println("No All Test is present");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)");
				select.selectByIndex(i);
				 if (test_name.equals("EXAMINATION OF BLOOD/Complete blood count"))
				 {

					Load(6);
				}
				
				 else if (test_name.equals("EXAMINATION OF BLOOD/Differential count"))
				 {

					Load(7);
				}

				 else if (test_name.equals("EXAMINATION OF BLOOD/Widal test")) 
				 {

					Load(8);
				}
				
				 else
				 {		
				
				driver.findElement(By.id("fldTestdetail")).clear();
				driver.findElement(By.id("fldTestdetail")).sendKeys(String.valueOf(randomvalues()+"."+i));
				driver.findElement(By.id("fldtestremarks")).sendKeys("Normal");
			/*	Select rtype=new Select(driver.findElement(By.id("resulttype")));
				rtype.selectByValue("2");*/
				driver.findElement(By.id("btnAddtest")).click();
				 }
				 }
		}
		

	}

	public  void Load(int Id) throws InterruptedException {
		try {

			Select select = new Select(driver.findElement(By.id("fldTest")));

			switch (Id) {
			case 1:

				// HIV
				// ************************

				select.selectByVisibleText("HIV/All hiv test");
				driver.findElement(By.id("txtlapid")).sendKeys("BSR L1");

				Thread.sleep(3000);
				Select ss = new Select(driver.findElement(By.id("spictype")));
				ss.selectByVisibleText("Serum");
				driver.findElement(By.id("txtname1")).sendKeys("HIV1");
				driver.findElement(By.id("txtbatch1")).sendKeys("Bct45");
				driver.findElement(By.id("txtanti11")).sendKeys("Normal");
				driver.findElement(By.id("txtanti12")).sendKeys("Normal L1");
				driver.findElement(By.id("txtanti13")).sendKeys("Normal L2");
				driver.findElement(By.id("ch1")).click();
				driver.findElement(By.id("ch2")).click();
				driver.findElement(By.id("ch3")).click();
				driver.findElement(By.id("ch4")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("btnhivadd")).click();
				Thread.sleep(2000);
				break;

			case 2:

				// EXAMINATION OF BLOOD
				// ***************************************

				select.selectByVisibleText("EXAMINATION OF BLOOD/All examination of blood");
				Thread.sleep(3000);
			/*	Select rtype=new Select(driver.findElement(By.id("resulttype")));
				rtype.selectByValue("1");*/
				driver.findElement(By.id("txthemo")).sendKeys("18");
				driver.findElement(By.id("txtpaked")).sendKeys("50");
				driver.findElement(By.id("txttotal")).sendKeys("3000");
				driver.findElement(By.id("txtrb")).sendKeys("4.3");

				// DIFFERENTIAL COUNT
			
				// ----------------------
				driver.findElement(By.id("txtpoly")).sendKeys("45");
				driver.findElement(By.id("txtlym")).sendKeys("30");
				driver.findElement(By.id("txteos")).sendKeys("02");
				driver.findElement(By.id("txtmono")).sendKeys("09");
				driver.findElement(By.id("txtbaso")).sendKeys("01");
				driver.findElement(By.id("txtband")).sendKeys("2.5");
				driver.findElement(By.id("txtplate")).sendKeys("2.7");
				driver.findElement(By.id("txtps")).sendKeys("20");
				driver.findElement(By.id("txtesr")).sendKeys("300");

				// WIDEL TEST
				// -------------
				driver.findElement(By.id("txttyphio")).sendKeys("16");
				driver.findElement(By.id("txttyphih")).sendKeys("13");
				driver.findElement(By.id("txttyphiAH")).sendKeys("15");
				driver.findElement(By.id("txtparatBH")).sendKeys("12");
				Thread.sleep(2000);
				JavascriptExecutor add=(JavascriptExecutor)driver;
				add.executeScript("window.scrollBy(0,500)", "");
				driver.findElement(By.id("btnexamadd")).click();
				break;

			case 3:

				// ALL URINE REPORT
				// **********************************************

				select.selectByVisibleText("URINE/All urine test");
				Thread.sleep(3000);
				/*Select rtype1=new Select(driver.findElement(By.id("resulttype")));
				rtype1.selectByValue("2");*/
				

				// PHYSICAL EXAMINATION
				// ------------------------
				driver.findElement(By.id("txtqty")).sendKeys("2.5");
				driver.findElement(By.id("txtsediment")).sendKeys("3");
				driver.findElement(By.id("txtcolour")).sendKeys("Yellow");
				driver.findElement(By.id("txtgravity")).sendKeys("2.5");
				driver.findElement(By.id("txtapp")).sendKeys("Normal");

				// CHEMICAL EXAMINATION
				// ------------------------

				driver.findElement(By.id("txtph")).sendKeys("Normal");
				driver.findElement(By.id("txtacetone")).sendKeys("50");
				driver.findElement(By.id("txtprotins")).sendKeys("20");
				driver.findElement(By.id("txtbitesalf")).sendKeys("8.3");
				driver.findElement(By.id("txtsugar")).sendKeys("23");
				driver.findElement(By.id("txtbilepigment")).sendKeys("50");
				driver.findElement(By.id("txtoccblood")).sendKeys("90");
				driver.findElement(By.id("txtepith")).sendKeys("45");
				driver.findElement(By.id("txtmaterial")).sendKeys("65");

				// MICROSCOPIC EXAMINATION
				// ------------------------
				driver.findElement(By.id("txtpuscells")).sendKeys("32");
				driver.findElement(By.id("txttricho")).sendKeys("35");
				driver.findElement(By.id("txtredblood")).sendKeys("56");
				driver.findElement(By.id("txtcast")).sendKeys("87");
				driver.findElement(By.id("txtfinding")).sendKeys("95");
				driver.findElement(By.id("btnurineadd")).click();
				break;

			case 4:

				// STOOL REPORT
				// ***************************************

				select.selectByVisibleText("STOOL/All stool test");
				Thread.sleep(3000);
				/*Select rtype2=new Select(driver.findElement(By.id("resulttype")));
				rtype2.selectByValue("2");
*/
				// PHYSICAL EXAMINATION
				// --------------------------------
				driver.findElement(By.id("txtcolor")).sendKeys("YELLOW");
				driver.findElement(By.id("txtblood")).sendKeys("Normal");
				driver.findElement(By.id("txtconsistency")).sendKeys("2.5");
				driver.findElement(By.id("txtparat")).sendKeys("30");
				driver.findElement(By.id("txtmusus")).sendKeys("4.5");

				// CHEMICAL EXAMINATION
				// -----------------------------
				driver.findElement(By.id("txtoccult")).sendKeys("2.5");

				// MICROSCOPIC EXAMINATION
				// ------------------------
				driver.findElement(By.id("txtcpicells")).sendKeys("50");
				driver.findElement(By.id("txtveg")).sendKeys("44");
				driver.findElement(By.id("txtpus")).sendKeys("25");
				driver.findElement(By.id("txtproto")).sendKeys("85");
				driver.findElement(By.id("txtredbloodcell")).sendKeys("74");
				driver.findElement(By.id("txtFlagellates")).sendKeys("62");
				driver.findElement(By.id("txtMacrophages")).sendKeys("88");
				driver.findElement(By.id("txtcyst")).sendKeys("12");
				driver.findElement(By.id("txtfat")).sendKeys("47");
				driver.findElement(By.id("txtStarch")).sendKeys("25");
				driver.findElement(By.id("txtova")).sendKeys("34");
				driver.findElement(By.id("txtundi")).sendKeys("58");
				driver.findElement(By.id("txtlarvae")).sendKeys("75");
				driver.findElement(By.id("txtanyfind")).sendKeys("44");

				// HANGING DROP METHOD
				// ------------------------
				Select Result = new Select(driver.findElement(By.id("opthang")));
				Result.selectByVisibleText("Positive");
				driver.findElement(By.id("btnstooladd")).click();
				break;

			case 5:

				// ANC REPORT
				// **********************************

				select.selectByVisibleText("ANC FP/All anc fp test");
				Thread.sleep(3000);
				/*Select rtype3=new Select(driver.findElement(By.id("resulttype")));
				rtype3.selectByValue("1");*/

				driver.findElement(By.id("txthemoanc")).sendKeys("17");
				driver.findElement(By.id("txtrh")).sendKeys("O Negative");
				driver.findElement(By.id("txtvdpl")).sendKeys("50");

				// URINE EXAMINATION
				// ------------------------
				// Physical

				driver.findElement(By.id("txtanccolor")).sendKeys("Yellow");
				driver.findElement(By.id("txtapper")).sendKeys("Normal");

				// CHEMICAL EXAMINATION
				// ------------------------
				driver.findElement(By.id("txtalbum")).sendKeys("4.5");
				driver.findElement(By.id("txtsugaranc")).sendKeys("2.6");
				driver.findElement(By.id("txtbssp")).sendKeys("7.88");

				// MICROSCOPIC EXAMINATION
				// ------------------------
				driver.findElement(By.id("txtepithe")).sendKeys("3.5");
				driver.findElement(By.id("txtamar")).sendKeys("4.6");
				driver.findElement(By.id("txtpuscellsans")).sendKeys("3.7");
				driver.findElement(By.id("txttrichomonas")).sendKeys("77");
				driver.findElement(By.id("txtredcells")).sendKeys("85");
				driver.findElement(By.id("txtcasts")).sendKeys("41");
				driver.findElement(By.id("txtcry")).sendKeys("56");
				driver.findElement(By.id("txtyeastcells")).sendKeys("75");
				driver.findElement(By.id("txtbact")).sendKeys("25");
				Select Aus = new Select(driver.findElement(By.id("optaat")));
				Aus.selectByVisibleText("Positive");
				Select Upt = new Select(driver.findElement(By.id("optupt")));
				Upt.selectByVisibleText("Positive");
				driver.findElement(By.id("txttc")).sendKeys("14");
				driver.findElement(By.id("txtdc")).sendKeys("57");
				driver.findElement(By.id("txtl")).sendKeys("25");
				driver.findElement(By.id("txte")).sendKeys("17");
				driver.findElement(By.id("txtm")).sendKeys("19");
				driver.findElement(By.id("btnaccall")).click();
				Thread.sleep(2000);
			break;
			case 6:
				
				// EXAMINATION OF BLOOD
				// ***************************************

				select.selectByVisibleText("EXAMINATION OF BLOOD/Complete blood count");
				Thread.sleep(3000);
				/*Select rtype4=new Select(driver.findElement(By.id("resulttype")));
				rtype4.selectByValue("1");*/
				driver.findElement(By.id("txthemo")).sendKeys("16");
				driver.findElement(By.id("txtpaked")).sendKeys("50");
				driver.findElement(By.id("txttotal")).sendKeys("9000");
				driver.findElement(By.id("txtrb")).sendKeys("5.2");
				driver.findElement(By.id("btnexamadd")).click();
				
				break;
			case 7:	
				
				// DIFFERENTIAL COUNT
				// ----------------------
				
				select.selectByVisibleText("EXAMINATION OF BLOOD/Differential count");
				Thread.sleep(3000);
			/*	Select rtype5=new Select(driver.findElement(By.id("resulttype")));
				rtype5.selectByValue("1");*/
				driver.findElement(By.id("txtpoly")).sendKeys("50");
				driver.findElement(By.id("txtlym")).sendKeys("30");
				driver.findElement(By.id("txteos")).sendKeys("4");
				driver.findElement(By.id("txtmono")).sendKeys("7");
				driver.findElement(By.id("txtbaso")).sendKeys("0.5");
				driver.findElement(By.id("txtband")).sendKeys("50");
				driver.findElement(By.id("txtplate")).sendKeys("2.5");
				driver.findElement(By.id("txtps")).sendKeys("20");
				driver.findElement(By.id("txtesr")).sendKeys("300");
				driver.findElement(By.id("btnexamadd")).click();

				break;
			case 8:	
				// WIDEL TEST
				// -------------
				
				select.selectByVisibleText("EXAMINATION OF BLOOD/Widal test");
				Thread.sleep(3000);
				/*Select rtype6=new Select(driver.findElement(By.id("resulttype")));
				rtype6.selectByValue("1");*/
				driver.findElement(By.id("txttyphio")).sendKeys("1.6");
				driver.findElement(By.id("txttyphih")).sendKeys("1.2");
				driver.findElement(By.id("txttyphiAH")).sendKeys("1.5");
				driver.findElement(By.id("txtparatBH")).sendKeys("1.2");
				driver.findElement(By.id("btnexamadd")).click();
				driver.findElement(By.id("btnexamadd")).click();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// driver.findElement(By.id("btnSaveangio")).click(); //SAVE

	}

	public  void ECG() throws InterruptedException {

		driver.findElement(By.id("fldivecgheader")).click();
		Thread.sleep(3000);
		Select ec = new Select(driver.findElement(By.id("fldEcgsummary")));
		Thread.sleep(2000);
		ec.selectByVisibleText("Fast");

		driver.findElement(By.id("txtRate")).sendKeys("0.25seconds");
		Thread.sleep(2000);
		Select rhy = new Select(driver.findElement(By.id("fldRhythm")));
		rhy.selectByVisibleText("Atrial fibrillation");

		driver.findElement(By.id("txtPR")).sendKeys("0.75seconds");

		driver.findElement(By.id("fldQRS")).sendKeys("0.5seconds");
		Thread.sleep(1000);
		Select st = new Select(driver.findElement(By.id("fldST")));
		st.selectByVisibleText("Depressed");
		Thread.sleep(1000);
		Select twave = new Select(driver.findElement(By.id("fldTWave")));
		Thread.sleep(1000);
		twave.selectByVisibleText("Inverted");
		Thread.sleep(2000);
		Select axis = new Select(driver.findElement(By.id("fldAxis")));
		Thread.sleep(1000);
		axis.selectByVisibleText("Right");
		Thread.sleep(1000);
		Select bundle = new Select(driver.findElement(By.id("fldBundle")));
		bundle.selectByVisibleText("Left");
		Thread.sleep(1000);
		Select conduction = new Select(driver.findElement(By.id("fldConduction")));
		conduction.selectByVisibleText("1st degree heart block");
		Thread.sleep(1000);
		Select treadmill = new Select(driver.findElement(By.id("fldTredmill")));
		treadmill.selectByVisibleText("Positive for inducible ischaemia");
		Thread.sleep(1000);
		driver.findElement(By.id("ecgimgrem")).sendKeys("NORMAL");
		Thread.sleep(1000);
		driver.findElement(By.id("filUpload")).sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\ECG\\ecg.jpg");
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddecgimg")).click();
		/*
		 * Alert alert=driver.switchTo().alert(); alert.getText();
		 * System.out.println(alert); alert.accept();
		 */
		/*
		 * driver.findElement(By.id("filUpload")).
		 * sendKeys("C:\\Users\\Document\\Documents\\Billin report\\eeg.jpg");
		 * driver.findElement(By.id("btnAddecgimg")).click();
		 */
		Thread.sleep(3000);
		JavascriptExecutor ecg=(JavascriptExecutor)driver;
		ecg.executeScript("window.scrollBy(0,800)", "");
		// driver.findElement(By.id("fldivecgheader")).click();

	}

	public  void EEG() throws InterruptedException {

		driver.findElement(By.id("fldiveegheader")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("fldEEGsummary")).sendKeys("EEG REPORT");
		Thread.sleep(3000);
		driver.findElement(By.id("eegimgrem")).sendKeys("NORMAL");
		Thread.sleep(3000);
		driver.findElement(By.id("eegupload")).sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\EEG\\eeg.png");
		driver.findElement(By.id("btnAddeegimg")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("fldiveegheader")).click();
	}

	public  void ANGIO() throws InterruptedException {

		driver.findElement(By.id("fldivangioheader")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("angiyoimgrem")).sendKeys("ANGIOGRAM REPORT");
		driver.findElement(By.id("angioupload"))
				.sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\ANGIO\\Angio brain.jpg");
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddangiyoimg")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("fldBrain")).sendKeys("NORMAL");
		Thread.sleep(2000);
		// driver.findElement(By.id("fldivangioheader")).click();

	}

	public  void SCAN() throws InterruptedException {

		
		driver.findElement(By.id("fldivscanheader")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("scanimgrem")).sendKeys("SCAN REPORT");
		driver.findElement(By.id("scanupload")).sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\SCAN\\Mri abdomen.png");
		driver.findElement(By.id("btnAddscanimg")).click();
		Thread.sleep(2000);
		Select scanr = new Select(driver.findElement(By.id("fldscanrpt")));
		List<WebElement> sclist=scanr.getOptions();
		for(int j=1;j<sclist.size();j++)
		{
		scanr.selectByIndex(j);
		Thread.sleep(2000);
		driver.findElement(By.id("fldScamdetail")).sendKeys("Good");
		driver.findElement(By.id("fldScanrptdetail")).sendKeys("NORMAL");
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddscan")).click();
		}
		//driver.findElement(By.id("fldivscanheader")).click();
	}

	public  void XRAY() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("fldivxrayheder")).click();
	
		Select xrayremark = new Select(driver.findElement(By.id("fldXray")));
		List<WebElement> xrayrem=xrayremark.getOptions();
		for(int xray=1;xray<xrayrem.size();xray++)
		{
		xrayremark.selectByIndex(xray);
		Thread.sleep(3000);
		Select detail = new Select(driver.findElement(By.id("fldXayremark")));
		detail.selectByVisibleText("Good");
		Thread.sleep(3000);
		driver.findElement(By.id("fldXraydetail")).sendKeys("NORMAL");
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddxray")).click();
		Thread.sleep(3000);
		JavascriptExecutor xrayscroll=(JavascriptExecutor)driver;
		xrayscroll.executeScript("window.scrollBy(0,300)", "");
		//driver.findElement(By.id("fldivxrayheder")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("xrayimgrem")).sendKeys("X-RAY REPORT");
		Thread.sleep(3000);
		driver.findElement(By.id("xrayupload")).sendKeys("C:\\Users\\Quality Analyst\\Downloads\\KDMC\\X-RAY\\X-ray Hand.jpg");
		Thread.sleep(3000);
		driver.findElement(By.id("btnAddxrayimg")).click();
		Thread.sleep(3000);
		}
		
	}
	
	public String randomvalues() 
	{
		String val="";
		Random values=new Random();
        val=String.valueOf(values.nextInt(100));
		return val;
	}
	
}
