package SeleniumProjectJobBoard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
	
  @Test
  public void getTitle() {
	  System.out.println("The title of te page is "+ driver.getTitle());
  }
  
  @Test
  public void verifyTitle() {
	  Assert.assertEquals(driver.getTitle(),"Alchemy Jobs – Job Board Application");
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
