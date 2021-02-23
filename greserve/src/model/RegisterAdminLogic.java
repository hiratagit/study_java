package model;
import dao.AdminDAO;

public class RegisterAdminLogic {

	public boolean execute(Admin admin) {

		AdminDAO dao = new AdminDAO();
		boolean result = dao.AddAdmin(admin);
		return result;

	}
}