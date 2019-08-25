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
import com.bcaf.project.model.Kota;
import com.bcaf.project.model.Provinsi;
import com.bcaf.project.repository.KecamatanRepo;
import com.bcaf.project.repository.KelurahanRepo;
import com.bcaf.project.repository.KotaRepo;
import com.bcaf.project.repository.ProvinsiRepo;


@Controller
@RequestMapping(value="/kecamatan/")
public class KecamatanController {
	
	@Autowired
	private KecamatanRepo repo;
	
	@Autowired
	private KotaRepo kotaRepo;
	
	@Autowired
	private KelurahanRepo kelurahanRepo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("kecamatan/index");
		List<Kecamatan> list = this.repo.findAll();

		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value="create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("kecamatan/_form");
		view.addObject("kecamatan", new Kecamatan());
		
		List<Kota> listKota = this.kotaRepo.findAll();
		view.addObject("listKota", listKota);

		return view;
	}
	
	@PostMapping(value="save")
	public ModelAndView save(@ModelAttribute Kecamatan kecamatan, BindingResult result) {
		ModelAndView view = new ModelAndView("kecamatan/_form");
		//query simpan ke databse
		if(result.hasErrors()) {
			view.addObject("kecamatan", kecamatan);
		} else {
			this.repo.save(kecamatan);
			view.addObject("kecamatan", new Kecamatan() );
		}
		return view;
	}
	
	@GetMapping(value="update")
	public ModelAndView update(@ModelAttribute Kecamatan kecamatan) {
		return  new ModelAndView("kecamatan/_form");
		
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kecamatan/_form");
		
		Kecamatan item = this.repo.findById(id).orElse(null);
		view.addObject("kecamatan", item);
		
		List<Kota> listKota = this.kotaRepo.findAll();
		view.addObject("listKota", listKota);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("kecamatan/_list");
		List<Kecamatan> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}

	
	@GetMapping(value = "hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kecamatan/_hapus");
		//ambil data department by id , lgi di save di object item
		Kecamatan item = this.repo.findById(id).orElse(null);
		//object item dikirim ke view melalui object view
		view.addObject("kecamatan", item);
		return view;
	}
	
	@PostMapping(value = "remove")
	public ModelAndView remove(@ModelAttribute Kecamatan kecamatan) {
		//perinta simpan ke databse 
		ModelAndView view = new ModelAndView("kecamatan/_form");
		if(this.kelurahanRepo.findByKecamatanId(kecamatan.getId()).size()==0) {
			this.repo.delete(kecamatan);
			view.addObject("kecamatan", new Kecamatan());
			
		} else {
			view.addObject("kecamatan", new Kecamatan());
		}

		return view;
	}
	
}
