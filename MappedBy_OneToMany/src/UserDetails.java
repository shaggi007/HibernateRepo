
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class UserDetails {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;   
	
	private String userName;
	@OneToMany
	@JoinTable(name="user_vehicle" ,joinColumns=@JoinColumn(name="user_id"),
	           inverseJoinColumns=@JoinColumn(name="vehicle_id")		
	)
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
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

	
}
