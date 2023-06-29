package com.w2a.listners;
//import com.w2a.base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;


public class CustomListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		test = rep.startTest(result.getName().toUpperCase());
		System.out.println(TestUtil.isTestRunnable(result.getName(), excel));
		
		if(!TestUtil.isTestRunnable(result.getName(), excel)) {
			
			throw new SkipException("skipping the test"+result.getName()+"since runmode is No");
			
		}
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(null, null);
		test.log(LogStatus.PASS, result.getName().toUpperCase()+ "PASS");
		rep.endTest(test);
		rep.flush();
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	
	    test.log(LogStatus.FAIL, result.getName().toUpperCase()+ "Failed with exception: " +result.getThrowable());
	    test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
	    rep.endTest(test);
	    rep.flush();
	
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP,result.getName().toUpperCase()+ "skipped the test");
		rep.endTest(test);
		rep.flush();
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
	//	rep.endTest(test);
	//	rep.flush();
		// TODO Auto-generated method stub
		
	}
	
}