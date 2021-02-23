package doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDOA {

	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			String sql = "SELECT ID, NAME, AGE FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

	public boolean remove(String id) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			String sql = "DELET FROM EMPLOYEE WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			int result = pStmt.executeUpdate();

			return result == 1;

		} catch(SQLException e) {
			e.getStackTrace();
			return false;
		}

	}

}