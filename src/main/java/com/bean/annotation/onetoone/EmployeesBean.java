package com.bean.annotation.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity//class
@Table(name="employee")//db
public class EmployeesBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//pk generate
	@PrimaryKeyJoinColumn
	int employeeId;
	String name;
	
	// Optional  => com.bean.annotation.onetoone. (Path)
	@OneToOne(targetEntity = AddressBean.class,cascade = CascadeType.ALL)
	AddressBean address;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}
	
	
	
}
