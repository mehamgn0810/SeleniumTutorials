package toastmessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class HandleToastMessage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://codeseven.github.io/toastr/demo.html");
		
		driver.findElement(By.id("title")).sendKeys("Success!");
		driver.findElement(By.id("message")).sendKeys("This is a Success message");
		driver.findElement(By.id("showtoast")).click();
		
		String toastTitle = driver.findElement(By.className("toast-title")).getText();
		String toastMessage = driver.findElement(By.className("toast-message")).getText();
		
		System.out.println("Toast Title ==> " + toastTitle);
		System.out.println("Toast Message ==> " + toastMessage);
		
		Assert.assertEquals(toastTitle, "Success!", "Toast Title Assertion failed");
		Assert.assertEquals(toastMessage, "This is a Success mesage", "Toast Message Assertion failed");
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
