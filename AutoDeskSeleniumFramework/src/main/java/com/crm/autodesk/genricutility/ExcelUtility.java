package com.crm.autodesk.genricutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POilibraries , which used to handle Microsoft Excel sheet
 * @author Kiran
 *
 */

public class ExcelUtility {

	private static final String EXCEL_PATH = null;
	private static final String PROPERTYFILE_PATH = null;
	/**
	 *  its used read the data from excel based on below arguments 
	 * @paramsheetName
	 * @paramrowNum
	 * @paramcelNum
	 * @return Data
	 * @throwsThrowable
	 */
	 public String getDataFromExcel(String sheetname,int rowNum,int cellNum)throws Throwable{
		FileInputStream fin=new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook wb=WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowNum);
		 String data=row.getCell(cellNum).getStringCellValue();
		 wb.close();
		 return data;
	}
	/**
	 * used to get the last used row number on specified Sheet
	 * @paramsheetName
	 * @return
	 * @throwsThrowable
	 */
	 public int getRowCount(String sheetName)throws Throwable{
		 FileInputStream fis=new FileInputStream(IPathConstants.EXCEL_PATH);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	 }
	 public void setDataExcel(String sheetName,int rowNum,int cellNum,String data)throws Throwable{
		 FileInputStream fis=new FileInputStream(IPathConstants.EXCEL_PATH);
		 Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheetName);
		 Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstants.PROPERTYFILE_PATH);
		wb.write(fos);
		wb.close();
	 }
	 

}
