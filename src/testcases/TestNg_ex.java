package testcases;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class TestNg_ex {
	
	@Test
	public void test(){
		System.out.println("Login into system");
		
	}
	@Test(dependsOnMethods={"test"})
	public void registerTestCase(){
		System.out.println("Register test case is here");
	}
	@Test(dependsOnMethods={"test","registerTestCase"})
	public void passChange(){
		System.out.println("Password change");
	}
	
}
