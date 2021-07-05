package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.homePage;
import utils.ExcelReaderTest;
import utils.utils;

public class HomeFunctionalityTest  extends baseTest{
	
	private String sheetName = "HomeTestData";
	ExcelReaderTest testData = new ExcelReaderTest("./Resources/testData.xlsx",sheetName);

	
	@Test(groups= {"home"},priority = 1)
	public void redBusCaresFunctionality() throws InterruptedException {
		extentTest = extent.startTest(" redBusCares Test ");
		log.info(" ---------- redBusCares Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 1));
		log.info("redBus Cares Test Started");
		homePage home = new homePage(driver);
		log.info("User clicks on Redbus Cares Banner");
		home.redBusCares();
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 1));
		log.info("User enters some donation amount");
		String txt = home.supportAmt(testData.getValue("Amount", 1));
		log.info("Check if the input amount is correct while paying the amount");
		Assert.assertTrue(txt.contains(testData.getValue("Amount", 1)));
		log.info("redBusCares Test passed Successfully !");
	}
	
	@Test(groups= {"home"},priority = 2)
	public void checkHelpOption() throws InterruptedException {
		extentTest = extent.startTest(" checkHelpOption Test ");
		log.info(" ---------- checkHelpOption Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 2));
		log.info("Help Option Test Started");
		homePage home = new homePage(driver);
		log.info("User clicks on help Option");
		home.helpOption();
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 2));
		log.info("checkHelpOption Test passed Successfully !");
	}
	
	@Test(groups= {"home"},priority = 3)
	public void checkCancelTicket() throws InterruptedException {
		extentTest = extent.startTest("checkCancelTicket Test ");
		log.info(" ---------- checkCancelTicket Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 3));
		log.info("Cancel Ticket Test Started");
		homePage home = new homePage(driver);
		log.info("User clicks on manage Bookings");
		home.manageBookings();
		log.info("User clicks on cancel Ticket link");
		home.cancelTicket();
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 3));
		log.info("checkCancelTicket Test passed Successfully !");
	}
	
	@Test(groups= {"home"},priority = 4)
	public void checkRescheduleTicket() throws InterruptedException {
		extentTest = extent.startTest(" checkRescheduleTicket Test");
		log.info(" ---------- checkRescheduleTicket Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 4));
		log.info("Reschedule Ticket Test Started");
		homePage home = new homePage(driver);
		log.info("User clicks on manage Bookings");
		home.manageBookings();
		log.info("User clicks on change Ticket link");
		home.changeTicket();
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 4));
		log.info("checkRescheduleTicket Test passed Successfully !");
	}
	
	@Test(groups= {"home"},priority = 5)
	public void checkShowTicket() throws InterruptedException {
		extentTest = extent.startTest(" checkShowTicket Test ");
		log.info(" ---------- checkShowTicket Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 5));
		log.info("Print Ticket Test Started");
		homePage home = new homePage(driver);
		log.info("User clicks on manage Bookings");
		home.manageBookings();
		log.info("User clicks on print Ticket link");
		home.showTicket();
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 5));
		log.info("checkShowTicket Test passed Successfully !");
	}
	
	@Test(groups= {"home"},priority = 6)
	public void checkMailSMSTicket() throws InterruptedException {
		extentTest = extent.startTest(" checkMailSMSTicket Test ");
		log.info(" ---------- checkMailSMSTicket Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 6));
		log.info("Mail / SMS Ticket Test Started");
		homePage home = new homePage(driver);
		log.info("User clicks on manage Bookings");
		home.manageBookings();
		log.info("User clicks on Mail/SMS Ticket link");
		home.mailTicketDetails();
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 6));
		log.info("checkMailSMSTicket Test passed Successfully !");
	}
}
