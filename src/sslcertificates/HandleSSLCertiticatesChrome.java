package sslcertificates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class HandleSSLCertiticatesChrome {
	
	public static void main(String[] args) {
		
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://expired.badssl.com/");
	
		
	}

}
