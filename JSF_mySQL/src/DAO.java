import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.fabric.xmlrpc.base.Array;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
 
private DataSource mysqlDS;

 public DAO() throws Exception {
     Context context = new InitialContext();
     String jndiName = "java:comp/env/jdbc/employeesdb14";
     mysqlDS = (DataSource) context.lookup(jndiName);
}
 
 
 public void addItem(Product p ) throws SQLException {
	 
	 	//get pid and description 
	 	int prodId = p.getProductID();
	 	
	 	String prodDesc = p.getProductDescription();
		// Establish connection
		Connection conn = mysqlDS.getConnection();
		
		// Statement Creation
		Statement myStmt = conn.createStatement();
					
		//SQL query
		 String query = "insert into product PRODID, DESCRIP"
				+ prodId + prodDesc;
		
		// Execute Query
		myStmt.executeQuery(query);
		
 }
		

public ArrayList<Product> getProducts() throws SQLException {
	
	// Establish connection
	Connection conn = mysqlDS.getConnection();
	
	// Statement Creation
	Statement myStmt = conn.createStatement();
			
	//SQL query
	 String query = "select PRODID, DESCRIP"
			+ " from product";
	
	// Execute Query
	ResultSet rs = myStmt.executeQuery(query);
	ArrayList<Product> productlist = new ArrayList<Product>();
	while( rs.next() ) {
		Product p = new Product();
		p.setProductID(rs.getInt("PRODID"));
		p.setProductDescription( rs.getString("DESCRIP")); 
		productlist.add(p);
	}
	return productlist;
}


}

