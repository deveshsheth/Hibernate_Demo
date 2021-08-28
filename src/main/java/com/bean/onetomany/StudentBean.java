package com.bean.onetomany;

import java.util.List;

public class StudentBean {
	
	int studentId;
	String FirstName;
	
	List<CertificateBean> certificateBean;
	
	
	
	
	public List<CertificateBean> getCertificateBean() {
		return certificateBean;
	}
	public void setCertificateBean(List<CertificateBean> certificateBean) {
		this.certificateBean = certificateBean;
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
