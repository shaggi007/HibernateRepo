import util.HibernateUtil;
import org.hibernate.*;
import java.util.*;
public class Test_One_to_Many {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Item it = new Item("Think Pad","IBM Think Pad");
		Bid bid1 = new Bid();
		Bid bid2 = new Bid();
		Set<Bid> bids = new HashSet<Bid>();
		bids.add(bid1);
		bids.add(bid2);
		
		it.setBids(bids);
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		
		//session.save(bid2);
		//session.save(bid1);
		//session.flush();
		//session.save(it);
		
		
		
		
		
		
		Item item = (Item)(session.load(Item.class, new Long(18)));
		System.out.println("DEBUG : Got Item  Deleting it "+item);
		session.delete(item);
		tx.commit();
		

	}

}
