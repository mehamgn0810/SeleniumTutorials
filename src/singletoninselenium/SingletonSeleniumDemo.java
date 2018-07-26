package singletoninselenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingletonSeleniumDemo {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		DriverInit driverInstance = DriverInit.getInstance();
		driver = driverInstance.openBrowser();
	}
	
	@Test
	public void testMethod() {
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
