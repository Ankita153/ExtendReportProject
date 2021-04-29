package com.jbk;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboradPage {
	class C{
		WebDriver driver = null;
		public WebElement actualDashborad;

		@BeforeMethod
		public void openBrower() {

			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
			// For open Browser
			driver = new ChromeDriver();
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("file:///F:/Offline%20Website/Offline%20Website/pages/examples/users.html");

		}


		@AfterMethod
		public void closeBrowser() {
			driver.close();
		}
		///CheckList Drop down
		@Test(priority=1)

		public void validateChecklistRadio() throws InterruptedException{
			driver.get("file:///F:/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
			Select state= new Select(driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));
			state.selectByVisibleText("Maharashtra");
			Thread.sleep(1000);
			state.selectByVisibleText("Delhi");
			state.selectByVisibleText("HP");
			state.selectByVisibleText("Punjab");
			
			
			System.out.println("print state1<<"+state);
			
			Thread.sleep(1000);
			state.selectByValue("Maharashtra");
			state.selectByValue("Delhi");
			state.selectByValue("HP");
			state.selectByValue("Punjab");
			
			System.out.println("print state2<<"+state.getOptions());
			
			List<WebElement> listOfOption=state.getOptions();
			
			for(WebElement option:listOfOption){
				
				option.getText();
				System.out.println("print state name..."+option.getText());
			}
				
				
			}

			
		///RadioButton
			@Test(priority=2)
			
			public void radiobutton(){
			driver.get("file:///F:/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
			WebElement male=driver.findElement(By.id("Male"));
			boolean maleRadio=male.isDisplayed();
			System.out.println("Is male button display...."+maleRadio);
			
			boolean maleRadio1=male.isEnabled();
			System.out.println("Is male button enable..."+maleRadio1);
			
			male.click();
			if(male.isSelected()){
				System.out.println("male is selected");
			}else{
				
				System.out.println("male is not selected...");
			}
			}
			
		@Test(priority=3)
			
			public void radiobutton1(){
			driver.get("file:///F:/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
			WebElement female=driver.findElement(By.id("Female"));
			boolean femaleRadio=female.isDisplayed();
			System.out.println("Is Female button display...."+femaleRadio);
			
			boolean femaleRadio1=female.isEnabled();
			System.out.println("Is Female button enable..."+femaleRadio1);
			
			female.click();
			if(female.isSelected()){
				System.out.println("Female is selected");
			}else{
				
				System.out.println("Female is not selected...");
			}
			}	
			


		//After login check NagivationMenu Text
		@Test(priority=4)
		public void verifyNavigationMenuText() throws InterruptedException{
			driver.get("file:///F:/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
			Thread.sleep(1000);
			String dashboard=driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[2]/a/span")).getText();
			Thread.sleep(1000);
			String user=driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).getText();
			Thread.sleep(1000);
			String operator=driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a/span")).getText();
			Thread.sleep(1000);
			String useFulLink=driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[5]/a")).getText();
			Thread.sleep(1000);
			String downloads=driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[6]/a/span")).getText();
			Thread.sleep(1000);
		    String Logout=driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[7]/a/span")).getText();

		    String a1[]={dashboard,user,operator,useFulLink,downloads,Logout};
		    
		    String a2[]={"Dashboard","Users","Operators","Useful Links","Downloads","Logout"};
		    Thread.sleep(1000);
		    Assert.assertEquals(a1,a2);
		    driver.close();
		    

		}


		@Test(priority=5)
		public void logout() throws InterruptedException{
		WebElement logOut = driver.findElement(By.id("/html/body/div/header/nav/div/ul/li/a"));
		logOut.click();
		Thread.sleep(5000);

		System.out.println("Logout Successfully");
		Thread.sleep(5000);
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);


		}






	}
}
