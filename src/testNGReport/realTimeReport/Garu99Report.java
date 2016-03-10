package testNGReport.realTimeReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Garu99Report implements ITestListener{

	

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Started->" + arg0.getName());
	}
	
	@Override
	public void onTestStart(ITestResult arg0){
		System.out.println("TestStared->" +arg0.getName());
	}
     
	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test passed ->" +arg0.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
	System.out.println("Test Failure->"+arg0.getName());	
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test sKipped->"+arg0.getName());
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("End of execution->"+arg0.getName());
	}

	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("");
	}


	

	

	

	
}
