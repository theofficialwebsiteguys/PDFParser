package com.pat.parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pat.parser.excel.CreateADJExcel;
import com.pat.parser.objs.ExcelObj;

public class PDFParser extends PDFTextStripper {
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Path filePath = Paths.get("C:\\Users\\patri\\OneDrive\\Documents\\Tsstage pdf dimensions\\ADJ.txt");
		
		try {
			
			List<String> lines = Files.readAllLines(filePath);
			
			CreateADJExcel excel = new CreateADJExcel();
			

	           
			List<ExcelObj> sixWordLines = new ArrayList<>();
	          	for(String line : lines) {
	          		
	          		
	          		String[] parts = line.split(" ");
	          		
	          		if(parts.length >=6) {
	          			ExcelObj obj = new ExcelObj();
	          			
	          			StringBuilder model = new StringBuilder();
	          			
	          			int i = 0;
	          			
	          			while(i < parts.length) {
	          			    try {
	          			        long number = Long.parseLong(parts[i]);
	          			        if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
	          			            
	          			            break;
	          			        } else {
	          			            
	          			            model.append(" ").append(parts[i++]);
	          			        }
	          			    } catch(NumberFormatException e) {
	          			       
	          			        model.append(" ").append(parts[i++]);
	          			    }
	          			    
	          			    obj.setModel(model.toString());
	          			}
	          			
	          			if(i < parts.length) {
	          	         
	          	            obj.setUpc(parts[i++]);
	          	            
	          			}
	          			
	          			int partsLeft = parts.length - i;
	          			if(partsLeft > 4) {
	          				obj.setUnitL(parts[i++]);
	                        obj.setUnitW(parts[i++]);
	                        obj.setUnitH(parts[i++]);
	                        obj.setUnitWeight(parts[i++]);
	                        sixWordLines.add(obj);
	          			}
	          			
	          			
	          		}
	          	}
	          	
	          	for(ExcelObj obj : sixWordLines) {
	          		System.out.println(obj.toString());
	          	}


	           
	            XSSFWorkbook workbook = new XSSFWorkbook();
	            
	           workbook =  excel.createExcelSheet(workbook, sixWordLines);
	            
	            workbook.setSheetName(0, "ADJ");
	            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\patri\\OneDrive\\Documents\\Tsstage pdf dimensions\\ADJExcel.xlsx"));
	            System.out.println("WRITING TO NOTEBOOK");
	            workbook.write(out);
	            out.close();
	            workbook.close();
	            
	            
	            
	          
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
