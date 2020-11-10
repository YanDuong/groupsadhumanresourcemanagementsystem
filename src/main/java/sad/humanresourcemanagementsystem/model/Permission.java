package sad.humanresourcemanagementsystem.model;

public class Permission {
private int id;
private int staffId;
private String staffName;
private int checkStaffProfile;
private int report;
private int notification;
private int checkAttendance;
private int contract;
private int trainingProgramDetail;
private int trainingProgram;
private int evaluation;
private int statistics;
private int assignPermission;
private int salary;
private int checkRegister;
private int signContract;


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

public int getCheckStaffProfile() {
	return checkStaffProfile;
}
public void setCheckStaffProfile(int checkStaffProfile) {
	this.checkStaffProfile = checkStaffProfile;
}
public int getReport() {
	return report;
}
public void setReport(int report) {
	this.report = report;
}
public int getNotification() {
	return notification;
}
public void setNotification(int notification) {
	this.notification = notification;
}
public int getCheckAttendance() {
	return checkAttendance;
}
public void setCheckAttendance(int checkAttendance) {
	this.checkAttendance = checkAttendance;
}
public int getContract() {
	return contract;
}
public void setContract(int contract) {
	this.contract = contract;
}

public int getTrainingProgramDetail() {
	return trainingProgramDetail;
}
public void setTrainingProgramDetail(int trainingProgramDetail) {
	this.trainingProgramDetail = trainingProgramDetail;
}
public int getEvaluation() {
	return evaluation;
}
public void setEvaluation(int evaluation) {
	this.evaluation = evaluation;
}
public int getAssignPermission() {
	return assignPermission;
}
public void setAssignPermission(int assignPermission) {
	this.assignPermission = assignPermission;
}
public int getTrainingProgram() {
	return trainingProgram;
}
public void setTrainingProgram(int trainingProgram) {
	this.trainingProgram = trainingProgram;
}

public int getStatistics() {
	return statistics;
}
public void setStatistics(int statistics) {
	this.statistics = statistics;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}

public int getCheckRegister() {
	return checkRegister;
}
public void setCheckRegister(int checkRegister) {
	this.checkRegister = checkRegister;
}
public int getSignContract() {
	return signContract;
}
public void setSignContract(int signContract) {
	this.signContract = signContract;
}




}
