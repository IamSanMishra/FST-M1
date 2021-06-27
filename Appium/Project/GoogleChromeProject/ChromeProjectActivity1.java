package GoogleChromeProject;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ChromeProjectActivity1 {
	
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
  
  
  @Test
  public void beforeClass() throws MalformedURLException {
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
	    driver.get("https://www.training-support.net/selenium");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    MobileElement title = driver.findElementByXPath("//android.view.View[2][@text='Selenium']");
		String pageTitle = title.getText();
		System.out.println("The page Title is: " + pageTitle);
		Assert.assertEquals(pageTitle, "Selenium");
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
		driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//To-Do List page
		MobileElement todoTitle = driver.findElementByXPath("//android.view.View[2][@text='To-Do List']");
		String todoListTitle = todoTitle.getText();
		System.out.println("The page Title is: " +todoListTitle);
		Assert.assertEquals(todoListTitle, "To-Do List");

		String[] tasksToAdd = {
				"Add Task 1",
				"Add Task 2"
		};

		for(String addTasks: tasksToAdd) {
			driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").click();
			driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys(addTasks);
			driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}

		driver.findElementByXPath("//android.view.View[@text='Add Task 1']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[@text='Add Task 2']").click();

		MobileElement clearListBtn = driver.findElementByXPath("//android.view.View[3][@class='android.view.View']");
		clearListBtn.click();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
