package model;

import dao.UserAccountDAO;

public class GetAccountLogic {

	public Account execute(String loginUserId) {

		Account account = null;
		UserAccountDAO dao = new UserAccountDAO();
		account = dao.getAccount(loginUserId);
		return account;
	}
}