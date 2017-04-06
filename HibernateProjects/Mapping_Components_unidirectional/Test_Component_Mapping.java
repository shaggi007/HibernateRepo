import util.*;

import org.hibernate.*;

public class Test_Component_Mapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();		
		Address homeAddr = new Address("Home IT Lane", "Home 411004", "Home Pune");
		Address billingAddr = new Address("Billing IT Lane", "Billing 411004", "Billing Pune");
		Customer customer = new Customer("Vivek"+session.hashCode(), "Kulkarni", "Vivek Kulkarni"+session.hashCode(), "passwd", "vikuk@hotmail.com",homeAddr, billingAddr);
		Transaction tx = session.beginTransaction();
		//session.save(customer);
		Customer customer2 = new Customer("Vivek2"+session.hashCode(), "Kulkarni2", "2Vivek Kulkarni"+session.hashCode(), "2passwd", "vikuk@hotmail.com",homeAddr, billingAddr);
		//session.save(customer2);
		Customer cust = ((Customer)session.get(Customer.class, new Long(1)));
		System.out.println("Modifying customer object "+cust);
		cust.setLastname("Patil1");
			
        tx.commit();
	}

}
