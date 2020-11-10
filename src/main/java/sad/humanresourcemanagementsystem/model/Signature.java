package sad.humanresourcemanagementsystem.model;

public class Signature {
private int id;
private String userName;
private String adminSignDirectory;
private String staffSignDirectory;
private int contractId;
private String adminFileName;
private String staffFileName;

public Signature() {
	
}
public Signature(int id, String userName, String adminSignDirectory, String staffSignDirectory, int contractId, String adminFileName, String staffFileName) {
	super();
	this.id = id;
	this.userName = userName;
	this.adminSignDirectory = adminSignDirectory;
	this.staffSignDirectory = staffSignDirectory;
	this.contractId = contractId;
	this.adminFileName = adminFileName;
	this.staffFileName = staffFileName;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getAdminSignDirectory() {
	return adminSignDirectory;
}
public void setAdminSignDirectory(String adminSignDirectory) {
	this.adminSignDirectory = adminSignDirectory;
}
public String getStaffSignDirectory() {
	return staffSignDirectory;
}
public void setStaffSignDirectory(String staffSignDirectory) {
	this.staffSignDirectory = staffSignDirectory;
}
public int getContractId() {
	return contractId;
}
public void setContractId(int contractId) {
	this.contractId = contractId;
}
public String getAdminFileName() {
	return adminFileName;
}
public void setAdminFileName(String adminFileName) {
	this.adminFileName = adminFileName;
}
public String getStaffFileName() {
	return staffFileName;
}
public void setStaffFileName(String staffFileName) {
	this.staffFileName = staffFileName;
}



}
