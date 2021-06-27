package SeleniumProjectJobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	WebDriver driver;
	
  @Test
  public void getURLOfHeaderImage() {
	  String Url;
	  Url = driver.findElement(By.className("wp-post-image")).getAttribute("src");
	  System.out.println(Url);
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
