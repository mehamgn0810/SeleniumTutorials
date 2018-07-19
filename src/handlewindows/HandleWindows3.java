package handlewindows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleWindows3 {
	
	WebDriver driver;
	
	@Test
	public void f() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		List<String> windowsToClose = new ArrayList<String>(Arrays.asList("Haier"));
		closeWindows(windowsToClose);	
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	public void closeWindows(List<String> windowsToClose) {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		allWindows.remove(parentWindow);
		for(String item: allWindows) {
			driver.switchTo().window(item);
			if(windowsToClose.contains(driver.getTitle())) {
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
}
