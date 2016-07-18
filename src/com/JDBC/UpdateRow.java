package com.JDBC;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.Query;

public class UpdateRow {

	public static void main(String[] args) {
		try {
			ConnectMsSQL conn = new ConnectMsSQL();
			Statement stmt = (Statement) conn.con.createStatement();
			/*
			 *
			 ("select client_channel_id from rtnewsprovider.dbo.Client_Channels");
			 ("select * from rtnewsprovider.dbo.Client_Channels");
	         String query1="update emp set name='ravi' where id=2";
	         String query2 = "delete  from emp where id=1";
	         String query3 = "insert into emp values
	         */
			String query1 = "update rtnewsprovider.dbo.Client_Channels " +
	         "set Query='la:en T' " + 
	         "where client_channel_id = 'SKDFRTNWSP15972460700991127'";
			stmt.execute(query1);
			// or you can use commit like this
		    //  conn.con.setAutoCommit(false);
		    //  stmt.execute(query1);
		    //  conn.con.commit();
			
			ResultSet rs = stmt.executeQuery
					("select * from rtnewsprovider.dbo.Client_Channels");
		         System.out.println("Client_Channel_Id                  Query");
		         while (rs.next()) {
		            String client_id = rs.getString("Client_Channel_Id");
		            String query = rs.getString("Query");
		            System.out.println(client_id+"        "+query);
		         }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("update success");
		
	}

}
