package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.HardwareEmployee;
import beans.SoftwareEmployee;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		
		Session session=sessionFactory.openSession();
		
		Transaction tran=session.beginTransaction();
		
		SoftwareEmployee se=new SoftwareEmployee(11,"Sachin","sachin@gmail.com",50000,"Hibernate");
		HardwareEmployee he=new HardwareEmployee(22,"Nilesh","nilesh@gmail.com",45000,9);
		
		session.save(se);
		session.save(he);
		
		tran.commit();
		session.close();
		sessionFactory.close();

	}

}
