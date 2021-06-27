package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AppiumActivity3 {
	
	AndroidDriver<MobileElement> driver;
	
	
  @Test
  public void addNum() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("op_add").click();
	  driver.findElementById("digit_9").click();
	  driver.findElementById("eq").click();
	  String result = driver.findElementById("result").getText();
	  System.out.println(result);
	  Assert.assertEquals(result,"14");
  }
  
  @Test
  public void subNum() {
	  driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("op_sub").click();
	  driver.findElementById("digit_5").click();
	  driver.findElementById("eq").click();
	  String result = driver.findElementById("result").getText();
	  System.out.println(result);
	  Assert.assertEquals(result,"5");
  }
  
  @Test
  public void mulNum() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("op_mul").click();
	  driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("eq").click();
	  String result = driver.findElementById("result").getText();
	  System.out.println(result);
	  Assert.assertEquals(result,"500");
  }
  
  @Test
  public void divNum() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("op_div").click();
	  driver.findElementById("digit_2").click();
	  driver.findElementById("eq").click();
	  String result = driver.findElementById("result").getText();
	  System.out.println(result);
	  Assert.assertEquals(result,"25");
  }
  
  
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "Pixel4Emulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("noReset", true);
	    caps.setCapability("appPackage", "com.android.calculator2");
	    caps.setCapability("appActivity", ".Calculator");
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
