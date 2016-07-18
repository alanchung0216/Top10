package com.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRow {

	public static void main(String[] args) {
		ConnectMsSQL conn;
		try {
			conn = new ConnectMsSQL();
		
			Statement stmt = (Statement) conn.con.createStatement();
			String insertquery = 
					"insert into rtnewsprovider.dbo.Client_Channels "
					+ "values('SKDFRTNWSP15972460700991144','DJ_TEST','','la:en GOOG'"
					+ ",'','','','','','','SVRSKDFRTNWSP21637488742359327','','') ";	
			stmt.execute(insertquery);
			PreparedStatement updateemp = conn.con.prepareStatement
					("insert into rtnewsprovider.dbo.Client_Channels values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");	
	
			updateemp.setString(1,"SKDFRTNWSP15972460700991149");
			updateemp.setString(2, "DJ_ALAN");
			updateemp.setString(3, "");
			updateemp.setString(4, "");
			updateemp.setString(5, "");
			updateemp.setString(6, "");
			updateemp.setString(7, "");
			updateemp.setString(8, "");
			updateemp.setString(9, "");
			updateemp.setString(10, "");
			updateemp.setString(11, "SVRSKDFRTNWSP21637475471742327");
			updateemp.setString(12, "");
			updateemp.setString(13, "");

			updateemp.executeUpdate();
		  
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
	}

}
