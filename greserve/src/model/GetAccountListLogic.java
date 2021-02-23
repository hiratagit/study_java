package model;
import java.util.ArrayList;
import java.util.List;

import dao.UserAccountDAO;

public class GetAccountListLogic {

	public List<Account> execute() {
		List<Account> accountList = new ArrayList<>();
		UserAccountDAO dao = new UserAccountDAO();
		accountList = dao.findAllAccount();

		return accountList;
	}
}