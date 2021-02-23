package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.LoginAdmin;

public class AdminDAO {

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public Admin findByLogin(LoginAdmin loginAdmin) {

		Admin admin = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT ADMIN_ID, PASS, NAME, AUTHORITY FROM ADMIN WHERE ADMIN_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,  loginAdmin.getAdminId());
			pStmt.setString(2, loginAdmin.getPass());

			ResultSet re = pStmt.executeQuery();

			if(re.next()) {

				String adminId = re.getString("ADMIN_ID");
				String pass = re.getString("PASS");
				String name = re.getString("NAME");
				int authority = re.getInt("AUTHORITY");

				admin = new Admin(adminId, pass, name, authority);

			}

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return admin;
	}

	public boolean AddAdmin(Admin admin) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO ADMIN (ADMIN_ID, PASS, NAME, AUTHORITY) VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, admin.getAdminId());
			pStmt.setString(2, admin.getPass());
			pStmt.setString(3, admin.getName());
			   pStmt.setInt(4, admin.getAuthority());

			int result = pStmt.executeUpdate();

			if(result != 1) { return false; }

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Admin> findAllAdmin() {

		List<Admin> adminList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT ADMIN_ID, PASS, NAME, AUTHORITY FROM ADMIN";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet re = pStmt.executeQuery();

			while(re.next()) {
				String adminId = re.getString("ADMIN_ID");
				String pass = re.getString("PASS");
				String name = re.getString("NAME");
				int authority = re.getInt("AUTHORITY");

				Admin admin = new Admin(adminId, pass, name, authority);
				adminList.add(admin);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return adminList;
	}


}
