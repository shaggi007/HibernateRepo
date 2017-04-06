import java.util.HashSet;

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
		
		UserDetails user=new UserDetails();
		
		user.setUserName("Rupesh");
		UserDetails user2=new UserDetails();
		user2.setUserName("Sujit");
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		
		vehicle.setUser(user);
		vehicle.setUser(user2);
		session.save(user);
		session.save(user2);
		session.save(vehicle);
		
		
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