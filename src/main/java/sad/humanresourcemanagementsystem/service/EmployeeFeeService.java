package sad.humanresourcemanagementsystem.service;

import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.EmployeeFeeDAOI;
import sad.humanresourcemanagementsystem.model.EmployeeFee;

public class EmployeeFeeService {
private EmployeeFeeDAOI employeeFeeDAOI;
public EmployeeFeeService() {
	employeeFeeDAOI = DAOFactory.getEmployeeFeeDAO();
}

public int insert(EmployeeFee fee) {
	return employeeFeeDAOI.insert(fee);
}
public boolean update(EmployeeFee fee) {
	return employeeFeeDAOI.update(fee);
}
public boolean checkStaffWorkingFee(int staffId) {
	return employeeFeeDAOI.checkStaffWorkingFee(staffId);
}

public int getStaffWorkingDays(String employeeCode) {
	return employeeFeeDAOI.getStaffWorkingDays(employeeCode);
}

public List<EmployeeFee> getEmployeeFeeList() {
	return employeeFeeDAOI.getEmployeeFeeList();
}
public EmployeeFee getEmployeeFeeById(int id) {
	return employeeFeeDAOI.getEmployeeFeeById(id);
}

public List<EmployeeFee> getEmployeeFeeListByMonth(String month) {
	return employeeFeeDAOI.getEmployeeFeeListByMonth(month);
}
}
