package sad.humanresourcemanagementsystem.model;

public class Account {
private int id;
private Staff staff;
private String username;
private String password;
private String avatarDir;

public Account(int id, Staff staff, String username, String password) {
	super();
	this.id = id;
	this.staff = staff;
	this.username = username;
	this.password = password;
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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAvatarDir() {
	return avatarDir;
}
public void setAvatarDir(String avatarDir) {
	this.avatarDir = avatarDir;
}

}
