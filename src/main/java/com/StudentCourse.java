package com;



import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.CertificateBean;
import com.bean.StudentBean;

public class StudentCourse {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		CertificateBean c1 = new CertificateBean();
		c1.setName("Java");
		
		CertificateBean c2 = new CertificateBean();
		c2.setName("Angular");
		
		CertificateBean c3 = new CertificateBean();
		c3.setName("Spring");
		
		StudentBean sb1 = new StudentBean();
		sb1.setFirstName("Devesh");
		sb1.setFirstName("Abhishek");
		
		ArrayList<CertificateBean> certificateBeans = new ArrayList<CertificateBean>();
		
		certificateBeans.add(c1);
		certificateBeans.add(c2);
		certificateBeans.add(c3);
		
		sb1.setCertificatBean(certificateBeans);
		
		session.save(sb1); 
		tx.commit();
		session.close();
	}
	
	
}
