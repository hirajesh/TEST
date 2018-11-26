package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ExtendReportTest
{

	WebDriver driver;
	
String	actualurl="http://192.168.137.1:8083/Multihospital_New/SA_JSP/SA_Admin_Dashboard.jsp?Login=1";
	
	@Test
	public void Login() throws InterruptedException 
	{

		 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.137.1/multihospital_new/");
		driver.findElement(By.linkText("Admin Master")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtusername")).sendKeys("admin");
		driver.findElement(By.id("txtpassword")).sendKeys("admin123");
		Thread.sleep(4000);
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();
		Thread.sleep(5000);
		
		String currenturl=driver.getCurrentUrl();
		Assert.assertEquals(currenturl, actualurl);
	}
}
	/*public class AdvanceReporting {


		     @Test

		     public void verifySeleniumBlog(){

		           ExtentReports extent = ExtentReports.get(AdvanceReporting.class);
		           extent.init("C:\\Mukesh\\Report\\myreport.html", true);
		           extent.startTest("Verify Page Title");
		           WebDriver driver=new FirefoxDriver();
		           driver.manage().window().maximize();
		           extent.log(LogStatus.INFO, "Browser started");
		           driver.get("http://learn-automation.com");
		           extent.log(LogStatus.INFO, "Navigated to www.learn-automation.com");
		           String title=driver.getTitle();
		           extent.log(LogStatus.INFO, "Get the current title");
		            Assert.assertTrue(title.contains("Selenium"));
		            extent.log(LogStatus.PASS, "Title verified");
		            extent.attachScreenshot("C:\\Mukesh\\image1.jpg");
		            driver.quit();
		            extent.log(LogStatus.INFO, "Browser closed");
		            extent.endTest();
		     }


*/

