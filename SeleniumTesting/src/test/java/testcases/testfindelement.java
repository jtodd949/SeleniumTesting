package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testfindelement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle().length());
		System.out.println(driver.getTitle());
		driver.findElement(By.id("identifierId")).sendKeys("jtodd949@gmail.com");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		
		driver.close();
		driver.quit();
	}

}
