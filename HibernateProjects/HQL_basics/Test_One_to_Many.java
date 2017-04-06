import util.HibernateUtil;
import org.hibernate.*;
import java.util.*;
public class Test_One_to_Many {

	/**
	 * @param args
	 */
	public static void createItems() {
		Item it = new Item("Think Pad","IBM Think Pad");
		Item it2 = new Item("LapTop","Dell Inspiron");
		Bid bid1 = new Bid(10000,it);
		Bid bid2 = new Bid(1010,it);
		Bid bid3 = new Bid(1110,it2);
		Bid bid4 = new Bid(1110,it2);
		Set<Bid> bids = new HashSet<Bid>();
		bids.add(bid1);
		bids.add(bid2);
		Set<Bid> bids2 = new HashSet<Bid>();
		bids2.add(bid3);
		bids2.add(bid4);
		it.setBids(bids);
		it2.setBids(bids2);
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	
		session.save(it);
		session.save(it2);
		tx.commit();
	}
		public static void createItems(int number_of_items, int number_of_bids){
			Session session= HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			
		    for(int i=0; i <number_of_items; i++){
			   Item it = new Item(("item"+i),("description"+i));
			   Set<Bid> bids = new HashSet<Bid>();
			   if(i%2==0){ //make every alternate item to have a successfule Bid
				  Bid successfulBid = new Bid(); 
				  successfulBid.setAmount(10000);
			      it.setSuccessfulBid(successfulBid);
		          successfulBid.setItem(it);
		          bids.add(successfulBid);
			   }
		       for(int j=0; j<number_of_bids; j++){
                  Bid b = new Bid(j*100,it);	
                  bids.add(b);
		      }
		       it.setBids(bids);
		       session.save(it);
		   }
          tx.commit();
	    }

}
