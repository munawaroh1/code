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

import com.bcaf.project.model.Employee1;
import com.bcaf.project.model.FollowUp;
import com.bcaf.project.model.KategoriPermasalahan;
import com.bcaf.project.model.Kota;
import com.bcaf.project.model.Provinsi;
import com.bcaf.project.model.Status;
import com.bcaf.project.repository.Employee1Repo;
import com.bcaf.project.repository.FollowupRepo;
import com.bcaf.project.repository.KategoriPermasalahanRepo;
import com.bcaf.project.repository.StatusRepo;

@Controller
@RequestMapping(value="/followup/")
public class FollowupController {
	
	@Autowired
	private FollowupRepo repo;
	
	@Autowired
	private KategoriPermasalahanRepo repoKategori; 
	
	@Autowired
	private StatusRepo repoStatus;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("followup/index");
		List<FollowUp> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("followup/_form");
		view.addObject("followup", new FollowUp()); //itu yg "provinsi" itu diliat dari th:object di file _form.html
		return view;
	}
	
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute FollowUp followup, BindingResult result) {
		ModelAndView view = new ModelAndView("followup/_form");
		if(result.hasErrors()) {
			view.addObject("followup", followup);
		}
		else {
			this.repo.save(followup);
			view.addObject("followup", new FollowUp());
		}
		
		return view;
		
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("followup/_form");
		FollowUp item = this.repo.findById(id).orElse(null);
		view.addObject("followup", item);
		
		List<KategoriPermasalahan> listKategori = this.repoKategori.findAll();
		view.addObject("listKategori", listKategori);
		
		List<Status> listStatus = this.repoStatus.findAll();
		view.addObject("listStatus", listStatus);
		
		return view;
	}
	
	@GetMapping(value="input/{id}")
	public ModelAndView input(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("followup/input");
		FollowUp item = this.repo.findById(id).orElse(null);
		view.addObject("followup", item);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("followup/_list");
		List<FollowUp> list = this.repo.findAll();
		view.addObject("list",list);
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("followup/_hapus");
		FollowUp item = this.repo.findById(id).orElse(null);
		view.addObject("followup", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute FollowUp followup) {
		
		this.repo.delete(followup);
		ModelAndView view = new ModelAndView("followup/_form");
		view.addObject("followup", new FollowUp());
		return view;
	}
}
