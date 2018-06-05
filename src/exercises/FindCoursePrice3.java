package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindCoursePrice3 {

	// using xPath - Effective one
	public static void main(String[] args) {
		WebDriver driver;
		String baseUrl = "https://learn.letskodeit.com/p/practice";

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String courseName = driver.findElement(By.xpath("//*[@id=\"product\"]//td[text()='Python Programming Language']")).getText();
		String courseAuthor = driver
				.findElement(By.xpath("//*[@id=\"product\"]//td[text()='Python Programming Language']//preceding-sibling::td"))
				.getText();
		String coursePrice = driver.findElement(By.xpath(
				"//*[@id=\"product\"]//td[text()='Python Programming Language']//following-sibling::td"))
				.getText();

		System.out.println("Course Author: " + courseAuthor);
		System.out.println("Course Name: " + courseName);
		System.out.println("Course Price: " + coursePrice);
		
		driver.close();

	}

}
