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

public class ElementList {
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
		boolean isSelected = false;
		List<WebElement> rBtns = driver.findElements(By.xpath("//input[@type='radio' and @name='cars']"));
		int listSize = rBtns.size();
		System.out.println("Size of the List is: " + listSize);

		for (int i = 0; i < listSize; i++) {
			isSelected = rBtns.get(i).isSelected();

			if (!isSelected) {
				rBtns.get(i).click();
				Thread.sleep(2000);
			}
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
}
