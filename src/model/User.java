package model;
//
public class User {

	private static User instance = new User();
	
	private User() {
		
	}
	
	public static User newInstance() {
		return instance;
	}
	
	private int id;
	private String user;
	private String pass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
