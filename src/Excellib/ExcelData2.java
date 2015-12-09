package Excellib;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import testcases.ReadExcelData2;

public class ExcelData2 {
	HSSFWorkbook wb;
	HSSFSheet sheet;
	
	public ExcelData2(String excelpath) {
		// TODO Auto-generated constructor stub
		try{
			File file=new File(excelpath);
			FileInputStream fis=new FileInputStream(file);
		
			wb=new HSSFWorkbook(fis);
		
			 sheet=wb.getSheetAt(0);
			}catch(Exception e){
				System.out.println(e.getMessage());
				}
     
           }
	
	public String excelData(int sheetNumber,int row,int col){
    	 sheet=wb.getSheetAt(sheetNumber);
    	 String data=sheet.getRow(row).getCell(col).getStringCellValue();
    	 
    	 return data;
    	
	}
	public int getData(int sheetNumber){
		
   	    int rows=wb.getSheetAt(0).getLastRowNum(); 
   	    
   	    rows+=1;
   	    
   	    return rows;
	}
	public int getCol(int sheetNumber){
		 int cols = 0;
		 int rows=wb.getSheetAt(0).getLastRowNum()+1; 
		 for(int i=0;i<rows;i++){
			HSSFRow row=sheet.getRow(i);
			 
			 cols=row.getLastCellNum();
			 
			/*HashMap<String,String> obj = new HashMap<String, String>();
			 
			 obj.put("index",""+i);
			 obj.put("value",""+row.getLastCellNum());
			 
			 ReadExcelData2.list.add(obj);
			*/ 
			
			
		 }
		//return rows;
		 return cols;
	}
}
