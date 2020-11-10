package sad.humanresourcemanagementsystem.model;

public class ContractType {
private int id;
private String name;
private String fileLocation;
private String fileName;


public ContractType(int id, String name, String fileLocation, String fileName) {
	super();
	this.id = id;
	this.name = name;
	this.fileLocation = fileLocation;
	this.fileName = fileName;
}

public ContractType(String name, String fileLocation, String fileName) {
	super();
	this.name = name;
	this.fileLocation = fileLocation;
	this.fileName = fileName;
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


public String getFileLocation() {
	return fileLocation;
}


public void setFileLocation(String fileLocation) {
	this.fileLocation = fileLocation;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}






}
