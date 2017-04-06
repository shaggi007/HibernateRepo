import java.util.*;
import util.HibernateUtil;
import org.hibernate.*;

public class Test_Person {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  Set<Person> friends = new HashSet<Person>();
	   Person friend1 = new Person();
	   Person friend2 = new Person();
	   Name name = new Name("Vivek","Kulkarni");
	   friend1.setId(name);
	   Name name2 = new Name("Shreeram","Kulkarni");
	   friend2.setId(name2);
	   Person person = new Person();
	   Name name3 = new Name("ShreeKrishna", "Kulkarni");
	   person.setId(name3);
	   friends.add(friend1);
	   friends.add(friend2);
	   person.setFriends(friends);
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   Transaction txn = session.beginTransaction();
	   session.save(person);
	   session.save(friend1);
	   session.save(friend2);
	   txn.commit();
	   
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		Person person = (Person)session.get(Person.class, new Name("ShreeKrishna","Kulkarni"));
	    session.delete(person);
		System.out.println(" Person First Name "+person.getId().getFirstName());
		System.out.println(" Person Last Name "+person.getId().getLastName());
	    txn.commit();*/
	   session.close();
	   
	}

}
