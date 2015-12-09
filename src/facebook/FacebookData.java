package facebook;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class FacebookData {

HSSFWorkbook wb;
HSSFSheet sheet;

    public FacebookData(String excelPath){
		try{
		File file=new File(excelPath);
		FileInputStream fis=new FileInputStream(file);
		
		wb=new HSSFWorkbook(fis);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getExcel(int sheetNumber,int row,int col){
		    sheet=wb.getSheetAt(sheetNumber);
			if(sheet==null){
			System.out.println("Sheet is empty ");
			}
		    String data=sheet.getRow(row).getCell(col).getStringCellValue();
		    return data;
	}
	public int getRowCount(int sheetNumber){
		int rows=wb.getSheetAt(0).getLastRowNum()+1;
		return rows;
	}
		

}
