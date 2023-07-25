package PolicyBazzarBase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import PolicyBazzarUtility.Utility;

public class Listener extends Base implements ITestListener { //base class in inherited bez of WebDriver driver 
	
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestSkipped(result);

	
		try {
			Utility.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Reporter.log("Exception occoured", true);
		}
	}
	
	@Override
		public void onTestStart(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);

		Reporter.log("test case excution "+result.getName()+"started", true);
		
	
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);

		Reporter.log("TC execution "+result.getName()+"success", false);
		
	}


}
