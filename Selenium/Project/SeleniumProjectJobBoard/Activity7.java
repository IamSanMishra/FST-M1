package SeleniumProjectJobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Activity7 {
	
	WebDriver driver;
	
  @Test
  public void CreateNewJobListing() throws InterruptedException {
	  WebElement mainMenu = driver.findElement(By.cssSelector("div.main-navigation"));
	  mainMenu.findElement(By.xpath("//a[text()='Post a Job']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("create_account_email")).sendKeys("test9717@gmail.com");
	  driver.findElement(By.id("job_title")).sendKeys("GO Test Job 3");
	  driver.findElement(By.id("job_location")).sendKeys("Test Location");
	  Select select = new Select(driver.findElement(By.id("job_type")));
	  select.selectByVisibleText("Internship");
	  driver.switchTo().frame("job_description_ifr");
	  driver.findElement(By.id("tinymce")).sendKeys("Test Job Description");
	  driver.switchTo().defaultContent();
	  driver.findElement(By.id("application")).sendKeys("sanmi136@gmail.com");
	  driver.findElement(By.id("company_name")).sendKeys("Test GO Pvt Ltd");
	  driver.findElement(By.id("company_website")).sendKeys("https://www.testgopvtltd.com/");
	  driver.findElement(By.id("company_tagline")).sendKeys("GO TEST GO");
	  driver.findElement(By.id("company_video")).sendKeys("https://www.youtube.com/");
	  driver.findElement(By.id("company_twitter")).sendKeys("twitter@TestGo");
	  File file = new File("C:\\Users\\SantoshMishra\\Desktop\\GO.gif");
	  driver.findElement(By.id("company_logo")).sendKeys(file.getAbsolutePath());
	  driver.findElement(By.xpath("//input[@value='Preview']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("job_preview_submit_button")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[text()='click here']")).click();
	  Thread.sleep(5000);
	  String jobTitle = driver.findElement(By.xpath("//h1[text()='GO Test Job 3']")).getText();
	  System.out.println(jobTitle);
	  Assert.assertEquals(jobTitle,"GO Test Job 3");
	  
  }
  
	
	  @Test 
	  public void searchForJob() throws InterruptedException {
	  driver.findElement(By.xpath("//a[text()='Jobs']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("GO Test Job 3");
	  driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
	  Thread.sleep(2500); 
	  String findTitle = driver.findElement(By.xpath("//h3[text()='GO Test Job 3']")).getText();
	  System.out.println(findTitle);
	  Assert.assertEquals(findTitle,"GO Test Job 3");
	  
	  }
	 
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
