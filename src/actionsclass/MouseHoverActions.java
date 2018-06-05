package actionsclass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverActions {
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		js.executeScript("window.scrollBy(0, 800);");
		
		Thread.sleep(2000);
		WebElement mouseHoverLink = driver.findElement(By.id("mousehover"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverLink).perform();
		
		Thread.sleep(2000);
		WebElement hoverOption1 = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		//WebElement hoverOption2 = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Reload']"));
		hoverOption1.click();
		//action.moveToElement(hoverOption2).click().perform();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
