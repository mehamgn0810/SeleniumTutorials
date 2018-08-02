package headlessbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class PhantomJsTest {
	
	WebDriver driver;
	
	@Test
	public void testMethod() {
		
		//System.setProperty does not work for PhantomJsDriver. Hence DesiredCapabilities is used
		//System.setProperty("phantomjs.binary.path", "C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\drivers\\phantomjs.exe");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\drivers\\phantomjs.exe");
		driver = new PhantomJSDriver(caps);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
