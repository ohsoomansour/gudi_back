package kr.happyjob.study.login.model;

import lombok.Data;

/*2024.6.4 osm - lombok 설정 및 수정*/
@Data
public class LgnInfoModel {
	private String loginID;
	private String user_type;
	private String name;
	private String email;
	private String hp;
}
