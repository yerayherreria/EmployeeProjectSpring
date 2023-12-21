package com.jacaranda.employeeProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jacaranda.employeeProject.model.Employee;
import com.jacaranda.employeeProject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository er;;
	
	public List<Employee> getEmployees(){
		return er.findAll();
	}
	
	public void addEmployee(Employee e) {
		er.save(e);
	}
	
	public void deleteEmployee(Employee e) {
		er.delete(e);
	}
	
	public Page<Employee> findAll(int pageNum, int pageSize, String fieldSort ,Boolean orderFieldSort){
		
		Pageable pageable = PageRequest.of(pageNum, pageSize,
				Sort.by(fieldSort).ascending());
		if(orderFieldSort) {
			 pageable = PageRequest.of(pageNum, pageSize,
					Sort.by(fieldSort).descending());
		} 
		return er.findAll(pageable);
	}
}
