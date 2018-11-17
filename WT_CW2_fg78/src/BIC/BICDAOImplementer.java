package BIC;
import Connector.myConnectorClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BICDAOImplementer implements BICDAO{

	static Connection conn;
	static PreparedStatement prepSt;
	@Override
	public BIC getBIC(String bic, int usedValue) {
		BIC b = new BIC();
		
		try{
			conn = myConnectorClass.getConnection();
			prepSt=conn.prepareStatement("SELECT * from BIC_RECORD WHERE USED="+ usedValue + " AND BIC='" + bic+"'");
			ResultSet rs = prepSt.executeQuery();
			
			if(rs.next()) {
			b.setCode(rs.getString(1));
			b.setUsedValue(rs.getInt(2));
			rs.close();
			prepSt.close();
			} else return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}


	@Override
	public void useBIC(String bic) {
		
		conn = myConnectorClass.getConnection();
		try {
			prepSt=conn.prepareStatement("UPDATE BIC_RECORD SET USED=1 WHERE BIC='" + bic +"'");
			prepSt.executeUpdate();
			prepSt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
