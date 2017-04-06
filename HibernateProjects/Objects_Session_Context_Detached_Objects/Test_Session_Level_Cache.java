import util.HibernateUtil;
import org.hibernate.*;

public class Test_Session_Level_Cache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       PersistentClass object1 = new PersistentClass();
       object1.setSomething("Objhect1");
       SessionFactory factory = HibernateUtil.getSessionFactory(); 
       Session session = factory.openSession();
       
       Transaction tx = session.beginTransaction();
       //OBJECT1 IS STILL A TRANSIENT OBJECT SO id WILL BE null
       System.out.println("DEBUG: making object with Id = "+object1.getId()+" Persistent");
       session.save(object1);
       //OBJECT1 IS A perSISTENT OBJECT SO id WILL BE ASSIGNED BY USING THE STRAGEY SELECTED
       System.out.println("DEBUG: object with Id = "+object1.getId()+" IS NOW Persistent");
       
       tx.commit();
       if(!session.isDirty())//here is session is not dirty
    	   System.out.println("DEBUG : state of session is not Dirty");
       session.close();
       if(!session.isOpen())
          session = factory.openSession();
      // session = factory.getCurrentSession();
       tx = session.beginTransaction();
       //make object1 persistent again
       System.out.println("DEBUG : Object1 is being made Persistent");
        
      //session.refresh(object1); //makes object1 a persistent object an explicit DB select statement and makes object1
       
       //merge() all doesn't make object1 persistent but loads object from memory with ID same as 
       //object1. But Object1's state is copied into this new object at the same time 
       // the old object1 is still detached.and SQL Update is issued to the DB with new state merged from object1
      object1.setSomething("Hello");
       
       // PersistentClass object_after_merge = (PersistentClass)session.merge(object1);
       //System.out.println("DEBUG : state of newly created persistent instance"+object_after_merge.getSomething()+" Id = "+object_after_merge.getId());
       if(!session.isDirty()) //session here is still not dirty
    	  // System.out.println("DEBUG : state of session is not Dirty"+object1.getId());
      // session.update(object1);//Now session is dirty and
       session.lock(object1,LockMode.NONE);//Now session should be dirty but somehow it is NOT
       // will make detached object1 as persistent object1
       object1.setSomething("Hello ");
       if(session.isDirty())
    	   System.out.println("DEBUG : Session is now Dirty");
       else 
    	   System.out.println("DEBUG : Session is NOT Dirty"+object1.getId());
   //    session.saveOrUpdate(object1);
    /*  if(object1==object_after_merge)
    	  System.out.println("The Perobject is same as detached one!!");
          else 
       	   System.out.println("Its is now changed vow !!!");
      */
       //PersistentClass object0 = session.get(PersistentClass.class, newLong(1));
     // System.out.println("DEBUG : Object1 is being retrieved from DB");
      // PersistentClass object4 = (PersistentClass)session.get(PersistentClass.class, new Long(1));
      /* if(object4==object1)
           System.out.println("This is SAME !!!"+object1.getSomething());
       else {
    	   System.out.println("They are DIFFERENT !!!");
       }*/
     //  System.out.println("DEBUG: deleting objectwith Id = "+object1.getId());
       //session.delete(object1);
      // System.out.println("DEBUG: Printing Id of deleted object"+object1.getId());
       tx.commit();
       
       
       
	

}
}
