package sad.humanresourcemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import sad.humanresourcemanagementsystem.daoi.EmployeeFeeDAOI;
import sad.humanresourcemanagementsystem.db.DBConnection;
import sad.humanresourcemanagementsystem.model.EmployeeFee;

public class EmployeeFeeDAO implements EmployeeFeeDAOI {
private static final String SQL_GET_EMPLOYEE_FEE_LIST = "select employee_fee_id, kpi, travel, equipment, bounus, insurrance, other, freetax, employee_code, fullname, basicsalary, salaryhour from employee_fee, staff, contract where employee_fee.staff_id = staff.id and staff.id = contract.staff_id";
private static final String SQL_GET_EMPLOYEE_FEE = "select * from employee_fee where employee_fee_id = ?";
private static final String SQL_UPDATE_EMPLOYEE_FEE = "update employee_fee set kpi = ?, equipment = ?, bounus = ?, inssurance = ?, other = ?, freetax = ? where employee_fee_id = ?";
private static final String SQL_STAFF_WORKING_DAYS = "select count(*), employee_code, startAt, endAt from attendance, staff where working_status = 1 and staff.employee_code = ? and staff.id = attendance.staff_id";
private static final String SQL_GET_EMPLOYEE_FEE_BY_MONTH = "select employee_fee_id, kpi, travel, equipment, bounus, insurrance, other, freetax, employee_code, fullname, basicsalary, salaryhour from employee_fee, staff, contract where  employee_fee.staff_id = staff.id and staff.id = contract.staff_id and month(payday) = ?";
	@Override
	public int insert(EmployeeFee fee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(EmployeeFee fee) {
		boolean isUpdated = false;
		try(DBConnection dbConnection = DBConnection.getInstance();
			Connection conn = dbConnection.getConnection();) {		
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_EMPLOYEE_FEE);
			ps.setString(1,  fee.getKpi());
			ps.setString(2, fee.getEquipment());
			ps.setString(3,  fee.getBonus());
			ps.setString(4, fee.getInssurance());
			ps.setString(5, fee.getOther());
			ps.setString(6,  fee.getTax());
			ps.setInt(7,  fee.getId());
			
			isUpdated = ps.executeUpdate() != -1;
			
			
	} catch(Exception e) {
		e.printStackTrace();
		return false;
	} 
		return isUpdated;
	}

	@Override
	public boolean checkStaffWorkingFee(int staffId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeFee> getEmployeeFeeList() {
		List<EmployeeFee> list = new ArrayList<>();
	try(DBConnection dbConnection = DBConnection.getInstance();
		Connection conn = dbConnection.getConnection();) {
		PreparedStatement ps = conn.prepareStatement(SQL_GET_EMPLOYEE_FEE_LIST);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("employee_fee_id");		
			String employeeCode = rs.getString("employee_code");
			String staffName = rs.getString("fullname");
			String basicSalary = rs.getString("basicsalary");
			double hourSalary = rs.getDouble("salaryhour");
			String kpi = rs.getString("kpi");
			String travel = rs.getString("travel");
			String equipment = rs.getString("equipment");
			String bonus = rs.getString("bounus");
			String inssurance = rs.getString("insurrance");
			String other = rs.getString("other");
			String freetax = rs.getString("freetax");
			EmployeeFee fee = new EmployeeFee(id, employeeCode, staffName, basicSalary, hourSalary, kpi, travel, equipment, bonus, inssurance, other, freetax);
			list.add(fee);
		}
	} catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	return list;
	}
	
	
	@Override
	public EmployeeFee getEmployeeFeeById(int id) {
		EmployeeFee fee = null;
		try(DBConnection dbConnection = DBConnection.getInstance();
				Connection conn = dbConnection.getConnection();) {
				PreparedStatement ps = conn.prepareStatement(SQL_GET_EMPLOYEE_FEE);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {			
					String employeeCode = rs.getString("employee_code");
					String staffName = rs.getString("fullname");
					int workingDays = getStaffWorkingDays(employeeCode);
					Time startAt = rs.getTime("startAt");
					Time endAt = rs.getTime("endAt");
					long otHours = endAt.getTime() - startAt.getTime();
					String basicSalary = rs.getString("basicsalary");
					double hourSalary = rs.getDouble("salaryhour");
					String kpi = rs.getString("kpi");
					String travel = rs.getString("travel");
					String equipment = rs.getString("equipment");
					String bonus = rs.getString("bounus");
					String inssurance = rs.getString("insurrance");
					String other = rs.getString("other");
					String freetax = rs.getString("freetax");
					double totalFee = Double.parseDouble(basicSalary) * workingDays + hourSalary * otHours + Double.parseDouble(travel) 
					+ Double.parseDouble(equipment) + Double.parseDouble(bonus) + Double.parseDouble(inssurance) + Double.parseDouble(other) ;
					fee = new EmployeeFee(id, employeeCode, staffName, workingDays, otHours, basicSalary, hourSalary, kpi, travel, equipment, bonus, inssurance, other, freetax, totalFee);					
				}
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			return fee;
			}
	
	public int getStaffWorkingDays(String employeeCode) {
		int days = 0;
		try(DBConnection dbInstance = DBConnection.getInstance();
			Connection connection = dbInstance.getConnection();) {		
			PreparedStatement ps = connection.prepareStatement(SQL_STAFF_WORKING_DAYS);
			ps.setString(1, employeeCode);		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				days = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return days;
	}
	
	@Override
	public List<EmployeeFee> getEmployeeFeeListByMonth(String month) {
		List<EmployeeFee> list = new ArrayList<>();
	try(DBConnection dbConnection = DBConnection.getInstance();
		Connection conn = dbConnection.getConnection();) {
		PreparedStatement ps = conn.prepareStatement(SQL_GET_EMPLOYEE_FEE_BY_MONTH);
		ps.setString(1, month);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("employee_fee_id");		
			String employeeCode = rs.getString("employee_code");
			String staffName = rs.getString("fullname");
			String basicSalary = rs.getString("basicsalary");
			double hourSalary = rs.getDouble("salaryhour");
			String kpi = rs.getString("kpi");
			String travel = rs.getString("travel");
			String equipment = rs.getString("equipment");
			String bonus = rs.getString("bounus");
			String inssurance = rs.getString("insurrance");
			String other = rs.getString("other");
			String freetax = rs.getString("freetax");
			EmployeeFee fee = new EmployeeFee(id, employeeCode, staffName, basicSalary, hourSalary, kpi, travel, equipment, bonus, inssurance, other, freetax);
			list.add(fee);
		}
	} catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	return list;
	}
	
	
	}
	
	
	

