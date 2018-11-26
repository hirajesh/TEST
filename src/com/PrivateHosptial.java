package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.subexample.Pageaccess;

public class PrivateHosptial {
	
	WebDriver driver;
	String ApplicantName="MANI";
	String NursingHome="FSM NURSING HOME";
	
	Pageaccess kdmc=new Pageaccess(driver);


@Test
public void Private() throws InterruptedException
{

Login();
Entry();
Thread.sleep(3000);
signout();
driver.close();


}


public void Login() throws InterruptedException 
{

	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://182.18.161.229/multihospital_new/Privatehoslogin.aspx");
	driver.findElement(By.id("txtusername")).sendKeys("mani");
	driver.findElement(By.id("txtpassword")).sendKeys("123");
	Thread.sleep(4000);
	driver.findElement(By.id("btnSubmit")).click();
	Thread.sleep(5000);
}


public void Entry() throws InterruptedException
{
	Pageaccess kdmc=new Pageaccess(driver);
	
driver.findElement(By.id("btnadd")).click();
Thread.sleep(2000);
Select hospital=new Select(driver.findElement(By.id("fldpo")));
hospital.selectByIndex(1);
driver.findElement(By.id("txtappname")).sendKeys(ApplicantName);
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='txttellno']")).sendKeys("787999898956");
Thread.sleep(2000);
driver.findElement(By.id("txtaddress")).sendKeys("Trichy");
Thread.sleep(2000);
kdmc.sendkeysfunction(2, "txtnational", "Hindu");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtsuit", "Good");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtnameother", NursingHome);
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtplace", "Trichy");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtarrangement", "Immunization Are Given");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtkitchen", "Floor");
kdmc.sendkeysfunction(2, "txtdetails", "Convience");
kdmc.sendkeysfunction(2, "txtstorage", "Storage Food");
kdmc.sendkeysfunction(2, "txtwhether", "Permiss connection");
kdmc.sendkeysfunction(2, "txtnoofbed", "50");
kdmc.sendkeysfunction(2, "txtotherpat", "50");
kdmc.sendkeysfunction(2, "txtnursingstaff", "Yes Accomdated");
kdmc.sendkeysfunction(2, "txtunregistered", "Midwife");
kdmc.sendkeysfunction(2, "txtnationality", "Indian");
kdmc.sendkeysfunction(2, "txtapplicant", "Yes Conducted");
kdmc.sendkeysfunction(2, "txtdateofexpiry", "5/5/2018");
kdmc.scrollthewindow();
Thread.sleep(2000);
kdmc.clicks(1, "//*[@id='txtgrndate']");
Thread.sleep(3000);
kdmc.clicks(1, "//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a");
Thread.sleep(1000);


kdmc.sendkeysfunction(2, "txtsignature", "C:\\Users\\Quality Analyst\\Downloads\\KDMC\\Signatures\\1.png");
kdmc.scrollthewindow();
JavascriptExecutor scroll = (JavascriptExecutor) driver;
scroll.executeScript("window.scrollBy(0,800)", "");
Thread.sleep(1000);
kdmc.scrollthewindow();
Thread.sleep(1000);
//kdmc.sendkeysfunction(2, "ContentPlaceHolder1_filebuilding", "Mumbai");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtowner", ApplicantName);
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txthosowner", ApplicantName);
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtownership", ApplicantName);
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtphno", "487465465465");
Thread.sleep(1000);
kdmc.scrollthewindow();
Select Dept=new Select(driver.findElement(By.id("optdept")));
Dept.selectByIndex(1);
Thread.sleep(1000);


kdmc.sendkeysfunction(2, "txtarea", "1500x1500");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtnobed", "600");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtroomdetail", "nil");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtpresentstatus", "Active");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtduration", "50");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtareaandwidth", "1500x600");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtothers", "No");
Thread.sleep(1000);
kdmc.scrollthewindow();
kdmc.clicks(2, "btnrowadd");
Thread.sleep(2000);
JavascriptExecutor scroll1 = (JavascriptExecutor) driver;
scroll1.executeScript("window.scrollBy(0,500)", "");

kdmc.sendkeysfunction(2, "txtdoc", "Guru");
kdmc.sendkeysfunction(2, "txtqual", "MBBS");
kdmc.sendkeysfunction(2, "txtage", "35");
kdmc.sendkeysfunction(2, "txtregnum", "788755445");
Thread.sleep(2000);
kdmc.sendkeysfunction(2, "txtsignature1",  "C:\\Users\\Quality Analyst\\Downloads\\KDMC\\Signatures\\3.png");

JavascriptExecutor scroll2 = (JavascriptExecutor) driver;
scroll2.executeScript("window.scrollBy(0,500)", "");
kdmc.sendkeysfunction(2, "txtdoct", "Raja");
kdmc.sendkeysfunction(2, "txtspl", "General Medicine");
kdmc.sendkeysfunction(2, "txtqual1", "MBBS");

kdmc.sendkeysfunction(2, "txtage1", "30");	
kdmc.sendkeysfunction(2, "txtmaha", "7878465421");	

kdmc.sendkeysfunction(2, "txtsignature2", "C:\\Users\\Quality Analyst\\Downloads\\KDMC\\Signatures\\2.png");
Thread.sleep(2000);
kdmc.clicks(2, "btnrowadd1");
Thread.sleep(2000);

JavascriptExecutor scroll3 = (JavascriptExecutor) driver;
scroll3.executeScript("window.scrollBy(0,500)", "");

