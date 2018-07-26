package singletoninselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {

	private static DriverInit driverInstance = null;
	private WebDriver driver;
	
	private DriverInit() {
		
	}
	
	public WebDriver openBrowser() {
		driver = new ChromeDriver();
		return driver;
	}
	
	public static DriverInit getInstance() {
		if(driverInstance == null)
			driverInstance = new DriverInit();
		return driverInstance;
	}
}
