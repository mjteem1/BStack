package Teamwork.BStack;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Teamwork.BStack.WebsitePage;
import Teamwork.cookie.LetMeRemember;

public class AppTest {

  private WebDriver driver;
  private WebDriverWait wait;
  private WebsitePage add;



  @BeforeClass
  @org.testng.annotations.Parameters(value={"browser","os_version","os"})
  public void setUp(String browser, String os_version, String os) throws Exception {
    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability("browserName", browser);
    capability.setCapability("os_version", os_version);
    capability.setCapability("os", os);
    capability.setCapability("project", "P1");
    capability.setCapability("build", "1.0");
    driver = new RemoteWebDriver(
      new URL("https://mjheff1:LuXjLo9YyEC3eXHfWr7r@hub-cloud.browserstack.com/wd/hub"),
      capability);
	wait = new WebDriverWait(driver, 10);
	add = new WebsitePage(driver);
  }

  @Test
  public void testSimple() throws Exception {
//    driver.get("https://www.teamwork.com/project-management-software");
//    System.out.println("Page title is: " + driver.getTitle());
//	wait.until(create.wait_getStarted());
//	
//	create.getStarted().click();
//	delete
//	wait.until(create.wait_fullName());
    
    driver.get("https://www.teamwork.com/signup");
	
	add.enterName("Automated Testerzzz"); 
	add.emailAddress().sendKeys("mjteamworkautomated@gmail.com");
	add.newAccountPassword().sendKeys("testing"); 
	add.companyName().sendKeys("test"); 
	add.phoneNumber().sendKeys("0888080028"); 
	wait.until(add.wait_euClick());
	add.euClick().click();
	
	assertTrue(add.euSet().getText().contains(".eu.teamwork.com"), "Changed to EU");

   
    driver = new Augmenter().augment(driver);
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File("Screenshot.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void assertTrue(boolean contains, String string) {
	// TODO Auto-generated method stub
	
}

@AfterClass
  public void tearDown() throws Exception {
    driver.quit();
  }
}