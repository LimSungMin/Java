package mazi;

public class MaziException extends Exception {
	private String reason;

	public MaziException(String s) {
		reason = s;
	}

	public String toString() {
		return "Exception reason : " + this.reason;
	}
}
