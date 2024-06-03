package kr.happyjob.study.adm.model;

import lombok.Data;

@Data
public class RegisterInfoModel {
	private String loginID ;
	private String user_type;
	private String name;
	private String password;
	private String email;
	private String hp;
    /*
	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return email;
	}

	public void setMail(String email) {
		this.email = email;
	}
    */



}
