package sad.humanresourcemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sad.humanresourcemanagementsystem.daoi.AuthenticationDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.Account;
import sad.humanresourcemanagementsystem.model.Staff;

public class AuthenticationDAO implements AuthenticationDAOI {
private static final String SQL_GET_ACCOUNT = "select account_id, staff_id, username, password, avatar, role, fullname from account, staff where username = ? and password = ? and account.staff_id = staff.id";
public Account getAccount(String username, String password) {
	Account account = null;
	try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_ACCOUNT);) {		
			ps.setString(1, username);
			ps.setString(2,  password);			
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				int id = rs.getInt("account_id");
				String role = rs.getString("role");
				String staffName = rs.getString("fullname");
				int staffId = rs.getInt("staff_id");
				Staff staff = new Staff();
				staff.setId(staffId);
				staff.setRole(role);
				staff.setFullName(staffName);
				String name = rs.getString("username");
				String pw = rs.getString("password");
				account = new Account(id, staff, name, pw);
			}
			return account;
	} catch(Exception e) {
		e.printStackTrace();
		return null;
	}
}


	

}
