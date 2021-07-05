package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.searchPage;
import utils.ExcelReaderTest;
import utils.utils;


public class searchBusTicketTest extends baseTest{
	
	private String sheetName = "SearchBusTestData";
	ExcelReaderTest testData = new ExcelReaderTest("./Resources/testData.xlsx",sheetName);
	
	@Test(groups= {"search"},priority = 1)
	public void validSearch() throws InterruptedException {
		extentTest = extent.startTest("validSearch Test");
		log.info(" ---------- validSearch Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 1));
		log.info("validSearch Test Started");
		searchPage search = new searchPage(driver);
		log.info("User search for particular buses with input entries");
		search.searchBuses(testData.getValue("Source", 1),testData.getValue("Destination", 1), testData.getValue("DateOfTravel", 1));
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 1));
		log.info("validSearch Test passed Successfully !");
		}
	
	@Test(groups= {"search"},priority = 2)
	public void invalidSearchWithIncorrectDestination() throws InterruptedException {
		extentTest = extent.startTest(" invalidSearch1 Test ");
		log.info(" ---------- invalid Search With Incorrect Destination Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 2));
		log.info("invalidSearchWithIncorrectDestination Test Started");
		searchPage search = new searchPage(driver);
		log.info("User search for particular buses with incorrect Destination Value");
		search.searchBuses(testData.getValue("Source", 2),testData.getValue("Destination", 2), testData.getValue("DateOfTravel", 2));
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 2));
		log.info("invalidSearch1 Test passed Successfully !");
		}
	
	@Test(groups= {"search"},priority = 3)
	public void invalidSearchWithIncorrectSource() throws InterruptedException {
		extentTest = extent.startTest(" invalidSearch2 Test ");
		log.info(" ---------- invalid Search With Incorrect Source Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 3));
		log.info("invalidSearchWithIncorrectSource Test Started");
		searchPage search = new searchPage(driver);
		log.info("User search for particular buses with incorrect source value");
		search.searchBuses(testData.getValue("Source", 3),testData.getValue("Destination", 3), testData.getValue("DateOfTravel", 3));
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 3));
		log.info("invalidSearch2 Test passed Successfully !");
		}
	
	@Test(groups= {"search"},priority = 4)
	public void modifyTripDetails() throws InterruptedException{
		extentTest = extent.startTest("modifyTripDetails Test");
		log.info(" ---------- modify Trip Details Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 4));
		log.info("modifyTripDetails Test Started");
		searchPage search = new searchPage(driver);
		log.info("User search for particular buses with input entries");
		search.searchBuses(testData.getValue("Source", 4),testData.getValue("Destination", 4), testData.getValue("DateOfTravel", 4));
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 4));
		log.info("User is navigated to search results page");
		log.info("User modifies the entries and checks if the details are modified");
		Assert.assertTrue(search.modifyDetails(testData.getValue("ModifySource", 4), testData.getValue("ModifyDest", 4)));
		log.info("modifyTripDetails Test passed Successfully !");
	}
}
