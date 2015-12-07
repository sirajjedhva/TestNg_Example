package ExcelFile_Example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelData {
	HSSFWorkbook hwb;
	HSSFSheet sheet; 
	  public ExcelData(String filepath)  
	  {
	    
		  	try		
		  	    {
		  			File file=new File(filepath);
		  			FileInputStream fis=new FileInputStream(file);
		  			hwb=new HSSFWorkbook(fis);
		  				if(hwb==null){
		  				System.out.println("Sheet is null");
		  				}
		      
		         }
		  	     catch(Exception e)	
		  		{
		  			e.printStackTrace();
		        }
					
	   }
	    public String getData(int sheetnumber,int row,int col){
			
	    	sheet=hwb.getSheetAt(sheetnumber);
			if(sheet==null)
			{
			System.out.println("Sheet is null");
			}
			String Data=sheet.getRow(row).getCell(col).getStringCellValue();
			return Data;
	  }
	   public  int getRowCount(int sheetNumber){
		   int rows=hwb.getSheetAt(0).getLastRowNum();
		   
		   rows+=1;
		   return rows;
	   }

}
