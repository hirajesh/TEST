package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.subexample.Pageaccess;

public class Private_Hospital_Inspection
{
	WebDriver driver;
	Pageaccess kdmc=new Pageaccess(driver);
	String ApplicatName="MANI";
	String Nursinghome="BALA NURSING HOME";
	
	
	@Test
	public void RUN() throws InterruptedException {
		
		Login();
		Inspect();
		signout();
		Thread.sleep(3000);
		//Send();
		driver.close();
	}

	
	
	public void Login() throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://182.18.161.229/Multihospital_New/AdminLogin.aspx?login=HD");
		driver.findElement(By.id("txtusername")).sendKeys("santhiya");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(5000);
	}
	
	public void Inspect() throws InterruptedException 
	{

		/*WebElement open=driver.findElement(By.xpath("//*[@id='loadfull']/aside[1]/section/ul/li[3]/a"));
		kdmc.Clickactions(open);
		
		Thread.sleep(2000);
		
		kdmc.clicks(1, "//*[@id='phpid']/a");
		Thread.sleep(2000);
		kdmc.clicks(1, "//*[@id='phpid']/ul/li[2]/a");*/
		Pageaccess kdmc=new Pageaccess(driver);
		
		driver.get("http://182.18.161.229/Multihospital_New/PrivatehosregistrationInspectionIII.aspx");
		Thread.sleep(3000);
		Select NursingHome=new Select(driver.findElement(By.id("fldpo")));
		NursingHome.selectByIndex(1);
		Thread.sleep(1000);
		kdmc.sendkeysfunction(2, "txt1", ApplicatName);
		Thread.sleep(1000);
		kdmc.sendkeysfunction(2, "txt2", Nursinghome);
		Thread.sleep(1000);
		kdmc.sendkeysfunction(2, "txtphno", "54654");
		Thread.sleep(1000);
		kdmc.sendkeysfunction(2, "txt4", "HARI");
		Thread.sleep(1000);
		kdmc.clicks(2, "txtgrndate1");
		Thread.sleep(2000);
		kdmc.clicks(1, "//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[3]/a");
		Thread.sleep(1000);
		
		kdmc.clicks(2, "txtgrndate2");
		Thread.sleep(2000);
		kdmc.clicks(1, "//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[6]/a");
		Thread.sleep(1000);
		
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,500)", "");
		
		kdmc.sendkeysfunction(2, "txtupto", "Yes");
		Thread.sleep(1000);
		
		JavascriptExecutor scroll1 = (JavascriptExecutor) driver;
		scroll1.executeScript("window.scrollBy(0,800)", "");
		
		kdmc.clicks(2, "txtgrndate");
		Thread.sleep(2000);
		kdmc.clicks(1, "//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[6]/a");
		Thread.sleep(1000);
		
		kdmc.sendkeysfunction(2, "txt22", "sa784512");
		Thread.sleep(1000);
		kdmc.sendkeysfunction(2, "txt29", "Separate Wards Are Allowcated");
		Thread.sleep(1000);
		
		kdmc.sendkeysfunction(2, "txt30", "5");
		
		kdmc.sendkeysfunction(2, "txtunit", "Availale");
		
		kdmc.sendkeysfunction(2, "txtgen", "Genral");
		kdmc.sendkeysfunction(2, "txtoth", "Nil");
		
		kdmc.sendkeysfunction(2, "txtroomis", "1500");
		kdmc.sendkeysfunction(2, "txtif", "Yes");
		
		kdmc.sendkeysfunction(2, "txt54", "04556654654");
		kdmc.sendkeysfunction(2, "txt55", "9878456510");
		kdmc.sendkeysfunction(2, "txtgeneral", "04565545151");
		kdmc.sendkeysfunction(2, "txt56", "04455466621");
		kdmc.sendkeysfunction(2, "txt58", "mam@gmail.com");
		kdmc.sendkeysfunction(2, "txt59", "NO");
		
		kdmc.sendkeysfunction(2, "txt61", "NO");
		kdmc.sendkeysfunction(2, "txtspecify", "All Wards");
		
		kdmc.sendkeysfunction(2, "txtoper", "200");
		kdmc.sendkeysfunction(2, "txticu", "201");
		kdmc.sendkeysfunction(2, "txticcu", "202");
		kdmc.sendkeysfunction(2, "txticcu1", "203");
		kdmc.sendkeysfunction(2, "txtemer", "204");
		kdmc.sendkeysfunction(2, "txtair", "Available");
		
		kdmc.sendkeysfunction(2, "txtelectro", "Yes");
		kdmc.sendkeysfunction(2, "txtmoni", "Yes");
		kdmc.sendkeysfunction(2, "txtres", "Yes");
		kdmc.sendkeysfunction(2, "txtsyphy", "Yes");
		kdmc.sendkeysfunction(2, "txtsteth", "Yes");
		kdmc.sendkeysfunction(2, "txtsterilizing", "Yes");
		kdmc.sendkeysfunction(2, "txtstainless", "Yes");
		kdmc.sendkeysfunction(2, "txtinstrument", "Yes");
		kdmc.sendkeysfunction(2, "txtot", "Yes");
		kdmc.sendkeysfunction(2, "txtxray", "Yes");
		kdmc.sendkeysfunction(2, "txttray", "Yes");
		kdmc.sendkeysfunction(2, "txtlamp", "Yes");
		kdmc.sendkeysfunction(2, "txtoxy", "Yes");
		
		kdmc.sendkeysfunction(2, "txtdress", "Yes");
		kdmc.sendkeysfunction(2, "txtiv", "Yes");
		kdmc.sendkeysfunction(2, "txtceiling", "Yes");
		kdmc.sendkeysfunction(2, "txt96", "MS");
		kdmc.sendkeysfunction(2, "txtnamequal", "Bala");
		kdmc.sendkeysfunction(2, "txt101", "Nithya");
		
		kdmc.sendkeysfunction(2, "txtfollow", "Yes");
		kdmc.sendkeysfunction(2, "txt126", "IV");
		
		
		
		kdmc.sendkeysfunction(2, "txtspecify1", "NO");
		kdmc.sendkeysfunction(2, "txt131", "Present");
		kdmc.sendkeysfunction(2, "txt132", "Present");
		kdmc.sendkeysfunction(2, "txt133", "Present");
		kdmc.sendkeysfunction(2, "txtremarks", "NO");
		
		kdmc.clicks(2, "btnSubmit");		
		Thread.sleep(3000);
		kdmc.clicks(1, "/html/body/div[8]/div/div/div[2]/button");

	}
	
	public void Send()
	{
		driver.get("http://182.18.161.229/Multihospital_New/InspectedList.aspx");
		kdmc.sendkeysfunction(1, "//*[@id='tblloadprivatehos_filter']/label/input", Nursinghome);

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
