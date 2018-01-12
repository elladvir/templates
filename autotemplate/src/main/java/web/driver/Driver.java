package web.driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import config.EnvConfig;
import config.Log;

public class Driver {

	protected static WebDriver driver;;
	
	public static WebDriver getWebDriver(){
		
		if (driver == null) {
			switch(EnvConfig.browserType.toLowerCase()){
				case "chrome": default:
					driver = getChromeDriver();
					break;
				case "firefox":
					driver = getFirefoxDriver();
					break;
				case "ie":
					driver = getInternetExplorerDriver();
					break;
			}
    		
    		driver.manage().timeouts().implicitlyWait(EnvConfig.webDriverImplicitWaitInSeconds, TimeUnit.SECONDS);
    		driver.manage().window().maximize(); 
		}
		return driver;
	}
	
	public static WebDriver getChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "webdrivers" + File.separator + "chromedriver.exe");		
	    driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver getFirefoxDriver(){
		System.setProperty("webdriver.gecko.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "webdrivers" + File.separator + "geckodriver.exe");
		 driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver getInternetExplorerDriver(){
		System.setProperty("webdriver.ie.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "webdrivers" + File.separator + "IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		return driver;
	}
	
    public static void quitDriver() throws Exception {
    	Log.info("Checking if other WebDriver is running");
    	if (driver != null) {
        	Log.info("Quiting WebDriver");
        	driver.quit();
            driver = null;
        }
    }
}
