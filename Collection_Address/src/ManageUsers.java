import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class ManageUsers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=null;
		//SessionFactory factory=new AnnotationConfiguration().addAnnotatedClass(UserDetails.class).buildSessionFactory();
		try{
		//factory=new AnnotationConfiguration().configure().addAnnotatedClass(UserDetails.class).buildSessionFactory();
			factory=new AnnotationConfiguration().configure().buildSessionFactory();
		}catch(Throwable obj){System.out.println("Errorrrrrrrrrr"+obj.getMessage());}
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		UserDetails user=new UserDetails();
		user.setUserId(1);
		user.setUserName("Rupesh");
		Address address=new Address();
		address.setStreet("first street name");
		address.setCity("first city name");
		
		//user.getListOfAddresses().add(address);
		
		Address address2=new Address();
		address2.setStreet("second street name");
		address2.setCity("second city name");
		//user.getListOfAddresses().add(address2);
		
		HashSet<Address> obj=new HashSet<Address>();
		obj.add(address);
		obj.add(address2);
		user.setSet1(obj);
		session.save(user);
		
		tx.commit();
		session.close();

	}

}
