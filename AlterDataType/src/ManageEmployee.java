import java.util.Date;
 

import org.hibernate.*;
public class ManageEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtil.getSessionFactory();
		if(factory!=null)
		{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee emp=new Employee(101,"project description",new Date());
		session.save(emp);
		
		tx.commit();
		}
		else
			System.out.println("factory null");

	}

}
