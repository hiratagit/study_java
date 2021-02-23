package test;

import java.util.List;

import dao.AdminDAO;
import model.Admin;
import model.AdminLoginLogic;
import model.LoginAdmin;


public class AdminDAOTest {

	public static void main(String[] args ){


		testAdminFindByLogin();
		testFindAllAdmin();
	}

	public static void testAdminFindByLogin() {
		LoginAdmin loginAdmin = new LoginAdmin("admin", "1234");
		AdminLoginLogic adminLoginLogic = new AdminLoginLogic();
		boolean result = adminLoginLogic.execute(loginAdmin);

		if(result) {
			System.out.println("testExecute: 成功しました");
		}else {
			System.out.println("testExecute: 失敗しました");
		}
	}

	public static void testFindAllAdmin() {
		AdminDAO dao = new AdminDAO();
		List<Admin> adminList = dao.findAllAdmin();

		for(Admin admin : adminList) {
			System.out.println(admin.getAdminId());
			System.out.println(admin.getName());
			System.out.println("----------------------");

		}
	}
}