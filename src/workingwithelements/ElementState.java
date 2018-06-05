package workingwithelements;

import java.util.concurrent.TimeUnit;

//Check for disabled attribute in the web element to check whether it is enabled or not

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementState {

	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.google.co.in";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	void test() {
		driver.get(baseUrl);

		WebElement e1 = driver.findElement(By.id("lst-ib"));
		System.out.println("E1 is Enabled? " + e1.isEnabled());

		WebElement e2 = driver.findElement(By.id("gs_taif0"));
		System.out.println("E1 is Enabled? " + e2.isEnabled());

		WebElement e3 = driver.findElement(By.id("gs_htif0"));
		System.out.println("E1 is Enabled? " + e3.isEnabled());

		e1.sendKeys("Python");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
