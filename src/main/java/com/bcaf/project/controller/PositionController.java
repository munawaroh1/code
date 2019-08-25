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

import com.bcaf.project.model.Kota;
import com.bcaf.project.model.Position;
import com.bcaf.project.model.Provinsi;
import com.bcaf.project.model.ViewPosition;
import com.bcaf.project.repository.KotaRepo;
import com.bcaf.project.repository.PositionRepo;
import com.bcaf.project.repository.ProvinsiRepo;
import com.bcaf.project.repository.ViewPositionRepo;


@Controller
@RequestMapping(value="/position/")
public class PositionController {
	
	@Autowired
	private ViewPositionRepo repo; 
	
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("position/index");
//		List<Position> list = this.repo.findAll();
//		view.addObject("list", list);
		List<ViewPosition> parent = this.repo.findAll();
		view.addObject("parent", parent);
		return view;
	}
//	
//	@GetMapping(value="create")
//	public ModelAndView create() {
//		ModelAndView view = new ModelAndView("provinsi/_form");
//		view.addObject("provinsi", new Provinsi());
//
//		return view;
//	}
//	
//	@PostMapping(value="save")
//	public ModelAndView save(@ModelAttribute Provinsi provinsi, BindingResult result) {
//		ModelAndView view = new ModelAndView("provinsi/_form");
//		//jika ada eror
//		if(result.hasErrors()) {
//			view.addObject("provinsi", provinsi);
//		} else {
//			this.repo.save(provinsi);
//			view.addObject("provinsi", new Provinsi() );
//		}
//		
//		return view;
//	}
//	
//	@GetMapping(value="update")
//	public ModelAndView update(@ModelAttribute Provinsi provinsi) {
//		return  new ModelAndView("provinsi/_form");
//
//	}
//	
//	@GetMapping(value="list")
//	public ModelAndView list() {
//		ModelAndView view = new ModelAndView("provinsi/_list");
//		List<Provinsi> list = this.repo.findAll();
//		view.addObject("list", list);
//		return view;
//	}
//	
//	
//	@GetMapping(value="edit/{id}")
//	public ModelAndView edit(@PathVariable("id") Long id) {
//		ModelAndView view = new ModelAndView("provinsi/_form");
//		
//		Provinsi provinsi = this.repo.findById(id).orElse(null);
//		view.addObject("provinsi", provinsi);
//		
//		return view;
//	}
//	
//	@GetMapping(value = "hapus/{id}")
//	public ModelAndView hapus(@PathVariable("id") Long id) {
//		ModelAndView view = new ModelAndView("provinsi/_hapus");
//		//ambil data department by id , lgi di save di object item
//		Provinsi item = this.repo.findById(id).orElse(null);
//		//object item dikirim ke view melalui object view
//		view.addObject("provinsi", item);
//		return view;
//	}
//	
//	@PostMapping(value="remove")
//	public ModelAndView remove(@ModelAttribute Provinsi provinsi) {
//		//#1 check data di kota
//		ModelAndView view = new ModelAndView("provinsi/_form");
//		if(this.kotaRepo.findByProvinsiId(provinsi.getId()).size()==0) {
//			// jika tidak ada data provinsi di kota, maka proses hapus dilakukan
//			this.repo.delete(provinsi);
//			view.addObject("provinsi", new Provinsi());
//		} else {
//			view.addObject("provinsi", new Provinsi());
//		}
//		
//		return view;
//	}
	
}
