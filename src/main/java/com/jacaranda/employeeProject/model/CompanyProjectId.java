package com.jacaranda.employeeProject.model;

import java.sql.Date;
import java.util.Objects;

public class CompanyProjectId {
	private int company;
	private int project;
	private Date begin;
	public CompanyProjectId(int company, int project, Date begin) {
		super();
		this.company = company;
		this.project = project;
		this.begin = begin;
	}
	public CompanyProjectId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCompany() {
		return company;
	}
	public void setCompany(int company) {
		this.company = company;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(begin, company, project);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyProjectId other = (CompanyProjectId) obj;
		return Objects.equals(begin, other.begin) && company == other.company && project == other.project;
	}
}
