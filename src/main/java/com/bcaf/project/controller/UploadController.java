package com.bcaf.project.controller;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Iterator;

@Controller
public class UploadController {

    public static final String SAMPLE_XLSX_FILE_PATH = "./temp/basic_salary.xlsx";

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "./temp/";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            
            try {
				importxls();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    
    public void importxls( )  throws IOException, InvalidFormatException {
    	try { 
            String url = "jdbc:mysql://localhost/myxls"; 
            Connection conn = DriverManager.getConnection(url,"root","1234567"); 
            Statement st = conn.createStatement(); 
        
	        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

	        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
	        Sheet sheet = workbook.getSheetAt(0);
	
	        DataFormatter dataFormatter = new DataFormatter();
	
	        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
	        
	        Iterator<Row> rowIterator = sheet.rowIterator();
	        int i=0;
	        int c;
	
	        String str="INSERT INTO basic_salary (name,email,dob,salary,department) VALUES ";
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