package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.Kecamatan;
import com.bcaf.project.model.Kelurahan;
import com.bcaf.project.model.Provinsi;
import com.bcaf.project.repository.KecamatanRepo;
import com.bcaf.project.repository.KelurahanRepo;


@Controller
@RequestMapping(value="/kelurahan/")
public class KelurahanController {
	
	@Autowired
	private KelurahanRepo repo; 
	
	@Autowired
	private KecamatanRepo repoKecamatan;
	
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("kelurahan/index");
		List<Kelurahan> list = this.repo.findAll();

		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value="create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("kelurahan/_form");
		//"kota" dari form yg di folder kota
		view.addObject("kelurahan", new Kelurahan());
		
		List<Kecamatan> listKecamatan = this.repoKecamatan.findAll();
		view.addObject("listKecamatan", listKecamatan);

		return view;
	}
	
	@PostMapping(value="save")
	public ModelAndView save(@ModelAttribute Kelurahan kelurahan, BindingResult result) {
		ModelAndView view = new ModelAndView("kelurahan/_form");
		//jika ada eror
		if (result.hasErrors()) {
			view.addObject("kelurahan", kelurahan);
		} else {
			this.repo.save(kelurahan);
			view.addObject("kelurahan", new Kelurahan());
		}
		return view;
	}
	
	@GetMapping(value="update")
	public ModelAndView update(@ModelAttribute Kelurahan kelurahan) {
		return  new ModelAndView("kelurahan/_form");

	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kelurahan/_form");
		Kelurahan item = this.repo.findById(id).orElse(null);
		view.addObject("kelurahan", item);
		
		List<Kecamatan> listKecamatan = this.repoKecamatan.findAll();
		view.addObject("listKecamatan", listKecamatan);

		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("kelurahan/_list");
		List<Kelurahan> list = this.repo.findAll();
		view.addObject("list", list);

		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kelurahan/_hapus");
		Kelurahan item = this.repo.findById(id).orElse(null);
		view.addObject("kelurahan", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute Kelurahan kelurahan) {
		// proses hapus
		ModelAndView view = new ModelAndView("kelurahan/_form");
			// jika tidak ada data provinsi di kota, maka proses hapus dilakukan
			this.repo.delete(kelurahan);
			view.addObject("kelurahan", new Kelurahan());

		return view;
	}
	
}
