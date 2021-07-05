package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutRedbusPage;
import utils.ExcelReaderTest;
import utils.utils;

public class aboutRedbusTest  extends baseTest  {
	
	private String sheetName = "AboutRedbusTestData";
	ExcelReaderTest testData = new ExcelReaderTest("./Resources/testData.xlsx",sheetName);

	
	@Test(groups= {"about"},priority = 1)
	public void aboutUs() throws Exception {
		extentTest = extent.startTest("About us Test");
		log.info(" ---------- About us Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 1));
		log.info("aboutUs Test Started");
		AboutRedbusPage about = new AboutRedbusPage(driver);
		about.gotoAboutUs();
		log.info("user is navigated to about us page");
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 1));
		Thread.sleep(5000);
		log.info("About Us Test passed Successfully !");
	}
	
	@Test(groups= {"about"},priority = 2)
	public void contactUs() throws InterruptedException {
		extentTest = extent.startTest("Contact us Test");
		log.info(" ---------- Contact us Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 2));
		log.info("contactUs Test Started");
		AboutRedbusPage about = new AboutRedbusPage(driver);
		about.gotoContactUs();
		log.info("user is navigated to Contact Us page");
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 2));
		log.info("Contact Us Test passed Successfully !");
	}
	
	@Test(groups= {"about"},priority = 3)
	public void redBusMobile() throws InterruptedException {
		extentTest = extent.startTest("redBusMobile Test");
		log.info(" ---------- redBusMobile Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 3));
		log.info("redBusMobile Test Started");
		AboutRedbusPage about = new AboutRedbusPage(driver);
		about.gotoRedBusMobile();
		log.info("user is navigated to redBus Mobile page");
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 3));
		log.info("redBusMobile Test passed Successfully !");
	}
	
	@Test(groups= {"about"},priority = 4)
	public void siteMap() throws InterruptedException {
		extentTest = extent.startTest("siteMap Test");
		log.info(" ---------- siteMap Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 4));
		log.info("siteMap Test Started");
		AboutRedbusPage about = new AboutRedbusPage(driver);
		about.gotoSiteMap();
		log.info("user is navigated to Site Maps page");
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 4));
		log.info("SiteMap Test passed Successfully !");
	}
	
	@Test(groups= {"about"},priority = 5)
	public void offers() throws InterruptedException {
		extentTest = extent.startTest("offers Test");
		log.info(" ---------- offers Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 5));
		log.info("offers Test Started");
		AboutRedbusPage about = new AboutRedbusPage(driver);
		about.gotoOffers();
		log.info("user is navigated to Offers page");
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 5));
		log.info("Offers Page Test passed Successfully !");
	}
	
	@Test(groups= {"about"},priority = 6)
	public void careers() throws InterruptedException {
		extentTest = extent.startTest("Careers Test");
		log.info(" ---------- Careers Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 6));
		log.info("careers Test Started");
		AboutRedbusPage about = new AboutRedbusPage(driver);
		about.gotoCareers();
		log.info("user is navigated to Careers page");
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("Current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 6));
		log.info("Careers Page Test passed Successfully !");
	}
	
	@Test(groups= {"about"},priority = 7)
	public void values() throws InterruptedException {
		extentTest = extent.startTest("values Test");
		log.info(" ---------- values Test ---------- ");
		log.info("Checking if this test is to be executed or not !");
		utils.toCheckExecutionRequired(testData.getValue("ExecutionRequired", 7));
		log.info("values Test Started");
		AboutRedbusPage about = new AboutRedbusPage(driver);
		about.gotoValues();
		log.info("user is navigated to Values page");
		log.info("Current url is fetched");
		String title = driver.getCurrentUrl();
		log.info("current url is matched with test data");
		Assert.assertEquals(title, testData.getValue("Current Url", 7));
		log.info("values Page Test passed Successfully !");
	}

}
