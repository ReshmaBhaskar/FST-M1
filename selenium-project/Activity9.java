package SeleniumProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity9 {

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
		
		
		@Test (priority=2)
		public void CreateJobListing() throws InterruptedException
		{
			String Posttitle = "TestTitle";
			
			WebElement strJobList = driver.findElement(By.linkText("Job Listings"));
			strJobList.click();
			Thread.sleep(10);
			
			WebElement strJobNew = driver.findElement(By.linkText("Add New"));
			strJobNew.click();
			Thread.sleep(10);
						
			WebElement strUser = driver.findElement(By.id("post-title"));
			strUser.sendKeys(Posttitle);
			Thread.sleep(5);
			
			WebElement strApp = driver.findElement(By.id("_application"));
			strApp.sendKeys("abhiram@cklabs.com");
			Thread.sleep(5);
			
			WebElement strCom = driver.findElement(By.id("_company_website"));
			strCom.sendKeys("www.abc.com");
			Thread.sleep(5);
			
			WebElement strdate = driver.findElement(By.id("_job_expires"));
			strdate.sendKeys("July 1, 2021");
			Thread.sleep(5);
			
			WebElement strLog = driver.findElement(By.xpath("//span[@class='file_url']/button[1]"));
			strLog.click();
			Thread.sleep(5);
			
			WebElement strthumb = driver.findElement(By.xpath("//div[@class='thumbnail']"));
			strthumb.click();
			Thread.sleep(5);
			
			WebElement strUseFile = driver.findElement(By.linkText("Use file"));
			strUseFile.click();
			Thread.sleep(5);
			
			WebElement strUsePub = driver.findElement(By.linkText("Publish"));
			strUsePub.click();
			Thread.sleep(5);
			
			WebElement strUsePub2 = driver.findElement(By.linkText("Publish"));
			strUsePub2.click();
			Thread.sleep(15);
			
			
			WebElement strUsePost = driver.findElement(By.linkText(Posttitle));
			String strUsePubTxt = strUsePost.getText();	
			Assert.assertEquals(Posttitle, strUsePubTxt, "Job - '" +Posttitle+ "' was not created");		
		}
		
				
		@AfterTest
		public void aftertest()
		{
			driver.close();
		}
		
	}

