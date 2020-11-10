package sad.humanresourcemanagementsystem.model;

public class Department {
private int id;
private String name;
private String employeeCode;
private String employeeName;
public Department(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}

public Department() {
	
}
public Department(int id, String name, String employeeCode, String employeeName) {
	super();
	this.id = id;
	this.name = name;
	this.employeeCode = employeeCode;
	this.employeeName = employeeName;
}


public String getEmployeeCode() {
	return employeeCode;
}


public void setEmployeeCode(String employeeCode) {
	this.employeeCode = employeeCode;
}


public String getEmployeeName() {
	return employeeName;
}


public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
