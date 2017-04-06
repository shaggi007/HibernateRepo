
/**
 * An item for auction.
 *
Item to Bid is One-toMany (One Itme can have more than One Bidding
 */
import java.util.*;
import java.io.*;

public class Item implements Serializable, Comparable{

    private Long id = null;
    private int version = 0;
    Set<Bid> bids = new HashSet<Bid>();
    private String name;
    private String description;
    public Item(){}
    public Item(String name, String description){
                         
        this.name = name;
        this.description = description;
         
    }

    // ********************** Accessor Methods ********************** //

    public Long getId() { return id; }
    public int getVersion() { return version; }

    public String getName() { return name; }

    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
        // ********************** Common Methods ********************** //

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        final Item item = (Item) o;

        if (name != null ? !name.equals(item.name) : item.name != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);

        return result;
    }

    public String toString() {
        return  "Item ('" + getId() + "'), " +
                "Name: '" + getName() + "' " ;

    }

    public int compareTo(Object o) { return 0; }
        //if (o instanceof Item) {
            // Don't compare Date objects! Use the time in milliseconds!
            //return Long.valueOf(this.getCreated().getTime()).compareTo(
              //      Long.valueOf( ((Item)o).getCreated().getTime())
                //   );
        //}

	public Set<Bid> getBids() {
		return bids;
	}
	public  void setBids(Set<Bid> bids) {
		 this.bids = bids;
	}


}
