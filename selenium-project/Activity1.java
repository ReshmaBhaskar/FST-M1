package SeleniumProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Activity1 {

		// TODO Auto-generated method stub

			WebDriver driver;
		    
		    @BeforeTest
		    public void BeforeTest() 
		    {
		        //Create a new instance of the Firefox driver
		        driver = new FirefoxDriver();
		        
		        //Open browser using navigate function 
		        driver.navigate().to("https://alchemy.hguy.co/jobs");
		    }

		    @Test
		    public void FetchTitle() 
		    {
		        // Check the title of the page
		        String title = driver.getTitle();
		            
		        //Print the title of the page
		        System.out.println("Page title is: " + title);
		            
		            //Assertion for page title
		        Assert.assertEquals("Alchemy Jobs – Job Board Application", title);
		                    
		      }

		    @AfterTest
		    public void AfterTest() 
		    {
		        //Close the browser
		        driver.close();
		    }

		}
