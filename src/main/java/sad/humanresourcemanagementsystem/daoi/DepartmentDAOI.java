package sad.humanresourcemanagementsystem.daoi;

import java.util.List;

import sad.humanresourcemanagementsystem.model.Department;

public interface DepartmentDAOI {
	int insertDepartment(Department department);
	boolean deleteDepartment(int id);
	boolean updateDepartment(Department department);
	List<Department> getDepartments();
	List<Department> getDepartmentInforList();
	Department getDepartmentById(int id);
	int getDepartmentIdByName(String name);
	boolean updateStaffDepartment(int departmentId, String employeeCode);
}
