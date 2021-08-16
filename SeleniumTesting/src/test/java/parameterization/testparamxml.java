package parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testparamxml {

	@Parameters({"browser"})
	@Test
	public void getbrowser(String browser) {
		System.out.println(browser);
		
		
	}
}
