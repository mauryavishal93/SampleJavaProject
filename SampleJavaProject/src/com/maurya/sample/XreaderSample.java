package com.maurya.sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XreaderSample {

	public static final String SAMPLE_XLSX_FILE_PATH = "./framework.xlsx";
	static FunctionLib funLib = new FunctionLib();

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		System.out.println("**************Xreader class to read and write to Excel file**************");
		
		FileInputStream fileInput = new FileInputStream(SAMPLE_XLSX_FILE_PATH);
		
		Workbook workbook = WorkbookFactory.create(fileInput);
		
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
		
		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		
        System.out.println("Retrieving Sheets using Iterator");
        
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }
        
        Sheet sheet = workbook.getSheet("Data");

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        
        
     // 1. You can obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
        
        
        // 2. Or you can use a for-each loop to iterate over the rows and columns
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row: sheet) {
            for(Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }

        // 3. Or you can use Java 8 forEach loop with lambda
        System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
		/*
		 * sheet.forEach(row -> { row.forEach(cell -> { String cellValue =
		 * dataFormatter.formatCellValue(cell); System.out.print(cellValue + "\t"); });
		 * System.out.println(); });
		 */

      
        
        Row row1 = sheet.getRow(0);
        for(Cell cell: row1) {
            String cellValue = dataFormatter.formatCellValue(cell);
            System.out.print(cellValue + "\t");
            
        }
        System.out.println();
        
        
        
        
        
        
        
        
        
        
        
        

   	 // Closing the workbook
   	 workbook.close();

	}
	    
}
