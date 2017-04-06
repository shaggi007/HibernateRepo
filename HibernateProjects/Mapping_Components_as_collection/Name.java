
public class Name {
  String firstName;
  String lastName;
  //Address homeAddr;
  Name(){}
  Name(String fname,String lname){
	  this.firstName = fname;
	  this.lastName  = lname;
	//  this.homeAddr  = addr;
	  
  }
  public String toString(){
	  return " Name = "+this.firstName+" "+this.lastName+"\n";//+homeAddr.toString();
  }
}
