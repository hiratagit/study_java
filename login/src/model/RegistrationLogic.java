package model;

import dao.AccountDAO;
public class RegistrationLogic {

	public void execute(Account account) {
		AccountDAO dao = new AccountDAO();
		dao.AccountRegistration(account);
	}
}