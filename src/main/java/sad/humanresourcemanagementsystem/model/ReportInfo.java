package sad.humanresourcemanagementsystem.model;



public class ReportInfo
 {
private int reportId;
private String reportTitle;
private String content;
private String reporter;
private String typeName;
private int status;
private String date;
public ReportInfo(int reportId, String reportTitle, String content, String reporter, String typeName, int status, String date) {
	super();
	this.reportId = reportId;
	this.reportTitle = reportTitle;
	this.content = content;
	this.reporter = reporter;
	this.typeName = typeName;
	this.status = status;
	this.date = date;
}

public ReportInfo(int reportId, String reportTitle, String reporter, String typeName, int status, String date) {
	super();
	this.reportId = reportId;
	this.reportTitle = reportTitle;
	
	this.reporter = reporter;
	this.typeName = typeName;
	this.status = status;
	this.date = date;
}

public ReportInfo( String reportTitle, String content, String reporter, String typeName, int status, String date) {
	super();
	this.reportTitle = reportTitle;
	this.typeName = typeName;
	this.content = content;
	this.reporter = reporter;
	this.status = status;
	this.date = date;
}


public int getReportId() {
	return reportId;
}
public void setReportId(int reportId) {
	this.reportId = reportId;
}
public String getReportTitle() {
	return reportTitle;
}
public void setReportTitle(String reportTitle) {
	this.reportTitle = reportTitle;
}


public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getReporter() {
	return reporter;
}

public void setReporter(String reporter) {
	this.reporter = reporter;
}

public String getTypeName() {
	return typeName;
}
public void setTypeName(String typeName) {
	this.typeName = typeName;
}


public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}



}
