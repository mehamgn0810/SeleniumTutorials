package workingwithelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSelection {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Test
	public void test1() throws Exception {
		driver.get(baseUrl);
		// Flights tab click
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		// Departing field click
		driver.findElement(By.id("flight-departing-hp-flight")).click();

		WebElement dateField = driver
				.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]//button[text()='30']"));
		dateField.click();
	}

	@Test
	public void test2() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		driver.findElement(By.id("flight-departing-hp-flight")).click();
	
		WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"));
		List<WebElement> validDates = calMonth
				.findElements(By.xpath("//div[@class='datepicker-cal-month'][position()=1]//button[@class='datepicker-cal-date']"));
		
		Thread.sleep(3000);
		
		for(WebElement date: validDates) {
			if(date.getText().equals("28")) {
				date.click();
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
