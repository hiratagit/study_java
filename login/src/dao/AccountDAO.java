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

public class AccountDAO {

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public Account findByLogin(Login login) {
		Account account = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				String userId = rs.getNString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getNString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				account = new Account(userId, pass, mail, name, age);
			}

		}catch(SQLException e) {
			e.getStackTrace();
			return null;
		}
		return account;
	}

	public List<Account> findAll() {

		List<Account> accountList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				Account account = new Account(userId, pass, mail, name, age);
				accountList.add(account);
			}


		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}

		return accountList;
	}

	public boolean AccountRegistration(Account account) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO ACCOUNT ( USER_ID, PASS, MAIL, NAME, AGE ) VALUES ( ?, ?, ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getMail());
			pStmt.setString(4, account.getName());
			pStmt.setInt(5, account.getAge());

			int result = pStmt.executeUpdate();

			if(result != 1) { return false; }

		} catch (SQLException e) {
			e.getStackTrace();
			return false;
		}

		return true;
	}

}