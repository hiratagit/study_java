package model;

import dao.UserAccountDAO;

public class RegisterAccountLogic {

	public boolean execute(Account account) {

		UserAccountDAO dao = new UserAccountDAO();

		return dao.createAccount(account);
	}
}