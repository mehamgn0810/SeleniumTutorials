package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverDemo {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\geckodriver-v0.20.1\\geckodriver.exe");
		driver = new FirefoxDriver();

		String baseUrl = "http://www.google.com";

		driver.get(baseUrl);
		driver.close();

	}

}
