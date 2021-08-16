package learntestng;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class testskip {

	@Test
	public void skiptest() {
		System.out.println("This is the skip test");
		
		throw new SkipException("Skipping this test because of condition");
		
	}
	
}
