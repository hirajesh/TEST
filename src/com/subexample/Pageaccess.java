package com.subexample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Quality Analyst Create on 26-04-2018
 */
public class Pageaccess {

	WebDriver driver;

	public Pageaccess(WebDriver driver) {
		this.driver = driver;
	}

	By Usernme = By.id("txtusername");
	By Password = By.id("txtpassword");
	By Login = By.id("btnSubmit");

	public void ChooseLogin(String Loginname) {
		driver.findElement(By.linkText(Loginname)).click();

	}

	/**
	 * @param DESCRIPTIONS
	 *            Code [Login Code] Created On 26-04-2018
	 * 
	 */
	public void TypeUsernamePassword(String userID, String userpassword) throws InterruptedException {
		driver.findElement(Usernme).sendKeys(userID);
		driver.findElement(Password).sendKeys(userpassword);
		Thread.sleep(4000);
		WebElement login = driver.findElement(Login);
		Clickactions(login);

	}

	/**
	 * @param DESCRIPTIONS
	 *            Code [CLick Using Action Method To Avoid Clickable Point
	 *            Exception] Created On 26-04-2018
	 * 
	 */
	public void Clickactions(WebElement Modifiers) {
		Actions action = new Actions(driver);
		action.moveToElement(Modifiers).click().perform();
	}

	public void SIGNOUT() throws InterruptedException {
		try {
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println(" ");
			System.out.println("* SIGN OUT SUCCESSFULLY");
		} catch (Exception e) {

			// e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(6000);
			driver.findElement(By.xpath("/html/body/header/div/div/nav/div/ul/li[2]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println(" ");
			System.out.println("* SIGN OUT SUCCESSFULLY");
		}

	}

	/**
	 * @param DESCRIPTIONS
	 *            Code [Scroll The Window For Finding The Elements] Created On
	 *            26-04-2018
	 * 
	 */
	public void scrollthewindow() {

		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,200)", "");

	}

	/**
	 * @param DESCRIPTIONS
	 *            [Click Operations in ElementS Using ID<XPATH,LINKTEXT] Created
	 *            On 26-04-2018
	 * @throws InterruptedException 
	 * 
	 */

	public void clicks(int xpathID, String modifier) {

		// 1.Xpath sendkeys 2.Id Sendkeys,3.Linktext

		switch (xpathID) {

		case 1:
			
			try {
				driver.findElement(By.xpath(modifier)).click();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 2:
			
			try {
				driver.findElement(By.id(modifier)).click();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 3:
			
			try {
				driver.findElement(By.linkText(modifier)).click();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

	/**
	 * @param DESCRIPTIONS
	 * @param [SendKeys
	 *            Operations in ElementS Using <ID>,<XPATH>,<LINKTEXT>]
	 * @param 26-4-2018
	 * @throws InterruptedException 
	 */
	public void sendkeysfunction(int ID, String modifier1, String PassValues)  {

		// 1.Xpath sendkeys 2.Id Sendkeys

		switch (ID) {

		case 1:
			
			try {
				driver.findElement(By.xpath(modifier1)).sendKeys(PassValues);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			
			try {
				driver.findElement(By.id(modifier1)).sendKeys(PassValues);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	public void SelectFunction(WebElement modifier2, int index) {

		Select Seletvalues = new Select(modifier2);
		Seletvalues.selectByIndex(index);

	}

}
