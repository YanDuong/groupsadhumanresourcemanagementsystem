package sad.humanresourcemanagementsystem.daoi;

import java.sql.Date;
import java.util.List;

import sad.humanresourcemanagementsystem.model.Attendance;

public interface AttendanceDAOI {
boolean updateAttendance(Attendance attendance);
List<Attendance> getAttendanceByStaffName(String staffName);
List<Attendance> getStaffAttendanceByDate(Date date);
int saveAttendance(Attendance attendance);
boolean updateWorkEndingTime(Attendance attendance);
List<Attendance> getAllStaffAttendance();
}
