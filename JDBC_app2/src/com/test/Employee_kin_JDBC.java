
package com.test;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Employee_kin_JDBC {
	
	public static void main(String[] args) throws SQLException {
		
		MysqlDataSource mysqlDS = new MysqlDataSource();
		
		mysqlDS.setURL("jdbc:mysql://localhost:3306/employee_kin");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("");
		
		// Establish connection
		Connection conn = mysqlDS.getConnection();
		
		// Statement Creation
		Statement myStmt = conn.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE, //make obj scrollable
		ResultSet.CONCUR_UPDATABLE); 
		//SQL query
		String query = "select e.ename, k.nok_name, s.salary"
				+ " from employee_table e"
				+ " Inner Join next_of_kin_table k"
				+ " on e.NextOfKin = k.NOK_ID"
				+ " Inner Join salary s"
				+ " on e.eid = s.eid";
		
		// Execute Query
		ResultSet rs = myStmt.executeQuery(query);
		
		while( rs.next() ) {
			
			String e_name = rs.getString("ename");
			String e_next_of_kin = rs.getString("NOK_NAME");
			double e_salary = rs.getDouble("salary");
			System.out.printf("%s, %s %.2f\n",e_name, e_next_of_kin, e_salary );
			//System.out.println("Town = " + sTown);
		}

		
		//Close the connection
		conn.close();
		myStmt.close();
		rs.close();

		
	}

}
