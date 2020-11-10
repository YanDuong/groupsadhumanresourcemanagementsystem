package sad.humanresourcemanagementsystem.model;
import java.sql.Date;
public class Contract {
private int id;
private int staffId;
private String employeeCode;
private String fullname;
protected ContractType type;
protected int ctId;
protected String fileLocation;
protected double hourSalary;
protected Date startDate;
protected Date endDate;
protected int adminSign;
protected int staffSign;
protected int status;
protected String baseSalary;
private String fileName;


public Contract() {}
public Contract(int id, int staffId, int ctId, String fileLocation, double hourSalary, Date startDate, Date endDate,
		int adminSign, int staffSign, int status, String baseSalary, String fileName) {
	super();
	this.id = id;
	this.staffId = staffId;
	this.ctId = ctId;
	this.fileLocation = fileLocation;
	this.hourSalary = hourSalary;
	this.startDate = startDate;
	this.endDate = endDate;
	this.adminSign = adminSign;
	this.staffSign = staffSign;
	this.status = status;
	this.baseSalary = baseSalary;
	this.fileName = fileName;
}


public Contract(int id, Date startDate, Date endDate, String baseSalary, double hourSalary,
		int adminSign, int staffSign, String fileLocation) {
	super();
	this.id = id;
	this.startDate = startDate;
	this.endDate = endDate;
	this.hourSalary = hourSalary;
	this.baseSalary = baseSalary;
	this.adminSign = adminSign;
	this.staffSign = staffSign;
	this.fileLocation = fileLocation;
}


public Contract(ContractType type, Date startDate, Date endDate,
		int adminSign, int staffSign, String baseSalary, double hourSalary) {
	super();
	this.type = type;
	this.hourSalary = hourSalary;
	this.startDate = startDate;
	this.endDate = endDate;
	this.adminSign = adminSign;
	this.staffSign = staffSign;
	this.baseSalary = baseSalary;
}

public Contract(int id, ContractType type, Date startDate, Date endDate,
		int adminSign, int staffSign, double hourSalary, String baseSalary, String employeeCode, String fullname) {
	this.id = id;
	this.type = type;
	this.startDate = startDate;
	this.endDate = endDate;
	this.adminSign = adminSign;
	this.staffSign = staffSign;
	this.hourSalary = hourSalary;
	this.baseSalary = baseSalary;
	this.employeeCode = employeeCode;
	this.fullname = fullname;
}

public Contract(int staffId, int ctId, double hourSalary, Date startDate, Date endDate, String baseSalary) {
	super();
	this.staffId = staffId;
	this.ctId = ctId;
	this.hourSalary = hourSalary;
	this.startDate = startDate;
	this.endDate = endDate;
	this.baseSalary = baseSalary;
}




public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public int getStaffId() {
	return staffId;
}


public void setStaffId(int staffId) {
	this.staffId = staffId;
}


public int getCtId() {
	return ctId;
}


public void setCtId(int ctId) {
	this.ctId = ctId;
}


public String getFileLocation() {
	return fileLocation;
}


public void setFileLocation(String fileLocation) {
	this.fileLocation = fileLocation;
}


public double getSalaryHour() {
	return hourSalary;
}


public void setSalaryHour(double salaryHour) {
	this.hourSalary = salaryHour;
}





public Date getStartDate() {
	return startDate;
}


public void setStartDate(Date startDate) {
	this.startDate = startDate;
}


public Date getEndDate() {
	return endDate;
}


public void setEndDate(Date endDate) {
	this.endDate = endDate;
}


public int getAdminSign() {
	return adminSign;
}

public void setAdminSign(int adminSign) {
	this.adminSign = adminSign;
}

public int getStaffSign() {
	return staffSign;
}

public void setStaffSign(int staffSign) {
	this.staffSign = staffSign;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}




public String getEmployeeCode() {
	return employeeCode;
}
public void setEmployeeCode(String employeeCode) {
	this.employeeCode = employeeCode;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getBaseSalary() {
	return baseSalary;
}

public void setBaseSalary(String baseSalary) {
	this.baseSalary = baseSalary;
}
public ContractType getType() {
	return type;
}
public void setType(ContractType type) {
	this.type = type;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}




}
