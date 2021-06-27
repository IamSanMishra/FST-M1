package SeleniumProjectJobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity6 {
	
	WebDriver driver;
	
  @Test
  public void searchAndApplyForJob() throws InterruptedException {
	  driver.findElement(By.xpath("//a[text()='Jobs']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("Test Lead");
	  driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
	  Thread.sleep(2500);
	  driver.findElement(By.className("post-3018")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
	  Thread.sleep(1000);
	  String getEmail;
	  getEmail = driver.findElement(By.className("application_details")).findElement(By.className("job_application_email")).getText();
	  System.out.println(getEmail);
	  
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
