package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.loginPage;
import utils.ExcelReaderTest;
import utils.utils;


public class LoginTest extends baseTest{
	
	private String sheetName = "LoginTestData";
	ExcelReaderTest testData = new ExcelReaderTest("./Resources/testData.xlsx",sheetName);
	
	@Test(groups= {"login"},priority = 1)
	public void validLogin() throws InterruptedException {
		extentTest = extent.startTest("validLogin Test");
		log.info(" ---------- validLogin Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 1));
		log.info("validLogin Test Started");
		loginPage login = new loginPage(driver);
		log.info("User enters gmail Id and Password");
		login.validuserLogin(testData.getValue("Username", 1), testData.getValue("Password", 1));
		log.info("User gets logged in !");
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 1));
		log.info("validLogin Test passed Successfully !");
	}
	
	@Test(groups= {"login"},priority = 2)
	public void invalidLoginWithInvalidEmail() throws InterruptedException {
		extentTest = extent.startTest("invalidLoginWithInvalidEmail Test");
		log.info(" ---------- invalidLoginWithInvalidEmail Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 2));
		log.info("invalidLogin Test Started");
		loginPage login = new loginPage(driver);
		log.info("User enters invalid gmail Id ");
		login.invaliduserLogin2(testData.getValue("Username", 2));
		log.info("User is unable to login !");
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 2));
		log.info("invalidLoginWithInvalidEmail Test passed Successfully !");
	}
	
	@Test(groups= {"login"},priority = 3)
	public void invalidLoginWithInvalidPassword() throws InterruptedException {
		extentTest = extent.startTest("invalidLoginWithInvalidPassword Test");
		log.info(" ---------- invalidLoginWithInvalidPassword Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 3));
		log.info("invalidLogin Test Started");
		loginPage login = new loginPage(driver);
		log.info("User enters gmail Id and Invalid Password");
		login.invaliduserLogin(testData.getValue("Username", 3), testData.getValue("Password", 3));
		log.info("User is unable to login !");
		log.info("Current Title is fetched");
		String title = driver.getTitle();
		log.info("Current Title is matched with test data");
		Assert.assertEquals(title, testData.getValue("Title", 3));
		log.info("invalidLoginWithInvalidPassword Test passed Successfully !");
	}
	
	@Test(groups= {"login"},priority = 4)
	public void myTripTest() throws InterruptedException{
		extentTest = extent.startTest("myTripTest Test");
		log.info(" ---------- myTripTest Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 4));
		log.info("myTripTest Test Started");
		loginPage login = new loginPage(driver);
		log.info("User enters gmail Id and Password");
		login.validuserLogin(testData.getValue("Username", 4), testData.getValue("Password", 4));
		log.info("User clicks on my trips link ");
		login.myTripHome();
		log.info("User is navigated to my Trips page");
		log.info("Current Title is matched with test data");
		Assert.assertEquals(driver.getTitle(),testData.getValue("Title", 4));
		log.info("Current Url is matched with test data");
		Assert.assertEquals(driver.getCurrentUrl(),testData.getValue("Current Url", 4));
		log.info("myTripTest Test passed Successfully !");
	}
	
	@Test(groups= {"login"},priority = 5)
	public void walletCardBalance() throws InterruptedException{
		extentTest = extent.startTest("walletCardBalance Test");
		log.info(" ---------- walletCardBalance Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 5));
		log.info("walletCardBalance Test Started");
		loginPage login = new loginPage(driver);
		log.info("User enters gmail Id and Password");
		login.validuserLogin(testData.getValue("Username", 5), testData.getValue("Password", 5));
		log.info("User clicks on Wallets/Cards link ");
		login.checkWalletCardBalance();
		log.info("User is navigated to my Wallets/Cards page");
		log.info("Current Title is matched with test data");
		Assert.assertEquals(driver.getTitle(),testData.getValue("Title", 5));
		log.info("Current Url is matched with test data");
		Assert.assertEquals(driver.getCurrentUrl(),testData.getValue("Current Url", 5));
		log.info("walletCardBalance Test passed Successfully !");
	}
	
	@Test(groups= {"login"},priority = 6)
	public void walletActivity() throws InterruptedException{
		extentTest = extent.startTest("walletActivity Test");
		log.info(" ---------- walletActivity Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 6));
		log.info("walletActivity Test Started");
		loginPage login = new loginPage(driver);
		log.info("User enters gmail Id and Password");
		login.validuserLogin(testData.getValue("Username", 6), testData.getValue("Password", 6));
		log.info("User clicks on Wallet History link ");
		login.checkWalletHistory();
		log.info("User is navigated to Wallet History page");
		log.info("Current Title is matched with test data");
		Assert.assertEquals(driver.getTitle(),testData.getValue("Title", 6));
		log.info("Current Url is matched with test data");
		Assert.assertEquals(driver.getCurrentUrl(),testData.getValue("Current Url", 6));
		log.info("walletActivity Test passed Successfully !");
	}
	
	@Test(groups= {"login"},priority = 7)
	public void validSignout() throws InterruptedException{
		extentTest = extent.startTest("validSignout Test");
		log.info(" ---------- validSignout Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 7));
		log.info("validSignout Test Started");
		loginPage login = new loginPage(driver);
		log.info("User enters gmail Id and Password");
		login.validuserLogin(testData.getValue("Username", 7), testData.getValue("Password", 7));
		log.info("User clicks on Signout link ");
		login.checkSuccessSignout();
		log.info("User is able to successfully signout");
		log.info("Current Title is matched with test data");
		Assert.assertEquals(driver.getTitle(), testData.getValue("Title", 7));
		log.info("Verifies if user is signed out or not");
		Assert.assertTrue(login.verifySignout());
		log.info("validSignout Test passed Successfully !");
	}
	
	
	
	

}

