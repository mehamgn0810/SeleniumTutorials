package waittypes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";

		driver.manage().window().maximize();
	}

	@Test
	void test() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();

		WebDriverWait wait = new WebDriverWait(driver, 3);

		WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		emailBox.sendKeys("test");

	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
