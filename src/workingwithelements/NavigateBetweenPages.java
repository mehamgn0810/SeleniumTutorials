package workingwithelements;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateBetweenPages {

	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		String pageTitle = driver.getTitle();
		System.out.println("PageTitle is: " + pageTitle);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("CurrentUrl is: " + currentUrl);

		String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		driver.navigate().to(urlToNavigate);
		System.out.println("Navigating to Login page...");
		currentUrl = driver.getCurrentUrl();
		System.out.println("CurrentUrl is: " + currentUrl);

		Thread.sleep(2000);

		driver.navigate().back();
		System.out.println("Navigating back to Home Page...");
		currentUrl = driver.getCurrentUrl();
		System.out.println("CurrentUrl is: " + currentUrl);

		Thread.sleep(2000);

		driver.navigate().forward();
		System.out.println("Navigating forward to Login page...");
		currentUrl = driver.getCurrentUrl();
		System.out.println("CurrentUrl is: " + currentUrl);

		Thread.sleep(2000);

		driver.navigate().back();
		System.out.println("Navigating back to Home Page...");
		currentUrl = driver.getCurrentUrl();
		System.out.println("CurrentUrl is: " + currentUrl);

		Thread.sleep(2000);

		driver.navigate().refresh();
		System.out.println("Navigate Refresh...");
		currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);
		System.out.println("Refresh by Current Url...");

		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}

	@AfterEach
	void tearDown() throws Exception {
		// driver.close();
	}

}
