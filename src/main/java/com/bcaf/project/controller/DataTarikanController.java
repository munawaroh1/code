package com.bcaf.project.controller;

import java.io.File;
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
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

import com.bcaf.project.model.DataTarikan;
import com.bcaf.project.repository.DataTarikanRepo;

/** 
 * The Kategori permsalahan program implements an application that
 * simply upload and displays data from database to the standard output.
 * @author MUNAWAROH
 * @author ZAIN
 * @author RIDWAN
 * @author LIVIA
 *
 * @version 1.0
 * @since   2019-07-23 
 */

@Controller
@RequestMapping(value = "/data-tarikan/")
public class DataTarikanController {

	@Autowired
	private DataTarikanRepo repo; 
	
	/**
	  * instance the ModelAndView passed to select and show data from databse
	  * @returns view 
	  */
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("data-tarikan/index");
		
		List<DataTarikan> tarikan = this.repo.findAll();

		view.addObject("tarikan", tarikan);
		return view;
	}
	
//	public static final String SAMPLE_XLS_FILE_PATH = "./sample-xls-file.xls";
//	public static final String SAMPLE_XLSX_FILE_PATH = "./*.xlsx";
	
	//save the uploaded file to folder
	/**
	  * instance the define uploaded folder
	  */
	public static String UPLOADED_FOLDER = "./temp/";
	

    @GetMapping("uploadtarikan")
    public ModelAndView uploadkategori() {
		ModelAndView view = new ModelAndView("data-tarikan/uploadTarikan");
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
//			importxls(file.getOriginalFilename());
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
        ModelAndView view = new ModelAndView("data-tarikan/uploadStatus");
        return view;
    }
	
    /**
     * instance the filename passed
     * @param Filename, that is the Filename passed
     * @throws Exception, if the Filename is in invalid format
     * @return Nothing.
     */
    public void importxls(String Filename)  throws IOException, InvalidFormatException {

		try { 
            String url = "jdbc:sqlserver://localhost;databaseName=project_db"; 
            Connection conn = DriverManager.getConnection(url,"sa","Muna1901"); 
            Statement st = conn.createStatement(); 

            XSSFWorkbook workbook = new XSSFWorkbook(Filename);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
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
				String status_pinjaman = row.getCell(0).getStringCellValue();
				String no_rek = row.getCell(1).getStringCellValue();
				String no_pin = row.getCell(2).getStringCellValue();
				String costumer_name = row.getCell(3).getStringCellValue();
				String no_rangka = row.getCell(4).getStringCellValue();
				String no_mesin = row.getCell(5).getStringCellValue();
				String covernote_date = row.getCell(6).getStringCellValue();
				String tipe_mobil = row.getCell(7).getStringCellValue();
				String bpkp_name = row.getCell(8).getStringCellValue();
				String dealer_name  = row.getCell(9).getStringCellValue();
				String dealer_address = row.getCell(10).getStringCellValue();
				String dealer_city = row.getCell(11).getStringCellValue();
				String dealer_phone = row.getCell(12).getStringCellValue();
				String dealer_contact = row.getCell(13).getStringCellValue();
				String cmo = row.getCell(14).getStringCellValue();
				String covernote_aging = row.getCell(15).getStringCellValue();
				String covernote_overdue = row.getCell(16).getStringCellValue();
				String tgl_realisasi = row.getCell(17).getStringCellValue();
				
				InsertRowInDB(status_pinjaman, no_rek, no_pin, costumer_name, no_rangka, no_mesin, covernote_date, tipe_mobil, bpkp_name, dealer_name, 
						dealer_address, dealer_city, dealer_phone, dealer_contact, cmo, covernote_aging, covernote_overdue, tgl_realisasi);
				System.out.println("");
			}
			workbook.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}	

	
		public void InsertRowInDB(String status_pinjaman, String no_rek, String  no_pin, String costumer_name, String no_rangka, String no_mesin, String covernote_date, String tipe_mobil, String bpkp_name, String dealer_name, 
				String dealer_address, String dealer_city, String dealer_phone, String dealer_contact, String cmo, String covernote_aging, String covernote_overdue, String tgl_realisasi) throws SQLException {
			String url = "jdbc:sqlserver://localhost;databaseName=project_db";
			Connection conn = DriverManager.getConnection(url, "sa", "Muna1901");
			Statement stmt = conn.createStatement();
			PreparedStatement ps = null;
			String sql = "Insert into tbl_tarikan1("
					+ "status_pinjaman, "
					+ "no_rek, "
					+ "no_pin, "
					+ "costumer_name, "
					+ "no_rangka, "
					+ "no_mesin, "
					+ "covernote_date, "
					+ "tipe_mobil, "
					+ "bpkp_name, "
					+ "dealer_name,"
					+ "dealer_address, "
					+ "dealer_city, "
					+ "dealer_phone, "
					+ "dealer_contact, "
					+ "cmo, "
					+ "covernote_aging, "
					+ "covernote_overdue, "
					+ "tgl_realisasi)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, status_pinjaman);
			ps.setString(2, no_rek);
			ps.setString(3, no_pin);
			ps.setString(4, costumer_name);
			ps.setString(5, no_rangka);
			ps.setString(6, no_mesin);
			ps.setString(7, covernote_date);
			ps.setString(8, tipe_mobil);
			ps.setString(9, bpkp_name);
			ps.setString(10, dealer_name);
			ps.setString(11, dealer_address);
			ps.setString(12, dealer_city);
			ps.setString(13, dealer_phone);
			ps.setString(14, dealer_contact);
			ps.setString(15, cmo);
			ps.setString(16, covernote_aging);
			ps.setString(17, covernote_overdue);
			ps.setString(18, tgl_realisasi);
			
			ps.executeUpdate();
//	    System.out.println("Values Inserted Successfully");
		}
}
