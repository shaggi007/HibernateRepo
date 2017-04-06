import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Student {
	Address addr;
	List<Person> friends = new ArrayList<Person>();
	Name id;
	List<String> subjects = new ArrayList<String>();
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public List<Person> getFriends() {
		return friends;
	}
	public void setFriends(List<Person> friends) {
		this.friends = friends;
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
	
	
	

}
