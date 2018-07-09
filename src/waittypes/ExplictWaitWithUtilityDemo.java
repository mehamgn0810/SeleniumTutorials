package waittypes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.WaitTypes;

public class ExplictWaitWithUtilityDemo {

	WebDriver driver;
	String baseUrl;
	WaitTypes wt;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		wt = new WaitTypes(driver);
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	void test() {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();

		WebElement email = wt.waitForElement(By.id("user_email"), 3);
		email.sendKeys("ExplictWaitWithUtilityDemo");

		wt.clickWhenReady(By.name("commit"), 3);
	}

}
