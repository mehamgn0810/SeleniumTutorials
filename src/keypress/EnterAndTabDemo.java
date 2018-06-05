package keypress;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterAndTabDemo {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys("test@example.com");
		
		email.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		driver.switchTo().activeElement().sendKeys("password");
		
		Thread.sleep(3000);
		//driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
