package sad.humanresourcemanagementsystem.service;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.AuthenticationDAOI;
import sad.humanresourcemanagementsystem.model.Account;

public class AuthenticationService {
	private AuthenticationDAOI authenticationDAOI;
	public AuthenticationService() {
		authenticationDAOI = DAOFactory.getAuthenticationDAO();
	}
	
	public Account getStaffAccount(String username, String password) {
		return authenticationDAOI.getAccount(username, password);
	}
}
