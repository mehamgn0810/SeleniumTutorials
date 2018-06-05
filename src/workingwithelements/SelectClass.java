package workingwithelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SelectClass {

	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	void test() throws InterruptedException {
		WebElement element = driver.findElement(By.id("carselect"));
		Select dropDown = new Select(element);

		Thread.sleep(2000);
		System.out.println("Select By Index...");
		dropDown.selectByIndex(1);

		Thread.sleep(2000);
		System.out.println("Select By Value...");
		dropDown.selectByValue("honda");

		Thread.sleep(2000);
		System.out.println("Select By VisibleText...");
		dropDown.selectByVisibleText("BMW");

		Thread.sleep(2000);
		System.out.println("Print All Options...");

		List<WebElement> options = dropDown.getOptions();
		int size = options.size();

		for (int i = 0; i < size; i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}

	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
