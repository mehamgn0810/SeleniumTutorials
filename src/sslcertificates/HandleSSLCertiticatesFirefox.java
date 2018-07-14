package sslcertificates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class HandleSSLCertiticatesFirefox {

	public static void main(String[] args) {
		
		ProfilesIni profilesIni = new ProfilesIni();
		FirefoxProfile fProfile = profilesIni.getProfile("seleniumtest");
		fProfile.setAcceptUntrustedCertificates(true);
		fProfile.setAssumeUntrustedCertificateIssuer(false);
		
		FirefoxOptions fOptions = new FirefoxOptions();
		fOptions.setProfile(fProfile);
		//fOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		WebDriver driver = new FirefoxDriver(fOptions);
		
		driver.get("https://expired.badssl.com/");
	}

}
