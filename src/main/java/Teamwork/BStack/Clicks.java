package Teamwork.BStack;

public class Clicks {

	public Clicks() {
		
		

			private WebDriver driver;

			public WebsitePage(WebDriver driver) {

				this.driver = driver;	
				
			}

			By getStarted = By.xpath("//a[contains(@href,'getstarted1')]");
			By fullName = By.id("fullname");
			By emailAddress = By.id("useremail");
			By newAccountPassword = By.id("password");
			By companyName = By.id("companyName");
			By phoneNumber = By.id("phone");
			By startTrial = By.xpath("//button[contains(.,'Start My Free Trial')]");
			By euClick = By.id("isEU");
			By euSet = By.className("tw-domain");

			public WebElement getStarted() {

				return driver.findElement(getStarted);
			}

			public WebElement fullName() {

				return driver.findElement(fullName);
			}

			public WebElement emailAddress() {

				return driver.findElement(emailAddress);
			}

			public WebElement newAccountPassword() {

				return driver.findElement(newAccountPassword);
			}

			public WebElement companyName() {

				return driver.findElement(companyName);
			}
			
			public WebElement phoneNumber() {
				
				return driver.findElement(phoneNumber);
			}
			
			public WebElement euClick() {
				
				return driver.findElement(euClick);
			}
			
			public WebElement euSet() {
				
				return driver.findElement(euSet);
				
			}

			public ExpectedCondition<List<WebElement>> wait_getStarted() {

				return ExpectedConditions.visibilityOfAllElementsLocatedBy(getStarted);
			}

			public ExpectedCondition<List<WebElement>> wait_fullName() {

				return ExpectedConditions.visibilityOfAllElementsLocatedBy(fullName);
			}
			
			public ExpectedCondition<List<WebElement>> wait_euClick() {

				return ExpectedConditions.visibilityOfAllElementsLocatedBy(euClick);
			}

		}

		
		
	

}
