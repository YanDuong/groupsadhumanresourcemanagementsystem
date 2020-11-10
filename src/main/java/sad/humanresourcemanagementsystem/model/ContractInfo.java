package sad.humanresourcemanagementsystem.model;

import java.sql.Date;

public class ContractInfo extends Contract {
private String employeeCode;
private String fullName;
private String ctName;
public ContractInfo(int id, Date startDate, Date endDate, String baseSalary, double hourSalary, int adminSign, int staffSign, String fileLocation, String employeeCode, String fullName, String ctName) {
	super(id, startDate, endDate, baseSalary, hourSalary, adminSign, staffSign, fileLocation);
	this.employeeCode = employeeCode;
	this.fullName = fullName;
	this.ctName = ctName;
}

public double getHourSalary() {
	return super.getSalaryHour();
}
public String getEmployeeCode() {
	return employeeCode;
}



public void setEmployeeCode(String employeeCode) {
	this.employeeCode = employeeCode;
}

public String getFullName() {
	return fullName;
}


public String getCtName() {
	return ctName;
}

public void setCtName(String ctName) {
	this.ctName = ctName;
}


public void setFullName(String fullName) {
	this.fullName = fullName;
}





}
