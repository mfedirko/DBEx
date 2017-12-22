
package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;



public class ConnectionFactory{
	// static reference to itself
	private static ConnectionFactory instance = new ConnectionFactory();
	private static DataSource dataSource;
	InitialContext enc;
	Context context;
	
	public static void setDataSource(DataSource dataSource) {
		ConnectionFactory.dataSource = dataSource;
	}

	/*
	public static final String URL = "jdbc:mysql://localhost/testdb";
	public static final String USER = "testuser";
	public static final String PASSWORD = "password";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
*/
	// private constructor
	private ConnectionFactory() {
		
		try {
			enc=new InitialContext();
	context= (Context) enc.lookup("java:comp/env");
	dataSource=(DataSource) context.lookup("datasource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	private Connection createConnection() {
		Connection connection = null;
		
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		/*
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		*/
			
		
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}
}