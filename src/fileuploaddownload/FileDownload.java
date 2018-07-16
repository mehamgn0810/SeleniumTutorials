package fileuploaddownload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownload {
	
	WebDriver driver;
	File folder;

	@BeforeMethod
	public void setUp() {
		//15248-4454652-126542-564654
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("start-maximized");
		
		driver = new ChromeDriver(options);
		
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.cssSelector(".example a")).click();
		
		Thread.sleep(3000);
		File listOfFiles[] = folder.listFiles();
		Assert.assertTrue(listOfFiles.length>0);
		
		for(File file: listOfFiles) {
			Assert.assertTrue(file.length()>0);
		}
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		for(File file: folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}

}
