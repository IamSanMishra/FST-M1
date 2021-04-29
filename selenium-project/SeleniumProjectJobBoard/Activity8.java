package SeleniumProjectJobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity8 {
	
	WebDriver driver;
	
  @Test
  public void backendLogin() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("​pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();
	  WebElement element = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
	  Assert.assertTrue(element.isDisplayed());
	  System.out.println("Dashboard is displayed");
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
