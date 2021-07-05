package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import tests.baseTest;

public class RunBrowserSetup  extends baseTest {
	
	public static RemoteWebDriver remoteDriver;
	public static WebDriver webDriver;
	public static DesiredCapabilities caps;
	private static URL url = null;
	private static String browserName = prop.getProperty("browser").toLowerCase();

	public RunBrowserSetup() throws Exception {
		if(browserName.equals("chrome")||browserName.equals("firefox")||browserName.equals("ie")){
			log.info("Browser is Supported !");
		}
		else {
			log.info("Browser is not Supported !");
			throw new Exception("Browser is not Supported !");
		}
	}
	
public static RemoteWebDriver nonHeadlessDocker() throws MalformedURLException {
	
	ChromeOptions chromeOptions = null;
	url = new URL("http://localhost:4444/wd/hub");

		
		if(browserName.equals("chrome")) {
			caps = DesiredCapabilities.chrome();
			remoteDriver = new RemoteWebDriver(url, caps);
		}
		
		else if(browserName.equals("firefox")) {
			
			caps = DesiredCapabilities.firefox();
			remoteDriver = new RemoteWebDriver(url, caps);
		}
		
		else if(browserName.equals("ie")) {
			
			caps = DesiredCapabilities.internetExplorer();
			remoteDriver = new RemoteWebDriver(url, caps);
		}
		
		return remoteDriver;
	}

public static RemoteWebDriver headlessDocker() throws MalformedURLException {
	ChromeOptions chromeOptions = null;
	FirefoxOptions firefoxOptions = null;
	InternetExplorerOptions ieOptions = null;
	url = new URL("http://localhost:4444/wd/hub");

	if(browserName.equals("chrome")) {
	      chromeOptions = new ChromeOptions();
	      chromeOptions.addArguments("--headless");
	      chromeOptions.addArguments("--disable-gpu");
	      chromeOptions.addArguments("--disable-dev-shm-usage");
	      chromeOptions.addArguments("--no-sandbox");
	      chromeOptions.addArguments("--allow-insecure-localhost");
	      chromeOptions.addArguments("window-size=1920,1080");
	      chromeOptions.addArguments("user-agent=Chrome/91.0.4472.124");
	      remoteDriver = new RemoteWebDriver(url,chromeOptions);
	}
	
	else if(browserName.equals("firefox")) {
		
		caps = DesiredCapabilities.firefox();
		firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("headless");
		firefoxOptions.addArguments("window-size=1920,1080");
		firefoxOptions.merge(caps);
		remoteDriver = new RemoteWebDriver(url, firefoxOptions);
	}
	
	else if(browserName.equals("ie")) {
		
		caps = DesiredCapabilities.internetExplorer();
		remoteDriver = new RemoteWebDriver(url, ieOptions);
	}
	
	
	return remoteDriver;
}

public static WebDriver headlessLocal() {
	ChromeOptions chromeOptions = null;
	FirefoxOptions options = null;
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("headless");
		chromeOptions.addArguments("window-size=1920,1080");
		chromeOptions.addArguments("user-agent=Chrome/88.0.4324.150");
		webDriver = new ChromeDriver(chromeOptions);
	}
	
	else if (browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriver"));
		options = new FirefoxOptions();
		options.setHeadless(true);
		webDriver = new FirefoxDriver(options);
	}
	
	 else if (browserName.equals("ie")) {
		System.setProperty("webdriver.ie.driver", prop.getProperty("ieDriver")); 
		webDriver = new InternetExplorerDriver();
	 }
	return webDriver;
}

public static WebDriver nonHeadlessLocal() {
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
		webDriver = new ChromeDriver();
	}
	
	else if (browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriver"));
		webDriver = new FirefoxDriver();
	}
	
	 else if (browserName.equals("ie")) {
		System.setProperty("webdriver.ie.driver", prop.getProperty("ieDriver")); 
		webDriver = new InternetExplorerDriver();
	 }
	return webDriver;
}
}
