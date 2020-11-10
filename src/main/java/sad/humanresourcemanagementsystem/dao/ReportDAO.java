package sad.humanresourcemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sad.humanresourcemanagementsystem.daoi.ReportDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.Report;
import sad.humanresourcemanagementsystem.model.ReportInfo;


public class ReportDAO implements ReportDAOI {
private static final String SQL_GET_REPORT_INFOR = "SELECT fullname, report_id, staff_id, rt_id, date, title, message, name, report_status FROM report, reporttype, staff WHERE reporttype.id = report.rt_id and report.staff_id = staff.id ORDER BY report_status";
private static final String SQL_GET_REPORT = "SELECT report_id, staff_id, id, title, content, date, report_status, message, fullname FROM report, staff WHERE report.staff_id = staff.id and report_id = ?";
private static final String SQL_UPDATE_REPORT = "UPDATE report SET message = ?, report_status = ? WHERE report_id = ?";
private static final String SQL_UPDATE_REPORT_MESSAGE = "UPDATE report SET message = ? WHERE report_id = ?";
	@Override
	public int insertReport(Report report) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateReport(Report report) {
		boolean isUpdated = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {	
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_REPORT);
			ps.setString(1, report.getMessage());
			ps.setInt(2, report.getStatus());
			ps.setInt(3, report.getId());
			int row =  ps.executeUpdate();
			isUpdated = row != -1;		
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return isUpdated;
	}

	@Override
	public boolean updateReportStatus(int status, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReportMessage(String message, int id) {
		boolean isUpdated = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_REPORT_MESSAGE);
			ps.setString(1, message);
			ps.setInt(2, id);		
			int row =  ps.executeUpdate();
			isUpdated = row != -1;		
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return isUpdated;
	}

	@Override
	public List<Report> getReports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report getReportById(int id) {
	Report report = null;	
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(SQL_GET_REPORT);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {			
				String reporter = rs.getString("fullname");
				String title = rs.getString("title");
				String content = rs.getString("content");				
				int status = rs.getInt("report_status");
				String date = String.valueOf(rs.getDate("date"));
				String message = rs.getString("message");
				report = new Report(id, title, content, date, status, reporter, message);				
			} 
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
			return report;
	}
	
	
	

	@Override
	public boolean updateReportName(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteReport(int id) {
		boolean isDeleted = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_GET_REPORT_INFOR);
			int row =  ps.executeUpdate();
			isDeleted = row != -1;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return isDeleted;
	}
	
	public List<ReportInfo> getReportInfoList() {
		List<ReportInfo> list = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_GET_REPORT_INFOR);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("report_id");
				String title = rs.getString("title");
				String reporter = rs.getString("fullname");
				String typeName = rs.getString("name");
				int status = rs.getInt("report_status");
				String date = String.valueOf(rs.getDate("date"));
				ReportInfo info = new ReportInfo(id, title,  reporter, typeName, status, date);
				list.add(info);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}


	

	

}
