package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Created Jars
import com.pageutils.comUtils;


public class busHiresPage {
	
	WebDriver driver;

	public busHiresPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// Element and Flow of Bus Hire Page
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'BUS TICKETS')]")
	private WebElement busTicket;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[1]/nav[1]/a[3]")
	public WebElement busHire;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Manage Booking')]")
	public WebElement manBooking;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'My Trips')]")
	public WebElement myTrips;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]")
	public WebElement cancellation;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Offers')]")
	public WebElement offer;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'VIEW ALL')]")
	public WebElement viewAll;
	
	// Method to click on Bus Hire Link
	public void clickBusHire() throws InterruptedException {
		busTicket.click();
		Thread.sleep(3000);
		busHire.click();
		Thread.sleep(3000);
	}
	
	// Method to navigate to My Trips Page
	public void myTripsCheck() throws InterruptedException {
		manBooking.click();
		comUtils.switchFrame(myTrips, driver);
	}
	
	// Method to navigate to My Cancellations Page
	public void myCancellation() throws InterruptedException {
		manBooking.click();
		comUtils.switchFrame(cancellation, driver);
	}
	
	public Boolean offersVisible() {
		return offer.isDisplayed();
	}
	
	// Method to navigate to Offers Page
	public void getOffers() throws InterruptedException {
		comUtils.action_scroll(offer, driver);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(viewAll));
		comUtils.switchFrame(viewAll, driver);
	}
}
