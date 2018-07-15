package fileuploaddownload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String fileToUpload = "C:\\Users\\MEHAVARNAN\\Documents\\TestFolder\\test.txt";
		
		driver.get("http://demo.guru99.com/test/upload/");
		
		WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
		//chooseFile.sendKeys(fileToUpload);
		
		chooseFile.click();
		
		uploadFileUsingRobotClass(fileToUpload);
		
		
	}

	public static void uploadFileUsingRobotClass(String filePath) {
		StringSelection ss = new StringSelection(filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(ss, null);

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void uploadFileUsingAutoIt() throws Exception {
		
		//Not sure whether AutoIt supports parameterizing. We need to create .exe file everytime
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\OrangeHRM\\AutoIt\\uploadFile.exe");
	}
}
