package GoogleTasksAndGoogleKeepProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	AppiumDriver<MobileElement> driver = null;


	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel4");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);


		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
	}
	@Test
	public void addNewTask() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		String[] tasksToAdd = {
				"Complete Activity with Google Tasks",
				"Complete Activity with Google Keep",
				"Complete the second Activity Google Keep"

		};

		for(String taskToAdd: tasksToAdd) {
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
			driver.findElementByAccessibilityId("Create new task").click();
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));	
			driver.findElementById("add_task_title").sendKeys(taskToAdd);
			driver.findElementById("add_task_done").click();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<MobileElement> tasksAdded = driver.findElementsByXPath("//android.widget.FrameLayout[@resource-id='task_item_layout']");
		Assert.assertEquals(tasksAdded.size(), 3);
	}


	@AfterClass 
	public void closeDriver() {
		driver.quit();
	}
	
}
