package actionsclass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://jqueryui.com/droppable/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		driver.switchTo().frame(0);
		
		WebElement fromElement = driver.findElement(By.id("draggable"));
		WebElement toElement = driver.findElement(By.id("droppable"));
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		//Drag and Drop
		action.dragAndDrop(fromElement, toElement).build().perform();
		
		//Click and Hold, move, release
		//action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
