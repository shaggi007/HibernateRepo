import java.util.*;
import util.HibernateUtil;
import org.hibernate.*;

public class Test_Students {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   List<Person> friends = new ArrayList<Person>();
	   Person friend1 = new Person();
	   Person friend2 = new Person();
	   Name name = new Name("Vivek","Kulkarni");
	   friend1.setId(name);
	   Address addr1 = new Address("Pune",411004,"MH");
	   friend1.setAddr(addr1);
	   
	   Name name2 = new Name("Shreeram","Kulkarni");
	   friend2.setId(name2);
	   Address addr2 = new Address("Soundalaga",591241,"KA");
	   friend2.setAddr(addr2);
	   Student student = new Student();
	   Name name3 = new Name("ShreeKrishna", "Kulkarni");
	   student.setId(name3);
	   List<String> subjects = new ArrayList<String>();
	   subjects.add("Maths");
	   subjects.add("Science");
	   subjects.add("Samskrit");
	   student.setSubjects(subjects);
	   friends.add(friend1);
	   friends.add(friend2);
	   student.setFriends(friends);
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   Transaction txn = session.beginTransaction();
	   session.save(student);
	   
	   txn.commit();
	   session.clear();
		//Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction txn = session.beginTransaction();
	   txn.begin();
		Student student2 = (Student)session.get(Student.class, new Name("ShreeKrishna","Kulkarni"));
	   // session.delete(person);
		System.out.println(" Person First Name "+student2.getId().getFirstName());
		System.out.println(" Person Last Name "+student2.getId().getLastName());
		System.out.println("Fteching his Subjects");
		List<String> subjects2 = student2.getSubjects();
		List<Person> friends2 = student2.getFriends();
		for(Person friend55 : friends){
			System.out.println(friend55.getId().getFirstName());
		}
		Iterator iter = subjects2.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		for(int i=0; i< subjects.size(); i++){
			System.out.println(subjects.get(i));
		}
		
	    txn.commit();
	   session.close();
	   
	} //end main

}
