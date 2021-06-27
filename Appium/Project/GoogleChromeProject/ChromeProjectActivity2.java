package GoogleChromeProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ChromeProjectActivity2 {
	
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
	
	@BeforeTest	
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_4_API_28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
	  
	}
	
	@BeforeMethod
	public void openLogInURL() {
	        driver.get("https://www.training-support.net/selenium");
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
			driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
			driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
			driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
			driver.findElementByXPath("//android.view.View[contains(@text,'Login')]").click();
	           }
  

	  @Test(priority=1)
	  public void chromeLogin() throws InterruptedException {
	     	              
	         Thread.sleep(5000);
	         wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[1]")));
	         driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("admin");
	         Thread.sleep(3000);
	         driver.findElementByXPath("//android.widget.EditText[2]").sendKeys("password");
	         Thread.sleep(3000);
	         driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	         Thread.sleep(3000);
	         wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
	         String message=driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();
	         System.out.println(message);
	         Assert.assertEquals("Welcome Back, admin", message);
	                       		       
	     }
	     
	     @Test(priority=2)
	     public void chromeLoginInvalid() throws InterruptedException {
	         Thread.sleep(5000);
	         wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[1]")));
	         driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("sk");
	         Thread.sleep(3000);
	         driver.findElementByXPath("//android.widget.EditText[2]").sendKeys("sk@123");
	         Thread.sleep(3000);
	         driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	         Thread.sleep(3000);
	         wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
	         String message=driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();
	         System.out.println(message);
	         Assert.assertEquals("Invalid Credentials", message);
	                       		       
	     }
  
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
}