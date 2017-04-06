package com.candidjava;

import java.sql.*;
import java.io.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class AddStudent {
	private static SessionFactory sessionFactory1;
	private static SessionFactory sessionFactory;

	public static void main(String args[]) throws Exception {
		if (args[0] != null || args[1] != null || args[2] != null) {// begin if
																	// A
			String name = args[0];
			String name1 = args[0];
			String degree = args[1];
			String phone = args[2];

			System.out.println("Name: " + name);
			System.out.println("Degree: " + degree);
			System.out.println("Phone: " + phone);

			if ((name.equals("") || degree.equals("") || phone.equals(""))) {
				System.out.println("All informations are Required");
			} else {

				try {// begin try
					sessionFactory = new Configuration().configure(
							"com\\xml\\hibernate.cfg.xml")
							.buildSessionFactory();
					sessionFactory1 = new Configuration().configure(
							"com\\xml\\student1.cfg.xml").buildSessionFactory();
				} catch (Exception e) {
					System.out.println("mathan");
					System.out.println(e.getMessage());
					System.err
							.println("Initial SessionFactory creation failed."
									+ e);

				}
				Session s = sessionFactory.openSession();
				Session s1 = sessionFactory1.openSession();
				Transaction tx1 = s1.beginTransaction();
				Transaction tx = s.beginTransaction();
				Student stu = new Student();
				stu.setName(name);
				stu.setDegree(degree);
				stu.setPhone(phone);
				s.save(stu);
				tx.commit();
				System.out.println("Added to oracle Database");
				if (s != null)
					s.close();

				Student1 stu1 = new Student1();
				stu1.setName(name1);
				s1.save(stu1);
				tx1.commit();
				System.out.println("Added to mysql Database");
				if (s1 != null)
					s1.close();
			}
		}// end of if A
	}// end of method
}// end of class
