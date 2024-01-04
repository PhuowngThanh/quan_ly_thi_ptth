package model;

public class user {
	private String email, pass;

	public user(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String toString() {
		return "email=" + email + ", pass=" + pass;
	}

}