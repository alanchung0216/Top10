package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMsSQL {
	Connection con;
	Statement stmt;
	public ConnectMsSQL() throws SQLException {
		con = DriverManager.getConnection
			("jdbc:sqlserver://10.1.64.236","App_Provider", "1234_abcd");
		stmt = con.createStatement();
	}
}
