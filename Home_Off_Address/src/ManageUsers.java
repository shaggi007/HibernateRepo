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
		user.setUserName("Rupeshs");
		Address address=new Address();
		address.setStreet("off street name");
		address.setCity("off city name");
		
		user.setOfficeAddress(address);
		
		Address address2=new Address();
		address2.setStreet("Home street name");
		address2.setCity("Home city name");
		user.setHomeAddress(address2);
		session.save(user);
		
		tx.commit();
		session.close();

	}

}
