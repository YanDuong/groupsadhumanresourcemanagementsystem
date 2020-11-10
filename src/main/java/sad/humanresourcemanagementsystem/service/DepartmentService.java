package sad.humanresourcemanagementsystem.service;

import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.DepartmentDAOI;
import sad.humanresourcemanagementsystem.model.Department;

public class DepartmentService {
	private DepartmentDAOI departmentDAOI;
	public DepartmentService() {
		departmentDAOI = DAOFactory.getDepartmentDAO();
	}
	public int insertDepartment(Department department) {
		return departmentDAOI.insertDepartment(department);
	}
	public boolean deleteDepartment(int id) {
		return departmentDAOI.deleteDepartment(id);
	}
	public boolean updateDepartment(Department department) {
		return departmentDAOI.updateDepartment(department);
	}
	public List<Department> getDepartments() {
		return departmentDAOI.getDepartments();
	}
	
	public List<Department> getDepartmentInfoList() {
		return departmentDAOI.getDepartmentInforList();
	}
	
	public int getDepartmentIdByName(String name) {
		return departmentDAOI.getDepartmentIdByName(name);
	}
	
	public boolean updateStaffDepartment(int departmentId, String employeeCode) {
		return departmentDAOI.updateStaffDepartment(departmentId, employeeCode);
	}

	
}
