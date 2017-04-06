import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateTest {

	
	public static void main(String[] args) {
	
		SessionFactory factory=null;
		//SessionFactory factory=new AnnotationConfiguration().addAnnotatedClass(UserDetails.class).buildSessionFactory();
		try{
		//factory=new AnnotationConfiguration().configure().addAnnotatedClass(UserDetails.class).buildSessionFactory();
			factory=new AnnotationConfiguration().configure().buildSessionFactory();
		}catch(Throwable obj){System.out.println("Errorrrrrrrrrr"+obj.getMessage());}
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		UserDetails user1=(UserDetails)session.get(UserDetails.class,1);  //select * from userdetails where userid=1
		
	 // Query query=session.createQuery("from UserDetails where userId=1"); //HQL  select * from userdetails where userid=1
	   //List user=query.list();
		
		
	/*	Query query2=session.createQuery("from UserDetails where userId=1"); //HQL  select * from userdetails where userid=1
		List use2r=query2.list();*/
		//user1.setUserName("Sourabh");  // now one select and one update
		
		//UserDetails user2=(UserDetails)session.get(UserDetails.class,1);
		 
		tx.commit();
		session.close();
		
		
      Session session2=factory.openSession();
		
		Transaction tx2=session2.beginTransaction();
		System.out.println("Different session");
		UserDetails user3=(UserDetails)session2.get(UserDetails.class,1);
		 
		tx2.commit();
		session2.close();
	
	}

}
/*

Performance
c lang - auto register
JDBC PreparedStatement Statement
*/