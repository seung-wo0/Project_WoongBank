<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	int UserIdSession = (int) session.getAttribute("UserIdSession");
	String UserPhoneSession = (String) session.getAttribute("UserPhoneSession");
	String UserNameSession = (String) session.getAttribute("UserNameSession");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>메인 페이지</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
<%
	if (UserPhoneSession == null || UserPhoneSession == "") {
%>
<script>
	alert("로그인은 필수 입니다.");
	window.location.href = "/";
</script>
<% } %>

	<div id="wrap">
	
		<header id="header">
			<!-- header부분 inc 시작 -->
			<%@ include file="inc/Header_inc.jsp" %>
			<!-- header부분 inc 끝 -->
		</header>
		<!-- header#header -->
		
		<div id="NavWrap" class="dFlex">
			<span><b>${ UserNameSession }</b> 님 환영합니다 ! </span>
			<button id="LogoutBtn" class="LogoutBtn" type="button">로그아웃</button>
			<!-- header부분 inc 시작 -->
			<%@ include file="inc/MenuNav_inc.jsp" %>
			<!-- header부분 inc 끝 -->
		</div>
		<!-- div#NavWrap -->
		
		<main id="main">
			
		</main>
		<!-- main#main -->
		
		<!-- footer부분 inc 시작 -->
		<%@ include file="inc/Footer_inc.jsp" %>
		<!-- footer부분 inc 끝 -->
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    