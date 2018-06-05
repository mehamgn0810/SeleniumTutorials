package workingwithelements;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Working with Hidden Elements

public class ElementIsDisplayed {

	WebDriver driver;
	String baseUrl1;
	String baseUrl2;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl1 = "http://letskodeit.teachable.com/pages/practice";
		baseUrl2 = "https://www.expedia.co.in";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	void letsKodeIt() throws Exception {
		driver.get(baseUrl1);
		WebElement textbox = driver.findElement(By.id("displayed-text"));
		System.out.println("Textbox is displayed? " + textbox.isDisplayed());

		Thread.sleep(2000);

		WebElement hideBtn = driver.findElement(By.id("hide-textbox"));
		System.out.println("Click Hide Button...");
		hideBtn.click();
		System.out.println("Textbox is displayed? " + textbox.isDisplayed());

		Thread.sleep(2000);

		WebElement showBtn = driver.findElement(By.id("show-textbox"));
		System.out.println("Click Show Button...");
		showBtn.click();
		System.out.println("Textbox is displayed? " + textbox.isDisplayed());

	}

	@Test
	void expedia() throws Exception {
		driver.get(baseUrl2);
		WebElement childAge = driver.findElement(By.id("hotel-1-age-select-1"));
		System.out.println("Child Age dropdown is displayed? " + childAge.isDisplayed());
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
