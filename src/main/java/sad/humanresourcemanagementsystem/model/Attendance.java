package sad.humanresourcemanagementsystem.model;
import java.sql.Date;
import java.sql.Time;
public class Attendance {
private int id;
private Staff staff;
private String staffName;
private String employeeCode;
private Date date;
private int status;
private String departmentName;
private Time startAt;
private Time endAt;
public Attendance() {
	
}
public Attendance(int id, String staffName, String employeeCode, Date date, int status, String departmentName) {
	super();
	this.id = id;
	this.staffName = staffName;
	this.employeeCode = employeeCode;
	this.date = date;
	this.status = status;
	this.departmentName = departmentName;
}


public Attendance(int id, String staffName, Date date, int status) {
	super();
	this.id = id;
	this.staffName = staffName;
	this.date = date;
	this.status = status;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public Staff getStaff() {
	return staff;
}
public void setStaff(Staff staff) {
	this.staff = staff;
}
public String getStaffName() {
	return staffName;
}
public void setStaffName(String staffName) {
	this.staffName = staffName;
}
public String getEmployeeCode() {
	return employeeCode;
}
public void setEmployeeCode(String employeeCode) {
	this.employeeCode = employeeCode;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public Time getStartAt() {
	return startAt;
}
public void setStartAt(Time startAt) {
	this.startAt = startAt;
}
public Time getEndAt() {
	return endAt;
}
public void setEndAt(Time endAt) {
	this.endAt = endAt;
}


}

