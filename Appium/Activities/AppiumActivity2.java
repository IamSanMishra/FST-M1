package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AppiumActivity2 {
	
	AndroidDriver<MobileElement> driver;
	DesiredCapabilities caps;
	WebDriverWait wait;
	
  @Test
  public void getPageTitle() throws MalformedURLException, InterruptedException {
	  caps.setCapability("appPackage", "com.android.chrome");
	  caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	  URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	  driver = new AndroidDriver<MobileElement>(remoteUrl,caps);
	  wait = new WebDriverWait(driver,10);
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://www.training-support.net/");
	  String homePageTitle = driver.findElementByXPath("//android.view.View[@text = 'Training Support']").getText();
	  System.out.println(homePageTitle);
	  driver.findElementByXPath("//android.view.View[@text = 'About Us']").click();
	  //Thread.sleep(2500);
	  String newPageTitle = driver.findElementByXPath("//android.view.View[@text = 'About Us']").getText();
	  System.out.println(newPageTitle);
	  Assert.assertEquals(homePageTitle,"Training Support");
	  Assert.assertEquals(newPageTitle,"About Us");
  }
    
  
  @BeforeClass
  public void setUp() throws MalformedURLException {
	    caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "Pixel4Emulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("noReset", true);
	   }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
