package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	/*
	 * ChromeDriver Url --> http://chromedriver.storage.googleapis.com/index.html
	 */

	public static void main(String[] args) {

		String baseUrl = "http://www.google.com";

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(baseUrl);
		driver.close();

	}

}
