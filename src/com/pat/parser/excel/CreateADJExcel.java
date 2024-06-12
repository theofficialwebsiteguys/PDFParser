package com.pat.parser.excel;

import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pat.parser.objs.ExcelObj;


public class CreateADJExcel {

	public XSSFWorkbook createExcelSheet(XSSFWorkbook workBook, List<ExcelObj> items) {
		XSSFSheet sheet = workBook.createSheet();
		XSSFRow headerRow = sheet.createRow(0);
		
		XSSFCell id = headerRow.createCell(0);
		id.setCellValue("ID");
		XSSFCell handle = headerRow.createCell(1);
		handle.setCellValue("Title");
		XSSFCell height = headerRow.createCell(2);
		height.setCellValue("Metafield: custom.height [dimension]");
		XSSFCell width = headerRow.createCell(3);
		width.setCellValue("Metafield: custom.width [dimension]");
		XSSFCell length = headerRow.createCell(4);
		length.setCellValue("Metafield: custom.length [dimension]");
		XSSFCell weight = headerRow.createCell(5);
		weight.setCellValue("Variant Weight");
		
		int rowNum = 1;
		for(ExcelObj obj : items) {
			XSSFRow row = sheet.createRow(rowNum++);
			XSSFCell idRow = row.createCell(0);
			idRow.setCellValue(obj.getUpc());
			XSSFCell handleRow = row.createCell(1);
			handleRow.setCellValue(obj.getModel());
			XSSFCell heightRow = row.createCell(2);
			heightRow.setCellValue("{\"value\": " + obj.getUnitH() + ", \"unit\": \"in\"}");
			XSSFCell widthRow = row.createCell(3);
			widthRow.setCellValue("{\"value\": " + obj.getUnitW() + ", \"unit\": \"in\"}");
			XSSFCell lengtRow = row.createCell(4);
			lengtRow.setCellValue("{\"value\": " + obj.getUnitL() + ", \"unit\": \"in\"}");
			XSSFCell weightRow = row.createCell(5);
			weightRow.setCellValue(obj.getUnitWeight());
		}
		
		
		
		return workBook;
	}
}
