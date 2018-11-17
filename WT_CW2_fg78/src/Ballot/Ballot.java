package Ballot;

public class Ballot {

	public String Question;
	public StringBuilder Options;
	
	
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public StringBuilder getOptions() {
		return Options;
	}
	public void setOptions(StringBuilder options) {
		Options = options;
	}	
}