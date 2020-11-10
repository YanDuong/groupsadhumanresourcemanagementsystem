package sad.humanresourcemanagementsystem.daoi;

import java.util.List;

import sad.humanresourcemanagementsystem.model.Contract;
import sad.humanresourcemanagementsystem.model.ContractInfo;


public interface ContractDAOI {
int insertContract(Contract contract);
boolean updateContractStaffSign(int staffSign, int id);
boolean updateContractName(String name, int id);
List<ContractInfo> getContractInforList();
boolean removeContract(int id);
List<Contract> getEmployeeContract();
Contract getContractById(int id);
boolean insertContractFile(Contract contract);
boolean updateAdminSign(int adminSign, int contractId);
}
