package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Login;

public class UserAccountDAO {

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public Account findByLogin(Login login) {

		Account account = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT USER_ID, PASS, NAME, MAIL, AUTHORITY FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,  login.getUserId());
			pStmt.setString(2, login.getPass());

			ResultSet re = pStmt.executeQuery();

			if(re.next()) {

				String userId = re.getString("USER_ID");
				String pass = re.getString("PASS");
				String mail = re.getString("MAIL");
				String name = re.getString("NAME");
				int authority = re.getInt("AUTHORITY");

				account = new Account(userId, pass, name, mail, authority);

			}

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return account;
	}

	public Account getAccount(String loginUserId) {

		Account account = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT USER_ID, PASS, NAME, MAIL, AUTHORITY FROM ACCOUNT WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,  loginUserId);

			ResultSet re = pStmt.executeQuery();

			if(re.next()) {

				String userId = re.getString("USER_ID");
				String pass = re.getString("PASS");
				String mail = re.getString("MAIL");
				String name = re.getString("NAME");
				int authority = re.getInt("AUTHORITY");

				account = new Account(userId, pass, name, mail, authority);

			}

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}

	public boolean createAccount(Account account) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO ACCOUNT ( USER_ID, PASS, NAME, MAIL) VALUES ( ?, ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getName());
			pStmt.setString(4, account.getMail());

			int result = pStmt.executeUpdate();

			if(result != 1) { return false; }

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Account> findAllAccount() {

		List<Account> accountList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT USER_ID, PASS, NAME, MAIL, AUTHORITY FROM ACCOUNT";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet re = pStmt.executeQuery();

			while(re.next()) {
				String adminId = re.getString("USER_ID");
				String pass = re.getString("PASS");
				String name = re.getString("NAME");
				String mail = re.getString("MAIL");
				int authority = re.getInt("AUTHORITY");

				Account account = new Account(adminId, pass, name, mail, authority);
				accountList.add(account);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return accountList;
	}
}
