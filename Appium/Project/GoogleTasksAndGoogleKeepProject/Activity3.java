package GoogleTasksAndGoogleKeepProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.interactions.Actions;
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


public class Activity3 {
	AppiumDriver<MobileElement> driver = null;
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel4");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
	}
	@Test
	public void noteWithReminder() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		Actions action = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));
		MobileElement addNoteBtn = driver.findElementByAccessibilityId("New text note");
		addNoteBtn.click();

		//Adding note
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("browse_note_interior_content")));
		MobileElement addTitle = driver.findElementById("browse_note_interior_content");
		addTitle.click();
		action.sendKeys(" Appium Avtivity 3").perform();

		MobileElement addDescNote = driver.findElementById("edit_note_text");
		addDescNote.click();
		action.sendKeys("  Completed Appium Avtivity 3").perform();

		//Setting reminder
		MobileElement reminderBtn = driver.findElementByAccessibilityId("Reminder");
		reminderBtn.click();

		//Waiting for afternoon reminder
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.ViewGroup[1][@class='android.view.ViewGroup']")));

		MobileElement datePicker = driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/bs_list_view']/android.widget.LinearLayout");
		datePicker.click();

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("save")));

		MobileElement timeSpinner = driver.findElementById("time_spinner");
		timeSpinner.click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("reminder_time_afternoon")));

		MobileElement afternoonBtn = driver.findElementById("reminder_time_afternoon");
		afternoonBtn.click();

		MobileElement saveBtn = driver.findElementById("save");
		saveBtn.click();

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("reminder_chip")));

		Assert.assertTrue(driver.findElementById("reminder_chip")!=null);
		MobileElement backBtn = driver.findElementByAccessibilityId("Open navigation drawer");
		backBtn.click();

		MobileElement addedNote = driver.findElementById("browse_note_interior_content");
		Assert.assertTrue(addedNote.isDisplayed());

		Assert.assertTrue(driver.findElementById("index_note_title").isDisplayed());
		Assert.assertTrue(driver.findElementById("index_note_text_description").isDisplayed());
		Assert.assertTrue(driver.findElementById("browse_reminder_chip").isDisplayed());

	}
	@AfterClass 
	public void closeDriver() {
		driver.quit();
	}
}
