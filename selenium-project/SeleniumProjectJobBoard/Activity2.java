package SeleniumProjectJobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	WebDriver driver;
	
  @Test
  public void verifyHeader() {
	  String pageHeading;
	  pageHeading = driver.findElement(By.cssSelector("h1.entry-title")).getText();
	  //System.out.println(pageHeading);
	  Assert.assertEquals(pageHeading,"Welcome to Alchemy Jobs");
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
