package com.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRow {

	public static void main(String[] args) {
		try {
			ConnectMsSQL conn = new ConnectMsSQL();
			Statement stmt = conn.con.createStatement();

	         
	         // after verified the one you want to delete.
	         // enter the Client_Channel_Id ''
	         // uncommented  the delete statement. 
	         // If no more things to delete than insert more entries.
	         
	        stmt.execute("delete from rtnewsprovider.dbo.Client_Channels "
	        		 + "where Client_Channel_Id = 'SKDFRTNWSP15972460700991130'");
	         
			ResultSet rs = stmt.executeQuery
					("select * from rtnewsprovider.dbo.Client_Channels");
		         System.out.println("Client_Channel_Id                  Query");
		         while (rs.next()) {
		            String client_id = rs.getString("Client_Channel_Id");
		            String query = rs.getString("Query");
		            System.out.println(client_id+"        "+query);
		         }	         
	         
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
