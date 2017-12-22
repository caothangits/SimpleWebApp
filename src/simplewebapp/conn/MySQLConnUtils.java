package simplewebapp.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

	public static Connection getMySQLConnection() 
		throws ClassNotFoundException, SQLException{
		// Chú ý: Thay đổi các thông số kết nối cho phù hợp.
	     String hostName = "localhost";
	     String dbName = "mytest";
	     String userName = "root";
	     String password = "12345";
	     return getMySQLConnection(hostName, dbName, userName, password);
	}
	
	public static Connection getMySQLConnection(String hostName, String dbName, 
			String userName, String password) throws SQLException, ClassNotFoundException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("MySQL JDBC Driver not found !!");            
		}
		System.out.println("MySQL JDBC Driver Registered!");
		
		String connectionURL="jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn=DriverManager.getConnection(connectionURL,userName,password);
		return conn;
	}
}
