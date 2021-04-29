package com.jbk;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPage {
	WebDriver driver = null;


	@BeforeMethod
	public void openBrower() {

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		// For open Browser
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("file:///F:/Offline%20Website/Offline%20Website/index.html");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	
	
	@Test 
	public void VerifyAlert(){
		
		driver.findElement(By.partialLinkText("Register")).click();;
		driver.findElement(By.id("name")).sendKeys("mangesh");
		driver.findElement(By.id("mobile")).sendKeys("1234567891");
		driver.findElement(By.id("email")).sendKeys("mangesh@gmail.com");
		driver.findElement(By.id("password")).sendKeys("qwerty");
	
		driver.findElement(By.tagName("button")).click();
		
		Alert al=driver.switchTo().alert();
		
		System.out.println(al.getText());
		
		al.accept();
		
	}
	
	@Test
	public void VerifyTitle() throws InterruptedException{
		driver.findElement(By.partialLinkText("Register")).click();;
		driver.findElement(By.id("name")).sendKeys("mangesh");
		driver.findElement(By.id("mobile")).sendKeys("1234567891");
		driver.findElement(By.id("email")).sendKeys("mangesh@gmail.com");
		driver.findElement(By.id("password")).sendKeys("qwerty");
	
		driver.findElement(By.tagName("button")).click();
		
		
		WebElement actualTitle = driver.findElement(By.partialLinkText("Membership"));
		String actTitle = actualTitle.getText();
		System.out.println("Actual Title" + actualTitle);

		String expTitle = "I already have a membership";
		Assert.assertEquals(actualTitle, expTitle);
		Thread.sleep(2000);
		System.out.println("Landed to login page");
		
			
			
		}

		
	}





