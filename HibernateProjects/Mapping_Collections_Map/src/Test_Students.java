import java.util.*;
import util.HibernateUtil;
import org.hibernate.*;

public class Test_Students {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*	   Map<Name, Address> friends = new HashMap<Name,Address>();
	   Name friend1 = new Name("Vivek","Kulkarni");
	   Name friend2 = new Name("Shreeram","Kulkarni");
	   Address addr1 = new Address("Pune",411004,"MH");
	   
	   Address addr2 = new Address("Soundalaga",591241,"KA");
	   
	   Student student = new Student();
	   Name name3 = new Name("ShreeKrishna", "Kulkarni");
	   student.setId(name3);
	   List<String> subjects = new ArrayList<String>();
	   subjects.add("Maths");
	   subjects.add("Science");
	   subjects.add("Samskrit");
	   student.setSubjects(subjects);
	   friends.put(friend1,addr1);
	   friends.put(friend2,addr2);
	   student.setFriends(friends);
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   Transaction txn = session.beginTransaction();
	   session.save(student);
	   
	   txn.commit();
	   */
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		Student student = (Student)session.get(Student.class, new Name("ShreeKrishna","Kulkarni"));
		
	   // session.delete(person);
		System.out.println(" Person First Name "+student.getId().getFirstName());
		System.out.println(" Person Last Name "+student.getId().getLastName());
		System.out.println("Fteching his Subjects");
		Map<Name, Address> friendsAddr = student.getFriends();
		Set<Name> keys = friendsAddr.keySet();
		for(Name name : keys){
			System.out.println(name.getFirstName()+"his Adr "+friendsAddr.get(name).getCity());
		}
		List<String> subjects = student.getSubjects();
		Iterator iter = subjects.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		for(int i=0; i< subjects.size(); i++){
			System.out.println(subjects.get(i));
		}
		
	//    txn.commit();
	   session.close();
	   
	} //end main

}
