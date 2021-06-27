package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumActivity5 {
	
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	
	
  @Test
  public void sendSMS() {
		    driver.findElementByAccessibilityId("Start new conversation").click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("recipient_text_view")));     
		    driver.findElementById("recipient_text_view").sendKeys("+919674449307");
		    ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("compose_message_text")));     
		    driver.findElementById("compose_message_text").sendKeys("Hello From Appium Again!!!");
		    driver.findElementById("send_message_button_icon").click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text"))); 
		    String sentMessageText = driver.findElementByXPath("//android.widget.TextView[@text = 'Hello From Appium Again!!!']").getText();
		    Assert.assertEquals(sentMessageText, "Hello From Appium Again!!!");
  }
  
  @BeforeClass
  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("deviceName", "Pixel4Emulator");
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appPackage", "com.google.android.apps.messaging");
	    desiredCapabilities.setCapability("appActivity", ".ui.ConversationListActivity");
	    desiredCapabilities.setCapability("noReset", true);
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
	    wait = new WebDriverWait(driver,10);
	    
  }
  
  @AfterClass
  public void tearDown() {
    driver.quit();
  }
  
}
