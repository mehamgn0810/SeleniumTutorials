package switchto;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchAlert {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	public void test1() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Mehavarnan");
		Thread.sleep(2000);
		driver.findElement(By.id("alertbtn")).click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test
	public void test2() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Mehavarnan");
		Thread.sleep(2000);
		driver.findElement(By.id("confirmbtn")).click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
