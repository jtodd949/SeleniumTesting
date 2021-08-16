package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testdropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.wikipedia.org");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.name("country")).sendKeys("Germany");
		
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
		select.selectByValue("hi");
		
		List<WebElement> values = driver.findElements(By.tagName("option"));
		System.out.println("Total number of values: " + values.size());
		for (int i = 0; i < values.size(); i++)
			System.out.println(values.get(i).getAttribute("lang"));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());
		for (int i = 0; i < links.size(); i++)
			System.out.println(links.get(i).getText() + " --- URL IS --- " + links.get(i).getAttribute("href"));
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
		List<WebElement> linksinblock = block.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + linksinblock.size());
		for (int i = 0; i < linksinblock.size(); i++)
			System.out.println(linksinblock.get(i).getText() + " --- URL IS --- " + linksinblock.get(i).getAttribute("href"));
		

		
		driver.close();
		driver.quit();
	}
}
