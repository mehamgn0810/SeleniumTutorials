package usefulmethods;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {

	WebDriver driver;
	String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void test() {
		driver.get(baseUrl);
		
		WebElement txtBox = driver.findElement(By.id("name"));
		
		String attrClass = txtBox.getAttribute("class");		
		System.out.println("Value of class attribute is: " + attrClass);
		
		String attrPlaceHolder = txtBox.getAttribute("placeholder");		
		System.out.println("Value of placeholder attribute is: " + attrPlaceHolder);
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
