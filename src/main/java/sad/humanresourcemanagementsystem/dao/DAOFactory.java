package sad.humanresourcemanagementsystem.dao;
import sad.humanresourcemanagementsystem.daoi.*;

public class DAOFactory {
	public static StaffDAOI getStaffDAO() {
		return new StaffDAO();
	}
	
	public static DepartmentDAOI getDepartmentDAO() {
	return new DepartmentDAO();	
	}
	
	public static EvaluationDAOI getEvalutionDAO() {
		return new EvaluationDAO();
	}
	
	public static NotificationDAOI getNotificationDAO() {
		return new NotificationDAO();
	}
	
	public static PermissionDAOI getPermissionDAO() {
		return new PermissionDAO();
	}
	
	public static ReportDAOI getReportDAO() {
		return new ReportDAO();
	}
	
	public static ReportTypeDAOI getReportTypeDAO() {
		return new ReportTypeDAO();
	}
	
	public static EmployeeFeeDAOI getEmployeeFeeDAO() {
		return new EmployeeFeeDAO();
	}
	
	public static SignatureDAOI getSignatureDAO() {
		return new SignatureDAO();
	}
	
	public static TrainingProgramDAOI getTrainingProgramDAO() {
		return new TrainingProgramDAO();
	}
	
	public static ContractDAOI getContractDAO() {
		return new ContractDAO();
	}
	
	public static ContractTypeDAOI getContractTypeDAO() {
		return new ContractTypeDAO();
	}
	
	public static AttendanceDAOI getAttendacneDAO() {
		return new AttendanceDAO();
	}
	
	public static AuthenticationDAOI getAuthenticationDAO() {
		return new AuthenticationDAO();
	}
	
	
}
