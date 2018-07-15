package switchto;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//When there are more than two handles , we need to assign each handle to a variable

public class SwitchHandles {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle: " + parentHandle);
		
		Thread.sleep(2000);
		//clicking Open Window link
		driver.findElement(By.id("openwindow")).click();
		
		//Get all handles
		Set<String> handles = driver.getWindowHandles();
		
		//printing all handles
		for(String handle: handles) {
			//System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				driver.findElement(By.id("search-courses")).sendKeys("python");
				
				Thread.sleep(2000);
				driver.close();
				break;
			}
		}
		
		//switch to parent window
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("test success");
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
