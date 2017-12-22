package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDAO {
	private Connection connection;
	private Statement statement;

	public EmployeeDAO() {
	}

	public ArrayList<Employee> getEmployee(String criteria,String value,String incl) throws SQLException {
		String query = "SELECT * FROM employee WHERE "+criteria+"='"+ value + "';";
		String query2 = "SELECT * FROM employee WHERE "+criteria+" LIKE '%"+ value + "%';";
		ArrayList<Employee> res=new ArrayList<>();
		
		ResultSet rs = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
             if (incl=="ok") rs = statement.executeQuery(query2);
             else rs = statement.executeQuery(query);
			// moves to first result
			while (rs.next()) {
		   res.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDouble(4),rs.getInt(5)));
			}

		}

		finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return res;
	}

}
