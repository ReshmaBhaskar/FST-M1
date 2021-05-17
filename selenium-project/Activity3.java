package SeleniumProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver;	
	
	@BeforeTest
	public void beforetest()
	{
		driver = new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs");
	}
	
	@Test
	public void GetURL_Img()
	{
		WebElement strIMG = driver.findElement(By.xpath("//article[@id ='post-16']/header/div/img"));
		String strIMGURL = strIMG.getAttribute("src");
		System.out.println("Image URL is - " + strIMGURL);
		Assert.assertNotNull(strIMGURL);
				
	}

	@AfterTest
	public void aftertest()
	{
		driver.close();
	}

}


