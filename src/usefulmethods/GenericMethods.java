package usefulmethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String locType, String locValue) {

		locType = locType.toLowerCase();

		if (locType.equals("id")) {
			return this.driver.findElement(By.id(locValue));
		} else if (locType.equals("name")) {
			return this.driver.findElement(By.name(locValue));
		} else if (locType.equals("css")) {
			return this.driver.findElement(By.cssSelector(locValue));
		} else if (locType.equals("xpath")) {
			return this.driver.findElement(By.xpath(locValue));
		} else if (locType.equals("linktext")) {
			return this.driver.findElement(By.linkText(locValue));
		} else if (locType.equals("partiallinktext")) {
			return this.driver.findElement(By.partialLinkText(locValue));
		} else {
			System.out.println("Invalid Locator Type: " + locType);
			return null;
		}
		
	}

	public boolean isElementPresent(String locType, String locValue) {

		List<WebElement> list = getElementList(locType, locValue);
		int listSize = list.size();

		if (listSize > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<WebElement> getElementList(String locType, String locValue) {

		locType = locType.toLowerCase();
		List<WebElement> elements = new ArrayList<WebElement>();

		if (locType.equals("id")) {
			elements = driver.findElements(By.id(locValue));
		} else if (locType.equals("name")) {
			elements = driver.findElements(By.name(locValue));
		} else if (locType.equals("css")) {
			elements = driver.findElements(By.cssSelector(locValue));
		} else if (locType.equals("xpath")) {
			elements = driver.findElements(By.xpath(locValue));
		} else if (locType.equals("linktext")) {
			elements = driver.findElements(By.linkText(locValue));
		} else if (locType.equals("partiallinktext")) {
			elements = driver.findElements(By.partialLinkText(locValue));
		} else {
			System.out.println("Invalid Locator Type: " + locType);
		}
		if (elements.isEmpty()) {
			System.out.println("Element(s) not Found with " + locType + " : " + locValue);
		} else {
			System.out.println("Element(s) Found with " + locType + " : " + locValue);
		}

		return elements;

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
