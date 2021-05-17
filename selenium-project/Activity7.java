package SeleniumProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity7 {

		WebDriver driver;	
		
		@BeforeTest
		public void beforetest()
		{
			driver = new FirefoxDriver();
			driver.navigate().to("https://alchemy.hguy.co/jobs/jobs/");
		}
		
		
		@Test (priority=1)
		public void PostJob() throws InterruptedException
		{
			WebElement strPostJob = driver.findElement(By.linkText("Post a Job"));
			strPostJob.click();
			Thread.sleep(20);
			WebElement strJobHeader = driver.findElement(By.className("entry-title"));
			String strJobHeadertxt = strJobHeader.getText();
			Assert.assertEquals("Post a Job", strJobHeadertxt, "Did not navigate to 'Post a Job' page");
		
		}
		
		
		@Test (priority=2)
		public void EnterJobDetails() throws InterruptedException
		{
			WebElement strJobEmail = driver.findElement(By.id("create_account_email"));
			strJobEmail.sendKeys("abc@gmail.com");
			Thread.sleep(10);
			
			WebElement strJobTitle = driver.findElement(By.id("job_title"));
			strJobTitle.sendKeys("tester");
			Thread.sleep(10);
			
			//create an instance of select class
			Select strJobType = new Select(driver.findElement(By.id("job_type")));
			strJobType.selectByVisibleText("Full Time");
			Thread.sleep(10);
			
			//UNABLE TO ENTER DESCRIPTION TEXT!!!
			WebElement strJobDesc = driver.findElement(By.xpath("//div[@id ='mceu_16']"));
			strJobDesc.sendKeys("This is a test job");
			Thread.sleep(10);
			
			WebElement strJobAppEmail = driver.findElement(By.id("application"));
			strJobAppEmail.sendKeys("abc2@gmail.com");
			Thread.sleep(10);
			
			WebElement strJobComp = driver.findElement(By.id("company_name"));
			strJobComp.sendKeys("Testerabc");
			Thread.sleep(10);
			
			//add logo via windows browser dialog box
			WebElement strJobLogo = driver.findElement(By.id("company_logo"));
			strJobLogo.sendKeys("C:\\Users\\ReshmaBhaskar\\Desktop\\IMG_20180820_104405.jpg");
					
			WebElement strJobPrev = driver.findElement(By.xpath("//input[@value ='Preview']"));
			strJobPrev.click();		
		
		}
		
		
		
		/* @Test (priority=3)
		public void VerifyJobPosted()throws InterruptedException		
		{
			//select job
			WebElement strJobLink = driver.findElement(By.tagName("h3"));
			strJobLink.click();					
			Thread.sleep(30);			
			
			//click on apply button	
			WebElement ApplyJob = driver.findElement(By.xpath("//input[@value = 'Apply for job']"));	
			ApplyJob.click();
			
			//print email ID
			WebElement Email = driver.findElement(By.xpath("//a[@class='job_application_email']"));
			String Emailtxt = Email.getText();
			if (Emailtxt!="")
			{
				Assert.assertEquals(Emailtxt, true);
				System.out.println("Email ID for the job applied is -" + Emailtxt);
			}
				else
				{
				System.out.println("Email ID for job is empty");
					
			}
			
		}
		
		
		@AfterTest
		public void aftertest()
		{
			driver.close();
		}*/
		
	}

