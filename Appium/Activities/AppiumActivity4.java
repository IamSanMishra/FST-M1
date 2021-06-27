package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AppiumActivity4 {
	
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	DesiredCapabilities caps;
	
  @Test
  public void addContact() {
	  //driver.findElementById("add_contact_button").click();
	  driver.findElementById("floating_action_button").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text = 'Create new contact']")));     
	  driver.findElementByXPath("//android.widget.EditText[@text = 'First name']").sendKeys("Aaditya");
	  driver.findElementByXPath("//android.widget.EditText[@text = 'Last name']").sendKeys("Varma");
	  driver.findElementByXPath("//android.widget.EditText[@text = 'Phone']").sendKeys("999148292");
	  driver.findElementById("editor_menu_save_button").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
	  Assert.assertTrue(driver.findElementById("toolbar_parent").isDisplayed());
	  Assert.assertTrue(driver.findElementByAccessibilityId("Aaditya Varma").isDisplayed());
	  
  }
  
    
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	    caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "Pixel4Emulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("noReset", true);
	    caps.setCapability("appPackage", "com.android.contacts");
	    caps.setCapability("appActivity", ".activities.PeopleActivity");
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
	    wait = new WebDriverWait(driver, 10);
	    
  }
  
  
  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
