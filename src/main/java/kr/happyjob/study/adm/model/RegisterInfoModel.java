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
}
