package Commissioner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connector.myConnectorClass;

public class CommDAOImplementer implements CommDAO {
	
	
	static Connection conn;
	static PreparedStatement prepSt;
	
	
	@Override
	public Commissioner getCommissioner(String userid, String pword) {
		
		Commissioner c = new Commissioner();
		
		if(userid!=null && pword!=null) {
			
			try{
				conn = myConnectorClass.getConnection();
				prepSt=conn.prepareStatement("SELECT * FROM VCOMM WHERE USERID=? AND PWORD=?");
				prepSt.setString(1, userid);
				prepSt.setString(2, pword);
				prepSt.executeQuery();
				prepSt.close();
				conn.close();
				ResultSet rs = prepSt.executeQuery();
				
				if(rs.next()) {		
					c.setName(rs.getString(1));
					c.setUserID(rs.getString(2));
					c.setPassword(rs.getString(3));
				
				} else {return null;}
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return c;
	}
}