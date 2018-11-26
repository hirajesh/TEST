package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestCase {

	WebDriver driver;
	String[] Testcase = {"TEST CASE 2:To Verify Enter InValid Username Valid Pasword Working Or Not",
			"TEST CASE 3:To Verify Enter Valid Username Invalid Password Working Or Not", "TEST CASE 4:To Verify Enter Empty Username Valid Password Working Or Not", "TEST CASE 5:To Verify Enter Valid Username Empty Password Working Or Not",
			"TEST CASE 6:To Verify Enter CS Username Valid Password Working Or Not", "TEST CASE 7:To Verify Enter Valid Username CS Password Working Or Not" };
	String[] Uname = {"123", "shyam", " ", "shyam", "SHYAM", "shyam", };
	String[] Pword = {"123", "1234", "123", " ", "123", "SHYAM", };
	
	String ExpectedURL="http://182.18.161.229/CHMSREV/DoctorGagets";
	String BaseURL="http://182.18.161.229/CHMSREV/Account/Login?Role=Doctor";
	String ExpectedURL1="http://182.18.161.229/CHMSREV/Account/Login";


	@Test
	public void Login() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(BaseURL);
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("shyam");
		driver.findElement(By.id("Password")).sendKeys("123");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[3]/div[2]/button")).click();
		Thread.sleep(2000);
		String CurrentURL=driver.getCurrentUrl();
		System.out.println("  ");
		
		if(CurrentURL.equals(ExpectedURL))
		{
			
			System.out.println("TEST CASE 1:To Verify Enter InValid Username Valid Pasword Working Or Not PASSED");
			driver.findElement(By.xpath("/html/body/section/header/nav/div[2]/div[2]/ul/li[3]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/section/header/nav/div[2]/div[2]/ul/li[3]/ul/li[2]/div[3]/a")).click();
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("TEST CASE 1:To Verify Enter InValid Username Valid Pasword Working Or Not FAILED");
		}
		driver.get(BaseURL);
		for (int i = 0; i < 6; i++) 
		{
		//	System.out.println(i+" "+Testcase[i]);
			driver.findElement(By.id("Email")).sendKeys(Uname[i]);
			driver.findElement(By.id("Password")).sendKeys(Pword[i]);
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[3]/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[4]/div[2]/button")).click();
			}
			
			Thread.sleep(2000);
			Thread.sleep(2000);
			String CurrentURL1=driver.getCurrentUrl();
			System.out.println("  ");
		
			
			if(CurrentURL1.equals(ExpectedURL1))
			{
				System.out.println(Testcase[i] +" "+ "PASSED");
				
			
			}
			else
			{
				System.out.println(Testcase[i] +" "+ "FAILED");
				/*driver.findElement(By.xpath("/html/body/section/header/nav/div[2]/div[2]/ul/li[3]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/section/header/nav/div[2]/div[2]/ul/li[3]/ul/li[2]/div[3]/a")).click();*/
				Thread.sleep(2000);
				driver.get(BaseURL);
			}
			
			Thread.sleep(2000);
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Password")).clear();
			Thread.sleep(2000);
		}
		System.out.println("  ");
		
		driver.close();
	}

}
