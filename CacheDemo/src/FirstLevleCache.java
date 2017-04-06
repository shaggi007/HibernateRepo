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
		UserDetails user=(UserDetails)session.get(UserDetails.class,1); // select * from userdetails where id=1
		
		
		
		
		UserDetails user1=(UserDetails)session.get(UserDetails.class,1);// select * from userdetails where id=1  sachin
		//user.setUserName("sachin "); // now one select and one update
		//UserDetails user2=(UserDetails)session.get(UserDetails.class,1);
		
		//UserDetails user=new UserDetails();
		//user.setUserName("Sachin");
		//session.save(user);
		
		tx.commit();
      session.close();
      
     /*
    session=factory.openSession();
    tx=session.beginTransaction();
    user=null;
    user=(UserDetails)session.get(UserDetails.class,1);
    
    tx.commit();
    session.close();
      
 */
   }
		
		// TODO Auto-generated method stub
		
	}