kdmc.sendkeysfunction(2, "txtdoct1", "JAI");	
kdmc.sendkeysfunction(2, "txtspl1", "General Medicine");
kdmc.sendkeysfunction(2, "txtqual2", "MBBS");
kdmc.sendkeysfunction(2, "txtage2", "30");	
kdmc.sendkeysfunction(2, "txtmaha1", "788946465465");	
Thread.sleep(2000);
kdmc.sendkeysfunction(2, "txtsignature3", "C:\\Users\\Quality Analyst\\Downloads\\KDMC\\Signatures\\4.png");	
kdmc.clicks(2, "btnrowadd2");
Thread.sleep(2000);

JavascriptExecutor scroll4 = (JavascriptExecutor) driver;
scroll4.executeScript("window.scrollBy(0,500)", "");

kdmc.sendkeysfunction(2, "txtdoct2", "General");	
kdmc.sendkeysfunction(2, "txtspl2", "Ragu");	
kdmc.sendkeysfunction(2, "txtqual3", "MBBS");	
kdmc.sendkeysfunction(2, "txtage3", "35");	
kdmc.sendkeysfunction(2, "txtmaha2", "8978954765");
Thread.sleep(2000);
kdmc.sendkeysfunction(2, "txtsignature4", "C:\\Users\\Quality Analyst\\Downloads\\KDMC\\Signatures\\5.png");	
Thread.sleep(2000);
kdmc.clicks(2, "btnrowadd3");
Thread.sleep(2000);

JavascriptExecutor scroll5 = (JavascriptExecutor) driver;
scroll5.executeScript("window.scrollBy(0,600)", "");

kdmc.sendkeysfunction(2, "txtdoct3", "Nithya");	
kdmc.sendkeysfunction(2, "txtqual4", "Bsc Nursing");	
kdmc.sendkeysfunction(2, "txtage4", "27");	
kdmc.sendkeysfunction(2, "txtmaha3", "783513515");
Thread.sleep(2000);
kdmc.sendkeysfunction(2, "txtsignature5", "C:\\Users\\Quality Analyst\\Downloads\\KDMC\\Signatures\\6.png");
Thread.sleep(2000);
kdmc.clicks(2, "btnrowadd4");
Thread.sleep(2000);

JavascriptExecutor scroll6 = (JavascriptExecutor) driver;
scroll6.executeScript("window.scrollBy(0,500)", "");

kdmc.sendkeysfunction(2, "txtdoct4", "Service Rendered");	
kdmc.sendkeysfunction(2, "txtqual5", "54");	
kdmc.sendkeysfunction(2, "txtage5", "Rendered");
kdmc.sendkeysfunction(2, "txtmaha4", "60");
kdmc.clicks(2, "btnrowadd5");
Thread.sleep(2000);
JavascriptExecutor scroll7 = (JavascriptExecutor) driver;
scroll7.executeScript("window.scrollBy(0,500)", "");

kdmc.sendkeysfunction(2, "txtot", "Yes");	
kdmc.sendkeysfunction(2, "txtot1", "50");
kdmc.sendkeysfunction(2, "txtbed", "Yes");	
kdmc.sendkeysfunction(2, "txtbed1", "60");
Thread.sleep(1000);
kdmc.clicks(2, "chk1");
kdmc.sendkeysfunction(2, "txtmac", "50");	
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txticu", "55");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txticu1", "fiftyfive");	
Thread.sleep(1000);
JavascriptExecutor scroll8 = (JavascriptExecutor) driver;
scroll8.executeScript("window.scrollBy(0,500)", "");


kdmc.sendkeysfunction(2, "txticu", "Seventy");
kdmc.sendkeysfunction(2, "txticu1", "70");

Thread.sleep(2000);
kdmc.sendkeysfunction(2, "txtbed2", "Seventyone");
kdmc.sendkeysfunction(2, "txtbed3", "71");	
Thread.sleep(1000);
kdmc.clicks(2, "chk23");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtlabour", "Yes");
Thread.sleep(2000);
JavascriptExecutor scroll9 = (JavascriptExecutor) driver;
scroll9.executeScript("window.scrollBy(0,500)", "");

kdmc.clicks(2, "chk47");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtuto", "10");
Thread.sleep(2000);

kdmc.scrollthewindow();
kdmc.clicks(2, "chk55");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtoper1", "20");
Thread.sleep(2000);


kdmc.sendkeysfunction(2, "txticu2", "Eighty");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txticu21", "80");	
Thread.sleep(2000);

kdmc.sendkeysfunction(2, "txtbed5", "ninety");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtbed51", "90");
Thread.sleep(2000);

kdmc.clicks(2, "chk73");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtemer2", "30");
Thread.sleep(2000);



kdmc.sendkeysfunction(2, "txticu3", "Hundred");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txticu4", "100");	
Thread.sleep(2000);

kdmc.sendkeysfunction(2, "txtbed6", "Hunderenden ten");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtbed7", "110");
Thread.sleep(2000);

kdmc.clicks(2, "chk93");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtemer12", "40"); 
Thread.sleep(2000);

JavascriptExecutor scroll10 = (JavascriptExecutor) driver;
scroll10.executeScript("window.scrollBy(0,500)", "");

kdmc.clicks(2, "chk111");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtemer21", "50");
Thread.sleep(2000);

kdmc.clicks(2, "chk121");
Thread.sleep(1000);
kdmc.sendkeysfunction(2, "txtemer26", "60");
Thread.sleep(2000);
JavascriptExecutor scroll11 = (JavascriptExecutor) driver;
scroll11.executeScript("window.scrollBy(0,600)", "");
Thread.sleep(2000);
kdmc.clicks(2, "ContentPlaceHolder1_btnSubmit");
	
}
public void signout() throws InterruptedException 
{
	Pageaccess kdmc=new Pageaccess(driver);
kdmc.clicks(1, "/html/body/header/div/div/nav/div/ul/li[2]/a");
Thread.sleep(2000);
kdmc.clicks(1, "//*[@id='aSign']");
Thread.sleep(2000);
}
	
	

}
