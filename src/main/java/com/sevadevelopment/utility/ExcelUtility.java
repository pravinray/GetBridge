package com.sevadevelopment.utility;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtility {
	private FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	private int rowCount;
	private int colCount;
	private Row firstRow;

	public ExcelUtility(String xlFilePath, String sheetName) throws IOException {
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
		
		sheet = workbook.getSheet(sheetName);
		
		rowCount = sheet.getPhysicalNumberOfRows();
		firstRow = sheet.getRow(0);
		colCount = firstRow.getPhysicalNumberOfCells();
	}

	public String getCellData(int rowNum, int colNum) {
		try {
			cell = sheet.getRow(rowNum).getCell(colNum);
			
			switch(cell.getCellType()) {
				case STRING:
					return cell.getStringCellValue();
					
				case NUMERIC:
				case FORMULA:
					String cellValue = String.valueOf(cell.getNumericCellValue());
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						DateFormat df = new SimpleDateFormat("dd/MM/yy");
						Date date = cell.getDateCellValue();
						cellValue = df.format(date);
					}
					return cellValue;
					
				case BLANK:
					return "";
				
				default:
					return String.valueOf(cell.getBooleanCellValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in Excel";
		}
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return colCount;
	}
	
	public Object[][] getAllDataAsArrayOfObject() {
		Object[][] excelData;
		
		excelData = new Object[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < 2; j++) {
				excelData[i][j] = getCellData(i, j);
			}
		}
		
		return excelData;
	}
}
