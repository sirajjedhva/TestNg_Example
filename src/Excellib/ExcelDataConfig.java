package Excellib;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataConfig {
	HSSFWorkbook wb;
	HSSFSheet sheet;
	
	public ExcelDataConfig(String excelpath)
	{
		
		try{
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		
		 wb=new HSSFWorkbook(fis);
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
	}


public String getData(int sheetNumber,int row,int col){
	
	sheet=wb.getSheetAt(sheetNumber);
	String data=sheet.getRow(row).getCell(col).getStringCellValue();
    return data;
}
}