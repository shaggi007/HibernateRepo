import java.util.HashSet;
import java.util.List;
import org.hibernate.Query;
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
		/*
		UserDetails user=new UserDetails();
		
		user.setUserName("Rupesh");
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleName("Car");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		session.save(user);
		
		
		session.save(vehicle);
		session.save(vehicle2);
		tx.commit();
		session.close();
		*/
 session=factory.openSession();
		
	 tx=session.beginTransaction();
		
		
		 String hql = "select u.userid,u.userName,v.vehiclename FROM userdetails u left join u.vehicle v "; 
	      /* HQL vrs SQL
	       * 1)class name instead of tablename
	       * 2)field name instead of column name
	       * 3)Query is not starting from select *
	       * 4)In JDBC select * from tablename returns ResultSet, in Hibernate it returns List(without generic)
	       */
	      Query query = session.createQuery(hql);
	      //List results=query.list();
	     // List<Employee> results = (List<Employee>)query.list();// Hibernate returns List so require casting
	      List results = query.list();// Hibernate returns List so require casting
	      java.util.Iterator it = results.iterator();
	      while(it.hasNext())
	      {
	    	 // Employee emp=(Employee)obj;
	    	  System.out.println(it.getClass());
	    	  
	    	  Object[] obj=(Object[]) it.next();
	    	  System.out.println(obj[0]+""+obj[1]+""+obj[2]);
	    	//  System.out.println(emp.getLastName());
	    	  //System.out.println(emp.getSalary());
	    	  
	      }
	      tx.commit();
	      session.close();
	      
	    

	}

}
/*
UserDetails_Vehicle is created as a third table.
no of table created
1)UserDetails
2)Vehicle
3)Userdetails_vehicle

output
log4j:WARN No appenders could be found for logger (org.hibernate.cfg.annotations.Version).
log4j:WARN Please initialize the log4j system properly.
Hibernate: select hibernate_sequence.nextval from dual
Hibernate: select hibernate_sequence.nextval from dual
Hibernate: select hibernate_sequence.nextval from dual
Hibernate: insert into UserDetails (userName, userId) values (?, ?)
Hibernate: insert into Vehicle (vehicleName, vehicleId) values (?, ?)
Hibernate: insert into Vehicle (vehicleName, vehicleId) values (?, ?)
Hibernate: insert into UserDetails_Vehicle (UserDetails_userId, vehicle_vehicleId) values (?, ?)
Hibernate: insert into UserDetails_Vehicle (UserDetails_userId, vehicle_vehicleId) values (?, ?)
*/