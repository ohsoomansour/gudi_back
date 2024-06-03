package kr.happyjob.study.adm.model;

import java.util.Date;

public class RegisterListControlModel {
		
		//tb_lec_info(강의 정보 테이블)
		private int lec_id; //강의 ID
		private String tutor_id; //강사 ID
		private String lecrm_id; //강의실 ID
		private String lec_name; //강의명
		private String lecrm_name; //강의실명
		private int max_pnum; //최대 인원
		private int pre_pnum; //수강 인원
		private String c_st; // 개강일
		private String c_end; //종강일
		private String startdate; // 개강일 뷰단 사용
		private String enddate; //종강일 뷰단 사용
		private int process_day; // 과정일수
		private int pre_day; //현재 과정일수
		private String lec_goal; // 수업목표
		private String atd_plan; //출석 계획
		private String lec_sort; //강의 분류
		
		
		//tb_userinfo(회원테이블)
		private String name;// 이름 
		private String loginID;
		



		
		public String getLoginID() {
			return loginID;
		}
		public void setLoginID(String loginID) {
			this.loginID = loginID;
		}
		public String getStartdate() {
			return startdate;
		}
		public void setStartdate(String startdate) {
			this.startdate = startdate;
		}
		public String getEnddate() {
			return enddate;
		}
		public void setEnddate(String enddate) {
			this.enddate = enddate;
		}
		
		public String getLecrm_name() {
			return lecrm_name;
		}
		public void setLecrm_name(String lecrm_name) {
			this.lecrm_name = lecrm_name;
		}
		
		public int getLec_id() {
			return lec_id;
		}
		public void setLec_id(int lec_id) {
			this.lec_id = lec_id;
		}
		public String getTutor_id() {
			return tutor_id;
		}
		public void setTutor_id(String tutor_id) {
			this.tutor_id = tutor_id;
		}
		public String getLecrm_id() {
			return lecrm_id;
		}
		public void setLecrm_id(String lecrm_id) {
			this.lecrm_id = lecrm_id;
		}
		public String getLec_name() {
			return lec_name;
		}
		public void setLec_name(String lec_name) {
			this.lec_name = lec_name;
		}
		public int getMax_pnum() {
			return max_pnum;
		}
		public void setMax_pnum(int max_num) {
			this.max_pnum = max_num;
		}
		public int getPre_pnum() {
			return pre_pnum;
		}
		public void setPre_pnum(int pre_pnum) {
			this.pre_pnum = pre_pnum;
		}
		public String getC_st() {
			return c_st;
		}
		public void setC_st(String c_st) {
			this.c_st = c_st;
		}
		public String getC_end() {
			return c_end;
		}
		public void setC_end(String c_end) {
			this.c_end = c_end;
		}
		public int getProcess_day() {
			return process_day;
		}
		public void setProcess_day(int process_day) {
			this.process_day = process_day;
		}
		public int getPre_day() {
			return pre_day;
		}
		public void setPre_day(int pre_day) {
			this.pre_day = pre_day;
		}
		public String getLec_goal() {
			return lec_goal;
		}
		public void setLec_goal(String lec_goal) {
			this.lec_goal = lec_goal;
		}
		public String getAtd_plan() {
			return atd_plan;
		}
		public void setAtd_plan(String atd_plan) {
			this.atd_plan = atd_plan;
		}
		public String getLec_sort() {
			return lec_sort;
		}
		public void setLec_sort(String lec_sort) {
			this.lec_sort = lec_sort;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		


	

	
}
