package com.maurya.sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Xreader {

	public static final String SAMPLE_XLSX_FILE_PATH = "./framework.xlsx";
	
	public static int ID;
	public static int NAME;
	public static int SALARY;
	
	static FunctionLib funLib = new FunctionLib();
	
	 static HashMap<String, Integer> hashMapColumns =  new HashMap<String, Integer>();

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		System.out.println("**************Xreader class to read and write to Excel file**************");
		
		FileInputStream fileInput = new FileInputStream(SAMPLE_XLSX_FILE_PATH);
		
		Workbook workbook = WorkbookFactory.create(fileInput);
		
		
        Sheet sheet = workbook.getSheet("Data");

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        Row row1 = sheet.getRow(0);
        for(Cell cell: row1) {
            String cellValue = dataFormatter.formatCellValue(cell);
            System.out.print(cellValue + "\t");
            int pos= cell.getColumnIndex();
            System.out.println(pos);
            hashMapColumns.put(cellValue, pos);
        }
        System.out.println();
        
        //System.out.println(hashMapColumns.toString());
        
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                if(row.getCell(hashMapColumns.get("ID")).toString().contains("10"))
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
        
        
        
        
        
        

   	 // Closing the workbook
   	 workbook.close();

	}
	    
}
