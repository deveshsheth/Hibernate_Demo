package com.bean.annotation.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity//class
@Table(name="address")//db
public class AddressBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//pk generate
	int addressId;
	int pincode;
	String city;
	
	@OneToOne(targetEntity = EmployeesBean.class,cascade = CascadeType.ALL)
	EmployeesBean employees;
	
	public EmployeesBean getEmployees() {
		return employees;
	}
	public void setEmployees(EmployeesBean employees) {
		this.employees = employees;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
