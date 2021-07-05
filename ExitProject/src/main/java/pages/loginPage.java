package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

	WebDriver driver;

	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// Element and Flow of RedBus Login Page
	
	@FindBy(how = How.ID, using = "sign-in-icon-down")
	public WebElement signIconElement;
	
	@FindBy(how = How.ID, using = "signInLink")
	public WebElement signElement;
	
	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement mframe;

	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/div[1]")
	public WebElement googleIcon;
	
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[2]")
	public WebElement anotherAcc;
	
	@FindBy(how = How.XPATH, using = "//input[@id='identifierId']")
	public WebElement emailId;
	
	@FindBy(how = How.NAME, using = "password")
	public WebElement psswd;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
	public WebElement nxtBtn;
	
	@FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")
	public WebElement wrongEmail;
	
	
	@FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]")
	public WebElement wrongPwdTxt;
	
	@FindBy(how = How.XPATH, using = "//i[@class= 'icon-close']")
	public WebElement iconClose;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"hc\"]/ul/li[1]")
	public WebElement myTrip;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"hc\"]/ul/li[2]")
	public WebElement walletCard;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hc\"]/ul/li[4]")
	public WebElement walletSummary;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"hc\"]/ul/li[5]")
	public WebElement signOut;
	
	// Method to implement valid Login
	public void validuserLogin(String username, String password) throws InterruptedException {
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
		signIconElement.click();
		signElement.click();
		driver.switchTo().frame(mframe);
		String parentWindow = driver.getWindowHandle();  
		Thread.sleep(3000);
		wait2.until(ExpectedConditions.visibilityOf(googleIcon)).click();
      	Set<String> allWindow = driver.getWindowHandles();
		for(String child:allWindow)
		  {
		      if(!parentWindow.equalsIgnoreCase(child))
		      { 
		          driver.switchTo().window(child);
		          emailId.sendKeys(username);
		          nxtBtn.click();
		          wait2.until(ExpectedConditions.elementToBeClickable(psswd)).sendKeys(password);
		          nxtBtn.click();
		      }
		      Thread.sleep(5000);
		  }
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		iconClose.click();
		Thread.sleep(3000);
	}
	
	// Method to implement invalid Login with invalid password
	public void invaliduserLogin(String username, String password) throws InterruptedException {
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
		signIconElement.click();
		signElement.click();
		driver.switchTo().frame(mframe);
		String parentWindow = driver.getWindowHandle();  
		wait2.until(ExpectedConditions.visibilityOf(googleIcon)).click();
      	Set<String> allWindow = driver.getWindowHandles();
		for(String child:allWindow)
		  {
		      if(!parentWindow.equalsIgnoreCase(child))
		      { 
		          driver.switchTo().window(child);
		          emailId.sendKeys(username);
		          nxtBtn.click();
		          wait2.until(ExpectedConditions.elementToBeClickable(psswd)).sendKeys(password);
		          nxtBtn.click();
		          Thread.sleep(2000);
		          if(wrongPwdTxt.isDisplayed()) {
		        	  driver.close();
		          }
		      }
		      Thread.sleep(3000);
		  }
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		iconClose.click();
		Thread.sleep(3000);
	}
	
	// Method to implement invalid Login with invalid email
	public void invaliduserLogin2(String username) throws InterruptedException {
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
		signIconElement.click();
		signElement.click();
		driver.switchTo().frame(mframe);
		String parentWindow = driver.getWindowHandle();  
		wait2.until(ExpectedConditions.visibilityOf(googleIcon)).click();
      	Set<String> allWindow = driver.getWindowHandles();
		for(String child:allWindow)
		  {
		      if(!parentWindow.equalsIgnoreCase(child))
		      { 
		          driver.switchTo().window(child);
		          emailId.sendKeys(username);
		          nxtBtn.click();
		          Thread.sleep(2000);
		          if(wrongEmail.isDisplayed()) {
		        	  driver.close();
		          }
		      }
		      Thread.sleep(3000);
		  }
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		iconClose.click();
		Thread.sleep(3000);
	}
	
	
	
	// Method to navigate to My Trips Page
	public void myTripHome() throws InterruptedException {
		signIconElement.click();
		myTrip.click();
		Thread.sleep(3000);
	}
	
	// Method to navigate to Wallet Balance Page
	public void checkWalletCardBalance() throws InterruptedException {
		signIconElement.click();
		walletCard.click();
		Thread.sleep(3000);
	}
	
	// Method to navigate to Wallet History Page
	public void checkWalletHistory() throws InterruptedException {
		signIconElement.click();
		walletSummary.click();
		Thread.sleep(3000);
	}
	
	// Method to check Signout Functionality
	public void checkSuccessSignout() throws InterruptedException {
		signIconElement.click();
		signOut.click();
		Thread.sleep(3000);
	}
	
	// Method to verify Correct Signout
	public Boolean verifySignout() throws InterruptedException {
		signIconElement.click();
		Thread.sleep(3000);
		return signElement.isDisplayed();
	}
	
	
}
