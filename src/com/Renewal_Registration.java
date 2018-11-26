package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.subexample.Pageaccess;

public class Renewal_Registration {
	
	
	WebDriver driver;
	Pageaccess kdmc=new Pageaccess(driver);
	String ApplicatName="FAIZAL";
	String Nursinghome="FAIZAL NURSING HOME";
	String DoctorName="FAIZAL";
	
	
	@Test
	public void Privaterenewal() throws InterruptedException 
	{
Login();
Renewal();
signout();
Thread.sleep(2000);
driver.close();
		
	}

	
	public void Login() throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://182.18.161.229/multihospital_new/Privatehoslogin.aspx");
		driver.findElement(By.id("txtusername")).sendKeys("santhiya");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(5000);
	}
public void Renewal() throws InterruptedException
{
	Pageaccess kdmc=new Pageaccess(driver);
	
	WebElement open=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a"));
	kdmc.Clickactions(open);
    Thread.sleep(2000);
	
	kdmc.clicks(2, "btnadd");
	Thread.sleep(2000);
	Select NursingHome=new Select(driver.findElement(By.id("fldpo")));
	NursingHome.selectByIndex(6);
	kdmc.sendkeysfunction(2, "txtappname", ApplicatName);
	kdmc.sendkeysfunction(2, "txtname", DoctorName);
	kdmc.clicks(2, "txtgrndate");
	kdmc.clicks(1, "//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[6]/a");
	
	
	
	
	kdmc.sendkeysfunction(2, "txtwhether", "No New Unit");
	kdmc.sendkeysfunction(2, "txtprevious", "Yes");
	kdmc.sendkeysfunction(2, "txtproposed", "Yes");
	kdmc.sendkeysfunction(2, "txtgive", "Yes");
	
	
	JavascriptExecutor scroll = (JavascriptExecutor) driver;
	scroll.executeScript("window.scrollBy(0,500)", "");
	
	kdmc.sendkeysfunction(2, "txtowner", "40");
	kdmc.sendkeysfunction(2, "txthosowner", "50");
	kdmc.sendkeysfunction(2, "txtownership", "60");
	kdmc.sendkeysfunction(2, "txtphno", "70");
	kdmc.clicks(2, "btnrowadd");
	
	JavascriptExecutor scroll1 = (JavascriptExecutor) driver;
	scroll1.executeScript("window.scrollBy(0,500)", "");
	
	kdmc.sendkeysfunction(2, "txtarea", "1500");
	kdmc.sendkeysfunction(2, "txtarea1", "1200");
	kdmc.sendkeysfunction(2, "txtarea2", "800");
	kdmc.sendkeysfunction(2, "txttot", "60");
	kdmc.sendkeysfunction(2, "txttot1", "60");
	kdmc.sendkeysfunction(2, "txttot2", "60");
	kdmc.sendkeysfunction(2, "txttot3", "60");
	
	kdmc.clicks(2, "chk9");
	kdmc.clicks(2, "chk11");
	kdmc.clicks(2, "chk13");
	kdmc.clicks(2, "chk15");
	kdmc.clicks(2, "chk19");
	kdmc.clicks(2, "chk21");
	kdmc.clicks(2, "chk27");
	kdmc.clicks(2, "chk29");
	kdmc.clicks(2, "chk31");
	kdmc.clicks(2, "chk35");
	kdmc.clicks(2, "chk37");
	kdmc.clicks(2, "chk39");
	kdmc.clicks(2, "chk43");
	kdmc.clicks(2, "chk45");
	kdmc.clicks(2, "chk47");
	kdmc.clicks(2, "chk51");
	kdmc.clicks(2, "chk53");
	kdmc.clicks(2, "chk55");
	kdmc.clicks(2, "chk57");
	kdmc.clicks(2, "chk59");
	
	JavascriptExecutor scroll2 = (JavascriptExecutor) driver;
	scroll2.executeScript("window.scrollBy(0,500)", "");
	
	kdmc.sendkeysfunction(2, "txtot", "1500");
	kdmc.sendkeysfunction(2, "txtot1", "1200");
	kdmc.sendkeysfunction(2, "txtot2", "800");
	kdmc.sendkeysfunction(2, "txtot3", "60");
	kdmc.sendkeysfunction(2, "txtbedward", "60");
	kdmc.sendkeysfunction(2, "txtbedward1", "60");
	kdmc.sendkeysfunction(2, "txtbedward2", "60");
	kdmc.sendkeysfunction(2, "txtbedward3", "60");
	
	kdmc.clicks(2, "chk65");
	kdmc.clicks(2, "chk67");
	kdmc.clicks(2, "chk69");
	
	kdmc.sendkeysfunction(2, "txtremark", "60");
	kdmc.sendkeysfunction(2, "txtremark1", "60");
	kdmc.sendkeysfunction(2, "txtremark2", "60");
	kdmc.sendkeysfunction(2, "txtremark3", "60");
	
	
	
	
	kdmc.clicks(2, "chk73");
	kdmc.clicks(2, "chk75");
	kdmc.clicks(2, "chk81");
	kdmc.clicks(2, "chk83");
	kdmc.clicks(2, "chk85");
	kdmc.clicks(2, "chk89");
	kdmc.clicks(2, "chk91");
	kdmc.clicks(2, "chk97");
	kdmc.clicks(2, "chk99");
	
	kdmc.clicks(2, "chk105");
	kdmc.clicks(2, "chk107");
	
	kdmc.clicks(2, "chk113");
	kdmc.clicks(2, "chk115");
	kdmc.clicks(2, "chk117");
	
	
	kdmc.clicks(2, "chk120");
	kdmc.clicks(2, "chk122");
	kdmc.clicks(2, "chk124");
	
	JavascriptExecutor scroll3 = (JavascriptExecutor) driver;
	scroll3.executeScript("window.scrollBy(0,500)", "");
	
	kdmc.clicks(2, "chk129");
	kdmc.clicks(2, "chk176");
	kdmc.clicks(2, "chk132");
	kdmc.clicks(2, "chk179");
	kdmc.clicks(2, "chk135");
	kdmc.clicks(2, "chk138");
	kdmc.clicks(2, "chk141");
	kdmc.clicks(2, "chk144");
	kdmc.clicks(2, "chk146");
	
	kdmc.clicks(2, "chk149");
	kdmc.clicks(2, "chk107");
	
	kdmc.clicks(2, "chk155");
	
	kdmc.sendkeysfunction(2, "filUpload", "C:\\Users\\Quality Analyst\\Downloads\\KDMC\\Signatures\\1.png");
	JavascriptExecutor scroll4 = (JavascriptExecutor) driver;
	scroll4.executeScript("window.scrollBy(0,800)", "");
	
	kdmc.clicks(2, "btnSubmit");
	Thread.sleep(3000);
	kdmc.clicks(1, "/html/body/div[8]/div/div/div[2]/button");
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
