package utils;

import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import tests.baseTest;

public class utils  extends baseTest{
	public static void toCheckExecutionRequired(String exec){
	
		if(exec.toLowerCase().equals("no")) {
			extentTest.log(LogStatus.WARNING, "Execution Required : "+exec.toUpperCase());
			log.info("Execution required is "+exec+", skipping the test");
			throw new SkipException("Skipping this exception");
		}
		if(exec.toLowerCase().equals("")) {
			extentTest.log(LogStatus.WARNING, "Execution Required : "+exec.toUpperCase());
			log.info("Execution required is "+exec+" , skipping the test");
			throw new SkipException("Skipping this exception");
		}
	}
	
	
		
		
		

}
