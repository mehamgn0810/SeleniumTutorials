package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

	WebDriver driver;

	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElement(By locator, int timeouts) {

		WebElement element = null;

		try {
			System.out.println("Waiting for " + timeouts + " seconds for the element to appear");
			WebDriverWait wait = new WebDriverWait(driver, timeouts);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeared on the webpage");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void clickWhenReady(By locator, int timeouts) {

		try {
			WebElement element = null;
			System.out.println("Waiting for " + timeouts + " seconds for the element to click");
			WebDriverWait wait = new WebDriverWait(driver, timeouts);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the webpage");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
