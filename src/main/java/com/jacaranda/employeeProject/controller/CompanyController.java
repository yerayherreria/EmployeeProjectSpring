package com.jacaranda.employeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.service.CompanyService;

@Controller
public class CompanyController {
 
	@Autowired
	CompanyService cs;
	
	
	@GetMapping("/company/listCompanies")
	public String listCompanies(Model model) {
		List<Company> listCompanies = cs.getCompanies();
		
		model.addAttribute("listCompanies",listCompanies);
		return "company/listCompanies";
	}
	
	@GetMapping("/company/addCompany")
	public String addCompany(Model model) {
		Company comp = new Company();
		model.addAttribute("company",comp);
		
		return "company/addCompany";
	}
	
	@GetMapping("/company/addCompanySave")
	public String saveCompany(Model model,@ModelAttribute("company") Company cSave) {
		Company comp = new Company();
		model.addAttribute("company",comp);
		cs.addCompany(cSave);
		model.addAttribute("add","Añadido correctamente");
		return "company/addCompany";
	}
	
	@GetMapping("/company/deleteCompany")
	public String deleteCompany(Model model,@RequestParam("id") Company cDelete) {
		model.addAttribute("company",cDelete);
		
		return "company/deleteCompany";
	}
	
	@GetMapping("/company/deleteCompanySave")
	public String deleteCompanySave(Model model,@RequestParam("id") Company cDelete) {
		Company comp = new Company();
		
		model.addAttribute("company",comp);
		cs.deleteCompany(cDelete);
		model.addAttribute("delete","Borrado con exito");
		
		return "company/deleteCompany";
	}
	
	@GetMapping("/company/editCompany")
	public String updateCompany(Model model,@RequestParam("id") Company cUpdate) {
		model.addAttribute("company",cUpdate);
		
		return "company/editCompany";
	}
	
	@GetMapping("/company/editCompanySave")
	public String editCompanySave(Model model,@ModelAttribute("company") Company cUpdate) {
		Company comp = new Company();
		
		model.addAttribute("company",comp);
		cs.addCompany(cUpdate);
		model.addAttribute("edit","Editado con exito");
		
		return "company/editCompany";
	}

}
	