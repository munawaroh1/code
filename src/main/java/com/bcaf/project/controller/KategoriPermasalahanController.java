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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bcaf.project.model.KategoriPermasalahan;
import com.bcaf.project.model.Kelurahan;
import com.bcaf.project.model.Provinsi;
import com.bcaf.project.repository.KategoriPermasalahanRepo;

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
@RequestMapping(value = "/kategori/")
public class KategoriPermasalahanController {

	@Autowired
	private KategoriPermasalahanRepo repo; 
	
	/**
	  * instance the ModelAndView passed
	  * @returns view 
	  */
	
	//coba dari sini
	
	@GetMapping(value="create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("kategori/_form");
		view.addObject("kategori", new KategoriPermasalahan());

		return view;
	}
	
	@PostMapping(value="save")
	public ModelAndView save(@ModelAttribute KategoriPermasalahan kategori, BindingResult result) {
		ModelAndView view = new ModelAndView("kategori/_form");
		//jika ada eror
		if(result.hasErrors()) {
			view.addObject("kategori", kategori);
		} else {
			this.repo.save(kategori);
			view.addObject("kategori", new KategoriPermasalahan() );
		}
		
		return view;
	}
	
	@GetMapping(value="update")
	public ModelAndView update(@ModelAttribute KategoriPermasalahan kategori) {
		return  new ModelAndView("kategori/_form");

	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("kategori/_list");
		List<KategoriPermasalahan> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kategori/_form");
		
		KategoriPermasalahan kategori = this.repo.findById(id).orElse(null);
		view.addObject("kategori", kategori);
		
		return view;
	}
	
	@GetMapping(value = "hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kategori/_hapus");
		//ambil data department by id , lgi di save di object item
		KategoriPermasalahan item = this.repo.findById(id).orElse(null);
		//object item dikirim ke view melalui object view
		view.addObject("kategori", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute KategoriPermasalahan kategori) {
		// proses hapus
		ModelAndView view = new ModelAndView("kategori/_form");
			// jika tidak ada data provinsi di kota, maka proses hapus dilakukan
			this.repo.delete(kategori);
			view.addObject("kategori", new KategoriPermasalahan());

		return view;
	}
	
	//sampai sini
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("kategori/index");
		
		List<KategoriPermasalahan> kategori = this.repo.findAll();

		view.addObject("kategori", kategori);
		return view;
	}
	
//	public static final String SAMPLE_XLS_FILE_PATH = "./sample-xls-file.xls";
//	public static final String SAMPLE_XLSX_FILE_PATH = "./*.xlsx";
	
	//save the uploaded file to folder
	public static String UPLOADED_FOLDER = "./temp/";
	

    @GetMapping("uploadkategori")
    public ModelAndView uploadkategori() {
		ModelAndView view = new ModelAndView("kategori/uploadKategori");
        return view;
    }
	
	
    /**
     * instance the file passed
     * @param file, that is the file passed
     * @returns catch if the name is the same , compare the multipart file
     */
    
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
        ModelAndView view = new ModelAndView("kategori/uploadStatus");
        return view;
    }
	
    /**
     * instance the filename passed
     * @param Filename, that is the Filename passed
     * @throws Exception, if the Filename is in invalid format
     */
    
    public void importxls(String Filename)  throws IOException, InvalidFormatException {

		try { 
            String url = "jdbc:sqlserver://localhost;databaseName=project_db"; 
            Connection conn = DriverManager.getConnection(url,"sa","Muna1901"); 
            Statement st = conn.createStatement(); 

            XSSFWorkbook workbook = new XSSFWorkbook(Filename);
			XSSFSheet sheet = workbook.getSheetAt(0);
            
//	        Workbook workbook = WorkbookFactory.create(new File(Filename));

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
					String jenis_permasalahan = row.getCell(0).getStringCellValue();
	        
					InsertRowInDB(jenis_permasalahan);
					System.out.println("");
	        }
			workbook.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
    }
    
    public void InsertRowInDB(String jenis_permasalahan) throws SQLException {
		String url = "jdbc:sqlserver://localhost;databaseName=project_db";
		Connection conn = DriverManager.getConnection(url, "sa", "Muna1901");
		Statement stmt = conn.createStatement();
		PreparedStatement ps = null;
		String sql = "Insert into tbl_kategori_permasalahan(jenis_permasalahan)"
				+ "values(?)";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, jenis_permasalahan);
		
		ps.executeUpdate();
//    System.out.println("Values Inserted Successfully");
	}
	
}
