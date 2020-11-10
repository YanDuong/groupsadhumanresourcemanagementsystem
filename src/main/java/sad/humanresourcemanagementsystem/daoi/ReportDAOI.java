package sad.humanresourcemanagementsystem.daoi;

import java.util.List;

import sad.humanresourcemanagementsystem.model.Report;
import sad.humanresourcemanagementsystem.model.ReportInfo;


public interface ReportDAOI {
int insertReport(Report report);
boolean updateReport(Report report);
boolean updateReportStatus(int status, int id);
boolean updateReportMessage(String message, int id);
boolean updateReportName(String name);
List<Report> getReports();
Report getReportById(int id);
List<ReportInfo> getReportInfoList();
boolean deleteReport(int id);



}
