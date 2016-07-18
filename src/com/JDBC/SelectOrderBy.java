package com.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectOrderBy {

	public static void main(String[] args) {
		try {
			ConnectMsSQL conn = new ConnectMsSQL();
			Statement stmt = (Statement) conn.con.createStatement();

			String[] query = 
				{"select * from rtnewsprovider.dbo.Client_Channels "
						+ "order by client_channel_id ",
				 "select client_channel_id, query,Create_Dt from rtnewsprovider.dbo.Client_Channels "
						 + "order by query, client_channel_id "};

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
		}		// TODO Auto-generated method stub

	}

}
