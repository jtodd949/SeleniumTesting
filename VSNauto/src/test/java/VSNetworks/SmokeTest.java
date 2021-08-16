package VSNetworks;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmokeTest {

	public static WebDriver driver;
	public static String password;

	public static boolean isElementPresent(By by) {
		int size = driver.findElements(by).size();
		if (size == 0) {
			return false;
		} else {
			return true;
		}
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://app.vs-networks.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("SeleniumTestUser");
		driver.findElement(By.id("password")).sendKeys("Codigo#123");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// delete company
//		driver.findElement(By.linkText("Managers")).click();
//		driver.findElement(By.xpath("//*[@id=\"manager_xdlgkikg\"]/thead/tr/th[1]/input")).sendKeys("Selenium");
//		driver.findElement(By.xpath("//*[@id=\"manager_xdlgkikg\"]/tbody/tr/td[3]/a[3]/button/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();
		// kill driver
		driver.quit();
	}

	@Test(priority = 1)
	public void newManager() throws InterruptedException {
		// go to managers
		driver.findElement(By.linkText("Managers")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div/div/div[2]/div[1]")).click();
		driver.findElement(By.linkText("Create Manager")).click();
		driver.findElement(By.id("name")).sendKeys("Selenium Test Company");
		driver.findElement(By.xpath("//*[@id=\"create-form\"]/div[2]/div/div/button")).click();
		// find
		driver.findElement(By.xpath("//*[@id=\"manager_xdlgkikg\"]/thead/tr/th[1]/input"))
				.sendKeys("Selenium Test Company");

		Assert.assertEquals(isElementPresent(By.linkText("Selenium Test Company")), true);
	}

	@Test(priority = 2, enabled = false)
	public void newUser() throws InterruptedException, AWTException {
		// go to users
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div/div/div[2]/div[1]/button")).click();
		driver.findElement(By.linkText("Create User")).click();
		// user page
		driver.findElement(By.xpath("//*[@id=\"s2id_group-list\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li[2]")).click();
		driver.findElement(By.id("username")).sendKeys("New Selenium User");
		driver.findElement(By.id("fullname")).sendKeys("Full Selenium User");
		driver.findElement(By.id("email")).sendKeys("vsnseleniumtestuser@mailinator.com");
		driver.findElement(By.id("select2-chosen-2")).click();
		driver.findElement(By.xpath("//body")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("s2id_entity-list")).click();
		driver.findElement(By.id("s2id_autogen10_search")).sendKeys("Selenium");
		driver.findElement(By.xpath("//*[@id=\"randomize-password\"]")).click();
		password = driver.findElement(By.id("password")).getText();
		System.out.println(password);
		driver.findElement(By.xpath("//*[@id=\"save-button\"]")).click();
	}

	@Test(priority = 3, enabled = false)
	public void changePassword() {

	}

	@Test(priority = 4)
	public void newLocation() throws InterruptedException {
		// go to locations
		driver.findElement(By.linkText("Selenium Test Company")).click();
		driver.findElement(By.linkText("Add a Location")).click();
		// fill out location
		driver.findElement(By.id("name")).sendKeys("Selenium Location");
		driver.findElement(By.id("street-1")).sendKeys("Selenium Address");
		driver.findElement(By.id("city")).sendKeys("Selenium City");
		driver.findElement(By.id("state-province")).sendKeys("Kentucky");
		driver.findElement(By.id("postal-code")).sendKeys("40242");
		driver.findElement(By.id("timezone")).sendKeys("US/Eastern");
		driver.findElement(By.xpath("//*[@id=\"location-form\"]/div[1]/div/div[2]/div[6]/div/button")).click();
		Assert.assertTrue(true);
	}

	@Test(priority = 5)
	public void newMediaSystem() throws InterruptedException {
		// go to media systems
		driver.findElement(By.linkText("Add a Media System")).click();
		// fill out system
		driver.findElement(By.id("nickname")).sendKeys("Selenium Test Player");
		driver.findElement(By.id("scid")).sendKeys("593839");
		
		driver.findElement(By.id("s2id_content-packages-select")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).sendKeys("codigo template" + Keys.ENTER);
		
		Thread.sleep(10000);

//		driver.findElement(By.id("s2id_content-packages-select")).click();
//		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).sendKeys("honda power equipment");
//		Thread.sleep(1000);
//
//		driver.findElement(By.id("s2id_content-packages-select")).click();
//		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).sendKeys("smartplay - ace hardware");
//		Thread.sleep(1000);
		
		//save
		driver.findElement(By.xpath("//*[@id=\"machine-form\"]/div[6]/div/button")).click();
		Assert.assertTrue(true);
	}
	
	@Test(priority = 6)
	public void deviceControls() {
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div/ul/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div/ul/li[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div/ul/li[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div/ul/li[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/div/div/div/ul/li[5]")).click();
	}
}
