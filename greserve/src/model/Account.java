package model;

public class Account {
	private String userId;
	private String pass;
	private String name;
	private String mail;
	private int authority;

	public Account(String userId, String pass, String name, String mail, int authority) {
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.mail = mail;
		this.authority = authority;
	}

	public String getUserId() {
		return this.userId;
	}
	public String getPass() {
		return this.pass;
	}

	public String getName() {
		return this.name;
	}

	public String getMail() {
		return this.mail;
	}

	public int getAuthority() {
		return this.authority;
	}
}