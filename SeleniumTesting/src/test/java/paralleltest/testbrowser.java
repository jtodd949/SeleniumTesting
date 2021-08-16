package paralleltest;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testbrowser {
	
	@Parameters({ "browser" })
	@Test
	public void login(String b) {
		Date d = new Date();
		System.out.println("Browser name: " + b + " " + d);
		
	}
}
