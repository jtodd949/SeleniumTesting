package learntestng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class testsuitenotation {

	@BeforeSuite
	public void setUp() {
		System.out.println("Inititalizing stuff");
	}
	
	@AfterSuite
	public void tearDown() {
		System.out.println("Burn it all down");
	}
}
