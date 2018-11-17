package Ballot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connector.myConnectorClass;

public abstract class BallotDAOImplementer implements BallotDAO {

	static Connection conn;
	static PreparedStatement prepSt;
	
	
	
	public void addOption(String option) {
		
		try{
		conn = myConnectorClass.getConnection(); 
		prepSt = conn.prepareStatement("INSERT INTO BALLOT (REF_ID,OPTION, VOTE_COUNT) VALUES(1,?,0)");
		prepSt.setString(1, option);
		prepSt.executeUpdate();  
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	@Override
	public void removeOption(String option) {
		conn = myConnectorClass.getConnection(); 
		try {
			prepSt = conn.prepareStatement("DELETE * FROM BALLOT WHERE OPTION=?");
			prepSt.setString(1, option);
			prepSt.executeUpdate(); 
			prepSt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void changeQuestion(String question) {
		// TODO Auto-generated method stub

	}

}
