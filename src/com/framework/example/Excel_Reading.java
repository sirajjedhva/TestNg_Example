package com.framework.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

public class Excel_Reading {
	
	HSSFWorkbook excel;
	HSSFSheet sheet;
	
	public Sheet readExcel(String path,int i){
		
		try {
			File file=new File(path);
			FileInputStream fis=new FileInputStream(file);
			
			excel=new HSSFWorkbook(fis);
			     
			    if(excel == null){
			    	System.out.println("Shit is null");
			    }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sh=excel.getSheetAt(i);
		return sh;
	}

	public String excelData(int sheetNumber,int row,int col){
		sheet=excel.getSheetAt(0);
		String data=sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	public int rowCount(int sheetNumber){
		int rows=excel.getSheetAt(0).getLastRowNum();
		rows=+1;
		return rows;
	}
}
