package sad.humanresourcemanagementsystem.daoi;


import java.util.List;

import sad.humanresourcemanagementsystem.model.ContractType;

public interface ContractTypeDAOI {
	boolean updateContractType(ContractType type);
	int insertContractType(ContractType type);
	boolean deleteContractType(int id);
	List<ContractType> getContractTypeList();
	ContractType getContractTypeById(int id);
	int getContractTypeIdByName(String name);
	String getContractTypeFileDirectory(int id);
	boolean checkContractType(String name);
}
