package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It is developed using Apache POI libraries, which is used handle Microsoft excel sheet
 * @author Akshay
 *
 */
public class ExcelUtility {
	/**
	 * It is used to read the data from excel based on below arguments
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb=WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		String data=format.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		wb.close();
		return data;
	}
	
	/**
	 * It is used to get the last used row in a specified sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb=WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return lastRowNum;
	}
	
	/**
	 * It is used to write the data in excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 */
	public void setExcelData(String sheetName,int rowNum,int cellNum,String data) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstant.EXCELPATH);
		wb.write(fos);
		wb.close();
	}
}
