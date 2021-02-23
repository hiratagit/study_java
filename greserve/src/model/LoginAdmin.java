package model;

public class LoginAdmin {

	private String adminId;
	private String pass;

	public LoginAdmin(String adminId, String pass) {
		this.adminId = adminId;
		this.pass = pass;
	}

	public String getAdminId() {
		return this.adminId;
	}

	public String getPass() {
		return this.pass;
	}

}