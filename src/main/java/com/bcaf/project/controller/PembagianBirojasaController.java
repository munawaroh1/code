package com.bcaf.project.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bcaf.project.model.PembagianBirojasa;
import com.bcaf.project.repository.PembagianBirojasaRepo;

@Controller
@RequestMapping(value = "/pembagian-birojasa/")
public class PembagianBirojasaController {
	
	@Autowired
	private PembagianBirojasaRepo repo; 
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("pembagian-birojasa/index");
		
		List<PembagianBirojasa> birojasa = this.repo.findAll();
//
//		System.out.println("============================");
//		System.out.println(birojasa);
		
		view.addObject("birojasa", birojasa);
		return view;
	}
	
	//save the uploaded file to folder
		public static String UPLOADED_FOLDER = "./temp/";
		

	    @GetMapping("uploadbirojasa")
	    public ModelAndView uploadBirojasa() {
			ModelAndView view = new ModelAndView("pembagian-birojasa/uploadBirojasa");
	        return view;
	    }
	
	    @PostMapping(value = "upload")
	    public String singleFileUpload(@RequestParam("file") MultipartFile file,
	            RedirectAttributes redirectAttributes) {

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			if(file.isEmpty()) {
				redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "redirect:uploadstatus";
			}
			try {
				  // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);

	            redirectAttributes.addFlashAttribute("message",
	                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
			try {
//				importxls(file.getOriginalFilename());
				importxls(path.toString());
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch  (IOException e) {
	            e.printStackTrace();
			}
			return "redirect:index";
		}
	    
	    @GetMapping("uploadstatus")
	    public ModelAndView uploadStatus() {
	        ModelAndView view = new ModelAndView("pembagian-birojasa/uploadStatus");
	        return view;
	    }
	    
	    public void importxls(String Filename)  throws IOException, InvalidFormatException {

			try { 
	            String url = "jdbc:sqlserver://localhost;databaseName=project_db"; 
	            Connection conn = DriverManager.getConnection(url,"sa","Muna1901"); 
	            Statement st = conn.createStatement(); 

	            XSSFWorkbook workbook = new XSSFWorkbook(Filename);
				XSSFSheet sheet = workbook.getSheetAt(0);
	            
//		        Workbook workbook = WorkbookFactory.create(new File(Filename));

				Iterator<Row> rowIterator = sheet.iterator();
				rowIterator.next();
				
				
		        while (rowIterator.hasNext()) {
		        	 Row row = rowIterator.next();
			         // For each row, iterate through each columns
						Iterator<Cell> cellIterator = row.cellIterator();
						
						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							cell.setCellType(Cell.CELL_TYPE_STRING);
						}
						String dealer_name = row.getCell(0).getStringCellValue();
						String dealer_address = row.getCell(1).getStringCellValue();
						String dealer_city = row.getCell(2).getStringCellValue();
						String birojasa_name = row.getCell(3).getStringCellValue();
						String cabang_kelola = row.getCell(4).getStringCellValue();
						
						InsertRowInDB(dealer_name, dealer_address, dealer_city, birojasa_name, cabang_kelola);
						System.out.println("");
		        }
				workbook.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("Got an exception! ");
				System.err.println(e.getMessage());
			}
	    }
	    
	    public void InsertRowInDB(String dealer_name,  String dealer_address, String dealer_city, String birojasa_name, String cabang_kelola) throws SQLException {
			String url = "jdbc:sqlserver://localhost;databaseName=project_db";
			Connection conn = DriverManager.getConnection(url, "sa", "Muna1901");
			Statement stmt = conn.createStatement();
			PreparedStatement ps = null;
			String sql = "Insert into tbl_pembagian_birojasa("
					+ "dealer_name, "
					+ "dealer_address, "
					+ "dealer_city, "
					+ "birojasa_name, "
					+ "cabang_kelola)"
					+ "values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dealer_name);
			ps.setString(2, dealer_address);
			ps.setString(3, dealer_city);
			ps.setString(4, birojasa_name);
			ps.setString(5, cabang_kelola);
	    
			ps.executeUpdate();
	    }

}
