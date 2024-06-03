package kr.happyjob.study.login.model;

import lombok.Data;

@Data
public class LgnInfoModel {
	private String loginID;
	private String user_type;
	private String name;
	private String email;
	private String hp;
}
