package sad.humanresourcemanagementsystem.service;

import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.ContractDAOI;
import sad.humanresourcemanagementsystem.model.Contract;
import sad.humanresourcemanagementsystem.model.ContractInfo;


public class ContractService {
private ContractDAOI contractDAOI;
public ContractService() {
	contractDAOI = DAOFactory.getContractDAO();
}
public int insertContract(Contract contract) {
	return contractDAOI.insertContract(contract);
}
public boolean updateContractStaffSign(int staffSign, int id) {
	return contractDAOI.updateContractStaffSign(staffSign, id);
}
public boolean updateContractName(String name, int id) {
	return contractDAOI.updateContractName(name, id);
}
public List<ContractInfo> getContractInforList() {
	return contractDAOI.getContractInforList();
}

public boolean removeContract(int id) {
	return contractDAOI.removeContract(id);
}
public Contract getContractById(int id) {
	return contractDAOI.getContractById(id);
}

public boolean insertContractFile(Contract contract) {
	return contractDAOI.insertContractFile(contract);
}

public List<Contract> getEmployeeContractList() {
	return contractDAOI.getEmployeeContract();
}

public boolean updateAdminSign(int adminSign, int contractId) {
	return contractDAOI.updateAdminSign(adminSign, contractId);
}

}
