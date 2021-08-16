package customlisteners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class listeners implements ITestListener {
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("passed test -- " + result.getName());
	}
	
	public void onTestFailure (ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=\"C:\\Users\\jordan.todd\\eclipse-workspace\\SeleniumTesting\\screenshot\\error.jpg\" target=\"_blank\"> Screenshot Link </a>");
		Reporter.log("<a href=<br>");
		Reporter.log("<a href=\"C:\\Users\\jordan.todd\\eclipse-workspace\\SeleniumTesting\\screenshot\\error.jpg\" target=\"_blank\"> <img src=\"C:\\Users\\jordan.todd\\eclipse-workspace\\SeleniumTesting\\screenshot\\error.jpg\" height=\"200\" width=\"200\"> </a>");
		System.out.println("caputring screenshot for failed test -- " + result.getName());
	}
	
	

}
