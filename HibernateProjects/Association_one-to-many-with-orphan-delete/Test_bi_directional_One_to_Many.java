import util.HibernateUtil;
import org.hibernate.*;
import java.util.*;
public class Test_bi_directional_One_to_Many {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Item it = new Item("My Item","Dell Inspiron");
		Bid bid1 = new Bid();
		/*bid1.setItem(it);
		
		Bid bid2 = new Bid();
		bid2.setItem(it);
		Set<Bid> bids = new HashSet<Bid>();
		bids.add(bid1);
		bids.add(bid2);
		it.addBid(bid1);
		it.addBid(bid2);
		*/
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		//session.lock(it,null);
		//session.save(it);
		
	//	session.save(bid2);
		
		Item item = (Item)(session.get(Item.class, new Long(1)));
		Set<Bid> bids = item.getBids();
		//bids.add(bid1);
		System.out.println("DEBUG: *** This item has "+bids.size()+" bids");
		item.addBid(bid1);
		bid1.setItem(item);
		//session.save(bid1);
		System.out.println("DEBUG: *** This item has "+bids.size()+" bids");
		/*
		Iterator<Bid> itr = bids.iterator();
		//remove first Element from the set. Bid with ID 2 is removed.
	while(itr.hasNext())
	{
			Bid bid = itr.next();
			bid.getItem().addBid(bid1);
	}
		if(bids.isEmpty())
			System.out.println("\n\nDEBBUG : *******Set is Empty******\n\n");
		List bid_list = session.createQuery("from Bid").list();
		for(int i=0; i<bid_list.size();i++){
			System.out.println("Bid "+bid_list.get(i)+" for Item"+((Bid)bid_list.get(i)).getItem());
		
		}
		//I am expecting that one database row from Bid table will be removed 
		//becase now Bid with ID 2 will not have any Item associated with it
		//which means Bid with id 2 is an orphan BID.
		
		
		*/
		//System.out.println("DEBUG : Got Item"+item);
		tx.commit();
		

	}

}
