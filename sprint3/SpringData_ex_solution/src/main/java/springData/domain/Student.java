/**
 * (C) Artur Boronat, 2016
 */
package springData.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="Students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="Students_id")
    private int id;
	@Column(name="Students_fullName")
    private String fullName;
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name="StudentsModules",
    	joinColumns=@JoinColumn(
    			name="Modules_Students_id",
    			referencedColumnName="Students_id"
    	),
    	inverseJoinColumns=@JoinColumn(
    		name="Students_modules_id",
    		referencedColumnName="Modules_id"
    	)
    )
	private List<Module> moduleList = new ArrayList<Module>();
    
	// Hibernate needs this generic constructor
    public Student(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Module> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}

}
