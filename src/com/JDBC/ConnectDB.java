package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {

	public static void main(String[] args) {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("class found");
		int no_of_rows = 0;
		try {
			Connection con = DriverManager.getConnection
//				("jdbc:derby://localhost:1527/testDb","username", "password");
			("jdbc:sqlserver://10.1.64.236","App_Provider", "1234_abcd");
/*The JDBC API has 3 Interfaces, 
 * (1. Statement, 2. PreparedStatement, 3. CallableStatement ). 
   The key features of these are as follows: 
   
Statement	
	This interface is used for executing a static SQL statement 
	and returning the results it produces.
	The object of Statement class can be created using 
	Connection.createStatement() method.

PreparedStatement
	A SQL statement is pre-compiled and stored in a PreparedStatement 
	object.
	This object can then be used to efficiently execute this statement 
	multiple times.
	The object of PreparedStatement class can be created using 
	Connection.prepareStatement() method. This extends Statement 
	interface.




CallableStatement
	This interface is used to execute SQL stored procedures.
	This extends PreparedStatement interface.
	The object of CallableStatement class can be created using 
	Connection.prepareCall() method.
*/		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery
				("select client_channel_id from rtnewsprovider.dbo.Client_Channels");
			//("select server_channel_id from rtnewsprovider.dbo.Server_Channels");
			while (rs.next()) {
	        	 no_of_rows++;
	        }
	        System.out.println("There are " + no_of_rows + " record in the table");

	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DriverManager.getConnection success ");	
	}

}
