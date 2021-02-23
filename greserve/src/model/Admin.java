package model;

public class Admin {
	private String adminId;
	private String pass;
	private String name;
	private int authority;

	public Admin(String adminId, String pass, String name, int authority) {
		this.adminId = adminId;
		this.pass = pass;
		this.name = name;
		this.authority = authority;
	}

	public String getAdminId() {
		return this.adminId;
	}
	public String getPass() {
		return this.pass;
	}

	public String getName() {
		return this.name;
	}

	public int getAuthority() {
		return this.authority;
	}
}