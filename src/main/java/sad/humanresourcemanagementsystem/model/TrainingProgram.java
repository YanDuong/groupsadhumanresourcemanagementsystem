package sad.humanresourcemanagementsystem.model;

public class TrainingProgram {
private int id;
private String name;
private int time;
private String description;
private int status;
public TrainingProgram(int id, String name, int time, String description, int status) {
	super();
	this.id = id;
	this.name = name;
	this.time = time;
	this.description = description;
	this.status = status;
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
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}


}
