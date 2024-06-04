package kr.happyjob.study.adm.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.adm.dao.peopleMngDao;
import kr.happyjob.study.adm.model.RegisterInfoModel;
import kr.happyjob.study.adm.model.RegisterListControlModel;

@Service
public class peopleMngServiceImpl implements peopleMngService{
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	peopleMngDao pmg_dao;
	
	//회원 전체
	@Override
	public List<RegisterInfoModel> getAllUsersInfo(){
		return pmg_dao.getAllUsersInfo();
	}
	//회원 유형별 
	@Override
	public List<RegisterInfoModel> doGetUsersByUsertype(Map<String, Object> paramMap){
		return pmg_dao.doGetUsersByUsertype(paramMap);
	}
	//회원 검색 
	@Override
	public List<RegisterInfoModel> doSearchForUser(Map<String, Object> paramMap){
		return pmg_dao.doSearchForUser(paramMap);
	}
	//회원 업데이트
	@Override
	public void doUpdateUserInfo(Map<String, Object> paramMap){
		pmg_dao.doUpdateUserInfo(paramMap);
	}
	
	@Override
	public int ban_user(Map<String, Object> paramMap) {
		return pmg_dao.ban_user(paramMap);
	}

	@Override
	public int register(Map<String, Object> paramMap) {
		return pmg_dao.register(paramMap);
	}

	@Override
	public RegisterInfoModel user_info(Map<String, Object> paramMap) {
		return pmg_dao.user_info(paramMap);
	}

	@Override
	public List<RegisterListControlModel> lec_list(Map<String, Object> paramMap) {
		return pmg_dao.lec_list(paramMap);
	}

	@Override
	public List<RegisterInfoModel> std_list(Map<String, Object> paramMap) {
		return pmg_dao.std_list(paramMap);
	}

	@Override
	public List<Integer> countList_std(Map<String, Object> paramMap) {
		return pmg_dao.countList_std(paramMap);
	}

	@Override
	public List<RegisterListControlModel> std_lec_info(Map<String, Object> paramMap) {
		return pmg_dao.std_lec_info(paramMap);
	}

	@Override
	public List<RegisterInfoModel> tut_list(Map<String, Object> paramMap) {
		return pmg_dao.tut_list(paramMap);
	}

	@Override
	public int apv_tut(Map<String, Object> paramMap) {
		return pmg_dao.apv_tut(paramMap);
	}

	@Override
	public List<RegisterListControlModel> tlec_list(Map<String, Object> paramMap) {
		return pmg_dao.tlec_list(paramMap);
	}

	@Override
	public int countList_lec(Map<String, Object> paramMap) {
		return pmg_dao.countList_lec(paramMap);
	}

	@Override
	public int std_lec_count(Map<String, Object> paramMap) {
		return pmg_dao.std_lec_count(paramMap);
	}

	@Override
	public int countList_tut(Map<String, Object> paramMap) {
		return pmg_dao.countList_tut(paramMap);
	}

	@Override
	public int tut_lec_count(Map<String, Object> paramMap) {
		return pmg_dao.tut_lec_count(paramMap);
	}

	@Override
	public int ceo_up(Map<String, Object> paramMap) {
		return pmg_dao.ceo_up(paramMap);
	}

	@Override
	public int std_lec_reg(Map<String, Object> paramMap) {
		pmg_dao.plusPrePnum(paramMap);
		return pmg_dao.std_lec_reg(paramMap);
	}

	@Override
	public int std_lec_del(Map<String, Object> paramMap) {
		pmg_dao.minusPrePnum(paramMap);
		return pmg_dao.std_lec_del(paramMap);
	}


	



}
