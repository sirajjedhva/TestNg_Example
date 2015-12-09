package testcases;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFRow;

import Excellib.ExcelData2;

public class ReadExcelData2 {

	//public static  list = new HashMap<String,String>();
	
	//public static ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	public static void main(String[] args) {
			// TODO Auto-generated method stub
		ExcelData2 excel=new ExcelData2("/home/inheritx_sales/TestData.xls");
		
		
		int rows=excel.getData(0);
		int cols=excel.getCol(0);
		Object[][] data=new Object[rows][cols];{
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
			data[i][j]=excel.excelData(0, i, j);
			//data[i][1]=excel.excelData(0, i, 1);
		    //data[i][2]=excel.excelData(0, i, 2);
			System.out.print(data[i][j]+" || ");
			}
			System.out.println();
		 }
		
		}
		
		/*for(int i=0;i<list.size();i++){
			
			HashMap<String,String> obj = new HashMap<String, String>();
			
			obj = list.get(i);
			
			System.out.println("Index==>  " + obj.get("index"));
			
			System.out.println("Value==>  " + obj.get("value"));
			 
		
	}*/

	}

}

