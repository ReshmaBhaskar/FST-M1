package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
		//AndroidDriver driver;
	    //AppiumDriver<MobileElement> driver = null;
		AndroidDriver<MobileElement> driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void beforeClass() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel4Emulator");
	        caps.setCapability("platformName", "Android");
	        //caps.setCapability("automationName", "UiAutomator2");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity", ".ui.TaskListsActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 5);
	    }

	    @Test
	    public void AddTasks() {
	        // Click on tasks
	       // driver.findElementByXPath("//android.widget.TextView[@content-desc='Tasks']").click();
	       
	        //implicit wait
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
	       //Add tasks
	        driver.findElementByAccessibilityId("Create new task").click();
	        
	        //implicit wait
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
	       
	        // Enter Task 1
	        String[] tasks = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep","Complete the second Activity Google Keep"};
	        
	        //For Each loop to loop through creating tasks
	        for(String task:tasks)
	        {
	        	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		        MobileElement firstTask = driver.findElementByXPath("//android.widget.EditText[@text='New Task']");
		        // Enter the text in the fields
		        firstTask.sendKeys(task);
		        driver.findElementByXPath("//android.widget.Button[3][@text='Save']");
		        //implicit wait
		        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	        }
	        
	        	        
	        
	        //Validate tasks
	     
	        MobileElement ValidateFirst = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Complete Activity with Google Tasks']/android.view.ViewGroup/android.widget.TextView");
	        String ValidateFirsttxt = ValidateFirst.getText();
	        Assert.assertEquals(ValidateFirsttxt,"Complete Activity with Google Tasks");
	        
	        MobileElement ValidateSecond = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Complete Activity with Google Keep']/android.view.ViewGroup/android.widget.TextView");
	        String ValidateSecondtxt = ValidateSecond.getText();
	        Assert.assertEquals(ValidateSecondtxt,"Complete Activity with Google Keep");
	    	        
	        MobileElement ValidateThird = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Complete the second Activity Google Keep']/android.view.ViewGroup/android.widget.TextView");
	        String ValidateThirdtxt = ValidateThird.getText();
	        Assert.assertEquals(ValidateThirdtxt,"Complete the second Activity Google Keep");
       
	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	}