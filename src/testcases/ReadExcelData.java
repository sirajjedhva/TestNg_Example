package testcases;

import Excellib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ExcelDataConfig obj=new ExcelDataConfig("/home/inheritx_sales/TestData.xls");
     
     System.out.println(obj.getData(0, 0, 0));
	}

}
