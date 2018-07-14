package sslcertificates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class HandleSSLCertiticatesIE {
	
	public static void main(String[] args) {
		
		//InternetExplorerOptions not working
//		InternetExplorerOptions iEOptions = new InternetExplorerOptions();
//		iEOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		
		driver.get("https://expired.badssl.com/");
		
		driver.navigate().to("javascript:document.getElementById('overridelink').click()"); 
		
//		driver.findElement(By.xpath("//span[@id='moreInfoContainer']//a")).click();
//		driver.findElement(By.id("overridelink")).click();
				
	}

}
