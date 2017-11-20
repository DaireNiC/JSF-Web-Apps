import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
 private DataSource mysqlDS;

 public DAO() throws Exception {
     Context context = new InitialContext();
     String jndiName = "java:comp/env/jdbc/employeesDB14.SQL";
     mysqlDS = (DataSource) context.lookup(jndiName);
 }
}

