package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testrightclick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement img = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
		
		Actions action = new Actions(driver);
		action.contextClick(img).perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"dm2m1i1tdT\"]"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"dm2m2i1tdT\"]"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"dm2m3i1tdT\"]"))).perform();
		
		
	}

}
