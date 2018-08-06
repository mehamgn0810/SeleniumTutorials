package headlessbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HTMLUnitDriverTest {
	//Ghost driver
	
	WebDriver driver;
	
	@Test
	public void testMethod() {
		
		//For Java
		/*
		 * No Browser is launched
		 * Fast execution - Increased performance of scripts
		 * Not suitable for Actions class - mouse Movement, double Click, drag and drop
		 */
		
		driver = new HtmlUnitDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
