package workingwithbrowserprofiles;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsTest {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\MEHAVARNAN\\AppData\\Local\\"
				+ "Google\\Chrome\\User Data\\Default\\Extensions\\aapocclcgogkmnckokdopfmhonfmgoek\\0.10_0.crx"));
		
		driver = new ChromeDriver(options);

		driver.get("https://www.google.com");
	}

}
