import java.util.List;

import doa.EmployeeDOA;
import model.Employee;

public class SelectEmployeeSample {

	public static void main(String[] args) {

		EmployeeDOA empDAO = new EmployeeDOA();
		List<Employee> empList = empDAO.findAll();

		for(Employee emp : empList) {
			System.out.println("");
			System.out.println("ID: " + emp.getId());
			System.out.println("Name: " + emp.getName());
			System.out.println("Age: " + emp.getAge());
		}

	}

}