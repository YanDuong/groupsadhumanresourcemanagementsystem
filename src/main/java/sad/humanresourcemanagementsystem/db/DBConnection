package sad.humanresourcemanagementsystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements AutoCloseable {
	private static String DB_URL = "jdbc:mysql://localhost:3306/humanresourcemanagementsystem?zeroDateTimeBehavior=round&allowPublicKeyRetrieval=true&useSSL=false";
	private static String USER_NAME = "root";
	private static String PASSWORD = "12345678";
	private static DBConnection dbConnection = null;
	private Connection conn = null;
	private DBConnection() {}
	
	public static DBConnection getInstance() {
		if(dbConnection == null) {
			synchronized(DBConnection.class) {
				if(dbConnection == null) {
					dbConnection = new DBConnection();
				}
			}
		}
		return dbConnection;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Connection to database successfully!");
			return conn;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Connection to database failed!");
			return null;
		}
	}
	
	
	
	@Override
	public void close() throws Exception {
		try {
			if(conn != null) {
				this.conn.close();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
