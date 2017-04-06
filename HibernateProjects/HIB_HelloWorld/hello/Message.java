package hello;

public class Message {
    Long id;
    String message;
    String details;
    int msg_no;
    String concat_msg;
    public String toString(){
    	return id+" : "+message;
    }
    private static final Message msg = new Message();
     Message(){
    	 details="hi there";
     }
     public void setMessage(String str){
    	System.out.println("DEBUG : setMessage is called");
    	this.message=str;
    }
   public String getMessage(){
    	System.out.println("DEBUG : getMessage is called");
    	return message;
    }
   public void setDetails(String str){
  	System.out.println("DEBUG : setdetails is called");
    	this.details=str;
    }
    public String getDetails(){
    	System.out.println("DEBUG : getDetails is called");
    	return details;
    }
    Long getId(){
    	System.out.println("DEBUG : getId is called");
    	return id;
    }
    final  void setId(Long id){
    	System.out.println("DEBUG : setId is called");
    	this.id = id;
    }
    public static Message getInstance(){
    	return msg;
    }
}
