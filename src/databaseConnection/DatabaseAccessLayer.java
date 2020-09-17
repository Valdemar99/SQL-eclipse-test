package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccessLayer {
	public ResultSet findEmployee(String empID) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;database=SQL-övningar";
		String user = "user";
		String password = "1";
		
		Connection con = DriverManager.getConnection(url, user, password);
		String query = "Select * FROM Employee WHERE empID = " + "'" + empID + "'";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		con.close();
		return rs;
}

}

