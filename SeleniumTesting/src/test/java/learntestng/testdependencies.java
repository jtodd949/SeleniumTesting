package learntestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testdependencies extends testsuitenotation {
	
	
	@Test(priority=2,dependsOnMethods="Registration",groups= {"functional","smoke"})
	public void Login() {
		System.out.println("Logging in...");
	}
	
	@Test(priority=1, groups= {"functional","smoke"})
	public void Registration() {
		System.out.println("Registering user...");
		Assert.fail("User not registered successfully");
	}
	
	@Test(priority=3,dependsOnMethods="Registration",alwaysRun=true,groups= {"functional","smoke"})
	public void Third() {
		System.out.println("Third test...");
	}
	
	@Test(priority=4,groups= "bvt")
	public void Forth() {
		System.out.println("Forth Test...");
	}
}
