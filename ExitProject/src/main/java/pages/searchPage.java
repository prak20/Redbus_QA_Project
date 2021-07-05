package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class searchPage {
	
	WebDriver driver;

	public searchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// Element and Flow of RedBus Login Page
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'BUS TICKETS')]")
	private WebElement busTicket;

	@FindBy(how = How.ID, using = "txtSource")
	private WebElement from;

	@FindBy(how = How.ID, using = "txtDestination")
	private WebElement to;

	@FindBy(how = How.ID, using = "txtOnwardCalendar")
	private WebElement date;
   
    @FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/img[1]")
    public WebElement Swipe;
   
    @FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[2]/li[18]/span[1]")
    public WebElement setDate;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/button[1]")
	private WebElement searchBusesButton;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Modify')]")
	private WebElement modify;

	@FindBy(how = How.ID, using = "src")
	private WebElement src;

	@FindBy(how = How.ID, using = "dest")
	private WebElement dest;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"fixer\"]/section/div/div[4]/button")
	public WebElement Modifysearch;
	
	// Method to search Bus Details
	public void searchBuses(String fromCity,String toCity,String DateVal) throws InterruptedException{
		busTicket.click();
		Thread.sleep(5000);
		from.click();
		from.sendKeys(fromCity);
		Thread.sleep(2000);
		from.sendKeys(Keys.ENTER);
		to.click();
		to.sendKeys(toCity);
		Thread.sleep(2000);
		to.sendKeys(Keys.ENTER);
		date.click();
		date.sendKeys(DateVal);
		Thread.sleep(1000);
		searchBusesButton.click();
		Thread.sleep(1000);
	}
	
	// Method to modify search Details
	public Boolean modifyDetails(String fromCity,String toCity) throws InterruptedException {
		modify.click();
		Thread.sleep(2000);
		src.clear();
		src.sendKeys(fromCity);
		Thread.sleep(2000);
		src.sendKeys(Keys.ENTER);
		dest.clear();
		dest.sendKeys(toCity);
		Thread.sleep(2000);
		dest.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Modifysearch.click();
		Thread.sleep(1000);
		return modify.isDisplayed();
	}

}
