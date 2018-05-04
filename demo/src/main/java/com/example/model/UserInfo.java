package com.example.model;

public class UserInfo {
	public UserInfo()
	{}
	public UserInfo(long id, String loginName, String password, String name)
	{
		this.id = id;
		this.loginname = loginName;
		this.password = password;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private long id;

	private String loginname;

	private String password; // 加密

	private String name;

}
