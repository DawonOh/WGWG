# Goodie Groupware project
구디 그룹웨어 프로젝트입니다.

## 프로젝트 소개
### 주제
- 그룹웨어 시스템 개발

### 프로젝트 기간
- 2021.12.06 ~ 2021.12.26 (160H)

### 담당 기능
- 회원관리
  - 로그인
  - 사원등록
  - 개인정보 수정
- 부서관리
  - 부서 등록
  - 부서 수정

## 개발환경 및 라이브러리
![개발환경 소개](https://user-images.githubusercontent.com/89020079/211256203-b3f77ec6-d11b-42f4-8f13-a11e579ecabe.png)

## 기능소개
### 회원관리 - 로그인
![로그인 과정](https://user-images.githubusercontent.com/89020079/211256508-c19450d3-f5c0-4cc0-9f7a-1e3ba9246d86.png)
- 사용 API : javax-mail

### 회원관리 - 사원등록
![사원등록 과정](https://user-images.githubusercontent.com/89020079/211257582-5b743b41-64d6-415e-8303-e22962360a02.png)
- 프로필 사진, 부서, 이름, 생년월일, 입사 년도, 주소, 직급, 전화번호, 근무 상태, 이메일을 입력받습니다.
- 사원번호와 비밀번호는 자동부여됩니다.
- 사용 API : spring-cron, JavaScript 정규표현식
  - 사원번호는 현재 연도(4자리) + 현재 월(2자리) + Sequence(2자리, 입사순)로 이루어져 있습니다. spring-cron을 사용하여 매월 1일에 Sequence를 초기화합니다.
  - 정규표현식으로 프로필사진의 확장자를 검사합니다. (jap, png만 가능)

### 부서관리 - 부서 조회 및 등록
![부서조회](https://user-images.githubusercontent.com/89020079/211258308-de71fe9b-b06e-47d7-ad24-a3bd4f5185d4.png)

### 부서관리 - 부서 수정
![부서 수정](https://user-images.githubusercontent.com/89020079/211258368-f1a76bbe-ef80-4ea5-9029-f5cd19a49980.png)
- 부서 명 수정 시 해당 부서 소속 직원들의 부서명도 동시에 바뀌게 됩니다.
