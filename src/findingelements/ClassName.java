package findingelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClassName {

	public static void main(String[] args) {
		
		//class(className) is associated with CSS for styling

		String baseUrl = "http://demostore.x-cart.com/";
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);

		/*
		 * if className value has spaces(multiple values), we shall use CSS selector to locate the element
		 * values with spaces doesn't work it seems
		 */
		driver.findElement(By.className("theme-label")).click();
		
		/*
		 * driver.findElement(By.className("leaf")).click();
		 * there are multiple occurrences for 'leaf'. This cannot be located using className.
		 */
		

	}

}
