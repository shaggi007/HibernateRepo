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
		
		Query query=session.createQuery("from UserDetails where userId=1");
		query.setCacheable(true);
		List user=query.list();
		
		
		Query query1=session.createQuery("from UserDetails where userId=1");
		query1.setCacheable(true);// 
		List user1=query1.list();
		
		tx.commit();
		session.close();
		
		
       Session session2=factory.openSession();
		
		Transaction tx2=session2.beginTransaction();
		
		Query query2=session2.createQuery("from UserDetails where userId=1");  // 2 queries Hibernate differentiate query cache
	    query2.setCacheable(true);// it not only caches the query result,it also tells the query to look in second level cache
	    user=query2.list();
		 
		tx2.commit();
		session2.close();
		
	}

}
/*
3 types of cache in Hibernate
1) first level cache -default
2)second level cache
3)Query level cache

If you want to use only query level cache, enabling second level cache is not required.

Just like not all entities are cacheable, we need to specify @cacheable, 
All queries also not cacheable

setCacheable has 2 roles
pull the record from database & set query cache
look from query cache
*/