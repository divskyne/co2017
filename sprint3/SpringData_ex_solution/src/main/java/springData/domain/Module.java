/**
 * (C) Artur Boronat, 2016
 */
package springData.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="Modules")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="Modules_id")
	private int id;
	@Column(name="Modules_code")
    private String code;
	@Column(name="Modules_description")
	private String description;
	@Column(name="Modules_students")
	@ManyToMany(mappedBy="moduleList")
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
