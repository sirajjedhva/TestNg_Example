package testNGReport.realTimeReport;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value=IReporter_Example.class)
public class IReporter_Listener {
	
	@Test(priority=0,description="testReporterOne")
	public void testReporterOne(){
		//Pass test case
		Assert.assertTrue(true);
	}
	
	@Test(priority=1,description="testReporterTwo")
	public void testReprterTwo(){
		Assert.assertTrue(false);
	}

}
