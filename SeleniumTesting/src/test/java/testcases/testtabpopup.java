package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testtabpopup {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Set<String> win = driver.getWindowHandles();
		Iterator<String> iterate = win.iterator();
		
		String first = iterate.next();
		System.out.println(first);
		
		driver.findElement(By.id("loginsubmit")).click();
		
		
		//2nd win
		win = driver.getWindowHandles();
		iterate = win.iterator();
		
		System.out.println(iterate.next());
		String second = iterate.next();
		System.out.println(second);
		
		driver.switchTo().window(second);
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a")).click();;
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[3]/a")).click();
		
		//3rd win
		win = driver.getWindowHandles();
		iterate = win.iterator();
		
		System.out.println(iterate.next());
		System.out.println(iterate.next());
		String third = iterate.next();
		System.out.println(third);
		
		driver.switchTo().window(third);
		System.out.println(driver.getTitle().contains("JetPrivilege HDFC Bank Signature"));
		
		
		//driver.close();
		//driver.switchTo().window(second);
		//driver.close();
		driver.quit();
	}

}
