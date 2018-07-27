package exceptionhandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementReferenceException {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
				
		username.sendKeys("admin");
		password.sendKeys("admin");
		loginButton.click();
		
		driver.navigate().refresh();
		
		/*
		 * Here, we can verify staleness of the element and find again
		 * or we can directly go ahead and find the element
		 */
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean stale = wait.until(ExpectedConditions.stalenessOf(username));
		
		if(stale) {
			username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUsername")));
		}
		
		username.sendKeys("Admin");
	}

}
