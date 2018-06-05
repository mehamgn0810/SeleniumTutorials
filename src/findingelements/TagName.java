package findingelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TagName {

	public static void main(String[] args) {

		String baseUrl = "http://demostore.x-cart.com/";
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);

		/*
		 * using tagName to locate element is highly unlikely because there would be
		 * many elements with same tagName. Selenium will find the first element and
		 * click or it may fail
		 */
		
		driver.findElement(By.tagName("a")).click();
		
		// id - fastest
		// name
		// classname
		// xpath
		// linktext
		// partial link text
		// tagname
		// css selector

	}

}
