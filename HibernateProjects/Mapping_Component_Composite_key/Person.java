
import java.util.*;

class Person{
    private Date birthday;
    private Name id;
    Person(){}
    public Person(Name id){
    	this.id=id;
    	System.out.println("DEBUG : Person Constructor called");
    }
    
    
    public Name getId(){
    	System.out.println("DEBUG: getId called");
    	return id;
    }
    public void setId(Name id){
    	this.id=id;
    }
    public void setBirthday(java.util.Date date){
    	System.out.println("DEBUG: setBirthday called");
    	this.birthday = date;
    }
    public Date getBirthday(){
    	System.out.println("DEBUG: getBirthday called");
    	return birthday;
    }
}
