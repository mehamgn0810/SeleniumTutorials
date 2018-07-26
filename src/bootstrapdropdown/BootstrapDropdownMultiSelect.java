package bootstrapdropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdownMultiSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://mdbootstrap.com/javascript/material-select/");
		
		driver.findElement(By.xpath("//section[@id='multiple']//div[contains(@class,'select-wrapper')]")).click();
		
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//ul//li//span"));
		
		for(int i=0; i<list.size();i++) {
			String value = list.get(i).getText();
			if(value.equals("Option 3") || value.equals("Option 1")) {
				list.get(i).click();
			}
		}

		driver.findElement(By.id("multiple")).click();
	}

}
