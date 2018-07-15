package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindCoursePrice1 {
	
	// using cssSelector directly

	public static void main(String[] args) {

		WebDriver driver;
		String baseUrl = "https://learn.letskodeit.com/p/practice";

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String courseName = driver.findElement(By.cssSelector("#product > tbody > tr:nth-child(3) > td:nth-child(2)"))
				.getText();
		String cousePrice = driver.findElement(By.cssSelector("#product > tbody > tr:nth-child(3) > td:nth-child(3)"))
				.getText();

		System.out.println("Course Price for " + courseName + " is " + cousePrice);

		driver.close();
	}

}
