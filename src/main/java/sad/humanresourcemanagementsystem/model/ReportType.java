package sad.humanresourcemanagementsystem.model;

public class ReportType {
private int id;
private String name;

public ReportType(int id, String name) {
	super();
	this.id = id;
	this.name = name;
	
}

public ReportType(String name) {
	super();
	this.name = name;
	
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



}
