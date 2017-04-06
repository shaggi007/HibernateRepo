import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionOfElements;

@Entity
public class UserDetails {
	
	@Id//@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;   
	
	private String userName;

	//@ElementCollection
    //private Set<Address> listOfAddresses=new HashSet<Address>();
	
   
    
    //@ManyToOne
	//@ElementCollection
	@CollectionOfElements
	@JoinTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
    private Set<Address> set1;
    
    
	public Set<Address> getSet1() {
		return set1;
	}

	public void setSet1(Set<Address> set1) {
		this.set1 = set1;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*public Set<Address> getListOfAddresses() {
		return listOfAddresses;
		
	}

	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
		
	}
*/
		
	

}
