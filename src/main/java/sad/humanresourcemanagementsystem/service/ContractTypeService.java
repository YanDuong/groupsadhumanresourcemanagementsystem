package sad.humanresourcemanagementsystem.service;


import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.ContractTypeDAOI;
import sad.humanresourcemanagementsystem.model.ContractType;

public class ContractTypeService {
private ContractTypeDAOI ctDAOI;
public ContractTypeService() {
	ctDAOI = DAOFactory.getContractTypeDAO();
}

public boolean updateContractType(ContractType type) {
	return ctDAOI.updateContractType(type);
}
public int insertContractType(ContractType type) {
	return ctDAOI.insertContractType(type);
}
public boolean deleteContractType(int id) {
	return ctDAOI.deleteContractType(id);
}

public List<ContractType> getContractTypeList() {
	return ctDAOI.getContractTypeList();
}

public ContractType getContractTypeById(int id) {
	return ctDAOI.getContractTypeById(id);
}


public int getContractTypeIdByName(String name) {
	return ctDAOI.getContractTypeIdByName(name);
}

public String getContractTypeFileDirectory(int id) {
	return ctDAOI.getContractTypeFileDirectory(id);
}
public boolean checkContracType(String name) {
	return ctDAOI.checkContractType(name);
}

}
