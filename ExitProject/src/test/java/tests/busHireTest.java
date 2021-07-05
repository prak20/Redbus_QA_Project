package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.busHiresPage;
import utils.ExcelReaderTest;
import utils.utils;

public class busHireTest  extends baseTest {
	
	private String sheetName = "BusHireTestData";
	ExcelReaderTest testData = new ExcelReaderTest("./Resources/testData.xlsx",sheetName);
	
	@Test(groups= {"bus"},priority = 1)
	public void busHireSiteFunctionality() throws InterruptedException {
		extentTest = extent.startTest("busHireSiteFunctionality Test ");
		log.info(" ---------- busHireSiteFunctionality Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 1));
		log.info("bus hire Test Started");
		busHiresPage bHire = new busHiresPage(driver);
		log.info("User clicks on Bus Hire link on HomePage");
		bHire.clickBusHire();
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 1));
		log.info("busHireSiteFunctionality Test passed Successfully !");
	}
	
	@Test(groups= {"bus"},priority = 2)
	public void myTripFunctionality() throws InterruptedException {
		extentTest = extent.startTest(" myTripFunctionality Test ");
		log.info(" ---------- myTripFunctionality Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 2));
		log.info("My Trips Test Started");
		busHiresPage bHire = new busHiresPage(driver);
		log.info("User clicks on Bus Hire link on HomePage");
		bHire.clickBusHire();
		log.info("User clicks on My Trips Link on Bus Hire Page");
		bHire.myTripsCheck();
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 2));
		log.info("myTripFunctionality Test passed Successfully !");
	}
	
	@Test(groups= {"bus"},priority = 3)
	public void myCancellations() throws InterruptedException {
		extentTest = extent.startTest(" myCancellations Test ");
		log.info(" ---------- myCancellations Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 3));
		log.info("My Cancellaton Test Started");
		busHiresPage bHire = new busHiresPage(driver);
		log.info("User clicks on Bus Hire link on HomePage");
		bHire.clickBusHire();
		log.info("User clicks on My Cancellation Link on Bus Hire Page");
		bHire.myCancellation();
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 3));
		log.info("myTripFunctionality Test passed Successfully !");
	}
	
	@Test(groups= {"bus"},priority = 4)
	public void checkOffers() throws InterruptedException {
		extentTest = extent.startTest(" checkOffers Test ");
		log.info(" ---------- checkOffers Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 4));
		log.info("Check Offers Test Started");
		busHiresPage bHire = new busHiresPage(driver);
		log.info("User clicks on Bus Hire link on HomePage");
		bHire.clickBusHire();
		log.info("Checks if offers are visible on Bus Hire Page");
		Assert.assertTrue(bHire.offersVisible());
		log.info("User clicks on Get more Offers Link on Bus Hire Page");
		bHire.getOffers();
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 4));
		log.info("myTripFunctionality Test passed Successfully !");
	}
	
	
	
}
