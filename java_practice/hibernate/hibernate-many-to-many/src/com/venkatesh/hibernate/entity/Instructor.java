package com.venkatesh.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructor_detail;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="instructor", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Course> courses;
	
	public Instructor() {
		
	}

	public Instructor(String first_name, String last_name, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructor_detail() {
		return instructor_detail;
	}

	public void setInstructor_detail(InstructorDetail instructor_detail) {
		this.instructor_detail = instructor_detail;
	}
	
	public void add(Course course) {
		if(courses == null) {
			courses = new ArrayList<Course>();
		}
		courses.add(course);
		course.setInstructor(this);
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ "]";
	}
	
	
}
