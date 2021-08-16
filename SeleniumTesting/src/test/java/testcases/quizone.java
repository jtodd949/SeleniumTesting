package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class quizone {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//quiz 1
		driver.findElement(By.name("q")).sendKeys("Way2Automation");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());
		for (int i = 0; i < links.size(); i++)
			System.out.println(links.get(i).getText() + " --- URL IS --- " + links.get(i).getAttribute("href"));
		
		//quiz 2 is pointless
		
		
		//quiz 3
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		String numbers = driver.findElement(By.id("mathq2")).getText();
		String[] values = numbers.split(" ");
		int n1 = Integer.parseInt(values[0]);
		String op = values[1];
		int n2 = Integer.parseInt(values[2]);
		
		String fin = null;
		
		switch (op) {
		case "+":
			fin = String.valueOf(n1+n2);
			System.out.println(fin);
			break;
		case "-":
			fin = String.valueOf(n1-n2);
			System.out.println(fin);
			break;
		case "*":
			fin = String.valueOf(n1*n2);
			System.out.println(fin);
			break;
		case "/":
			fin = String.valueOf(n1/n2);
			System.out.println(fin);
			break;
		}
		
		driver.findElement(By.id("mathuserans2")).sendKeys(fin);
		driver.findElement(By.xpath("//*[@id=\"pollform\"]/table/tbody/tr[4]/td/div")).click();
		
		
		driver.close();
		driver.quit();
		
	}

}
