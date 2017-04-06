import util.*;

import org.hibernate.*;

public class Test_Component_Mapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();		
		Address homeAddr = new Address("Santosh", "SantoshHome 411004", "Santosh Home Pune");
		Address billingAddr = new Address("Billing IT Lane", "Billing 411004", "Billing Pune");
		Customer customer1 = new Customer("Santosh"+session.hashCode(), "Mangaonkar", "Santosh Mangaonkar"+session.hashCode(), "passwd", "vikuk@hotmail.com",homeAddr, billingAddr);
		
	//	billingAddr.setCustomer(customer1);
	//	billingAddr.setCustomer(customer1);
		Transaction tx = session.beginTransaction();
		System.out.println("DEBUG : Saving Santosh" );
		session.save(customer1);
		tx.commit();
		System.out.println("DEBUG : Successfully saved Santosh" );
		System.out.println("\n\nDEBUG : Saving Sanjaya with same home Address" );
		Customer customer2 = new Customer("Sanjay"+session.hashCode(), "Mangaonkar", "Sanjay Mangaonkar"+session.hashCode(), "passwd", "vikuk@hotmail.com",homeAddr, billingAddr);
		Transaction tx1 = session.beginTransaction();
		session.save(customer2);
		tx1.commit();
		Address billingAddress = ((Customer)session.get(Customer.class, new Long(2))).getBillingAddress();
		System.out.println("Billing address in DB "+billingAddress);
		System.out.println("Customer details from Billing address in DB "+billingAddress.getCustomer());
		
		
        tx.commit();
	}

}
