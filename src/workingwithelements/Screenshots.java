package workingwithelements;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {

	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		driver.get(baseUrl);

		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("user_email")).sendKeys("Screehshot test");
		driver.findElement(By.name("commit")).click();
	}

	public String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	@After
	public void tearDown() throws Exception {
		String directory = "C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\SeleniumTutorials\\src\\screenshots\\";
		String fileName = getRandomString(5) + ".png";
		
		File destFile = new File(directory + fileName);
		
		/*
		 * TakesScreenshot is an interface
		 * down casting WebDriver to use getScreenshotAs method
		 */
		TakesScreenshot ss = ((TakesScreenshot)driver);
		File sourceFile = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, destFile);

		Thread.sleep(2000);
		driver.close();
	}

}
