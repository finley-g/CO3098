package Ballot;

public interface BallotDAO {
	
	public void addOption(String option);
	public void removeOption(String option);
	public void changeQuestion(String question);
}
