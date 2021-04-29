package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver = null;
	private WebElement actualDashborad;

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

	@Test(priority = 1)
	public void test1() throws InterruptedException {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver","F://chromedriver.exe");
		// For open Browser
		// WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		// driver.get("file:///F:/Offline%20Website/Offline%20Website/index.html");

		WebElement uname = driver.findElement(By.id("email"));
		uname.sendKeys("kiran@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		

		WebElement button = driver.findElement(By.xpath("//button"));
		button.click();
	

		String actualData = driver.getTitle();
		System.out.println("print actual data.." + actualData);
		String expDta = "JavaByKiran | Dashboard";
		Assert.assertEquals(actualData, expDta);
	}

	@Test(priority = 2)

	public void heading() throws InterruptedException {

		WebElement actualHeading = driver.findElement(By.tagName("b")); /// html/body/div/div[1]/a/b
		String actHeading = actualHeading.getText();

		System.out.println("actual heading.." + actHeading);

		String expHeading = "Java By Kiran";

		Thread.sleep(2000);
		Assert.assertEquals(actHeading, expHeading);
		
	}

	@Test(priority = 3)

	public void subHeading() throws InterruptedException {

		WebElement actualsubHeading = driver.findElement(By.tagName("h4"));
		String actsubHeading = actualsubHeading.getText();
		System.out.println("actual subHeading.." + actsubHeading);

		String expHeading = "JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(actsubHeading, expHeading);
		Thread.sleep(2000);
	}

	@Test(priority = 4)

	public void sessionHeading() throws InterruptedException {
		WebElement actualsessionHeading = driver.findElement(By.xpath("//p[contains(text(),'session')]"));
		String actsessHeading = actualsessionHeading.getText();
		System.out.println("Actual session Heading" + actsessHeading);

		String expHeading = "Sign in to start your session";
		Assert.assertEquals(actsessHeading, expHeading);
		Thread.sleep(2000);
	}

	@Test(priority = 5)

	public void endheading() throws InterruptedException {

		WebElement actualendHeading = driver.findElement(By.partialLinkText("Register"));
		String actendHeading = actualendHeading.getText();
		System.out.println("Actual End Heading" + actendHeading);

		String expHeading = "Register a new member";
		Assert.assertEquals(actendHeading, expHeading);
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void wrongEmailError() throws InterruptedException {
		WebElement uname = driver.findElement(By.id("email"));
		uname.sendKeys("a@gmail.com");

		WebElement button = driver.findElement(By.xpath("//button"));
		button.click();
		WebElement errorMsg = driver.findElement(By.id("email_error"));
		String errorMsg1 = errorMsg.getText();
		System.out.println("actual error msg.." + errorMsg1);
		String expMsg = "Please enter email as kiran@gmail.com";
		Assert.assertEquals(errorMsg1, expMsg);
		Thread.sleep(2000);
		
	}

	
	@Test(priority=7)
	
	public void blankEmail() throws InterruptedException{
		WebElement uname = driver.findElement(By.id("email"));
		uname.sendKeys(" ");

		WebElement button = driver.findElement(By.xpath("//button"));
		button.click();
		WebElement errorMsg = driver.findElement(By.id("email_error"));
		String errorMsg1 = errorMsg.getText();
		System.out.println("actual error msg.." + errorMsg1);
		String expMsg = "Please enter valid email.";
		Assert.assertEquals(errorMsg1, expMsg);
		Thread.sleep(2000);
		
		
		}
@Test(priority=8)

public void image(){
	WebElement image=driver.findElement(By.xpath("//img"));
	boolean flag= image.isDisplayed();
	if(flag==true){
		System.out.println("Image displayed");
		
	}else{
		System.out.println("Not displayed");
	}
	Assert.assertEquals(flag, true);
	
}

@Test(priority=9)
public void dashboard() throws InterruptedException{
	driver.get("file:///F:/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
 WebElement dashboard =driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1"));

String actDashborad = actualDashborad.getText();

	System.out.println("actual Dashboard.." +actDashborad );

	String expDashboard = "Dashboard";

	Thread.sleep(2000);
	Assert.assertEquals(actDashborad, expDashboard);
	

}
@Test(priority=10)
public void Dashimage(){
	driver.get("file:///F:/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
	WebElement Dashimage=driver.findElement(By.xpath("/html/body/div/aside/section/div/div[1]/img"));
	boolean flag= Dashimage.isDisplayed();
	if(flag==true){
		System.out.println("Image displayed");
		
	}else{
		System.out.println("Not displayed");
	}
	Assert.assertEquals(flag, true);
	
	
	
}
  }

