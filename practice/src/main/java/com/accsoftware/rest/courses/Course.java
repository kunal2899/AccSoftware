package com.accsoftware.rest.courses;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.accsoftware.rest.students.Student;

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String details;
	
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student stu;

	public Course() {
		this.name = new String();
		this.details = new String();
	}

	public Course(Long id, String name, String details, Student stu) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.stu = stu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stu == null) ? 0 : stu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Course other = (Course) obj;
		if (details == null) {
			if (other.details != null) {
				return false;
			}
		} else if (!details.equals(other.details)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (stu == null) {
			if (other.stu != null) {
				return false;
			}
		} else if (!stu.equals(other.stu)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", details=" + details + ", stu=" + stu + "]";
	}
	
}
