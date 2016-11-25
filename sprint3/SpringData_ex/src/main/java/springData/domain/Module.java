/**
 * (C) Artur Boronat, 2016
 */
package springData.domain;

import java.util.HashSet;
import java.util.Set;

public class Module {
	private int id;
    private String code;
	private String description;
    private Set<Student> students = new HashSet<Student>();
    
	// Hibernate needs this generic constructor
    public Module(){}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
