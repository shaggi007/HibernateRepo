import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;



public class FirstLevelCache {
	
	private static SessionFactory factory;
	public static void main(String[] args) {
//		try{
		 factory=new AnnotationConfiguration().configure().buildSessionFactory();
		
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		// First Level Cache By Default
		UserDetails user=(UserDetails)session.get(UserDetails.class,1); // select * from userdetails where id=1
		UserDetails user3=(UserDetails)session.get(UserDetails.class,1);
		//System.out.println(user.getUserName());
		//UserDetails user1=(UserDetails)session.get(UserDetails.class,1);// select * from userdetails where id=1  sachin
		//user.setUserName("Nilesh "); // now one select and one update
		//UserDetails user2=(UserDetails)session.load(UserDetails.class,1);
		
		//UserDetails user=new UserDetails();
		//user.setUserName("Sachin");
		//session.save(user);
		
		tx.commit();
      session.close();
	/*	}catch(Exception e){System.out.println(e.getMessage());
		e.printStackTrace();
		}*/
 
  session=factory.openSession();
    tx=session.beginTransaction();
    user=null;
    System.out.println("Different session");
    user=(UserDetails)session.get(UserDetails.class,1);//select * from userdetails where userid=1
    
    tx.commit();
    session.close();
    

   }
		
	}
