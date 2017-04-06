import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;



@Embeddable
public class Address {
	//@Column(name="street_name")
	private String street;
	
	private String city;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
