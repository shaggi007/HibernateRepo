import util.HibernateUtil;
import org.hibernate.*;

public class Test_Replication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       PersistentClass object1 = new PersistentClass();
       object1.setSomething("Object1 in System user schema");
              
       SessionFactory factory_source = HibernateUtil.getSessionFactory("system"); 
       Session session_source = factory_source.openSession();
       
       Transaction tx1 = session_source.beginTransaction();
       System.out.println("DEBUG: Saving object with Id = "+object1.getId()+" Persistent");
       session_source.save(object1);
       PersistentClass object0 = (PersistentClass)session_source.get(PersistentClass.class, new Long(1));
       System.out.println("DEBUG: Saved with Id = "+object1.getId());
       tx1.commit();
       session_source.close();
       
       SessionFactory factory_target = HibernateUtil.getSessionFactory("vivek"); 
       Session session_target = factory_target.openSession();
       Transaction tx2 = session_target.beginTransaction();
       System.out.println("DEBUG : Object1 is being made Persistent");
        
       session_target.replicate(object0,ReplicationMode.LATEST_VERSION); //makes object1 a persistent object an explicit DB select statement and makes object1
       tx2.commit();
       session_target.close();
       
       
       
       
	

}
}
