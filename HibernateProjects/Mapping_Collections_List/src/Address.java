
public class Address {
	Address(){}
	public Address(String city, int zip, String state) {
		super();
		this.city = city;
		this.zip = zip;
		this.state = state;
	}
	String city;
	int zip;
	String state;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
