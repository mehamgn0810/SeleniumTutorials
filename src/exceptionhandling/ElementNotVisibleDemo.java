package exceptionhandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementNotVisibleDemo {
	
	WebDriver driver;
	
	@Test
	public void test() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		List<WebElement> elements = driver.findElements(By.id("male"));
		
//		for(WebElement e: elements) {
//			if(e.isDisplayed()) {
//				e.click();
//				break;
//			}
//		}
		
		
		for(WebElement e: elements) {
			int x = e.getLocation().getX();
			if(x!=0) {
				e.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.close();
	}
	
	

}
