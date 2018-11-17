package BIC;

public interface BICDAO {
	public BIC getBIC(String bic, int code);
	public void useBIC(String bic);
}
