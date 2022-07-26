package restassured.excelintegration;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegrationDemo {
	
	public static ArrayList<Object> getDataForTestCase (Map<String, Integer> rowColumnMap, String fileName, 
			String sheetName, String testCaseName) throws Exception{
		
		FileInputStream fileInputStream = new FileInputStream(fileName);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
		ArrayList<Object> inputDataList = new ArrayList<>();
		
		Iterator<Sheet> sheetIterator = xssfWorkbook.iterator();
		//int sheetIndex = 0;
		while (sheetIterator.hasNext()) {
			Sheet currentSheet = sheetIterator.next();
			if (currentSheet.getSheetName().equals(sheetName)) { 
				
				//Post
				Integer rowNumber = rowColumnMap.get("row") + 1;  
				Integer columnNumber = rowColumnMap.get("column");
				
				Integer rowIndex = 0; 
				Integer columnIndex = 0;
				
				Iterator<Row> rowIterator = currentSheet.iterator();
				while (rowIterator.hasNext()) {
					if (rowIndex >= rowNumber) {
						Row currentRow = rowIterator.next();
						if (currentRow.getCell(columnNumber).toString().equals(testCaseName)) {
							columnNumber++;
							Iterator<Cell> cellIterator = currentRow.cellIterator();
							
							while (cellIterator.hasNext()) {
								
								if (columnIndex >= columnNumber ) {
									Cell currentCell = cellIterator.next();
									if (currentCell.getCellType().equals(CellType.STRING)) {
										inputDataList.add(currentCell.getStringCellValue());
									} else {
										//NUMERIC
										String convertedCellValue = NumberToTextConverter.toText(
												currentCell.getNumericCellValue());
										inputDataList.add(convertedCellValue);
									}
									columnIndex++;
								} else {
									cellIterator.next();
									columnIndex++;
								}
							}
						}
						rowIndex++;
					} else {
						rowIterator.next();
						rowIndex++;
					}
				}
			}
		}
		return inputDataList;
	}
	
	public static Map<String, Integer> searchForTestCase (String fileName, 
									String sheetName, String testCaseLiteral) throws Exception{
		
		Map<String, Integer> rowColumnMap = new HashedMap<>();
		
		FileInputStream fileInputStream = new FileInputStream(fileName);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
		
		int totalNumberOfSheets = xssfWorkbook.getNumberOfSheets();
		
		int columnNumber = -1;
		int rowNumber = -1;
		
		for (int i = 0; i < totalNumberOfSheets; i++) {
			if (xssfWorkbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(i);
				Iterator<Row> rowIterator = xssfSheet.rowIterator();
				boolean isFound = false;
				int rowIndex = 0;
				while (rowIterator.hasNext()) {
					Row currentRow = rowIterator.next();
					Iterator<Cell> cellIterator = currentRow.cellIterator();
					int columnIndex = 0;
					while (cellIterator.hasNext()) {
						Cell currentCell = cellIterator.next();
						if (currentCell.getStringCellValue().equals(testCaseLiteral)) {
							columnNumber = columnIndex;
							isFound = true;
							break;
						}
						columnIndex++;
					}
					if (isFound) {
						rowNumber = rowIndex;
						break;
					}
					rowIndex++;
				}
				rowColumnMap.put("row", rowNumber);
				rowColumnMap.put("column", columnNumber);
			}
		}
		return rowColumnMap;
	}	
}
