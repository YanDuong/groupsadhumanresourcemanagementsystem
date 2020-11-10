package sad.humanresourcemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sad.humanresourcemanagementsystem.daoi.ReportTypeDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.ReportType;

public class ReportTypeDAO implements ReportTypeDAOI {
private static final String SQL_ALL_REPORTYPE = "SELECT * FROM reporttype";
private static final String SQL_NEW_REPORTTYPE = "INSERT INTO reporttype (name) values (?)";
private static final String SQL_REMOVE_REPORTTYPE = "DELETE FROM reporttype WHERE id = ?";
private static final String SQL_UPDATE_REPORTTYPE = "UPDATE reporttype SET name = ? WHERE id = ?";
private static final String SQL_GET_REPORTTYPE = "SELECT * FROM reporttype WHERE id = ?";
private static final String SQL_CHECK_REPORTTYPE = "SELECT * FROM reporttype WHERE name = ?";
	@Override
	public boolean updateReportType(ReportType type) {
	boolean isUpdated = false;
	
	try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {
		PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_REPORTTYPE);
		ps.setString(1, type.getName());	
		ps.setInt(2, type.getId());
		isUpdated = ps.executeUpdate() != -1;		
} catch(Exception e) {
	e.printStackTrace();
	return false;
} 
	return isUpdated;
	
	}

	@Override
	public int insertReportType(String typeName) {
		int row = 0;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_NEW_REPORTTYPE);
			ps.setString(1, typeName);
			row = ps.executeUpdate();
			
			
	} catch(Exception e) {
		e.printStackTrace();
	} 
		return row;
	}

	@Override
	public boolean deleteReportType(int id) {
		boolean isDeleted = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_REMOVE_REPORTTYPE);
			ps.setInt(1, id);			
			isDeleted = ps.executeUpdate() != -1;
			
			
	} catch(Exception e) {
		e.printStackTrace();
		return false;
	} 
		return isDeleted;
	}

	@Override
	public List<ReportType> getReportTypeList() {
		List<ReportType> list = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_ALL_REPORTYPE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");				
				ReportType type = new ReportType(id, name);
				list.add(type);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ReportType getReportType(int id) {
		ReportType type = null;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_GET_REPORTTYPE);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				String name = rs.getString("name");				
				type = new ReportType(id, name);
			}			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return type;
	}

	@Override
	public boolean checkReportType(String name) {
		boolean isExisted = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_CHECK_REPORTTYPE);) {		
			ps.setString(1,  name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				isExisted = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return isExisted;
	}

}
