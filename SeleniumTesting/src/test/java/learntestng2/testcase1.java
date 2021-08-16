package learntestng2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testcase1 {
	
	@BeforeTest
	public void dbConnect() {
		System.out.println("Opening db connection...");
	}
	
	@AfterTest
	public void dbClose() {
		System.out.println("Closing db connection...");
	}
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching browser...");
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Closing browser...");
	}

	@Test(priority=2)
	public void Login() {
		System.out.println("Logging in...");
	}
	
	@Test(priority=1)
	public void Registration() {
		System.out.println("Registering user...");
	}

}
