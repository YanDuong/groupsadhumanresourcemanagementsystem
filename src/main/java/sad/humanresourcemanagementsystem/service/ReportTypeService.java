package sad.humanresourcemanagementsystem.service;

import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.ReportTypeDAOI;
import sad.humanresourcemanagementsystem.model.ReportType;

public class ReportTypeService {
private ReportTypeDAOI rtDAOI;
public ReportTypeService() {
	rtDAOI = DAOFactory.getReportTypeDAO();
}


public boolean updateReportType(ReportType type) {
	return rtDAOI.updateReportType(type);
}
public int insertReportType(String typeName) {
	return rtDAOI.insertReportType(typeName);
}

public List<ReportType> getReportTypeList() {
	return rtDAOI.getReportTypeList();
}
public boolean deleteReportType(int id) {
	return rtDAOI.deleteReportType(id);
}

public ReportType getReportType(int id) {
	return rtDAOI.getReportType(id);
}

public boolean checkReportType(String name) {
	return rtDAOI.checkReportType(name);
}
}
