package SeleniumProjectJobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	
	WebDriver driver;
	
  @Test
  public void verifySecondHeading() {
	  String secondHeading;
	  secondHeading = driver.findElement(By.tagName("h2")).getText();
	  System.out.println(secondHeading);
	  Assert.assertEquals(secondHeading,"Quia quis non");
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
