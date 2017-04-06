import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Student {
	Address addr;
	Map<Name,Address> friends = new HashMap<Name, Address>();
	Name id;
	List<String> subjects = new ArrayList<String>();
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	public Name getId() {
		return id;
	}
	public void setId(Name id) {
		this.id = id;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public Map<Name, Address> getFriends() {
		return friends;
	}
	public void setFriends(Map<Name, Address> friends) {
		this.friends = friends;
	}
	
	
	

}
