import java.sql.SQLException;
import model.*;
import controller.*;
public class Main {
	public static void main(String[] args) throws SQLException {
		EmployeeDAO edao = new EmployeeDAO();
		UserDAO udao=new UserDAO();
		int id = 2;
		
		try {
			System.out.println(udao.validateLogin("me12", "password"));
			Employee e = edao.getEmployee(id);
			System.out.println("Name: " + e.getEmpName());

			System.out.println("Dept: " + e.getDeptId());

			System.out.println("ID: " + e.getEmpId());

			System.out.println("Salari: " + e.getSalary());

			System.out.println("DOB: " + e.getDob());
		} catch (java.lang.NullPointerException e) {
			System.out.println("Employee not found with ID " + id);

		}

	}
}
