package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2{
	//AndroidDriver driver;
    AppiumDriver<MobileElement> driver = null;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @Test(priority=1)
    public void openbr() {
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
    	
	 // Open the browser with the URL
	    driver.get("https://www.training-support.net/");
	
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    // Locate page title on homepage and print it
	    String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
        
	    System.out.println("Title on Homepage: " + pageTitle);
        
        MobileElement aboutButton = driver.findElementById("about-link");
        		aboutButton.click();
 
        String newPageTitle = driver
                .findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]")
                .getText();
 
        System.out.println("Title on new page: " + newPageTitle);
 
        // Assertions
        Assert.assertEquals(pageTitle, "Training Support");
        Assert.assertEquals(newPageTitle, "About Us");
    }
 
    @Test(priority=2)
    public void takeScreenshot() throws Exception {
        String timeStamp;
        File screenShotName;

        //Take screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //This specifies the location the screenshot will be saved
        screenShotName = new File("src/test/resources/screenshot.jpg");
        
        //This will copy the screenshot to the file created
        FileUtils.copyFile(scrFile, screenShotName);

        //Set filepath for image
        String filePath = "../"+screenShotName.toString();
    }
    
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}




