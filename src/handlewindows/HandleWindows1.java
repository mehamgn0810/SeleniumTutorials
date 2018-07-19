package handlewindows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleWindows1 {
	WebDriver driver;

	@Test
	public void f() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.xpath("//div[@id='post-body-6170641642826198246']//a[@href='http://www.google.com']"))
				.click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allWindowsList = new ArrayList<String>(allWindows);
		allWindowsList.remove(parentWindow);
		String googleWindow = allWindowsList.get(0);

		driver.findElement(By.xpath("//div[@id='post-body-6170641642826198246']//a[@href='http://www.facebook.com']"))
				.click();
		allWindowsList = new ArrayList<String>(driver.getWindowHandles());
		allWindowsList.remove(parentWindow);
		allWindowsList.remove(googleWindow);
		String fbWindow = allWindowsList.get(0);

		driver.findElement(By.xpath("//div[@id='post-body-6170641642826198246']//a[@href='http://www.yahoo.com']"))
				.click();
		allWindowsList = new ArrayList<String>(driver.getWindowHandles());
		allWindowsList.remove(parentWindow);
		allWindowsList.remove(googleWindow);
		allWindowsList.remove(fbWindow);
		String yahooWindow = allWindowsList.get(0);
		
		driver.switchTo().window(googleWindow);
		Assert.assertEquals(driver.getTitle(), "Google", "Google Title verification failed");
		driver.close();
		
		driver.switchTo().window(fbWindow);
		Assert.assertTrue(driver.getTitle().contains("Facebook"), "Facebook Title Verification failed");
		driver.close();
		
		driver.switchTo().window(yahooWindow);
		Assert.assertTrue(driver.getTitle().contains("Yahoo"), "Yahoo Title Verification failed");
		driver.close();
		
		driver.switchTo().window(parentWindow);
		driver.close();
	}

}