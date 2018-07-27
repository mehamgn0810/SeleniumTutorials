package exceptionhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementNotClickableDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freecrm.com/");
		
		driver.findElement(By.name("username")).sendKeys("testing");
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		loginBtn.click();
		
		//Using Explicit wait - Preferred one
//		WebDriverWait wait = new WebDriverWait(driver, 3);
//		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
//		
//		if(invisible) {
//			loginBtn.click();
//		}
		
		
		//Using JavaScript Executor
//		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//		javascriptExecutor.executeScript("arguments[0].click();", loginBtn);

	}

}
