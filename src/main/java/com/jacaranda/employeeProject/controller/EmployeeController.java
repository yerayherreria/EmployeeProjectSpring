package com.jacaranda.employeeProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.model.Employee;
import com.jacaranda.employeeProject.service.CompanyService;
import com.jacaranda.employeeProject.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService es;
	@Autowired
	CompanyService cs;

	
	@GetMapping("/employee/listEmployee")
	public String listEmployee(Model model,@RequestParam("pageNumber") Optional<Integer> entrada,@RequestParam("pageSize") Optional<Integer> espacio) {
		/*List<Employee> listEmploye = es.getEmployees();
		
		model.addAttribute("listEmploye",listEmploye);*/
		int pageNumber = entrada.orElse(1);
		int espacio2 = espacio.orElse(10);
		Page<Employee> page = es.findAll(pageNumber, espacio2);
		
		model.addAttribute("listEmploye",page);
		model.addAttribute("totalItems",page.getSize());
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("currentPage",page.getPageable().getPageNumber());
		return "employee/listEmployee";
	}
	
	@GetMapping("/employee/addEmployee")
	public String addCompany(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		List<Company> listCompanies = cs.getCompanies();
		
		model.addAttribute("listCompanies",listCompanies);
		
		return "employee/addEmployee";
	}
	
	@GetMapping("/employee/addEmployeeSave")
	public String saveCompany(Model model,@ModelAttribute("employee") Employee eSave) {
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		es.addEmployee(eSave);
		model.addAttribute("add","Añadido correctamente");
		return "employee/addEmployee";
	}
	
	@GetMapping("/employee/deleteEmployee")
	public String deleteEmployee(Model model,@RequestParam("id") Employee eDelete) {
		model.addAttribute("employee",eDelete);
		
		return "employee/deleteEmployee";
	}
	
	@GetMapping("/employee/deleteEmployeeSave")
	public String deleteEmployeeSave(Model model,@RequestParam("id") Employee eDelete) {
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		es.deleteEmployee(eDelete);
		model.addAttribute("delete","Borrado con exito");
		
		return "employee/deleteEmployee";
	}
	
	@GetMapping("/employee/editEmployee")
	public String updateEmployee(Model model,@RequestParam("id") Employee eUpdate) {
		model.addAttribute("employee",eUpdate);
		List<Company> listCompanies = cs.getCompanies();
		
		model.addAttribute("listCompanies",listCompanies);
		return "employee/editEmployee";
	}
	
	@GetMapping("/employee/editEmployeeSave")
	public String editEmployeeSave(Model model,@ModelAttribute("employee") Employee eUpdate) {
		Employee emp = new Employee();
		model.addAttribute("employee",eUpdate);
		es.addEmployee(eUpdate);
		model.addAttribute("edit","Editado con exito");
		
		return "employee/editEmployee";
	}
}
