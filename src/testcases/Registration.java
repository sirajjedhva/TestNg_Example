package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Registration {
	
	@Test(dataProvider="getRegister")
	public void testRegister(String username,String password,String email,String city){
		
		System.out.println(username+"----"+password+"-----"+email+"----"+city);
		
	}

@DataProvider
public Object[][] getRegister(){
	
	Object[][] data=new Object[3][4];
	
	//first Row
	   data[0][0]="user1";
	   data[0][1]="pass1";
	   data[0][2]="emai1";
	   data[0][3]="city1";
	
	//second Row
		data[1][0]="user2";
		data[1][1]="pass2";
		data[1][2]="emai2";
		data[1][3]="city2";
		
		
		//third Row
		data[2][0]="user3";
		data[2][1]="pass3";
		data[2][2]="emai3";
		data[2][3]="city3";		
		
		return data;
	
}
}