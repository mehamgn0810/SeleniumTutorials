package workingwithbrowserprofiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxProfiles {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fprofile = profile.getProfile("seleniumtest");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fprofile);
		
		driver = new FirefoxDriver(options);
		driver.get("http://www.google.com");
	}

}
