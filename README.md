> # Project_WoongBank
>
> 소개 : 뱅킹 시스템, 계좌관리 입·출금/송금 등 거래내역관리가 가능한 간단한 뱅킹시스템
>
> 사용기술 : Java, SpringBoot, Mybatis, MySQL, JavaScript, jQurey
>
> 인원 : 1 명
>
> 개발 기간 : [2024.12.05] ~ 진행중

---

> # [구현 예정 기능]
>
> - **로그인**
>   - [x] 이름,핸드폰번호 로 회원가입 후
>   - [x] 여기서 핸드폰번호 로 로그인을 할 수 있게함
> - **계좌생성, 계좌조회**
>   - [x] 계좌생성 은 개인당 3개까지 계좌를 생성할 수 있다.
>     - [x] 계좌생성시 계좌비밀번호 4자리도 등록 해야함
>   - [x] 본인이 가진 계좌를 모두 조회 할 수 있다.
>   - [x] 로그인이 되어있다면 된다면 계좌를 생성할 수 있음 계좌는 13자리로 해야함
>   - [x] 모든 계좌 리스트에서 현재잔액도 볼 수 있게 추가작업 예정
> - **입·출금, 송금 및 거래내역 조회**
>   - [x] 입·출금 은 본인계좌로만 가능하게
>   - [x] 입·출금 페이지내에서 select로 계좌를 선택, 이후 ajax(비동기) 로 해당계좌 맞는 데이터(현재잔액) 을 불러오게 처리
>   - [x] 입·출금 중 계좌를 선택 하면 역시 ajax 로 선택한 계좌에대한 잔액을 불러와 입금 또는 출금 하려는금액을 입력하면 예상 계좌잔액 으로 표기
>   - [ ] 송금이 된다면 계좌번호가 존재하는지의 여부를 확인체크 후 존재하다면 송금이 가능하게 한다.

---

> # DB 설계도
>
> <img src="[https://github.com/user-attachments/assets/af6759af-5fb6-44f5-9882-c1a44452e48b](https://github.com/user-attachments/assets/d6acdc1c-b87f-4776-af6e-f8703c73dd91)" width="100%" title="DB 설계도" />

---

> # 2024.12.16
>
> - "입·출금" 부분 데이터받아 처리하는작업 완료
>   - "입·출금" 부분 데이터받아 처리하는과정에 패스워드 일치여부 체크후 일치하다면 입출금처리 후 거래내역에도 추가작업
> - "거래내역" 부분 계좌선택에 따른 거래내역 불러오기 AJAX 로 처리작업

---

> # 2024.12.14
>
> - "입·출금" 부분 계좌를 선택 후 입금,출금 을선택하면 ajax 로 해당계좌의 현재잔액 데이터 를 불러오게 작업
> - "입·출금" 부분 입금,출금 에따라서 거래후 잔액이 +인지 - 인지 구분 후 표기
> - "입·출금" 부분 해당 모든 부분이 완료가 되면 입·출금 데이터들을 처리해주는 메서드 구현 데이터받는것 까지는 완료, 현재 완전한작업은 미완성

---

> # 2024.12.13
>
> - "계좌관리" 에 "계좌삭제" 버튼 클릭시 새창이띄워지며 삭제할 계좌를 선택 후 삭제버튼을누르면 해당 삭제처리 메서드 작업
> - "계좌관리" 에 삭제 를한다면 만든기록은 있으나, 회원에게는 보유중인계좌에서 확인이 불가. 관리할수있는 DB 상으로 기록.
> - "계좌관리" 계좌생성 부분 비밀번호등록을추가작업 완료

---

> # 2024.12.11
>
> - "계좌관리" 에 "계좌생성" 버튼 클릭시 새 인터넷창이 띄워지며 생성여부 "확인,취소" 창까지 작업
>   - "확인" 누를시 계좌 총 13자리중 앞4자리는 고정 "7777", 그리고 중간 3자리, 맨뒤6자리는 모두 랜덤으로 지정, 해당계좌가 db테이블에 존재여부 체크
>     체크 후 중복되는게없다면 생성후 부모창 새로고침으로 계좌 1개가 늘어난다.(최대 3개)
> - "계좌관리" 에 계좌가 존재하다면 본인의 리스트출력
>   - 계좌를 클릭하면 계좌별칭을 바꿀수있게 변경 처리작업 끝

---

> # 2024.12.09
>
> - 해당 아이디가 존재하는지의 여부를 판단 하여 로그인시킴
>   - 현재는 로그인이된다면 메인페이지로 아니라면 로그인페이지에서 머물도록 구현
> - nav 기본 틀 구현
>   - "계좌관리" 부분 해당유저 session 값으로 보유한 계좌의 갯수를 파악, 3개라면 계좌생성 버튼이 사라지는 시스템
>   - 현재 기능은 미구현

---

> # 2024.12.07
>
> - 회원가입부분 javascript 등 일부 완료
>   - 이름 ,핸드폰번호, 패스워드 일치여부 , 공백 및 유효성검사
>   - controller 에 전달까지 완료

---

> # 2024.12.06
>
> - 로그인 처리부분 일부 완료

---

> # 2024.12.05
>
> - 기본적인 셋팅
>   - application.properties, bulid.gradle 수정
>   - Controller, Dao, Dto,, Service
>   - Mybatis Mapper
>   - Script, Style(css)
>   - JSP 부분 Header,Footer include 파일 생성
