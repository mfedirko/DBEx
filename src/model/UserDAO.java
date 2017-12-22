package model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	private volatile Connection connection;
	private Statement statement;

	public UserDAO() {
	}

	
	
	public boolean validateLogin(String user,String pass) throws SQLException {
		String query = "SELECT * FROM users WHERE user='" + user + "'"+" AND pass='"+pass+"';";
		ResultSet rs=null;
		boolean res;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();

			rs = statement.executeQuery(query);
			rs.beforeFirst(); // moves to first result
			if (!rs.next()) res=false;
			else res= true;
		}

		finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return (rs == null)?false:res;
	}

}
