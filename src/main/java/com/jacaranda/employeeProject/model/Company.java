package com.jacaranda.employeeProject.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String city;
	
	@OneToMany(mappedBy="company")
	private List<Employee> listEmployees;
	
	@OneToMany(mappedBy="company")
	private List<CompanyProject> listComanyProjects;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Employee> getListEmployees() {
		return listEmployees;
	}
	public void setListEmployees(List<Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}
	public List<CompanyProject> getListComanyProjects() {
		return listComanyProjects;
	}
	public void setListComanyProjects(List<CompanyProject> listComanyProjects) {
		this.listComanyProjects = listComanyProjects;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return id == other.id;
	}
	
	
}
