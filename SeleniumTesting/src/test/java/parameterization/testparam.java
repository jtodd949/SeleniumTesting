package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testparam {

	@Test (dataProvider="getData")
	public void login (String username, String password) {
		System.out.println(username + " --- " + password);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		return data;
		
	}
}
