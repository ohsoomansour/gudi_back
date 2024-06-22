# 프로젝트 소개
- 유형: lms 
- 설명: 관리자가 회원 아이디를 부여하고 대부분의 권한을 관리  

### ⏲️프로젝트 개발 기간
2024년 5월 21 ~ 6.21 
### ⚙️개발 환경
 + **BackEnd**: java
 + **FrontEnd**:Vue.js, Node.js
 + **Framework**: eclipse
 + **Database**: MySQL

# 📌주요 기능 담당

## 회원가입 및 로그인 기능 
### 디렉토리 경로: 
+ kr.happyjob.study.login.controller - LoginController.java 
+ kr.happyjob.study.login.dao - LoginDao.java
+ kr.happyjob.study.login.model - LgInfoModel.java, UsrMnuAtrtModel.java, UsrMnuChildAtrtModel.java
+ kr.happyjob.study.login.service - LoginService.java, LoginServiceImpl.java
+ 매퍼 경로: src/main/resources/login/LoginMapper.xml
	
## 로그인
+ 디렉토리 경로: src/views/Login.vue

## 인원관리 및 사용자 정보 수정
### 디렉토리 경로: 
+ kr.happyjob.study.adm.controller - peopleMngController.java 파일 
+ kr.happyjob.study.adm.dao - peopleMngDao.java 파일 
+ kr.happyjob.study.adm.model - RegisterInfoModel.java                           
+ kr.happyjob.study.adm.service - peopleMgService.java, poepleMngServiceImple.java
+ 매퍼 경로: rc/main/resources/people/PeoplemngMapper.xml

