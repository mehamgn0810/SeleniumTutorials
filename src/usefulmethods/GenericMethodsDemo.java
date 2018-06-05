package usefulmethods;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulmethods.GenericMethods;

public class GenericMethodsDemo {

	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		gm = new GenericMethods(driver);
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void test() throws Exception {
		driver.get(baseUrl);
		

		WebElement e1 = gm.getElement("id", "name1");
		e1.clear();
		e1.sendKeys("id test");
		System.out.println("id test complete");

		Thread.sleep(2000);
		WebElement e2 = gm.getElement("name", "show-hide");
		e2.clear();
		e2.sendKeys("name test");
		System.out.println("name test complete");

		Thread.sleep(2000);
		WebElement e3 = gm.getElement("css", "input[id='name']");
		e3.clear();
		e3.sendKeys("css test");
		System.out.println("css test complete");

		Thread.sleep(2000);
		WebElement e4 = gm.getElement("xpath", "//input[@id='displayed-text']");
		e4.clear();
		e4.sendKeys("xpath test");
		System.out.println("xpath test complete");

		/*
		 * partiallinktext for Login not working
		 * 
		 * Build XPath if partial link is not working. In real time, we usually do not
		 * depend on link text or partial link text to find elements, these are usually
		 * flaky. If an element has id/name then it's great. If not, then XPath is the
		 * most reliable way to work with elements.
		 */

		Thread.sleep(2000);
		WebElement e5 = gm.getElement("xpath", "//div[@id='navbar']//a[@href='/sign_in']");
		//scroll to the element
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", e5); 
		e5.click();
		System.out.println("click Login test complete");

		Thread.sleep(2000);
		WebElement e6 = gm.getElement("xpath", "//form[@id='new_user']//a");
		e6.click();
		System.out.println("click forgot password test complete");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
