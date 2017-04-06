import java.util.Date;



public class Employee {
	private int employeeId;
	
	private String description;
	
	private Date joiningDate;


	private String extraInfo;
	
	public Employee(int employeeId, String description, Date joiningDate) {
		super();
		this.employeeId = employeeId;
		this.description = description;
		this.joiningDate = joiningDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	

}
