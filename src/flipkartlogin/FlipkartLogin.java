package flipkartlogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLogin {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='text']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='password']")).sendKeys("abcdef");
		driver.findElement(By.xpath("//div[@class='_1avdGP']//button[@type='submit']")).click();

	}

}
