package sad.humanresourcemanagementsystem.model;

public class Evaluation {
private int id;
private Staff staff;
private int staffId;
private String message;
private String date;

public Evaluation(int id, int staffId, String message, String date) {
	super();
	this.id = id;
	this.staffId = staffId;
	this.message = message;
	this.date = date;
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


public Staff getStaff() {
	return staff;
}


public void setStaff(Staff staff) {
	this.staff = staff;
}


public String getMessage() {
	return message;
}


public void setMessage(String message) {
	this.message = message;
}


public String getDate() {
	return date;
}


public void setDate(String date) {
	this.date = date;
}


}
