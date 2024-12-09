# Project_WoongBank

소개 : 뱅킹 시스템, 계좌관리 입·출금/송금 등 거래내역관리가 가능한 간단한 뱅킹시스템

사용기술 : Java, SpringBoot, Mybatis, MySQL, JavaScript, jQurey

인원 : 1 명

개발 기간 : [2024.12.05] ~ 진행중

# [구현 예정 기능]

- 로그인
  - 이름,핸드폰번호 로 회원가입 후
  - 여기서 핸드폰번호 로 로그인을 할 수 있게함, 핸드폰번호
- 계좌생성, 계좌조회
  - 계좌생성 은 개인당 3개까지 계좌를 생성할 수 있다. 계좌생성시 계좌비밀번호 4자리도 등록 해야함
  - 본인이 가진 계좌를 모두 조회 할 수 있다.
  - 로그인이 되어있다면 된다면 계좌를 생성할 수 있음 계좌는 13자리로 해야함
- 입·출금, 송금 및 거래내역 조회
  - 입·출금 은 본인계좌로만 가능 , 송금이 된다면 계좌번호가 존재하는지의 여부를 확인체크 후 존재하다면 송금이 가능하게 한다.

---

# 추후 Readme.md 수정

---

# DB 설계도

## <img src="https://github.com/user-attachments/assets/028db3a4-7e8a-4c1e-b2f4-5a8c7fcd6b09" width="100%" title="DB 설계도" />

---

# 2024.12.07

- 회원가입부분 javascript 등 일부 완료
  - 이름 ,핸드폰번호, 패스워드 일치여부 , 공백 및 유효성검사
  - controller 에 전달까지 완료

---

# 2024.12.06

- 로그인 처리부분 일부 완료

---

# 2024.12.05

- 기본적인 셋팅
  - application.properties, bulid.gradle 수정
  - Controller, Dao, Dto,, Service
  - Mybatis Mapper
  - Script, Style(css)
  - JSP 부분 Header,Footer include 파일 생성
