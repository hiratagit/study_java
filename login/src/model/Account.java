package model;

public class Account {
	private String userId;
	private String pass;
	private String mail;
	private String name;
	private int age;

	public Account (String userId, String pass, String mail, String name, int age) {
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
		this.age = age;
	}

	public String getUserId() {return this.userId;}
	public String getPass() { return this.pass; }
	public String getMail() { return this.mail; }
	public String getName() { return this.name; }
	public int getAge() { return  this.age; }
}