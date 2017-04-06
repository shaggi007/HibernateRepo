
import java.util.*;
import util.HibernateUtil;
import org.hibernate.*;

public class Test_Person {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
	    Address home = new Address("IT Lane", "411004", "Pune");
	    Address home2 = new Address("Kalpana", "411004", "Kolhapur");
		
		
		//yogesh and vivek have some common friends and some they don't know
		
	
		Person vivek  = new Person("Vivek", "Kulkarni");
		Person veena  = new Person("Veena", "Kulkarni");
		//home.setUser(vivek);
		
		vivek.setHomeAddress(home);
		vivek.setShippingAddress(home);
		vivek.setId(new Long(1234));
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try{
	        session.save(vivek);
			
		tx.commit();
		
		session.close();
		}catch(Throwable ex){
			ex.printStackTrace();
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();
	//	session.evict(home);
	//Person customer = (Person)session.load(Person.class, new Long(4321));
		//System.out.println("DEBUG : Displaying Person"+customer+" and his Address "+customer.getHomeAddress());
	    veena.setId(new Long(4321));
	
		veena.setHomeAddress(home2);
		veena.setShippingAddress(home2);
		session.save(veena);
		//session.delete(customer);
		tx.commit(); /*
		System.out.println("DEBUG : Deleted Person from DB : "+customer+" and his friends "+customer.getFriends());
		Person customer1 = (Person)session.load(Person.class, new Long(2));
		System.out.println("DEBUG : Loaded 2nd Person from DB : "+customer+" and his friends "+customer1.getFriends());

		Person customer2 = (Person)session.load(Person.class, new Long(3));
		System.out.println("DEBUG : Loaded 3rd Person from DB : "+customer2+" and his friends "+customer2.getFriends());
		Person customer3 = (Person)session.load(Person.class, new Long(4));
		System.out.println("DEBUG : Loaded 3rd Person from DB : "+customer3+" and his friends "+customer3.getFriends());
		*/

	}

}
