package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverDemo {

	public static void main(String[] args) {
//		http://selenium-release.storage.googleapis.com/index.html
		
		String baseUrl = "http://www.google.com";
		System.setProperty("webdriver.ie.driver", "C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");

		WebDriver driver = new InternetExplorerDriver();
		driver.get(baseUrl);
		
		driver.close();
	}

}
