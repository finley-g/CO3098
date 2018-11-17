package Voter;

public class Voter {
	
	private static String name;
	private static String userID;
	private static String password;
	private static String bic;
	private static String dob;
	private static String address;
	private static String city;
	private static String state;
	private static String postcode;
	
		
	public String addressToString(String a, String c, String s, String p){
		return a + " " + c + " " + s + " " + p;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String fullname) {
		Voter.name = fullname;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		Voter.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		Voter.password = password;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		Voter.bic = bic;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		Voter.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		Voter.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		Voter.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		Voter.state = state;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		Voter.postcode = postcode;
	}
	
}
