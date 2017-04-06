import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class FirstLevleCache {
	
	private static SessionFactory factory;
	public static void main(String[] args) {
		
		 factory=new Configuration().configure().buildSessionFactory();
		
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		// First Level Cache By Default
		UserDetails user=(UserDetails)session.get(UserDetails.class,1);
		//user.setUserName("user 1");  //same existing rec no update
		//user.setUserName("user 10"); // now one select and one update
		UserDetails user2=(UserDetails)session.get(UserDetails.class,1);
		
		
		tx.commit();
      session.close();
      
      
    //  readData();
      
  
   }
	private static void readData() {
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		// First Level Cache By Default
		UserDetails user=(UserDetails)session.get(UserDetails.class,1);
		
		tx.commit();
	    session.close();
	      
		
		// TODO Auto-generated method stub
		
	}
}