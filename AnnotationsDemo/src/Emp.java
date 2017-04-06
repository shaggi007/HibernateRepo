import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Emp12")
public class Emp {
	@Id@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="empNo")
	private int empNumber;// @GeneratedValue work with Integer only
	
	@Column(name="empName")
	private String name;
	public String getName() {
		return name;
	}
	@Lob
	private String description;//description  varchar2(255)
	//to store 400 pages text  //description clob
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	public Emp(){}
	/*public Emp(int empNumber, String name) {
		super();
		this.empNumber = empNumber;
		this.name = name;
	}*/
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
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
	public void setName(String name) {
		this.name = name;
	}
	
	

}
