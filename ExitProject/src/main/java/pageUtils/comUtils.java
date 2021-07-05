package pageUtils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class comUtils {
	
	// Common Method to Switch Frames
	public static void switchFrame(WebElement element, WebDriver driver) throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();
		String winHandleAfter="";
		element.click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    winHandleAfter = winHandle;
		}
		Thread.sleep(5000);
		driver.switchTo().window(winHandleBefore);
		driver.close();
		driver.switchTo().window(winHandleAfter);
		Thread.sleep(3000);
	}
	
	// Method to scroll down using Javascript Executor -
	public static void scroll(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	// Method to scroll down using Actions -
	public static void action_scroll(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
}