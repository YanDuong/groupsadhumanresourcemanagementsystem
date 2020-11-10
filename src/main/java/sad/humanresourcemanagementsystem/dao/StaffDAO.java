package sad.humanresourcemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sad.humanresourcemanagementsystem.Helper.Helper;
import sad.humanresourcemanagementsystem.daoi.StaffDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;

import sad.humanresourcemanagementsystem.model.Staff;

public class StaffDAO implements StaffDAOI {
private static final String SQL_ALL_STAFFS = "SELECT * FROM staff, department WHERE staff.department_id = department.id";
private static final String SQL_REMOVE_STAFF = "DELETE FROM staff WHERE id = ?";
private static final String SQL_NEW_STAFF = "INSERT INTO staff (department_id, role, status, employee_code, fullname, cmnd, sex, email, phone, date_of_birth, address, status_marriage, necessary_contact, activity, profile_status, graduate_institution, major, degree, graduate_year, oversea_education) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
private static final String SQL_GET_STAFF = "SELECT * FROM staff WHERE staff.id = ?";
private static final String SQL_UPDATE_STAFF = "UPDATE staff SET fullname = ?, department_id = ?, role = ?, status = ?, cmnd = ?, sex = ?, email = ?, phone = ?, date_of_birth = ?, address = ?, status_marriage = ?, necessary_contact = ?, activity = ?, profile_status = ?, graduate_institution = ?, major = ?, degree = ?, graduate_year = ?, oversea_education = ? WHERE id = ?;";
private static final String SQL_GET_STAFFS_BY_PROFILE_STATUS = "SELECT fullname, sex, email, phone, date_of_birth, address FROM staff WHERE profile_status = ?";
private static final String SQL_GET_ID_BY_NAME = "SELECT id FROM staff WHERE fullname = ?";
private static final String SQL_CHECK_STAFF = "SELECT * FROM staff WHERE employee_code = ?";
private static final String SQL_GET_STAFFS_WITHOUT_CONTRACT = "SELECT fullname FROM staff WHERE id NOT IN (SELECT staff_id FROM contract)";
private static final String SQL_GET_STAFFS_BY_WORKING_STATUS = "SELECT employee_code, fullname, email, name FROM staff, department WHERE status = ?";
private static final String SQL_GET_STAFFS_BY_NAME = "SELECT * FROM staff, department WHERE staff.department_id = department.id AND fullname LIKE ?";
private static final String SQL_GET_ROLE_LIST = "SELECT DISTINCT role FROM staff";

@Override
public boolean checkExistStaff(String employeeCode) {
	boolean isExisted = false;
	try(DBConnection dbConnection = DBConnection.getInstance();
		Connection conn = dbConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(SQL_CHECK_STAFF);) {		
		ps.setString(1,  employeeCode);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			isExisted = true;
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	return isExisted;
}
	@Override
	public Staff getStaffById(int id) {
		Staff staff = null;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_STAFF);) {			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {			
				String fullname = rs.getString("fullname");
				int departmentId = rs.getInt("department_id");
				String role = rs.getString("role");
				int status = rs.getInt("status");
				String employeeCode = rs.getString("employee_code");	
				String cmnd = rs.getString("cmnd");
				int sex = rs.getInt("sex");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String dateOfBirth = String.valueOf(rs.getDate("date_of_birth"));
				String address = rs.getString("address");			
				int activity = rs.getInt("activity");			
				int profileStatus = rs.getInt("profile_status");
				int marriageStatus = rs.getInt("status_marriage");
				String contact = rs.getString("necessary_contact");
				String graduateInstitution = rs.getString("graduate_institution");
				String major = rs.getString("major");
				String degree = rs.getString("degree");
				String graduateYear = rs.getString("graduate_year");
				String overseaEducation = rs.getString("oversea_education");
			staff = new Staff(id, departmentId, role, status, employeeCode, fullname, cmnd, sex, email, phone, dateOfBirth, address,marriageStatus, contact, activity, profileStatus, graduateInstitution, major ,degree, graduateYear, overseaEducation);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return staff;
	}
	
	@Override
	public List<Staff> getStaffByName(String staffName) {
		List<Staff> staffs = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_STAFFS_BY_NAME);) {	
			ps.setString(1, "%" + staffName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String departmentName = rs.getString("name");
				String role = rs.getString("role");
				int status = rs.getInt("status");
				String employeeCode = rs.getString("employee_code");						
				String fullname = rs.getString("fullname");
				String cmnd = rs.getString("cmnd");
				int sex = rs.getInt("sex");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String dateOfBirth = String.valueOf(rs.getDate("date_of_birth"));
				String address = rs.getString("address");				
				int marriageStatus = rs.getInt("status_marriage");
				String neccessaryContract = rs.getString("necessary_contact");
				int activity = rs.getInt("activity");			
				int profileStatus = rs.getInt("profile_status");
				String graduationInstitution = rs.getString("graduate_institution");
				String major = rs.getString("major");
				String degree = rs.getString("degree");
				String graduateYear = rs.getString("graduate_year");
				String overseaEducation = rs.getString("oversea_education");
			Staff staff = new Staff(id, departmentName, role, status, employeeCode, fullname, cmnd, sex, email, phone, dateOfBirth, address, marriageStatus, neccessaryContract, activity, profileStatus, graduationInstitution, major ,degree, graduateYear, overseaEducation);
				staffs.add(staff);				
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return staffs;
	}

	@Override
	public List<Staff> getStaffByActivity(int activity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> getStaffsWithKPI(int month, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> getNoContractStaff() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<String> getStaffRoles() {
		List<String> roleList = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_GET_ROLE_LIST);) {	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String role = rs.getString("role");
				roleList.add(role);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return roleList;
	}

	@Override
	public List<Staff> getStaffs() {
		List<Staff> staffs = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_ALL_STAFFS);) {			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String departmentName = rs.getString("name");
				String role = rs.getString("role");
				int status = rs.getInt("status");
				String employeeCode = rs.getString("employee_code");						
				String fullname = rs.getString("fullname");
				String cmnd = rs.getString("cmnd");
				int sex = rs.getInt("sex");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String dateOfBirth = String.valueOf(rs.getDate("date_of_birth"));
				String address = rs.getString("address");
				
				int marriageStatus = rs.getInt("status_marriage");
				String neccessaryContract = rs.getString("necessary_contact");
				int activity = rs.getInt("activity");
			
				int profileStatus = rs.getInt("profile_status");
				String graduationInstitution = rs.getString("graduate_institution");
				String major = rs.getString("major");
				String degree = rs.getString("degree");
				String graduateYear = rs.getString("graduate_year");
				String overseaEducation = rs.getString("oversea_education");
			Staff staff = new Staff(id, departmentName, role, status, employeeCode, fullname, cmnd, sex, email, phone, dateOfBirth, address, marriageStatus, neccessaryContract, activity, profileStatus, graduationInstitution, major ,degree, graduateYear, overseaEducation);
				staffs.add(staff);
				
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return staffs;
	}

	@Override
	public boolean updateStaff(Staff staff) {
		boolean isUpdated = false;		
	try(DBConnection dbConnection = DBConnection.getInstance();
		Connection conn = dbConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_STAFF);) {		
		ps.setString(1, staff.getFullName());
		ps.setInt(2, staff.getDepartmentId());
		ps.setString(3, staff.getRole());
		ps.setInt(4, staff.getStatus());
		ps.setString(5, staff.getCmnd());
		ps.setInt(6,  staff.getSex());
		ps.setString(7, staff.getEmail());
		ps.setString(8, staff.getPhone());
		ps.setDate(9, Helper.stringToDate2(staff.getDateOfBirth()));
		ps.setString(10, staff.getAddress());
		ps.setInt(11,  staff.getMarriageStatus());
		ps.setString(12, staff.getContact());
		ps.setInt(13, staff.getActivity());
		ps.setInt(14, staff.getProfileStatus());
		ps.setString(15, staff.getGraduateInstitution());
		ps.setString(16, staff.getMajor());
		ps.setString(17, staff.getDegree());
		ps.setString(18, staff.getGraduateYear());
		ps.setString(19, staff.getOverseaEducation());
		ps.setInt(20, staff.getId());
		isUpdated = ps.executeUpdate() != -1;
		System.out.println(isUpdated);
			
	
	} catch(Exception e) {
		e.printStackTrace();
	}
	return isUpdated;
	}

