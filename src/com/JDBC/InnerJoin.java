package com.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InnerJoin {

	public static void main(String[] args) {
	try {
		ConnectMsSQL conn = new ConnectMsSQL();
		Statement stmt = (Statement) conn.con.createStatement();

		String[] joinquery = 
			{"select * from rtnewsprovider.dbo.Client_Channels C "
					+ "INNER JOIN  rtnewsprovider.dbo.Server_Channels S "
					+ "ON C.Server_Channel_Id = S.Server_Channel_Id ",
			 "select client_channel_id, Server_Channel_Id,Create_Dt from rtnewsprovider.dbo.Client_Channels "
					 + "order by Server_Channel_Id, client_channel_id "};

		for (String q : joinquery){
			ResultSet rs = stmt.executeQuery(q);
			System.out.println("\nClient_Channel_Id                 Server_Channel_Id");
			while (rs.next()) {
	            String client_id = rs.getString("Client_Channel_Id");
	            String server_id = rs.getString("Server_Channel_Id");
	            System.out.println(client_id+"        "+server_id);
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		// TODO Auto-generated method stubenerated method stub

	}

}
