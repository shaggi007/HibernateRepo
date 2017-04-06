import java.util.*;
import util.HibernateUtil;
import org.hibernate.*;

public class Test_Person {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//	Address home = new Address("IT Lane", "411004", "Pune");
		//Address home = new Address("IT Lane", "411004", "Pune");
		Name name = new Name("vivek","kulkarni");
		Name name2 = new Name("Yogesh","kulkarni");
		
		Name friend1 = new Name("vikas9","Joshi9");
		Name friend2 = new Name("Anand9","Deshpande9");
		Name friend3 = new Name("Sadashiv9","Patil9");
		Name friend4 = new Name("Pravin9","Kulkarni9");
		Set<Name> friends = new HashSet();
		Set<Name> friends2 = new HashSet();
		
		friends.add(friend1);
		friends.add(friend2);
		friends.add(friend3);
		friends.add(friend4);
		
		friends2.add(friend1);
		//yogesh and vivek have some common friends and some they don't know
		Name friend5 = new Name("Umesh9","Hedgewar9");
		friends2.add(friend3);
		friends2.add(friend4);
		friends2.add(friend5);
	
		Person vivek  = new Person(name,friends);
		Person yogesh = new Person(name2,friends2);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		//session.save(vivek);
		//session.save(yogesh);
		tx.commit();
		tx = session.beginTransaction();
		
		Person customer = (Person)session.load(Person.class, new Long(6));
		System.out.println("DEBUG : now deleting old person with id=6 "+customer+" and his friends "+customer.getFriends());
		session.delete(customer);
		tx.commit();
	/*	System.out.println("DEBUG : Deleted Person from DB : "+customer+" and his friends "+customer.getFriends());
		Person customer1 = (Person)session.load(Person.class, new Long(2));
		System.out.println("DEBUG : Loaded 2nd Person from DB : "+customer+" and his friends "+customer1.getFriends());

		Person customer2 = (Person)session.load(Person.class, new Long(3));
		System.out.println("DEBUG : Loaded 3rd Person from DB : "+customer2+" and his friends "+customer2.getFriends());
		Person customer3 = (Person)session.load(Person.class, new Long(4));
		System.out.println("DEBUG : Loaded 3rd Person from DB : "+customer3+" and his friends "+customer3.getFriends());
		*/

	}

}
