package hashmapinselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HashMapTest {
	WebDriver driver;
	
  @Test
  public void f() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  String[] credentials = Data.credentialsMap().get("admin").split(":");
	  
	  driver.findElement(By.id("txtUsername")).sendKeys(credentials[0]);
	  driver.findElement(By.id("txtPassword")).sendKeys(credentials[1]);
	  driver.findElement(By.id("btnLogin")).click();
  }
}
