package waittypes;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo {
	
	private WebDriver driver;
	private String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	void test() {
		driver.get(baseUrl);
		
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id(("user_email"))).sendKeys("test");

	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
