package sad.humanresourcemanagementsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sad.humanresourcemanagementsystem.daoi.AttendanceDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.Attendance;

public class AttendanceDAO implements AttendanceDAOI {
private static final String SQL_GET = "SELECT * FROM attendance WHERE staff_name = ?";
private static final String SQL_UPDATE = "UPDATE attendance SET staff_name = ?, time = ?, working_status = ? where id = ?";
private static final String SQL_INSERT = "INSERT INTO attendance (staff_id, date, working_status, startAt) VALUES(?, ?, ?, ?)";
private static final String SQL_STAFF_ATTENDANCE_BY_DATE = "SELECT employee_code, fullname, name, working_status FROM staff, department, attendance WHERE date = ? and staff.id = attendance.staff_id";
private static final String SQL_UPDATE_ENDING_TIME = "UPDATE attendance SET endAt = ? WHERE staff_id = ? and date = ?";
private static final String SQL_STAFF_ATTENDANCE = "SELECT employee_code, fullname, name, working_status, date FROM staff, department, attendance where staff.id = attendance.staff_id";
	@Override
	public List<Attendance> getAttendanceByStaffName(String staffName) {
		List<Attendance> staffAttendances = new ArrayList<>();
		try(DBConnection dbInstance = DBConnection.getInstance();
			Connection connection = dbInstance.getConnection();) {		
			PreparedStatement ps = connection.prepareStatement(SQL_GET);
			ps.setString(1, staffName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			 int id = rs.getInt("id");
			 Date date = rs.getDate("date");
			 int status = rs.getInt("working_status");
			 Attendance attendance = new Attendance(id, staffName, date, status);
			 staffAttendances.add(attendance);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return staffAttendances;
	}

	@Override
	public boolean updateAttendance(Attendance attendance) {
		boolean isUpdated = false;
		try(DBConnection dbInstance = DBConnection.getInstance();
			Connection connection = dbInstance.getConnection();) {
			PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
			ps.setString(1,  attendance.getStaffName());
			ps.setDate(2,  attendance.getDate());
			ps.setInt(3, attendance.getStatus());
			ps.setInt(4,  attendance.getId());
			isUpdated = ps.executeUpdate() != -1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	public int saveAttendance(Attendance attendance) {
		int rowInserted = 0;
		try(DBConnection dbInstance = DBConnection.getInstance();
			Connection connection = dbInstance.getConnection();) {		
			PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
			ps.setInt(1,  attendance.getStaff().getId());
			ps.setDate(2, attendance.getDate());
			ps.setInt(3, attendance.getStatus());
			ps.setTime(4,  attendance.getStartAt());
			rowInserted = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}
	
	public boolean updateWorkEndingTime(Attendance attendance) {
		boolean isUpdated = false;
		try(DBConnection dbInstance = DBConnection.getInstance();
			Connection connection = dbInstance.getConnection();) {		
			PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_ENDING_TIME);
			ps.setTime(1, attendance.getEndAt());
			ps.setInt(2,  attendance.getStaff().getId());
			ps.setDate(3,  attendance.getDate());
			isUpdated = ps.executeUpdate() != -1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	

	@Override
	public List<Attendance> getStaffAttendanceByDate(Date date) {
		List<Attendance> list = new ArrayList<>();
		try(DBConnection dbInstance = DBConnection.getInstance();
			Connection connection = dbInstance.getConnection();) {
			PreparedStatement ps = connection.prepareStatement(SQL_STAFF_ATTENDANCE_BY_DATE);
			ps.setDate(1, date);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			String employeeCode = rs.getString("employee_code");
			String staffName = rs.getString("fullname");
			String departmentName = rs.getString("name");	 
			 int status = rs.getInt("working_status");
			 Attendance attendance = new Attendance();
			 attendance.setEmployeeCode(employeeCode);
			 attendance.setStaffName(staffName);
			 attendance.setDepartmentName(departmentName);
			 attendance.setStatus(status);
			 attendance.setDate(date);
			 list.add(attendance);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	@Override
	public List<Attendance> getAllStaffAttendance() {
		List<Attendance> list = new ArrayList<>();
		try(DBConnection dbInstance = DBConnection.getInstance();
			Connection connection = dbInstance.getConnection();) {
			PreparedStatement ps = connection.prepareStatement(SQL_STAFF_ATTENDANCE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			String employeeCode = rs.getString("employee_code");
			String staffName = rs.getString("fullname");
			String departmentName = rs.getString("name");	 
			 int status = rs.getInt("working_status");
			 Date date = rs.getDate("date");
			 Attendance attendance = new Attendance();
			 attendance.setEmployeeCode(employeeCode);
			 attendance.setStaffName(staffName);
			 attendance.setDepartmentName(departmentName);
			 attendance.setStatus(status);
			 attendance.setDate(date);
			 list.add(attendance);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	

}
