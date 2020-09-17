package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import databaseConnection.DatabaseAccessLayer;

public class Test {

	public static void main(String[] args) {
		DatabaseAccessLayer access = new DatabaseAccessLayer();
		try {
			ResultSet rs = access.findEmployee("E2");
			System.out.println("ID \tName \tAddress Phone   Salary");
			while(rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(access.editEmployee("E1", "Jo", "Örtofta", "1223", 13500) + " row(s) affected.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
