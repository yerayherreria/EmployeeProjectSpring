package com.jacaranda.employeeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.model.Employee;
import com.jacaranda.employeeProject.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository cr;
	
	public List<Company> getCompanies(){
		return cr.findAll();
	}
	
	public void addCompany(Company c) {
		cr.save(c);
	}
	
	public void deleteCompany(Company c) {
		cr.delete(c);
	}
	
	public Page<Company> findAll(int pageNum, int pageSize){
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return cr.findAll(pageable);
		}
}
