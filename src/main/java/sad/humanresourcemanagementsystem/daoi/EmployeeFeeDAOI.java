package sad.humanresourcemanagementsystem.daoi;

import java.util.List;

import sad.humanresourcemanagementsystem.model.EmployeeFee;

public interface EmployeeFeeDAOI {
int insert(EmployeeFee fee);
boolean update(EmployeeFee fee);
boolean checkStaffWorkingFee(int staffId);
List<EmployeeFee> getEmployeeFeeList();
EmployeeFee getEmployeeFeeById(int id);
int getStaffWorkingDays(String employeeCode);
List<EmployeeFee> getEmployeeFeeListByMonth(String month);
}
