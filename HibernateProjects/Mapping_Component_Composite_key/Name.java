/*
 * Created on Mar 22, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author vivek kulkarni
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.util.*;
import java.io.*;

public class Name implements Serializable {
	
	private String firstName;
	private String lastName;
	
	
	public void setFirstName(String name){
		System.out.println("DEBUG: Name.setFirstName called");
		this.firstName = name;
	}
	public String getFirstName(){
		System.out.println("DEBUG: Name.getFirstName called");
		return firstName;
	}
	public void setLastName(String name){
		System.out.println("DEBUG: Name.setLastName called");
		this.lastName = name;
	}
	public String getLastName(){
		System.out.println("DEBUG: Name.getLastName called");
		return lastName;
	}
	
}

