package workingwithelements;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicActions {

	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	void test() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
		System.out.println("Clicked Login link...");
		driver.findElement(By.id("user_email")).sendKeys("test@gmail.com");
		System.out.println("Sending keys to username...");
		driver.findElement(By.id("user_password")).sendKeys("test@gmail.com");
		System.out.println("Sending keys to password...");
		driver.findElement(By.id("user_email")).clear();
		System.out.println("Username cleared...");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	
}
