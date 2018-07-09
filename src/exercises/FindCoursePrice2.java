package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindCoursePrice2 {

	// using xPath directly
	public static void main(String[] args) {
		WebDriver driver;
		String baseUrl = "https://learn.letskodeit.com/p/practice";

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String courseName = driver.findElement(By.xpath("//table[@id=\"product\"]//tr[3]/td[2]")).getText();
		String courseAuthor = driver
				.findElement(By.xpath("//table[@id=\"product\"]//tr[3]/td[2]//parent::td//preceding-sibling::td"))
				.getText();
		String coursePrice = driver.findElement(By.xpath(
				"//table[@id=\"product\"]//tr[3]/td[2]//parent::td//preceding-sibling::td//following-sibling::td[2]"))
				.getText();

		System.out.println("Course Author: " + courseAuthor);
		System.out.println("Course Name: " + courseName);
		System.out.println("Course Price: " + coursePrice);
		
		driver.close();
	}

}
