package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Created Jars
import com.pageutils.comUtils;


public class homePage {

	WebDriver driver;

	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// Element and Flow of RedBus Home Page
	
	@FindBy(how = How.XPATH, using = "//body[1]/section[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[4]/div[2]/ul[1]/li[1]")
	public WebElement amznPay;
	
	@FindBy(how = How.XPATH, using = "//body[1]/section[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[4]/div[2]/ul[1]/li[2]/span[1]/span[2]")
	public WebElement busCares;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[2]/span[1]")
	public WebElement amt;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/span[2]/input[1]")
	public WebElement customAmt;
	
	
	@FindBy(how = How.XPATH, using = ".//li[@class='modeLi']/span[1]/ul[1]/li[1]/span[1]/input[@value='yes']")
	public WebElement anonDonate;
	
	@FindBy(how = How.CLASS_NAME, using = "donateBtn")
	public WebElement donBtn;
	
	@FindBy(how = How.CLASS_NAME, using = "donateText")
	public WebElement validateDonate;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help')]")
	public WebElement help;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Manage Booking')]")
	public WebElement manBooking;
	
	@FindBy(how = How.XPATH, using = "//div[@id='hmb']")
	public WebElement bookingDetail;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
	public WebElement cancel;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Change Travel Date')]")
	public WebElement reschedule;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show My Ticket')]")
	public WebElement printTicket;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Email/SMS')]")
	public WebElement emailTicket;

	// Method to navigate to Amazon Pay Offer Page
	public void amazonOffer() throws InterruptedException {
		comUtils.switchFrame(amznPay, driver);
	}
	
	// Method to navigate to Red Bus Cares Website
	public void redBusCares() throws InterruptedException {
		comUtils.switchFrame(busCares, driver);
	}
	
	// Method to validate Amount in Redbus Cares Page
	public String supportAmt(String money) throws InterruptedException {
//		amt.click();
		customAmt.sendKeys(money);
		anonDonate.click();
		Thread.sleep(1000);
		donBtn.click();
		Thread.sleep(3000);
		return validateDonate.getText();
	}
	
	// Method to navigate to Help Page
	public void helpOption() throws InterruptedException {
		comUtils.switchFrame(help, driver);
	}
	
	// Method to navigate to Manage Bookings Page
	public void manageBookings() throws InterruptedException {
		manBooking.click();
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(bookingDetail));
	}
	
	// Method to navigate to Cancel Ticket Page
	public void cancelTicket() throws InterruptedException {
		cancel.click();
		Thread.sleep(5000);
	}
	
	// Method to navigate to Change Ticket Page
	public void changeTicket() throws InterruptedException {
		reschedule.click();
		Thread.sleep(5000);
	}
	
	// Method to navigate to Print Ticket Page
	public void showTicket() throws InterruptedException {
		printTicket.click();
		Thread.sleep(5000);
	}
	
	// Method to navigate to SMS / Mail Ticket Page
	public void mailTicketDetails() throws InterruptedException {
		emailTicket.click();
		Thread.sleep(5000);
	}
	
	
}