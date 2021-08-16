package learntestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testfailure extends testsuitenotation {
	
	@Test
	public void login() {
		Assert.fail("log in fail");
		System.out.println("capturing screenshot");
	}

}
