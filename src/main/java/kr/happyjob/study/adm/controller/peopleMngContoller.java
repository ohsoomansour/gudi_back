package kr.happyjob.study.adm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.adm.model.RegisterInfoModel;
import kr.happyjob.study.adm.model.RegisterListControlModel;
import kr.happyjob.study.adm.service.peopleMngService;
import kr.happyjob.study.login.service.LoginService;

@Controller
@RequestMapping("/adm/")
public class peopleMngContoller {

	@Autowired
	peopleMngService pmg_sv;
	
	@Autowired
	LoginService loginService;
	/**
	@Autowired
	RegisterService registerService; */
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	
    /**
     * @author: osm
     * @date: 2024.5.29
     * @param: -
     * @return: 전체 인원(관리자, 강사, 학생)   
     * @function: 인원 전체를 불러온다. 
     * @description: response 값을 반활 할 때반드시 @ResponseBody를 붙여줘야 함 
     *   - 그렇지 않으면(.jsp)html태그 로 인지 
     * */ 
	@RequestMapping("doGetAllPeopleList.do")
	@ResponseBody
	public Map<String, Object> dogetAllPeopleList() {
		
		List<RegisterInfoModel> AllUsers = pmg_sv.getAllUsersInfo();
		System.out.println(AllUsers);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("allUsers", AllUsers);
		return resultMap;
	}
	
   /**
     * @author: osm
     * @date: 2024.5.29
     * @param: paramMap, a(=관리자)또는 t(=강사) 또는 s(=학생)
     * @function: 관리자 또는 강사 또는 학생 개별적으로 조회    
     * @return: Map 데이터 타입에 조회된 인원들을 반환  
     * @description:                
     * */
	@RequestMapping("doGetUsersByUserType.do")
	@ResponseBody
	public Map<String, Object> doGetUsersByUsertype(@RequestParam Map<String, Object> paramMap)throws Exception {
		logger.info("ParamMap : " + paramMap);  //{user_type=a}
		List<RegisterInfoModel> members = pmg_sv.doGetUsersByUsertype(paramMap);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("members", members);
		return resultMap;
	}
	
   /** @author: osm 
     * @date: 2024. 5.30
     * @param: paramMap(= loginID, user_type, name, hp)
     * @function: 
     * @return: 검색된 사용자 또는 사용자들
     * @description:      
     * 
     *           
     * */
	@RequestMapping("doSearchForUser.do")
	@ResponseBody //@RequestParam Map<String, Object> paramMap)
	public Map<String, Object> doSearchUser(@RequestParam Map<String, Object> paramMap) throws Exception {
		logger.info("SearchUser:" + paramMap);
		List<RegisterInfoModel> users = pmg_sv.doSearchForUser(paramMap);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("users", users);
		return resultMap;
	}
	
   /**
	 *@author: osm
	 *@date: 2024. 6.4 
	 *@param: Map<String, Object> paraMap(= user_type, name, email, hp)
	 *@return: 
	 *@function: 회원 정보를 업데이트
	 * */
	@RequestMapping("doUpdateUserInfo.do")
	@ResponseBody
	public void doUpdateUserInfo(@RequestParam Map<String, Object> paramMap) throws Exception  {
		logger.info("doUpdateUserInfo" + paramMap);
		//회원 타입 권한 : 로그인 시 a 타입에서 권한 확인이 됨
		pmg_sv.doUpdateUserInfo(paramMap);
	}
	
	
	
	@RequestMapping("studentControl.do")
	public String tutor_lec_list(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		logger.info("   - paramMap : " + paramMap);
		List<RegisterListControlModel> list_lec = pmg_sv.lec_list(paramMap);
		model.addAttribute("list_lec", list_lec);
		
		return "adm/people_mng/stdMng/stdMng";
	}

	

	
	
	
}