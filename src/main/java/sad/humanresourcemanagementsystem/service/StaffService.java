package sad.humanresourcemanagementsystem.service;

import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.StaffDAOI;
import sad.humanresourcemanagementsystem.model.Staff;

public class StaffService {
private StaffDAOI staffDAOI;
public StaffService() {
	staffDAOI = DAOFactory.getStaffDAO();
}

public List<Staff> getStaffsByProfileStatus(int status) {
	return staffDAOI.getStaffByProfileStatus(status);
	
}
public Staff getStaffById(int id) {
	return staffDAOI.getStaffById(id);
}
public List<Staff> getStaffByActivity(int activity) {
	return staffDAOI.getStaffByActivity(activity);
}
public List<Staff> getStaffsWithKPI(int month, int year) {
	return staffDAOI.getStaffsWithKPI(month, year);
}
public List<Staff> getNoContractStaff() {
	return staffDAOI.getNoContractStaff();
}
public List<Staff> getStaffs() {
	return staffDAOI.getStaffs();
}
public boolean updateStaff(Staff staff) {
	return staffDAOI.updateStaff(staff);
}

public boolean removeStaff(int id) {
	return staffDAOI.removeStaff(id);
}

public int addNewStaff(Staff staff) {
	return staffDAOI.addNewStaff(staff);
}

public int getStaffIdByName(String staffName) {
	return staffDAOI.getStaffIdByName(staffName);
}

public boolean checkExistStaff(String employeeCode) {
	return staffDAOI.checkExistStaff(employeeCode);
}

public List<Staff> getStaffsWithoutContract() {
	return staffDAOI.getStaffWithoutContract();
}

public List<Staff> getStaffByName(String staffName) {
	return staffDAOI.getStaffByName(staffName);
}

public List<String> getStaffRoles() {
	return staffDAOI.getStaffRoles();
}


	
}
