package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestID {


WebDriver driver;

@Test
public void Login() throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://182.18.161.229:8081/Finance/Calendar_event.jsp#!");
	driver.findElement(By.linkText("Reception")).click();
	driver.findElement(By.id("txtusername")).sendKeys("amirtha");
	driver.findElement(By.id("txtpassword")).sendKeys("123");
	Thread.sleep(4000);
	WebElement submit=driver.findElement(By.id("btnSubmit"));
	Actions action=new Actions(driver);
	action.moveToElement(submit).click().perform();
	Thread.sleep(3000);
	
	driver.findElement(By.cssSelector("body > div.row > div > div > aside.left-side.sidebar-offcanvas > section > ul > li:nth-child(3) > a")).click();
	 Thread.sleep(2000);
	 
	 driver.findElement(By.id("btnadd")).click();
		Thread.sleep(4000);
		
		WebElement allid=driver.findElement(By.xpath("//*['@id']"));
	

		for(int i=0;i<=50;i++)
		{
		
		String sd=	allid.getAttribute(String.valueOf(allid));
		String sd1=allid.getText();
		//String sd1=	allid.getAttribute(String.valueOf(allid)).toString();
			System.out.println(sd);
			System.out.println(sd1);
			
		}
}

}

/*640x480
800x600*/
