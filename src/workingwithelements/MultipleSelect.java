package workingwithelements;

import java.util.List;

//To identify multiple select element, look for Select tag with 'multiple' attribute

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelect {

	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	void multipleSelectExample() throws Exception {
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select mSelect = new Select(element);
		
		Thread.sleep(2000);
		System.out.println("Select by value...");
		mSelect.selectByValue("apple");
		
		Thread.sleep(2000);
		System.out.println("deSelect by value...");
		mSelect.deselectByValue("apple");
		
		Thread.sleep(2000);
		System.out.println("Select by index...");
		mSelect.selectByIndex(1);
		
		Thread.sleep(2000);
		System.out.println("Select by visibleText...");
		mSelect.selectByVisibleText("Peach");
		
		Thread.sleep(2000);
		System.out.println("Print all Selected Options...");
		List<WebElement> selectedOptions = mSelect.getAllSelectedOptions();
		
		for(WebElement option: selectedOptions) {
			System.out.println(option.getText());
		}
		
		Thread.sleep(2000);
		System.out.println("Deselect All...");
		mSelect.deselectAll();

	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
