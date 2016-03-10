package com.framework.example;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Pms_Testcase {
	WebDriver driver;
	
	@Test(dataProvider="hybrid")
	public void testLogin(String testCaseName,String Keyword,String ObjectName,String ObjectType,String value) throws Exception{
		
		if(testCaseName!=null && testCaseName.length() != 0){
			 driver=new FirefoxDriver();
		}
	  ReadObject object=new ReadObject();
	  Properties p=object.getProperty();
	  UI_Operation ui=new UI_Operation(driver);
	  
	//Call perform function to perform operation on UI
	  ui.perform(p, Keyword, ObjectName, ObjectType, value);
	}
	
	@DataProvider(name="hybrid")
	public Object[][] getDataFormProvider(){
		Object[][] object=null;
		Excel_Reading ex=new Excel_Reading();
		
		//Read keyword sheet
		Sheet pms=ex.readExcel("/home/inheritx_sales/Pms-Testcases.xls",0);
		//Find number of rows in excel file
		int rowCount=pms.getLastRowNum()-pms.getFirstRowNum();
		object=new Object[rowCount][5];
		  for(int j=0;j<rowCount;j++){
			  Row row=pms.getRow(j+1);
			  for(int k=0;k<row.getLastCellNum();k++){
				  object[j][k]=row.getCell(k).toString();
			  }
		  }
		  System.out.println("");
		  return object;
	}
}
