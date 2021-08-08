package com.bean;

import java.util.List;

public class StudentBean {
	
	int studentId;
	String FirstName;
	
	List<CertificateBean> certificatBean;
	
	public List<CertificateBean> getCertificatBean() {
		return certificatBean;
	}
	public void setCertificatBean(List<CertificateBean> certificatBean) {
		this.certificatBean = certificatBean;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	

}
