import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;   
	/* userid also can be object but in that case
	 @EmbeddedId
	 private Login userId  //a kind of composite primary key
	 
	 */
	
	private String userName;
	// must set unique column name otherwise error-repeated column in mapping for entity
	//@Embedded
	
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="off_street_name")),
		@AttributeOverride(name="city",column=@Column(name="off_City_name"))
	})
	private Address officeAddress;
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="Home_street_name")),
		@AttributeOverride(name="city",column=@Column(name="Home_City_name"))
	})
	private Address HomeAddress;

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

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Address getHomeAddress() {
		return HomeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		HomeAddress = homeAddress;
	}
	
	

}
