import util.HibernateUtil;
import org.hibernate.*;
import java.util.*;
public class Test_BillingDetails {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx =  session.beginTransaction();
		BillingDetails bdetails = new BillingDetails("SomeBody");
		createBillingDetails("BA",session);
		session.save(bdetails);
		List details = session.createQuery("from BillingDetails").list();
		for(int i=0;i<details.size();i++){
			System.out.println(details.get(i));
		}
		tx.commit();
		System.out.println("DEBUG : Successfully committed");
	}
	public  static void createBillingDetails(String type,Session session){
	  if(type.equals("CC")){
	    CreditCard credit_billing = new CreditCard("vivek","1","December","2009");
	    session.save(credit_billing);
      }else if(type.equals("BA")){
	     BankAccount bank_billing   = new BankAccount("veena","12345","SBI","SBIN004");
	     session.save(bank_billing);
	  }else{
		  BillingDetails details = new Echequeue("ShreeRam","6244","SBIN110022");
		  session.save(details);
	  }
	}

}
