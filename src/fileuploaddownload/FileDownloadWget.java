package fileuploaddownload;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadWget {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/test/yahoo.html");

		// WebElement downloadButton = driver.findElement(By.id("messenger-download"));
		// downloadButton.click();

		// to download to a specific folder
		String downloadDestination = "C:\\Users\\MEHAVARNAN\\Documents\\TestFolder\\";
		String downloadSource = driver.findElement(By.xpath("//div[@id='hdr_dwnld']//a")).getAttribute("href");
		String WgetPath = "C:\\Wget\\wget.exe";

		String command = "cmd /c " + WgetPath + " -P " + downloadDestination + " --no-check-certificate "
				+ downloadSource;

		try {
			Process exec = Runtime.getRuntime().exec(command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal);
		} catch (IOException | InterruptedException e) {
			System.out.println(e.toString());
		}
		
		driver.close();

	}

}
