package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import beans.Actor;
import beans.Movies;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		
		Session session=sessionFactory.openSession();
		
		Transaction tran=session.beginTransaction();
		
		Actor a=new Actor();
		a.setActorId(1);
		a.setActorName("AkshayKumar");
		
		Movies m=new Movies();
		m.setMovieId(101);
		m.setMovieName("Airlift");
		m.setActor(a);
		
		Movies m1=new Movies();
		m1.setMovieId(102);
		m1.setMovieName("Holiday");
		m1.setActor(a);
		session.save(m);
		session.save(m1);
		session.save(a);
		
		tran.commit();
		session.close();
		sessionFactory.close();

	}

}
