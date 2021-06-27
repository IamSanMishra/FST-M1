package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AppiumActivity6 {
	
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	
  @Test
  public void verifyLazyLoadingPage() {
	  
	  //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text() = 'Lazy Loading']")));  
	  List<MobileElement> numberOfImages = driver.findElementsByClassName("android.widget.Image");
	  System.out.println("The number of images displayed currently are "+ numberOfImages.size());
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).flingForward().scrollTextIntoView(\"helen\")"));
	  numberOfImages = driver.findElementsByClassName("android.widget.Image");
	  System.out.println("The number of images displayed currently are "+ numberOfImages.size());
  }
  
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("deviceName", "Pixel4Emulator");
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    //desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appPackage", "com.android.chrome");
	    desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main"); 
	    desiredCapabilities.setCapability("noReset", true);
	    
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
	    wait = new WebDriverWait(driver,10);
	    driver.get("https://www.training-support.net/selenium/lazy-loading");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
