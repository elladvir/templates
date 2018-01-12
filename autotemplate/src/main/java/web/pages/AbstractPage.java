package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Log;

public abstract class AbstractPage {

	
	protected WebDriver driver;
	protected WebDriverWait webDriverWait;

	public AbstractPage(WebDriver driver){
		this.driver = driver;
		this.webDriverWait = new WebDriverWait(driver, 30);
	}
	
	public void refreshPage() {
		
		Log.info("Refreshing the page");
		driver.navigate().refresh();		
	}

	public void browseBack() {

		Log.info("Navigating back");
		driver.navigate().back();		
	}
}
