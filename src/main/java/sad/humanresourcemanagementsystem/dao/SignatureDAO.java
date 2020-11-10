package sad.humanresourcemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import sad.humanresourcemanagementsystem.daoi.SignatureDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.Signature;

public class SignatureDAO implements SignatureDAOI {
private static final String SQL_UPDATE_ADMIN_SIGN = "UPDATE signature SET adminsign = ?, admin_filename = ?  WHERE contract_id = ?";
private static final String SQL_GET_SIGNATURE = "SELECT * FROM signature WHERE contract_id = ?";
private static final String SQL_INSERT_ADMIN_SIGN = "insert into signature(staff_name, adminsign, contract_id, admin_filename) values(?, ?, ?, ?)";

	@Override
	public boolean updateAdminSignature(Signature signature) {
		boolean isUpdated = false;
		
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_ADMIN_SIGN);) {		
				ps.setString(1, signature.getAdminSignDirectory());	
				ps.setString(2, signature.getAdminFileName());
				ps.setInt(3, signature.getContractId());				
				isUpdated = ps.executeUpdate() != -1;					
			return isUpdated;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insertAdminSignature(Signature signature) {
		boolean isInserted = false;
		
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT_ADMIN_SIGN);) {		
				ps.setString(1,  signature.getUserName());
				ps.setString(2,  signature.getAdminSignDirectory());				
				ps.setInt(3,  signature.getContractId());
				ps.setString(4, signature.getAdminFileName());				
				isInserted = ps.executeUpdate() != -1;					
			return isInserted;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Signature getSignatureByStaffName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Signature getSignatureByContractId(int contractId) {
		Signature signature = null;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();) {			
			PreparedStatement ps = conn.prepareStatement(SQL_GET_SIGNATURE);
			ps.setInt(1, contractId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {	
				int id = rs.getInt("id");
				String staffName = rs.getString("staff_name");
				String adminSignDir = rs.getString("adminsign");
				String staffSignDir = rs.getString("staffsign");				
				String adminFileName = rs.getString("admin_filename");
				String staffFileName = rs.getString("staff_filename");
				signature = new Signature(id, staffName, adminSignDir, staffSignDir, contractId, adminFileName, staffFileName);				
			} 
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
			return signature;
	}

	@Override
	public List<Signature> getSignatureList() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
