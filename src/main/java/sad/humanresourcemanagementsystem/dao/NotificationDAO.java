package sad.humanresourcemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sad.humanresourcemanagementsystem.daoi.NotificationDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.Notification;


public class NotificationDAO implements NotificationDAOI {
private static final String SQL_NOTIFICATION_LIST = "SELECT notification_id, title, content, date, sender FROM notification";
private static final String SQL_NOTIFICATION = "SELECT * FROM notification WHERE notification_id = ?";
private static final String SQL_UPDATE_NOTIFICATION = "UPDATE notification SET title = ?, content = ?, date = ? WHERE notification_id = ?";
private static final String SQL_REMOVE_NOTIFICATION = "DELETE FROM notification WHERE notification_id = ?";
private static final String SQL_NEW_NOTIFICATION = "INSERT INTO notification (title, content, date, sender) VALUES(?, ?, ?, ?)";
	@Override
	public int insertNotification(Notification notification) {
		int row = 0;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_NEW_NOTIFICATION);
			ps.setString(1, notification.getTitle());
			ps.setString(2, notification.getContent());
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			ps.setTimestamp(3, date);
			
			ps.setString(4, notification.getStaffName());
			row = ps.executeUpdate();
					
	} catch(Exception e) {
		e.printStackTrace();
		return 0;
	} 
		return row;
	}

	@Override
	public boolean updateNofication(Notification notification) {
		boolean isUpdated = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_NOTIFICATION);
			ps.setString(1, notification.getTitle());
			ps.setString(2, notification.getContent());
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			ps.setTimestamp(3, date);
			ps.setInt(4, notification.getId());		
			isUpdated = ps.executeUpdate() != -1;
			
			
	} catch(Exception e) {
		e.printStackTrace();
		return false;
	} 
		return isUpdated;
	}

	@Override
	public boolean deleteNotification(int id) {
		boolean isDeleted = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_REMOVE_NOTIFICATION);
			ps.setInt(1, id);
			isDeleted = ps.executeUpdate() != -1;
			
	} catch(Exception e) {
		e.printStackTrace();
		return false;
	} 
		return isDeleted;
	}

	@Override
	public List<Notification> getNotifications() {
		List<Notification> list = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_NOTIFICATION_LIST);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("notification_id");
				String title = rs.getString("title");
				String content = rs.getString("content");				
				java.sql.Date date = rs.getDate("date");	
				String sender = rs.getString("sender");
				list.add(new Notification(id, title, content, date, sender));
				
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Notification getNotificationById(int id) {
		Notification notification = null;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_NOTIFICATION);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				String title = rs.getString("title");
				String content = rs.getString("content");			
				java.sql.Date date = rs.getDate("date");
				String sender = rs.getString("sender");
				notification = new Notification(id, title, content, date, sender);
			}
			
			return notification;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
