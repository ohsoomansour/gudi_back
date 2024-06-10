package kr.happyjob.study.adm.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.adm.model.RegisterInfoModel;
import kr.happyjob.study.adm.model.RegisterListControlModel;

public interface peopleMngService {
	/* 2024.5.29 ~ 6.4 변경 (수)*/
	//회원 전체 : osooman 변경 
	List<RegisterInfoModel> getAllUsersInfo();
	//회원 유형별 회원 조회 
	List<RegisterInfoModel> doGetUsersByUsertype(Map<String, Object> paramMap);
	//회원 업데이트
	List<RegisterInfoModel> doSearchForUser(Map<String, Object> paramMap);
	/*2024.6.4*/
	void doUpdateUserInfo(Map<String, Object> paramMap);
	//회원 
	
	
	
/* 공통 */
	
	public int ban_user(Map<String,Object> paramMap);
	 
	public int register(Map<String, Object> paramMap);

	public RegisterInfoModel user_info(Map<String,Object> paramMap);
	
	/* 학생 */
	
	public List<RegisterListControlModel> lec_list(Map<String, Object> paramMap);
	
	public int countList_lec(Map<String,Object> paramMap);
	
	public List<RegisterInfoModel> std_list(Map<String,Object> paramMap);
	
	public List<Integer> countList_std(Map<String,Object> paramMap);
	
	public List<RegisterListControlModel> std_lec_info(Map<String,Object> paramMap);
	
	public int std_lec_count(Map<String,Object> paramMap);
	
	public int std_lec_reg(Map<String,Object> paramMap);
	
	public int std_lec_del(Map<String,Object> paramMap);
	

	
	/* 강사 */
	
	public List<RegisterInfoModel> tut_list(Map<String,Object> paramMap);
	
	public int countList_tut(Map<String,Object> paramMap);
	
	public int apv_tut(Map<String,Object> paramMap);
	
	public List<RegisterListControlModel> tlec_list(Map<String,Object> paramMap);
	
	public int tut_lec_count(Map<String,Object> paramMap);
	
	/*대표자 */
	 
	public int ceo_up(Map<String,Object> paramMap);
	
}
