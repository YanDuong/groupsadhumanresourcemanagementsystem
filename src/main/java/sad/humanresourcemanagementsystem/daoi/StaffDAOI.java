package sad.humanresourcemanagementsystem.daoi;

import java.util.List;

import sad.humanresourcemanagementsystem.model.Staff;

public interface StaffDAOI {
	
	Staff getStaffById(int id);
	List<Staff> getStaffByName(String userName);
	List<Staff> getStaffByProfileStatus(int profileStatus);
	List<Staff> getStaffByActivity(int activity);
	List<Staff> getStaffsWithKPI(int month, int year);
	List<Staff> getNoContractStaff();
	List<Staff> getStaffs();
	boolean updateStaff(Staff staff);
	boolean removeStaff(int id);
	int addNewStaff(Staff staff);
	int getStaffIdByName(String staffName);
	boolean checkExistStaff(String employeeCode);
	List<Staff> getStaffWithoutContract();
	List<Staff> getStaffByWorkingStatus(int status);
	List<String> getStaffRoles();

	
	
	
	
}
