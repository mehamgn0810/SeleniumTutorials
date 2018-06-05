package javascriptexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptIntro {
	private WebDriver driver;
	//private String baseUrl;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		//baseUrl = "http://letskodeit.teachable.com/pages/practice";
		js = (JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		
		js.executeScript("window.location = 'http://letskodeit.teachable.com/pages/practice';");
		
		WebElement textBox = (WebElement)js.executeScript("return document.getElementById('name');");
		textBox.sendKeys("javascript");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
