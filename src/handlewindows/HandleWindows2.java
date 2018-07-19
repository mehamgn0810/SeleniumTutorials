package handlewindows;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleWindows2 {
	WebDriver driver;

	@Test
	public void f() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");

		driver.findElement(By.xpath("//div[@id='post-body-6170641642826198246']//a[@href='http://www.google.com']"))
				.click();
		Assert.assertTrue(verifyNewWindow("Google"), "Google Title verification failed");

		driver.findElement(By.xpath("//div[@id='post-body-6170641642826198246']//a[@href='http://www.facebook.com']"))
				.click();
		Assert.assertTrue(verifyNewWindow("Facebook"), "Facebook Title verification failed");

		driver.findElement(By.xpath("//div[@id='post-body-6170641642826198246']//a[@href='http://www.yahoo.com']"))
				.click();
		Assert.assertTrue(verifyNewWindow("Yahoo"), "Yahoo Title verification failed");
		
		driver.quit();

	}

	public boolean verifyNewWindow(String newWindowTitle) {
		String parentWindow = driver.getWindowHandle();
		List<String> allWindowsList = new ArrayList<String>(driver.getWindowHandles());
		allWindowsList.remove(parentWindow);
		String newWindow = allWindowsList.get(0);
		driver.switchTo().window(newWindow);
		String currentWindowTitle = driver.getTitle();
		driver.close();
		driver.switchTo().window(parentWindow);
		if (currentWindowTitle.contains(newWindowTitle)) {
			return true;
		} else {
			return false;
		}
	}

}