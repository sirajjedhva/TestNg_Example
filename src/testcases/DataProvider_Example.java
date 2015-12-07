package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Example {
	
	@Test(dataProvider="testData")
	public void yahooRegister(String username,String Password){
		
		System.out.println(username+"---"+Password);
		
	}
	
	@DataProvider
	public Object[][] testData(){
		Object[][] data=new Object[2][2];
		
		//First Row
		
		data[0][0]="username1";
		data[0][1]="password1";
		
		//second row
		data[1][0]="username2";
		data[1][1]="password2";
		
		return data;
				
	}

}
