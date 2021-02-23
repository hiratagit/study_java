package model;
import dao.UserAccountDAO;
public class LoginLogic {

	public boolean execute(Login login) {
		UserAccountDAO dao = new UserAccountDAO();
		Account account = dao.findByLogin(login);
		return account != null;
	}

}