package sad.humanresourcemanagementsystem.daoi;

import java.util.List;

import sad.humanresourcemanagementsystem.model.ReportType;

public interface ReportTypeDAOI {
boolean updateReportType(ReportType type);
int insertReportType(String name);
boolean deleteReportType(int id);
List<ReportType> getReportTypeList();
ReportType getReportType(int id);
boolean checkReportType(String name);
}
