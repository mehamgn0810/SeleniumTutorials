package qrcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class HandleQRCode {
	
	//https://www.the-qrcode-generator.com
	
	/*
	 * jar files
	 * https://github.com/zxing/zxing
	 * https://github.com/zxing/zxing/releases
	 * https://mvnrepository.com/artifact/com.google.zxing/javase
	 */

	public static void main(String[] args) throws IOException, NotFoundException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("file://C:/Users/MEHAVARNAN/Documents/eclipse-workspace/zxing/testQRCode.png");
		
		String urlOfImage = driver.findElement(By.tagName("img")).getAttribute("src");
		URL url = new URL(urlOfImage);
		
		BufferedImage bImage = ImageIO.read(url);
		
		LuminanceSource lSource = new BufferedImageLuminanceSource(bImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(lSource));
		
		Result result = new MultiFormatReader().decode(binaryBitmap);
		String qrCodeText = result.getText();
		
		System.out.println(qrCodeText);
		
		driver.close();
		

	}

}