	@Override
	public List<Staff> getStaffByProfileStatus(int profileStatus) {
		List<Staff> staffs = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_STAFFS_BY_PROFILE_STATUS);) {		
			ps.setInt(1, profileStatus);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {			
				String fullname = rs.getString("fullname");
				int sex = rs.getInt("sex");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String dateOfBirth = String.valueOf(rs.getDate("date_of_birth"));
				String address = rs.getString("address");				
				Staff staff = new Staff(fullname, sex, email, phone, dateOfBirth, address);
				staffs.add(staff);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return staffs;
	}
	
	public boolean removeStaff(int id) {
		boolean isUpdated = false;
	try {
		DBConnection dbConnection = DBConnection.getInstance();
		Connection conn = dbConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(SQL_REMOVE_STAFF);
		ps.setInt(1, id);
		int row = ps.executeUpdate();
		isUpdated = row != -1;
		
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return isUpdated;
	}

	@Override
	public int addNewStaff(Staff staff) {
		int row = 0;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_NEW_STAFF);) {			
			ps.setInt(1, staff.getDepartmentId());
			ps.setString(2,  staff.getRole());
			ps.setInt(3, staff.getStatus());
			ps.setString(4, staff.getEmployeeCode());
			ps.setString(5, staff.getFullName());
			ps.setString(6, staff.getCmnd());
			ps.setInt(7, staff.getSex());
			ps.setString(8, staff.getEmail());
			ps.setString(9, staff.getPhone());			
			ps.setDate(10,  Helper.stringToDate(staff.getDateOfBirth()));
			ps.setString(11, staff.getAddress());
			ps.setInt(12, staff.getMarriageStatus());
			ps.setString(13, staff.getContact());
			ps.setInt(14, staff.getActivity());
			ps.setInt(15, staff.getProfileStatus());
			ps.setString(16,  staff.getGraduateInstitution());
			ps.setString(17,  staff.getMajor());
			ps.setString(18,  staff.getDegree());
			ps.setString(19, staff.getGraduateYear());
			ps.setString(20, staff.getOverseaEducation());
			row = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int getStaffIdByName(String staffName) {
		int id = 0;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_GET_ID_BY_NAME);) {
			ps.setString(1, staffName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			id = rs.getInt("id");						
			}
			return id;
		} catch(Exception  e) {
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	public List<Staff> getStaffWithoutContract() {
		List<Staff> staffs = new ArrayList<>();
		try {
			DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_STAFFS_WITHOUT_CONTRACT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {			
				String fullname = rs.getString("fullname");						
				Staff staff = new Staff();
				staff.setFullName(fullname);
				staffs.add(staff);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return staffs;
	}
	@Override
	public List<Staff> getStaffByWorkingStatus(int status) {
		List<Staff> staffs = new ArrayList<>();
		try {
			DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_STAFFS_BY_WORKING_STATUS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {	
				String employeeCode = rs.getString("employee_code");
				String fullname = rs.getString("fullname");	
				String email = rs.getString("email");
				String name = rs.getString("name");				
				Staff staff = new Staff();
				staff.setEmployeeCode(employeeCode);
				staff.setFullName(fullname);
				staff.setEmail(email);
				staff.setDepartmentName(name);	
				staff.setStatus(status);
				staffs.add(staff);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return staffs;
	}
	
	
	
	
	



}
