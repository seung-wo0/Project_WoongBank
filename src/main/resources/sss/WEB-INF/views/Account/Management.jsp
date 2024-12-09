<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>계좌관리 페이지</title>
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
			<h1>계좌 관리</h1>
				<div id="UserAccountArea">
					<div id="UserAccountAreaTitle">
						<span>${ UserNameSession } 님의 계좌 <b>${ UserAccountCnt }</b> 개</span>
					</div>
					<!-- div#UserAccountAreaTitle -->
					
				</div>
				<!-- div#UserAccountArea -->
				<c:choose>
					<c:when test="${ UserAccountCnt >= 3 }">
						<span style="color:red;">계좌가 이미 ${ UserAccountCnt } 개 를 보유중 이므로 계좌를 더 이상 만들 수 없습니다.</span>
						<br/>
					</c:when>
					<c:otherwise>
						<span style="color:blue;">계좌 ${ UserAccountCnt } 개 를 보유중 이므로 계좌 개설이 가능 합니다.</span>
						<br/>
						<button type="button" id="UserAccount_add">계좌 생성</button>
					</c:otherwise>
				</c:choose>
			
			<button type="button" id="UserAccount_del">계좌 삭제</button>
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