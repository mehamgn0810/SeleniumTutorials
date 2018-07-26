package bootstrapdropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdownBasic {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://mdbootstrap.com/javascript/material-select/");
		
		driver.findElement(By.xpath("//section[@id='basic']//div[contains(@class,'select-wrapper')]")).click();
		
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//ul//li//span"));
		
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getText().equals("Option 3")) {
				list.get(i).click();
			}
		}

	}

}
