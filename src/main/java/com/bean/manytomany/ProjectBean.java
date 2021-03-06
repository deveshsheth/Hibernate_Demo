package com.bean.manytomany;

import java.util.Set;

public class ProjectBean {
	
	int projectId;
	String projectName;
	int budget;
	
	Set<EmployeeBean> employees;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.projectName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public Set<EmployeeBean> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeBean> employees) {
		this.employees = employees;
	}
	
	

}
