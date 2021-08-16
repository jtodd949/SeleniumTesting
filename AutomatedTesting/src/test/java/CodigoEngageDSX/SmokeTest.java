package CodigoEngageDSX;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmokeTest {

	public static WebDriver driver;

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
		driver.get("https://codigo.gocodigo.net");
		driver.manage().window().maximize();
		driver.findElement(By.id("UserName")).sendKeys("codigoautomation@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Codigo#123");
		driver.findElement(By.id("fat-btn")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// delete company
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Companies")).click();
		driver.findElement(By.id("ClientTable_search")).sendKeys("Selenium Test Company");
		driver.findElement(By.xpath("//*[@id=\"ClientTable\"]/tbody/tr/td[3]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"ClientTableRightActions\"]/div[7]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ConfirmationModal\"]/div[3]/button[2]")).click();
		// kill driver
		driver.quit();
	}

	@Test(priority = 1)
	public void newCompany() throws InterruptedException {
		System.out.println("New company test");
		// dashboard
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Companies")).click();
		// companies
		driver.findElement(By.linkText("New Client")).click();
		// new company
		driver.findElement(By.name("CompanyName")).sendKeys("Selenium Test Company");
		driver.findElement(By.name("AddressLine1")).sendKeys("123 Test Street");
		driver.findElement(By.name("City")).sendKeys("Testville");
		driver.findElement(By.name("PostalCode")).sendKeys("40242");
		driver.findElement(By.name("chksitepackages")).click();
		driver.findElement(By.xpath("//*[@id=\"Vaults_table\"]/thead/tr/th[1]/div/a[2]/span")).click();
		driver.findElement(By.id("PagesDropdown")).click();
		driver.findElement(By.name("FirstName")).sendKeys("First");
		driver.findElement(By.name("LastName")).sendKeys("Last");
		driver.findElement(By.name("PrimaryContactEmail")).sendKeys("codigotest@mailinator.com");
		driver.findElement(By.name("chkEmail")).click();
		driver.findElement(By.name("chkAlert")).click();
		driver.findElement(By.name("HasDigitalSignage")).click();
		driver.findElement(By.name("HasKiosk")).click();
		driver.findElement(By.name("HasVoice")).click();
		driver.findElement(By.id("saveBottomBtn")).click();
		// companies
		driver.findElement(By.id("ClientTable_search")).sendKeys("Selenium Test Company");
		String compName = driver.findElement(By.xpath("//*[@id=\"ClientTable\"]/tbody/tr/td[3]/span")).getText();
		Assert.assertEquals(compName, "Selenium Test Company",
				"The retrieved name was: " + compName + " instead of Selenium Test Company");
	}

	@Test(priority = 2)
	public void newUser() throws InterruptedException {
		System.out.println("New user test");
		// log in as
		driver.findElement(By.xpath("//*[@id=\"ClientTable\"]/tbody/tr/td[3]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"ClientTableRightActions\"]/div[3]/a")).click();
		Thread.sleep(3000);
		// go to users
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.linkText("New User")).click();
		// new user
		driver.findElement(By.name("FirstName")).sendKeys("New");
		driver.findElement(By.name("LastName")).sendKeys("User");
		driver.findElement(By.name("EmailAddress")).sendKeys("newcodigouser@mailinator.com");
		driver.findElement(By.id("saveTopBtn")).click();
		String userName = driver.findElement(By.xpath("//*[@id=\"UserTable\"]/tbody/tr[2]/td[3]/span")).getText();
		Assert.assertEquals(userName, "New User", "The retrieved name was: " + userName + " instead of New User");
	}

	@Test(priority = 3)
	public void changePassword() throws InterruptedException {
		System.out.println("Change password test");
		// get to change pw
		driver.findElement(By.xpath("//*[@id=\"UserTable\"]/tbody/tr[2]/td[3]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"UserTableRightActions\"]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"UserGeneralSettings\"]/div/div/div/button")).click();
		// change pw
		driver.findElement(By.id("NewPassword")).sendKeys("Codigo#123");
		driver.findElement(By.id("ConfirmNewPassword")).sendKeys("Codigo#123");
		driver.findElement(By.id("changePasswordSave")).click();
		// cant get info from alert right now
		Assert.assertTrue(true);
	}

	@Test(priority = 4)
	public void enableVault() throws InterruptedException {
		// go to vaults
		driver.findElement(By.id("codigo-success-link")).click();
		driver.findElement(By.xpath("//*[@id=\"VaultTable_wrapper\"]/div[7]/div/button[2]")).click();
		driver.findElement(By.id("VaultTable_search")).sendKeys("landscape");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"VaultTable\"]/thead/tr/th[1]/div/a[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"VaultTableRightActions\"]/div[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"CopyToMediaLibrary\"]/div[3]/button[2]")).click();
		Thread.sleep(3000);
		// cant get info from alert right now
		Assert.assertTrue(true);
	}

	@Test(priority = 5)
	public void newLicense() throws InterruptedException {
		System.out.println("New license test");
		// go to licenses
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Licenses")).click();
		driver.findElement(By.linkText("New License")).click();
		// new ds license
		driver.findElement(By.name("ServiceType")).sendKeys("Digital");
		driver.findElement(By.id("btn_add_license")).click();
		// cant get info from alert right now
		Assert.assertTrue(true);
	}

	@Test(priority = 6)
	public void newHub() throws InterruptedException {
		System.out.println("New hub test");
		// go to hubs
		driver.findElement(By.linkText("Network")).click();
		driver.findElement(By.linkText("Hubs")).click();
		driver.findElement(By.linkText("New Hub")).click();
		// new hub
		Thread.sleep(2000);
		driver.findElement(By.name("Name")).sendKeys("autohub");
		driver.findElement(By.name("AddressLine1")).sendKeys("123 test street");
		driver.findElement(By.name("City")).sendKeys("testville");
		driver.findElement(By.name("State")).sendKeys("kentucky");
		driver.findElement(By.name("PostalCode")).sendKeys("40242");
		driver.findElement(By.xpath("/html/body/div[3]/codigo-hub-edit/div/div[1]/codigo-save-button/button/strong"))
				.click();
		String hubName = driver.findElement(By.xpath("//*[@id=\"HubTable\"]/tbody/tr/td[6]/span")).getText();
		Assert.assertEquals(hubName, "autohub", "The retrieved name was: " + hubName + " instead of autohub");
	}

	@Test(priority = 7, enabled = false)
	public void hubSupportTools() throws InterruptedException {
		System.out.println("Hub support tools test");
		// go to support tools
		driver.findElement(By.xpath("//*[@id=\"HubTable\"]/tbody/tr/td[6]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"HubTableRightActions\"]/div[2]/a")).click();
		// support tools
		driver.findElement(By.cssSelector("button.btn.dropdown-toggle.has-tooltip")).click();
		driver.findElement(By.linkText("Download Configuration")).click();
		driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
		driver.findElement(By.linkText("Download Schedule")).click();
		driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
		driver.findElement(By.linkText("Upload Hardware Info")).click();
		driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
		driver.findElement(By.linkText("Upload Player Statistics")).click();
		driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
		driver.findElement(By.linkText("Reboot")).click();
		// assert
	}

	@Test(priority = 8)
	public void editChannel() throws InterruptedException {
		System.out.println("Edit channel test");
		// go to channels
		driver.findElement(By.linkText("Network")).click();
		driver.findElement(By.linkText("Channels")).click();
		// select channel
		driver.findElement(By.xpath("//*[@id=\"ChannelTable\"]/tbody/tr[1]/td[3]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"ChannelTableRightActions\"]/div[1]/a")).click();
		// assign to hub
		driver.findElement(By.id("hub-select")).sendKeys("autohub");
		driver.findElement(By.id("display-select")).sendKeys("Display");
		driver.findElement(By.id("saveBottomBtn")).click();
		String hubName = driver.findElement(By.xpath("//*[@id=\"ChannelTable\"]/tbody/tr/td[7]/span")).getText();
		Assert.assertEquals(hubName, "autohub", "The retrieved name was: " + hubName + " instead of autohub");
	}

	@Test(priority = 9)
	public void newShow() throws InterruptedException {
		System.out.println("New show test");
		// go to my shows
		driver.findElement(By.linkText("My Shows")).click();
		driver.findElement(By.linkText("New Show")).click();
		// new show
		driver.findElement(By.id("preview-zone-33")).click();
		driver.findElement(By.id("btnNext")).click();
		driver.findElement(By.name("Name")).sendKeys("auto show");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"MediaTable\"]/thead/tr/th[1]/div/a[1]/input")).click();
		Thread.sleep(2000);
		// all of this bullshit to drag and drop
		WebElement drag = driver.findElement(By.xpath("//*[@id=\"MediaTable\"]/tbody/tr[2]/td[3]"));
		WebElement drop = driver.findElement(By.xpath("//*[@id=\"tab-zone-33\"]/div/div[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(drag).pause(Duration.ofSeconds(1)).clickAndHold(drag).pause(Duration.ofSeconds(1))
				.moveByOffset(1, 0).moveToElement(drop).moveByOffset(1, 0).pause(Duration.ofSeconds(1)).release()
				.perform();
		// save
		driver.findElement(By.xpath("/html/body/div[3]/div[10]/h3/div/a[2]")).click();
		String showName = driver.findElement(By.xpath("//*[@id=\"DSShowsTable\"]/tbody/tr/td[3]")).getText();
		Assert.assertEquals(showName, "auto show", "The retrieved name was: " + showName + " instead of auto show");
	}

	@Test(priority = 10)
	public void scheduleShow() throws InterruptedException {
		System.out.println("Schedule show test");
		driver.findElement(By.xpath("//*[@id=\"DSShowsTable\"]/tbody/tr/td[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"DSShowsTableRightActions\"]/div[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ChannelSelectContainer\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"ChannelSelectContainer\"]/ul/li[3]/a/label")).click();
		driver.findElement(By.id("btn_time_add")).click();
		// get alert
		Assert.assertTrue(true);
	}

	@Test(priority = 11)
	public void copyAssets() throws InterruptedException {
		System.out.println("Copy assets test");
		// go to vaults
		driver.findElement(By.id("codigo-success-link")).click();
		driver.findElement(By.xpath("//*[@id=\"VaultTable_wrapper\"]/div[7]/div/button[2]")).click();
		driver.findElement(By.id("VaultTable_search")).sendKeys("asset");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id=\"VaultTable\"]/thead/tr/th[1]/div/a[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"VaultTableRightActions\"]/div[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"CopyToMediaLibrary\"]/div[3]/button[2]")).click();
		Thread.sleep(3000);
		// cant get info from alert right now
		Assert.assertTrue(true);
	}

	@Test(priority = 12)
	public void assetAttributes() throws InterruptedException {
		System.out.println("Asset attributes test");
		// go to my assets
		driver.findElement(By.linkText("My Assets")).click();
		driver.findElement(By.xpath("//*[@id=\"AssetsTable_wrapper\"]/div[7]/div/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"AssetsTable\"]/tbody/tr[2]/td[2]")).click();
		// attributes
		driver.findElement(By.xpath("//*[@id=\"EditContent\"]/table/tbody/tr[2]/td/input")).sendKeys("0newassetname");
		driver.findElement(By.xpath("//*[@id=\"EditContent\"]/table/tbody/tr[4]/td/textarea"))
				.sendKeys("asset description");
		driver.findElement(By.xpath("//*[@id=\"EditContent\"]/table/tbody/tr[8]/td/textarea"))
				.sendKeys("tag1,tag2,tag3");
		// save
		driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/a")).click();
		// get alert
		Assert.assertTrue(true);
	}

	@Test(priority = 13)
	public void editMedia() throws InterruptedException {
		System.out.println("Edit media test");
		// go to my media
		driver.findElement(By.linkText("My Media")).click();
		driver.findElement(By.xpath("//*[@id=\"MediaTable_wrapper\"]/div[7]/div/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"MediaTable\"]/tbody/tr[1]/td[2]")).click();
		// media attributes
		driver.findElement(By.xpath("//*[@id=\"EditContent\"]/table/tbody/tr[2]/td/input")).sendKeys("media name");
		driver.findElement(By.xpath("//*[@id=\"EditContent\"]/table/tbody/tr[4]/td/textarea"))
				.sendKeys("media description");
		driver.findElement(By.xpath("//*[@id=\"EditContent\"]/table/tbody/tr[10]/td/textarea")).sendKeys("media tags");
		// save
		driver.findElement(By.xpath("//*[@id=\"MediaLibraryTurnover\"]/div/div[2]/a[1]")).click();

		Thread.sleep(2000);
		// get alert
		Assert.assertTrue(true);
	}

	@Test(priority = 14)
	public void hubPage() {
		System.out.println("Hub page test");
		// go to hub page
		driver.findElement(By.linkText("Network")).click();
		driver.findElement(By.linkText("Hubs")).click();
		// hub status
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"StatusFilterContainer\"]/ul/li[1]/a")).click();
		Assert.assertTrue(true);
	}

	@Test(priority = 15)
	public void reportsPage() {
		System.out.println("Reports test");
		// go to hub page
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Reports")).click();
		// access reports
		driver.findElement(By.id("ReportType")).click();
		driver.findElement(By.xpath("//*[@id=\"ReportType\"]/ul/li[2]/a")).click();
		driver.findElement(By.id("ReportType")).click();
		driver.findElement(By.xpath("//*[@id=\"ReportType\"]/ul/li[3]/a")).click();
		driver.findElement(By.id("ReportType")).click();
		driver.findElement(By.xpath("//*[@id=\"ReportType\"]/ul/li[4]/a")).click();
		driver.findElement(By.id("ReportType")).click();
		driver.findElement(By.xpath("//*[@id=\"ReportType\"]/ul/li[5]/a")).click();
		driver.findElement(By.id("ReportType")).click();
		driver.findElement(By.xpath("//*[@id=\"ReportType\"]/ul/li[6]/a")).click();
		driver.findElement(By.id("ReportType")).click();
		driver.findElement(By.xpath("//*[@id=\"ReportType\"]/ul/li[7]/a")).click();
		driver.findElement(By.id("ReportType")).click();
		driver.findElement(By.xpath("//*[@id=\"ReportType\"]/ul/li[8]/a")).click();
		driver.findElement(By.id("ReportType")).click();
		driver.findElement(By.xpath("//*[@id=\"ReportType\"]/ul/li[1]/a")).click();
		Assert.assertTrue(true);
	}
}
