<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
	<ul id="Nav" class="dFlex">
		<li id="Management" onclick="QuickMenuEvent(this);">계좌관리</li>
			<!-- 계좌생성,삭제 넣을예정 -->
		<li id="Depo_With" onclick="QuickMenuEvent(this);">입·출금</li>
			<!-- 본인계좌를 선택 하여 입,출금 여부를선택후 해당하는작업 예정 -->
		<li id="Remittance" onclick="QuickMenuEvent(this);">송금</li>
			<!-- 송금할 계좌를 입력하면 존재하는계좌인지 여부체크 및 해당계좌의 소유주 성명이 표기되게 작업 예정 -->
		<li id="Tran_History" onclick="QuickMenuEvent(this);">거래내역</li>
<!-- 			선택한 계좌의 거래내역을 모두 불러오게 작업 예정. -->
		<li id="5" >5번메뉴</li>
	</ul>
</body>
