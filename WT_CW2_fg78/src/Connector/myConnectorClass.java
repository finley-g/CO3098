package Connector;
import java.sql.*;

public class myConnectorClass implements myConnector {
	
	static Connection conn = null;
	
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connectionLink,username,password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
