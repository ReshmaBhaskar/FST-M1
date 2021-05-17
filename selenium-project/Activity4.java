package SeleniumProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {

		
		WebDriver driver;	
		
		@BeforeTest
		public void beforetest()
		{
			driver = new FirefoxDriver();
			driver.navigate().to("https://alchemy.hguy.co/jobs");
		}
		
		@Test
		public void GetSecondHeader()
		{
			WebElement strheader2 = driver.findElement(By.tagName("h2"));
			String strheader2txt = strheader2.getText();
			System.out.println("Header 2 txt is - " + strheader2txt);
			Assert.assertEquals("Quia quis non", strheader2txt, "Header2 is not as expected");
					
		}

		@AfterTest
		public void aftertest()
		{
			driver.close();
		}
	}

