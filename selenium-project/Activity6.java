package SeleniumProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity6 {

		WebDriver driver;	
		
		@BeforeTest
		public void beforetest()
		{
			driver = new FirefoxDriver();
			driver.navigate().to("https://alchemy.hguy.co/jobs");
		}
		
		
		@Test (priority=1)
		public void NavigateToJob() throws InterruptedException
		{
			WebElement strJobLink = driver.findElement(By.linkText("Jobs"));
			strJobLink.click();
			Thread.sleep(50);
			WebElement strheader = driver.findElement(By.xpath("//h1[@class='entry-title']"));				
			String strheadertxt = strheader.getText();
			System.out.println(strheadertxt);
			Assert.assertEquals("Jobs", strheadertxt, "Did not navigate to Jobs page");		
			
		}
		
		
		@Test (priority=2)
		public void SearchJob() throws InterruptedException
		{
			WebElement strJobLink = driver.findElement(By.id("search_keywords"));
			strJobLink.sendKeys("Virtual Manufacturing Engineer");
			Thread.sleep(50);
			WebElement SearchJobs = driver.findElement(By.xpath("//input[@value='Search Jobs']"));	
			SearchJobs.click();
			Thread.sleep(50);
			
			//validate if any jobs are present or not & terminate if no jobs are there
			WebElement SearchJobsRes = driver.findElement(By.xpath("//ul[@class = 'job_listings']/li]"));
			//xpath - //ul[@class = "job_listings"]/li[contains(text(),"no listings")]
			String SearchJobRestxt = SearchJobs.getText();		
			Assert.assertEquals("There are no listings matching your search.", SearchJobRestxt,"No Jobs Present");
			
		}
		
		@Test (priority=3)
		public void ApplyForJob()throws InterruptedException		
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
		}
		
	}

