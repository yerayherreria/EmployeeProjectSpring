package com.jacaranda.employeeProject.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	@Id
	private int id;
	
	private String name;
	private String butget;
	
	@OneToMany(mappedBy="project")
	private List<CompanyProject> listCompanyProjects;
	
	@OneToMany(mappedBy="project")
	private List<EmployeeProject> listEmployeeProjects;

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

	public String getButget() {
		return butget;
	}

	public void setButget(String butget) {
		this.butget = butget;
	}

	public List<CompanyProject> getListCompanyProjects() {
		return listCompanyProjects;
	}

	public void setListCompanyProjects(List<CompanyProject> listCompanyProjects) {
		this.listCompanyProjects = listCompanyProjects;
	}

	public List<EmployeeProject> getListEmployeeProjects() {
		return listEmployeeProjects;
	}

	public void setListEmployeeProjects(List<EmployeeProject> listEmployeeProjects) {
		this.listEmployeeProjects = listEmployeeProjects;
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
		Project other = (Project) obj;
		return id == other.id;
	}
}
