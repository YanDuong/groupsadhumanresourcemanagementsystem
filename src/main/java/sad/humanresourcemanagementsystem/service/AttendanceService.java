package sad.humanresourcemanagementsystem.service;

import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.AttendanceDAOI;
import sad.humanresourcemanagementsystem.model.Attendance;

public class AttendanceService {
private AttendanceDAOI attendanceDAOI;
public AttendanceService() {
	attendanceDAOI = DAOFactory.getAttendacneDAO();
}
public boolean updateAttendance(Attendance attendance) {
	return attendanceDAOI.updateAttendance(attendance);
}
public List<Attendance> getAttendanceByStaffName(String staffName) {
	return attendanceDAOI.getAttendanceByStaffName(staffName);
}

public List<Attendance> getStaffAttendanceByDate(java.sql.Date date) {
	return attendanceDAOI.getStaffAttendanceByDate(date);
}

public int saveAttedance(Attendance attendance) {
	return attendanceDAOI.saveAttendance(attendance);
}

public boolean updateWorkEndingTime(Attendance attendance) {
	return attendanceDAOI.updateWorkEndingTime(attendance);
}

public List<Attendance> getAllStaffAttendance() {
	return attendanceDAOI.getAllStaffAttendance();
}



}
