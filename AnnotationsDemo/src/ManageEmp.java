import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class ManageEmp {

	
	private static SessionFactory factory;
	public static void main(String[] args) {
	
		 try{
		      // very expensive object, takes too many resources to create, so we must create object per application 		    	  
		    	  factory = new AnnotationConfiguration().configure().addAnnotatedClass(Emp.class).buildSessionFactory();
		      }catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
		      
		      Session session=factory.openSession();
		      Transaction tx=session.beginTransaction();//without transaction table is created but data is not inserted.
		      Emp emp=new Emp();//1,"Sachin");
		      emp.setName("one more name");
		      session.save(emp);
		      
		      tx.commit();
		      session.close();//ideally rollback and session.close should be finally block
		      
		      emp=null;
		      session=factory.openSession();
		      tx=session.beginTransaction();
		      emp=(Emp)session.get(Emp.class,1);//not dealing with tables ,communicating with object
		      System.out.println(emp.getName());

	}

}
