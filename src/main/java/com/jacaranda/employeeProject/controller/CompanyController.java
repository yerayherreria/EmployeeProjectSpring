package com.jacaranda.employeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.service.CompanyService;

@Controller
public class CompanyController {
 
	@Autowired
	CompanyService cs;
	
	
	@GetMapping("/listCompanies")
	public String listCompanies(Model model) {
		List<Company> listCompanies = cs.getCompanies();
		
		model.addAttribute("listCompanies",listCompanies);
		return "listCompanies";
	}
}
