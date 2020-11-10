package sad.humanresourcemanagementsystem.service;

import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.ReportDAOI;
import sad.humanresourcemanagementsystem.model.Report;
import sad.humanresourcemanagementsystem.model.ReportInfo;

public class ReportService {
	private ReportDAOI reportDAOI;
	public ReportService() {
		reportDAOI = DAOFactory.getReportDAO();
	}
	public int insertReport(Report report) {
		return reportDAOI.insertReport(report);
	}
	public boolean updateReport(Report report) {
		return reportDAOI.updateReport(report);
	}
	public boolean updateReportStatus(int status, int id) {
		return reportDAOI.updateReportStatus(status, id);
	}
	public boolean updateReportMessage(String message, int id) {
		return reportDAOI.updateReportMessage(message, id);
	}
	public boolean updateReportName(String name) {
		return reportDAOI.updateReportName(name);
	}
	public List<Report> getReports() {
		return reportDAOI.getReports();
	}
	public Report getReportById(int id) {
		return reportDAOI.getReportById(id);
	}
	
	public List<ReportInfo> getReportInfoList() {
		return reportDAOI.getReportInfoList();
	}
	
	public boolean removeReport(int id) {
		return reportDAOI.deleteReport(id);
	}
	
}
