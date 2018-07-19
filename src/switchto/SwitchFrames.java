package switchto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchFrames {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		//switch by id
		driver.switchTo().frame("courses-iframe");
		//switch by name
		//driver.switchTo().frame("iframe-name");
		//switch by frame number
		//driver.switchTo().frame(0);
		
		//Switch by WebElement
		//driver.switchTo().frame(WebElement);
		
		Thread.sleep(2000);
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement textBox = driver.findElement(By.id("name"));
		textBox.sendKeys("test successful");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
