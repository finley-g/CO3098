package Voter;
import java.sql.*;

import Connector.myConnectorClass;

public class VoterDAOImplementer implements VoterDAO {

	static Connection conn;
	static PreparedStatement prepSt;
	
	@Override
	public Voter getVoter(String userID, String pword) {
		Voter v = new Voter();
		if(userID!=null && pword!=null) {
		try {
			conn = myConnectorClass.getConnection();
			prepSt=conn.prepareStatement("SELECT * FROM VOTERS WHERE USERID=? AND PWORD=?");
			prepSt.setString(1, userID);
			prepSt.setString(2, pword);
			prepSt.executeQuery();
			prepSt.close();
			conn.close();
			ResultSet rs = prepSt.executeQuery();
			
			if(rs.next()) {
				v.setName(rs.getString(1));
				v.setUserID(rs.getString(2));
				v.setPassword(rs.getString(3));
				v.setBic(rs.getString(4));
				v.setDob(rs.getString(5));
				v.setAddress(rs.getString(6));
				v.setCity(rs.getString(7));
				v.setState(rs.getString(8));
				v.setPostcode(rs.getString(9));
			} else return null;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		}
		
		return v;
	}

	
	@Override
	public int insertVoter(Voter v) {
		int state = 0;
		try{
			
			conn = myConnectorClass.getConnection();
			prepSt=conn.prepareStatement("INSERT INTO `VOTERS` VALUES (?,?,?,?,?,?,?,?,?)");
			prepSt.setString(1, v.getName());
			prepSt.setString(2, v.getUserID());
			prepSt.setString(3, v.getPassword());
			prepSt.setString(4, v.getBic());
			prepSt.setString(5, v.getDob());
			prepSt.setString(6, v.getAddress());
			prepSt.setString(7, v.getCity());
			prepSt.setString(8, v.getState());
			prepSt.setString(9, v.getPostcode());
			state = prepSt.executeUpdate();
			conn.close();
			prepSt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

}
