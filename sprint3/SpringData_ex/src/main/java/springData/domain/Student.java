/**
 * (C) Artur Boronat, 2016
 */
package springData.domain;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String fullName;
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
