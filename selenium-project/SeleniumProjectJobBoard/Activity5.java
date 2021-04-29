package SeleniumProjectJobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	
	WebDriver driver;
	
  @Test
  public void clickMenuItem() throws InterruptedException {
	  WebElement mainMenu = driver.findElement(By.cssSelector("div.main-navigation"));
	  mainMenu.findElement(By.xpath("//a[text()='Jobs']")).click();
	  Thread.sleep(1000);
	  String pageTitle = driver.getTitle();
	  System.out.println(pageTitle);
	  Assert.assertEquals(pageTitle,"Jobs – Alchemy Jobs");
	  
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
