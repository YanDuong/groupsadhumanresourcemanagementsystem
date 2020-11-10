package sad.humanresourcemanagementsystem.model;

public class Report {
private int id;
private int staffId;
private int rtId;
private String title;
private String content;
private String file;
private String date;
private String message;
private int status;
private String reporter;

public Report(int id, int staffId, String title, String content, String file, int rtId, int status, String date,
	 String message) {
	super();
	this.id = id;
	this.rtId = rtId;
	this.title = title;
	this.content = content;
	this.file = file;
	this.rtId = rtId;
	this.date = date;
	this.message = message;
	this.status = status;
}


public Report(int staffId, String title, String content, String file,int rtId, int status, String date, String message) {
	super();
	this.staffId = staffId;
	this.title = title;
	this.content = content;
	this.file = file;
	this.date = date;	
	this.message = message;
}




public Report(int id, String title, String content, String date, int status, String reporter, String message) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.date = date;
	this.status = status;
	this.reporter = reporter;
	this.message = message;
}


public Report(int id, String message, int status) {
	super();
	this.id = id;
	this.message = message;
	this.status = status;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getRtId() {
	return rtId;
}


public void setRtId(int rtId) {
	this.rtId = rtId;
}


public int getStaffId() {
	return staffId;
}


public void setStaffId(int staffId) {
	this.staffId = staffId;
}



public String getFile() {
	return file;
}


public void setFile(String file) {
	this.file = file;
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


public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}


public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}




public String getReporter() {
	return reporter;
}


public void setReporter(String reporter) {
	this.reporter = reporter;
}


public int getStatus() {
	return status;
}


public void setStatus(int status) {
	this.status = status;
}






}
