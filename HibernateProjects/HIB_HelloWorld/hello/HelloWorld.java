package hello;
import util.HibernateUtil;
import org.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HelloWorld {
public static void main(String[] args){
	Message msg = new Message();
	Message msg2 = new Message();
	//Message mszg = Message.getInstance();
	msg.setMessage("Hello World");
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = session.getTransaction();
	//session.setFlushMode(FlushMode.NEVER);
	tx.begin();
	//msg.setId(new Long(57));
	session.save(msg);
	session.save(msg2);
	//session.flush();
	tx.commit();
	//session.close();
	//System.out.println("DEBUG:BEGIN Initiating a new Transaction");
	Transaction tx1 = session.beginTransaction();
	 Message msg1 = (Message)session.get(Message.class, 1L);
	//System.out.println("DEBUG : Got Message Object Getting Message concat"+msg1.concat_msg);
	//msg1.setMessage("Hello Again ");
	msg.setMessage("Now it is changed");
	System.out.println("DEBUG:Comming new Transaction");
	tx1.commit();
	
	
	System.out.println("DEBUG : Calling load again after flush");
	Message msgfromDb = (Message)session.load(Message.class, 1L);
	System.out.println("the details of the retrieved are "+msgfromDb);
	//if(msg1 ==msg2){
	//	System.out.println("DEBUG : Got Message Object Getting Message ID"+msg1.getMessage());
	  //  System.out.println("DEBUG : Got Message Object Getting Message ID"+msg2.getMessage());
	//}else
//		System.out.println("DEBUG : msg1 and msg2 are not same");
	//session.close();
		
	session.close();
}
}
