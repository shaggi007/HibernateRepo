package model;

import java.util.Set;

public class Course {
	private int courseId;
	private String courseName;
	private int fees;
	private Set<Faculty> faculties;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public Set<Faculty> getFaculties() {
		return faculties;
	}
	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}
	
	

}
