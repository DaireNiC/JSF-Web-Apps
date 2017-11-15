package com.test;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Class {
	
	public static void main(String[] args) throws SQLException {
		
		MysqlDataSource mysqlDS = new MysqlDataSource();
		
		mysqlDS.setURL("jdbc:mysql://localhost:3306/superheroes");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("");
		
		// Establish connection
		Connection conn = mysqlDS.getConnection();
		
		// Statement Creation
		Statement myStmt = conn.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE, //make obj scrollable
		ResultSet.CONCUR_UPDATABLE); 
		//SQL query
		String query = "select * from superhero_table";
		
		// Execute Query
		ResultSet rs = myStmt.executeQuery(query);
		
		while( rs.next() ) {
			
			String s_name = rs.getString("name");
			String s_real_firstname = rs.getString("real_first_name");
			String s_real_surname = rs.getString("real_surname");
			String s_dob = rs.getString("dob");
			double s_power = rs.getDouble("powers");
			System.out.printf("%s, %s %s, %s, %.2f\n",s_name, s_real_firstname, s_real_surname,s_dob, s_power );
			//System.out.println("Town = " + sTown);
		}

		
		//Close the connection
		conn.close();
		myStmt.close();
		rs.close();

		
	}

}
