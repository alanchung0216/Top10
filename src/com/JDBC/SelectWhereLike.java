package com.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectWhereLike {

	public static void main(String[] args) {
		try {
			ConnectMsSQL conn = new ConnectMsSQL();
			Statement stmt = (Statement) conn.con.createStatement();

			String[] query = 
				{"select * from rtnewsprovider.dbo.Client_Channels "
						+ "where client_channel_id = 'SKDFRTNWSP15972460700991127'",
				 "select * from rtnewsprovider.dbo.Client_Channels "
						 + "where client_channel_id like 'SKD%' and " // % is *
						 + "query like 'la:en%'",
			 	 "select * from rtnewsprovider.dbo.Client_Channels "
			 	 		+ "where client_channel_id like 'SKD_' and " // _ is ?
			 	 		+ "query like 'la:en%'"};			
			for (String q : query){
				ResultSet rs = stmt.executeQuery(q);
				System.out.println("\nClient_Channel_Id                  Query");
				while (rs.next()) {
		            String client_id = rs.getString("Client_Channel_Id");
		            String qry = rs.getString("Query");
		            System.out.println(client_id+"        "+qry);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
