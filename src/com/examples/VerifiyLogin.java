package com.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.subexample.Pageaccess;

public class VerifiyLogin {

	int a=0;
	String Name="Bala";
	WebDriver driver;

	@Test
	public void loginVerifiy() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.137.1/multihospital_new/");
		Thread.sleep(3000);
	
		
		Pageaccess KDMC = new Pageaccess(driver);
		
		
		KDMC.ChooseLogin("CMS");
		Thread.sleep(2000);
		KDMC.TypeUsernamePassword("bala","123");
		Thread.sleep(3000);
		KDMC.scrollthewindow();
		KDMC.SIGNOUT();
		driver.close();

	}

}
