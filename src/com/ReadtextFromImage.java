package com;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.asprise.util.ocr.OCR;

public class ReadtextFromImage {

	WebDriver driver;

	 @BeforeTest
	  public void setUpDriver() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","D:\\Selenium\\add jar files\\chromedriver.exe");; 
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   Thread.sleep(4000);
	   scrollthewindow();
	 	  }
	  public void scrollthewindow() {

			JavascriptExecutor scroll = (JavascriptExecutor) driver;
			scroll.executeScript("window.scrollBy(0,200)", "");

		}

	 @Test
	 public void start() throws IOException, InterruptedException{

	 /*Navigate to http://www.mythoughts.co.in/2013/10/extract-and-verify-text-from-image.html page
	  * and get the image source attribute
	  *  
	  */  
		   Thread.sleep(3000);
	 driver.get("http://www.mythoughts.co.in/2013/10/extract-and-verify-text-from-image.html");
	 Thread.sleep(3000);
	 String imageUrl=driver.findElement(By.xpath("//*[@id='post-body-5614451749129773593']/div[1]/div[1]/div/a/img")).getAttribute("src");
	 System.out.println("Image source path : \n"+ imageUrl);

	 URL url = new URL(imageUrl);
	 Thread.sleep(3000);
	 Image image = ImageIO.read(url);
	 Thread.sleep(3000);
	 String s = new OCR().recognizeCharacters((RenderedImage) image);
	 System.out.println("Text From Image : \n"+ s);
	 System.out.println("Length of total text : \n"+ s.length());
	 driver.quit();

	 /* Use below code If you want to read image location from your hard disk   
	  *   
	   BufferedImage image = ImageIO.read(new File("Image location"));   
	   String imageText = new OCR().recognizeCharacters((RenderedImage) image);  
	   System.out.println("Text From Image : \n"+ imageText);  
	   System.out.println("Length of total text : \n"+ imageText.length());   

	   */ 
	}

}
