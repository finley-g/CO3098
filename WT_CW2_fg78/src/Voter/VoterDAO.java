package Voter;

public interface VoterDAO {

	public Voter getVoter(String userID, String pword);
	public int insertVoter(Voter v);
}
