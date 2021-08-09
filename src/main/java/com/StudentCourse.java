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
		
		//new StudentCourse().addStudent();
		// new StudentCourse().getStudent();
		// new StudentCourse().deleteStudent();
		// new StudentCourse().addCertiForStudent();
		new StudentCourse().deleteCertificate();
		
	}
	
	void getStudent() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		StudentBean sb = session.get(StudentBean.class, 11);// student
		System.out.println(sb.getFirstName());

		for (CertificateBean cb : sb.getCertificatBean()) {
			System.out.println(cb.getName());
		}
		session.close();
	}
	
	void addStudent() {
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
		
		StudentBean sb2 = new StudentBean();
		sb2.setFirstName("Aryan");
		
		StudentBean sb3 = new StudentBean();
		sb3.setFirstName("Abhishek");
		
		ArrayList<CertificateBean> certificateBeans = new ArrayList<CertificateBean>();
		
		certificateBeans.add(c1);
		certificateBeans.add(c2);
		certificateBeans.add(c3);
		
		sb1.setCertificatBean(certificateBeans);
		sb2.setCertificatBean(certificateBeans);
		sb3.setCertificatBean(certificateBeans);
		
		session.save(sb1);
		session.save(sb2);
		session.save(sb3);
		tx.commit();
		session.close();
	}
	
	void deleteStudent() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		StudentBean studentBean = session.get(StudentBean.class, 3);
		session.delete(studentBean);

		tx.commit(); 
		session.close();

	}
	
	void addCertiForStudent() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		CertificateBean cb = new CertificateBean();
		cb.setName("RoR");

		StudentBean sb = session.get(StudentBean.class, 4);
		sb.getCertificatBean().add(cb);

		session.save(sb);

		tx.commit();
		session.close();

	}
	
	void deleteCertificate() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		CertificateBean cb =  session.get(CertificateBean.class, 13);
		session.delete(cb);

		tx.commit();
		session.close();
	}

	
	
}
