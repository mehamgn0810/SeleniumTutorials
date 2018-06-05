package workingwithelements;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoComplete {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.southwest.com/";
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		String searchingText = "New York/Newark, NJ - EWR";
		String partialText = "new";

		WebElement departField = driver.findElement(By.id("air-city-departure"));
		departField.sendKeys(partialText);

		WebElement wrapper = driver.findElement(By.id("air-city-departure-menu"));
		List<WebElement> results = wrapper.findElements(By.tagName("li"));
		
		int size = results.size();
		System.out.println("Size of the list is: " + size);
		
		for	(int i=0; i<size; i++) {
			System.out.println(results.get(i).getText());
		}
		
		Thread.sleep(2000);
		for (WebElement result : results) {
			if (result.getText().equals(searchingText)) {
				result.click();
				System.out.println("Selected: " + result.getText());
				break;
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
