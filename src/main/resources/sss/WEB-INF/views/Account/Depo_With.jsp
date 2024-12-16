<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>입·출금 페이지</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap">
		<header id="header">
			<!-- header부분 inc 시작 -->
			<%@ include file="../inc/Header_inc.jsp" %>
			<!-- header부분 inc 끝 -->
		</header>
		<!-- header#header -->
		
		<div id="NavWrap" class="dFlex">
			<span><b>${ UserNameSession }</b> 님 환영합니다 ! </span>
			<button id="LogoutBtn" class="LogoutBtn" type="button">로그아웃</button>
			<!-- header부분 inc 시작 -->
			<%@ include file="../inc/MenuNav_inc.jsp" %>
			<!-- header부분 inc 끝 -->
		</div>
		<!-- div#NavWrap -->
		
		<main id="main">
			<h1>입·출금</h1>
			
			<select id="DW_SelectAccount" name="DW_SelectAccount"  form="DW_SelectAccountFrm">
				<option value="0">거래할 계좌를 선택하세요.</option>
				<c:forEach var="UserAccountList" items="${ UserAccountList }">
				<option value="${ UserAccountList.account_number }">${ UserAccountList.account_number } - (${ UserAccountList.account_name })</option>
				</c:forEach>
			</select>
			<br><br>
			<input type="radio" id="Depo" class="Depo_WithBox" name="Depo_WithBox" > 입금
			<input type="radio" id="With" class="Depo_WithBox" name="Depo_WithBox" > 출금
			<input type="hidden" id="Depo_WithChk" name="Depo_WithChk" form="DW_SelectAccountFrm">
			<br><br>
			현재 잔액 <input type="text" id="Now_account_balance" name="Now_account_balance" value="" form="DW_SelectAccountFrm" readonly>
			<br><br>
			거래 금액 <input type="text"  id="input_balance" name="input_balance" value="" form="DW_SelectAccountFrm">
			<br><br>
			거래 후 잔액 <input type="text"  id="maybe_AccountBalance" name="maybe_AccountBalance" value="" form="DW_SelectAccountFrm" readonly>
<!-- 			 <span id="maybe_AccountBalance"></span> -->
			<br><br>
			계좌 비밀번호 <input type="password" id="input_Account_Password" name="input_Account_Password" form="DW_SelectAccountFrm" maxlength="4" min="4">
			<br><br>
			<button type="button" id="Depo_WithBtn" class="Depo_WithBtn" form="DW_SelectAccountFrm">완료</button>
			<form action="" id="DW_SelectAccountFrm"></form>
			
			
			<div id="Depo_With_infoArea">
			
			</div>
			
		</main>
		<!-- main#main -->
		
		<!-- footer부분 inc 시작 -->
		<%@ include file="../inc/Footer_inc.jsp" %>
		<!-- footer부분 inc 끝 -->
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    