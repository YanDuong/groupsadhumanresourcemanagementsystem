package sad.humanresourcemanagementsystem.daoi;

import sad.humanresourcemanagementsystem.model.Account;

public interface AuthenticationDAOI {
Account getAccount(String username, String password);

}
