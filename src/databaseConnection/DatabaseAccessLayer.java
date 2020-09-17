package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DatabaseAccessLayer {
	
	private String url = "jdbc:sqlserver://localhost:1433;database=SQL-övningar";
	private String user = "user";
	private String password = "1";
	private Connection con;
	
	public ResultSet runSelectQuery(String query) throws SQLException {
		con = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet resultSet = ps.executeQuery();
		return resultSet;
	}
	public int runQuery(String query) throws SQLException {
		con = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = con.prepareStatement(query);
		int amountOfRows = ps.executeUpdate();
		return amountOfRows;
	}
	
	public ResultSet findEmployee(String empID) throws ClassNotFoundException, SQLException{
		String query = "Select * FROM Employee WHERE empID = '" + empID + "'";
		return runSelectQuery(query);
		
	}
	public int editEmployee(String empID, String empName, String empAddress, String empPhoneNumber, int empSalary) throws ClassNotFoundException, SQLException {
		
		String query = "UPDATE Employee SET empName = " + "'" + empName + "'," + 
		"empPhoneNumber = '" + empPhoneNumber + "'," + 
		"empSalary = " + empSalary +
		"WHERE empID = '" + empID +  "'";
		return runQuery(query);
	}
}

