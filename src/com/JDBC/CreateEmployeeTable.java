package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateEmployeeTable {

	public static void main(String[] args) {
		Connection con;
		try {
			con = DriverManager.getConnection
				("jdbc:sqlserver://10.1.64.236","App_Provider", "1234_abcd");
//					("select client_channel_id from rtnewsprovider.dbo.Client_Channels");
			Statement stmt = con.createStatement();
			String query = "CREATE TABLE Employees"
					+ "(id INTEGER PRIMARY KEY,"
					+ "first_name CHAR(50),"
					+ "last_name CHAR(75))";
			stmt.execute(query);
			System.out.println("Employee table created");
			String query1 = "ALTER TABLE Employees ADD address CHAR(100) ";
		  String query2 = "ALTER TABLE Employees DROP COLUMN last_name";
		  stmt.execute(query1);
		  stmt.execute(query2);
		  System.out.println("Address column added to the table & last_name column removed from the table");
		  String query3 = "drop table Employees";
		  stmt.execute(query3);
		  System.out.println("Employees table removed");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Employee table failed to create");
		}
	}

}
