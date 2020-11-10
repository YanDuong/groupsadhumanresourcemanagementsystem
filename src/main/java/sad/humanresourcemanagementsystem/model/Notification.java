package sad.humanresourcemanagementsystem.model;
import java.sql.Date;
public class Notification {
private int id;
private Staff staff;
private int staffId;
private String title;
private String content;
private Date date;
private String staffName;

public Notification(int id, String title, String content, Date date, String staffName) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.date = date;	
	this.staffName = staffName;
}

public Notification(int id, String title, String content, Date date) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.date = date;
	
}

public Notification(String title, String content, String staffName) {
	super();	
	this.title = title;
	this.content = content;
	this.staffName = staffName;
}

public Notification(int id, String title, String content) {
	super();	
	this.id = id;
	this.title = title;
	this.content = content;	
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


public String getStaffName() {
	return staffName;
}
public void setStaffName(String staffName) {
	this.staffName = staffName;
}
public Staff getStaff() {
	return staff;
}
public void setStaff(Staff staff) {
	this.staff = staff;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}



}
