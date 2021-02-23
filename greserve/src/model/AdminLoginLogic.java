package model;

import dao.AdminDAO;

public class AdminLoginLogic {

	public boolean execute(LoginAdmin loginAdmin) {
		AdminDAO dao = new AdminDAO();
		Admin admin = dao.findByLogin(loginAdmin);
		return admin != null;
	}

}