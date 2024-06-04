package kr.happyjob.study.adm.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.adm.model.RegisterInfoModel;
import kr.happyjob.study.adm.model.RegisterListControlModel;

public interface peopleMngDao {
	//회원 전체 조회
	public List<RegisterInfoModel> getAllUsersInfo(); 
	//회원 타입에 따라 회원 얻기 : 
	public List<RegisterInfoModel> doGetUsersByUsertype(Map<String, Object> paramMap);
	//회원 검색: osm 24.5.30 
	public List<RegisterInfoModel> doSearchForUser(Map<String, Object> paramMap);
	//회원 정보 업데이트 : osm 24.6.4
	public void doUpdateUserInfo(Map<String, Object> paramMap);
	
	
	
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
	
	public void plusPrePnum(Map<String,Object> paramMap);
	
	public void minusPrePnum(Map<String,Object> paramMap);

	
	/* 강사 */
	
	public List<RegisterInfoModel> tut_list(Map<String,Object> paramMap);
	
	public int countList_tut(Map<String,Object> paramMap);

	public int apv_tut(Map<String,Object> paramMap);
	
	public List<RegisterListControlModel> tlec_list(Map<String,Object> paramMap);
	
	public int tut_lec_count(Map<String,Object> paramMap);
	
	
	/* 대표자 */
	
	public int ceo_up(Map<String,Object> paramMap);
}
