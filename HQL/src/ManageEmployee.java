import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManageEmployee {

	
	private static SessionFactory factory;
	public static void main(String[] args) {
				
		 try{
	         //factory = new Configuration().configure().buildSessionFactory();
			 factory=new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      
	      Session session = factory.openSession();
	      Transaction tx = session.beginTransaction();
	      
	      String hql = "FROM Employee";  //select * from Employee123
	      /* HQL vrs SQL
	       * 1)class name instead of tablename
	       * 2)field name instead of column name
	       * 3)Query is not starting from select *
	       * 4)In JDBC select * from tablename returns ResultSet, in Hibernate it returns List(without generic)
	       */
	      Query query = session.createQuery(hql);
	      //List results=query.list();
	      List<Employee> results = (List<Employee>)query.list();// Hibernate returns List so require casting
	      for(Employee emp:results)
	      {
	    	 // Employee emp=(Employee)obj;
	    	  System.out.println(emp.getFirstName());
	    	  System.out.println(emp.getLastName());
	    	  System.out.println(emp.getSalary());
	    	  
	      }
	      tx.commit();
	      session.close();
	      
	      //readOneProperty();
	      
        //  namedParameter();

	}
	private static void namedParameter() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
	      Transaction tx = session.beginTransaction();
	      
	   // String hql = "FROM Employee where id =? ";
	     // String hql = "FROM Employee where id =2 "; 
	      
	     String hql = "FROM Employee where id =:userid";
	     
		 Query query = session.createQuery(hql);
		//query.setInteger(0,2);
		 
		query.setParameter("userid",2);
		List<Employee> results =(List<Employee>) query.list();
		for(Employee emp:results)
		{
			System.out.println("From named parameter"+emp.getFirstName());
		}
		
		tx.commit();
		session.close();
		
	}
	/*////////////////////////join query
	 * package str;
 
import java.util.Iterator;
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class urLogic {
 
    public static void main(String args[])
    {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
 
        Query qry= session.createQuery("select v.vendorName, c.customerName from Vendor v Left Join v.children c");
 
        List l = qry.list();
        Iterator it=l.iterator();
 
        while(it.hasNext())
        {
            Object rows[] = (Object[])it.next();
            System.out.println(rows[0]+ " -- " +rows[1]);
        }
 
    }
}*/
	 
	private static void readOneProperty() {
		Session session = factory.openSession();
	      Transaction tx = session.beginTransaction();
	      
	      String hql = "select firstName FROM Employee";// * column name and table name is case sensitive  
		
		Query query = session.createQuery(hql);
		List<String> results =(List<String>) query.list();
		for(String s:results)
		{
			System.out.println(s);
		}
		
		tx.commit();
		session.close();
		
	}

}
