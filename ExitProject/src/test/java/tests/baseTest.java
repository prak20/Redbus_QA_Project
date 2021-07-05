package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.RunBrowserSetup;
import utils.Screenshots;

public class baseTest {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static Logger log = LogManager.getLogger(baseTest.class.getName());

	static File file = new File("./Resources/config.properties");
	static FileInputStream fis = null;
	public static Properties prop = new Properties();

	static {
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException el) {
			el.printStackTrace();
		}
	}
	
	// Initialising Extent Report
	@BeforeTest(groups= {"about","login","search","home","bus"})
	public void setExtent() {
		extent=new ExtentReports(System.getProperty("user.dir") + "/Result/ExtentReport/Report.html", true);
		extent.addSystemInfo("UserInfo", "Prakhar01");
		extent.addSystemInfo("User Name", "Prakhar Agarwal");
		extent.assignProject("Redbus Tests");
	
	}
	
	// Ending Extent Reports
	@AfterTest(groups= {"about","login","search","home","bus"})
	public void endReport() {
		extent.flush();
		extent.close(); 
	}
	
	// Logging result to Extent report and then ending it
	@AfterMethod(groups= {"about","login","search","home","bus"})
	public void attachScreenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotPath=Screenshots.takeScreenShot(driver,result.getName());
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(screenshotPath),"TEST CASE FAILED IS " + result.getName());

		}
		else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
		}
		extent.endTest(extentTest);
	}
	
	// Initialising WebDrivers
	@BeforeMethod(groups= {"about","login","search","home","bus"})
	public static void intializeWebdriver() throws Exception {
		
		boolean headlessMode = Boolean.parseBoolean(prop.getProperty("headlessMode").toLowerCase());
		boolean dockerMode = Boolean.parseBoolean(prop.getProperty("dockerMode").toLowerCase());
		if(dockerMode) {
			if(headlessMode) {
				driver=RunBrowserSetup.headlessDocker();
			}
			else {
				driver=RunBrowserSetup.nonHeadlessDocker();
			}
		}
		else {
			if(headlessMode) {
				driver=RunBrowserSetup.headlessLocal();
			}
			else {
				driver=RunBrowserSetup.nonHeadlessLocal();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("timeoutValue")), TimeUnit.SECONDS);
	}
	
	// Opening the URL
	@BeforeMethod(groups= {"about","login","search","home","bus"})
	public static void openBrowser() {

		driver.get(prop.getProperty("url"));

	}
	
	// Closing the driver
	@AfterMethod(groups= {"about","login","search","home","bus"}) 
	public static void closeBrowser() {
		driver.close();
	}
}
