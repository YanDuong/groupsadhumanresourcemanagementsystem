package sad.humanresourcemanagementsystem.dao;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import sad.humanresourcemanagementsystem.daoi.ContractTypeDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.ContractType;

public class ContractTypeDAO implements ContractTypeDAOI {
private static final String SQL_NEW_CONTRACTTYPE = "INSERT INTO contracttype (name, fileDirectory, fileName) VALUES (?, ?, ?)";
private static final String SQL_UPDATE_CONTRACTTYPE = "UPDATE contracttype SET name = ?, fileDirectory = ?, fileName = ? WHERE id = ?";
private static final String SQL_REMOVE_CONTRACTTYPE = "DELETE FROM contracttype WHERE id = ?";
private static final String SQL_CONTRACTTYPE_LIST = "SELECT * FROM contracttype";
private static final String SQL_GET_CONTRACTTYPE = "SELECT * FROM contracttype WHERE id = ?";
private static final String SQL_GET_CONTRACTTYPE_ID_BY_NAME = "SELECT id FROM contracttype WHERE name = ?";
private static final String SQL_CHECK_CONTRACTTYPE = "SELECT * FROM contracttype WHERE name = ?";
private static final String SQL_GET_CONTRACTTYPE_DIRECTORY = "SELECT fileDirectory FROM contracttype WHERE  id = ?";
private static final String SQL_GET_FILE_DIRECTORY = "SELECT fileDirectory FROM contracttype WHERE id = ?";
	@Override
	public boolean updateContractType(ContractType type) {
		boolean isUpdated = false;
		removeContractTypeFile(type.getId());
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_CONTRACTTYPE);) {		
				ps.setString(1, type.getName());
				ps.setString(2,  type.getFileLocation());
				ps.setString(3, type.getFileName());
				ps.setInt(4, type.getId());
				isUpdated = ps.executeUpdate() != -1;					
			return isUpdated;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int insertContractType(ContractType type) {
		int row = 0;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_NEW_CONTRACTTYPE);) {		
				ps.setString(1, type.getName());
				ps.setString(2, type.getFileLocation());
				ps.setString(3,  type.getFileName());
				row = ps.executeUpdate();			
			
			return row;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public String getContractTypeDirectory(int id)  {
		String fileDirectory = "";
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_GET_FILE_DIRECTORY);) {
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				fileDirectory = rs.getString("fileDirectory");
			}
			
		} catch(Exception  e) {
			e.printStackTrace();
			return null;
		}
		return fileDirectory;
	}
	

	public boolean removeContractTypeFile(int id) {
		String fileDirectory = getContractTypeDirectory(id);
		File file = new File(fileDirectory);
		if(file.exists()) {
			file.delete();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteContractType(int id) {
		boolean isDeleted = false;
		removeContractTypeFile(id);
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_REMOVE_CONTRACTTYPE);) {				
				ps.setInt(1, id);
				isDeleted = ps.executeUpdate() != -1;			
			
			return isDeleted;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ContractType> getContractTypeList() {
		List<ContractType> list = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_CONTRACTTYPE_LIST)) {				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String fileDirectory = rs.getString("fileDirectory");
					String fileName = rs.getString("fileName");
					list.add(new ContractType(id, name, fileDirectory, fileName));
				}		
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ContractType getContractTypeById(int id) {
		ContractType type = null;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_GET_CONTRACTTYPE)) {	
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {					
					String name = rs.getString("name");
					String fileLocation = rs.getString("fileDirectory");
					String fileName = rs.getString("fileName");
					type = new ContractType(id, name, fileLocation, fileName);
				}		
			return type;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getContractTypeIdByName(String name) {
		int id = 0;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_GET_CONTRACTTYPE_ID_BY_NAME);) {
			ps.setString(1, name);
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
	
	public String getContractTypeFileDirectory(int id) {
		String fileDirectory = "";
		try {
			try(DBConnection dbConnection = DBConnection.getInstance();
					Connection conn = dbConnection.getConnection();
					PreparedStatement ps = conn.prepareStatement(SQL_GET_CONTRACTTYPE_DIRECTORY);) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					fileDirectory = rs.getString("fileDirectory");
				}
				
			} catch(Exception  e) {
				e.printStackTrace();
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return fileDirectory;
	}

	@Override
	public boolean checkContractType(String name) {
		boolean isExisted = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_CHECK_CONTRACTTYPE);) {
			
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
