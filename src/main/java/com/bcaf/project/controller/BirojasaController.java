package com.bcaf.project.controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.sql.*;

/**
 * <h1> birojasa controller digunakan untuk upload data tarikan covernote  </h1>
 * @author livia - muna - ridwan - zain
 * @version 1.0
 * @since 16-July-2019
 */

public class BirojasaController {
	
	/**
	 * @param args Input any arguments 
	 * 
	 * @param args the command line arguments 
	 *
	 */
	
	public static final String SAMPLE_XLS_FILE_PATH = "./sample-xls-file.xls";
	public static final String SAMPLE_XLSX_FILE_PATH = "./kategoriempat.xlsx";
	

	public static void main(String[] args) throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		
		try { 
            String url = "jdbc:sqlserver://localhost;databaseName=project_db"; 
            Connection conn = DriverManager.getConnection(url,"sa","Muna1901"); 
            Statement st = conn.createStatement(); 
            
	        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

	        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
	        Sheet sheet = workbook.getSheetAt(0);
	
	        DataFormatter dataFormatter = new DataFormatter();
	
	        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
	        
	        Iterator<Row> rowIterator = sheet.rowIterator();
	        int i=0;
	        int c;
	
	        String str="INSERT INTO tbl_kategori_permasalahan (jenis_permasalahan) VALUES ";
	        String strx = "";
	        String all="";
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	            if(i>0) {
		            Iterator<Cell> cellIterator = row.cellIterator();
		            strx="";
		            c=0;
		            while (cellIterator.hasNext()) {
		                Cell cell = cellIterator.next();
		                String cellValue = dataFormatter.formatCellValue(cell);
		                
		                String strval="";
		                strval=cellValue.replace("’", "");
		                strval=strval.replace("#", "");
		                strx+="'"+strval+"',";
		                
			            strx=strx.substring(0,strx.length()-1)+",";
			            c++;
		            }
		            strx="("+strx.substring(0,strx.length()-1)+"),";
	        	}
	            all+=strx;
	            i++;
	        }
	        str+=all.substring(0,all.length()-1)+";";
	        st.executeUpdate(str);
	        System.out.println(str);
	
        	workbook.close();
        	conn.close(); 
	    } catch (Exception e) { 
	        System.err.println("Got an exception! "); 
	        System.err.println(e.getMessage()); 
	    } 
    }

	}

