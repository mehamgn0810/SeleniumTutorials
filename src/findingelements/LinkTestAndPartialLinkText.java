package findingelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkTestAndPartialLinkText {

	public static void main(String[] args) throws Exception {
		String baseUrl = "https://letskodeit.teachable.com/";

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\geckodriver-v0.20.1\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//waits till 10 seconds before throwing NoSuchElement Exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		driver.findElement(By.linkText("Login")).click();
		//Halts the execution for defined time(gives memory for other threads if available)
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Pract")).click();

	}

}
