package com.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayTableContent {

	public static void main(String[] args) {
		try {
			ConnectMsSQL conn = new ConnectMsSQL();
			Statement stmt = conn.con.createStatement();
			ResultSet rs = stmt.executeQuery
//				("select client_channel_id from rtnewsprovider.dbo.Client_Channels");
				("select * from rtnewsprovider.dbo.Client_Channels");
	         System.out.println("Client_Channel_Id                  Query");
	         while (rs.next()) {
	            String client_id = rs.getString("Client_Channel_Id");
	            String query = rs.getString("Query");
	            System.out.println(client_id+"        "+query);
	            //System.out.println(client_id+"              ");
	         }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
