package sad.humanresourcemanagementsystem.daoi;

import java.util.List;

import sad.humanresourcemanagementsystem.model.Signature;

public interface SignatureDAOI {
boolean updateAdminSignature(Signature signature);
boolean insertAdminSignature(Signature signature);
Signature getSignatureByStaffName(String name);
Signature getSignatureByContractId(int id);
List<Signature> getSignatureList();

}
