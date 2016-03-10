package testNGReport.realTimeReport;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Garu99Report.class)
public class TestGuru99RealReport {

	@Test
	public void testRealReportOne(){
		Assert.assertTrue(true);
	}
	@Test
	public void testReportTwo(){
		Assert.assertTrue(false);
	}
	@Test(dependsOnMethods="testReportTwo")
	public void testReportThree(){
		
	}
}
