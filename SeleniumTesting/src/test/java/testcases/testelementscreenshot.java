package testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testelementscreenshot {

public static WebDriver driver;
	
	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot//"+fileName));
	}
	
	public static void captureEleScreenshot(WebElement ele) throws IOException {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		BufferedImage fullImg = ImageIO.read(screenshot);
		
		Point point = ele.getLocation();
		int w = ele.getSize().getWidth();
		int h = ele.getSize().getHeight();
		
		BufferedImage eleScreenshot = fullImg.getSubimage(point.x, point.y, w, h);
		ImageIO.write(eleScreenshot, "jpg", screenshot);
		
		File screenshotLocation = new File (".\\screenshot\\"+fileName);
		FileUtils.copyFile(screenshot, screenshotLocation);
	}

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.way2automation.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div[1]/a/img"));
		
		
		captureScreenshot();
		captureEleScreenshot(ele);
		
		driver.quit();
	}

}
