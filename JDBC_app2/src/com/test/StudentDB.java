package com.test;

import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDB {
	
	public static void main(String[] args) throws SQLException {
		
		MysqlDataSource mysqlDS = new MysqlDataSource();
		
		mysqlDS.setURL("jdbc:mysql://localhost:3306/studentdb3");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("");
		
		// Establish connection
		Connection conn = mysqlDS.getConnection();
		
		// Statement Creation
		Statement myStmt = conn.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE, //make obj scrollable
		ResultSet.CONCUR_UPDATABLE); 
		//SQL query
		String query = "select s.student_name as Student,"
				+ " c.course_name as Course,"
				+ " clg.college_name as College,"
				+ " clg.county as County,"
				+ " cnty.main_town as MainTown "
				+ " from student_table s"
				+ " Inner Join course_Table c"
				+ " on s.course_ID = c.course_ID"
				+ " Inner Join college_table clg"
				+ " on c.college_id = clg.college_id"
				+ " Inner Join county_Table cnty"
				+ " on clg.county = cnty.county_name";
		
		// Execute Query
		ResultSet rs = myStmt.executeQuery(query);
		
		while( rs.next() ) {
			
			String s_name = rs.getString("Student");
			String s_course = rs.getString("Course");
			String s_college = rs.getString("College");
			String s_county = rs.getString("County");
			String s_main_town = rs.getString("MainTown");
			System.out.printf("%s, %s, %s, %s, %s\n",s_name, s_course, s_college, s_county, s_main_town );
			//System.out.println("Town = " + sTown);
		}

		
		//Close the connection
		conn.close();
		myStmt.close();
		rs.close();

		
	}

}
