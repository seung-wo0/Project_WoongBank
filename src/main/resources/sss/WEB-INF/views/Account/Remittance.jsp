<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>송금하기</title>
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
			<h1>송금하기</h1>
			<select id="Select_RiAccountID" name="Select_RiAccountID" >
				<option value="0">출금할 계좌를 선택하세요.</option>
				<c:forEach var="UserAccountList" items="${ UserAccountList }">
				<option value="${ UserAccountList.id }">${ UserAccountList.account_number } - (${ UserAccountList.account_name })</option>
				</c:forEach>
			</select>
			<br><br>
			
			이체할 계좌번호 : <input type="text" id="receive_account" name="receive_account" placeholder="이체할 계좌번호 입력" maxlength="13" disabled>
			
			<span id="Ri_accountChk"></span>
			<br><br>
			이체할 금액 : <input type="text" id="receive_amount" name="receive_amount" placeholder="이체할금액" disabled>
			<br><br>
			출금계좌 비밀번호 : <input type="password" id="UserAccountPW" name="UserAccountPW" maxlength="4" placeholder="출금계좌 비밀번호" disabled>
			<br><br>
			<button disabled>송금하기</button>
			<button type="reset">다시작성</button>
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