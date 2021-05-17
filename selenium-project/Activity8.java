package SeleniumProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity8 {

		WebDriver driver;	
		
		@BeforeTest
		public void beforetest()
		{
			driver = new FirefoxDriver();
			driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin");
		}
		
		
		@Test (priority=1)
		public void BackEndLogin() throws InterruptedException
		{
			WebElement strUser = driver.findElement(By.id("user_login"));
			strUser.sendKeys("root");
			Thread.sleep(5);
			
			WebElement strPass = driver.findElement(By.id("user_pass"));
			strPass.sendKeys("pa$$w0rd");
			Thread.sleep(5);
			
			WebElement strLogIn = driver.findElement(By.id("Log In"));
			strLogIn.click();
			Thread.sleep(20);
			
			WebElement strLog = driver.findElement(By.linkText("Alchemy Jobs"));
			String strLogTxt = strLog.getText();
			Assert.assertEquals("Alchemy Jobs", strLogTxt, "Did not navigate to 'Alchemy Jobs' page");
		
		}
		
				
		@AfterTest
		public void aftertest()
		{
			driver.close();
		}
		
	}

