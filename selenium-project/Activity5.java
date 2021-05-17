package SeleniumProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Activity5 {

	WebDriver driver;	
	
	@BeforeTest
	public void beforetest()
	{
		driver = new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs");
	}
	
	@Test
	public void NavigateToJob()
	{
		WebElement strJobLink = driver.findElement(By.linkText("Jobs"));
		strJobLink.click();
		//driver.wait(30);
		WebElement strheader = driver.findElement(By.xpath("//h1[@class='entry-title']"));				
		String strheadertxt = strheader.getText();
		System.out.println(strheadertxt);
		Assert.assertEquals("Jobs", strheadertxt, "Did not navigate to Jobs page");		
		
	}
	

	@AfterTest
	public void aftertest()
	{
		driver.close();
	}
}
