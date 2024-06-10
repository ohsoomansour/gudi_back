package kr.happyjob.study.login.controller;

import java.util.Collections;
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
import org.springframework.web.servlet.ModelAndView;

import kr.happyjob.study.common.comnUtils.ComnCodUtil;
import kr.happyjob.study.login.model.LgnInfoModel;
import kr.happyjob.study.login.model.UsrMnuAtrtModel;
import kr.happyjob.study.login.service.LoginService;

import kr.happyjob.study.system.model.ComnCodUtilModel;


@Controller
public class LoginController {
   // 커밋 테스트 됌 -동철
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   @Autowired
   LoginService loginService;
   
   /**
* index 접속 시 로그인 페이지로 이동한다.
* 
* @param   Model result - Spring model object
* @param   Map paramMap - Request Param object
* @param   HttpServletRequest request - Servlet request object
* @param   HttpServletResponse response - Servlet response object
* @param   HttpSession session - Http session Object
* @return   String - page navigator
* @throws Exception
*/

   @RequestMapping("login.do")
   public String index(Model result, @RequestParam Map<String, String> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {

  logger.info("+ Start LoginController.login.do");
  List<ComnCodUtilModel> listOfcDvsCod = ComnCodUtil.getComnCod("OFC_DVS_COD","M");   // 오피스 구분 코드 (M제외)
  Collections.reverse(listOfcDvsCod); // 오피스 구분 역순으로

/*  List<LgnInfoModel> cdList = loginService.selectBankList();	//select박스 은행 목록
  request.setAttribute("cdListobj", cdList);					//select박스 은행 목록
*/  result.addAttribute("listOfcDvsCod", listOfcDvsCod);   // 오피스 구분 코드
  //result.addAttribute("listCtrCod", listCtrCod);            // 국가 코드
  //result.addAttribute("listPnnCtr", listPnnCtr);            // 전화번호 국가
      logger.info("+ End LoginController.login.do");

  return "/login/login";
   }

   /**
* 사용자 로그인을 처리한다. 
* @Author  osm 24.6.3 수정
* @param   Model result - Spring model object
* @param   Map paramMap - Request Param object
* @param   HttpServletRequest request - Servlet request object
* @param   HttpServletResponse response - Servlet response object
* @param   HttpSession session - Http session Object
* @return   String - page navigator
* @throws Exception
* @function: 사용자가 로그인을 한다. 
*/
   @RequestMapping("loginProc.do")
   @ResponseBody
   public Map<String, Object> loginProc(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {

      logger.info("+ Start LoginController.loginProc.do");
	  logger.info("   - ParamMap : " + paramMap);
	    
	  // 사용자 로그인
	  LgnInfoModel lgnInfoModel = loginService.loginProc(paramMap);
	  
	  String result;
	  String resultMsg;
	  Map<String, Object> resultMap = new HashMap<String, Object>();
	  
	  if (lgnInfoModel != null) {
	     result = "SUCCESS";
	     resultMsg = "사용자 로그인 정보가 일치 합니다.";

	     // 사용자 메뉴 권한 조회: doSelectLogin 에서 가져오면 된다. (24.5.30)   
	     System.out.println("user_type:" + lgnInfoModel.getUser_type());
	     paramMap.put("user_type", lgnInfoModel.getUser_type());
	     // 메뉴 목록 조회 0depth:  dao - listUsrMnuAtrt  
	     List<UsrMnuAtrtModel> listUsrMnuAtrtModel = loginService.listUsrMnuAtrt(paramMap);
	     // 메뉴 목록 조회 1depth
	     for(UsrMnuAtrtModel list : listUsrMnuAtrtModel){
	        Map<String, Object> resultMapSub = new HashMap<String, Object>();
	        resultMapSub.put("loginID", paramMap.get("loginID")); 
	        resultMapSub.put("hir_mnu_id", list.getMnu_id()); // 0 depth
	        resultMapSub.put("user_type",lgnInfoModel.getUser_type());
	        
	        list.setNodeList(loginService.listUsrChildMnuAtrt(resultMapSub));
	     }
	     
	     //세션 설정
	     session.setAttribute("loginId", lgnInfoModel.getLoginID());                     //   로그인 ID
	     session.setAttribute("name", lgnInfoModel.getName());                  // 사용자 성명
	     session.setAttribute("user_type", lgnInfoModel.getUser_type());            // 로그린 사용자 권란       A: 관리자       B: 기업회원    C:일반회원
	     session.setAttribute("usrMnuAtrt", listUsrMnuAtrtModel);
	     //session.setAttribute("serverName", request.getServerName());
	
	     resultMap.put("loginId",lgnInfoModel.getLoginID()); 
	     resultMap.put("name",lgnInfoModel.getName()); 
	     resultMap.put("user_type", lgnInfoModel.getUser_type());
	     //SELECT * FROM tm_mnu_mst;
	     resultMap.put("usrMnuAtrt", listUsrMnuAtrtModel);
	     //resultMap.put("serverName", request.getServerName());
	 
	} else {
         result = "FALSE";
         resultMsg = "사용자 로그인 정보가 일치하지 않습니다.";
    }
   
    resultMap.put("result", result);
    resultMap.put("resultMsg", resultMsg);
    resultMap.put("serverName", request.getServerName());
  
    logger.info("+ End LoginController.loginProc.do");

      return resultMap;
   }
   
	 /**
	* 로그아웃
	* @author: osm 
	* @param request
	* @param response
	* @param session
	* @return
	*/
   @RequestMapping(value = "/loginOut.do")
   public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
                  
      ModelAndView mav = new ModelAndView();
      session.invalidate();
      mav.setViewName("redirect:/login.do");
      	
      return mav;
   }
   
  /** @author: osm 
    * @date: 2024. 5.30
    * @param: paramMap,  
    * @function: 회원가입 
    * @return: result("SUCCESS" 또는 "FAIL"), resultMsg = ("가입 요청 완료" 또는  "가입 요청 실패")
    * @description:                
    * */
   @RequestMapping("register.do")
   @ResponseBody   //@RequestParam Map<String, Object> paramMap
   public Map<String, Object> registerUser(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception{

	   logger.info("+ Start " + className + ".registerUser");
	   logger.info("   - paramMap : " + paramMap);
	   String action = (String)paramMap.get("action");
	   String result = "SUCCESS";
	   String resultMsg;
	   
	   if("I".equals(action)) {
		   
		   loginService.registerUser(paramMap);
		   resultMsg = "가입 요청 완료";
	   } else {
		   
		   result = "FAIL";
		   resultMsg = "가입 요청 실패";
	   }


	   Map<String, Object> resultMap = new HashMap<String, Object>();
	   resultMap.put("result", result);
	   resultMap.put("resultMsg", resultMsg);
	   
	   logger.info("+ End " + className + ".registerUser");
	   
	   return resultMap;
   }
   
   /** @author: osm 
    * @date: 2024. 5.30
    * @param: paramMap,
    * @function: loginID 중복체크
    * @return: 
    * @description:                
    * */
   /*loginID 중복체크 - 5.31 확인 중*/
   @RequestMapping(value="doCheckDuplicLoginID.do")
   @ResponseBody
   public int doCheckDuplicLoginID(@RequestParam Map<String, Object> paramMap) throws Exception{
	   logger.info("+ Start " + className + ".doCheckDuplicLoginID");
	   System.out.println("doCheckDuplicLoginID.do:"+paramMap);
	   int result = loginService.doCheckDuplicLoginID(paramMap);
	   logger.info("+ End " + className + ".doCheckDuplicLoginID");
	   return result;
   }
   

   /*사용자 id 찾기*/
   @RequestMapping("selectFindInfoId.do")
   @ResponseBody
   public Map<String, Object> selectFindInfoId(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".selectFindInfoId");
  
  logger.info("   - paramMap : " + paramMap);

  String result;
  String resultMsg;
  LgnInfoModel resultModel= loginService.selectFindId(paramMap);
  

  if (resultModel != null) {  
  result = "SUCCESS";
  resultMsg = "조회 성공";

  	
  }else {
      result = "FALSE";
      resultMsg = "조회 실패";
   }
  

  Map<String, Object> resultMap = new HashMap<String, Object>();

  resultMap.put("result", result);
  resultMap.put("resultMsg", resultMsg);
  resultMap.put("resultModel", resultModel);
  
  System.out.println(result);
  System.out.println(resultMsg);
  System.out.println(resultModel);
  System.out.println(resultMap);
  
  logger.info("+ End " + className + ".selectFindInfoId");
      
      return resultMap;
     
   }
   
   //사용자 pw 조회
   @RequestMapping("selectFindInfoPw.do")
   @ResponseBody
   public Map<String, Object> selectFindInfoPw(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".selectFindInfoPw");
  
      logger.info("   - paramMap : " + paramMap);

  String result;
  String resultMsg;
  LgnInfoModel resultModelPw= loginService.selectFindPw(paramMap);
  
  if (resultModelPw != null) {  
  result = "SUCCESS";
  resultMsg = "조회 성공";

  }else {
      result = "FALSE";
      resultMsg = "조회 실패";
   }

  Map<String, Object> resultMap = new HashMap<String, Object>();

  resultMap.put("result", result);
  resultMap.put("resultMsg", resultMsg);
  resultMap.put("resultModel", resultModelPw);

  
  logger.info("+ End " + className + ".selectFindInfoPw");
      
     return resultMap;
     
   }
   

}