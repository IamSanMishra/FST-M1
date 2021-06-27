package SeleniumProjectJobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Activity9 {
	
	WebDriver driver;
	String postID;
	
  @Test 
  public void CreateJobListingFromBackend() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("​pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//div[text()='Job Listings']")).click();
	  driver.findElement(By.className("page-title-action")).click();
	  if((driver.findElement(By.xpath("//button[@aria-label='Close dialog']"))!=null)){
		  driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
	  }
	  driver.findElement(By.id("post-title-0")).sendKeys("GO Test Position 1");
	  driver.findElement(By.id("_company_website")).sendKeys("https://alchemy.hguy.co");
	  driver.findElement(By.id("_company_twitter")).sendKeys("Twitter@Test");
	  driver.findElement(By.id("_filled")).click();
	  driver.findElement(By.id("_job_location")).sendKeys("Test Location");
	  driver.findElement(By.id("_company_name")).sendKeys("Test GO Pvt Ltd");
	  driver.findElement(By.id("_company_tagline")).sendKeys("Keep Rocking");
	  driver.findElement(By.id("in-job_listing_type-2")).click();
	  driver.findElement(By.xpath("//button[text()='Publish…']")).click();
	  driver.findElement(By.xpath("//button[text()='Publish']")).click();
	  Thread.sleep(2500);
	  driver.findElement(By.xpath("//a[text()='View Job']")).click();
	  postID = driver.findElement(By.className("status-publish")).getAttribute("id");
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");	  
	  driver.findElement(By.xpath("//div[text()='Job Listings']")).click();
	  //Verifying if the job post id that was created exists
	  if(driver.findElement(By.id(postID)).isDisplayed()) {
		  System.out.println("Job Listing successfully verified");
	  }
	    
  }
  
 
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
