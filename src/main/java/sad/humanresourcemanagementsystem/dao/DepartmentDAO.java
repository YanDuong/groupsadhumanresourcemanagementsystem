package sad.humanresourcemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import sad.humanresourcemanagementsystem.daoi.DepartmentDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.Department;


public class DepartmentDAO implements DepartmentDAOI {
private static final String SQL_GET_DEPARTMENT_STAFF = "SELECT employee_code, fullname, name FROM staff, department WHERE staff.department_id = department.id";
private static final String SQL_GET_DEPARTMENT = "SELECT * FROM department";
private static final String SQL_UPDATE_DEPARTMENT = "UPDATE department SET name = ? WHERE id = ?";
private static final String SQL_DELETE_DEPARTMENT = "DELETE FROM department WHERE id = ?";
private static final String SQL_NEW_DEPARTMENT = "INSERT INTO department (name) values (?)";
private static final String SQL_GET_ID_BY_NAME = "SELECT id FROM department WHERE name = ?";
private static final String SQL_UPDATE_DEPARTMENT_STAFF = "UPDATE staff SET department_id = ? WHERE employee_code = ?";
	@Override
	public int insertDepartment(Department department) {
		int row = 0;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
		PreparedStatement ps = conn.prepareStatement(SQL_NEW_DEPARTMENT);
		ps.setString(1, department.getName());
		row = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public boolean deleteDepartment(int id) {
		boolean isDeleted = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_DEPARTMENT);			
			ps.setInt(1, id);						
			isDeleted = ps.executeUpdate() != -1;		
	} catch(Exception e) {
		e.printStackTrace();
		return false;
	} 
		return isDeleted;
	}

	@Override
	public boolean updateDepartment(Department department) {
		boolean isUpdated = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_DEPARTMENT);
			ps.setString(1, department.getName());
			ps.setInt(2, department.getId());			
			
			isUpdated = ps.executeUpdate() != -1;
			
			
	} catch(Exception e) {
		e.printStackTrace();
		return false;
	} 
		return isUpdated;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> list = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_GET_DEPARTMENT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {	
				int id = rs.getInt("id");
				String departmentName = rs.getString("name");				
				list.add(new Department(id, departmentName));
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Department> getDepartmentInforList() {
		List<Department> list = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_GET_DEPARTMENT_STAFF);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String employeeCode = rs.getString("employee_code");
				String staffName = rs.getString("fullname");
				String departmentName = rs.getString("name");				
				list.add(new Department(id, departmentName, employeeCode, staffName));
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = null;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_GET_DEPARTMENT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {								
				String departmentName = rs.getString("name");				
				department = new Department(id, departmentName);
			}
			return department;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int getDepartmentIdByName(String name) {
		int id = 0;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_GET_ID_BY_NAME);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {								
				id = rs.getInt("id");
			}
			return id;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public boolean updateStaffDepartment(int departmentId, String employeeCode) {
		boolean isUpdated = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_DEPARTMENT_STAFF);
			ps.setInt(1, departmentId);
			ps.setString(2, employeeCode);						
			isUpdated = ps.executeUpdate() != -1;			
	} catch(Exception e) {
		e.printStackTrace();
		return false;
	} 
		return isUpdated;
	}
 
}
