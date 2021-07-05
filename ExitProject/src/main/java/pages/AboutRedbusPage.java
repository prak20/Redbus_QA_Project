package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// Created Jars
import com.pageutils.comUtils;


public class AboutRedbusPage {
	
	WebDriver driver;

	public AboutRedbusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// Element and Flow for getting info about RedBus Page
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'About Us')]")
	public WebElement aboutUs;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Contact Us')]")
	public WebElement contact;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'redBus on Mobile')]")
	public WebElement mobRed;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sitemap')]")
	public WebElement siteMap;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Offers')]")
	public WebElement offers;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Careers')]")
	public WebElement careers;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Values')]")
	public WebElement values;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"rh_footer\"]/div[2]/div/div/ul/h6")
	public WebElement scrollcomponent;
	
	
	// Method to navigate to AboutUs Page
	public void gotoAboutUs() throws InterruptedException {
		comUtils.scroll(scrollcomponent,driver);
		Thread.sleep(5000);
		comUtils.switchFrame(aboutUs, driver);
	}
	
	// Method to navigate to ContactUs Page
	public void gotoContactUs() throws InterruptedException {
		comUtils.scroll(scrollcomponent,driver);
		Thread.sleep(5000);
		comUtils.switchFrame(contact, driver);
	}
	
	// Method to navigate to RedBus Mobile Page
	public void gotoRedBusMobile() throws InterruptedException {
		comUtils.scroll(scrollcomponent,driver);
		Thread.sleep(5000);
		comUtils.switchFrame(mobRed, driver);
	}
	
	// Method to navigate to SiteMap Page
	public void gotoSiteMap() throws InterruptedException {
		comUtils.scroll(scrollcomponent,driver);
		Thread.sleep(5000);
		comUtils.switchFrame(siteMap, driver);
	}
	
	// Method to navigate to Offers Page
	public void gotoOffers() throws InterruptedException {
		comUtils.scroll(scrollcomponent,driver);
		Thread.sleep(5000);
		comUtils.switchFrame(offers, driver);
	}
	
	// Method to navigate to Careers Page
	public void gotoCareers() throws InterruptedException {
		comUtils.scroll(scrollcomponent,driver);
		Thread.sleep(5000);
		comUtils.switchFrame(careers, driver);
	}
	
	// Method to navigate to Values Page
	public void gotoValues() throws InterruptedException {
		comUtils.scroll(scrollcomponent,driver);
		Thread.sleep(5000);
		comUtils.switchFrame(values, driver);
	}
	
	
}
