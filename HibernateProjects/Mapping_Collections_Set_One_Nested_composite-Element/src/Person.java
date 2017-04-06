import java.util.HashSet;
import java.util.Set;


public class Person {
	Address addr;
	Set<Person> friends = new HashSet<Person>();
	Name id;
	
	public Person(){}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public Set<Person> getFriends() {
		return friends;
	}
	public void setFriends(Set<Person> friends) {
		this.friends = friends;
	}
	public Name getId() {
		return id;
	}
	public void setId(Name id) {
		this.id = id;
	}
	public Person(Address addr, Set<Person> friends, Name id) {
		super();
		this.addr = addr;
		this.friends = friends;
		this.id = id;
	}
	

}
