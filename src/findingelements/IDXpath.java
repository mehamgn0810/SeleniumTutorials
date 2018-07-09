package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IDXpath {

	public static void main(String[] args) {

		String baseUrl = "http://www.bing.co.in";

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\geckodriver-v0.20.1\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get(baseUrl);
		driver.findElement(By.id("sb_form_q")).sendKeys("letskodeit");
		driver.findElement(By.xpath("//*[@id=\"sb_form_go\"]")).click();
		

	}
}