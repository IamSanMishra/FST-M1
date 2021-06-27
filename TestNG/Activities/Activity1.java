package TestNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	
	WebDriver driver;
	
  @Test
  public void f() {
	  String pageTitle = driver.getTitle();
	  System.out.println("The title of the page is "+pageTitle);
	  Assert.assertEquals("Training Support",pageTitle);
	  driver.findElement(By.id("about-link")).click();
	  System.out.println("The new page title is "+driver.getTitle());
	  Assert.assertEquals("About Training Support",driver.getTitle());
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
