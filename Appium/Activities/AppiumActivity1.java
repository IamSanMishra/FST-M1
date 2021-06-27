package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class AppiumActivity1 {
	
	AndroidDriver<MobileElement> driver;
	DesiredCapabilities caps;
	
  @Test
  public void getCalculator() throws MalformedURLException {
		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		    caps.setCapability("appPackage", "com.android.calculator2");
		    caps.setCapability("appActivity", ".Calculator");
		    driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
		    System.out.println("Calculator is open");
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
