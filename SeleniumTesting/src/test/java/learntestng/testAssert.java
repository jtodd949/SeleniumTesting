package learntestng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testAssert extends testsuitenotation {

	@Test (groups="smoketest")
	public void validateTitle() {
		System.out.println("Begin...");
		String expected = "Yahoo.com";
		String actual = "Gmail.com";
		
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("Validate title...");
		softAssert.assertEquals(actual, expected);
		//Assert.assertTrue(condition);
		//Assert.fail("It went esplody");
		
		System.out.println("Validate img...");
		softAssert.assertEquals(true, false, "img not present");
		
		System.out.println("Validate textbox...");
		softAssert.assertEquals(true, false, "textbox not present");
		
		System.out.println("End...");
		
		softAssert.assertAll();
	}
	
}
