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
import com.bcaf.project.repository.KotaRepo;
import com.bcaf.project.repository.ProvinsiRepo;


@Controller
@RequestMapping(value="/kota/")
public class KotaController {
	
	@Autowired
	private KotaRepo repo; 
	
	@Autowired
	private ProvinsiRepo repoProvinsi;
	
	@Autowired
	private KecamatanRepo repoKecamatan;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("kota/index");
		List<Kota> list = this.repo.findAll();

		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value="create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("kota/_form");
		//"kota" dari form yg di folder kota
		view.addObject("kota", new Kota());
		
		List<Provinsi> listProvinsi = this.repoProvinsi.findAll();
		view.addObject("listProvinsi", listProvinsi);

		return view;
	}
	
	@PostMapping(value="save")
	public ModelAndView save(@ModelAttribute Kota kota, BindingResult result) {
		ModelAndView view = new ModelAndView("kota/_form");
		//jika ada eror
		if (result.hasErrors()) {
			view.addObject("kota", kota);
		} else {
			this.repo.save(kota);
			view.addObject("kota", new Kota());
		}
		return view;
	}
	
	@GetMapping(value="update")
	public ModelAndView update(@ModelAttribute Kota kota) {
		return  new ModelAndView("kota/_form");

	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kota/_form");
		Kota  item = this.repo.findById(id).orElse(null);
		view.addObject("kota", item);
		
		List<Provinsi> listProvinsi = this.repoProvinsi.findAll();
		view.addObject("listProvinsi", listProvinsi);

		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("kota/_list");
		List<Kota> list = this.repo.findAll();
		view.addObject("list", list);

		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kota/_hapus");
		Kota  item = this.repo.findById(id).orElse(null);
		view.addObject("kota", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute Kota kota) {
		// proses hapus
		ModelAndView view = new ModelAndView("kota/_form");
		if(this.repoKecamatan.findByKotaId(kota.getId()).size()==0) {
			this.repo.delete(kota);
		}
		this.repo.delete(kota);

		view.addObject("kota", new Kota());
		return view;
	}
	
}
