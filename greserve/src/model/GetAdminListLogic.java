package model;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDAO;

public class GetAdminListLogic {

	public List<Admin> execute() {
		List<Admin> adminList = new ArrayList<>();
		AdminDAO dao = new AdminDAO();
		adminList = dao.findAllAdmin();

		return adminList;
	}
}