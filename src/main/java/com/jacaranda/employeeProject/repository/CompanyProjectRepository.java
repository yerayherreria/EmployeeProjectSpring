package com.jacaranda.employeeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.employeeProject.model.CompanyProject;
import com.jacaranda.employeeProject.model.CompanyProjectId;

public interface CompanyProjectRepository extends JpaRepository<CompanyProject, CompanyProjectId> {

}
