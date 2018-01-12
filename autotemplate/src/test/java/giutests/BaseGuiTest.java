package giutests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import config.Log;
import web.driver.Driver;

public class BaseGuiTest {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	@BeforeClass
	public static void setUp(){
		try{
			driver = Driver.getWebDriver();
		}catch(Exception e){
			Log.error("Failed to initiate WebDriver");
			e.printStackTrace();
			throw e;
		}
		wait = new WebDriverWait(driver, 10);
	}
	
	@AfterClass
	public static void cleanUp() throws Exception{
		Driver.quitDriver();
	}
	
	protected static void browseToUrl(String url) {
		Log.info("Browsing to URL: " + url);
		driver.get(url);
	}
}
