import java.util.*;

public class Person {
	Set<Name> friends = new HashSet<Name>();//person has friends
	Name name;
	Long id;
	Person(){}
	Person(Name name,Set<Name> friends){
		this.name = name;
		this.friends = friends;
	}
	public Set<Name> getFriends(){return friends;}
	public Name getName(){ return name; }
	public String toString(){
		return name.toString();
	}
	

}
