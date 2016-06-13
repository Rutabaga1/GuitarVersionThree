package main.java.model;

public class User {
	private String userName;
	private String userPassword;
	
	public User(String userName,String userPassword){
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}
	
	public boolean Manager(User user){//不设修改密码和名称的环节，直接限定比较
		if(!user.userName.equals("adminJack"))
		return false;
		if(!user.userPassword.equals("1233210"))
			return false;
		return true;
	}
	
}
