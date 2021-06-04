package Web.Contex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbContex {
public Connection getConnection() throws SQLException {
	String url = "jdbc:mysql://localhost:3306/ProjectJava";
	String user ="root";
	String password ="dai223";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return  DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
}
}
