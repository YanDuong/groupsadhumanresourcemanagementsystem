package sad.humanresourcemanagementsystem.service;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.SignatureDAOI;
import sad.humanresourcemanagementsystem.model.Signature;

public class SignatureService {
private SignatureDAOI signatureDAOI;
public SignatureService() {
		signatureDAOI = DAOFactory.getSignatureDAO();
}
public boolean update(Signature signature) {
	return signatureDAOI.updateAdminSignature(signature);
}
public boolean insert(Signature signature) {
	return signatureDAOI.insertAdminSignature(signature);
}
public Signature getSignatureByStaffName(String name) {
	return signatureDAOI.getSignatureByStaffName(name);
}

public Signature getSignatureByContractId(int contractId) {
	return signatureDAOI.getSignatureByContractId(contractId);
}



}
