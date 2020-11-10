package sad.humanresourcemanagementsystem.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sad.humanresourcemanagementsystem.daoi.ContractDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.Contract;
import sad.humanresourcemanagementsystem.model.ContractInfo;
import sad.humanresourcemanagementsystem.model.ContractType;



public class ContractDAO implements ContractDAOI {
private static final String SQL_CONTRACTINFOR_LIST = "SELECT employee_code, contract_id, fullname, name, start, end, salaryhour, basicsalary, adminsign, staffsign, fileLocation FROM contract, contracttype, staff WHERE contract.staff_id = staff.id and contracttype_id = contracttype.id";
private static final String SQL_NEW_CONTRACT = "INSERT INTO contract (staff_id, contracttype_id, fileLocation, salaryhour, start, end, basicsalary, file_name) values (?, ?, ?, ?, ?, ?, ?, ?)";
private static final String SQL_REMOVE_CONTRACT = "DELETE FROM contract WHERE contract_id = ?";
private static final String SQL_EMPLOYEE_CONTRACT_LIST = "SELECT employee_code, fullname, contract_id, name, fileDirectory, fileName, start, end, salaryhour, basicsalary, adminsign, staffsign FROM contract, contracttype, staff WHERE contract.staff_id = staff.id and contracttype_id = contracttype.id";
private static final String SQL_GET_CONTRACT_BY_ID = "SELECT * FROM contract WHERE contract_id = ?";
private static final String SQL_UPDATE_CONTRACT_FILE = "UPDATE contract SET fileLocation = ?, file_name = ? WHERE contract_id = ?";
private static final String SQL_GET_FILE_DIRECTORY = "SELECT fileLocation FROM contract WHERE id = ?";
private static final String SQL_UPDATE_ADMIN_SIGN = "UPDATE contract SET adminsign = ? WHERE contract_id = ?";
	@Override
	public int insertContract(Contract contract) {
		int row = 0;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_NEW_CONTRACT);) {		
				ps.setInt(1, contract.getStaffId());
				ps.setInt(2,  contract.getCtId());
				ps.setString(3, contract.getFileLocation());
				ps.setDouble(4, contract.getSalaryHour());
				ps.setDate(5,  contract.getStartDate());
				ps.setDate(6,  contract.getEndDate());
				ps.setString(7,  contract.getBaseSalary());
				ps.setString(8,  contract.getFileName());
				row = ps.executeUpdate();			
			
			return row;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updateContractStaffSign(int staffSign, int id) {
		return false;
	}

	@Override
	public boolean updateContractName(String name, int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public List<ContractInfo> getContractInforList() {
		List<ContractInfo> list = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_CONTRACTINFOR_LIST);) {			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("contract_id");
				String employeeCode = rs.getString("employee_code");
				String fullname = rs.getString("fullname");
				String name = rs.getString("name");
				Date startDate = rs.getDate("start");
				Date endDate = rs.getDate("end");
				double salaryHour = rs.getDouble("salaryhour");
				String basicSalary = rs.getString("basicsalary");
				int staffSign = rs.getInt("staffsign");
				int adminSign = rs.getInt("adminsign");
				String fileDirectory = rs.getString("fileLocation");
				list.add(new ContractInfo(id, startDate, endDate, basicSalary, salaryHour, adminSign, staffSign, fileDirectory, employeeCode, fullname, name));			
			}
			return list;
		} catch(Exception  e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getContractFileDirectory(int id) {
		String fileDirectory = "";
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_GET_FILE_DIRECTORY);) {
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				fileDirectory = rs.getString("fileLocation");
			}
			
		} catch(Exception  e) {
			e.printStackTrace();
			return null;
		}
		return fileDirectory;
	}
	
	@Override
	public boolean updateAdminSign(int adminSign, int contractId) {
		boolean isUpdated = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_ADMIN_SIGN);) {					
				ps.setInt(1, adminSign);
				ps.setInt(2,  contractId);
				isUpdated = ps.executeUpdate() != -1;					
			return isUpdated;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public boolean removeContractFile(int id) {
		String fileDirectory = getContractFileDirectory(id);
		File file = new File(fileDirectory);
		if(file.exists()) {
			file.delete();
			return true;
		}
		return false;
	}
	@Override
	public boolean removeContract(int id) {
		boolean isDeleted = false;
		removeContractFile(id);
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_REMOVE_CONTRACT);) {
			ps.setInt(1,  id);
			isDeleted = ps.executeUpdate() != -1;
			
		} catch(Exception  e) {
			e.printStackTrace();
			return false;
		}
		return isDeleted;
	}

	@Override
	public List<Contract> getEmployeeContract() {
		List<Contract> list = new ArrayList<>();
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_EMPLOYEE_CONTRACT_LIST);) {			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int contractId = rs.getInt("contract_id");
				String employeeCode = rs.getString("employee_code");
				String fullname = rs.getString("fullname");
				String name = rs.getString("name");
				String fileDirectory = rs.getString("fileDirectory");
				String fileName = rs.getString("fileName");
				Date startDate = rs.getDate("start");
				Date endDate = rs.getDate("end");
				double salaryHour = rs.getDouble("salaryhour");
				String basicSalary = rs.getString("basicsalary");
				int staffSign = rs.getInt("staffsign");
				int adminSign = rs.getInt("adminsign");
				ContractType type = new ContractType(name, fileDirectory, fileName);
				list.add(new Contract(contractId, type, startDate, endDate, adminSign, staffSign, salaryHour, basicSalary, employeeCode, fullname));			
			}
			return list;
		} catch(Exception  e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Contract getContractById(int id) {
		Contract contract = null;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_GET_CONTRACT_BY_ID)) {	
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();			
				while(rs.next()) {	
					int staffId = rs.getInt("staff_id");
					int contracttypeId = rs.getInt("contracttype_id");
					String fileDirectory = rs.getString("fileLocation");
					double hourSalary = rs.getDouble("salaryhour");
					String basicSalary = rs.getString("basicsalary");
					Date startDate = rs.getDate("start");
					Date endDate = rs.getDate("end");
					int adminSign = rs.getInt("adminsign");
					int staffSign = rs.getInt("staffsign");
					int status = rs.getInt("status");
					String fileName = rs.getString("file_name");
					contract = new Contract(id, staffId, contracttypeId, fileDirectory, hourSalary, startDate, endDate, adminSign, staffSign, status, basicSalary, fileName);				
				}		
			return contract;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean insertContractFile(Contract contract) {
		boolean isUpdated = false;
		removeContract(contract.getId());
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_CONTRACT_FILE);) {		
				ps.setString(1, contract.getFileLocation());
				ps.setString(2,  contract.getFileName());
				ps.setInt(3, contract.getId());			
				System.out.println("ID: " + contract.getId());
				isUpdated = ps.executeUpdate() != -1;					
			return isUpdated;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	
}
