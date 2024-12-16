<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>거래내역 페이지</title>
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
			<h1>거래내역</h1>
			<select id="SelectAccountID" name="SelectAccountID" >
				<option value="0">거래할 계좌를 선택하세요.</option>
				<c:forEach var="UserAccountList" items="${ UserAccountList }">
				<option value="${ UserAccountList.id }">${ UserAccountList.account_number } - (${ UserAccountList.account_name })</option>
				</c:forEach>
			</select>
			<br><br>
			<div id="AccountTransactionListArea">
				
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