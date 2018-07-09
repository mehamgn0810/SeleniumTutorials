package javascriptexecution;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Javascript click must be use when selenium .click() method doesn't work
 * test2 is an example
 */

public class JavaScriptClick {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	private String baseUrl1;
	private String baseUrl2;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		js = (JavascriptExecutor)driver;
		baseUrl1 = "http://letskodeit.teachable.com/pages/practice";
		baseUrl2 = "https://www.retailmenot.com/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Test
	public void test1() throws InterruptedException {
		driver.get(baseUrl1);
		WebElement checkBox = driver.findElement(By.id("bmwcheck"));
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", checkBox);
	}
	
	@Test
	public void test2() throws InterruptedException {
		driver.get(baseUrl2);
		driver.findElement(By.xpath("//div[text()='Log In / Sign up']")).click();
		
		WebElement checkBox = driver.findElement(By.id("subscribe"));
		System.out.println("Displayed: " + checkBox.isDisplayed());
		System.out.println("Enabled: " + checkBox.isEnabled());
		System.out.println("Selected: " + checkBox.isSelected());
		//checkBox.click();
				
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", checkBox);
		System.out.println("Selected: " + checkBox.isSelected());
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
