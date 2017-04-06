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
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehicleName("Two wheeler name");
		bike.setSteeringHandle("steeringHandle");
		
		FourWheeler car=new FourWheeler();
		car.setVehicleName("Four wheeler name");
		car.setSteeringWheel("steeringWheel");
		
		session.save(vehicle); // Though we specify 3 entities it creates only one table
		session.save(bike);  // Hibernate by default strategy in inheritance is single table....below
		session.save(car);
		
		tx.commit();
		session.close();
		
	}

}
/*
Hibernate: insert into Vehicle (vehicleName, DTYPE, vehicleId) values (?, 'Vehicle', ?)
Hibernate: insert into Vehicle (vehicleName, steeringHandle, DTYPE, vehicleId) values (?, ?, 'TwoWheeler', ?)
Hibernate: insert into Vehicle (vehicleName, steeringWheel, DTYPE, vehicleId) values (?, ?, 'FourWheeler', ?)

one extra column added DTYPE which tells you what class it is
DTYPE is also called discriminator - to distinguish between vehicle/FourWheeler/TwoWheeler object.
if you don't prvoide the value of steeringhandle/steeringwheel ,using this discriminator we can identify implementation.
*/