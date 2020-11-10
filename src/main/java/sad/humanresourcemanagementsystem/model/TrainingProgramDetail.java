package sad.humanresourcemanagementsystem.model;

public class TrainingProgramDetail {
private int id;
private int trainingProgramId;
private int staffId;
private String staffName;
private TrainingProgram program;
private Staff staff;
private String start;
private String end;
private String supportMoney;
private int status;
private String description;

public TrainingProgramDetail(int id, int staffId, int trainingProgramId,  String staffName, String start, String end, String supportMoney,
		int status, String description) {
	super();
	this.id = id;
	this.trainingProgramId = trainingProgramId;
	this.staffId = staffId;
	this.staffName = staffName;
	this.start = start;
	this.end = end;
	this.supportMoney = supportMoney;
	this.status = status;
	this.description = description;
}

public int getId() {
	return id;
}



public int getTrainingProgramId() {
	return trainingProgramId;
}

public void setTrainingProgramId(int trainingProgramId) {
	this.trainingProgramId = trainingProgramId;
}

public int getStaffId() {
	return staffId;
}

public void setStaffId(int staffId) {
	this.staffId = staffId;
}

public void setId(int id) {
	this.id = id;
}

public TrainingProgram getProgram() {
	return program;
}

public void setProgram(TrainingProgram program) {
	this.program = program;
}

public Staff getStaff() {
	return staff;
}

public void setStaff(Staff staff) {
	this.staff = staff;
}

public String getStart() {
	return start;
}

public void setStart(String start) {
	this.start = start;
}

public String getEnd() {
	return end;
}

public void setEnd(String end) {
	this.end = end;
}


public String getStaffName() {
	return staffName;
}

public void setStaffName(String staffName) {
	this.staffName = staffName;
}

public String getSupportMoney() {
	return supportMoney;
}

public void setSupportMoney(String supportMoney) {
	this.supportMoney = supportMoney;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}




}
